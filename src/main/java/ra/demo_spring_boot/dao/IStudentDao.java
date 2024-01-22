package ra.demo_spring_boot.dao;

import ra.demo_spring_boot.model.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    boolean save(Student student);
    boolean deleteById(Integer id);
}
