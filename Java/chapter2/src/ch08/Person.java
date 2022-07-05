package ch08;

public class Person {

    public String name;
    public int age;
    public float height;
    public float weight;

    public String sex;

    public Person(String name,int age,float height,float weight,String sex){
        this.name=name;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.sex=sex;
    }

    public void showPersonInfo(){
        System.out.println("키가 "+height+" 이고 몸무게가 " + weight +" 킬로인" +sex+"이 있습니다. 이름은 "+name +"이고 나이는 "+age+"세입니다.");
    }
}
