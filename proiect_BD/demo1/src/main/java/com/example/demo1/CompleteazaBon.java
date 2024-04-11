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

public class CompleteazaBon
{
    @FXML
    private Button inapoi;
    @FXML
    private Button emiteBon;

    @FXML
    private Label mesajFinalBon;

    private int id;
    int ok=0;

    @FXML
    private TextField data;

    @FXML
    private TextField idBon;

    @FXML
    private TextField idProgramare;

    @FXML
    private TextField valoare;

    public void setId(int id) {
        this.id=id;
    }

    public void emiteBonOnAction(ActionEvent e) throws SQLException{
            adaugaBon(id);
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoi.getScene().getWindow();
        stage.close();
    }

    public void adaugaBon(int id) throws SQLException {
        ok=0;
        if(idBon.getText().isBlank()==false && idProgramare.getText().isBlank()==false && data.getText().isBlank()==false && valoare.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String addDataBon ="INSERT INTO bonurifiscale ( ID_Bon, Data_Emitere, Valoare, ID_Programare) VALUES(?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataBon)) {
                preparedStatement.setInt(1, Integer.parseInt(idBon.getText()));
                preparedStatement.setString(2, data.getText());
                preparedStatement.setInt(3, Integer.parseInt(valoare.getText()));
                preparedStatement.setInt(4, Integer.parseInt(idProgramare.getText()));
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(ok==1){
            mesajFinalBon.setText("Bon emis cu succes!");
        }
        else {
            mesajFinalBon.setText("Nu s-au produs modificari!");
        }
    }
}