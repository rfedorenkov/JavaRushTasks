package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream()
                .filter(student -> student.getAverageGrade() == averageGrade)
                .findFirst().orElse(null);
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = students.stream()
                .mapToDouble(Student::getAverageGrade).max().orElse(0.0);
        return getStudentWithAverageGrade(max);
    }

    public Student getStudentWithMinAverageGrade() {
        double min = students.stream()
                .mapToDouble(Student::getAverageGrade).min().orElse(0.0);
        return getStudentWithAverageGrade(min);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}