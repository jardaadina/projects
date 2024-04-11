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

public class ProgramareNoua
{
    @FXML
    private Button inapoi;

    @FXML
    private Button programeaza;

    @FXML
    private TextField data;

    @FXML
    private TextField idMedic;

    @FXML
    private TextField idProgramare;

    @FXML
    private TextField ora;

    @FXML
    private TextField idPacient;

    @FXML
    private TextField serviciu;

    @FXML
    private Label mesajFinalProgramare;

    private int id;
    int ok=0;
    public void setId(int id) {
        this.id=id;
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoi.getScene().getWindow();
        stage.close();
    }

    public void programeazaOnAction(ActionEvent e)throws SQLException{
        adaugaProgramare(id);
    }

    public void adaugaProgramare(int id) throws SQLException {
        ok=0;
        if(idProgramare.getText().isBlank()==false && idPacient.getText().isBlank()==false  && data.getText().isBlank()==false&&
                ora.getText().isBlank()==false && idMedic.getText().isBlank()==false && serviciu.getText().isBlank()==false){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String addDataBon ="INSERT INTO programari (ID_Programare,ID_Pacient, Data_Programare, Ora_Programare, ID_Serviciu, ID_Medic) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataBon)) {
                preparedStatement.setInt(1, Integer.parseInt(idProgramare.getText()));
                preparedStatement.setInt(2, Integer.parseInt(idPacient.getText()));
                preparedStatement.setString(3, data.getText());
                preparedStatement.setInt(4, Integer.parseInt(ora.getText()));
                preparedStatement.setInt(5, Integer.parseInt(serviciu.getText()));
                preparedStatement.setInt(6, Integer.parseInt(idMedic.getText()));
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(ok==1){
            mesajFinalProgramare.setText("Programare realizata cu succes!");
        }
        else {
            mesajFinalProgramare.setText("Nu s-au produs modificari!");
        }
    }
}