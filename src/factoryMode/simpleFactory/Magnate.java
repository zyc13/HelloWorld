package factoryMode.simpleFactory;

public class Magnate {

    public static void main(String[] args) throws Exception {
        Car car = Driver.driverCar("benz");
        car.driver();
    }
}
