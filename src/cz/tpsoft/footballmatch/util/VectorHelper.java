/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

import javax.vecmath.Vector3d;

public class VectorHelper {
//
//    /**
//     * Vrati novy vektor, ktery se nejprve nahodne narotuje v rovine YZ (tedy
//     * vertialne) a pote jeste nahodne narotuje v rovine XY (tedy horizontalne).
//     * Toto narotovani neni komutativni, proto zalezi na poradi. Pokud chcete
//     * prohodit poradi rotaci, je nutne predavat pootoceny vektor a potom ho
//     * vratit zpet.
//     *
//     * @param original puvodni vektor, ze ktereho bude vytvorena nahodne
//     * narotovana kopie.
//     * @param minRotateYZ minimalni rotace v ose YZ.
//     * @param maxRotateYZ maximalni rotace v ose YZ.
//     * @param minRotateXZ minimalni rotace v ose XZ.
//     * @param maxRotateXZ maximalni rotace v ose XZ.
//     * @return novou, nahodne narotovanou, instanci vektoru.
//     */
//    public static Vector3d getRandomVector3d(Vector3d original,
//            double minRotateYZ, double maxRotateYZ,
//            double minRotateXZ, double maxRotateXZ) {
//        Vector3d ret = new Vector3d(original);
//        ret.rotateVector3dByX((Math.random() * (maxRotateYZ - minRotateYZ)) + minRotateYZ);
//        ret.rotateVector3dByY((Math.random() * (maxRotateXZ - minRotateXZ)) + minRotateXZ);
//        return ret;
//
//
//    }
//
//    /**
//     *
//     * @author tomas.praslicak
//     */
//    public static Vector3d getRandomVector3d(double length,
//            double minRotateYZ, double maxRotateYZ,
//            double minRotateXZ, double maxRotateXZ) {
//        return getRandomVector3d(
//                new Vector3d(0, 0, length),
//                minRotateYZ, maxRotateYZ, minRotateXZ, maxRotateXZ);
//    }
//    
//    /**
//     * 
//     * @param angleChange uhel rotace v radianech.
//     */
//    public void rotateVector3dByX(double angleChange) {
//        double angle = getYZAngle() + angleChange;
//        double r = absYZ();
//        setZ(r * Math.cos(angle));
//        setY(r * Math.sin(angle));
//    }
//    
//    /**
//     * 
//     * @param angleChange uhel rotace v radianech.
//     */
//    public void rotateVector3dByY(double angleChange) {
//        double angle = getXZAngle() + angleChange;
//        double r = absXZ();
//        setX(r * Math.cos(angle));
//        setZ(r * Math.sin(angle));
//    }
//    
//    /**
//     * 
//     * @param angleChange uhel rotace v radianech.
//     */
//    public void rotateVector3dByZ(double angleChange) {
//        double angle = getXYAngle() + angleChange;
//        double r = absXY();
//        setX(r * Math.cos(angle));
//        setY(r * Math.sin(angle));
//    }
}
