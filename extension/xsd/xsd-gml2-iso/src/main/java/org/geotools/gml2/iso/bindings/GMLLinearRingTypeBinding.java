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
package org.geotools.gml2.iso.bindings;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.namespace.QName;

import org.geotools.gml2.iso.GML;
import org.geotools.xml.AbstractComplexBinding;
import org.geotools.xml.ElementInstance;
import org.geotools.xml.Node;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.ISOGeometryBuilder;
import org.opengis.geometry.coordinate.PointArray;
import org.opengis.geometry.coordinate.Position;
import org.opengis.geometry.primitive.Curve;
import org.opengis.geometry.primitive.CurveSegment;
import org.opengis.geometry.primitive.Primitive;
import org.opengis.geometry.primitive.Ring;


/**
 * Binding object for the type http://www.opengis.net/gml:LinearRingType.
 *
 * <p>
 *        <pre>
 *         <code>
 *  &lt;complexType name="LinearRingType"&gt;
 *      &lt;annotation&gt;
 *          &lt;documentation&gt;         A LinearRing is defined by four or more
 *              coordinate tuples, with          linear interpolation
 *              between them; the first and last coordinates          must
 *              be coincident.       &lt;/documentation&gt;
 *      &lt;/annotation&gt;
 *      &lt;complexContent&gt;
 *          &lt;extension base="gml:AbstractGeometryType"&gt;
 *              &lt;sequence&gt;
 *                  &lt;choice&gt;
 *                      &lt;element ref="gml:coord" minOccurs="4" maxOccurs="unbounded"/&gt;
 *                      &lt;element ref="gml:coordinates"/&gt;
 *                  &lt;/choice&gt;
 *              &lt;/sequence&gt;
 *          &lt;/extension&gt;
 *      &lt;/complexContent&gt;
 *  &lt;/complexType&gt;
 *
 *          </code>
 *         </pre>
 * </p>
 *
 * @generated
 *
 *
 *
 * @source $URL$
 */
public class GMLLinearRingTypeBinding extends AbstractComplexBinding {
    ISOGeometryBuilder gBuilder;

    public GMLLinearRingTypeBinding(ISOGeometryBuilder gBuilder) {
        this.gBuilder = gBuilder;
    }

    /**
     * @generated
     */
    public QName getTarget() {
        return GML.LinearRingType;
    }

    public int getExecutionMode() {
        return AFTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    public Class getType() {
        return Ring.class;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    public Object parse(ElementInstance instance, Node node, Object value)
        throws Exception {
        List coordinates = node.getChildren("coord");

        if (!coordinates.isEmpty() && (coordinates.size() < 4)) {
            throw new RuntimeException("LinearRing must have at least 4 coordinates");
        }

        if (!coordinates.isEmpty()) {
            PointArray pArr = gBuilder.createPointArray();
            for (int i = 0; i < coordinates.size(); i++) {
                Node cnode = (Node) coordinates.get(i);
                DirectPosition dp = (DirectPosition) cnode.getValue();
                pArr.add(dp);
            }

            Curve c = gBuilder.createCurve(pArr);
            return gBuilder.createRing(Arrays.asList(c));
        }

        if (node.getChild("coordinates") != null) {
            Node cnode = (Node) node.getChild("coordinates");
            PointArray pArr = (PointArray) cnode.getValue();

            Curve c = gBuilder.createCurve(pArr);
            return gBuilder.createRing(Arrays.asList(c));
        }

        throw new RuntimeException("Could not find coordinates to build linestring");
    }

    public Object getProperty(Object object, QName name)
        throws Exception {
    	Ring linearRing = (Ring) object;

        if (GML.coordinates.equals(name)) {
        	PointArray pa = gBuilder.createPointArray();
        	
        	//assuming that first element is Curve
        	Collection<? extends Primitive> elements = linearRing.getElements();
        	Curve curve = (Curve) elements.iterator().next();
        	List<? extends CurveSegment> segments = curve.getSegments();
        	for(CurveSegment cs : segments) {
        		for(Position p : cs.getSamplePoints()) {
        			if(pa.size() == 0 || !pa.get(pa.size() - 1).equals(p)) {
        				pa.add(p);
        			}
        		}
        	}
        	return pa;
        }

        return null;
    }
}
