package com.arabie;

public class Student {
    private String name;
    private int classNo;
    private String grade;

    public Student(String name, int classNo, String grade) {
        this.name = name;
        this.classNo = classNo;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNo=" + classNo +
                ", grade='" + grade + '\'' +
                "}\n";
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
