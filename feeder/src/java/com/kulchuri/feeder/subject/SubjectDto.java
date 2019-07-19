package com.kulchuri.feeder.subject;

import java.io.Serializable;

public class SubjectDto implements Serializable {

    private int sid, bid, sem;
    private String sname;

    public SubjectDto() {
        sname = "";
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
