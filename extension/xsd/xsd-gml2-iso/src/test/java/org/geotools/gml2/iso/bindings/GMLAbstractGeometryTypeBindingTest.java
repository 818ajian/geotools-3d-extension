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
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.geotools.xml.Binding;
import org.opengis.geometry.Geometry;
import org.opengis.geometry.primitive.Point;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.w3c.dom.Document;


/**
 * 
 *
 * @source $URL$
 */
public class GMLAbstractGeometryTypeBindingTest extends GMLTestSupport {
    public void testType() {
        assertEquals(Geometry.class, binding(GML.AbstractGeometryType).getType());
    }

    public void testExecutionMode() {
        assertEquals(Binding.OVERRIDE, binding(GML.AbstractGeometryType).getExecutionMode());
    }

    public void testParse() throws Exception {
        GML2MockData.point(document, document);
        document.getDocumentElement().setAttribute("srsName", "EPSG:4329");

        Point p = (Point) parse();
        assertNotNull(p.getCoordinateReferenceSystem());
    }

    public void testEncode() throws Exception {
        Point p = GML2MockData.point();
        
        Document doc = encode(p, GML.Point);
        assertEquals("WGS84(DD)",
            doc.getDocumentElement().getAttribute("srsName"));
    }
}
