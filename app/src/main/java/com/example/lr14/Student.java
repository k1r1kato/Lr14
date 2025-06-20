package com.example.lr14;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String group;
    private int score;

    public Student(String name, String group, int score) {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", score=" + score +
                '}';
    }
}