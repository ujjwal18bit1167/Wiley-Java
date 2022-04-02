package Week3;

abstract class Vehicle {
    abstract void drive();

    abstract void steeringMechanism();

    void start() {
        System.out.println("Vehicle started");
    }

    void stop() {
        System.out.println("Vehicle stopped");
    }

}

class Bike extends Vehicle {
    @Override
    void drive() {
        System.out.println("Driving....");
    }

    @Override
    void steeringMechanism() {
        System.out.println("Has a steering handle");
    }

}

class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Driving....");
    }

    @Override
    void steeringMechanism() {
        System.out.println("Has a steering wheel");
    }

}

public class abstractClassesTask {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.start();
        bike.drive();
        bike.steeringMechanism();
        bike.stop();

        System.out.println();

        Car car = new Car();
        car.start();
        car.drive();
        car.steeringMechanism();
        car.stop();

    }
}
