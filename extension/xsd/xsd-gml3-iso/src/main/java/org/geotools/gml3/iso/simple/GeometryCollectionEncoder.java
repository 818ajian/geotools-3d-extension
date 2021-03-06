/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2016, Open Source Geospatial Foundation (OSGeo). 
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

import com.vividsolutions.jts.geom.GeometryCollection;

import org.geotools.gml2.iso.simple.GMLWriter;
import org.geotools.gml2.iso.simple.GeometryEncoder;
import org.geotools.gml2.iso.simple.QualifiedName;
import org.geotools.gml3.iso.GML;
import org.geotools.gml3.iso.simple.GenericGeometryEncoder;
import org.geotools.gml3.iso.simple.GeometryCollectionEncoder;
import org.geotools.xml.Encoder;
import org.opengis.geometry.aggregate.MultiPrimitive;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Encodes a GML3 generic geometry collection
 * 
 * @author 
 */
public class GeometryCollectionEncoder extends GeometryEncoder<MultiPrimitive> {

    static final QualifiedName GEOMETRY_COLLECTION = new QualifiedName(
        GML.NAMESPACE, "GeometryCollection", "gml");

    QualifiedName element;
    static Encoder encoder;

    public GeometryCollectionEncoder(Encoder encoder, String gmlPrefix, String gmlUri) {
        this(encoder, GEOMETRY_COLLECTION.derive(gmlPrefix, gmlUri));
    }

    public GeometryCollectionEncoder(Encoder encoder, QualifiedName name) {
        super(encoder);
        GeometryCollectionEncoder.encoder = encoder;
    }
    @Override
    public void encode(MultiPrimitive geometry, AttributesImpl atts,
        GMLWriter handler) throws Exception {
        handler.startElement(GEOMETRY_COLLECTION, atts);
        /*if (geometry.getNumGeometries() < 1) {
            throw new Exception("More than 1 geometry required!");
        } else {
            GenericGeometryEncoder gec = new GenericGeometryEncoder(
                GeometryCollectionEncoder.encoder);
            for (int i = 0; i < geometry.getNumGeometries(); i++) {
                gec.encode(geometry.getGeometryN(i), atts, handler);
            }
        }*/
        handler.endElement(GEOMETRY_COLLECTION);
    }

}