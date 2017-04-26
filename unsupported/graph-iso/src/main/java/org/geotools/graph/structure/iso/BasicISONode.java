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
package org.geotools.graph.structure.iso;

import org.geotools.graph.structure.basic.BasicNode;
import org.opengis.geometry.DirectPosition;

/**
 * Basic implementation of XYNode extended from BasicNode. The coordinate is
 * stored in the underlying object reference of the node.
 * 
 * @see org.geotools.graph.structure.basic.BasicNode
 * 
 * @author Justin Deoliveira, Refractions Research Inc, jdeolive@refractions.net
 * @author Hyung-Gyu Ryoo, Pusan National University, hyunggyu.ryoo@gmail.com
 *
 *
 * @source $URL$
 */
public class BasicISONode extends BasicNode implements ISONode {

    @Override
    public DirectPosition getCoordinate() {
        return (DirectPosition)getObject();
    }

    @Override
    public void setCoordinate(DirectPosition c) {
        setObject((DirectPosition)c);
    }
}
