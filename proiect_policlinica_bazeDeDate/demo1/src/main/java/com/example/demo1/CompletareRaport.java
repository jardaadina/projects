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

public class CompletareRaport
{
    @FXML
    private Button inapoi;

    @FXML
    private Button adauga;
    private int id;
    @FXML
    private Label mesajFinalRaport;

    @FXML
    private TextField continut;

    @FXML
    private TextField programare;
    @FXML
    private TextField medic;

    @FXML
    private TextField raport;
    int ok=0;

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoi.getScene().getWindow();
        stage.close();
    }

    public void adaugaOnAction(ActionEvent e) throws SQLException{
            adaugaRaport(id);
    }

    public void setId(int id) {
        this.id=id;
    }

    public void adaugaRaport(int id)throws SQLException {
        ok=0;
        if(continut.getText().isBlank()==false && programare.getText().isBlank()==false && raport.getText().isBlank()==false ){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String addDataBon ="INSERT INTO rapoartemedicale ( ID_Raport, Continut, ID_Programare, ID_Asistent, ID_Medic) VALUES(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connectDB.prepareStatement(addDataBon)) {
                preparedStatement.setInt(1, Integer.parseInt(raport.getText()));
                preparedStatement.setString(2, continut.getText());
                preparedStatement.setInt(3, Integer.parseInt(programare.getText()));
                preparedStatement.setInt(4, id);
                preparedStatement.setInt(5, Integer.parseInt(medic.getText()));
                preparedStatement.executeUpdate();
                ok=1;
            }
        }

        if(ok==1){
            mesajFinalRaport.setText("Raport completat cu succes!");
        }
        else {
            mesajFinalRaport.setText("Nu s-au produs modificari!");
        }
    }
}