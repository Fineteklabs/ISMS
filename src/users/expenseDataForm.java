package users;//
//import common.emptyFieldError;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;
//import javafx.beans.binding.Bindings;
//import javafx.beans.property.ReadOnlyObjectWrapper;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.concurrent.Task;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Cursor;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.util.Callback;
//import javafx.util.Duration;
//import org.apache.commons.dbutils.DbUtils;
//import tray.animations.AnimationType;
//import tray.notification.NotificationType;
//import tray.notification.TrayNotification;
//
//import java.sql.*;
//import java.text.SimpleDateFormat;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * Created by FINETECHLABS on 26/01/2017.
// */
//public class expenseDataForm {
//    public static TableView<Expenses> table;
//    private static ObservableList<Expenses> entries = FXCollections.observableArrayList();
//    public static SplitMenuButton homebtn= new SplitMenuButton();
//    public static VBox Adding;
//    private static ComboBox <Accounts>depositAccount;
//    private static  Label depositAccountlbl;
//    private static DatePicker entryDate;
//    private static  PreparedStatement pstmt = null;
//    private static  Connection conn = null;
//    private static ResultSet rs = null;
//
//
//    private static Label  doblbl;
//    private  static  DatePicker dob;
//    private  static  Label phonenumberlbl;
//    private static ChoiceBox activity;
//    private static  Button  save;
//
//    private static Button  cancel;
//    private static   Button   clear;
//    private static  Button held;
//    private  static GridPane saving= new GridPane();
//    private static Label entryDatelbl;
//    private static TextField driverPhoneNumber;
//    private static Label employeeFirstNamelbl;
//    private static  TextField employeeFirstName;
//    private static Label secondNamelbl;
//    private static TextField secondName;
//    private static TextField idNumber;
//    private static Label idNumberlbl;
//  private static TextField salary;
//  private static Label salarylbl;
//  private static ComboBox maritalStatus;
//  private static Label maritalStatuslbl;
//  private static Label activeStatuslbl;
//  private static ComboBox activeStatus;
//  private static TextField station;
//  private static Label stationlbl;
//  private static  TextField residence;
//  private static Label residencelbl;
//private static  TextField phoneNumber;
//public static Label expenseTotallbl;
//public static Label expenseNamelbl;
//public static  Label expenseDescriptionlbl;
//public static Label paidbacklbl;
//public static Label datelbl;
//public static Label expenseIdlbl;
//public static Label standingBallbl;
//public static TextField expenseName;
//public static TextField paidback;
//public static DatePicker date;
//public static  TextArea expenseDescription;
//public static TextField expenseTotal;
//public static TextField expenseId;
//public static TextField standingBal;
//public static TextField expenseCost;
//    private static Label expenseCostlbl;
//
//
//    public static VBox Add(){
//        GridPane grid= new GridPane();
//        Adding= new VBox();
//        Adding.setPadding(new Insets(0,10,10,10));
//        expenseNamelbl= new Label("EXPENSE NAME");
//        expenseName= new TextField();
//
////            IdNumber= new TextField(){
////
////
////
////                @Override
////                public void replaceText(int start, int end, String text) {
////                    if (!text.matches("[a-z, A-Z]")) {
////                        super.replaceText(start, end, text);
////                    }
////
////                }
////
////                @Override
////                public void replaceSelection(String text) {
////                    if (!text.matches("[a-z, A-Z]")) {
////                        super.replaceSelection(text);
////                    }
////                }
////            };
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
//        expenseName.setPrefColumnCount(8);
//        grid.addColumn(0,expenseNamelbl,expenseName);
//
//        expenseDescriptionlbl = new Label("DESCRIPTION ");
//        expenseDescription= new TextArea();
//        expenseDescription.setMaxWidth(200);
//        expenseDescription.setMaxHeight(60);
//        grid.addColumn(0,expenseDescriptionlbl,expenseDescription);
//
//
//
//
//        expenseIdlbl= new Label("EXPENSE ID");
//        expenseId= new TextField();
//        grid.addColumn(0,expenseIdlbl,expenseId);
//
//
//
//
//        depositAccount= new ComboBox<>(AccountsList.getExpenseAccounts());
//        depositAccountlbl= new Label("CHOOSE ACCOUNT");
//
//        grid.addColumn(1,depositAccountlbl,depositAccount);
//
//
//        expenseTotallbl= new Label("TOTAL ");
//        expenseTotal= new TextField(){
//
//            @Override
//            public void replaceText(int start, int end, String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceText(start, end, text);
//                }
//
//            }
//
//            @Override
//            public void replaceSelection(String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceSelection(text);
//                }
//            }
//        };
//        grid.addColumn(1,expenseTotallbl,expenseTotal);
//
//
//        expenseCostlbl= new Label("EXPENSE COSTING");
//        expenseCost= new TextField(){
//
//            @Override
//            public void replaceText(int start, int end, String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceText(start, end, text);
//                }
//
//            }
//
//            @Override
//            public void replaceSelection(String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceSelection(text);
//                }
//            }
//        };
//
//
//        grid.addColumn(2,expenseCostlbl,expenseCost);
//        grid.setPadding(new Insets(20,20,50,20));
//        paidbacklbl = new Label("PAID  BACK");
//        paidback = new TextField(){
//
//            @Override
//            public void replaceText(int start, int end, String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceText(start, end, text);
//                }
//
//            }
//
//            @Override
//            public void replaceSelection(String text) {
//                if (!text.matches("[a-z, A-Z]")) {
//                    super.replaceSelection(text);
//                }
//        }
//        };
//
//
//
//        grid.addColumn(2,paidbacklbl,paidback);
//
//
//
//// Create a day cell factory
//        Callback<DatePicker, DateCell> dayCellFactory =
//                new Callback<DatePicker, DateCell>() {
//                    public DateCell call(final DatePicker datePicker) {
//                        return new DateCell() {
//                            @Override
//                            public void updateItem(LocalDate item, boolean empty) {
//                                // Must call super
//                                super.updateItem(item, empty);
//                                // Disable all future date cells
//                                if (item.isAfter(LocalDate.now())) {
//                                    this.setDisable(true);
//
//                                }
//                                // Show Weekends in blue color
//                                DayOfWeek day = DayOfWeek.from(item);
//                                if (day == DayOfWeek.SATURDAY ||
//                                        day == DayOfWeek.SUNDAY) {
//                                    this.setTextFill(Color.GREEN);
//                                }else{
//                                    this.setTextFill(Color.BROWN);
//                                }
//                            }
//                        };
//                    }};
//
//        entryDate= new DatePicker();
//        entryDate.setDayCellFactory(dayCellFactory);
//        entryDate.setEditable(false);
//        entryDatelbl= new Label("DATE  ");
//        grid.addColumn(3,entryDatelbl,entryDate);
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
//        save= new Button("save");
//        save.setOnAction(e->{
//
//
//
//            if(expenseId.getText().isEmpty()||expenseName.getText().isEmpty()||expenseDescription.getText().isEmpty()||expenseCost.getText().isEmpty()||
//
//                    entryDate.getValue().toString().isEmpty()) {
//                emptyFieldError.showFatalError();
//            }else {
//
//
//               double total = Double.parseDouble(expenseCost.getText()) ;
//
//                transactionList.insert(getCurrentTime(),depositAccount.getSelectionModel().getSelectedItem().getAccountCode(),Double.parseDouble(expenseTotal.getText()),depositAccount.getSelectionModel().getSelectedItem().getBalance()+Double.parseDouble(expenseTotal.getText()),entryDate.getValue());
//                transactionList.updateAccounts(depositAccount.getSelectionModel().getSelectedItem().getAccountName(),Double.parseDouble(expenseTotal.getText()));
//                insert(expenseId.getText().toUpperCase().trim(), expenseName.getText().toUpperCase().trim(), expenseDescription.getText().toUpperCase().trim(), total, total, entryDate.getValue(), total, 0.0);
//                table.setItems(null);
//              table.setItems(expenseList.getExpenses());
//
//                //notification  for the addition of expenses
//                String title = "NEW  EXPENSE ADDED";
//                String message = "NAME :" + expenseName.getText() + "\n TOTAL :" + expenseTotal.getText() + "" + "kshs";
//
//                Image expenseimg = new Image("Expenses/price-tag-4.png");
//                NotificationType type = NotificationType.SUCCESS;
//                TrayNotification tray = new TrayNotification();
//                tray.setTitle(title);
//                tray.setMessage(message);
//                tray.setImage(expenseimg);
//                tray.setAnimationType(AnimationType.FADE);
//                tray.setNotificationType(type);
//                tray.showAndDismiss(Duration.seconds(5));
//            }
//            expenseId.clear();
//            expenseName.clear();
//            expenseDescription.clear();
////            standingBal.clear();
//            expenseTotal.clear();
////            date.setValue(null);
//        });
//
//        //  printMember= new CheckBox("Print Member Details");
//        save.setPrefWidth(50);
//        cancel= new Button("cancel");
//        cancel.setPrefWidth(50);
//        clear= new Button("clear");
//        clear.setPrefWidth(50);
//        held= new Button("search");
//        saving.addColumn(2,save,clear,cancel);
//        saving.setHgap(10);
//        saving.setVgap(10);
//        saving.setPadding(new Insets(10,10,10,10));
//
//
//
//
//
//
//        grid.addColumn(6,save,clear,cancel);
//
//        grid.setVgap(10);
//        grid.setHgap(50);
//        Adding.getChildren().addAll(grid);
//        return Adding;
//    }
//
//
//
//    public static BorderPane expenseTableHolder() {
//        BorderPane update = new BorderPane();
//        //entries.addAll(vehicleList.allMembers());
//        table = new TableView<>();
//
//
//
//        table = new TableView<>(expenseList.getExpenses());
////define the numbering column
//        TableColumn<Expenses, Number> numberCol = new TableColumn<Expenses, Number>("#");
//        numberCol.setSortable(false);
//        numberCol.setMinWidth(50);
//        numberCol.setMaxWidth(150);
//
//        numberCol.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
//        table.getColumns().addAll(numberCol,expenseList.getIdColumn(),expenseList.getExpenseNameColumn(), expenseList.getDescription(),expenseList.getTotal(),expenseList.getPaidBack(),expenseList.getFormatedDate());
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        table.setEditable(true);
//        table.setPlaceholder(new Label("YOU HAVE NO EXPENSES"));
//        table.setPadding(new Insets(20,20,20,20));
//        table.setTableMenuButtonVisible(true);
//
//
//        table.setRowFactory(
//                new Callback<TableView<Expenses>, TableRow<Expenses>>() {
//                    @Override
//                    public TableRow<Expenses> call(TableView<Expenses> tableView) {
//                        final TableRow<Expenses> row = new TableRow<>();
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
//                            //Members.UpdatePop.updateBox();
//                        });
//                        // editItem.setOnAction(...);
//                        MenuItem removeItem = new MenuItem("delete");
//                        removeItem.setOnAction(E->{
//
//                            if(row.getItem().getPaidback()<row.getItem().getExpenseTotal()){
//
//                                Alert alert= new Alert(Alert.AlertType.WARNING);
//                                Label alertHead= new Label(row.getItem().getExpenseName()+" is an active expense\n" +
//                                        " or has a loan balance");
//                                alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
//                                Label  alertcontent=  new Label("this entry of "+row.getItem().getStandingBalance()+"will be discarded");
//                                alert.setHeaderText(alertHead.getText());
//                                alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
//                                alert.setContentText(String.valueOf(alertcontent.getText()));
//                                alert.showAndWait();
//
//                            }
////                            else  if(row.getItem().getActiveStatus()!="ACTIVE") {
//                            //remove from screen
//                            table.getItems().remove(row.getItem());
//
//                            //delete from database
//                            expenseList.delete((row.getItem().getExpenseID()));
//
//                            //notify from taskbar
//                            String title = "EXPENSE DELETED FROM THE SYSTEM";
//                            String message = "NAME :" + row.getItem().getExpenseDescription();
//
//                            Image expenseimg = new Image("Expenses/price-tag-4.png");
//                            NotificationType type = NotificationType.SUCCESS;
//                            TrayNotification tray = new TrayNotification();
//                            tray.setTitle(title);
//                            tray.setMessage(message);
//                            tray.setImage(expenseimg);
//                            tray.setAnimationType(AnimationType.FADE);
//                            tray.setNotificationType(type);
//                            tray.showAndDismiss(Duration.seconds(5));
//
//
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
//        //);
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        table.setEditable(true);
//        table.setTableMenuButtonVisible(true);
//
//
////
////        table.setRowFactory(
////                new Callback<TableView<vehicle>, TableRow<vehicle>>() {
////                    @Override
////                    public TableRow<vehicle> call(TableView<vehicle> tableView) {
////                        final TableRow<vehicle> row = new TableRow<>();
////                        final ContextMenu rowMenu = new ContextMenu();
////
////                        // "Borrow" menu items from table's context menu,
////                        // if there is one.
////                        final ContextMenu tableMenu = tableView.getContextMenu();
////                        if (tableMenu != null) {
////                            rowMenu.getItems().addAll(tableMenu.getItems());
////                            rowMenu.getItems().add(new SeparatorMenuItem());
////                        }
////                        MenuItem editItem = new MenuItem("edit");
////                        MenuItem  suspend= new MenuItem("suspend");
////                        suspend.setOnAction(e->{
////                            UpdatePop.updateBox();
////                        });
////                        // editItem.setOnAction(...);
////                        MenuItem removeItem = new MenuItem("delete");
////                        removeItem.setOnAction(E->{
////
////                            if(row.getItem().getLoanbal()> 0&&row.getItem().getActiveStatus()=="ACTIVE"){
////
////                                Alert alert= new Alert(Alert.AlertType.WARNING);
////                                Label alertHead= new Label(row.getItem().getName()+" is an active member\n" +
////                                        " or has a loan balance");
////                                alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
////                                Label  alertcontent=  new Label("please ensure outstanding loan ammount "+row.getItem().getLoanbal()+"is cleared first");
////                                alert.setHeaderText(alertHead.getText());
////                                alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
//////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
////                                alert.setContentText(String.valueOf(alertcontent.getText()));
////                                alert.showAndWait();
////
////                            }
////                            else  if(row.getItem().getActiveStatus()!="ACTIVE") {
////                                //remove from screen
////                                table.getItems().remove(row.getItem());
////
////                                //delete from database
////                                MembersList.delete(Integer.parseInt(row.getItem().getIdNumber()));
////
////                                //delete all savings entries
////                                Savings.savingsList.delete(row.getItem().getIdNumber());
////
////
////
////                                //notify from taskbar
////                                String title = "MEMBER DELETED FROM THE SYSTEM";
////                                String message = "NAME :" + row.getItem().getName();
////
////                                Image expenseimg = new Image("Expenses/price-tag-4.png");
////                                NotificationType type = NotificationType.SUCCESS;
////                                TrayNotification tray = new TrayNotification();
////                                tray.setTitle(title);
////                                tray.setMessage(message);
////                                tray.setImage(expenseimg);
////                                tray.setAnimationType(AnimationType.FADE);
////                                tray.setNotificationType(type);
////                                tray.showAndDismiss(Duration.seconds(5));
////                            }
//////}else{
//////    Alert alert= new Alert(Alert.AlertType.WARNING);
//////    Label alertHead= new Label(row.getItem().getName()+" is an active member\n" +
//////            " or has a loan balance");
//////    alertHead.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 7));
//////
//////    Label  alertcontent=  new Label("please ensure loan ammount "+row.getItem().getLoanbal()+"is cleared first");
//////    alertcontent.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 5));
//////    alert.setHeaderText(alertHead.getText());
//////
////////alert.getStylesheets().add(MainView.class.getResource("MainView.css").toExternalForm());
//////    alert.setContentText(String.valueOf(alertcontent.getText()));
//////    alert.showAndWait();
//////}
////
////
//////37167568262
////
////
////
////                        });
////
////                        rowMenu.getItems().addAll(editItem,suspend, removeItem);
////
////                        // only display context menu for non-null items:
////                        row.contextMenuProperty().bind(
////                                Bindings.when(Bindings.isNotNull(row.itemProperty()))
////                                        .then(rowMenu)
////                                        .otherwise((ContextMenu)null));
////                        return row;
////                    }
////                });
////
//
//
//
//
//
//
//
////DeleteMember.deleteSelected();
//        //TableView.TableViewSelectionModel<Member> tsm = table.getSelectionModel();
//        //tsm.setSelectionMode(SelectionMode.MULTIPLE);
//
//
//
//
//
//        //table.setItems(entries);
//        table.setPadding(new Insets(20,20,20,20));
//        table.setPlaceholder( new Label(" NO RECORDED EXPENSES"));
////table.setItems(entries);
//
//
//
//
//
//        VBox centerlayout = new VBox();
//
//        centerlayout.getChildren().addAll( table);
//        centerlayout.setSpacing(50);
//        centerlayout.setPadding(new Insets(20, 20, 20, 20));
//
//
//        //   tsm.setCellSelectionEnabled(true);
//
//        //TOP OF MEMBER VIEW TAB
//        // update.setTop(mainmenu());
//
//
//        update .setCenter(centerlayout);
//
//        //update.setTop(txt);
//        return update;
//    }
//
//
//
//    public static MenuBar mainmenu(){
//        Menu  top= new Menu();
//
//        MenuBar bar= new MenuBar();
//        Menu home= new Menu();
//
//        homebtn.setOnAction(e->{
////            centraldata.setCenter(null);
////            //  MembersView.centraldata.setTop(null);
////            centraldata.setBottom(null);
////            centraldata.setLeft(null);
////            centraldata.setRight(null);
//            BorderPane contents= new BorderPane();
//            //  contents.setSpacing(10);
//            //
////            centraldata.setTop(Design.mainmenu());
////            centraldata.setCenter(Design.updateItems());
////            centraldata.setBottom(AddData.Add());
////            centraldata.setRight(LeftSider.memberDetails());
////            contents.setCenter(Design.savingsTable());
////            contents.setBottom(SavingsDesign.memberDetails());
////            contents.setTop(SavingsDesign.topmenu());
//            // contents.getChildren().addAll(SavingsDesign.savingsTable(),);
//            //  MembersView.centraldata.setCenter(contents);
//            // MembersView.centraldata.setBottom(SavingsDesign.memberDetails());
//            //   MembersView.centraldata.setTop();
//        });
//        homebtn.setText("HOME");
//
//        Menu add= new Menu();
//        Menu delete= new Menu();
//        Menu update= new Menu();
//        Menu reports= new Menu();
//        Menu search= new Menu();
//        bar.setPadding(new Insets(0,20,0,20));
//        bar.setCursor(Cursor.HAND);
//
//        // MenuItem recent= new MenuItem("recently added");
//        MenuItem   editDetails= new MenuItem("EDIT EXPENSE");
//        editDetails.setOnAction(e->{
//
//            // Inventory.border.setCenter(AddItem.main());
//            //Inventory.cinfo.setText("RECEIVE  ITEMS");
//
//
//        });
//
//
//        MenuItem addBill= new MenuItem(" ENTER BILLS");
//
//        addBill.setOnAction(e->{
//            //   AddSavings.updateBox();
//        });
//        MenuItem  payingExpenses= new MenuItem("PAY EXPENSES");
//        payingExpenses.setOnAction(e->{
//
//            payExpense.paying();
//        });
//
//        MenuItem updates= new MenuItem("EXPENSES");
//        updates.setOnAction(e->{
//            //  UpdatePop.updateBox();
//        });
//        MenuItem  quickupdate = new MenuItem("DELETE EXPENSES");
//        quickupdate.setOnAction(e->{
//            //DeleteMember.deletePane();
//            //Inventory.border.setCenter(UpdateItem.updateItems());
//            // Inventory.cinfo.setText("UPDATE ITEMS");
//
//        });
//
//
//
//        MenuItem exportXls= new MenuItem("EXCEL");
//       exportXls.setOnAction(e->{
//
//           String title = "EXPORTING EXPENSES TO EXCEL";
//           String message = "Go to C:my reports/reports/Expenses";
//
//           Image expenseimg = new Image("Expenses/price-tag-4.png");
//           NotificationType type = NotificationType.INFORMATION;
//           TrayNotification tray = new TrayNotification();
//           tray.setTitle(title);
//           tray.setMessage(message);
//           tray.setImage(expenseimg);
//           tray.setAnimationType(AnimationType.SLIDE);
//           tray.setNotificationType(type);
//           tray.showAndDismiss(Duration.seconds(5));
//
//
//
//
//         ProgressForm pForm = new ProgressForm();
//
//           // In real life this task would do something useful and return
//           // some meaningful result:
//           Task<Void> task = new Task<Void>() {
//               @Override
//               public Void call() throws InterruptedException {
//
//                   for (int i = 0; i < 1; i++) {
//                       updateProgress(i, 1);
//
//                       Thread.sleep(200);
//
//
//                   }
//                   ExpenseToXls.build();
//                   updateProgress(20, 20);
//
//
//
//                   return null ;
//               }
//           };
//
//           // binds progress of progress bars to progress of task:
//           pForm.activateProgressBar(task);
//
//           // in real life this method would get the result of the task
//           // and update the UI based on its value:
//           task.setOnSucceeded(event -> {
//               pForm.getDialogStage().close();
//            //   export.setDisable(false);
//           });
//
//        //   export.setDisable(true);
//           pForm.getDialogStage().setTitle("PRINTING EXPENSES");
//           pForm.getDialogStage().setMinWidth(200);
//           pForm.getDialogStage().setMinHeight(100);
//           pForm.getDialogStage().show();
//
//           Thread thread = new Thread(task);
//           thread.start();
//      });
//
//        MenuItem exportPdf= new MenuItem("PDF");
////        exportPdf.setOnAction(e->{
////            Date currentTime= new Date();
////            String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
////            String title = "EXPORTING MEMBERS TO PDF";
////            String message = "Go to C:my reports/reports/ "+MembersToPdf.getCurrentTime()+"members.pdf";
////
////            Image expenseimg = new Image("Expenses/price-tag-4.png");
////            NotificationType type = NotificationType.INFORMATION;
////            TrayNotification tray = new TrayNotification();
////            tray.setTitle(title);
////            tray.setMessage(message);
////            tray.setImage(expenseimg);
////            tray.setAnimationType(AnimationType.SLIDE);
////            tray.setNotificationType(type);
////            tray.showAndDismiss(Duration.seconds(5));
////
////
////
////
////            ProgressForm pForm = new ProgressForm();
////
////            // In real life this task would do something useful and return
////            // some meaningful result:
////            Task<Void> task = new Task<Void>() {
////                @Override
////                public Void call() throws InterruptedException {
////
////                    for (int i = 0; i < 1; i++) {
////                        updateProgress(i, 1);
////
////                        Thread.sleep(200);
////
////
////                    }
////                    MembersToPdf.build();
////                    updateProgress(20, 20);
////
////
////
////                    return null ;
////                }
////            };
////
////            // binds progress of progress bars to progress of task:
////            pForm.activateProgressBar(task);
////
////            // in real life this method would get the result of the task
////            // and update the UI based on its value:
////            task.setOnSucceeded(event -> {
////                pForm.getDialogStage().close();
//////                export.setDisable(false);
////            });
////
////            // export.setDisable(true);
////            pForm.getDialogStage().setTitle("PRINTING MEMBERS TO PDF");
////            pForm.getDialogStage().setMinWidth(200);
////            pForm.getDialogStage().setMinHeight(100);
////            pForm.getDialogStage().show();
////
////            Thread thread = new Thread(task);
////            thread.start();
////        });
//
//        MenuButton savingsButton= new MenuButton("EDIT");
//        savingsButton.getItems().addAll(addBill,payingExpenses);
//        add.setGraphic(savingsButton);
//
//
//
//        MenuButton exportButton= new MenuButton("EXPORT");
//        delete.setGraphic(exportButton);
//        exportButton.getItems().addAll(exportXls,exportPdf);
//
//
//        MenuButton  updatebutton= new MenuButton("UPDATE");
//        updatebutton.getItems().addAll(quickupdate,updates);
//        update.setGraphic(updatebutton);
//        MenuButton  reportsButton= new MenuButton("REPORTS");
//
//
//
//        MenuItem memberEvaluation= new MenuItem("GENERAL REPORT");
//        memberEvaluation.setOnAction(e->{
//
//            String title = "GENERATING EXPENSE REPORT";
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
//                    Reports.ExpenseReports.expenseList();
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
//     pForm.getDialogStage().setTitle("GENERATING EXPENSE REPORT");
//           pForm.getDialogStage().setMinWidth(200);
//          pForm.getDialogStage().setMinHeight(100);
//           pForm.getDialogStage().show();
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
//
//        MenuItem loanedMembers= new MenuItem(" STATEMENTS");
//
//        reportsButton.getItems().addAll(memberEvaluation,loanedMembers);
//        reports.setGraphic(reportsButton);
//        //     viewallbutton.getItems().addAll(allitems,edititems);
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
//        //  home button content items
//        MenuItem  addshort= new MenuItem("ADD EXPENSE");
//        addshort.setOnAction(e->{
//
//            //    Inventory.border.setCenter(AddItem.main());
//            //   Inventory.cinfo.setText("RECEIVE  ITEMS");
//
//        });
//
//        MenuItem payexpenses= new MenuItem("PAY EXPENSES");
//        payexpenses.setOnAction(e->{
//
////            table.setItems(null);
////         table.setItems(expenseList.getExpenses());
//           payExpense.paying();
//        });
//
//        MenuItem  allitemshort= new MenuItem("ALL EXPENSES");
//        MenuItem updateshort= new MenuItem("UPDATE EXPENSES");
//        updateshort.setOnAction(e->{
//            //  Inventory.border.setCenter(UpdateItem.updateItems());
//            /// Inventory.cinfo.setText("UPDATE ITEMS");
//        });
//
//        TextField searchField= new TextField();
//        searchField.setPromptText("search");
//        search.setGraphic(searchField);
//        searchField.setAlignment(Pos.BASELINE_RIGHT);
////        searchField.textProperty().addListener(new InvalidationListener() {
////            @Override-
////            public void invalidated(Observable observable) {
////                if(searchField.textProperty().get().isEmpty()){
////                    table.setItems(MembersList.allMembers());
////                    return;
////                }
////                ObservableList<Member>tableItems=FXCollections.observableArrayList();
////                ObservableList<TableColumn<Member,?>>cols=table.getColumns();
////                for(int i=0;i<MembersList.allMembers().size();i++){
////                    for(int j=0;j<cols.size();j++){
////                        TableColumn col=cols.get(j);
////                        String cellValue=col.getCellData(MembersList.allMembers().get(i)).toString();
////                        cellValue= cellValue.toLowerCase();
////                        if(cellValue.contains(searchField.textProperty().get().toLowerCase())){
////                            tableItems.add(MembersList.allMembers().get(i));
////                            break;
////                        }
////                    }
////                }
////                table.setItems(tableItems);
////            }
//        // });
//        homebtn.getItems().addAll(addshort,payexpenses,updateshort,allitemshort);
//        home.setGraphic(homebtn);
//
//        bar.getMenus().addAll(home, add, delete, update, reports,search);
////bar.setPadding(new Insets(10,10,10,10));
//
//        return  bar;
//    }
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
//
//
//
//
//
//
//
//
//
//    public static void insert( String  registrationNumber, String vehicleModel, int vehicleSeats,String ownerIdNumber,  String ownerFirstName,
//                               String ownerLastName,String ownerPhoneNumber, String driverIdNumber,String driverFirstName,String driverLastName,String driverPhoneNumber,String conductorIdNumber,String conductorFirstName,
//                               String conductorLastName,   Double totalContributions, double loanBalance, double outStandingFine,
//                               double serviceCharges,LocalDate entryDate) {
//        String sql = "INSERT INTO vehicles (  registrationNumber, vehicleModel, vehicleSeats,ownerIdNumber,  ownerFirstName,\n" +
//                "                                   ownerLastName,ownerPhoneNumber,  driverIdNumber, driverFirstName, driverLastName, driverPhoneNumber, conductorIdNumber,String conductorFirstName,\n" +
//                "                                  conductorLastName, totalContributions,  loanBalance, outStandingFine,\n" +
//                "                                   serviceCharges, entryDate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        try (Connection conn =  connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, registrationNumber);
//            pstmt.setString(2, vehicleModel);
//            pstmt.setInt(3, vehicleSeats);
//            pstmt.setString(4, ownerIdNumber);
//            pstmt.setDate(5, java.sql.Date.valueOf(entryDate));
//            pstmt.setString(6,ownerLastName);
//            pstmt.setString(7,ownerPhoneNumber);
//            pstmt.setString(8,driverIdNumber);
//            pstmt.setString(9,driverFirstName);
//            pstmt.setString(10,ownerFirstName);
//            pstmt.setString(11,driverLastName);
//            pstmt.setString(12,driverPhoneNumber);
//            pstmt.setString(13,conductorIdNumber);
//            pstmt.setString(14,conductorFirstName);
//            pstmt.setString(15,conductorLastName);
//            pstmt.setDouble(16,totalContributions);
//            pstmt.setDouble(17,loanBalance);
//            pstmt.setDouble(18,outStandingFine);
//            pstmt.setDouble(19,serviceCharges);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//
//    private static Connection connect() {
//        // SQLite connection string
//
//        String url = "jdbc:sqlite:C:\\Povo Data\\members.db";
//        Connection conn = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//
//    public static String getCurrentTime(){
//
//        Calendar cal = Calendar.getInstance();
//        return  cal.getTime().toString();
//
//    }
//    public static void insert( String expenseID,String expenseName, String expenseDescription, Double expenseTotal, double expenseCost, LocalDate DATE,double  paidback,double standinBal) {
//
//        try {
//
//            String sql = "INSERT INTO ExpenseList (expenseID,expenseName, expenseDescription,  expenseTotal, expensecost, DATE,paidback,standingBalance ) VALUES(?,?,?,?,?,?,?,?)";
//
//
//
//            // Do stuff
////            savepoint1 = conn.setSavepoint("savepoint1");
//            conn = connect();
//            //  conn.setAutoCommit(false);
//            pstmt = conn.prepareStatement(sql);
//
//            pstmt.setString(1,  expenseID);
//            pstmt.setString(2, expenseDescription);
//            pstmt.setString(3,expenseName);
//            pstmt.setDouble(4, expenseTotal);
//            pstmt.setDouble(5, expenseCost);
//            pstmt.setDate(6, java.sql.Date.valueOf(DATE));
//            pstmt.setDouble(7,paidback);
//            pstmt.setDouble(8,standinBal);
//            pstmt.executeUpdate();
//            conn.commit();
//
//        } catch (SQLException e) {
//            System.out.print(e);
//
//        } finally {
//            DbUtils.closeQuietly(pstmt);
//            DbUtils.closeQuietly(rs);
//            DbUtils.closeQuietly(conn);
//        }
//    }
//
//
//}
//
//
//
//
//
//
