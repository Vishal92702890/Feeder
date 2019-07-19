package com.kulchuri.feeder.subject;

import com.kulchuri.feeder.db.FeederDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectDao {

    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;

    public SubjectDao() {
    }

    public boolean addSubject(SubjectDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "insert into subject_master(bid, sname, sem) values(?,?,?)";
        try {
            System.out.println("sxhxvsh");
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getBid());
            ps.setString(2, dto.getSname());
            ps.setInt(3, dto.getSem());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addSubject():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }
}
