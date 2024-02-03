package ua.com.alevel.Entity;

public class EntityGetCred {
    private String login;
    private String firstName;
    private String lastName;
    private String surName;
    private int yearOfBirth;
    private int monthOfBirth;
    private int dayOfBirth;
    private int idOfPassport;
    private int sumOfCredit;

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }



    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getSurName(){
        return surName;
    }

    public void setSurName(String surName){
        this.surName = surName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth >= 1940 ){
            this.yearOfBirth = yearOfBirth;
        }
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        if (monthOfBirth >= 1 && monthOfBirth <= 12){
            this.monthOfBirth = monthOfBirth;
        }
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        if (dayOfBirth >= 1 && dayOfBirth <= 30){
            this.dayOfBirth = dayOfBirth;
        }
    }

    public int getIdOfPassport() {
        return idOfPassport;
    }

    public void setIdOfPassport(int idOfPassport) {
        if (idOfPassport >= 10000000 && idOfPassport <= 99999999){
            this.idOfPassport = idOfPassport;
        }
    }

    public int getSumOfCredit() {
        return sumOfCredit;
    }

    public void setSumOfCredit(int sumOfCredit) {
        if (sumOfCredit >= 1000 && sumOfCredit <= 1000000){
            this.sumOfCredit = sumOfCredit;
        }
    }
}
