/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomas.praslicak
 */
public class Vec2DOldTest {
    
    public Vec2DOldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAngle() {
        assertEquals(0, Vec2DOld.getAngle(0, 0), 0.0);
        // po osach
        assertEquals(0, Vec2DOld.getAngle(1, 0), 0.0);
        assertEquals(Math.PI / 2, Vec2DOld.getAngle(0, 1), 0.0);
        assertEquals(Math.PI, Vec2DOld.getAngle(-1, 0), 0.0);
        assertEquals(-Math.PI / 2, Vec2DOld.getAngle(0, -1), 0.0);
        // diagonaly
        assertEquals(Math.PI / 4, Vec2DOld.getAngle(1, 1), 0.0);
        assertEquals(3 * Math.PI / 4, Vec2DOld.getAngle(-1, 1), 0.0);
        assertEquals(-3 * Math.PI / 4, Vec2DOld.getAngle(-1, -1), 0.0);
        assertEquals(-Math.PI / 4, Vec2DOld.getAngle(1, -1), 0.0);
    }

    @Test
    public void testGetX() {
    }

    @Test
    public void testGetY() {
    }

    @Test
    public void testSetX() {
    }

    @Test
    public void testSetY() {
    }

    @Test
    public void testAbs() {
    }
}