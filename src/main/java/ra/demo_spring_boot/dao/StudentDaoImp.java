package ra.demo_spring_boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ra.demo_spring_boot.model.Student;
import ra.demo_spring_boot.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements IStudentDao {
    @Autowired
    private ConnectDB connectDB;
    @Override
    public List<Student> findAll() {
        List<Student> newStudentList = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            newStudentList = new ArrayList<>();
            conn = connectDB.openConnection();
            callSt = conn.prepareCall("select * from student");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthday(rs.getDate("birthdate"));
                student.setPhoneNb(rs.getString("phone_nb"));
                student.setAddress(rs.getString("address"));
                student.setImgUrl(rs.getString("img_url"));
                newStudentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return newStudentList;
    }

    @Override
    public Student findById(Integer id) {
        Student student = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = connectDB.openConnection();
            callSt = conn.prepareCall("select * from student whwere student_id = ?");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthday(rs.getDate("birthdate"));
                student.setPhoneNb(rs.getString("phone_nb"));
                student.setAddress(rs.getString("address"));
                student.setImgUrl(rs.getString("img_url"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean save(Student student) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean result = false;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = connectDB.openConnection();
            callSt = conn.prepareCall("delete from student where student_id = ?");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
