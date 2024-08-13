package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class ProfitPoliclinica {
    @FXML
    private Button anuleaza;

    @FXML
    private Label profit;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserProfit(int id) throws SQLException
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String Profit = "SELECT policlinici.Profit FROM policlinici JOIN utilizatori ON policlinici.ID_Policlinica = utilizatori.ID_Policlinica JOIN angajati ON angajati.ID_Utilizator = utilizatori.ID_Utilizator WHERE utilizatori.ID_Utilizator = ?;";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(Profit)) {

            preparedStatement.setInt(1, id);

            String userProfit = null;
            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next()) {
                    userProfit = result2.getString("Profit");
                }
                profit.setText(" " + userProfit );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setID(int id) {
    }

    public void anuleazaOnAction(ActionEvent e)
    {
        Stage stage= (Stage)anuleaza.getScene().getWindow();
        stage.close();
    }
}