package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class ProfitMedic {
    @FXML
    private Button anuleaza;

    @FXML
    private Label profitMedic;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserProfitMedic(int id) throws SQLException
    {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String Profit = "CALL CalculProfitMedic(?)";
        try (PreparedStatement preparedStatement = connectDB.prepareStatement(Profit)) {

            preparedStatement.setInt(1, id);

            String userProfit = null;
            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next()) {
                    userProfit = result2.getString("ProfitMedic");
                }
                profitMedic.setText(" " + userProfit );
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