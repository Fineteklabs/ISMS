package users;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import javafx.util.Duration;
import org.apache.commons.dbutils.DbUtils;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by FINETECHLABS on 26/01/2017.
 */
public class employeeDataForm {
    public static TableView<employee> table;
    public static SplitMenuButton homebtn = new SplitMenuButton();
    public static VBox Adding;
    private static ObservableList<employee> entries = FXCollections.observableArrayList();
    private static TextField registrationNumber;
    private static Label registrationNumberlbl;
    private static ComboBox vehicleSeats;
    private static Label vehicleSeatslbl;
    private static ComboBox vehicleModel;
    private static Label vehicleModellbl;
    private static TextField ownerFirstName;
    private static Label ownerFirstNamelbl;
    private static TextField ownerLastName;
    private static Label ownerLastNamelbl;
    private static TextField ownerIdNumber;
    private static Label ownerIdNumberlbl;
    private static ComboBox driver;
    private static Label driverlbl;
    private static TextField ownerPhoneNumber;
    private static Label ownerPhoneNumberlbl;
    private static TextField conductorFirstName;
    private static Label conductorFirstNamelbl;

    private static TextField conductorLastName;
    private static Label conductorLastNamelbl;

    private static TextField conductorPhoneNumber;
    private static Label conductorPhoneNumberlbl;
    private static ComboBox position;
    private static Label positionlbl;

    private static DatePicker entryDate;

    private static Label passwordLbl;
    private static JFXPasswordField password;
    private static Label passwordlbl1;
    private static JFXPasswordField password1;
    private static Label openingBallbl;
    private static Label doblbl;
    private static JFXDatePicker dob;
    private static Label phonenumberlbl;
    private static ChoiceBox activity;
    private static Button save;
    private static Label activelbl;
    private static Button cancel;
    private static Button clear;
    private static Button held;
    private static GridPane saving = new GridPane();
    private static Label entryDatelbl;
    private static TextField driverPhoneNumber;
    private static Label employeeFirstNamelbl;
    private static TextField employeeFirstName;
    private static Label secondNamelbl;
    private static TextField secondName;
    private static TextField idNumber;
    private static Label idNumberlbl;
    private static Label wagelbl;
    private static TextField wage;
    private static TextField salary;
    private static Label salarylbl;
    private static ComboBox maritalStatus;
    private static Label maritalStatuslbl;
    private static Label activeStatuslbl;
    private static ComboBox activeStatus;
    private static TextField station;
    private static Label stationlbl;
    private static TextField residence;
    private static Label residencelbl;
    private static TextField phoneNumber;

    public static VBox Add() {
        GridPane grid = new GridPane();
        Adding = new VBox();
        employeeFirstNamelbl = new Label(" FIRST NAME");
        employeeFirstName = new TextField();

//            IdNumber= new TextField(){
//
//
//
//                @Override
//                public void replaceText(int start, int end, String text) {
//                    if (!text.matches("[a-z, A-Z]")) {
//                        super.replaceText(start, end, text);
//                    }
//
//                }
//
//                @Override
//                public void replaceSelection(String text) {
//                    if (!text.matches("[a-z, A-Z]")) {
//                        super.replaceSelection(text);
//                    }
//                }
//            };


        employeeFirstName.setPrefColumnCount(8);
        grid.addColumn(0, employeeFirstNamelbl, employeeFirstName);

        secondNamelbl = new Label("LAST NAME");
        secondName = new TextField() {

            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[0-9, 0-9]")) {
                    super.replaceText(start, end, text);
                }

            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[0-9, 0-9]")) {
                    super.replaceSelection(text);
                }
            }
        };
        grid.addColumn(0, secondNamelbl, secondName);


        idNumberlbl = new Label("ID NUMBER");
        idNumber = new TextField();
        grid.addColumn(0, idNumberlbl, idNumber);

        idNumber.textProperty().addListener(
                (observable, oldValue, newValue) ->
                        search(idNumber.getText().toUpperCase().trim())
        );
        maritalStatuslbl = new Label("MARITAL STATUS");
        maritalStatus = new ComboBox();
        maritalStatus.getItems().addAll("MARRIED", "SINGLE");
        maritalStatus.setMinWidth(150);
        grid.addColumn(1, maritalStatuslbl, maritalStatus);


        phonenumberlbl = new Label("PHONE NUMBER");
        phoneNumber = new TextField() {
            final int maxChars = 13;
            final String restictTo = "[ 0-9,0-9 +]*";

            @Override
            public void replaceText(int start, int end, String text) {
                if (matchTest(text)) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (matchTest(text)) {
                    super.replaceSelection(text);
                }
            }

            private boolean matchTest(String text) {
                return text.isEmpty() || (text.matches(restictTo) && getText().length() < maxChars);
            }
        };


        grid.addColumn(1, phonenumberlbl, phoneNumber);


        residencelbl = new Label("RESIDENCE");
        residence = new TextField();


        grid.addColumn(2, residencelbl, residence);
        grid.setPadding(new Insets(20, 20, 50, 20));
        stationlbl = new Label("STATION");
        station = new TextField();


        station.setPromptText("station of work");
        grid.addColumn(2, stationlbl, station);

        activeStatuslbl = new Label("ACTIVE STATUS");
        activeStatus = new ComboBox<>();
        activeStatus.setMinWidth(150);
        activeStatus.getItems().addAll("ACTIVE", "SUSPENDED");
        grid.addColumn(3, activeStatuslbl, activeStatus);

// Create a day cell factory
        Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                // Must call super
                                super.updateItem(item, empty);
                                // Disable all future date cells
                                if (item.isAfter(LocalDate.now())) {
                                    this.setDisable(true);

                                }
                                // Show Weekends in blue color
                                DayOfWeek day = DayOfWeek.from(item);
                                if (day == DayOfWeek.SATURDAY ||
                                        day == DayOfWeek.SUNDAY) {
                                    this.setTextFill(Color.GREEN);
                                } else {
                                    this.setTextFill(Color.BROWN);
                                }
                            }
                        };
                    }
                };

        entryDate = new DatePicker();
        entryDate.setDayCellFactory(dayCellFactory);
        entryDate.setEditable(false);
        entryDatelbl = new Label("RECRUITMENT DATE  ");
        grid.addColumn(3, entryDatelbl, entryDate);


        doblbl = new Label("DATE OF BIRTH");
        dob = new JFXDatePicker();
        grid.addColumn(3, doblbl, dob);


        salarylbl = new Label("SALARY");
        salary = new TextField();
        grid.addColumn(4, salarylbl, salary);

        positionlbl = new Label("POSITION");

        position = new ComboBox();
        position.getItems().addAll("ASSISTANT", "OFFICER", "SENIOR OFFICER", "MANAGER");


        grid.addColumn(2, positionlbl, position);


        password = new JFXPasswordField();
        passwordLbl = new Label("PASSWORD");
        grid.addColumn(4, passwordLbl, password);

        passwordlbl1 = new Label("CONFIRM PASSWORD");
        password1 = new JFXPasswordField();


        password1.setPromptText("confirm password");
//password1.textProperty().addListener(
//                (observable, oldValue, newValue) ->
//
//                      //  verifyPassword()
//        );
        grid.addColumn(4, passwordlbl1, password1);
        save = new Button("save");
        save.setOnAction(e -> {


//check if all input forms are filled
            if (idNumber.getText().isEmpty() || employeeFirstName.getText().isEmpty() ||
                    secondName.getText().isEmpty() || phoneNumber.getText().isEmpty() ||
                    salary.getText().isEmpty() ||
                    residence.getText().isEmpty() ||
                    station.getText().isEmpty() ||
                    maritalStatus.getValue().toString().isEmpty() ||
                    dob.getValue().toString().isEmpty() ||
                    password.getText().isEmpty() ||
                    password1.getText().isEmpty() ||
                    activeStatus.getValue().toString().isEmpty() ||
                    entryDate.getValue().toString().isEmpty()) {

            } else {


                //insert into db
//                    insert( String idNumber,String firstName,String secondName,String phoneNumber,String residence,String station, String position,
//                            String activeStatus,String maritalStatus,double salary,double wage,double bonus,LocalDate dob,LocalDate recruitmentDate) {
//


                insert(idNumber.getText().toUpperCase().trim(), employeeFirstName.getText().toUpperCase().trim(), secondName.getText().toUpperCase().trim(),
                        phoneNumber.getText().toUpperCase().trim(), residence.getText().trim().toUpperCase(), station.getText().toUpperCase().trim(), position.getValue().toString().toUpperCase(), activeStatus.getValue().toString().toUpperCase(),
                        maritalStatus.getValue().toString().toUpperCase(), Double.parseDouble(salary.getText()), 0.0, 0.0,
                        dob.getValue(), entryDate.getValue(), password1.getText().trim());


                String title = "NEW EMPLOYEE ADDED";
                String message = "NAME :" + employeeFirstName.getText() + "\n :" + secondName.getText() + "" + "";

                //   Image expenseimg = new Image("Expenses/price-tag-4.png");
                NotificationType type = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                // tray.setImage(expenseimg);
                tray.setAnimationType(AnimationType.FADE);
                tray.setNotificationType(type);
                tray.showAndDismiss(Duration.seconds(5));


                // refresh lists
//        refreshConnections.refreshMembers();


                idNumber.clear();
                secondName.clear();
                dob.setValue(null);
                residence.clear();
                employeeFirstName.clear();
                salary.setText("0.0");
                station.clear();
                activeStatus.setValue(null);
                phoneNumber.clear();


                table.setItems(null);
                table.setItems(employeeList.allEmployees());
            }
        });

        //  printMember= new CheckBox("Print Member Details");
        save.setPrefWidth(50);
        cancel = new Button("cancel");
        cancel.setPrefWidth(50);
        clear = new Button("clear");
        clear.setPrefWidth(50);
        held = new Button("search");
//        saving.addColumn(2,save,clear,cancel);
//        saving.setHgap(10);
//        saving.setVgap(10);
//        saving.setPadding(new Insets(10,10,10,10));


        save.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: rgb(77,102,204);" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill: WHITE;"
        );
        cancel.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color:#D63333;;" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill: WHITE;"
        );
        clear.setStyle(
                " -fx-padding: 0.7em 0.57em;" +
                        " -fx-font-size: 10px;" +
                        "  -jfx-button-type: RAISED;" +
                        "   -fx-background-color: rgb(77,102,204);" +
                        " -fx-pref-width: 50;" +
                        " -fx-text-fill: WHITE;"
        );


        grid.addColumn(6, save, clear, cancel);

        grid.setVgap(10);
        grid.setHgap(15);
        Adding.getChildren().addAll(grid);
        return Adding;
    }


    public static BorderPane EmployeeTableHolder() {
        BorderPane update = new BorderPane();
        //entries.addAll(vehicleList.allMembers());
        table = new TableView<>(employeeList.allEmployees());


        TableColumn<employee, Number> numberCol = new TableColumn<employee, Number>("#");
        numberCol.setSortable(false);
        numberCol.setMinWidth(50);
        numberCol.setMaxWidth(150);

        numberCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        table.getColumns().addAll(numberCol,
                employeeList.getIdNumber(),
                employeeList.getFirstName(),
                employeeList.getLastName(),
                employeeList.getSalary(),
                employeeList.getBonus(),
                employeeList.getPosition(),
                employeeList.getMaritalStatus(),
                employeeList.getPhoneNumber(),
                employeeList.getActiveStatu()

        );
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);
        table.setTableMenuButtonVisible(true);


        table.setRowFactory(
                new Callback<TableView<employee>, TableRow<employee>>() {
                    @Override
                    public TableRow<employee> call(TableView<employee> tableView) {
                        final TableRow<employee> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();

                        // "Borrow" menu items from table's context menu,
                        // if there is one.
                        final ContextMenu tableMenu = tableView.getContextMenu();
                        if (tableMenu != null) {
                            rowMenu.getItems().addAll(tableMenu.getItems());
                            rowMenu.getItems().add(new SeparatorMenuItem());
                        }
                        MenuItem editItem = new MenuItem("edit");
                        editItem.setOnAction(e -> updateEmployee.updateEmployeePop());
                        MenuItem suspend = new MenuItem("suspend");
                        suspend.setOnAction(
                                e -> updateEmployee.updateEmployeePop()
                        );
                        // editItem.setOnAction(...);
                        MenuItem removeItem = new MenuItem("delete");
                        removeItem.setOnAction(e -> {

                            if (row.getItem().getPosition() != "OFFICER" && row.getItem().getActiveStatus() == "ACTIVE") {

                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                Label alertHead = new Label(row.getItem().getFirstName() + " " + row.getItem().getLastName() + " is a senior officer\n" +
                                        " or has more rights");
                                alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
                                Label alertcontent = new Label("the operation cannot be done");
                                alert.setHeaderText(alertHead.getText());
                                alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
//alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
                                alert.setContentText(String.valueOf(alertcontent.getText()));
                                alert.showAndWait();

                            } else if (row.getItem().getActiveStatus() != "ACTIVE" && row.getItem().getPosition() == "ASSISTANT") {
                                //remove from screen
                                table.getItems().remove(row.getItem());

                                //delete from database
                                //  database.deleteEmployee.delete(row.getItem().getIdNumber());

                                //delete all savings entries
                                //database.deleteSavings.deleteAllSavings();


                                //notify from taskbar
                                String title = "EMPLOYEE DELETED FROM THE SYSTEM";
                                String message = "NAME :" + row.getItem().getFirstName() + "" + row.getItem().getLastName();

                                //  Image expenseimg = new Image("Expenses/price-tag-4.png");
                                NotificationType type = NotificationType.SUCCESS;
                                TrayNotification tray = new TrayNotification();
                                tray.setTitle(title);
                                tray.setMessage(message);
                                //tray.setImage(expenseimg);
                                tray.setAnimationType(AnimationType.FADE);
                                tray.setNotificationType(type);
                                tray.showAndDismiss(Duration.seconds(5));
                            }
//}else{
//    Alert alert= new Alert(Alert.AlertType.WARNING);
//    Label alertHead= new Label(row.getItem().getName()+" is an active member\n" +
//            " or has a loan balance");
//    alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
//
//    Label  alertcontent=  new Label("please ensure loan ammount "+row.getItem().getLoanbal()+"is cleared first");
//    alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
//    alert.setHeaderText(alertHead.getText());
//
////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
//    alert.setContentText(String.valueOf(alertcontent.getText()));
//    alert.showAndWait();
//}


//37167568262


                        });

                        rowMenu.getItems().addAll(editItem, removeItem);

                        // only display context menu for non-null items:
                        row.contextMenuProperty().bind(
                                Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                        .then(rowMenu)
                                        .otherwise((ContextMenu) null));
                        return row;
                    }
                });


//DeleteMember.deleteSelected();
        //TableView.TableViewSelectionModel<Member> tsm = table.getSelectionModel();
        //tsm.setSelectionMode(SelectionMode.MULTIPLE);


        //table.setItems(entries);
        table.setPadding(new Insets(20, 20, 20, 20));
        table.setPlaceholder(new Label(" PLEASE ADD ::EMPLOYEES INTO THE SYSTEM"));
//table.setItems(entries);


        VBox centerlayout = new VBox();

        centerlayout.getChildren().addAll(table);
        centerlayout.setSpacing(50);
        centerlayout.setPadding(new Insets(20, 20, 20, 20));


        //   tsm.setCellSelectionEnabled(true);

        //TOP OF MEMBER VIEW TAB
        // update.setTop(mainmenu());


        update.setCenter(centerlayout);

        //update.setTop(txt);
        return update;
    }


    public static MenuBar mainmenu() {
        Menu top = new Menu();

        MenuBar bar = new MenuBar();
        Menu home = new Menu();

        homebtn.setOnAction(e -> {
//            centraldata.setCenter(null);
//            //  MembersView.centraldata.setTop(null);
//            centraldata.setBottom(null);
//            centraldata.setLeft(null);
//            centraldata.setRight(null);
            BorderPane contents = new BorderPane();
            //  contents.setSpacing(10);
            //
//            centraldata.setTop(Design.mainmenu());
//            centraldata.setCenter(Design.updateItems());
//            centraldata.setBottom(AddData.Add());
//            centraldata.setRight(LeftSider.memberDetails());
//            contents.setCenter(Design.savingsTable());
//            contents.setBottom(SavingsDesign.memberDetails());
//            contents.setTop(SavingsDesign.topmenu());
            // contents.getChildren().addAll(SavingsDesign.savingsTable(),);
            //  MembersView.centraldata.setCenter(contents);
            // MembersView.centraldata.setBottom(SavingsDesign.memberDetails());
            //   MembersView.centraldata.setTop();
        });
        homebtn.setText("HOME");

        Menu add = new Menu();
        Menu delete = new Menu();
        Menu update = new Menu();
        Menu allreports = new Menu();
        Menu search = new Menu();
        bar.setPadding(new Insets(0, 20, 0, 20));
        bar.setCursor(Cursor.HAND);

        // MenuItem recent= new MenuItem("recently added");
        MenuItem editDetails = new MenuItem("EDIT DETAILS");
        editDetails.setOnAction(e -> {

            // Inventory.border.setCenter(AddItem.main());
            //Inventory.cinfo.setText("RECEIVE  ITEMS");


        });


        MenuItem addSavings = new MenuItem(" ADD EMPLOYEE");

        addSavings.setOnAction(e -> {
            employeeFirstName.requestFocus();
        });
        MenuItem savingsHistory = new MenuItem("EMPLOYEE PAYMENTS");
        savingsHistory.setOnAction(e -> {


        });

        MenuItem updates = new MenuItem("UPDATE EMPLOYEES");
        updates.setOnAction(e -> {
            updateEmployee.updateEmployeePop();
            updateEmployee.operations.getChildren().remove(updateEmployee.clear);
            updateEmployee.operations.getChildren().remove(updateEmployee.delete);
            updateEmployee.operations.getChildren().remove(updateEmployee.suspend);
        });
        MenuItem quickupdate = new MenuItem("DELETE EMPLOYEE");
        quickupdate.setOnAction(e -> {
            updateEmployee.updateEmployeePop();
            updateEmployee.operations.getChildren().remove(updateEmployee.clear);
            updateEmployee.operations.getChildren().remove(updateEmployee.update);
            updateEmployee.operations.getChildren().remove(updateEmployee.suspend);
            //updateEmployee.operations.getChildren().addAll(updateEmployee.d)


        });


        MenuItem exportXls = new MenuItem("EXCEL");
        exportXls.setOnAction(e -> {
            String title = "EXPORTING TO EXCEL";
            String message = "Go to C:my reports/reports/EMPLOYEES";

            //  Image expenseimg = new Image("Expenses/price-tag-4.png");
            NotificationType type = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            ///tray.setImage(expenseimg);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setNotificationType(type);
            tray.showAndDismiss(Duration.seconds(5));


            ProgressForm pForm = new ProgressForm();

            // In real life this task would do something useful and return
            // some meaningful result:
            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws InterruptedException {

                    for (int i = 0; i < 1; i++) {
                        updateProgress(i, 1);

                        Thread.sleep(200);


                    }
                    //   reports.employeeToXls.build();
                    //Reports.MemberReports.memberList();
                    updateProgress(20, 20);


                    return null;
                }
            };

            // binds progress of progress bars to progress of task:
            pForm.activateProgressBar(task);

            // in real life this method would get the result of the task
            // and update the UI based on its value:
            task.setOnSucceeded(event -> {
                pForm.getDialogStage().close();
//                export.setDisable(false);
            });

            // export.setDisable(true);
            pForm.getDialogStage().setTitle("PRINTING TO EXCEL");
            pForm.getDialogStage().setMinWidth(200);
            pForm.getDialogStage().setMinHeight(100);
            pForm.getDialogStage().show();

            Thread thread = new Thread(task);
            thread.start();
        });
        MenuItem exportPdf = new MenuItem("PDF");
        exportPdf.setOnAction(e -> {
            Date currentTime = new Date();
            String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
            String title = "EXPORTING EMPLOYEES TO PDF";
            String message = "Go to C:my reports/reports/ " + "members.pdf";

//            Image expenseimg = new Image("Expenses/price-tag-4.png");
            NotificationType type = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            //          tray.setImage(expenseimg);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setNotificationType(type);
            tray.showAndDismiss(Duration.seconds(5));


            ProgressForm pForm = new ProgressForm();

            // In real life this task would do something useful and return
            // some meaningful result:
            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws InterruptedException {

                    for (int i = 0; i < 1; i++) {
                        updateProgress(i, 1);

                        Thread.sleep(200);


                    }
                    //      reports.employeeToPdf.build();
                    updateProgress(20, 20);


                    return null;
                }
            };

            // binds progress of progress bars to progress of task:
            pForm.activateProgressBar(task);

            // in real life this method would get the result of the task
            // and update the UI based on its value:
            task.setOnSucceeded(event -> {
                pForm.getDialogStage().close();
//                export.setDisable(false);
            });

            // export.setDisable(true);
            pForm.getDialogStage().setTitle("PRINTING MEMBERS TO PDF");
            pForm.getDialogStage().setMinWidth(200);
            pForm.getDialogStage().setMinHeight(100);
            pForm.getDialogStage().show();

            Thread thread = new Thread(task);
            thread.start();
        });

        MenuButton savingsButton = new MenuButton("SALARIES");
        savingsButton.getItems().addAll(addSavings, savingsHistory);
        add.setGraphic(savingsButton);


        MenuButton exportButton = new MenuButton("EXPORT");
        delete.setGraphic(exportButton);
        exportButton.getItems().addAll(exportXls, exportPdf);


        MenuButton updatebutton = new MenuButton("UPDATE");
        updatebutton.getItems().addAll(quickupdate, updates);
        update.setGraphic(updatebutton);
        update.setOnAction(E -> {
            updateEmployee.updateEmployeePop();
        });
        MenuButton reportsButton = new MenuButton("REPORTS");


        MenuItem memberEvaluation = new MenuItem("GENERAL REPORT");
        memberEvaluation.setOnAction(e -> {

            String title = "GENERATING MEMBERS REPORT";
            String message = "Go to C:my reports/reports/MemberDetails.xls";

            //Image expenseimg = new Image("Expenses/price-tag-4.png");
            NotificationType type = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            //    tray.setImage(expenseimg);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.setNotificationType(type);
            tray.showAndDismiss(Duration.seconds(5));


            ProgressForm pForm = new ProgressForm();

            // In real life this task would do something useful and return
            // some meaningful result:
            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws InterruptedException {

                    for (int i = 0; i < 1; i++) {
                        updateProgress(i, 1);

                        Thread.sleep(200);


                    }
                    ///   reports.empoyeeReports.employeeReports();
                    //Reports.MemberReports.memberList();
                    updateProgress(20, 20);


                    return null;
                }
            };

            // binds progress of progress bars to progress of task:
            pForm.activateProgressBar(task);

            // in real life this method would get the result of the task
            // and update the UI based on its value:
            task.setOnSucceeded(event -> {
                pForm.getDialogStage().close();
//                export.setDisable(false);
            });

            // export.setDisable(true);
//            pForm.getDialogStage().setTitle("GENERATING MEMBERS REPORT");
//            pForm.getDialogStage().setMinWidth(200);
//            pForm.getDialogStage().setMinHeight(100);
//            pForm.getDialogStage().show();

            Thread thread = new Thread(task);
            thread.start();


        });

        MenuItem loanedMembers = new MenuItem(" STATEMENTS");

        reportsButton.getItems().addAll(memberEvaluation, loanedMembers);
        allreports.setGraphic(reportsButton);
        //     viewallbutton.getItems().addAll(allitems,edititems);


        //  home button content items
        MenuItem addshort = new MenuItem("ADD EMPLOYEE");
        addshort.setOnAction(e -> {
            employeeFirstName.requestFocus();
            employeeFirstName.requestFocus();
        });

        MenuItem deleteshort = new MenuItem("QUICK DELETE");
        deleteshort.setOnAction(e -> {
            updateEmployee.updateEmployeePop();
            //   updateEmployee.operations.getChildren().remove(updateEmployee.clear);
            updateEmployee.operations.getChildren().remove(updateEmployee.update);
            updateEmployee.operations.getChildren().remove(updateEmployee.suspend);
        });

        MenuItem allitemshort = new MenuItem("ALL EMPLOYEES");

        MenuItem updateshort = new MenuItem("UPDATE EMPLOYEES");
        updateshort.setOnAction(e -> {
            updateEmployee.updateEmployeePop();
        });

        TextField searchField = new TextField();
        searchField.setPromptText("search");
        search.setGraphic(searchField);
        searchField.setAlignment(Pos.BASELINE_RIGHT);
        searchField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (searchField.textProperty().get().isEmpty()) {
                    table.setItems(employeeList.allEmployees());
                    return;
                }
                ObservableList<employee> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<employee, ?>> cols = table.getColumns();
                for (int i = 0; i < employeeList.allEmployees().size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(employeeList.allEmployees().get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if (cellValue.contains(searchField.textProperty().get().toLowerCase())) {
                            tableItems.add(employeeList.allEmployees().get(i));
                            break;
                        }
                    }
                }
                table.setItems(tableItems);
            }
        });
//                table.setItems(tableItems);
//            }
        // });
        homebtn.getItems().addAll(addshort, deleteshort, updateshort, allitemshort);
        home.setGraphic(homebtn);

        bar.getMenus().addAll(home, add, delete, update, allreports, search);
//bar.setPadding(new Insets(10,10,10,10));

        return bar;
    }


    public static void insert(String idNumber, String firstName, String secondName, String phoneNumber, String residence, String station, String position,
                              String activeStatus, String maritalStatus, double salary, double wage, double bonus, LocalDate dob, LocalDate recruitmentDate, String password) {
        String sql = "INSERT INTO employees (  idNumber, firstName, secondName, phoneNumber,  residence,\n" +
                "                                   station,position,  activeStatus, maritalStatus, salary, wage, bonus,dob,\n" +
                "                                  recruitmentDate,altPhone) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idNumber);
            pstmt.setString(2, firstName);
            pstmt.setString(3, secondName);
            pstmt.setString(4, phoneNumber);

            pstmt.setString(5, residence);
            pstmt.setString(6, station);
            pstmt.setString(7, position);
            pstmt.setString(8, activeStatus);
            pstmt.setString(9, maritalStatus);
            pstmt.setDouble(10, salary);
            pstmt.setDouble(11, wage);
            pstmt.setDouble(12, bonus);
            pstmt.setDate(13, java.sql.Date.valueOf(dob));
            pstmt.setDate(14, java.sql.Date.valueOf(recruitmentDate));
            pstmt.setString(15, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private static Connection connect() {
        // SQLite connection string

        String url = "jdbc:sqlite:E:/IdeaProjects/PSV SACCO MANAGEMENT/resources/sacco.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


    private static void search(String searchText) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        ObservableList<String> members = FXCollections.observableArrayList();

        try {
            conn = connect();

            statement = conn.createStatement();
            String s = "SELECT idNumber FROM employees ";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                String steve = (
                        rs.getString("idNumber")


                );


                members.add(steve);


            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //Code to release your resources
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
        }


        //search the ob list
        if (searchText != null & members.contains(searchText) == true) {
            Platform.runLater(() -> {
                idNumber.clear();
            });

        } else {

        }
    }


    private static void verifyPassword() {

        String password0 = password.getText().trim();
        String password2 = password1.getText().trim();

//
//    Thread t = new Thread(() -> {
//        while (true) {
//            try {
//                Thread.sleep(6000); // sleep 5 secs
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Platform.runLater(() -> {   // Ensure data is updated on JavaFX thread
//
//     if(password2!=null&password2.matches(password0)){
//            Platform.runLater(() -> {
//                emptyFieldError.errorInPassword();
//            });
//
//        }else{
//
//        }
//
//            });
//        }
//    });
//    t.setDaemon(true);
//    t.start();

        if (password0 != password2) {

        } else {

        }
    }

//    public static void addToFirebase() throws FirebaseException, JsonParseException, JsonMappingException, IOException, JacksonUtilityException {
//        ObjectMapper mapper = new ObjectMapper();
//
//        String firebase_baseUrl = "https://aluminium-loans.firebaseio.com/";
//
//
//
//        employee newEmployee = new employee(idNumber.getText().toUpperCase().trim(), employeeFirstName.getText().toUpperCase().trim(), secondName.getText().toUpperCase().trim(),
//                phoneNumber.getText().toUpperCase().trim(), residence.getText().trim().toUpperCase(), station.getText().toUpperCase().trim(), position.getValue().toString().toUpperCase(), activeStatus.getValue().toString().toUpperCase(),
//                maritalStatus.getValue().toString().toUpperCase(), Double.parseDouble(salary.getText()), 0.0, 0.0,
//                dob.getValue(), entryDate.getValue(), password1.getText().trim());
//
//        Map<String, Object> dataMap = mapper.convertValue(newEmployee, Map.class);
//
//        Firebase firebase = new Firebase(firebase_baseUrl);
//        FirebaseResponse response = firebase.delete();
//        response = firebase.post( "EMPLOYEES", dataMap );
//        System.out.println( "\n\nResult of PUT (for the test-PUT):\n" + response );
//
//    }


}



