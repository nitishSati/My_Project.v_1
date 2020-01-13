package com.example.studentmanagementsystem.model;


public class Student {
    private String name;
    private String ids;
    public Student(String name, String ids){
        this.name=name;
        this.ids=ids;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return ids;
    }

}
