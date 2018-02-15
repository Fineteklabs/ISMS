//package common;
//
////import com.jfoenix.controls.JFXButton;
//import employees.employee;
//import eu.hansolo.medusa.Gauge;
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//
///**
// * Created by FINETECHLABS on 29/04/2017.
// */
//public class Users extends Application {
//
//    public  static VBox loginScreen;
//    public static ComboBox<employees.employee> users;
//    public static PasswordField userpassword;
//    public static Label username;
//    public static  Label password;
//    public static Button login;
//    public static Button logout;
//    public static Separator rightSeparator;
//    public static Label error;
//    public static Label name;
//    public static GridPane gridtwo;
//    public static Label nameholder;
//    public static Label phone;
//    public static Label phoneHolder;
//    public static Label dateEntered;
//    public static Label dateEnteredHoLder;
//    public static Label IdNumber;
//    public static Label station;
//    public static Label stationHolder;
//    public static Separator separatorOne;
//    public static Separator separatorTwo;
//    public static VBox loginSuccessfulScreen;
//    public static VBox rightContent;
//    public static Label challenge;
//    public static Label success;
//    public static Stage stage;
//    public static Stage stageone;
//    public static GridPane gridone;
//    public static HBox topmenu;
//    public  static Label titleLabel;
//    public static  Stage  mainStage;
//    public static Scene scene;
//    public VBox border;
//    private static GridPane leftarea;
//    public static BorderPane mainBorder;
//    private Gauge members;
//    private Gauge    empGauge;
//    private Gauge    outloans;
//    private Gauge    reminders;
//    private Gauge    expenses;
//    private Gauge    interest;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        stageone= new Stage();
//        scene= new Scene(loginMenu(),400,200);
//        //  stage= new Stage(StageStyle.UNDECORATED);
//        stageone.setScene(scene);
//        stageone.setTitle("LOGIN");
//        stageone.setResizable(false);
//        stageone.show();
//    }
//
//
//
//
//    public  static VBox loginMenu(){
//        loginScreen= new VBox();
//        gridtwo= new GridPane();
//        loginScreen.setSpacing(15);
//        users= new ComboBox(employees.employeeList.allEmployees());
//        users.setEditable(false);
//        userpassword= new PasswordField();
//        userpassword.setOnKeyPressed(e->{
//            if(e.getCode()== KeyCode.ENTER) {
//                if(users.getValue().getPassword().matches(userpassword.getText().trim())&users.getValue().getPosition().matches("OFFICER")){
////                    MainView.reportstab.setDisable(false);
////                    MainView.vehicles.setDisable(false);
//  MainView.loans.setDisable(false);
//                    MainView.savings.setDisable(false);
//                   MainView.expenses.setDisable(false);
//                 MainView.logout.setDisable(false);
//                   MainView.accounts.setDisable(false);
//                    MainView.employees.setDisable(false);
//                    MainView.rate.setDisable(false);
//                    MainView.members.setDisable(false);
//                    MainView.classification.setDisable(false);
//                    stage.close();
//                    // gridone.getChildren().removeAll(username,password,userpassword,users);
//
//
////gridtwo.addRow(0,logout);
//                    //   logout.setPadding(new Insets(50,20,0,200));
////                topmenu.getChildren().add(logout);
////                topmenu.setSpacing(500);
////                login.setDisable(true);
//
//                    userpassword.clear();
//                }else if(users.getValue().getPassword().matches(userpassword.getText().trim())&users.getValue().getPosition().matches("ASSISTANT")){
//                    //MainView.reportstab.setDisable(false);
////                    MainView.vehicles.setDisable(false);
////                    //MainView.employees.setDisable(false);
////                    MainView.offences.setDisable(false);
////                    MainView.savings.setDisable(false);
//                    // gridone.getChildren().removeAll(username,password,userpassword,users);
//                    MainView.logout.setDisable(false);
//                    MainView.login.setDisable(true);
//                    stage.close();
////gridtwo.addRow(
//
//                    userpassword.clear();
//                }else{
//                    common.emptyFieldError.errorInPassword();
//                }
//
//
//
//            }
//        });
//     //   userpassword.setStyle("-fx-background-radius: 5;-fx-border-color: #8BC34A;-fx-border-radius: 5;-fx-border-width: 5;");
//        username= new Label("USERNAME");
//
//        gridtwo.addColumn(1,username,users);
//        password= new Label("PASSWORD");
//        login= new Button();
//        login.setText("LOGIN");
//
//        login.setStyle(
//                " -fx-padding: 0.7em 0.57em;"+
//                        " -fx-font-size: 10px;"+
//                        "  -jfx-button-type: RAISED;"+
//                        "   -fx-background-color:  #004d40;"+
//                        " -fx-pref-width: 70;"+
//                        " -fx-text-fill: WHITE;"
//        );
//
//        login.setOnAction(e->{
//            if(users.getValue().getPassword().matches(userpassword.getText().trim())&users.getValue().getPosition().matches("OFFICER")){
////                MainView.reportstab.setDisable(false);
////                MainView.vehicles.setDisable(false);
////                MainView.employees.setDisable(false);
////                MainView.offences.setDisable(false);
////                MainView.savings.setDisable(false);
//                MainView.logout.setDisable(false);
//                MainView.login.setDisable(true);
//                stage.close();
//                // gridone.getChildren().removeAll(username,password,userpassword,users);
//
//
////gridtwo.addRow(0,logout);
//             //   logout.setPadding(new Insets(50,20,0,200));
////                topmenu.getChildren().add(logout);
////                topmenu.setSpacing(500);
////                login.setDisable(true);
//
//                userpassword.clear();
//            }else if(users.getValue().getPassword().matches(userpassword.getText().trim())&users.getValue().getPosition().matches("ASSISTANT")){
//                //MainView.reportstab.setDisable(false);
////                MainView.vehicles.setDisable(false);
////                //MainView.employees.setDisable(false);
////                MainView.offences.setDisable(false);
////                MainView.savings.setDisable(false);
//                // gridone.getChildren().removeAll(username,password,userpassword,users);
//
////gridtwo.addRow(0,logout);
//              //  logout.setPadding(new Insets(50,20,0,200));
//                topmenu.getChildren().add(logout);
//                topmenu.setSpacing(500);
//                login.setDisable(true);
//
//                userpassword.clear();
//            }else{
//                common.emptyFieldError.errorInPassword();
//            }
//
//
//            // mainStage.sizeToScene();
//        });
//        gridtwo.addColumn(1,password,userpassword,login);
//        gridtwo.setVgap(10);
//        gridtwo.setHgap(10);
//        gridtwo.setPadding(new Insets(20,20,20,20));
//
//        users.setCellFactory(
//                new Callback<ListView<employee>,ListCell<employee>>() {
//                    @Override
//                    public ListCell<employee> call(ListView<employee> listView) {
//                        return new ListCell<employee>() {
//                            @Override
//                            public void updateItem(employee item, boolean empty) {
//                                // Must call super
//                                super.updateItem(item, empty);
//                                int index = this.getIndex();
//                                String name = null;
//                                String description= null;
//                                // Format name
//                                if (item == null || empty) {
//
//                                    // No action to perform
//                                } else {
//                                    name = (index + 1) + ". " +
//                                            item.getFirstName()+" ";
//
//                                    description="ID.NO:"+item.getIdNumber();
//                                }
//                                // this.setText(name);
//                                Label namelbl= new Label();
//                                namelbl.setFont(Font.font("FontAwesome", FontWeight.BOLD, 10));
//                                namelbl.setText(name);
//                                Button btn= new Button("+");
//                                GridPane  grid= new GridPane();
//                                grid.setVgap(2);
//                                grid.setHgap(1);
//                                grid.setPadding(new Insets(0, 10, 0, 10));
//                                grid.addRow(0,namelbl);
//                                Label deslbl= new Label();
//                                deslbl.setText(description);
//                                HBox hbox= new HBox();
//                                hbox.getChildren().addAll(grid);
//                                deslbl.setFont(Font.font("FontAwesome", FontWeight.BOLD, 10));
//                                grid.addRow(1,deslbl);
//
//                                users.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<employee>() {
//                                    @Override
//                                    public void changed(ObservableValue<? extends employee> observable, employee oldValue, employee newValue) {
//
//                                    }
//                                });
//                                setGraphic(hbox);
//                            }
//                        };
//                    }});
//        loginScreen.getChildren().addAll(gridtwo);
//        return loginScreen;
//    }
//
//
//
//
//    public static void login(){
//        HBox hbox= new HBox();
//        stage= new Stage();
//        scene= new Scene(loginMenu(),300,180);
//
//scene.setFill(Color.TRANSPARENT);
//        //  stage= new Stage(StageStyle.UNDECORATED);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.setTitle("LOGIN");
//        stage.initModality(Modality.APPLICATION_MODAL
//        );
//        stage.setResizable(false);
//        stage.show();
//
//        //return hbox;
//    }
//}
