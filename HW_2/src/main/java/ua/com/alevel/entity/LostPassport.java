package ua.com.alevel.entity;

public class LostPassport extends LostBase{

    private String lostFirstName;
    private String lostLastName;
    private String lostFatherName;
    private int lostAge;

    public  String getLostFirstName(){
        return lostFirstName;
    }

    public void setLostFirstName(String lostFirstName) {
        this.lostFirstName = lostFirstName;
    }

    public String getLostLastName(){
        return lostLastName;
    }

    public void setLostLastName(String lostLastName) {
        this.lostLastName = lostLastName;
    }

    public String getLostFatherName(){
        return lostFatherName;
    }

    public void setLostFatherName(String lostFatherName) {
        this.lostFatherName = lostFatherName;
    }

    public int getLostAge(){
        return lostAge;
    }

    public void setLostAge(int lostAge) {
        if (lostAge > 0) {
            this.lostAge = lostAge;
        }
    }
}
