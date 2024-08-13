package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificaDate {
    @FXML
    private TextField adresaField;

    @FXML
    private TextField cnpField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField ibanField;

    @FXML
    private TextField nrtelField;

    @FXML
    private TextField numeField;

    @FXML
    private TextField parolaField;

    @FXML
    private TextField prenumeField;

    @FXML
    private Button anuleazaMDA;

    @FXML
    private Label mesajFinalUpdate;

    @FXML
    private Button updateMDA;
    private int id;

    public void setID(int id) {
        this.id = id;
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) anuleazaMDA.getScene().getWindow();
        stage.close();
    }
    int ok=0;
    public void updateMDAOnAction(ActionEvent e) throws SQLException{

        modificadatele(id);

    }

    public void modificadatele(int id) throws SQLException{
        ok=0;
        if(numeField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Nume = '"+numeField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(prenumeField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Prenume = '"+prenumeField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(parolaField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Parola = '"+parolaField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(cnpField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set CNP = '"+cnpField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(adresaField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Adresa = '"+adresaField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(nrtelField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Telefon = '"+nrtelField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(emailField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Email = '"+emailField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ibanField.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String updateData = "update utilizatori set Cont_IBAN = '"+ibanField.getText() + "' where ID_Utilizator=?";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                ok=1;
            }
        }
        if(ok==1){
            mesajFinalUpdate.setText("Update realizat cu succes!");
        }
        else {
            mesajFinalUpdate.setText("Nu s-au produs modificari!");
        }



    }
}
