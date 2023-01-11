package se.me0nly.Service;

import se.me0nly.Models.Student;

import java.util.List;

public interface StudentManagement {
    Student create();
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);
}
