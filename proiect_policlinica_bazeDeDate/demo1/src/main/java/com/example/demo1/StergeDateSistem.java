package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class StergeDateSistem {
    @FXML
    private Button anuleazaSDS;

    @FXML
    private TextField idSDS;

    @FXML
    private Label mesajFinalSDS;

    @FXML
    private TextField rolSDS;

    @FXML
    private Button stergeDS;

    private int id;
    int ok=0;

    public void setID(int id) {
        this.id=id;
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) anuleazaSDS.getScene().getWindow();
        stage.close();
    }
    public void stergeDSOnAction(ActionEvent e) throws SQLException{
        sterge();
    }
    public void sterge()throws SQLException {
        ok=0;
        if(idSDS.getText().isBlank()==false && rolSDS.getText().isBlank()==false){
                String s=idSDS.getText();
                int id=Integer.parseInt(s);
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();
                String updateData = "delete from utilizatori where ID_Utilizator=?";
                try (PreparedStatement preparedStatement = connectDB.prepareStatement(updateData)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                    ok=1;
                }
        }
        if(ok==1){
            mesajFinalSDS.setText("Stergere realizata cu succes!");
        }
        else {
            mesajFinalSDS.setText("Nu s-au produs modificari!");
        }






    }
}
