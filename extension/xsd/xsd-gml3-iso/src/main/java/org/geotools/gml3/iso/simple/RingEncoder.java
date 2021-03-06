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

import org.geotools.gml2.simple.GMLWriter;
import org.geotools.gml2.simple.QualifiedName;
import org.geotools.gml3.iso.GML;
import org.geotools.gml3.iso.simple.MultiLineStringEncoder;
import org.geotools.xml.Encoder;
import org.xml.sax.helpers.AttributesImpl;

import com.vividsolutions.jts.geom.Geometry;

/**
 * Encodes a GML3 curved ring
 * 
 * @author Andrea Aime - GeoSolutions
 */
public class RingEncoder extends MultiLineStringEncoder {

    static final QualifiedName RING = new QualifiedName(GML.NAMESPACE, "Ring", "gml");

    private QualifiedName ring;

    protected RingEncoder(Encoder e, String gmlPrefix, String gmlUri) {
        super(e, gmlPrefix, gmlUri, true);
        this.ring = RING.derive(gmlPrefix, gmlUri);
    }

    @Override
    public void encode(Geometry geometry, AttributesImpl atts, GMLWriter handler)
            throws Exception {
        handler.startElement(ring, atts);

        encodeMembers(geometry, handler);

        handler.endElement(ring);
    }

}
