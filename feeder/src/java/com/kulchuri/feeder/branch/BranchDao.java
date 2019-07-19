package com.kulchuri.feeder.branch;

import com.kulchuri.feeder.db.FeederDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BranchDao {

    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs = null;

    public boolean addBranch(BranchDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String query = "insert into branch_master (bname) values(?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, dto.getBname());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addBranch():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean updateBranch(BranchDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String query = "update branch_master set bname=? where bid=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, dto.getBname());
            ps.setInt(2, dto.getBid());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at updateBranch():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean checkDuplicateBranch(String bname) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String query = "select bid from branch_master  where bname=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, bname);
            if (ps.executeQuery().next()) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at checkDuplicateBranch():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<BranchDto> getAllBranches() {
        ArrayList<BranchDto> al = new ArrayList<>();
        BranchDto dto;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "select *from branch_master";
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                dto = new BranchDto();
                dto.setBid(rs.getInt("bid"));
                dto.setBname(rs.getString("bname"));
                al.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllBranches():" + e);
        } finally {
            rs = null;
            conn = null;
            if (al.isEmpty()) {
                al = null;
            }
            return al;
        }
    }

    public BranchDto getBranch(int bid) {
        BranchDto dto = null;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "select *from branch_master where bid=" + bid;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            if (rs.next()) {
                dto = new BranchDto();
                dto.setBid(rs.getInt("bid"));
                dto.setBname(rs.getString("bname"));

            }
        } catch (Exception e) {
            System.out.println("Exception at getBranch():" + e);
        } finally {
            rs = null;
            conn = null;
            return dto;
        }
    }

    public boolean deleteBranch(int bid) {
        boolean flag = false;
        if (conn == null) {
            conn = FeederDb.getFeederDb();
        }
        String sql = "delete from branch_master where bid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at deleteBranch():" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

}
