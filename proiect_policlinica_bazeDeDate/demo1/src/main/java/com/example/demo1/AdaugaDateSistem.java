package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class AdaugaDateSistem
{
    @FXML
    private Button anuleazaADS;
    @FXML
    private Button anuleazaADA;
    @FXML
    private Button anuleazaADM;

    @FXML
    private Button updateADS;
    @FXML
    private Button updateADA;
    @FXML
    private Button updateADM;

    @FXML
    private TextField adresaADS;

    @FXML
    private TextField cnpADS;

    @FXML
    private TextField contractADS;

    @FXML
    private TextField dataADS;

    @FXML
    private TextField emailADS;

    @FXML
    private TextField ibanADS;

    @FXML
    private TextField numeADS;

    @FXML
    private TextField parolaADS;

    @FXML
    private TextField prenumeADS;

    @FXML
    private TextField rolADS;

    @FXML
    private TextField salariuADS;

    @FXML
    private TextField telADS;

    @FXML
    private TextField idADS;

    @FXML
    private TextField adresaADM;


    @FXML
    private TextField cnpADM;

    @FXML
    private TextField codADM;

    @FXML
    private TextField competenteADM;

    @FXML
    private TextField contractADM;

    @FXML
    private TextField dataADM;

    @FXML
    private TextField emailADM;

    @FXML
    private TextField gradADM;

    @FXML
    private TextField ibanADM;

    @FXML
    private TextField idADM;

    @FXML
    private TextField numeADM;

    @FXML
    private TextField parolaADM;

    @FXML
    private TextField postADM;

    @FXML
    private TextField prenumeADM;

    @FXML
    private TextField procentADM;

    @FXML
    private TextField rolADM;

    @FXML
    private TextField salariuADM;

    @FXML
    private TextField specialitateADM;

    @FXML
    private TextField telADM;

    @FXML
    private TextField titluADM;
    private int id;

    @FXML
    private TextField adresaADA;

    @FXML
    private TextField cnpADA;

    @FXML
    private TextField contractADA;

    @FXML
    private TextField dataADA;

    @FXML
    private TextField emailADA;

    @FXML
    private TextField gradADA;

    @FXML
    private TextField ibanADA;

    @FXML
    private TextField idADA;

    @FXML
    private TextField numeADA;

    @FXML
    private TextField parolaADA;

    @FXML
    private TextField prenumeADA;

    @FXML
    private TextField rolADA;

    @FXML
    private TextField salariuADA;

    @FXML
    private TextField telADA;

    @FXML
    private TextField tipADA;

    @FXML
    private Label mesajFinalAdd;

    int ok=0;

    public void setID(int id) {
        this.id=id;
    }


    public void updateADSOnAction(ActionEvent e) throws SQLException {
            adaugaAngajat(id);
    }

    public void updateADAOnAction(ActionEvent e) throws SQLException {
            adaugaAsistent(id);
    }

    public void updateADMOnAction(ActionEvent e) throws SQLException {
            adaugaMedic(id);
    }

    public void adaugaAngajat(int id) throws SQLException{
        ok=0;
        if(idADS.getText().isBlank()==false && cnpADS.getText().isBlank()==false && contractADS.getText().isBlank()==false &&numeADS.getText().isBlank()==false &&
                prenumeADS.getText().isBlank()==false &&parolaADS.getText().isBlank()==false &&telADS.getText().isBlank()==false &&
                emailADS.getText().isBlank()==false &&ibanADS.getText().isBlank()==false &&rolADS.getText().isBlank()==false &&
                contractADS.getText().isBlank()==false && dataADS.getText().isBlank()==false && salariuADS.getText().isBlank()==false ){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String s=salariuADS.getText();
            int salariu=Integer.parseInt(s);
            String anga;
            if(rolADS.getText().equals("hr")){
                 anga="HR";
            }
            else if(rolADS.getText().equals("receptioner")){
                anga="RECEPTIONER";
            }
            else if(rolADS.getText().equals("economic")){
                 anga="ECONOMIC";
            }
            else{
                anga="ADMIN";
            }
           // String addDataUtilizatori = "INSERT INTO utilizatori (ID_Utilizator,CNP, Parola, Nume, Prenume, Adresa, Telefon, Email, Cont_IBAN, Numar_Contract, Data_Angajarii, rol_user) VALUES ("+idADS.getText() +",'"+cnpADS.getText() +"','"+parolaADS.getText() +"','"+numeADS.getText() +"'," +
              //      ",'"+prenumeADS.getText() +"','"+adresaADS.getText() +"','"+telADS.getText() +"','"+emailADS.getText() +"','"+ibanADS.getText() +"','"+contractADS.getText() +"','"+dataADS.getText() +"','"+rolADS.getText() +"')";
            String addDataUtilizatori="INSERT INTO utilizatori (ID_Utilizator,CNP, Parola, Nume, Prenume, Adresa, Telefon, Email, Cont_IBAN, Numar_Contract, Data_Angajarii, rol_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          //  String addDataAngajati ="INSERT INTO angajati (ID_Angajat, Salariu, Ore_Lucrate, Tip_Angajati, ID_Utilizator) VALUES("+idADS.getText() +",salariu,0,anga,"+idADS.getText() +")";
            String addDataAngajati ="INSERT INTO angajati (ID_Angajat, Salariu, Ore_Lucrate, Tip_Angajati, ID_Utilizator) VALUES(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataUtilizatori) ) {

                preparedStatement.setInt(1, Integer.parseInt(idADS.getText()));
                preparedStatement.setString(2, cnpADS.getText());
                preparedStatement.setString(3, parolaADS.getText());
                preparedStatement.setString(4, numeADS.getText());
                preparedStatement.setString(5, prenumeADS.getText());
                preparedStatement.setString(6, adresaADS.getText());
                preparedStatement.setString(7, telADS.getText());
                preparedStatement.setString(8, emailADS.getText());
                preparedStatement.setString(9, ibanADS.getText());
                preparedStatement.setString(10, contractADS.getText());
                preparedStatement.setString(11, dataADS.getText());
                preparedStatement.setString(12, anga);
                preparedStatement.executeUpdate();

                try (PreparedStatement preparedStatement2 = connectDB.prepareStatement(addDataAngajati)){

                    preparedStatement2.setInt(1, Integer.parseInt(idADS.getText()));
                    preparedStatement2.setInt(2, Integer.parseInt(salariuADS.getText()));
                    preparedStatement2.setInt(3, 0);
                    preparedStatement2.setString(4, anga);
                    preparedStatement2.setInt(5, Integer.parseInt(idADS.getText()));
                    preparedStatement2.executeUpdate();
                    ok=1;
                }
            }
        }

        if(ok==1){
            mesajFinalAdd.setText("Adaugare realizata cu succes!");
        }
        else {
            mesajFinalAdd.setText("Nu s-au produs modificari!");
        }

    }

    public void adaugaMedic(int id) throws SQLException{
        ok=0;
        if(idADM.getText().isBlank()==false && numeADM.getText().isBlank()==false && prenumeADM.getText().isBlank()==false &&parolaADM.getText().isBlank()==false &&
                cnpADM.getText().isBlank()==false &&adresaADM.getText().isBlank()==false &&telADM.getText().isBlank()==false &&
                emailADM.getText().isBlank()==false &&ibanADM.getText().isBlank()==false &&rolADM.getText().isBlank()==false &&
                contractADM.getText().isBlank()==false && salariuADM.getText().isBlank()==false && specialitateADM.getText().isBlank()==false&&
                gradADM.getText().isBlank()==false &&competenteADM.getText().isBlank()==false &&codADM.getText().isBlank()==false &&
                titluADM.getText().isBlank()==false && postADM.getText().isBlank()==false && procentADM.getText().isBlank()==false &&dataADM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String s=salariuADM.getText();
            int salariu=Integer.parseInt(s);
            String anga="MEDIC";
            String addDataUtilizatori="INSERT INTO utilizatori (ID_Utilizator,CNP, Parola, Nume, Prenume, Adresa, Telefon, Email, Cont_IBAN, Numar_Contract, Data_Angajarii, rol_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String addDataAngajati ="INSERT INTO angajati (ID_Angajat, Salariu, Ore_Lucrate, Tip_Angajati, ID_Utilizator) VALUES(?,?,?,?,?)";
           // String addDataMedic ="INSERT INTO medici (ID_Medic, ID_Angajat, Specialitate, Grad_Medic, Cod_Parafa, Competente, Titlu_Stiintific, Post_Didactic, Procent_Servicii) VALUES( '"+idADM.getText() +"','"+idADM.getText() +"'," +
                 //   "'"+specialitateADM.getText() +"', '"+gradADM.getText() +"', '"+codADM.getText() +"', '"+competenteADM.getText() +"', '"+titluADM.getText() +"', '"+postADM.getText() +"', '"+procentADM.getText() +"')";
            String addDataMedic ="INSERT INTO medici (ID_Medic, ID_Angajat, Specialitate, Grad_Medic, Cod_Parafa, Competente, Titlu_Stiintific, Post_Didactic, Procent_Servicii) VALUES(?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataUtilizatori) ) {

                preparedStatement.setInt(1, Integer.parseInt(idADM.getText()));
                preparedStatement.setString(2, cnpADM.getText());
                preparedStatement.setString(3, parolaADM.getText());
                preparedStatement.setString(4, numeADM.getText());
                preparedStatement.setString(5, prenumeADM.getText());
                preparedStatement.setString(6, adresaADM.getText());
                preparedStatement.setString(7, telADM.getText());
                preparedStatement.setString(8, emailADM.getText());
                preparedStatement.setString(9, ibanADM.getText());
                preparedStatement.setString(10, contractADM.getText());
                preparedStatement.setString(11, dataADM.getText());
                preparedStatement.setString(12, anga);
                preparedStatement.executeUpdate();

                try (PreparedStatement preparedStatement2 = connectDB.prepareStatement(addDataAngajati)){

                    preparedStatement2.setInt(1, Integer.parseInt(idADM.getText()));
                    preparedStatement2.setInt(2, Integer.parseInt(salariuADM.getText()));
                    preparedStatement2.setInt(3, 0);
                    preparedStatement2.setString(4, anga);
                    preparedStatement2.setInt(5, Integer.parseInt(idADM.getText()));
                    preparedStatement2.executeUpdate();

                    try (PreparedStatement preparedStatement3 = connectDB.prepareStatement(addDataMedic)){

                        preparedStatement3.setInt(1, Integer.parseInt(idADM.getText()));
                        preparedStatement3.setInt(2, Integer.parseInt(idADM.getText()));
                        preparedStatement3.setString(3, specialitateADM.getText());
                        preparedStatement3.setString(4, gradADM.getText());
                        preparedStatement3.setString(5, codADM.getText());
                        preparedStatement3.setString(6, competenteADM.getText());
                        preparedStatement3.setString(7, titluADM.getText());
                        preparedStatement3.setString(8, postADM.getText());
                        preparedStatement3.setInt(9, Integer.parseInt(procentADM.getText()));
                        preparedStatement3.executeUpdate();
                        ok=1;
                    }
                }
            }
        }
        if(ok==1){
            mesajFinalAdd.setText("Adaugare realizata cu succes!");
        }
        else {
            mesajFinalAdd.setText("Nu s-au produs modificari!");
        }

    }

    public void adaugaAsistent(int id) throws SQLException{
        ok=0;
        if(idADA.getText().isBlank()==false && numeADA.getText().isBlank()==false && prenumeADA.getText().isBlank()==false && parolaADA.getText().isBlank()==false &&
                cnpADA.getText().isBlank()==false &&adresaADA.getText().isBlank()==false &&telADA.getText().isBlank()==false &&
                emailADA.getText().isBlank()==false &&contractADA.getText().isBlank()==false &&ibanADA.getText().isBlank()==false &&
                rolADA.getText().isBlank()==false && dataADA.getText().isBlank()==false&&
                salariuADA.getText().isBlank()==false &&gradADA.getText().isBlank()==false &&tipADA.getText().isBlank()==false ){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String s=salariuADA.getText();
            int salariu=Integer.parseInt(s);
            String anga="ASISTENT";
            String addDataUtilizatori="INSERT INTO utilizatori (ID_Utilizator,CNP, Parola, Nume, Prenume, Adresa, Telefon, Email, Cont_IBAN, Numar_Contract, Data_Angajarii, rol_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String addDataAngajati ="INSERT INTO angajati (ID_Angajat, Salariu, Ore_Lucrate, Tip_Angajati, ID_Utilizator) VALUES(?,?,?,?,?)";
           // String addDataAsistent ="INSERT INTO proiect.asistentimedicali ( ID_Asistent, Tip_Asistent, Grad_Asistent, ID_Angajat) VALUES( '"+idADA.getText() +"','"+tipADA.getText() +"'," +
                 //   "'"+gradADA.getText() +"', '"+idADA.getText() +"')";
            String addDataAsistent ="INSERT INTO proiect.asistentimedicali ( ID_Asistent, Tip_Asistent, Grad_Asistent, ID_Angajat) VALUES(?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataUtilizatori) ) {

                preparedStatement.setInt(1, Integer.parseInt(idADA.getText()));
                preparedStatement.setString(2, cnpADA.getText());
                preparedStatement.setString(3, parolaADA.getText());
                preparedStatement.setString(4, numeADA.getText());
                preparedStatement.setString(5, prenumeADA.getText());
                preparedStatement.setString(6, adresaADA.getText());
                preparedStatement.setString(7, telADA.getText());
                preparedStatement.setString(8, emailADA.getText());
                preparedStatement.setString(9, ibanADA.getText());
                preparedStatement.setString(10, contractADA.getText());
                preparedStatement.setString(11, dataADA.getText());
                preparedStatement.setString(12, anga);
                preparedStatement.executeUpdate();

                try (PreparedStatement preparedStatement2 = connectDB.prepareStatement(addDataAngajati)){

                    preparedStatement2.setInt(1, Integer.parseInt(idADA.getText()));
                    preparedStatement2.setInt(2, Integer.parseInt(salariuADA.getText()));
                    preparedStatement2.setInt(3, 0);
                    preparedStatement2.setString(4, anga);
                    preparedStatement2.setInt(5, Integer.parseInt(idADA.getText()));
                    preparedStatement2.executeUpdate();

                    try (PreparedStatement preparedStatement3 = connectDB.prepareStatement(addDataAsistent)){

                        preparedStatement3.setInt(1, Integer.parseInt(idADA.getText()));
                        preparedStatement3.setString(2, tipADA.getText());
                        preparedStatement3.setString(3, gradADA.getText());
                        preparedStatement3.setInt(4, Integer.parseInt(idADA.getText()));
                        preparedStatement3.executeUpdate();
                        ok=1;
                    }
                }
            }
        }
        if(ok==1){
            mesajFinalAdd.setText("Adaugare realizata cu succes!");
        }
        else {
            mesajFinalAdd.setText("Nu s-au produs modificari!");
        }

    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) anuleazaADS.getScene().getWindow();
        stage.close();
    }


}
