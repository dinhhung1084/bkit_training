package OOP;

abstract class Vehicle {
    abstract void start();

    abstract void stop();

    abstract void accelerate();

    abstract void brake();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Start");
    }

    void stop() {
        System.out.println("Stop");
    }

    void accelerate() {
        System.out.println("Accelerate");
    }

    void brake() {
        System.out.println("Brake");
    }
}



public class Abstraction {
    public static void main(String[] args) {
        Vehicle obj = new Car();
        obj.stop();
    }
}
