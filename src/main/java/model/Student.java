package model;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String location;
    private int sdt;
    private String gmail;
    public Student() {

    }
    public Student(String id, String name, String location, int sdt, String gmail) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.sdt = sdt;
        this.gmail = gmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", sdt=" + sdt +
                ", gmail='" + gmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && sdt == student.sdt && Objects.equals(name, student.name) && Objects.equals(location, student.location) && Objects.equals(gmail, student.gmail);
    }
}
