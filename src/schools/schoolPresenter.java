package schools;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FINETEKLABS on 12/22/2017.
 */
public class schoolPresenter {
    private school myschool;
    private schoolPresenter myschoolView;

    private school_view myView;


    public schoolPresenter(school myschool, school_view myView) {
        this.myschool = myschool;
        this.myView = myView;
        attachEvents();
    }

    private void attachEvents() {
        myView.saveButton.setOnAction(e -> saveData(myView.myschool)
        );

//          new school( Integer.parseInt(myView.schoolIdField.getText().trim()),
//                  myView.schoolNameField.getText().trim().toUpperCase(),
//                  myView.centerCodeField.getText().trim().toUpperCase(),
//                  myView.academicYearField.getSelectionModel().getSelectedItem().toString(),
//                  myView.locationField.getText().trim().toUpperCase(),
//                  myView.addressField.getText().toUpperCase().trim(),
//                  myView.mobileField.getText().trim().toUpperCase(),
//                  myView.telephoneField.getText().trim().toUpperCase(),
//                  myView.websiteField.getText().trim().toUpperCase(),
//                  myView.emailField.getText().trim().toLowerCase(),
//                  myView.currentTermField.getText().trim().toUpperCase(),
//                  "ACTIVE")
//        )
        //   myView.closeButton.setOnAction(e -> myView.getScene().getWindow().hide());

    }


    private void saveData(school myschool) {
        List<String> errorList = new ArrayList<>();
        myschool = myView.myschool;
        boolean isVaild = myView.isvalidEntry(errorList);
        if (!isVaild) {
            this.showError(errorList);
        } else {
            boolean isSaved = myschool.save(errorList, myschool);
            if (!isSaved) {
                this.showError(errorList);
            }
        }


    }


    public void showError(List<String> errorList) {
        String msg = "";
        if (errorList.isEmpty()) {
            msg = "No message to display.";
        } else {
            for (String s : errorList) {
                msg = msg + s + "\n";
            }
        }
        Label msgLbl = new Label(msg);
        Button okBtn = new Button("OK");
        VBox root = new VBox(new StackPane(msgLbl), new StackPane(okBtn));
        root.setSpacing(10);
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 120);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(schoolApp.mainStage.getScene().getWindow());
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(" ERROR"));
        content.setBody(msgLbl);

        JFXDialog popupDiag = new JFXDialog(stack, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("okay");
        button.setOnAction(e -> stage.close());
        content.setActions(button);

        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(false);
        popupDiag.show();
    }

}
