package com.javarush.task.task15.task1529;

public class Plane implements CanFly {

    public final int numberOfPassengers;

    public Plane(int numberOfPassengers ) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void fly() {

    }
}
