package classification;

/**
 * Created by FINETEKLABS on 7/10/2017.
 */

import common.emptyFieldError;
import javafx.application.Platform;
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
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by FINETECHLABS on 26/01/2017.
 */
public class examDataForm {
    public static TableView<exams> table;
    public static ObservableList<exams> accountlist = FXCollections.observableArrayList();
    public static SplitMenuButton homebtn = new SplitMenuButton();
    public static VBox Adding;
    private static ObservableList<exams> entries = FXCollections.observableArrayList();
    private static TextField lastName;
    private static Label currentTerm;
    private static ComboBox currentTermField;


    private static TextField openingBalance;
    private static Label openingBalancelbl;

    private static TextField fineCount;
    private static Label fineCountlbl;
    private static ComboBox classification;
    private static Label classificationlbl;
    private static TextField loanBal;

    private static Label dividendsRatelbk;
    private static TextField dividendsRate;

    private static Label taxRatelbl;
    private static TextField taxRate;

    private static Label classificationNamelbl;
    private static TextField classificationName;

    private static Label classificationIdlbl;
    private static TextField classificationId;

    private static Label driverIdNumberLbl;
    private static CheckBox printVehicle;
    private static Label printVehiclelbl;
    private static DatePicker entryDate;
    private static Label driverPhoneNumberlbl;
    private static Label lastNamelbl;
    private static Label spousefirstName;
    private static Label spouseIdLabel;
    private static Label spouselastNamelbl;


    private static Label openingBallbl;
    private static Label scheduleReviewlbl;
    private static DatePicker scheduleReview;
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

    private static Label insurancelbl;
    private static TextField insurance;

    private static Label minimmumIncomelbl;
    private static TextField minimmumIncome;
    private static TextField idNumber;
    private static Label idNumberlbl;

    private static Label maximmumIncomelbl;
    private static TextField maximmumIncome;

    private static TextField salary;
    private static Label salarylbl;
    private static ComboBox maritalStatus;
    private static Label creditLimitlbl;
    private static Label activeStatuslbl;
    private static ComboBox activeStatus;
    private static TextField creditLimit;
    private static Label stationlbl;
    private static TextField residence;
    private static Label residencelbl;
    private static TextField phoneNumber;
    private static Label firstNamelbl;
    private static TextField firstName;
    private static TextArea classificationDescription;
    private static Label classificationDescriptionlbl;
    private static Label dividendsRatelbl;
    private static ExecutorService executor;

    public static VBox Add() {
        GridPane grid = new GridPane();
        Adding = new VBox();
        Adding.setPadding(new Insets(10, 10, 10, 10));
        classificationIdlbl = new Label(" exam id");
        classificationId = new TextField() {
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


        classificationId.setPrefColumnCount(8);
        grid.addColumn(0, classificationIdlbl, classificationId);

        classificationNamelbl = new Label(" exam name");
        classificationName = new TextField() {
            final int maxChars = 20;
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
        grid.addColumn(0, classificationNamelbl, classificationName);

        currentTerm = new Label("current term");

        currentTermField = new ComboBox();
        currentTermField.getItems().addAll("ALL", "SENIORS", " JUNIORS");
        currentTermField.setMinWidth(150);

        grid.addColumn(0, currentTerm, currentTermField);


        classificationlbl = new Label("classes");
        classification = new ComboBox();
        classification.getItems().addAll("ALL", "SENIORS", " JUNIORS");
        classification.setMinWidth(150);
        grid.addColumn(1, classificationlbl, classification);


        grid.setPadding(new Insets(20, 20, 50, 20));


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
        entryDatelbl = new Label("start date  ");
        grid.addColumn(3, entryDatelbl, entryDate);


        scheduleReviewlbl = new Label("end date");
        scheduleReview = new DatePicker();
        grid.addColumn(3, scheduleReviewlbl, scheduleReview);


        creditLimitlbl = new Label("CREDIT LIMIT");
        creditLimit = new TextField() {
            final int maxChars = 8;
            final String restictTo = "[ 0-9]";

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
        grid.addColumn(4, creditLimitlbl, creditLimit);


        save = new Button("save");
        save.setOnAction(e -> {
            executor = Executors.newFixedThreadPool(2);

//check if all input forms are filled
            if (classificationId.getText().isEmpty() || classificationDescription.getText().isEmpty() || minimmumIncome.getText().isEmpty() || maximmumIncome.getText().isEmpty() ||
                    taxRate.getText().isEmpty() || dividendsRate.getText().isEmpty() || insurance.getText().isEmpty() || scheduleReview.getValue().toString().isEmpty() || entryDate.getValue().toString().isEmpty()) {
                emptyFieldError.showFatalError();
            } else {
                // executor = Executors.newFixedThreadPool(4);
                // executor.execute(new database.addClassificationToFirebase(classificationId.getText().trim().toUpperCase(),classificationName.getText().trim().toUpperCase(),classificationDescription.getText().trim().trim(),Double.parseDouble(minimmumIncome.getText().trim()),Double.parseDouble(maximmumIncome.getText().trim()),Double.parseDouble(creditLimit.getText()),Double.parseDouble(dividendsRate.getText().trim().toUpperCase()),Double.parseDouble(dividendsRate.getText()),Double.parseDouble(taxRate.getText().trim().toUpperCase()),scheduleReview.getValue(),entryDate.getValue()));

//                    try {
//                        database.addClassificationToFirebase.upload(new MemberClassification(classificationId.getText().trim().toUpperCase(),classificationName.getText().trim().toUpperCase(),classificationDescription.getText().trim().trim(),Double.parseDouble(minimmumIncome.getText().trim()),Double.parseDouble(maximmumIncome.getText().trim()),Double.parseDouble(creditLimit.getText()),Double.parseDouble(dividendsRate.getText().trim().toUpperCase()),Double.parseDouble(dividendsRate.getText()),Double.parseDouble(taxRate.getText().trim().toUpperCase()),scheduleReview.getValue(),entryDate.getValue()));
//                    } catch (FirebaseException e1) {
//                        e1.printStackTrace();
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    } catch (JacksonUtilityException e1) {
//                        e1.printStackTrace();
//                    }


                //  executor.execute(new saveClassification(classificationId.getText().trim().toUpperCase(),classificationName.getText().trim().toUpperCase(),classificationDescription.getText().trim().trim(),Double.parseDouble(minimmumIncome.getText().trim()),Double.parseDouble(maximmumIncome.getText().trim()),Double.parseDouble(creditLimit.getText()),Double.parseDouble(insurance.getText().trim().toUpperCase()),Double.parseDouble(dividendsRate.getText()),Double.parseDouble(taxRate.getText().trim().toUpperCase()),scheduleReview.getValue(),entryDate.getValue()));
//

                table.setItems(null);


                String title = "CLASSIFICATION ADDED";
                String message = "NAME :" + classificationName.getText() + "\nID: :" + classificationId.getText();

                // Image expenseimg = new Image("Expenses/price-tag-4.png");
                NotificationType type = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle(title);
                tray.setMessage(message);
                // tray.setImage(expenseimg);
                tray.setAnimationType(AnimationType.FADE);
                tray.setNotificationType(type);
                tray.showAndDismiss(Duration.seconds(5));
//

                classificationId.clear();
                classificationName.clear();
                entryDate.getEditor().clear();
                classificationDescription.clear();
                minimmumIncome.clear();
                maximmumIncome.clear();
                taxRate.clear();
                insurance.clear();
                dividendsRate.clear();
                // lastName.clear();


            }        // }
        });

        //  printMember= new CheckBox("Print Member Details");
        save.setPrefWidth(50);
        cancel = new Button("cancel");
        cancel.setPrefWidth(50);
        clear = new Button("clear");
        clear.setPrefWidth(50);
        held = new Button("search");
        saving.addColumn(2, save, clear, cancel);
        saving.setHgap(10);
        saving.setVgap(10);
        saving.setPadding(new Insets(10, 10, 10, 10));


        grid.addColumn(6, save, clear, cancel);

        grid.setVgap(10);
        grid.setHgap(20);
        Adding.getChildren().addAll(grid);
        return Adding;
    }


    public static BorderPane EmployeeTableHolder() {
        BorderPane update = new BorderPane();
        //entries.addAll(vehicleList.allMembers());
        table = new TableView<>();

        table.setEditable(true);


        TableColumn<exams, Number> numberCol = new TableColumn<exams, Number>("#");
        numberCol.setSortable(false);
        table.getColumns().addAll(examList.getExamId(),
                examList.getExamName(),
                examList.getCurrentTerm(),
                examList.getLevelId(),
                examList.getStartDate(),
                examList.getEndDate());
        numberCol.setMinWidth(50);
        numberCol.setMaxWidth(150);

        numberCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));


//                MembersList.getFine(),
//                MembersList.getReferee(),
//                MembersList.getTotalWorth()
        //     vehicleList.getContributions()

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);
        table.setTableMenuButtonVisible(true);
//        try {
//            getFromDatabase();
//        } catch (FirebaseException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JacksonUtilityException e) {
//            e.printStackTrace();
//        }

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


        table.setItems(examList.examsList());
        table.setPadding(new Insets(20, 20, 20, 20));
        table.setPlaceholder(new Label(" PLEASE ADD ::CLASSES" +
                " INTO THE SYSTEM"));
//table.setItems(entries);


        VBox centerlayout = new VBox();

        centerlayout.getChildren().addAll(table);
        centerlayout.setSpacing(10);
        centerlayout.setPadding(new Insets(20, 20, 20, 20));


        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50000); // sleep 5 secs
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {   // Ensure data is updated on JavaFX thread
                    table.setItems(null);
                    table.setItems(examList.examsList());


                });
            }
        });
        t.setDaemon(true);
        t.start();
        update.setCenter(centerlayout);


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
        MenuItem editDetails = new MenuItem("EDIT DETAILS");
        editDetails.setOnAction(e -> {

            // Inventory.border.setCenter(AddItem.main());
            //Inventory.cinfo.setText("RECEIVE  ITEMS");


        });


        MenuItem addSavings = new MenuItem(" ADD EMPLOYEE");

        addSavings.setOnAction(e -> {
            //   AddSavings.updateBox();
        });
        MenuItem savingsHistory = new MenuItem("EMPLOYEE PAYMENTS");
        savingsHistory.setOnAction(e -> {


        });

        MenuItem updates = new MenuItem("EMPLOYEES");
        updates.setOnAction(e -> {
            //  UpdatePop.updateBox();
        });
        MenuItem quickupdate = new MenuItem("DELETE EMPLOYEE");
        quickupdate.setOnAction(e -> {
            //DeleteMember.deletePane();
            //Inventory.border.setCenter(UpdateItem.updateItems());
            // Inventory.cinfo.setText("UPDATE ITEMS");

        });


        MenuItem exportXls = new MenuItem("EXCEL");
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
        MenuItem exportPdf = new MenuItem("PDF");
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

        MenuButton savingsButton = new MenuButton("SALARIES");
        savingsButton.getItems().addAll(addSavings, savingsHistory);
        add.setGraphic(savingsButton);


        MenuButton exportButton = new MenuButton("EXPORT");
        delete.setGraphic(exportButton);
        exportButton.getItems().addAll(exportXls, exportPdf);


        MenuButton updatebutton = new MenuButton("UPDATE");
        updatebutton.getItems().addAll(quickupdate, updates);
        update.setGraphic(updatebutton);
        MenuButton reportsButton = new MenuButton("REPORTS");


        MenuItem memberEvaluation = new MenuItem("GENERAL REPORT");
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

        MenuItem loanedMembers = new MenuItem(" STATEMENTS");

        reportsButton.getItems().addAll(memberEvaluation, loanedMembers);
        reports.setGraphic(reportsButton);
        //     viewallbutton.getItems().addAll(allitems,edititems);


        //  home button content items
        MenuItem addshort = new MenuItem("ADD EMPLOYEE");
        addshort.setOnAction(e -> {

            //    Inventory.border.setCenter(AddItem.main());
            //   Inventory.cinfo.setText("RECEIVE  ITEMS");

        });

        MenuItem deleteshort = new MenuItem("QUICK DELETE");
        deleteshort.setOnAction(e -> {


        });

        MenuItem allitemshort = new MenuItem("ALL EMPLOYEES");
        MenuItem updateshort = new MenuItem("UPDATE EMPLOYEE");
        updateshort.setOnAction(e -> {
            //  Inventory.border.setCenter(UpdateItem.updateItems());
            /// Inventory.cinfo.setText("UPDATE ITEMS");
        });

        TextField searchField = new TextField();
        searchField.setPromptText("search");
        search.setGraphic(searchField);
        searchField.setAlignment(Pos.BASELINE_RIGHT);
//        searchField.textProperty().addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                if(searchField.textProperty().get().isEmpty()){
//                    table.setItems(MembersList.allMembers());
//                    return;
//                }
//                ObservableList<Member>tableItems=FXCollections.observableArrayList();
//                ObservableList<TableColumn<Member,?>>cols=table.getColumns();
//                for(int i=0;i<MembersList.allMembers().size();i++){
//                    for(int j=0;j<cols.size();j++){
//                        TableColumn col=cols.get(j);
//                        String cellValue=col.getCellData(MembersList.allMembers().get(i)).toString();
//                        cellValue= cellValue.toLowerCase();
//                        if(cellValue.contains(searchField.textProperty().get().toLowerCase())){
//                            tableItems.add(MembersList.allMembers().get(i));
//                            break;
//                        }
//                    }
//                }
//                table.setItems(tableItems);
//            }
        // });
        homebtn.getItems().addAll(addshort, deleteshort, updateshort, allitemshort);
        home.setGraphic(homebtn);

        bar.getMenus().addAll(home, add, delete, update, reports, search);
//bar.setPadding(new Insets(10,10,10,10));

        return bar;
    }


//    public static void getFromDatabase() throws FirebaseException, JsonParseException, JsonMappingException, IOException, JacksonUtilityException {
//
//        Thread t = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(5000); // sleep 5 secs
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//
//                }
//
//
//                String firebase_baseUrl = "https://aluminium-loans.firebaseio.com/";
//                try {
//                    Firebase firebase = new Firebase(firebase_baseUrl);
//                    FirebaseResponse response = firebase.get("CLASSIFICATION");
//                    Map<String, Object> dataMap = response.getBody();
//                    Set<String> keyste = dataMap.keySet();
//                    accountlist.removeAll();
//                    while (dataMap.size()>accountlist.size()){
//                        for (String s : keyste) {
////System.out.println("KEYS",+);
//                            LinkedHashMap<String, Object> account = (LinkedHashMap<String, Object>) dataMap.get(s);
//                            MemberClassification newAcc = new MemberClassification(account.get( "classificationCode").toString(),
//                                    account.get("classificationName").toString(),
//                                    account.get("classificationDescription").toString(),
//                                    (Double) account.get("minimmumIncome") ,
//                                    (Double) account.get("maximmumIncome"),
//                                    (Double) account.get("creditLimit"),
//                                    (Double) account.get("insurance"),
//                                    (Double) account.get("dividends"),
//                                    (Double) account.get("tax"),
//                                    (LocalDate) account.get("entryDate"),
//                                    (LocalDate)account.get("scheduleReview"));
//                            System.out.println(newAcc.toString());
//                            System.out.println(dataMap.get(s).toString());
//
//                            accountlist.add(newAcc);
//                        }}
//
//                } catch (FirebaseException e) {
//                    e.printStackTrace();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//
//
//                Platform.runLater(() -> {
//                    // Ensure data is updated on JavaFX thread
//
//
//                    //  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//                    table.setItems(null);
//                    table.setItems(accountlist);
//                });
//            }
//        });
//        t.setDaemon(true);
//        t.start();
//
//
//        //  table.setItems(accountlist);
//
//        //  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//
////        Accounts newAccounts= new Accounts(accountType.getValue().toString(),accountName.getText(),accountCode.getText(),description.getText(),Double.parseDouble(balance.getText()));
//
//
//        //  System.out.println( "\n\nRESULTS FOR ACCOUNTS):\n" + response );
//
//        //  Accounts newAcc= new Accounts(dataMap.get("accountCode").toString(),dataMap.get("accountDescription").toString(),dataMap.get("AccountName").toString(), dataMap.get("AccountType").toString(),(double)dataMap.get("balance"));
//
//
//        //Map<String,Object> hashmap= new HashedMap();
//        //  hashmap.putAll(dataMap);
//        // final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//        //   Accounts pojo = mapper.convertValue(dataMap, Accounts.class);
//        // Accounts neAccount= mapper.convertValue(hashmap, Accounts.class);
//        // JSONObject jsonobject=response.getBody().
//        // List<Value> values = dataMap.values().stream().collect(Collectors.toList());
//        // table.getItems().add(neAccount)
//        //  System.out.println( "\n\nRESULTS FOR ACCOUNTS):\n" + pojo );
////Accounts newAccount= new Accounts(dataMap.values().)
////        Thread t = new Thread(() -> {
////            while (true) {
////                try {
////                    Thread.sleep(500000); // sleep 5 secs
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                Platform.runLater(() -> {
////                    // Ensure data is updated on JavaFX thread
////                    table.setItems(null);
////                    table.setItems(accountlist);
////                });
////            }
////        });
////        t.setDaemon(true);
////        t.start();
//
////        table.setItems(null);
////                   table.setItems(accountlist);
//
//
//    }


//
//    public static void insert(String classificationId,String classificationName,String classificationDescription,Double minimmumIncome,Double maximmumIncome, Double creditLimit,Double Insurance, Double dividends,Double taxRate, LocalDate entryDate,LocalDate scheduleReview) {
//        String sql = "INSERT INTO classification (  classificationId, classificationName, classificationDescription, minimmumIncome,  maximmumIncome,creditLimit,Insurance,   dividends, taxRate, creationDate, scheduleReview) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//
//        try (Connection conn = classificationList.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, classificationId);
//            pstmt.setString(2, classificationName);
//            pstmt.setString(3, classificationDescription);
//            pstmt.setDouble(4, minimmumIncome);
//
//            pstmt.setDouble(5, maximmumIncome);
//            pstmt.setDouble(6, creditLimit);
//            pstmt.setDouble(7, Insurance);
//            pstmt.setDouble(8, dividends);
//            pstmt.setDouble(9, taxRate);;
//            pstmt.setDate(10, java.sql.Date.valueOf(entryDate));
//            pstmt.setDate(11, java.sql.Date.valueOf(scheduleReview));
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


}




























































