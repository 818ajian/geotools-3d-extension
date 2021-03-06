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

import org.geotools.gml2.iso.GML;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.xml.ElementInstance;
import org.geotools.xml.Node;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.ISOGeometryBuilder;
import org.opengis.geometry.coordinate.PointArray;
import org.opengis.geometry.primitive.Surface;
/**
 * 
 *
 * @source $URL$
 */
public class GMLPolygonPropertyTypeBindingTest extends AbstractGMLBindingTest {
    ElementInstance association;
    ElementInstance geometry;

    ISOGeometryBuilder builder = new ISOGeometryBuilder(DefaultGeographicCRS.WGS84_3D);
    protected void setUp() throws Exception {
        super.setUp();

        association = createElement(GML.NAMESPACE, "myPolygonProperty", GML.POLYGONPROPERTYTYPE,
                null);
        geometry = createElement(GML.NAMESPACE, "myPolygon", GML.POLYGONTYPE, null);
    }

    public void testWithGeometry() throws Exception {
    	DirectPosition dp1 = builder.createDirectPosition(new double[] {1.0, 2.0, 3.0});
    	DirectPosition dp2 = builder.createDirectPosition(new double[] {3.0, 4.0, 4.0});
    	DirectPosition dp3 = builder.createDirectPosition(new double[] {5.0, 2.0, 3.0});
    	PointArray pa1 = createPointArray(builder, new DirectPosition[] {dp1, dp2, dp3, dp1});
        Node node = createNode(association, new ElementInstance[] { geometry },
                new Object[] {
                		builder.createSurface(builder.createSurfaceBoundary(pa1)),
                }, null, null);
        GMLGeometryAssociationTypeBinding s = (GMLGeometryAssociationTypeBinding) getBinding(GML.GEOMETRYASSOCIATIONTYPE);
        GMLPolygonPropertyTypeBinding s1 = (GMLPolygonPropertyTypeBinding) getBinding(GML.POLYGONPROPERTYTYPE);
        Surface p = (Surface) s1.parse(association, node, s.parse(association, node, null));
        assertNotNull(p);
    }
}
