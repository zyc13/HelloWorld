package factoryMode.simpleFactory;

/**
 * 工厂类角色
 */
public class Driver {

    /**
     * 工厂方法
     * 注意 返回类型为抽象产品角色
     * @param s
     * @return
     * @throws Exception
     */
    public static Car driverCar(String s) throws Exception {
        if (s.equalsIgnoreCase("Benz"))
            return new Benz();
        else if (s.equalsIgnoreCase("Bmw"))
            return new Bmw();
        else
            throw new Exception();
    }
}
