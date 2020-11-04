package com.company;

/**
 * Constructs the Celestial Body information
 */
public class CelestialBody {
    String name;
    double mass;
    int xCoord;
    int yCoord;
    double xVelocity;
    double yVelocity;
    int radius;

    /**
     * Constructor for the Celestial Body class
     * @param name
     * @param mass
     * @param xCoord
     * @param yCoord
     * @param xVelocity
     * @param yVelocity
     * @param radius
     */
    public CelestialBody(String name, double mass, int xCoord, int yCoord, double xVelocity, double yVelocity, int radius) {
        this.name = name;
        this.mass = mass;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
    }


    /**
     * Converts the Lists to to a String
     * @return
     */
    @Override
    public String toString() {
        return "CelestialBody{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", xVelocity=" + xVelocity +
                ", yVelocity=" + yVelocity +
                ", radius=" + radius +
                '}';
    }

    /**
     * gets the name of the Celestial Body
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * gets the mass of the Celestial Body
     * @return
     */
    public double getMass() {
        return mass;
    }

    /**
     * gets the x-coordinate of the Celestial Body
     * @return
     */
    public int getxCoord() {
        return xCoord;
    }

    /**
     * gets the y-coordinate of the Celestial Body
     * @return
     */
    public int getyCoord() {
        return yCoord;
    }

    /**
     * gets the x-velocity of the Celestial Body
     * @return
     */
    public double getxVelocity() {
        return xVelocity;
    }

    /**
     * gets the y-velocity of the Celestial Body
     * @return
     */
    public double getyVelocity() {
        return yVelocity;
    }

    /**
     * gets the radius of the Celestial Body
     * @return
     */
    public int getRadius() {
        return radius;
    }

    /**
     * sets the name of the Celestial Body
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the mass of the Celestial Body
     * @return
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * sets the x-coordinate of the Celestial Body
     * @return
     */
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    /**
     * sets the y-coordinate of the Celestial Body
     * @return
     */
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    /**
     * sets the x-velocity of the Celestial Body
     * @return
     */
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    /**
     * sets the y-velocity of the Celestial Body
     * @return
     */
    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    /**
     * sets the radius of the Celestial Body
     * @return
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
