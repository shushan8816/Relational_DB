package models;

public class User {
    private int ID;
    private String name;
    private String email;
    private String phone;
    private String country;
    private int age;

    public User() {
    }

    public User(int ID, String name, String email, String phone, String country, int age) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getUserInfo() {
        return String.format("user {ID: %d, Name: %s, Email: %s, Phone: %s, Country: %s, Age: %d}",
                getID(), getName(), getEmail(), getPhone(), getCountry(), getAge());
    }
    @Override
    public String toString() {
        return "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age;
    }
}
