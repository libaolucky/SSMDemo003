package com.hp.bean;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private String lname;
    private String pwd;
    private List<Goodfirend> goodfirends;
    private Integer[] aihao;

    @Override
    public String toString() {
        return "Login{" +
                "lname='" + lname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", goodfirends=" + goodfirends +
                ", aihao=" + Arrays.toString(aihao) +
                '}';
    }

    public List<Goodfirend> getGoodfirends() {
        return goodfirends;
    }

    public void setGoodfirends(List<Goodfirend> goodfirends) {
        this.goodfirends = goodfirends;
    }

    public Integer[] getAihao() {
        return aihao;
    }

    public void setAihao(Integer[] aihao) {
        this.aihao = aihao;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}