package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class VizualizareProgramari
{
    @FXML
    private Button inapoiProgramari;

    @FXML
    private TableView<DateProgramari> tabelProgramari;

    @FXML
    private TableColumn<DateProgramari, String> tabelNume;

    @FXML
    private TableColumn<DateProgramari, String> tabelPrenume;

    @FXML
    private TableColumn<DateProgramari, String> data;

    @FXML
    private TableColumn<DateProgramari, String> ora;

    @FXML
    private TableColumn<DateProgramari, String> medic;

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) inapoiProgramari.getScene().getWindow();
        stage.close();
    }

    private int id;
    public void setID(int id) throws SQLException {
        this.id=id;
        dateTabelProgramari(id);
    }

    ObservableList<DateProgramari> listP= FXCollections.observableArrayList();

    public void dateTabelProgramari(int id) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String getData = "SELECT u.nume, u.prenume, prog.Data_Programare, prog.Ora_Programare, prog.ID_Medic\n" +
                "                FROM utilizatori u\n" +
                "                JOIN pacienti p ON u.ID_Utilizator = p.ID_Utilizator\n" +
                "                JOIN programari prog ON p.ID_Pacient = prog.ID_Pacient\n" +
                "                WHERE u.ID_Utilizator = ?;\n";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(getData)) {
            preparedStatement.setInt(1, id); // Setăm valoarea pentru parametrul ID_Utilizator

            try (ResultSet result2 = preparedStatement.executeQuery()) {

                while (result2.next())
                {
                    String userNume = result2.getString("Nume");
                    String userPrenume = result2.getString("Prenume");
                    String userData = result2.getString("Data_Programare");
                    String userOra = result2.getString("Ora_Programare");
                    String userMedic = result2.getString("ID_Medic");
                    listP.add(new DateProgramari(userNume, userPrenume, userData, userOra,userMedic));
                }

                tabelNume.setCellValueFactory(new PropertyValueFactory<>("nume"));
                tabelPrenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
                data.setCellValueFactory(new PropertyValueFactory<>("data"));
                ora.setCellValueFactory(new PropertyValueFactory<>("ora"));
                medic.setCellValueFactory(new PropertyValueFactory<>("medic"));


                tabelProgramari.setItems(listP);

            } catch (SQLException e) {
                Logger.getLogger(DateProgramari.class.getName()).log(Level.SEVERE, null, e);
                e.printStackTrace();
            }

        }
    }
}