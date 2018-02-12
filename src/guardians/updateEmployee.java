package guardians;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXToolbar;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * Created by FINETECHLABS on 01/04/2017.
 */
public class updateEmployee extends Application {
    public static TextField employeeFirstName;
    public static Label employeeFirstNamelbl;
    public static Label employeeLastNamelbl;
    public static Label activeStatuslbl;
    public static Label phoneNumberlbl;
    public static TextField employeeLastName;
    public static TextField phoneNumber;
    public static Button update;
    public static Button clear;
    public static Button delete;
    public static Button suspend;
    public static TextField salary;
    public static TextField residence;
    public static ComboBox position;
    public static ComboBox activeStatus;
    public static TextField employeeId;
    public static Label employeeIdlbl;
    public static TextField employeeSalary;
    public static JFXToolbar toolbar;
    public static JFXPasswordField password;
    public static GridPane members;
    public static VBox employeeAddress;
    public static VBox employeeDetails;
    public static VBox employeePayments;
    public static VBox operations;
    public static Separator separatorFour;
    public static Separator separatorZero;
    public static Separator separatorOne;
    public static Separator separatorTwo;
    public static Separator separatorThree;
    public static GridPane grid;
    public static ComboBox<employee> allEmployees;
    public static Scene scene;
    public static Stage stage;
    private static TextArea Notes;
    private static Label salarylbl;
    private static Label residencelbl;
    private static Label positionlbl;

    public static void updateEmployeePop() {
        HBox hbox = new HBox();
        stage = new Stage();
        scene = new Scene(updateMembers(), 720, 320);
        //  stage= new Stage(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("UPDATE EMPLOYEES");
        stage.setResizable(false);
        stage.show();

        //return hbox;
    }

    public static GridPane updateMembers() {
        members = new GridPane();
        grid = new GridPane();
        //  grid.setStyle("-fx-background-color: #FCE4EC");
        employeeAddress = new VBox();
//        employeeAddress.setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
//                "-fx-border-style:solid;" +
//                "-fx-border-width: 2");

        employeeDetails = new VBox();
//        employeeDetails.setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
//            "-fx-border-style:solid;" +
//            "-fx-border-width: 2");
        operations = new VBox();
//
//       operations .setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
//            "-fx-border-style:solid;" +
//            "-fx-border-width: 2");
        employeePayments = new VBox();
//employeePayments.setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
//            "-fx-border-style:solid;" +
//            "-fx-border-width: 2");

        employeeDetails.setSpacing(15);
        employeeDetails.setPadding(new Insets(20, 20, 20, 20));
        employeeDetails.setMaxHeight(300);
        employeeDetails.setMaxWidth(450);

        employeeAddress.setMaxWidth(450);
        employeeAddress.setMaxHeight(300);
        employeeAddress.setSpacing(15);
        employeeAddress.setPadding(new Insets(20, 20, 20, 20));

        employeePayments.setSpacing(15);
        employeePayments.setMaxHeight(300);
        employeePayments.setPadding(new Insets(20, 20, 20, 20));
        employeePayments.setMaxWidth(450);


        operations.setSpacing(15);
        operations.setMaxHeight(300);
        operations.setPadding(new Insets(20, 20, 20, 0));
        operations.setMaxWidth(500);

        separatorZero = new Separator();
        separatorZero.setPadding(new Insets(5, 5, 5, 5));
        separatorZero.setOrientation(Orientation.VERTICAL);
        grid.addColumn(0, separatorZero);
        allEmployees = new ComboBox<>(employeeList.allEmployees());
        allEmployees.setMaxWidth(150);
        employeeId = new TextField();
        employeeId.setPromptText("   ID");
        employeeId.setMaxWidth(150);

        employeeAddress.getChildren().addAll(allEmployees);
        separatorTwo = new Separator();
        separatorTwo.setOrientation(Orientation.HORIZONTAL);
        //  separatorTwo.setPadding(new Insets(10,10,10,10));
        employeeAddress.getChildren().add(separatorTwo);
        employeeIdlbl = new Label("EMPLOYEE ID");

        employeeAddress.getChildren().add(employeeIdlbl);
        employeeAddress.getChildren().add(employeeId);
        phoneNumber = new TextField();
        phoneNumber.setPromptText("PHONE NUMBER");
        phoneNumber.setMaxWidth(150);
        phoneNumberlbl = new Label("PHONE .NO");
        employeeAddress.getChildren().addAll(phoneNumberlbl, phoneNumber);
        grid.addColumn(1, employeeAddress);
        separatorOne = new Separator();
        separatorOne.setPadding(new Insets(5, 5, 5, 5));
        separatorOne.setOrientation(Orientation.VERTICAL);
        grid.addColumn(2, separatorOne);

        employeeFirstNamelbl = new Label("FIRST NAME");
        employeeFirstName = new TextField();
        employeeFirstName.setPromptText("First Name");
        employeeFirstName.setMaxWidth(150);

        employeeLastNamelbl = new Label("LAST NAME");
        employeeLastName = new TextField();
        employeeLastName.setPromptText("Last Name");
        employeeLastName.setMaxWidth(150);

        residencelbl = new Label("RESIDENCE");
        residence = new TextField();
        residence.setPromptText("residence");
        residence.setMaxWidth(150);


        employeeDetails.getChildren().addAll(employeeFirstNamelbl, employeeFirstName, employeeLastNamelbl, employeeLastName, residencelbl, residence);


        grid.addColumn(3, employeeDetails);
        separatorThree = new Separator();
        separatorThree.setPadding(new Insets(5, 5, 5, 5));
        separatorThree.setOrientation(Orientation.VERTICAL);
        grid.addColumn(4, separatorThree);

        activeStatus = new ComboBox<>();
        salary = new TextField();
        salary.setMaxWidth(150);
        salarylbl = new Label("SALARY");

        employeePayments.getChildren().addAll(salarylbl, salary);


        activeStatus = new ComboBox();
        activeStatus.setMaxWidth(150);
        activeStatuslbl = new Label("ACTIVE STATE");

        activeStatus.getItems().addAll("ACTIVE", "SUSPENDED");

        position = new ComboBox();
        position.getItems().addAll("MANAGER", "ASSISTANT", "OFFICER", "ASSISRANT-OFFICER");
        position.setMaxWidth(150);
        positionlbl = new Label("POSITION");
        employeePayments.getChildren().addAll(positionlbl, position);

        employeePayments.getChildren().addAll(activeStatuslbl, activeStatus);
        grid.addColumn(5, employeePayments);


        separatorFour = new Separator();
        separatorFour.setPadding(new Insets(5, 5, 5, 5));
        separatorFour.setOrientation(Orientation.VERTICAL);
        grid.addColumn(6, separatorFour);
        update = new Button("update");
        update.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: #E6EE9C;" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill: #212121;"
        );
        update.setOnAction(e -> {
//database.updateEmployees.Updated(employeeFirstName.getText().toUpperCase().trim(),employeeLastName.getText().toUpperCase().trim(),phoneNumber.getText().trim(),position.getValue().toString().trim(),residence.getText().toUpperCase().trim(),activeStatus.getValue().toString().toUpperCase(),employeeId.getText().toUpperCase().trim());
            employeeId.clear();
            employeeLastName.clear();
            employeeFirstName.clear();
            phoneNumber.clear();
            salary.clear();
            residence.clear();


            String title = "UPDATE FOR" + allEmployees.getValue().getFirstName() + allEmployees.getValue().getLastName();
            String message = "has been committed succesfully";

            //Image expenseimg = new Image("Expenses/price-tag-4.png");
            NotificationType type = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            //tray.setImage(expenseimg);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setNotificationType(type);
            tray.showAndDismiss(Duration.seconds(10));


        });


        clear = new Button("clear");
        clear.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: #E6EE9C;" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill:#212121;"
        );
        delete = new Button("delete");
        delete.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: #FF5722;" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill:#212121;"
        );
        delete.setOnAction(e -> {
            //  database.deleteEmployee.delete(allEmployees.getValue().getIdNumber());

            String title = "DELETED VALUE" + allEmployees.getValue().getFirstName() + allEmployees.getValue().getLastName();
            String message = "has been deleted succesfully";

            //Image expenseimg = new Image("Expenses/price-tag-4.png");
            NotificationType type = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            //tray.setImage(expenseimg);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setNotificationType(type);
            tray.showAndDismiss(Duration.seconds(10));

        });
        suspend = new Button("suspend");
        suspend.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: #E6EE9C;" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill: #212121;"
        );
        operations.getChildren().addAll(clear, update, suspend, delete);
        grid.addColumn(7, operations);
        Notes = new TextArea();
        Notes.setPadding(new Insets(5, 10, 5, 10));
        Notes.setMaxHeight(20);
        Notes.setMaxWidth(400);
        //grid.addRow(8,Notes);
        grid.setPadding(new Insets(10, 10, 10, 10));
        members.getChildren().addAll(grid);


        allEmployees.setCellFactory(
                new Callback<ListView<employee>, ListCell<employee>>() {
                    @Override
                    public ListCell<employee> call(ListView<employee> listView) {
                        return new ListCell<employee>() {
                            @Override
                            public void updateItem(employee item, boolean empty) {
                                // Must call super
                                super.updateItem(item, empty);
                                int index = this.getIndex();
                                String name = null;
                                String description = null;
                                // Format name
                                if (item == null || empty) {

                                    // No action to perform
                                } else {
                                    name = (index + 1) + ". " +
                                            item.getFirstName() + " ";

                                    description = "ID.NO:" + item.getIdNumber();
                                }
                                // this.setText(name);
                                Label namelbl = new Label();
                                namelbl.setFont(Font.font("FontAwesome", FontWeight.BOLD, 10));
                                namelbl.setText(name);
                                Button btn = new Button("+");
                                GridPane grid = new GridPane();
                                grid.setVgap(2);
                                grid.setHgap(1);
                                grid.setPadding(new Insets(0, 10, 0, 10));
                                grid.addRow(0, namelbl);
                                Label deslbl = new Label();
                                deslbl.setText(description);
                                HBox hbox = new HBox();
                                hbox.getChildren().addAll(grid);
                                deslbl.setFont(Font.font("FontAwesome", FontWeight.BOLD, 10));
                                grid.addRow(1, deslbl);


                                // firstName.setText(search.getSelectionModel().getSelectedItem().getFirstName());
                                // lastName.setText(search.getSelectionModel().getSelectedItem().getLastName());

                                allEmployees.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<employee>() {
                                    @Override
                                    public void changed(ObservableValue<? extends employee> observable, employee oldValue, employee newValue) {
                                        //String c= expenseSearch.getSelectionModel().getSelectedItem().getLoanAmmount()-loanSearch.getSelectionModel().getSelectedItem().getPaidback()+"";
                                        //   paidback.setText(expenseSearch.getSelectionModel().getSelectedItem().getPaidback()+"");
//                                        String bal=(expenseSearch.getSelectionModel().getSelectedItem().getExpenseTotal())-(expenseSearch.getSelectionModel().getSelectedItem().getPaidback())+"";
//                                        balance.setText(bal);
//                                        expenseName.setText(expenseSearch.getSelectionModel().getSelectedItem().getExpenseName());
//                                        paidback.setText(expenseSearch.getSelectionModel().getSelectedItem().getPaidback()+"");


                                        employeeId.setText(allEmployees.getSelectionModel().getSelectedItem().getIdNumber() + "");
                                        phoneNumber.setText(allEmployees.getSelectionModel().getSelectedItem().getPhoneNumber() + "");
                                        residence.setText(allEmployees.getSelectionModel().getSelectedItem().getResidence() + "");
                                        employeeFirstName.setText(allEmployees.getSelectionModel().getSelectedItem().getFirstName() + "");
                                        employeeLastName.setText(allEmployees.getSelectionModel().getSelectedItem().getLastName() + "");
                                        salary.setText(allEmployees.getSelectionModel().getSelectedItem().getSalary() + "");
//                                        expenseId.setText(expenseSearch.getSelectionModel().getSelectedItem().getExpenseID());
//                                        expenseAmmount.setText(expenseSearch.getSelectionModel().getSelectedItem().getExpenseTotal()+"");
//
//                                        //endDate.setValue(loanSearch.getSelectionModel().getSelectedItem().getFinalDate());

                                        //   spouseFirstName.setText(search.getSelectionModel().getSelectedItem().getSpouseFirstName());

                                    }
                                });
                                setGraphic(hbox);
                            }
                        };
                    }
                });
        return members;
    }

    @Override
    public void start(Stage stage) {
        scene = new Scene(updateMembers(), 720, 320);
        //  stage= new Stage(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("UPDATE EMPLOYEES");
        stage.show();
    }


}
