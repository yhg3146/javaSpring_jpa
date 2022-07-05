package ch19;

public class Car {
    private static int serialNumber =10000;
    private int carNum;

    public Car(){
        serialNumber++;
        this.carNum = serialNumber;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
}
