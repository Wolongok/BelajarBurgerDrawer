package com.example.burgerdrawerfoodlist;

public class Model {
    String img;
    String nama;

    public Model(String nama, String img) {
        this.img = img;
        this.nama = nama;
    }

    public String getImg() {
        return img;
    }

    public String getNama() {
        return nama;
    }
}
