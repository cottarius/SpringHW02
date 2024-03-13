package ru.cotarius.springcourse.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
        students.add(new Student("John", "Travolta", "actor"));
        students.add(new Student("Bruce", "Willis", "actor"));
        students.add(new Student("Uma", "Thurman", "actor"));
        students.add(new Student("Michael", "Bay", "producer"));
        students.add(new Student("Jerry", "Bruckheimer", "producer"));
        students.add(new Student("John", "Davis", "producer"));
        students.add(new Student("Julia", "Roberts", "actor"));
    }

    public List<Student> getAllStudents() {
        return students;
    }
    public Student getById (int id){
        return students.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }
    public List<Student> getByGroupName (String groupName) {
        return students.stream().filter(student -> student.getGroupName().equals(groupName)).toList();
    }
    public List<Student> getByName(String name){
        return students.stream().filter(student -> student.getName().equals(name)).toList();
    }

}
