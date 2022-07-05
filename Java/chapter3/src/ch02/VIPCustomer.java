package ch02;

public class VIPCustomer extends Customer{

    double salesRatio;
    private String agentID;
    public VIPCustomer(){
        customerGrade ="VIP";
        bonusRatio=0.05;
        salesRatio =0.1;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price*bonusRatio;
        return (int)(price - salesRatio*price);
    }

    public String getAgentID(){
        return agentID;
    }

	

}
