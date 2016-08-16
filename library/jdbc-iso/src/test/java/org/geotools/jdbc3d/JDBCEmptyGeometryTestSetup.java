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
package org.geotools.jdbc3d;

import java.sql.SQLException;

/**
 * 
 *
 * @source $URL: http://svn.osgeo.org/geotools/trunk/modules/library/jdbc/src/test/java/org/geotools/jdbc/JDBCEmptyGeometryTestSetup.java $
 */
public abstract class JDBCEmptyGeometryTestSetup extends JDBCDelegatingTestSetup {

    protected JDBCEmptyGeometryTestSetup(JDBCTestSetup delegate) {
        super(delegate);
    }
    
    protected final void setUpData() throws Exception {
        //kill all the data
        try {
            dropEmptyGeometryTable();
        } catch (SQLException e) {
        }

        //create all the data
        createEmptyGeometryTable();
    }

    protected abstract void createEmptyGeometryTable() throws Exception;

    /**
     * Drops the "empty" table previously created
     */
    protected abstract void dropEmptyGeometryTable() throws Exception;

}
