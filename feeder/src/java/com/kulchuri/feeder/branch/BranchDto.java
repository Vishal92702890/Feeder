package com.kulchuri.feeder.branch;

import java.io.Serializable;

public class BranchDto implements Serializable {

    private int bid;
    private String bname;

    public BranchDto() {
        bname = "";
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
