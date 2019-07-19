package com.kulchuri.feeder.student;

import com.kulchuri.feeder.db.FeederDb;
import com.kulchuri.feeder.utility.FeederPassword;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

public class StudentDao {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;

    public StudentDao() {
    }

    public boolean addStudent(StudentDto dto, InputStream photo) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "insert into student_master(eno ,name, mno, email, pwd, gender, photo, bid, sem, dob) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getEno());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getMno());
            ps.setString(4, dto.getEmail());
            ps.setString(5, FeederPassword.encrypt(dto.getPwd()));
            ps.setString(6, dto.getGender());
            ps.setBlob(7, photo);
            ps.setInt(8, dto.getBid());
            ps.setInt(9, dto.getSem());
            ps.setString(10, dto.getDob());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addStudent():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean updatePhoto(String eno, InputStream photo) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "update student_master set photo=? where eno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setBlob(1, photo);
            ps.setString(2, eno);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at updatePhoto():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean updateStudent(StudentDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "update student_master set name=?, mno=?, email=?, gender=?,bid=?, sem=?, dob=? where eno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getMno());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getGender());
            ps.setInt(5, dto.getBid());
            ps.setInt(6, dto.getSem());
            ps.setString(7, dto.getDob());
            ps.setString(8, dto.getEno());
            System.err.println("name:" + dto.getName());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at updateStudent():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<StudentDto> getAllStudents() {
        ArrayList<StudentDto> al = new ArrayList<>();
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        try {
            rs = conn.prepareStatement("select *from student_master").executeQuery();
            StudentDto dto;
            while (rs.next()) {
                dto = new StudentDto();
                dto.setEno(rs.getString("eno"));
                dto.setEmail(rs.getString("email"));
                dto.setMno(rs.getString("mno"));
                dto.setGender(rs.getString("gender"));
                dto.setSem(rs.getInt("sem"));
                dto.setBid(rs.getInt("bid"));
                dto.setDob(rs.getString("dob"));
                dto.setName(rs.getString("name"));
                dto.setPhoto(Base64.getEncoder().encodeToString(rs.getBytes("photo")));
                al.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllStudents():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            if (al.isEmpty()) {
                al = null;
            }
            return al;
        }
    }

    public boolean deleteStudent(String eno) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        try {
            ps = conn.prepareStatement("delete from student_master where eno=?");
            ps.setString(1, eno);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at deleteStudent():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public StudentDto getStudent(String eno) {
        StudentDto dto = null;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        try {
            ps = conn.prepareStatement("select *from student_master where eno=?");
            ps.setString(1, eno);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = new StudentDto();
                dto.setEno(rs.getString("eno"));
                dto.setEmail(rs.getString("email"));
                dto.setMno(rs.getString("mno"));
                dto.setGender(rs.getString("gender"));
                dto.setSem(rs.getInt("sem"));
                dto.setBid(rs.getInt("bid"));
                dto.setDob(rs.getString("dob"));
                dto.setName(rs.getString("name"));
                dto.setPhoto(Base64.getEncoder().encodeToString(rs.getBytes("photo")));
            }
        } catch (Exception e) {
            System.out.println("Exception at getStudent():" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return dto;
        }
    }

    public boolean login(String uname, String pwd) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        try {
            ps = conn.prepareStatement("select *from student_master eno=? and pwd=?");
            ps.setString(1, uname);
            ps.setString(2, pwd);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at login():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }
}
