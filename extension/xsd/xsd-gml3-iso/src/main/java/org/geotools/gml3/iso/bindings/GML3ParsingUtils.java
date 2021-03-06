/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.gml3.iso.bindings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xsd.XSDElementDeclaration;
import org.geotools.geometry.GeometryBuilder;
import org.geotools.geometry.jts.CircularArc;
import org.geotools.geometry.jts.CurvedGeometries;
import org.geotools.geometry.jts.CurvedGeometryFactory;
import org.geotools.gml2.iso.FeatureTypeCache;
import org.geotools.gml2.iso.bindings.GML2ParsingUtils;
import org.geotools.gml3.iso.ArcParameters;
import org.geotools.gml3.iso.Circle;
import org.geotools.xml.BindingWalkerFactory;
import org.geotools.xml.ElementInstance;
import org.geotools.xml.Node;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.ISOGeometryBuilder;
import org.opengis.geometry.coordinate.PointArray;
import org.opengis.geometry.primitive.Curve;
import org.opengis.geometry.primitive.OrientableCurve;
import org.opengis.geometry.primitive.Point;
import org.opengis.geometry.primitive.Ring;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * Utility class for gml3 parsing.
 * 
 * @author Justin Deoliveira, The Open Planning Project, jdeolive@openplans.org
 * 
 * 
 * 
 * 
 * @source $URL$
 */
public class GML3ParsingUtils {
    /**
     * Utility method to implement Binding.parse for a binding which parses into A feature.
     * 
     * @param instance The instance being parsed.
     * @param node The parse tree.
     * @param value The value from the last binding in the chain.
     * @param ftCache The feature type cache.
     * @param bwFactory Binding walker factory.
     * 
     * @return A feature.
     */
    public static SimpleFeature parseFeature(ElementInstance instance, Node node, Object value,
            FeatureTypeCache ftCache, BindingWalkerFactory bwFactory) throws Exception {
        return GML2ParsingUtils.parseFeature(instance, node, value, ftCache, bwFactory);
    }

    /**
     * Turns a xml type definition into a geotools feature type.
     * 
     * @param type The xml schema tupe.
     * 
     * @return The corresponding geotools feature type.
     */
    public static SimpleFeatureType featureType(XSDElementDeclaration element,
            BindingWalkerFactory bwFactory) throws Exception {
        return GML2ParsingUtils.featureType(element, bwFactory);
    }

    /**
     * Turns a parse node + feature type + fid info a feature.
     */
    static SimpleFeature feature(SimpleFeatureType fType, String fid, Node node) throws Exception {
        return GML2ParsingUtils.feature(fType, fid, node);
    }

    static CoordinateReferenceSystem crs(Node node) {
        return GML2ParsingUtils.crs(node);
    }

    /**
     * Returns the number of dimensions for the specified node, eventually recursing up to find the
     * parent node that has the indication of the dimensions (normally the top-most geometry element
     * has it, not the posList). Returns 2 if no srsDimension attribute could be found.
     * 
     * @param node
     * @return
     */
    public static int dimensions(Node node) {
        Node current = node;
        while (current != null) {
            Node dimensions = current.getAttribute("srsDimension");
            if (dimensions != null) {
                return ((Number) dimensions.getValue()).intValue();
            }
            current = current.getParent();
        }

        return 2;
    }
    
    public static String id(Node node) {
        Object id = getAttributeValue(node, "id");
        if (id != null) {
            return (String) id;
        }
        
        return null;
    }
    
    public static String name(Node node) {
        Object name = getAttributeValue(node, "name");
        if (name != null) {
            return (String) name;
        }
        
        return null;
    }
    
    public static String description(Node node) {
        Object description = getAttributeValue(node, "description");
        if (description != null) {
            return (String) description;
        }
        
        return null;
    }
    
    public static Object getAttributeValue(Node node, String name) {
        Node attribute = node.getAttribute(name);
        if (attribute != null) {
            return attribute.getValue();
        }
        
        return null;
    }
    
    public static void setCRS(Object g, CoordinateReferenceSystem crs) {
        if (g instanceof com.vividsolutions.jts.geom.Geometry) {
            com.vividsolutions.jts.geom.Geometry geometry = (com.vividsolutions.jts.geom.Geometry) g;
            
            if (geometry.getUserData() == null) {
                geometry.setUserData(new HashMap<Object, Object>());
            }
            if (geometry.getUserData() instanceof Map) {
                ((Map) geometry.getUserData()).put(CoordinateReferenceSystem.class, crs);
            }
        }
    }
    
    public static void setID(Object g, String id) {
        setMetaData(g, "gml:id", id);
    }
    
    public static void setName(Object g, String name) {
        setMetaData(g, "gml:name", name);
    }
    
    public static void setDescription(Object g, String description) {
        setMetaData(g, "gml:description", description);
    }
    
    public static void setMetaData(Object g, String metadata, String value) {
        if (g instanceof com.vividsolutions.jts.geom.Geometry) {
            com.vividsolutions.jts.geom.Geometry geometry = (com.vividsolutions.jts.geom.Geometry) g;
            if (geometry.getUserData() == null) {
                geometry.setUserData(new HashMap<Object, Object>());
            }
            if (geometry.getUserData() instanceof Map) {
                ((Map) geometry.getUserData()).put(metadata, value);
            }
        } else if (g instanceof org.geotools.geometry.iso.root.GeometryImpl) {
            org.geotools.geometry.iso.root.GeometryImpl geometry = (org.geotools.geometry.iso.root.GeometryImpl) g;
            if (geometry.getUserData() == null) {
                geometry.setUserData(new HashMap<Object, Object>());
            }
            if (geometry.getUserData() instanceof Map) {
                ((Map) geometry.getUserData()).put(metadata, value);
            }
        }
    }

    static Curve lineString(Node node, ISOGeometryBuilder gb) {
        return line(node, gb, false);
    }

    static Ring linearRing(Node node, ISOGeometryBuilder gb) {
    	Curve curve = line(node, gb, true);
        return gb.createRing(Arrays.asList(curve));
    }

    static Curve line(Node node, ISOGeometryBuilder gb,
            boolean ring) {
        if (node.hasChild(DirectPosition.class)) {
            List dps = node.getChildValues(DirectPosition.class);

            PointArray pa = gb.createPointArray();
            for (int i = 0; i < dps.size(); i++) {
            	DirectPosition dp = (DirectPosition) dps.get(i);
                pa.add(dp);
            }
            
            if(ring) {
            	if(!pa.get(0).equals(pa.get(pa.size() - 1)))
            		pa.add(pa.get(0));
            }
            
            return gb.createCurve(pa);
        }

        if (node.hasChild(Point.class)) {
            List points = node.getChildValues(Point.class);
            PointArray pa = gb.createPointArray();

            for (int i = 0; i < points.size(); i++) {
            	pa.add(((Point) points.get(i)).getDirectPosition());
            }

            return gb.createCurve(pa);
        }

        if (node.hasChild(DirectPosition[].class)) {
            DirectPosition[] dps = (DirectPosition[]) node.getChildValue(DirectPosition[].class);

            PointArray pa = gb.createPointArray();

            for (DirectPosition dp : dps) {
            	pa.add(dp);
            }

            return gb.createCurve(pa);
        }

        if (node.hasChild(PointArray.class)) {
            PointArray pa = (PointArray) node
                    .getChildValue(PointArray.class);

            return gb.createCurve(pa);
        }

        return null;
    }

    /**
     * Returns a curved geometry factory given the linearization constraints, the original factory,
     * and a coordinate sequence representing the control points of a curved geometry
     * 
     * @param arcParameters
     * @param gFactory
     * @param cs
     * @return
     *//*
    public static CurvedGeometryFactory getCurvedGeometryFactory(ArcParameters arcParameters,
            GeometryFactory gFactory, CoordinateSequence cs) {
        CurvedGeometryFactory factory;
        if (gFactory instanceof CurvedGeometryFactory) {
            factory = (CurvedGeometryFactory) gFactory;
        } else if (arcParameters != null && arcParameters.getLinearizationTolerance() != null) {
            double tolerance = Double.MAX_VALUE;
            if (cs != null) {
                CircularArc arc = CurvedGeometries.getArc(cs, 0);
                Circle c = new Circle(arc.getCenter(), arc.getRadius());
                tolerance = arcParameters.getLinearizationTolerance().getTolerance(c);
            }
            factory = new CurvedGeometryFactory(gFactory, tolerance);
        } else {
            factory = new CurvedGeometryFactory(gFactory, Double.MAX_VALUE);
        }
        return factory;
    }*/

}
