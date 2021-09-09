/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author fsoft
 */
public class StudentDAO extends BaseDAO<Student> {

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "  FROM [Student]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getBoolean("gender"));
                s.setDob(rs.getDate("dob"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public Student getStudent(int id) {
        try {
            String sql = "SELECT s.id,s.name,s.gender,s.dob FROM Student s\n"
                    + "WHERE s.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertStudent(Student s) {
        try {
            String sql = "  insert into Student\n"
                    + "  values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getName());           
            statement.setBoolean(2, s.isGender());
            statement.setDate(3, s.getDob());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStudent(Student s) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + " WHERE [id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getName());
            statement.setDate(2, s.getDob());
            statement.setBoolean(3, s.isGender());
            statement.setInt(4, s.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(int id) {
        try {
            String sql = "DELETE Student WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLast() {
        int id = 0;
        try {
            String sql = "select top 1 id from Student \n"
                    + "  order by id desc";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
        }
        return id;
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<Student> students = new ArrayList<>();
        StudentDAO dao = new StudentDAO();
        dao.getAll();
        //        for (Student s : students) {
        //            System.out.println(s);
        //        }
      //  System.out.println(dao.getLast());
      // chèn thử thôi
        Student a = new Student();
        int id = dao.getLast()+1;
        String name = "Dương Thị Thương";
        boolean gender = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse("2002-02-20");
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
        Student d = new Student(id, name, gender, sql);
        dao.insertStudent(d);
    }

}
