package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalariiAngajati
{

    @FXML
    private Button anuleazaSAD;
    @FXML
    private TableColumn<DateSalariiAngajati, String> salariu;

    @FXML
    private TableView<DateSalariiAngajati> tabelSalarii;

    @FXML
    private TableColumn<DateSalariiAngajati, String> tabelNume;

    @FXML
    private TableColumn<DateSalariiAngajati, String> tabelPrenume;

    private int id;
    public void setID(int id) throws SQLException {
        this.id=id;
        dateTabelSalarii(id);
    }

    ObservableList<DateSalariiAngajati> listS= FXCollections.observableArrayList();

    public void dateTabelSalarii(int id) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData = "SELECT u.nume, u.prenume, a.salariu\n" +
                "FROM utilizatori u\n" +
                "JOIN angajati a ON u.ID_Utilizator = a.ID_Angajat\n" +
                "WHERE u.ID_Utilizator = ?;\n";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData)) {

            for (int i = 1; i < 150; i++) {

                preparedStatement.setInt(1, i); // Setăm valoarea pentru parametrul ID_Utilizator

                try (ResultSet result2 = preparedStatement.executeQuery()) {

                    while (result2.next()) {
                        String userNume = result2.getString("Nume");
                        String userPrenume = result2.getString("Prenume");
                        String userSalariu = result2.getString("Salariu");
                        listS.add(new DateSalariiAngajati(userNume, userPrenume, userSalariu));
                    }

                    tabelNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
                    tabelPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
                    salariu.setCellValueFactory(new PropertyValueFactory<>("salariu"));
                    tabelSalarii.setItems(listS);

                } catch (SQLException e) {
                    Logger.getLogger(DateSalariiAngajati.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                }
            }
        }
    }
    public void anuleazaSAOnAction(ActionEvent e)
    {
        Stage stage= (Stage)anuleazaSAD.getScene().getWindow();
        stage.close();
    }
}