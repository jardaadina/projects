package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class Salariu {
    @FXML
    private Button anuleazaSA;


    @FXML
    private Label salariu;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserSalariu(int id) throws SQLException
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String Salariu = "call SelectSalariuAngajat(?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(Salariu)) {
            preparedStatement.setInt(1, id);

            String userSalariu = null;
            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next()) {
                    userSalariu = result2.getString("Salariu");
                }
                salariu.setText(" " + userSalariu );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setID(int id) {
    }

    public void anuleazaSAOnAction(ActionEvent e)
    {
        Stage stage= (Stage)anuleazaSA.getScene().getWindow();
        stage.close();
    }
}