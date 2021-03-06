/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2015 - 2016, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.gml3.iso.simple;

import org.geotools.gml2.iso.simple.GMLWriter;
import org.geotools.gml2.iso.simple.GeometryEncoder;
import org.geotools.gml2.iso.simple.QualifiedName;
import org.geotools.gml3.iso.GML;
import org.geotools.gml3.iso.simple.LinearRingEncoder;
import org.geotools.gml3.iso.simple.RingEncoder;
import org.geotools.xml.Encoder;
import org.opengis.geometry.primitive.Curve;
import org.opengis.geometry.primitive.Ring;
import org.opengis.geometry.primitive.Surface;
import org.opengis.geometry.primitive.SurfaceBoundary;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Encodes a GML3 polygon
 * 
 * @author Justin Deoliveira, OpenGeo
 * @author Andrea Aime - GeoSolutions
 */
class PolygonEncoder extends GeometryEncoder<Surface> {
    static final QualifiedName POLYGON = new QualifiedName(GML.NAMESPACE, "Polygon", "gml");

    static final QualifiedName EXTERIOR = new QualifiedName(GML.NAMESPACE, "exterior", "gml");

    static final QualifiedName INTERIOR = new QualifiedName(GML.NAMESPACE, "interior", "gml");

    QualifiedName polygon;

    QualifiedName exterior;

    QualifiedName interior;

    LinearRingEncoder lre;

    RingEncoder re;

    protected PolygonEncoder(Encoder encoder, String gmlPrefix, String gmlUri) {
        super(encoder);
        polygon = POLYGON.derive(gmlPrefix, gmlUri);
        exterior = EXTERIOR.derive(gmlPrefix, gmlUri);
        interior = INTERIOR.derive(gmlPrefix, gmlUri);
        lre = new LinearRingEncoder(encoder, gmlPrefix, gmlUri);
        re = new RingEncoder(encoder, gmlPrefix, gmlUri);
    }
    
    @Override
    public void encode(Surface geometry, AttributesImpl atts, GMLWriter handler)
            throws Exception {
        handler.startElement(polygon, atts);
        
        SurfaceBoundary boundary = geometry.getBoundary();
        
        handler.startElement(exterior, null);
        encodeRing(boundary.getExterior(), handler);
        handler.endElement(exterior);
        
        for ( int i = 0; i < boundary.getInteriors().size(); i++ ) {
            handler.startElement(interior, null);
            encodeRing(boundary.getInteriors().get(i), handler);
            handler.endElement(interior);
        }
        
        handler.endElement(polygon);
    }

    private void encodeRing(Ring ring, GMLWriter handler) throws Exception {
        /*if (ring instanceof CurvedGeometry) {
            re.encode(ring, null, handler);
        } else {
            lre.encode(ring, null, handler);
        }*/
        lre.encode((Curve) ring.getElements().iterator().next(), null, handler);
    }
    
}