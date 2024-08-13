package com.example.demo1;

public class DateSalariiAngajati {

    String nume, prenume, salariu;

    public DateSalariiAngajati(String nume, String prenume, String salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setSalariu(String salariu) {
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getSalariu() {
        return salariu;
    }
}