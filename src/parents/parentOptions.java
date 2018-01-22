package parents;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by FINETEKLABS on 1/16/2018.
 */
public class parentOptions extends HBox {
    Label add = new Label("new parent");
    Label close = new Label("close");
    Label logout = new Label("logout");
    Label edit = new Label("edit");
    Label exportToExcel = new Label("export to excel");
    Label exportToPdf = new Label("export to pdf");


    //JFX BUTTONS
    JFXButton addField = new JFXButton(" add");
    JFXButton exporToPdfField = new JFXButton(" pdf");
    JFXButton exportToExcelField = new JFXButton(" excel");
    JFXButton loggedIn = new JFXButton("user");


    TextField searchField = new TextField();


    //comboBoxes
    public parentOptions() {
        this.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: darkgray;");
        this.setMinWidth(500);
        layoutField();
    }

    public HBox layoutField() {

        this.setSpacing(10);
        this.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().addAll(addField, exporToPdfField, exportToExcelField, searchField, loggedIn);
        this.setAlignment(Pos.CENTER);
        //this.setMaxHeight(250);

        return this;
    }


}
