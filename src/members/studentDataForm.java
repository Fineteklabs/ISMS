package members;

import common.emptyFieldError;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;
import org.apache.commons.dbutils.DbUtils;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by FINETECHLABS on 26/01/2017.
 */
public class studentDataForm {
    public static TableView<student> table;
    public static SplitMenuButton homebtn = new SplitMenuButton();
    public static VBox Adding;
    private static ObservableList<student> entries = FXCollections.observableArrayList();
    private static TextField lastName;
    private static TextField otherNames;
    private static Label otherNameslbl;
    ;
    private static ComboBox<classification.classification> classification;
    private static Label classificationlbl;
    private static TextField emailAdress;
    private static Label emailAdresslbl;

    private static DatePicker entryDate;
    private static Label driverPhoneNumberlbl;
    private static Label lastNamelbl;
    private static Label doblbl;
    private static DatePicker dob;
    private static Label phonenumberlbl;
    private static ChoiceBox activity;
    private static Button save;
    private static GridPane saving = new GridPane();
    private static Label entryDatelbl;
    private static TextField idNumber;
    private static Label idNumberlbl;

    private static Label activeStatuslbl;
    private static ComboBox<String> activeStatus;
    private static TextField station;
    private static Label stationlbl;
    private static TextField residence;
    private static Label residencelbl;
    private static TextField phoneNumber;
    private static Label firstNamelbl;
    private static TextField firstName;
    private static ExecutorService executor;

    public static GridPane Add() {

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(30);
        Adding = new VBox();
        Adding.setPadding(new Insets(10, 10, 10, 10));
        idNumberlbl = new Label("student identificaton");

        idNumber = new TextField() {
            final int maxChars = 12;
            final String restictTo = "[ 0-9,a-z A-Z ]";

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

        idNumber.textProperty().addListener(
                (observable, oldValue, newValue) ->
                        search(idNumber.getText().toUpperCase().trim())
        );


        grid.addColumn(0, idNumberlbl, idNumber);


        firstNamelbl = new Label(" first name");
        firstName = new TextField() {
            final int maxChars = 12;
            final String restictTo = "[ 0-9,a-z A-Z ]*";

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


        firstName.setPrefColumnCount(8);
        grid.addColumn(0, firstNamelbl, firstName);

        lastNamelbl = new Label("last name");
        lastName = new TextField() {
            final int maxChars = 12;
            final String restictTo = "[ a-z A-Z ]*";

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
        grid.addColumn(0, lastNamelbl, lastName);

        otherNameslbl = new Label("admission number");

        otherNames = new TextField() {
            final int maxChars = 12;
            final String restictTo = "[ a-z A-Z ]";

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
        grid.addColumn(0, otherNameslbl, otherNames);


        classificationlbl = new Label("classes");
        classification = new ComboBox();
        // classification.getItems().addAll(classificationList.classificationList());
        classification.setMinWidth(150);
        grid.addColumn(1, classificationlbl, classification);


        phonenumberlbl = new Label("phone number");
        phoneNumber = new TextField() {
            final int maxChars = 13;
            final String restictTo = "[ 0-9]+";

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


        residencelbl = new Label("home ");
        residence = new TextField() {
            final int maxChars = 10;
            final String restictTo = "[ 0-9,a-z A-Z ]*";

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


        grid.addColumn(1, residencelbl, residence);
        grid.setPadding(new Insets(20, 20, 50, 20));
        emailAdresslbl = new Label("email");
        emailAdress = new TextField() {
            final int maxChars = 30;
            final String restictTo = "[ 0-9,a-z A-Z,.@ ]";

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


        emailAdress.setPromptText("email ");
        grid.addColumn(1, emailAdresslbl, emailAdress);


        activeStatuslbl = new Label("active status");
        activeStatus = new ComboBox<>();
        activeStatus.setMinWidth(150);
        activeStatus.getItems().addAll("active", "inactive");
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
                                // Show Weekends in brown  color
                                DayOfWeek wday = DayOfWeek.from(item);
                                if (wday == DayOfWeek.SATURDAY ||
                                        wday == DayOfWeek.SUNDAY) {
                                    this.setTextFill(Color.GREEN);
                                } else {
                                    this.setTextFill(Color.YELLOW);
                                }
                            }
                        };
                    }
                };

        entryDate = new DatePicker();
        entryDate.setDayCellFactory(dayCellFactory);
        entryDate.setEditable(false);
        entryDatelbl = new Label("admission date  ");
        grid.addColumn(3, entryDatelbl, entryDate);


        doblbl = new Label("date of birth");
        dob = new DatePicker();
        grid.addColumn(3, doblbl, dob);


        save = new Button("save");
        save.setOnAction(e -> {


//check if all input forms are filled
            if (idNumber.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty() || phoneNumber.getText().isEmpty() ||
                    emailAdress.getText().isEmpty() ||
                    otherNames.getText().isEmpty() ||

                    //  activity.getValue().toString().isEmpty()||
                    dob.getValue().toString().isEmpty()) {
                emptyFieldError.showFatalError();
            } else {
//
                executor = Executors.newFixedThreadPool(2);


//                    executor.execute(new saveMember(idNumber.getText().trim().toUpperCase(),
//                            firstName.getText().trim().toUpperCase(),
//                            lastName.getText().trim().toUpperCase(),
//                            otherNames.getText().trim().toUpperCase(),
//                            phoneNumber.getText().trim().toUpperCase(),
//                            emailAdress.getText().trim().toUpperCase(),
//                            residence.getText().trim().toUpperCase(),
//                            0.0,
//                            classification.getSelectionModel().getSelectedItem().getTaxRate(),
//                            classification.getSelectionModel().getSelectedItem().getInsuranceRate(),refereeIdNumber.getText().trim().toUpperCase(),refereeFirstName.getText().trim().toUpperCase(),
//                            refereeSecondName.getText().trim().toUpperCase(),
//                            Double.parseDouble(salary.getText()),
//                            Double.parseDouble(salary.getText()),0.0,
//                            classification.getSelectionModel().getSelectedItem().getDividendsRate(),0.0,
//                            activeStatus.getSelectionModel().getSelectedItem().trim(),0.0,0.0,
//                            classification.getSelectionModel().getSelectedItem().maximmumIncome(),
//                            classification.getSelectionModel().getSelectedItem().getClassificationId(),"NONE "," NONE",dob.getValue()));
//


                String title = "NEW MEMBER ADDED";
                String message = "NAME :" + firstName.getText() + "\n o.bal :" + "" + "kshs";

                //  Image expenseimg = new Image("Expenses/price-tag-4.png");
                NotificationType type = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                // tray.setImage(expenseimg);
                tray.setAnimationType(AnimationType.FADE);
                tray.setNotificationType(type);
                tray.showAndDismiss(Duration.seconds(5));


//
//
                idNumber.clear();
                firstName.clear();
                dob.getEditor().clear();
                residence.clear();
                phoneNumber.clear();
                lastName.clear();
                emailAdress.clear();
                residence.clear();


            }
        });

        //  printMember= new CheckBox("Print Member Details");

        ;
        // saving.setPadding(new Insets(10,10,10,10));


        grid.addColumn(5, save);
        //grid.addColumn(6,save,clear,cancel);

        return grid;
    }


    public static BorderPane EmployeeTableHolder() {
        BorderPane update = new BorderPane();
        entries.addAll(studentList.student_with_classes());
        table = new TableView<>();


        TableColumn<student, Number> numberCol = new TableColumn<student, Number>("#");
        numberCol.setSortable(false);
        numberCol.setMinWidth(50);
        numberCol.setMaxWidth(150);

        numberCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        table.getColumns().addAll(numberCol,
                studentList.getAdmissionNumber(),
                studentList.getFullName(),
                studentList.getCurrentClass(),
                studentList.getStream(),
                studentList.getActiveStatus(),
                studentList.getAdmissionDate()
                //     vehicleList.getContributions()
        );
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);
        table.setTableMenuButtonVisible(true);


        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(30000); // sleep 5 secs
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {   // Ensure data is updated on JavaFX thread
                    table.setItems(null);
                    table.setItems(studentList.student_with_classes());


                });
            }
        });
        t.setDaemon(true);
        t.start();
//
//        table.setRowFactory(
//                new Callback<TableView<vehicle>, TableRow<vehicle>>() {
//                    @Override
//                    public TableRow<vehicle> call(TableView<vehicle> tableView) {
//                        final TableRow<vehicle> row = new TableRow<>();
//                        final ContextMenu rowMenu = new ContextMenu();
//
//                        // "Borrow" menu items from table's context menu,
//                        // if there is one.
//                        final ContextMenu tableMenu = tableView.getContextMenu();
//                        if (tableMenu != null) {
//                            rowMenu.getItems().addAll(tableMenu.getItems());
//                            rowMenu.getItems().add(new SeparatorMenuItem());
//                        }
//                        MenuItem editItem = new MenuItem("edit");
//                        MenuItem  suspend= new MenuItem("suspend");
//                        suspend.setOnAction(e->{
//                            UpdatePop.updateBox();
//                        });
//                        // editItem.setOnAction(...);
//                        MenuItem removeItem = new MenuItem("delete");
//                        removeItem.setOnAction(E->{
//
//                            if(row.getItem().getLoanbal()> 0&&row.getItem().getActiveStatus()=="ACTIVE"){
//
//                                Alert alert= new Alert(Alert.AlertType.WARNING);
//                                Label alertHead= new Label(row.getItem().getName()+" is an active member\n" +
//                                        " or has a loan balance");
//                                alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
//                                Label  alertcontent=  new Label("please ensure outstanding loan ammount "+row.getItem().getLoanbal()+"is cleared first");
//                                alert.setHeaderText(alertHead.getText());
//                                alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
//                                alert.setContentText(String.valueOf(alertcontent.getText()));
//                                alert.showAndWait();
//
//                            }
//                            else  if(row.getItem().getActiveStatus()!="ACTIVE") {
//                                //remove from screen
//                                table.getItems().remove(row.getItem());
//
//                                //delete from database
//                                MembersList.delete(Integer.parseInt(row.getItem().getIdNumber()));
//
//                                //delete all savings entries
//                                Savings.savingsList.delete(row.getItem().getIdNumber());
//
//
//
//                                //notify from taskbar
//                                String title = "MEMBER DELETED FROM THE SYSTEM";
//                                String message = "NAME :" + row.getItem().getName();
//
//                                Image expenseimg = new Image("Expenses/price-tag-4.png");
//                                NotificationType type = NotificationType.SUCCESS;
//                                TrayNotification tray = new TrayNotification();
//                                tray.setTitle(title);
//                                tray.setMessage(message);
//                                tray.setImage(expenseimg);
//                                tray.setAnimationType(AnimationType.FADE);
//                                tray.setNotificationType(type);
//                                tray.showAndDismiss(Duration.seconds(5));
//                            }
////}else{
////    Alert alert= new Alert(Alert.AlertType.WARNING);
////    Label alertHead= new Label(row.getItem().getName()+" is an active member\n" +
////            " or has a loan balance");
////    alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
////
////    Label  alertcontent=  new Label("please ensure loan ammount "+row.getItem().getLoanbal()+"is cleared first");
////    alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
////    alert.setHeaderText(alertHead.getText());
////
//////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
////    alert.setContentText(String.valueOf(alertcontent.getText()));
////    alert.showAndWait();
////}
//
//
////37167568262
//
//
//
//                        });
//
//                        rowMenu.getItems().addAll(editItem,suspend, removeItem);
//
//                        // only display context menu for non-null items:
//                        row.contextMenuProperty().bind(
//                                Bindings.when(Bindings.isNotNull(row.itemProperty()))
//                                        .then(rowMenu)
//                                        .otherwise((ContextMenu)null));
//                        return row;
//                    }
//                });
//


//DeleteMember.deleteSelected();
        //TableView.TableViewSelectionModel<Member> tsm = table.getSelectionModel();
        //tsm.setSelectionMode(SelectionMode.MULTIPLE);


        table.setItems(entries);
        table.setPadding(new Insets(20, 20, 20, 20));
        table.setPlaceholder(new Label(" PLEASE ADD ::MEMBER INTO THE SYSTEM"));
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
        Menu reports = new Menu();
        Menu search = new Menu();
        bar.setPadding(new Insets(0, 20, 0, 20));
        bar.setCursor(Cursor.HAND);

        // MenuItem recent= new MenuItem("recently added");
        MenuItem editDetails = new MenuItem("edit student details");
        editDetails.setOnAction(e -> {

            // Inventory.border.setCenter(AddItem.main());
            //Inventory.cinfo.setText("RECEIVE  ITEMS");


        });


        MenuItem addStudent = new MenuItem(" add new student");

        addStudent.setOnAction(e -> {
            //   AddSavings.updateBox();
        });
        MenuItem paymentHisory = new MenuItem("fee payment");
        paymentHisory.setOnAction(e -> {


        });

        MenuItem allExams = new MenuItem("all exams");
        allExams.setOnAction(e -> {
            //  UpdatePop.updateBox();
        });
        MenuItem addmarks = new MenuItem("add exam");
        addmarks.setOnAction(e -> {
            //DeleteMember.deletePane();
            //Inventory.border.setCenter(UpdateItem.updateItems());
            // Inventory.cinfo.setText("UPDATE ITEMS");

        });


        MenuItem exportXls = new MenuItem("excel");
//        exportXls.setOnAction(e->{
//            String title = "EXPORTING MEMBERS TO EXCEL";
//            String message = "Go to C:my reports/reports/MemberDetails.xls";
//
//            Image expenseimg = new Image("Expenses/price-tag-4.png");
//            NotificationType type = NotificationType.INFORMATION;
//            TrayNotification tray = new TrayNotification();
//            tray.setTitle(title);
//            tray.setMessage(message);
//            tray.setImage(expenseimg);
//            tray.setAnimationType(AnimationType.SLIDE);
//            tray.setNotificationType(type);
//            tray.showAndDismiss(Duration.seconds(5));
//
//
//
//
//            ProgressForm pForm = new ProgressForm();
//
//            // In real life this task would do something useful and return
//            // some meaningful result:
//            Task<Void> task = new Task<Void>() {
//                @Override
//                public Void call() throws InterruptedException {
//
//                    for (int i = 0; i < 1; i++) {
//                        updateProgress(i, 1);
//
//                        Thread.sleep(200);
//
//
//                    }
//                    MembersToXls.build();
//                    //Reports.MemberReports.memberList();
//                    updateProgress(20, 20);
//
//
//
//                    return null ;
//                }
//            };
//
//            // binds progress of progress bars to progress of task:
//            pForm.activateProgressBar(task);
//
//            // in real life this method would get the result of the task
//            // and update the UI based on its value:
//            task.setOnSucceeded(event -> {
//                pForm.getDialogStage().close();
////                export.setDisable(false);
//            });
//
//            // export.setDisable(true);
//            pForm.getDialogStage().setTitle("PRINTING MEMBERS TO EXCEL");
//            pForm.getDialogStage().setMinWidth(200);
//            pForm.getDialogStage().setMinHeight(100);
//            pForm.getDialogStage().show();
//
//            Thread thread = new Thread(task);
//            thread.start();
//        });
        MenuItem exportPdf = new MenuItem("pdf");
//        exportPdf.setOnAction(e->{
//            Date currentTime= new Date();
//            String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
//            String title = "EXPORTING MEMBERS TO PDF";
//            String message = "Go to C:my reports/reports/ "+MembersToPdf.getCurrentTime()+"members.pdf";
//
//            Image expenseimg = new Image("Expenses/price-tag-4.png");
//            NotificationType type = NotificationType.INFORMATION;
//            TrayNotification tray = new TrayNotification();
//            tray.setTitle(title);
//            tray.setMessage(message);
//            tray.setImage(expenseimg);
//            tray.setAnimationType(AnimationType.SLIDE);
//            tray.setNotificationType(type);
//            tray.showAndDismiss(Duration.seconds(5));
//
//
//
//
//            ProgressForm pForm = new ProgressForm();
//
//            // In real life this task would do something useful and return
//            // some meaningful result:
//            Task<Void> task = new Task<Void>() {
//                @Override
//                public Void call() throws InterruptedException {
//
//                    for (int i = 0; i < 1; i++) {
//                        updateProgress(i, 1);
//
//                        Thread.sleep(200);
//
//
//                    }
//                    MembersToPdf.build();
//                    updateProgress(20, 20);
//
//
//
//                    return null ;
//                }
//            };
//
//            // binds progress of progress bars to progress of task:
//            pForm.activateProgressBar(task);
//
//            // in real life this method would get the result of the task
//            // and update the UI based on its value:
//            task.setOnSucceeded(event -> {
//                pForm.getDialogStage().close();
////                export.setDisable(false);
//            });
//
//            // export.setDisable(true);
//            pForm.getDialogStage().setTitle("PRINTING MEMBERS TO PDF");
//            pForm.getDialogStage().setMinWidth(200);
//            pForm.getDialogStage().setMinHeight(100);
//            pForm.getDialogStage().show();
//
//            Thread thread = new Thread(task);
//            thread.start();
//        });

        MenuButton savingsButton = new MenuButton("Fees");
        savingsButton.getItems().addAll(paymentHisory);
        add.setGraphic(savingsButton);


        MenuButton exportButton = new MenuButton("utilities");
        delete.setGraphic(exportButton);
        exportButton.getItems().addAll(exportXls, exportPdf);


        MenuButton examButton = new MenuButton("exams");
        examButton.getItems().addAll(addmarks, allExams);
        update.setGraphic(examButton);
        MenuButton reportsButton = new MenuButton("report forms");


        MenuItem memberEvaluation = new MenuItem("all reports");
//        memberEvaluation.setOnAction(e->{
//
//            String title = "GENERATING MEMBERS REPORT";
//            String message = "Go to C:my reports/reports/MemberDetails.xls";
//
//            Image expenseimg = new Image("Expenses/price-tag-4.png");
//            NotificationType type = NotificationType.INFORMATION;
//            TrayNotification tray = new TrayNotification();
//            tray.setTitle(title);
//            tray.setMessage(message);
//            tray.setImage(expenseimg);
//            tray.setAnimationType(AnimationType.SLIDE);
//            tray.setNotificationType(type);
//            tray.showAndDismiss(Duration.seconds(5));
//
//
//
//
//            ProgressForm pForm = new ProgressForm();
//
//            // In real life this task would do something useful and return
//            // some meaningful result:
//            Task<Void> task = new Task<Void>() {
//                @Override
//                public Void call() throws InterruptedException {
//
//                    for (int i = 0; i < 1; i++) {
//                        updateProgress(i, 1);
//
//                        Thread.sleep(200);
//
//
//                    }
//                    Reports.MemberReports.memberList();
//                    //Reports.MemberReports.memberList();
//                    updateProgress(20, 20);
//
//
//
//                    return null ;
//                }
//            };
//
//            // binds progress of progress bars to progress of task:
//            pForm.activateProgressBar(task);
//
//            // in real life this method would get the result of the task
//            // and update the UI based on its value:
//            task.setOnSucceeded(event -> {
//                pForm.getDialogStage().close();
////                export.setDisable(false);
//            });
//
//            // export.setDisable(true);
////            pForm.getDialogStage().setTitle("GENERATING MEMBERS REPORT");
////            pForm.getDialogStage().setMinWidth(200);
////            pForm.getDialogStage().setMinHeight(100);
////            pForm.getDialogStage().show();
//
//            Thread thread = new Thread(task);
//            thread.start();
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        });

        MenuItem loanedMembers = new MenuItem(" report forms");
        reportsButton.getItems().addAll(memberEvaluation, loanedMembers);
        reports.setGraphic(reportsButton);
        //     viewallbutton.getItems().addAll(allitems,edititems);


        //  home button content items
        MenuItem addshort = new MenuItem("add students");
        addshort.setOnAction(e -> {

            //    Inventory.border.setCenter(AddItem.main());
            //   Inventory.cinfo.setText("RECEIVE  ITEMS");

        });

        MenuItem deleteshort = new MenuItem("Quick delete");
        deleteshort.setOnAction(e -> {


        });

        MenuItem allitemshort = new MenuItem("all students");
        MenuItem updateshort = new MenuItem("Udate students");
        updateshort.setOnAction(e -> {
            //  Inventory.border.setCenter(UpdateItem.updateItems());
            /// Inventory.cinfo.setText("UPDATE ITEMS");
        });


        TextField searchField = new TextField();
        searchField.setPromptText("search");
        search.setGraphic(searchField);
        searchField.setAlignment(Pos.BASELINE_RIGHT);
        searchField.textProperty().addListener(new InvalidationListener() {


            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if (searchField.textProperty().get().isEmpty()) {
                    table.setItems(studentList.student_with_classes());
                    return;
                }
                ObservableList<student> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<student, ?>> cols = table.getColumns();
                for (int i = 0; i < studentList.student_with_classes().size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(studentList.student_with_classes().get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if (cellValue.contains(searchField.textProperty().get().toLowerCase())) {
                            tableItems.add(studentList.student_with_classes().get(i));
                            break;
                        }

                    }
                    table.setItems(tableItems);
                }
            }
        });
        homebtn.getItems().addAll(addshort, deleteshort, updateshort, allitemshort);
        home.setGraphic(homebtn);

        bar.getMenus().addAll(home, add, delete, update, reports, search);

        return bar;
    }



    private static void search(String searchText) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        ObservableList<String> members = FXCollections.observableArrayList();

        try {
            conn = database.currentDb.mysql_connection();

            statement = conn.createStatement();
            String s = "SELECT id FROM  sims.students";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                String steve = (
                        rs.getString("id")


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
        if (members.contains(searchText) == true) {
            Platform.runLater(() -> {
                idNumber.clear();
            });
            emptyFieldError.RepeatedValue();
        } else {

        }
    }

}






