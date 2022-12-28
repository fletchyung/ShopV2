package com.example.shopvideocard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class Tablle {

    @FXML
    private Button s;
    @FXML
    private TextField nz;

    @FXML
    private TableColumn<Accountant, String> on;

    @FXML
    private TableView<Accountant> tb;

    ObservableList<Accountant> accountants = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        s.setOnAction(click -> {
            try {
                String line = ("Ваши заказы: " + nz.getText()+" ");
                FileOutputStream fileOutputStream =new FileOutputStream("D:\\dowlond\\kursach\\Shop-Video-Cards-master\\src\\main\\resources\\com\\example\\data.txt");
                byte[] buffer=line.getBytes();
                fileOutputStream.write(buffer);
                System.out.println("Удачно сохранено");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        on.setCellValueFactory(new PropertyValueFactory<Accountant, String>("Ваши заказы"));

        s.setOnAction(click -> {
            Accountant accountant = new Accountant(nz.getText());
            accountants.add(accountant);
            tb.setItems(accountants);
        });
    }
}

