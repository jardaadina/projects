package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatePersonaleAngajati {
    private int id;
    public void setID(int id) throws SQLException {
        this.id=id;
        dateTabel(id);
    }

    @FXML
    private TableView<DateAngajati> tabel;

    @FXML
    private TableColumn<DateAngajati, String> tabelAdresa;

    @FXML
    private TableColumn<DateAngajati, String> tabelCNP;

    @FXML
    private TableColumn<DateAngajati, String> tabelData;

    @FXML
    private TableColumn<DateAngajati, String> tabelEmail;

    @FXML
    private TableColumn<DateAngajati, String> tabelIban;

    @FXML
    private TableColumn<DateAngajati, Integer> tabelNrContract;

    @FXML
    private TableColumn<DateAngajati, String> tabelNume;

    @FXML
    private TableColumn<DateAngajati, String> tabelPrenume;

    @FXML
    private TableColumn<DateAngajati, String> tabelRol;

    @FXML
    private TableColumn<DateAngajati, String> tabelTelefon;

    ObservableList<DateAngajati> listA= FXCollections.observableArrayList();

    public void dateTabel(int id) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData ="CALL SelectUtilizator(?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData)) {

            for(int i=1; i<150; i++) {
                preparedStatement.setInt(1, i); // Setăm valoarea pentru parametrul ID_Utilizator

                try (ResultSet result2 = preparedStatement.executeQuery()) {

                    while (result2.next()) {
                        String userNume = result2.getString("Nume");
                        String userPrenume = result2.getString("Prenume");
                        String userRol = result2.getString("rol_user");
                        String userEmail = result2.getString("Email");
                        String userAdresa = result2.getString("Adresa");
                        String userData = result2.getString("Data_Angajarii");
                        String userCNP = result2.getString("CNP");
                        String userTelefon = result2.getString("Telefon");
                        String userIban = result2.getString("Cont_IBAN");
                        int userNrContract = result2.getInt("Numar_Contract");
                        listA.add(new DateAngajati(userNume, userPrenume, userAdresa, userEmail, userRol, userCNP, userTelefon, userIban, userNrContract, userData));
                    }

                    tabelAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
                    tabelNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
                    tabelPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
                    tabelRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
                    tabelEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
                    tabelCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
                    tabelTelefon.setCellValueFactory(new PropertyValueFactory<>("nrTelefon"));
                    tabelIban.setCellValueFactory(new PropertyValueFactory<>("iban"));
                    tabelNrContract.setCellValueFactory(new PropertyValueFactory<>("nrContract"));
                    tabelData.setCellValueFactory(new PropertyValueFactory<>("data"));


                    tabel.setItems(listA);

                } catch (SQLException e) {
                    Logger.getLogger(DatePersonale.class.getName()).log(Level.SEVERE, null, e);
                    e.printStackTrace();
                }
            }
        }
    }
}