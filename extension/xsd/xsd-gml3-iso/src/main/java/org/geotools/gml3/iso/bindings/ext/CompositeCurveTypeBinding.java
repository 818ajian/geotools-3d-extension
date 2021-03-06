/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2011, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.gml3.iso.bindings.ext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.geotools.geometry.jts.CurvedGeometryFactory;
import org.geotools.gml3.iso.ArcParameters;
import org.geotools.gml3.iso.GML;
import org.geotools.gml3.iso.bindings.GML3ParsingUtils;
import org.geotools.gml3.iso.bindings.LineStringTypeBinding;
import org.geotools.xml.ElementInstance;
import org.geotools.xml.Node;
import org.opengis.geometry.ISOGeometryBuilder;
import org.opengis.geometry.complex.CompositeCurve;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.CoordinateSequenceFactory;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;

/**
 * Simple type binding for Composite Curve GML elements.
 * @source $URL$
 */
public class CompositeCurveTypeBinding extends LineStringTypeBinding {

    private final ISOGeometryBuilder gBuilder;

    private ArcParameters arcParameters;
    
    public CompositeCurveTypeBinding(ISOGeometryBuilder gBuilder) {
        super(gBuilder);
        this.gBuilder = gBuilder;
    }

    public void setArcParameters(ArcParameters arcParameters) {
        this.arcParameters = arcParameters;
    }

    @Override
    public QName getTarget() {
        return GML.CompositeCurveType;
    }

    @Override
    public Class getType() {
        return CompositeCurve.class;
    }

    @Override
    public Object parse(ElementInstance instance, Node node, Object value)
            throws Exception {
        /*List children = node.getChildren("curveMember");
        List<LineString> components = new ArrayList<>();
        for (Iterator it = children.iterator(); it.hasNext();) {
            Node child = (Node) it.next();
            if (child.getValue() instanceof LineString) {
                LineString ls = (LineString) child.getValue();
                components.add(ls);
            }
        }

        if (components.isEmpty()) {
            return gBuilder.createLineString(new Coordinate[0]);
        } else {
            CoordinateSequence cs = components.get(0).getCoordinateSequence();
            CurvedGeometryFactory factory = GML3ParsingUtils.getCurvedGeometryFactory(
                    arcParameters, gBuilder, cs);
            return factory.createCurvedGeometry(components);
        }*/
    	return null;
    }

    /**
     * Construct a line string from CurveMembers coordinates.
     * 
     * @param node
     * @return
     */
    public static CoordinateList extractCurveMemberCoordinates(Node node) {
        List curveMembers = node.getChildren("curveMember");
        CoordinateList clist = new CoordinateList();
        for (int i = 0; i < curveMembers.size(); i++) {
            List curves = ((Node) curveMembers.get(i))
                    .getChildren(MultiLineString.class);
            for (int j = 0; j < curves.size(); j++) {
                MultiLineString mls = (MultiLineString) ((Node) curves.get(j))
                        .getValue();
                clist.add(mls.getCoordinates(), false);
            }
        }
        return clist;
    }

}
