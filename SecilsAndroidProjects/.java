class Scratch {
    public static void main(String[] args) {

//        Vehicle aGenericVehicle = new Vehicle();
//        aGenericVehicle.name = "Car";
//        aGenericVehicle.numberOfWheels = 4;
//        aGenericVehicle.canFly = false;
//        aGenericVehicle.describeVehicle();
//        aGenericVehicle.start();
//        aGenericVehicle.stop();

        Car car = new Car("Mercedes");

    }
}

class Vehicle {

    String name;
    int numberOfWheels;
    boolean canFly;

    void describeVehicle() {
        System.out.println("VEHICLE DETAILS - Name:  " + name + ", Number of wheels " + numberOfWheels + "Capable of fly " + canFly);
    }

    void start() {
        System.out.println("<Engine Started>");
    }

    void stop() {
        System.out.println("<Engine Stopped>");
    }
}

class Car extends Vehicle {

    String model;

    Car(String model) {
        this.name = "Car";
        this.numberOfWheels = 4;
        this.canFly = false;vbnm
        this.model = model;
    }

    @Override
    void describeVehicle() {


        super.describeVehicle();

vcxvbnm/.  ty
    }

    void beepHorn() {
        System.out.println("Beep beep!");
    }

}