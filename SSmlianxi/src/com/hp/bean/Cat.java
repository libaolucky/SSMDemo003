package com.hp.bean;

public class Cat {
    private Integer catid;
    private String catSex;

    @Override
    public String toString() {
        return "cat{" +
                "catid=" + catid +
                ", catSex='" + catSex + '\'' +
                '}';
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getCatSex() {
        return catSex;
    }

    public void setCatSex(String catSex) {
        this.catSex = catSex;
    }
}
