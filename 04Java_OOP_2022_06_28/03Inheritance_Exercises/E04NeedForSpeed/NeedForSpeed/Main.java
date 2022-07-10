package NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        Motorcycle motorcycle = new Motorcycle(15, 50);

        FamilyCar familyCar = new FamilyCar(30, 90);

        SportCar sportCar = new SportCar(40, 200);

        System.out.println(motorcycle.getFuelConsumption());

        System.out.println(familyCar.getFuelConsumption());

        System.out.println(sportCar.getFuelConsumption());
        System.out.println(sportCar.getFuel());
        System.out.println(sportCar.getHorsePower());

        sportCar.drive(20);
        sportCar.drive(1000);

        System.out.println(sportCar.getFuel());

        sportCar.setFuelConsumption(15.0);

        System.out.println(sportCar.getFuelConsumption());

    }
}