package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label big_label;

    @FXML
    private ChoiceBox<String> chBox;

    @FXML
    private TextField text_field;

    @FXML
    private Label tonna_label;

    @FXML
    private Label tonna_out;

    @FXML
    private Label killo_out;

    @FXML
    private Label gram_label;

    @FXML
    private Label gram_out;

    @FXML
    private Label killo_label;

    private float str_num;
    private String operation;
    private float inTon = 0;
    private float inKilo = 0;
    private float inGram = 0;

    @FXML
    void initialize() {
        String kilo = "Килограммы";
        String gram = "Граммы";
        String ton = "Тонны";
        chBox.setItems(FXCollections.observableArrayList(kilo, gram, ton));

        chBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, number2) -> {
            operation = chBox.getItems().get((Integer) number2);
            str_num = Float.parseFloat(text_field.getText());
            setText_field(operation);
        });

    }

    void setText_field(String operation) {
        switch (operation) {
            case "Килограммы":
                this.inTon = (float) (this.str_num * 0.001);
                this.inKilo = (this.str_num * 1);
                this.inGram = (this.str_num * 1000);
                break;
            case "Тонны":
                this.inTon = (this.str_num * 1);
                this.inKilo = (this.str_num * 1000);
                this.inGram = (this.str_num * 1000000);
                break;
            case "Граммы":
                this.inTon = (float) (this.str_num * 0.000001);
                this.inKilo = (this.str_num * 1000);
                this.inGram = (this.str_num * 1);
                break;
        }
        tonna_out.setText(Float.toString(this.inTon));
        killo_out.setText(Float.toString(this.inKilo));
        gram_out.setText(Float.toString(this.inGram));
    }


}

