package ch14;

public class Bus {
        private int busnum;
        private int income;
        private int customnum;

        public Bus(int busnum){
                this.busnum=busnum;
        }
        public void take(int wage){
                this.income +=wage;
                customnum++;
        }

        public void showBusinfo(){
                System.out.println(busnum + "번의 승객 수는 " +customnum + "명 이고, 수입은 " + income +"원 입니다.");
        }

}

