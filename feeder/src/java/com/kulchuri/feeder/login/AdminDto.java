package com.kulchuri.feeder.login;

import java.io.Serializable;

public class AdminDto implements Serializable {

    private String uname, pwd, ltype;

    public AdminDto() {
        uname = pwd = ltype = "";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }
}
