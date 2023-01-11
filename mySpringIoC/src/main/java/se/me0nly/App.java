package se.me0nly;

import se.me0nly.Config.AppConfig;
import se.me0nly.Data_Access.StudentDao;
import se.me0nly.Exception.DataNotFoundException;
import se.me0nly.Models.Student;
import se.me0nly.Service.StudentManagement;
import se.me0nly.myUtil.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        UserInputService userInputService = context.getBean(UserInputService.class);

        Student Me = studentDao.save(new Student("0nly"));
        Student My = studentDao.save(new Student("NewName"));
        Student New = studentDao.save(new Student("Student"));

        System.out.println(studentDao.findAll());

        System.out.println("===============================================================");

        try {
            Student studentById = studentDao.find(3);
            System.out.println(studentById);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===============================================================" + " \n");

        try {
            studentDao.delete(3);
        } catch (DataNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(studentDao.findAll());
        System.out.println("===============================================================");

        Student student = studentManagement.create();
        System.out.println(student);
        System.out.println("===============================================================" + " \n");
        studentManagement.save(student);
        System.out.println("===============================================================");
        System.out.println(studentManagement.findAll());
        System.out.println("===============================================================");
        System.out.println(studentManagement.find(1));
        System.out.println("===============================================================");
        studentManagement.remove(1);
        System.out.println(studentManagement.findAll());
    }
}
