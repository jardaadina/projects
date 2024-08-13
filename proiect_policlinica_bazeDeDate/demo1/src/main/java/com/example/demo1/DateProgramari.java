package com.example.demo1;

public class DateProgramari
{
    String nume, prenume, data, ora,medic;


    public DateProgramari(String nume, String prenume, String data, String ora, String medic) {
        this.nume = nume;
        this.prenume = prenume;
        this.data = data;
        this.ora = ora;
        this.medic=medic;

    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }



    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }
}