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
package org.geotools.factory;

import junit.framework.TestCase;

import org.geotools.feature.AbstractFeatureFactoryImpl;
import org.geotools.feature.ISOFeatureFactoryImpl;
import org.geotools.feature.ValidatingFeatureFactoryImpl;
import org.opengis.feature.FeatureFactory;

/**
 * 
 *
 * @source $URL$
 */
public class CommonFactoryFinderTest extends TestCase {
    public void testGetNewFeatureFactory() {
        Hints hints = new Hints(Hints.FEATURE_FACTORY, ISOFeatureFactoryImpl.class);
        FeatureFactory featureFactory = CommonFactoryFinder.getFeatureFactory(hints);
        assertNotNull(featureFactory);
        assertTrue(featureFactory instanceof ISOFeatureFactoryImpl);
    }
}
