package common;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by FINETECHLABS on 26/01/2017.
 */


public class emptyFieldError extends Application {

    public static void showFatalError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Label alertHead = new Label("Some of your cells may be empty\n" +
                " ");
        Label alertcontent = new Label("Please  counter check to fill the  empty details ");
        alert.setHeaderText(alertHead.getText());
//alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
        alert.setContentText(String.valueOf(alertcontent.getText()));
        alert.showAndWait();
    }

    public static void minVal() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Label alertHead = new Label("your  contribution ammount is of min value\n" +
                " ");
        Label alertcontent = new Label("Please  counter check  to enter recommended values");
        alert.setHeaderText(alertHead.getText());
//alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
        alert.setContentText(String.valueOf(alertcontent.getText()));
        alert.showAndWait();
    }

    public static void RepeatedValue() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Label alertHead = new Label("The registration Number is already used\n" +
                " ");
        Label alertcontent = new Label("Please please enter another or verify");
        alert.setHeaderText(alertHead.getText());
//alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
        alert.setContentText(String.valueOf(alertcontent.getText()));
        alert.showAndWait();
    }

    public static void errorInPassword() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Label alertHead = new Label("WRONG PASSWORD OR USERNAME\n" +
                " ");
        Label alertcontent = new Label("Please please enter another or verify");
        alert.setHeaderText(alertHead.getText());
//alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
        alert.setContentText(String.valueOf(alertcontent.getText()));
        alert.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) {
        showFatalError();
    }
}





