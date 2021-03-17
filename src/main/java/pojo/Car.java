package pojo;

public class Car {
    private String carName;

    public Car() {
        System.out.println("car类被创建了。。。");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
