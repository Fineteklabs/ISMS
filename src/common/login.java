//package common;
//import accounts.Accounts;
//import accounts.AccountsList;
//import com.jfoenix.controls.JFXComboBox;
//import eu.hansolo.medusa.*;
//import eu.hansolo.tilesfx.Country;
//import eu.hansolo.tilesfx.Tile;
//import eu.hansolo.tilesfx.TileBuilder;
//import eu.hansolo.tilesfx.tools.FlowGridPane;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Orientation;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Stop;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Stage;
//import members.Member;
//import members.MembersList;
//
//import java.util.Locale;
//
//
///**
// * Created by FINETECHLABS on 04/01/2017.
// */
//public class login extends Tab {
//    public  static VBox loginScreen;
//    public static JFXComboBox<employees.employee> users;
//    public static PasswordField userpassword;
//    public static Label username;
//    public static  Label password;
//    public static Button login;
//    public static Button logout;
//    public static Separator rightSeparator;
//    public static Label error;
//    public static Label name;
//    private static final    double TILE_WIDTH  = 150;
//    private static final    double TILE_HEIGHT = 150;
//    public static GridPane gridtwo;
//    public static Label nameholder;
//    public static Label phone;
//    private Gauge membersGauge;
//    private Gauge    employeesGauge;
//    private Gauge    outloansGauge;
//    private Gauge    remindersGauge;
//    private Gauge    expensesGauge;
//    private Gauge    interestGauge;
//    public static Label phoneHolder;
//    public static Label dateEntered;
//    public static Label dateEnteredHoLder;
//    public static Label IdNumber;
//    public static Label station;
//    public static Label stationHolder;
//public static Separator separatorOne;
//    public static Separator separatorTwo;
//public static VBox loginSuccessfulScreen;
//    public static VBox rightContent;
//    public static Label challenge;
//    public static Label success;
//    public static Stage stage;
//   public static GridPane gridone;
//    public static HBox topmenu;
//    public  static Label titleLabel;
//    public static  Stage  mainStage;
//    public static Scene scene;
//    public VBox border;
//    private static GridPane leftarea;
//    private static Gauge    members;
//    private static Gauge    empGauge;
//    private static Gauge    outloans;
//    private static Gauge    reminders;
//    private static Gauge    expenses;
//    private static Gauge    interest;
//    public static BorderPane mainBorder;
//
//
//    private static Tile            stockTile;
//    private static Tile            percentageTile;
//    private static Tile            clockTile;
//    private Tile            gaugeTile;
//    private Tile            sparkLineTile;
//    private Tile            areaChartTile;
//    private Tile            lineChartTile;
//    private Tile            highLowTile;
//    private Tile            timerControlTile;
//    private static Tile            numberTile;
//    private static Tile            textTile;
//    private static Tile            plusMinusTile;
//    private Tile            sliderTile;
//    private static Tile            switchTile;
//    private Tile            worldTile;
//    private Tile            weatherTile;
//    private Tile            timeTile;
//    private Tile            barChartTile;
//    private static Tile            customTile;
//    private Tile            leaderBoardTile;
//    private Tile            mapTile;
//    private Tile            radialChartTile;
//    private Tile            donutChartTile;
//    private static Tile            circularProgressTile;
//
//    private static Tile            gaugeSparkLineTile;
//    private Tile            radarChartTile1;
//    private Tile            radarChartTile2;
//    private Tile            smoothAreaChartTile;
//    private static Tile            countryTile;
//    public login(String title, Node graphic) {
//        this.setText(title);
//        this.setGraphic(graphic);
//        init();
//    }
//
//    public void init() {
//
//
//        this.setContent(GeneralInfo());
//    }
//
//
//    public BorderPane GeneralInfo() {
// gridone= new GridPane();
//        mainBorder = new BorderPane();
//        separatorTwo= new Separator();
//        separatorTwo.setPadding(new Insets(10,10,10,10));
//        separatorTwo.setOrientation(Orientation.VERTICAL);
//       // grid.addColumn(3,separatorTwo);
//        mainBorder.setEffect(new DropShadow(5, Color.GRAY));
//
//        mainBorder.setPadding(new Insets(20,20,20,20));      // loggedInMenu().setEffect(new DropShadow(10, Color.CADETBLUE));
//    //  gridone.addColumn(6,loginMenu());
//        //gridone.addColumn(7,loggedInMenu());
//     // gridone.addColumn(2,newCenter());
//      gridone.addColumn(5,immediatePane());
//        separatorOne= new Separator();
//        separatorOne.setPadding(new Insets(10,10,10,10));
//        separatorOne.setOrientation(Orientation.VERTICAL);
//     //   grid.addColumn(6,separatorOne);
//      //gridone.addColumn(7,loggedInMenu());
//       // mainBorder.getStyleClass().addAll()
//mainBorder.setCenter(gridone);
////mainBorder.setTop(topMenuone());
////mainBorder.setRight(RightSiderContent());
//        // Create a horizontal separator
//        return mainBorder;
//
//    }
//
//public static VBox loggedInMenu(){
//    GridPane grid= new GridPane();
//    grid.setStyle("-fx-border-color:  #0091EA;-fx-border-insets:5;" +
//            "-fx-border-style:solid;" +
//            "-fx-border-width: 2;-fx-border-radius: 20;-fx-background-color:  #0091EA;-fx-background-radius: 20");
//    loginSuccessfulScreen= new VBox();
//    loginSuccessfulScreen.setSpacing(15);
//    loginSuccessfulScreen.setMaxHeight(700);
//    loginSuccessfulScreen.setSpacing(20);
//    loginSuccessfulScreen.setPadding(new Insets(50,100,50,50));
//    loginSuccessfulScreen.setMaxWidth(800);
//    loginSuccessfulScreen.setMinWidth(600);
//    loginSuccessfulScreen.setPrefHeight(600);
//    grid.setVgap(20);
//    grid.setHgap(20);
//    grid.setPadding(new Insets(50,50,50,0));
//
//
//    //grid.add(logout,8,0);
//loginSuccessfulScreen.getChildren().addAll(grid);
//
//return loginSuccessfulScreen;
//    }
//
//
//
//
//
//    public  static VBox loginMenu(){
//        loginScreen= new VBox();
//      gridtwo= new GridPane();
//        gridtwo.setStyle("-fx-border-color:  #0091EA;-fx-border-insets:5;" +
//                "-fx-border-style:solid;" +
//                "-fx-border-width: 2;-fx-border-radius: 20;-fx-background-color:  #0091EA;-fx-background-radius: 20");
//        loginScreen.setSpacing(15);
//        loginScreen.setMaxHeight(700);
//        loginScreen.setPadding(new Insets(50,100,50,20));
//        loginScreen.setMaxWidth(800);
//
//
//        users= new JFXComboBox(employees.employeeList.allEmployees());
//users.setEditable(false);
//        users.setMaxWidth(150);
//        userpassword= new PasswordField();
//        userpassword.setStyle("-fx-background-radius: 5;-fx-border-color: #8BC34A;-fx-border-radius: 5;-fx-border-width: 5;");
//        userpassword.setStyle("");
//        username= new Label("USERNAME");
//      //  username.setFont(Font.font("FontAwesome", FontWeight.BOLD, FontPosture.ITALIC,15));
//        username.setStyle("-fx-text-fill: #A7FFEB;-fx-text-alignment: center;-fx-font-size: 20");
//Label loginarea= new Label();
//loginarea.setFont(Font.font("FontAwesome", FontWeight.BOLD, FontPosture.REGULAR,20));
//loginarea.setText("LOGIN AREA");
//loginarea.setStyle("-fx-text-fill: #A7FFEB;-fx-text-alignment: right;-fx-font-size: 30;-fx-font-effect:engrave;");
//    //    gridtwo.addRow(1,loginarea);
//      //  gridtwo.addRow(5,username,users);
//        password= new Label("PASSWORD");
//        password.setFont(Font.font("FontAwesome", FontWeight.BOLD, FontPosture.ITALIC,15));
//        password.setStyle("-fx-text-fill: #A7FFEB;-fx-text-alignment: center;-fx-font-size: 20");
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
////                userpassword.clear();
////                MainView.login.setDisable(true);
////                MainView.logout.setDisable(false);
//Users.stage.close();
//
//            }else if(users.getValue().getPassword().matches(userpassword.getText().trim())&users.getValue().getPosition().matches("ASSISTANT")){
//                //MainView.reportstab.setDisable(false);
////                MainView.vehicles.setDisable(false);
////                userpassword.clear();
////                MainView.offences.setDisable(false);
////                MainView.savings.setDisable(false);
////                MainView.login.setDisable(true);
////                MainView.logout.setDisable(false);
//                // gridone.getChildren().removeAll(username,password,userpassword,users);
//                logout= new Button("LOGOUT");
//                logout.setStyle(
//                        " -fx-padding: 0.7em 0.57em;"+
//                                " -fx-font-size: 10px;"+
//                                "  -jfx-button-type: RAISED;"+
//                                "   -fx-background-color:  #BF360C;"+
//                                " -fx-pref-width: 70;"+
//                                " -fx-text-fill: WHITE;"
//                );
//                logout.setOnAction(E->{
////                    MainView.reportstab.setDisable(true);
////                    MainView.vehicles.setDisable(true);
////                    MainView.employees.setDisable(true);
////                    MainView.offences.setDisable(true);
////                    MainView.savings.setDisable(true);
////                    login.setDisable(false);
////                    logout.setDisable(true);
//
//                    topmenu.getChildren().remove(logout);
//                });
////gridtwo.addRow(0,logout);
//                logout.setPadding(new Insets(50,20,0,200));
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
//       // gridtwo.addRow(8,password,userpassword,login);
//        gridtwo.setVgap(20);
//        gridtwo.setHgap(20);
//        gridtwo.setPadding(new Insets(50,50,50,0));
//
//
//        loginScreen.getChildren().addAll(gridtwo);
//        return loginScreen;
//    }
//    public static HBox topMenuone() {
//        Label name = new Label();
//        name.setText("LOAN MANAGEMENT SYSTEM");
//        name.setStyle("-fx-font-size: 40; -fx-fill: #2196F3");
//        name.setAlignment(Pos.CENTER_RIGHT);
//        topmenu = new HBox();
//        //topmenu.setSpacing(20);
//        topmenu.setPadding(new Insets(20,20,20,20));
//        topmenu.getChildren().addAll(name);
//
//        topmenu.setStyle("-fx-border-color: #AEEA00;-fx-border-insets:5;" +
//                "-fx-border-style:solid;" +
//                "-fx-border-width: 2;-fx-border-radius: 20;-fx-background-color:  #AEEA00;-fx-background-radius: 20");
//        return topmenu;
//    }
//    public static  VBox RightSiderContent(){
//      rightContent= new VBox();
//
//      GridPane  grid= new GridPane();
//
//Label label= new Label();
//label.setText("USERS");
//label.setStyle("-fx-font-size: 20; -fx-font-weight: 600;-fx-fill: #2196F3");
//        rightContent.setSpacing(15);
//        rightContent.setMaxHeight(500);
//        rightContent.setPadding(new Insets(50,100,50,50));
//        rightContent.setMaxWidth(700);
//
//grid.addColumn(0,label);
//rightContent.setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
//            "-fx-border-style:solid;" +
//           "-fx-border-width: 2;-fx-border-radius: 20");
//
//
//rightContent.getChildren().addAll(grid);
//       return rightContent;
//    }
//
//    public static GridPane  newCenter(){
//         GridPane  newGrid= new GridPane();
//        GaugeBuilder builder = GaugeBuilder.create();
//
//
//        builder.skinType(Gauge.SkinType.MODERN);
//        members          = builder.decimals(0).maxValue(10000).unit("MEMBERS").build();
//
//        empGauge       = builder.decimals(2).maxValue(10).unit("EMPLOYEES").build();
//
//        outloans = builder.decimals(0).maxValue(2200).unit("OUTSTANDING LOANS").build();
//        //builder.skinType(Gauge.SkinType.MODERN);
//        reminders   = builder.decimals(0).maxValue(2200).unit("REMINDERS").build();
//        //builder.skinType(Gauge.SkinType.MODERN);
//        expenses         = builder.decimals(1).maxValue(85).unit("EXPENSES").build();
//        // builder.skinType(Gauge.SkinType.MODERN);
//        interest        = builder.decimals(1).maxValue(20).unit("ANNUAL INTEREST").build();
//
//        FGauge fmembers = FGaugeBuilder
//                .create()
//              .prefSize(600, 600)
//                .gauge(members)
//                .gaugeDesign(GaugeDesign.ENZO)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(true)
//                .build();
//
//
//
//        FGauge finterest = FGaugeBuilder
//                .create()
//            .prefSize(600, 600)
//                .gauge(interest)
//                .gaugeDesign(GaugeDesign.ENZO)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(true)
//                //.maxSize(400,400)
//                .build();
//
//        FGauge foutloans = FGaugeBuilder
//                .create()
//              .prefSize(600, 600)
//                .gauge(outloans)
//                .gaugeDesign(GaugeDesign.STEEL)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(true)
//                .build();
//
//        FGauge freminders = FGaugeBuilder
//                .create()
//            .prefSize(400, 600)
//                .layoutX(600)
//                .layoutY(700)
//                .gauge(reminders)
//                .gaugeDesign(GaugeDesign.STEEL)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(true)
//                .build();
//
//        FGauge femployees = FGaugeBuilder
//                .create()
//               .prefSize(400, 600)
//                .gauge(empGauge)
//                .gaugeDesign(GaugeDesign.GOLD)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(false)
//                .build();
//
//
//        FGauge fexpenses = FGaugeBuilder
//                .create()
//               .prefSize(400, 600)
//                .gauge(expenses)
//                .gaugeDesign(GaugeDesign.STEEL)
//                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
//                .foregroundVisible(false)
//                .build();
//
//        VBox stepsBox        = getTopicBox("LOANS", "BLACK", fexpenses);
//        VBox distanceBox     = getTopicBox("GAINED INTEREST","BLACK", finterest);
//        VBox foodCaloriesBox = getTopicBox("REMINDERS", "BLACK", freminders);
//        VBox weightBox       = getTopicBox("EMPLOYEES", "BLACK", femployees);
//        VBox bodyFatBox      = getTopicBox("MEMBERS","BLACK", fmembers);
//        VBox actvCaloriesBox = getTopicBox("ACTIVE LOANS","BLACK", foutloans);
//        newGrid = new GridPane();
//        newGrid.setPadding(new Insets(20));
//        newGrid.setHgap(10);
//        newGrid.setVgap(15);
//        newGrid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(8), Insets.EMPTY)));
//        newGrid.add(stepsBox, 0, 0);
//        newGrid.add(distanceBox, 1, 0);
//        newGrid.add(actvCaloriesBox, 0, 2);
//        newGrid.add(foodCaloriesBox, 1, 2);
//        newGrid.add(weightBox, 0, 4);
//        newGrid.add(bodyFatBox, 1, 4);
//
//
//
//        members.setValue(5201);
//        empGauge.setValue(3.12);
//        reminders.setValue(347);
//        outloans.setValue(1500);
//        expenses.setValue(78.7);
//        interest.setValue(14.2);
//        return newGrid;
//    }
//    private static  VBox getTopicBox(final String TEXT, String COLOR, final FGauge GAUGE) {
//        Rectangle bar = new Rectangle(50, 3);
//
//     //   bar
//        bar.setArcWidth(4);
//        bar.setArcHeight(5);
//        bar.setStyle("-fx-background-color: #2196F3");
//
//        Label label = new Label(TEXT);
//        label.setTextFill(Color.BLACK);
//        label.setAlignment(Pos.CENTER);
//        label.setPadding(new Insets(10, 10, 5, 10));
//        label.setStyle("-fx-font-size: 10; -fx-font-weight: 800;-fx-fill: #2196F3");
//        GAUGE.setStyle("-fx-background-color: #2196F3");
//      //  GAUGE.setPadding();
////        GAUGE.setBarBackgroundColor(Color.rgb(39,44,50));
////        GAUGE.setAnimated(true);
//
//        VBox vBox = new VBox(bar, label, GAUGE);
//       // vBox.setSpacing(3);
//        vBox.setAlignment(Pos.CENTER);
//        vBox.setPadding(new Insets(10,10,10,10));
//        vBox.setMaxWidth(600);
//        vBox.setStyle("-fx-border-color: WHITE;-fx-border-insets:5;" +
//                "-fx-border-style:solid;" +
//                "-fx-border-width: 2;-fx-border-radius: 20;-fx-background-color:  WHITE;-fx-background-radius: 20");
//        return vBox;
//    }
//    public static FlowGridPane immediatePane(){
//        FlowGridPane newPane;
//Button  loginButton = new Button("LOGIN");
//        Double savingsTotal= (Double) MembersList.allMembers(). stream().mapToDouble(Member::getTotalWorth).sum();
//Integer  totalMembers= MembersList.allMembers().size();
//
//
//        stockTile = TileBuilder.create()
//                .skinType(Tile.SkinType.SLIDER)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("MEMBERS")
//                .text("TOTAL MEMBERS IN  SACCO")
//                .minValue(totalMembers)
//                .maxValue(1000)
//
//
//               .averagingPeriod(1)
//                .backgroundColor(Color.BURLYWOOD)
//                .build();
//
//
//
//
//        circularProgressTile = TileBuilder.create()
//                .skinType(Tile.SkinType.CIRCULAR_PROGRESS)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("MONEY OUT")
//                .text("Total Money Out")
//                .value(100000.0)
//                .maxValue(savingsTotal)
//                .unit("\u0025")
//                //.graphic(new WeatherSymbol(ConditionAndIcon.CLEAR_DAY, 48, Color.WHITE))
//                .build();
//        countryTile = TileBuilder.create().skinType(Tile.SkinType.COUNTRY)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .minValue(0)
//                .maxValue(40)
//                .title("REGION")
//                .unit(" ")
//                .country(Country.KE)
//                .tooltipText("Kenya")
//                .animated(true)
//                .build();
//        clockTile = TileBuilder.create()
//                .skinType(Tile.SkinType.CLOCK)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("CURRENT TIME")
//                .text("East Africa Standard Time")
//                .dateVisible(true)
//                .locale(Locale.US)
//                .running(true)
//                .backgroundColor(Color.CHOCOLATE)
//                .build();
//        gaugeSparkLineTile = TileBuilder.create()
//                .skinType(Tile.SkinType.GAUGE_SPARK_LINE)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("LOAN REPAYMENT COMPLETION")
//                .animated(true)
//                .textVisible(false)
//                .averagingPeriod(25)
//                .autoReferenceValue(true)
//                .barColor(Tile.YELLOW_ORANGE)
//                .barBackgroundColor(Color.rgb(255, 255, 255, 0.1))
//                .sections(new eu.hansolo.tilesfx.Section(0, 33, Tile.LIGHT_GREEN),
//                        new eu.hansolo.tilesfx.Section(33, 67, Tile.YELLOW),
//                        new eu.hansolo.tilesfx.Section(67, 100, Tile.LIGHT_RED))
//                .sectionsVisible(true)
//                .highlightSections(true)
//                .strokeWithGradient(true)
//                .gradientStops(new Stop(0.0, Tile.LIGHT_GREEN),
//                        new Stop(0.33, Tile.LIGHT_GREEN),
//                        new Stop(0.33,Tile.YELLOW),
//                        new Stop(0.67, Tile.YELLOW),
//                        new Stop(0.67, Tile.LIGHT_RED),
//                        new Stop(1.0, Tile.LIGHT_RED))
//                .build();
//
//        switchTile = TileBuilder.create()
//                .skinType(Tile.SkinType.SWITCH)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("Switch Tile")
//                .text("Whatever text")
//
//                //.description("Test")
//                .build();
//        plusMinusTile = TileBuilder.create()
//                .skinType(Tile.SkinType.PLUS_MINUS)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .maxValue(30)
//                .minValue(0)
//                .title("SIMULATOR")
//                .text("loan  calculator")
//                .description("simulate your loans")
//                .unit("KSHS")
//
//                .build();
//
//        ObservableList<Accounts> me = AccountsList.getIncomeAccounts();
//        //me.stream()
//
//
//        numberTile = TileBuilder.create()
//                .skinType(Tile.SkinType.NUMBER)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("TOTAL MEMBERS SAVINGS ")
//                //.text("kshs")
//
//                .value(savingsTotal)
//                .unit("KES")
//               // .description("Test")
//                .textVisible(true)
//                .build();
//
//        textTile = TileBuilder.create()
//                .skinType(Tile.SkinType.TEXT)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("Text Tile")
//                .text("Whatever text")
//                .description("May the force be with you\n...always")
//                .descriptionAlignment(Pos.TOP_LEFT)
//                .textVisible(true)
//                .build();
//        customTile = TileBuilder.create()
//                .skinType(Tile.SkinType.CUSTOM)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title("Custom Tile")
//                .text("Whatever text")
//                .graphic(  loginButton
//                )
//                .roundedCorners(false)
//                .build();
//
//        loginButton.setOnAction(e->{
//            Users.login();
//        });
//        // Creating Tiles
//        percentageTile = TileBuilder.create()
//                .skinType(Tile.SkinType.STOCK)
//                .prefSize(TILE_WIDTH, TILE_HEIGHT)
//                .title(" GENERAL INTEREST ")
//                .unit("\u0025")
//               // .description("Test")
//                //.activeColor(Color.CADETBLUE)
//            //    .subTitle("NEW ")
//              //  .subTitle("TEST")
//                .maxValue(60)
//                .animated(true)
//                .backgroundColor(Color.FIREBRICK)
//                .build();
//newPane= new FlowGridPane(6,
//
//         4,percentageTile,stockTile,gaugeSparkLineTile,countryTile,circularProgressTile,clockTile,plusMinusTile,switchTile,customTile,numberTile,textTile);
//newPane.setPadding(new Insets(20,20,20,20));
////newPane.setBackground(new Background(new BackgroundFill(Color.web("#2196F3"), CornerRadii.EMPTY, Insets.EMPTY)));
//newPane.setAlignment(Pos.CENTER);
//newPane.setHgap(20);
//newPane.setVgap(20);
////newPane.setOrientation(Orientation.HORIZONTAL);
//        return newPane;
//    }
//
//}