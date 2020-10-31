package com.company;

public class CelestialBody {
    String name;
    double mass;
    int xCoord;
    int yCoord;
    double xVelocity;
    double yVelocity;
    int radius;

    public CelestialBody(String name, double mass, int xCoord, int yCoord, double xVelocity, double yVelocity, int radius) {
        this.name = name;
        this.mass = mass;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
    }



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

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public int getRadius() {
        return radius;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
