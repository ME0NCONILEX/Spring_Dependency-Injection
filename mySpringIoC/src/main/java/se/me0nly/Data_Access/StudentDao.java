package se.me0nly.Data_Access;

import se.me0nly.Exception.DataNotFoundException;
import se.me0nly.Models.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student find(int id) throws DataNotFoundException;
    List<Student> findAll();
    void delete(int id) throws DataNotFoundException;
}
