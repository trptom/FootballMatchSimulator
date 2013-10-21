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
public class Vec3DOldTest {
    
    public Vec3DOldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println(Vec3DOldTest.class.getName() + " started");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println(Vec3DOldTest.class.getName() + " finished");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRandomVector() {
        // vektory se generuji nahodne, tak to proste hodim do cyklu
        // a kontroluju, jestli jsem v povolenem rozmezi (nejdriv pro YZ,
        // pak XZ)
        for (int a=0; a<20; a++) {
            double rand = Math.random() * Math.PI/ 2;
            Vec3DOld vec = Vec3DOld.getRandomVector(1, -rand, rand, 0, 0);
            assertEquals(0.0, vec.getYZAngle(), rand + 0.01);
        }
        for (int a=0; a<20; a++) {
            double rand = Math.random() * Math.PI/ 2;
            Vec3DOld vec = Vec3DOld.getRandomVector(1, 0, 0, -rand, rand);
            assertEquals(Math.PI / 2, vec.getXZAngle(), rand + 0.01);
        }
    }
    
    @Test
    public void testGetX() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getX(), 0.0);
        instance = new Vec3DOld(1d, 1d, 1d);
        assertEquals(1.0, instance.getX(), 0.0);
    }

    @Test
    public void testGetY() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getY(), 0.0);
        instance = new Vec3DOld(1d, 1d, 1d);
        assertEquals(1.0, instance.getY(), 0.0);
    }

    @Test
    public void testGetZ() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getZ(), 0.0);
        instance = new Vec3DOld(1d, 1d, 1d);
        assertEquals(1.0, instance.getZ(), 0.0);
    }

    @Test
    public void testSetX() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getX(), 0.0);
        instance.setX(2d);
        assertEquals(2.0, instance.getX(), 0.0);
        instance.setX(10d);
        assertEquals(10.0, instance.getX(), 0.0);
        instance.setX(-10d);
        assertEquals(-10.0, instance.getX(), 0.0);
    }

    @Test
    public void testSetY() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getY(), 0.0);
        instance.setY(2d);
        assertEquals(2.0, instance.getY(), 0.0);
        instance.setY(10d);
        assertEquals(10.0, instance.getY(), 0.0);
        instance.setY(-10d);
        assertEquals(-10.0, instance.getY(), 0.0);
    }

    @Test
    public void testSetZ() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.getZ(), 0.0);
        instance.setZ(2d);
        assertEquals(2.0, instance.getZ(), 0.0);
        instance.setZ(10d);
        assertEquals(10.0, instance.getZ(), 0.0);
        instance.setZ(-10d);
        assertEquals(-10.0, instance.getZ(), 0.0);
    }

    @Test
    public void testAbs() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0.0, instance.abs(), 0.0);
        instance = new Vec3DOld(1d, 1d, 1d);
        assertEquals(Math.sqrt(3), instance.abs(), 0.0);
        instance = new Vec3DOld(2d, 2d, 1d);
        assertEquals(3.0, instance.abs(), 0.0);
    }
    
    @Test
    public void testGetXZAngle() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0, instance.getXZAngle(), 0.0);
        instance = new Vec3DOld(1, 10, 1);
        assertEquals(Math.PI / 4, instance.getXZAngle(), 0.0);
        instance = new Vec3DOld(1, 10, -1);
        assertEquals(-Math.PI / 4, instance.getXZAngle(), 0.0);
    }
    
    @Test
    public void testGetXYAngle() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0, instance.getXYAngle(), 0.0);
        instance = new Vec3DOld(1, 1, 10);
        assertEquals(Math.PI / 4, instance.getXYAngle(), 0.0);
        instance = new Vec3DOld(1, -1, 10);
        assertEquals(-Math.PI / 4, instance.getXYAngle(), 0.0);
    }
    
    @Test
    public void testGetYZAngle() {
        Vec3DOld instance;
        instance = new Vec3DOld();
        assertEquals(0, instance.getYZAngle(), 0.0);
        instance = new Vec3DOld(10, 1, 1);
        assertEquals(Math.PI / 4, instance.getYZAngle(), 0.0);
        instance = new Vec3DOld(10, -1, 1);
        assertEquals(-Math.PI / 4, instance.getYZAngle(), 0.0);
    }

    @Test
    public void testRotateByX() {
        Vec3DOld instance = new Vec3DOld(1, 1, 0);
        assertEquals(Math.PI / 2, instance.getYZAngle(), 0.00001);
        instance.rotateByX(Math.PI / 2);
        assertEquals(Math.PI, instance.getYZAngle(), 0.00001);
        instance.rotateByX(-Math.PI);
        assertEquals(0.0, instance.getYZAngle(), 0.00001);
        instance.rotateByX(4*Math.PI);
        assertEquals(0.0, instance.getYZAngle(), 0.00001);
    }
    
    @Test
    public void testRotateByY() {
        Vec3DOld instance = new Vec3DOld(0, 1, 1);
        assertEquals(Math.PI / 2, instance.getXZAngle(), 0.00001);
        instance.rotateByY(Math.PI / 2);
        assertEquals(Math.PI, instance.getXZAngle(), 0.00001);
        instance.rotateByY(-Math.PI);
        assertEquals(0.0, instance.getXZAngle(), 0.00001);
        instance.rotateByY(4*Math.PI);
        assertEquals(0.0, instance.getXZAngle(), 0.00001);
    }
    
    @Test
    public void testRotateByZ() {
        Vec3DOld instance = new Vec3DOld(0, 1, 1);
        assertEquals(Math.PI / 2, instance.getXYAngle(), 0.00001);
        instance.rotateByZ(Math.PI / 2);
        assertEquals(Math.PI, instance.getXYAngle(), 0.00001);
        instance.rotateByZ(-Math.PI);
        assertEquals(0.0, instance.getXYAngle(), 0.00001);
        instance.rotateByZ(4*Math.PI);
        assertEquals(0.0, instance.getXYAngle(), 0.00001);
    }
}