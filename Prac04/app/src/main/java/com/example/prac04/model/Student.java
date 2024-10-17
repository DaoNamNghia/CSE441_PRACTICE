package com.example.prac04.model;

public class Student {
    private String name;  // Họ tên
    private String mssv;  // Mã sinh viên
    private String className; // Lớp
    private double gpa; // Điểm trung bình

    // Constructor rỗng (cần thiết cho Firebase)
    public Student() {
    }

    // Constructor đầy đủ
    public Student(String name, String mssv, String className, double gpa) {
        this.name = name;
        this.mssv = mssv;
        this.className = className;
        this.gpa = gpa;
    }

    // Getter và Setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

