package com.example.pangling.appsjamu.model;

import java.util.List;

/**
 * Created by Pangling on 10/26/2017.
 */
public class Value {
    String value;
    String message;
    List<Akun> akun;
    List<Bekas> ambilH;
    List<Mahasiswa> result;
    List<ListArtikel> ambilA;

    public List<Bekas> getAmbilH() {
        return ambilH;
    }

    public String getValue() {
        return value;

    }

    public List<ListArtikel> getAmbilA() {
        return ambilA;
    }

    public String getMessage() {
        return message;
    }

    public List<Akun> getAkun() {
        return akun;
    }

    public List<Mahasiswa> getResult(){
        return result;
    }
}
