/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.tpsoft.footballmatch.util;

/**
 *
 * @author tomas.praslicak
 */
public class Vec3DOld {
    /**
     * 
     * @param length
     * @param minRotateYZ
     * @param maxRotateYZ
     * @param minRotateXZ
     * @param maxRotateXZ
     * @return 
     */
    public static Vec3DOld getRandomVector(double length,
            double minRotateYZ, double maxRotateYZ,
            double minRotateXZ, double maxRotateXZ) {
        return getRandomVector(
                new Vec3DOld(0, 0, length),
                minRotateYZ, maxRotateYZ, minRotateXZ, maxRotateXZ);
    }
    
    /**
     * 
     * @param vector vektor, jehoz nasobek ma byt vracen (jeho hodnota se
     * nezmeni).
     * @param value hodnota, kterou se nasobi vektor.
     * @return novou instanci vektoru, ktera je nasobkem parametru.
     */
    public static Vec3DOld multiple(Vec3DOld vector, double value) {
        return new Vec3DOld(vector).multiple(value);
    }
    
    /**
     * Vrati novy vektor, ktery se nejprve nahodne narotuje v rovine YZ (tedy
     * vertialne) a pote jeste nahodne narotuje v rovine XY (tedy horizontalne).
     * Toto narotovani neni komutativni, proto zalezi na poradi. Pokud chcete
     * prohodit poradi rotaci, je nutne predavat pootoceny vektor a potom
     * ho vratit zpet.
     * @param original puvodni vektor, ze ktereho bude vytvorena nahodne
     * narotovana kopie.
     * @param minRotateYZ minimalni rotace v ose YZ.
     * @param maxRotateYZ maximalni rotace v ose YZ.
     * @param minRotateXZ minimalni rotace v ose XZ.
     * @param maxRotateXZ maximalni rotace v ose XZ.
     * @return novou, nahodne narotovanou, instanci vektoru.
     */
    public static Vec3DOld getRandomVector(Vec3DOld original,
            double minRotateYZ, double maxRotateYZ,
            double minRotateXZ, double maxRotateXZ) {
        Vec3DOld ret = new Vec3DOld(original);
        ret.rotateByX((Math.random() * (maxRotateYZ - minRotateYZ)) + minRotateYZ);
        ret.rotateByY((Math.random() * (maxRotateXZ - minRotateXZ)) + minRotateXZ);
        return ret;
    }
    
    private double x;
    private double y;
    private double z;

    public Vec3DOld() {
        this(0d, 0d, 0d);
    }
    
    public Vec3DOld(Vec3DOld copyOf) {
        this(copyOf.x, copyOf.y, copyOf.z);
    }
    
    public Vec3DOld(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    public double abs() {
        return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }
    
    public double absXZ() {
        return Math.sqrt(getX() * getX() + getZ() * getZ());
    }
    
    public double absXY() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }
    
    public double absYZ() {
        return Math.sqrt(getY() * getY() + getZ() * getZ());
    }
    
    /**
     * 
     * @return uhel vektoru, promituteho na rovinu XZ. Pokud je vektor na kladne
     * casti osy X, je uhel=0, pokud je nad osou, je uhel kladny, jinak je
     * zaporny.
     */
    public double getXZAngle() {
        return Vec2DOld.getAngle(getX(), getZ());
    }
    
    /**
     * 
     * @return uhel vektoru, promituteho na rovinu XY. Pokud je vektor na kladne
     * casti osy X, je uhel=0, pokud je nad osou, je uhel kladny, jinak je
     * zaporny.
     */
    public double getXYAngle() {
        return Vec2DOld.getAngle(getX(), getY());
    }
    
    /**
     * 
     * @return uhel vektoru, promituteho na rovinu YZ. Pokud je vektor na kladne
     * casti osy Z, je uhel=0, pokud je nad osou, je uhel kladny, jinak je
     * zaporny.
     */
    public double getYZAngle() {
        return Vec2DOld.getAngle(getZ(), getY());
    }
    
    /**
     * 
     * @param angleChange uhel rotace v radianech.
     */
    public void rotateByX(double angleChange) {
        double angle = getYZAngle() + angleChange;
        double r = absYZ();
        setZ(r * Math.cos(angle));
        setY(r * Math.sin(angle));
    }
    
    /**
     * 
     * @param angleChange uhel rotace v radianech.
     */
    public void rotateByY(double angleChange) {
        double angle = getXZAngle() + angleChange;
        double r = absXZ();
        setX(r * Math.cos(angle));
        setZ(r * Math.sin(angle));
    }
    
    /**
     * 
     * @param angleChange uhel rotace v radianech.
     */
    public void rotateByZ(double angleChange) {
        double angle = getXYAngle() + angleChange;
        double r = absXY();
        setX(r * Math.cos(angle));
        setY(r * Math.sin(angle));
    }
    
    /**
     * 
     * @param value hodnota, kterou se ma vektor vynasobit.
     * @return tento vektor po vynasobeni.
     */
    public Vec3DOld multiple(double value) {
        setX(getX() * value);
        setY(getY() * value);
        setZ(getZ() * value);
        return this;
    }
    
    public Vec3DOld sum(Vec3DOld vector) {
        setX(getX() + vector.getX());
        setY(getY() + vector.getY());
        setZ(getZ() + vector.getZ());
        return this;
    }
    
    public Vec3DOld set(Vec3DOld values) {
        setX(values.getX());
        setY(values.getY());
        setZ(values.getZ());
        return this;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [x=" + getX() + ", y=" + getY() + ", z=" + getZ() + "]";
    }
    
}
