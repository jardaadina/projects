package com.example.demo1;


public class DateAngajati {


    private int  nrContract;
    private String nume, prenume, rol, email, adresa,data,CNP, nrTelefon, iban;

    public DateAngajati(String nume, String prenume, String adresa, String email, String rol, String CNP, String nrTelefon, String iban, int nrContract, String data)
    {
        this.CNP=CNP;
        this.nrTelefon=nrTelefon;
        this.iban=iban;
        this.nrContract=nrContract;
        this.data=data;
        this.nume=nume;
        this.prenume=prenume;
        this.rol=rol;
        this.email=email;
        this.adresa=adresa;
    }

    public DateAngajati(String userNume, String userPrenume, String userAdresa, String userOra, String userData) {
    }


    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setNrContract(int nrContract) {
        this.nrContract = nrContract;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getCNP() {
        return CNP;
    }

    public String getData() {
        return data;
    }

    public String getEmail() {
        return email;
    }

    public String getIban() {
        return iban;
    }

    public int getNrContract() {
        return nrContract;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getRol() {
        return rol;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

}