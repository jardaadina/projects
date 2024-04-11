package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class SalariuPeOra {
    @FXML
    private Button anuleaza;


    @FXML
    private Label salariuPeOra;

    private int id;
    public void setID(int id) {
        this.id = id;
    }

    public void setUserSalariuPeOra(int id) throws SQLException
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String Salariu = "CALL CalculSalariuOra5(?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(Salariu)) {
            preparedStatement.setInt(1, id);

            String userSalariu = null;
            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next()) {
                    userSalariu = result2.getString("SalariuOra");
                }
                salariuPeOra.setText(" " + userSalariu );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void anuleazaSAOnAction(ActionEvent e)
    {
        Stage stage= (Stage)anuleaza.getScene().getWindow();
        stage.close();
    }
}