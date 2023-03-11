package Students.model;

import org.springframework.stereotype.Component;


public class Students {

    private String id;
    private String name;
    private String major;
    private double gpa;
    private String gender;

    public Students(String id, String name, String major, double gpa, String gender) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.gender = gender;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGender() {
        return gender;
    }
}
