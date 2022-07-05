package ch14;

public class TakeTransTest {

    public static void main(String[] args) {


        Student studentJ = new Student("James",5000);
        Student studentT = new Student("Tomas",10000);

        Bus bus100=new Bus(100);
        Subway subwaygreen = new Subway("초록색");

        studentJ.takeBus(bus100);
        studentT.takeSubway(subwaygreen);

        studentJ.showStudentInfo();
        studentT.showStudentInfo();
        bus100.showBusinfo();
        subwaygreen.showSubwayinfo();
    }







}
