package com.kulchuri.feeder.faculty;
import com.kulchuri.feeder.branch.BranchDao;
import com.kulchuri.feeder.db.FeederDb;
import com.kulchuri.feeder.utility.FeederDate;
import com.kulchuri.feeder.utility.FeederPassword;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class FacultyDao {

    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;

    public FacultyDao() {
    }

    public String addFaculty(FacultyDto dto) {
        String fid = null;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "insert into faculty_master(fid, name, email, pwd, gender, mno, doj, dob, address, exp,bid) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            int t = 0;

            rs = conn.prepareStatement("SELECT count(name) as total FROM faculty_master").executeQuery();
            if (rs.next()) {
                t = rs.getInt("total");
            }
            t++;
            rs = null;
            String branch = new BranchDao().getBranch(dto.getBid()).getBname();
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String eno = branch + year + t;
            ps = conn.prepareStatement(sql);
            ps.setString(1, eno);
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getEmail());
            ps.setString(4, FeederPassword.encrypt(dto.getPwd()));
            ps.setString(5, dto.getGender());
            ps.setString(6, dto.getMno());
            ps.setString(7, FeederDate.getCurrentDate());
            ps.setString(8, dto.getDob());
            ps.setString(9, dto.getAddress());
            ps.setInt(10, dto.getExp());
            ps.setInt(11, dto.getBid());
            if (ps.executeUpdate() > 0) {
                fid = eno;
            }
        } catch (Exception e) {
            System.out.println("Exception at addFaculty():" + e);
        } finally {
            ps = null;
            conn = null;
            return fid;
        }
    }

    public boolean addPhoto(String fid, InputStream photo) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        try {
            ps = conn.prepareStatement("update faculty_master set photo=? where fid=?");
            ps.setBlob(1, photo);
            ps.setString(2, fid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addPhoto():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public static void main(String[] args) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year);
    }
}
