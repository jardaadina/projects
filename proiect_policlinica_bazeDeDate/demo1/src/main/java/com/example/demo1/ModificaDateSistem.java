package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificaDateSistem {

    @FXML
    private TextField adresaMDS;

    @FXML
    private Button anuleazaMDS;

    @FXML
    private TextField cnpMDS;

    @FXML
    private TextField contractMDS;
    @FXML
    private TextField salariuMDS;

    @FXML
    private TextField dataMDS;

    @FXML
    private TextField emailMDS;

    @FXML
    private TextField ibanMDS;

    @FXML
    private TextField idMDS;

    @FXML
    private Button modificaMDS;

    @FXML
    private TextField numeMDS;

    @FXML
    private TextField parolaMDS;

    @FXML
    private TextField prenumeMDS;

    @FXML
    private TextField rolMDS;

    @FXML
    private TextField telefonMDS;

    @FXML
    private TextField adresaMDSM;

    @FXML
    private TextField cnpMDSM;

    @FXML
    private TextField codMDSM;

    @FXML
    private TextField competenteMDSM;

    @FXML
    private TextField contractMDSM;

    @FXML
    private TextField dataMDSM;

    @FXML
    private TextField emailMDSM;

    @FXML
    private TextField gradMDSM;

    @FXML
    private TextField ibanMDSM;

    @FXML
    private TextField idMDSM;

    @FXML
    private Label mesajFinalMDSM;

    @FXML
    private Label mesajFinalMDS;

    @FXML
    private Button modificaDSM;

    @FXML
    private TextField numeMDSM;

    @FXML
    private TextField parolaMDSM;

    @FXML
    private TextField postMDSM;

    @FXML
    private TextField prenumeMDSM;

    @FXML
    private TextField procentMDSM;

    @FXML
    private TextField rolMDSM;

    @FXML
    private TextField salariuMDSM;

    @FXML
    private TextField specialitateMDSM;

    @FXML
    private TextField telefonMDSM;

    @FXML
    private TextField titluMDSM;

    @FXML
    private TextField adresaMDSA;

    @FXML
    private TextField cnpMDSA;

    @FXML
    private TextField contractMDSA;

    @FXML
    private TextField dataMDSA;

    @FXML
    private TextField emailMDSA;

    @FXML
    private TextField gradMDSA;

    @FXML
    private TextField ibanMDSA;

    @FXML
    private TextField idMDSA;

    @FXML
    private Label mesajFinalMDSA;

    @FXML
    private Button modificaDSA;

    @FXML
    private TextField numeMDSA;

    @FXML
    private TextField parolaMDSA;

    @FXML
    private TextField prenumeMDSA;

    @FXML
    private TextField rolMDSA;

    @FXML
    private TextField salariuMDSA;

    @FXML
    private TextField telefonMDSA;

    @FXML
    private TextField tipMDSA;

    private int id;
    int ok=0;

    public void setID(int id) {
        this.id=id;
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) anuleazaMDS.getScene().getWindow();
        stage.close();
    }

    public void modificaMDSOnAction(ActionEvent e) throws SQLException {
        modificaDate();
    }

    public void modificaDSAOnAction(ActionEvent e) throws SQLException {
        modificaDateAsistent();
    }

    public void modificaDSMOnAction(ActionEvent e) throws SQLException {
        modificaDateMedic();
    }

    public void modificaDate() throws SQLException {
        ok=0;
        if(idMDS.getText().isBlank()==false){
            String s=idMDS.getText();
            int id=Integer.parseInt(s);
        }


        if(numeMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Nume = '"+numeMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(prenumeMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Prenume = '"+prenumeMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(parolaMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Parola = '"+parolaMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(cnpMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set CNP = '"+cnpMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(adresaMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Adresa = '"+adresaMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(telefonMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Telefon = '"+telefonMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(emailMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Email = '"+emailMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ibanMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Cont_IBAN = '"+ibanMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(rolMDS.getText().isBlank()==false){
            String anga;
            if(rolMDS.getText().equals("hr")){
                anga="HR";
            }
            else if(rolMDS.getText().equals("receptioner")){
                anga="RECEPTIONER";
            }
            else if(rolMDS.getText().equals("economic")){
                anga="ECONOMIC";
            }
            else{
                anga="ADMIN";
            }
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set rol_user = '"+anga + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(contractMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Numar_Contract = '"+contractMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(dataMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Data_Angajarii = '"+dataMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(salariuMDS.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update angajati set Salariu = '"+salariuMDS.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(ok==1){
            mesajFinalMDS.setText("Modificare realizata cu succes!");
        }
        else {
            mesajFinalMDS.setText("Nu s-au produs modificari!");
        }

    }

    public void modificaDateAsistent() throws SQLException{
        ok=0;

        if(idMDSA.getText().isBlank()==false){
            String s=idMDSA.getText();
            int id=Integer.parseInt(s);
        }


        if(numeMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Nume = '"+numeMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(prenumeMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Prenume = '"+prenumeMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(parolaMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Parola = '"+parolaMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(cnpMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set CNP = '"+cnpMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(adresaMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Adresa = '"+adresaMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(telefonMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Telefon = '"+telefonMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(emailMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Email = '"+emailMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ibanMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Cont_IBAN = '"+ibanMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(rolMDSA.getText().isBlank()==false){
            String anga;
            if(rolMDSA.getText().equals("hr")){
                anga="HR";
            }
            else if(rolMDSA.getText().equals("receptioner")){
                anga="RECEPTIONER";
            }
            else if(rolMDSA.getText().equals("economic")){
                anga="ECONOMIC";
            }
            else{
                anga="ADMIN";
            }
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set rol_user = '"+anga + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(contractMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Numar_Contract = '"+contractMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(dataMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Data_Angajarii = '"+dataMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(salariuMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update angajati set Salariu = '"+salariuMDSA.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(tipMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update asistentimedicali set Tip_Asistent = '"+tipMDSA.getText() + "' where ID_Asistent=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(gradMDSA.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update asistentimedicali set Grad_Asistent = '"+gradMDSA.getText() + "' where ID_Asistent=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ok==1){
            mesajFinalMDSA.setText("Modificare realizata cu succes!");
        }
        else {
            mesajFinalMDSA.setText("Nu s-au produs modificari!");
        }
    }

    public void modificaDateMedic() throws SQLException{
        ok=0;
        if(idMDSM.getText().isBlank()==false){
            String s=idMDSM.getText();
            int id=Integer.parseInt(s);
        }


        if(numeMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Nume = '"+numeMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(prenumeMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Prenume = '"+prenumeMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(parolaMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Parola = '"+parolaMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(cnpMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set CNP = '"+cnpMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(adresaMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Adresa = '"+adresaMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(telefonMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Telefon = '"+telefonMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(emailMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Email = '"+emailMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ibanMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Cont_IBAN = '"+ibanMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(rolMDSM.getText().isBlank()==false){
            String anga;
            if(rolMDSM.getText().equals("hr")){
                anga="HR";
            }
            else if(rolMDSM.getText().equals("receptioner")){
                anga="RECEPTIONER";
            }
            else if(rolMDSM.getText().equals("economic")){
                anga="ECONOMIC";
            }
            else{
                anga="ADMIN";
            }
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set rol_user = '"+anga + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(contractMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Numar_Contract = '"+contractMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(dataMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Data_Angajarii = '"+dataMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(salariuMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update angajati set Salariu = '"+salariuMDSM.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(specialitateMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Specialitate = '"+specialitateMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(gradMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Grad_Medic = '"+gradMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(competenteMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Competente = '"+competenteMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(codMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Cod_Parafa = '"+codMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(titluMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Titlu_Stiintific = '"+titluMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(postMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Post_Didactic = '"+postMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(procentMDSM.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update medici set Procent_Servicii = '"+procentMDSM.getText() + "' where ID_Medic=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(ok==1){
            mesajFinalMDSM.setText("Modificare realizata cu succes!");
        }
        else {
            mesajFinalMDSM.setText("Nu s-au produs modificari!");
        }
    }
}
