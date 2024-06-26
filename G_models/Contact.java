package G_models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact(String name,String phoneNumber,String birthDate)throws ParseException {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank.");
        }
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank.");
        }
        if(phoneNumber.length() < 5){
            throw new IllegalArgumentException("Phone number cannot be less than 5 characters. ");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);

    }
    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank.");
        }
        if(phoneNumber.length() < 5){
            throw new IllegalArgumentException("Phone number cannot be less than 5 characters. ");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) throws ParseException{
        this.birthDate = birthDate;
        setAge(toAge(birthDate));

    }

    public void setAge(int age) {
        this.age = age;
    }

    public int toAge(String birthDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        //Date toDate = formatter.parse(birthDate);
        //long toMilli = toDate.getTime();
        //long diff = new Date().getTime() - toMilli;
        //Or
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime();
        //this.age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);

    }


    public String toString() {
        return "Name= " + this.name + "\n" +
                "PhoneNumber= " + this.phoneNumber + "\n" +
                "BirthDate= " + this.birthDate + "\n" +
                "Age=" + this.age + "years old\n";
    }
}
