package ch14;

public class Subway {
        private String subname;
        private int income;
        private int cusnum;

        public Subway(String subname){
            this.subname=subname;

        }

        public void take(int wage){
            this.income +=wage;
            cusnum++;
        }

        public void showSubwayinfo(){
        System.out.println(subname + "노선의 승객 수는 " +cusnum + "명 이고, 수입은 " + income +"원 입니다.");
    }
}
