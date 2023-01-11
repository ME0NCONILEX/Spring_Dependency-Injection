package se.me0nly.Service;

import se.me0nly.Data_Access.StudentDao;
import se.me0nly.Exception.DataNotFoundException;
import se.me0nly.Models.Student;
import se.me0nly.myUtil.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {
    UserInputService scannerService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter your full name");
        String userName = scannerService.getString();
        return new Student(userName);
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("student was null");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        if(id <= 0 ) throw new IllegalArgumentException("Id was not valid");
        try {
            return studentDao.find(id);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student remove(int id) {
        if(id <= 0 ) throw new IllegalArgumentException("Id was not valid");
        try {
            studentDao.delete(id);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student == null) throw new IllegalArgumentException("student was null");
        if(student.getId() == 0) throw new IllegalArgumentException("student id should not be empty or zero");
        studentDao.save(student);
        return student;
    }
}
