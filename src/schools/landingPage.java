package schools;

import eu.hansolo.medusa.*;
import eu.hansolo.tilesfx.Country;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.skins.LeaderBoardItem;
import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import java.util.Locale;

/**
 * Created by FINETEKLABS on 2/10/2018.
 */
public class landingPage {
    private static final double TILE_WIDTH = 200;
    private static final double TILE_HEIGHT = 100;
    public static Label error;
    public static Label name;
    public static LeaderBoardItem leaderBoardItem1;
    public static LeaderBoardItem leaderBoardItem2;
    public static LeaderBoardItem leaderBoardItem3;
    public static LeaderBoardItem leaderBoardItem4;
    public static Tile leaderBoardTile;
    public static Tile levelsCategory;

    private static Gauge members;
    private static Gauge empGauge;
    private static Gauge outloans;
    private static Gauge reminders;
    private static Gauge expenses;
    private static Gauge interest;
    private static Tile stockTile;
    private static Tile percentageTile;
    private static Tile clockTile;
    private static Tile numberTile;
    private static Tile textTile;
    private static Tile plusMinusTile;
    private static Tile switchTile;
    private static Tile schoolDetails;
    private static Tile customTile;
    private static Tile circularProgressTile;
    private static Tile gaugeSparkLineTile;
    private static Tile countryTile;
    private Tile gaugeTile;
    private Tile sparkLineTile;
    private Tile areaChartTile;
    private Tile lineChartTile;
    private Tile highLowTile;
    private Tile timerControlTile;
    private Tile sliderTile;
    private Tile worldTile;
    private Tile weatherTile;
    private Tile timeTile;
    private Tile barChartTile;
    private Tile mapTile;
    private Tile radialChartTile;
    private Tile donutChartTile;
    private Tile radarChartTile1;
    private Tile radarChartTile2;
    private Tile smoothAreaChartTile;

    public static GridPane newCenter() {
        GridPane newGrid = new GridPane();
        GaugeBuilder builder = GaugeBuilder.create();


        builder.skinType(Gauge.SkinType.MODERN);
        members = builder.decimals(0).maxValue(10000).unit("STUDENTS").build();

        empGauge = builder.decimals(2).maxValue(10).unit("PARENTS").build();

        outloans = builder.decimals(0).maxValue(2200).unit("FEES").build();
        //builder.skinType(Gauge.SkinType.MODERN);
        reminders = builder.decimals(0).maxValue(2200).unit("REMINDERS").build();
        //builder.skinType(Gauge.SkinType.MODERN);
        expenses = builder.decimals(1).maxValue(85).unit("EXPENSES").build();
        // builder.skinType(Gauge.SkinType.MODERN);
        interest = builder.decimals(1).maxValue(20).unit("ANNUAL INTEREST").build();

        FGauge fmembers = FGaugeBuilder
                .create()
                .prefSize(600, 600)
                .gauge(members)
                .gaugeDesign(GaugeDesign.ENZO)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(true)
                .build();


        FGauge finterest = FGaugeBuilder
                .create()
                .prefSize(600, 600)
                .gauge(interest)
                .gaugeDesign(GaugeDesign.ENZO)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(true)
                //.maxSize(400,400)
                .build();

        FGauge foutloans = FGaugeBuilder
                .create()
                .prefSize(600, 600)
                .gauge(outloans)
                .gaugeDesign(GaugeDesign.STEEL)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(true)
                .build();

        FGauge freminders = FGaugeBuilder
                .create()
                .prefSize(400, 600)
                .layoutX(600)
                .layoutY(700)
                .gauge(reminders)
                .gaugeDesign(GaugeDesign.STEEL)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(true)
                .build();

        FGauge femployees = FGaugeBuilder
                .create()
                .prefSize(400, 600)
                .gauge(empGauge)
                .gaugeDesign(GaugeDesign.GOLD)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(false)
                .build();


        FGauge fexpenses = FGaugeBuilder
                .create()
                .prefSize(400, 600)
                .gauge(expenses)
                .gaugeDesign(GaugeDesign.STEEL)
                .gaugeBackground(GaugeDesign.GaugeBackground.TRANSPARENT)
                .foregroundVisible(false)
                .build();

        VBox stepsBox = getTopicBox("LOANS", "BLACK", fexpenses);
        VBox distanceBox = getTopicBox("GAINED INTEREST", "BLACK", finterest);
        VBox foodCaloriesBox = getTopicBox("REMINDERS", "#00c853", freminders);
        VBox weightBox = getTopicBox("EMPLOYEES", "BLACK", femployees);
        VBox bodyFatBox = getTopicBox("STUDENTS", "#00c853", fmembers);
        VBox actvCaloriesBox = getTopicBox("ACTIVE LOANS", "BLACK", foutloans);
        newGrid = new GridPane();
        newGrid.setPadding(new Insets(20));
        newGrid.setHgap(10);
        newGrid.setVgap(15);
        newGrid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(8), Insets.EMPTY)));
        newGrid.add(stepsBox, 0, 0);
        newGrid.add(distanceBox, 1, 0);
        newGrid.add(actvCaloriesBox, 0, 2);
        newGrid.add(foodCaloriesBox, 1, 2);
        newGrid.add(weightBox, 0, 4);
        newGrid.add(bodyFatBox, 1, 4);


        members.setValue(5201);
        empGauge.setValue(3.12);
        reminders.setValue(347);
        outloans.setValue(1500);
        expenses.setValue(78.7);
        interest.setValue(14.2);
        return newGrid;
    }

    private static VBox getTopicBox(final String TEXT, String COLOR, final FGauge GAUGE) {
        Rectangle bar = new Rectangle(50, 3);

        //   bar
        bar.setArcWidth(4);
        bar.setArcHeight(5);
        bar.setStyle("-fx-background-color: #2196F3");

        Label label = new Label(TEXT);
        label.setTextFill(Color.BLACK);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(10, 10, 5, 10));
        label.setStyle("-fx-font-size: 10; -fx-font-weight: 800;-fx-fill: #2196F3");
        GAUGE.setStyle("-fx-background-color: #2196F3");
        //  GAUGE.setPadding();
//        GAUGE.setBarBackgroundColor(Color.rgb(39,44,50));
//        GAUGE.setAnimated(true);

        VBox vBox = new VBox(bar, label, GAUGE);
        // vBox.setSpacing(3);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setMaxWidth(600);
        vBox.setStyle("-fx-border-color: WHITE;-fx-border-insets:5;" +
                "-fx-border-style:solid;" +
                "-fx-border-width: 2;-fx-border-radius: 20;-fx-background-color:  WHITE;-fx-background-radius: 20");
        return vBox;
    }

    public static FlowGridPane immediatePane() {
        FlowGridPane newPane;
        Button loginButton = new Button("LOGIN");
//        Double savingsTotal= (Double) MembersList.allMembers(). stream().mapToDouble(Member::getTotalWorth).sum();
//        Integer  totalMembers= MembersList.allMembers().size();
        leaderBoardItem1 = new LeaderBoardItem("FORM 1", 47);
        leaderBoardItem2 = new LeaderBoardItem("FORM 2", 43);
        leaderBoardItem3 = new LeaderBoardItem("FORM 3", 12);
        leaderBoardItem4 = new LeaderBoardItem("FORM 4", 8);

        stockTile = TileBuilder.create()
                .skinType(Tile.SkinType.SLIDER)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("STUDENTS")
                .text("Total Students in School")
                .minValue(0.0)
                .maxValue(1000)


                .averagingPeriod(1)
                .backgroundColor(Color.valueOf("#00c853"))
                .build();


        circularProgressTile = TileBuilder.create()
                .skinType(Tile.SkinType.CIRCULAR_PROGRESS)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("UNPAID FEES")
                .text("ammount school is owed by students")
                .value(100000.0)
                .maxValue(0.0)
                .unit("\u0025")
                .backgroundColor(Color.valueOf("#949494"))
                //.graphic(new WeatherSymbol(ConditionAndIcon.CLEAR_DAY, 48, Color.WHITE))
                .build();
        countryTile = TileBuilder.create().skinType(Tile.SkinType.COUNTRY)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .minValue(0)
                .maxValue(40)
                .title("REGION")
                .unit(" ")
                .country(Country.KE)
                .tooltipText("Kenya")
                .animated(true)
                .build();
        clockTile = TileBuilder.create()
                .skinType(Tile.SkinType.CLOCK)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("CURRENT TIME")
                .text("East Africa Standard Time")
                .dateVisible(true)
                .locale(Locale.US)
                .running(true)
                .backgroundColor(Color.CHOCOLATE)
                .build();
        gaugeSparkLineTile = TileBuilder.create()
                .skinType(Tile.SkinType.GAUGE_SPARK_LINE)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("LOAN REPAYMENT COMPLETION")
                .animated(true)
                .textVisible(false)
                .averagingPeriod(25)
                .autoReferenceValue(true)
                .barColor(Tile.YELLOW_ORANGE)
                .barBackgroundColor(Color.rgb(255, 255, 255, 0.1))
                .sections(new eu.hansolo.tilesfx.Section(0, 33, Tile.LIGHT_GREEN),
                        new eu.hansolo.tilesfx.Section(33, 67, Tile.YELLOW),
                        new eu.hansolo.tilesfx.Section(67, 100, Tile.LIGHT_RED))
                .sectionsVisible(true)
                .highlightSections(true)
                .strokeWithGradient(true)
                .gradientStops(new Stop(0.0, Tile.LIGHT_GREEN),
                        new Stop(0.33, Tile.LIGHT_GREEN),
                        new Stop(0.33, Tile.YELLOW),
                        new Stop(0.67, Tile.YELLOW),
                        new Stop(0.67, Tile.LIGHT_RED),
                        new Stop(1.0, Tile.LIGHT_RED))
                .build();

        switchTile = TileBuilder.create()
                .skinType(Tile.SkinType.SWITCH)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("Switch Tile")
                .text("Whatever text")

                //.description("Test")
                .build();
        plusMinusTile = TileBuilder.create()
                .skinType(Tile.SkinType.PLUS_MINUS)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .maxValue(30)
                .minValue(0)
                .title("SIMULATOR")
                .text("loan  calculator")
                .description("simulate your loans")
                .unit("KSHS")

                .build();

        //  ObservableList<Accounts> me = AccountsList.getIncomeAccounts();
        //me.stream()


        numberTile = TileBuilder.create()
                .skinType(Tile.SkinType.NUMBER)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("TOTAL MEMBERS SAVINGS ")
                //.text("kshs")

                .value(0.0)
                .unit("KES")
                // .description("Test")
                .textVisible(true)
                .build();

        textTile = TileBuilder.create()
                .skinType(Tile.SkinType.TEXT)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("REMINDERS")
                .text("Whatever text")
                .description("May the force be with you\n...always")
                .descriptionAlignment(Pos.TOP_LEFT)
                .textVisible(true)
                .build();
        customTile = TileBuilder.create()
                .skinType(Tile.SkinType.CUSTOM)
                //.prefSize(TILE_WIDTH, TILE_HEIGHT)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("CURRENT TERM")
                .text("Whatever text")
                .graphic(addTerm()
                )
                .roundedCorners(true)
                .textColor(Color.LAWNGREEN)
                .build();

//        loginButton.setOnAction(e->{
//            Users.login();
//        });

        schoolDetails = TileBuilder.create()
                .skinType(Tile.SkinType.CUSTOM)
                //.prefSize(TILE_WIDTH, TILE_HEIGHT)
                .minSize(TILE_WIDTH, TILE_HEIGHT)
                .title("SCHOOL INFORMATION")
                .text("Whatever text")
                .graphic(addTerm()
                )
                .roundedCorners(true)
                .build();

//        loginButton.setOnAction(e->{
//            Users.login();
//        });


        leaderBoardTile = TileBuilder.create()
                .skinType(Tile.SkinType.LEADER_BOARD)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("STUDENT POPULATION")
                .text("Whatever text")
                .leaderBoardItems(leaderBoardItem1, leaderBoardItem2, leaderBoardItem3, leaderBoardItem4)
                .graphic(addTerm())
                .build();
        // Creating Tiles

        levelsCategory = TileBuilder.create()
                .skinType(Tile.SkinType.LEADER_BOARD)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title("STUDENT POPULATION")
                .text("Whatever text")
                .leaderBoardItems(leaderBoardItem1, leaderBoardItem2, leaderBoardItem3, leaderBoardItem4)
                .graphic(addTerm())
                .build();
        // Creating Tiles




        percentageTile = TileBuilder.create()
                .skinType(Tile.SkinType.STOCK)
                .prefSize(TILE_WIDTH, TILE_HEIGHT)
                .title(" GENERAL INTEREST ")
                .unit("\u0025")
                // .description("Test")
                //.activeColor(Color.CADETBLUE)
                //    .subTitle("NEW ")
                //  .subTitle("TEST")
                .maxValue(60)
                .animated(true)
                .backgroundColor(Color.FIREBRICK)
                .build();
        newPane = new FlowGridPane(4,

                4, leaderBoardTile, gaugeSparkLineTile, circularProgressTile, clockTile, switchTile, customTile, numberTile, textTile);
        newPane.setPadding(new Insets(20, 20, 20, 20));
//newPane.setBackground(new Background(new BackgroundFill(Color.web("#2196F3"), CornerRadii.EMPTY, Insets.EMPTY)));
        newPane.setAlignment(Pos.CENTER);
        newPane.setHgap(20);
        newPane.setVgap(20);
//newPane.setOrientation(Orientation.HORIZONTAL);school
        return newPane;
    }


    public static VBox addTerm() {
        VBox term = new VBox();
        HBox currentTerm = new HBox();
        Label termName = new Label(" ");
        // MembersList.allMembers(). stream().mapToDouble(Member::getTotalWorth).sum()
        termName.setText(schoolLists.getActiveSchool().stream().findFirst().get().getCurrentTerm() + "," + schoolLists.getActiveSchool().stream().findFirst().get().getAcademicYear());
        termName.setStyle("-fx-text-fill: #F1F1F1");
        Button add;
        Button edit;
        add = new Button("add");
        add.getStyleClass().add("button-normal");
        edit = new Button("edit");
        edit.getStyleClass().add("button-normal");
        term.getChildren().addAll(termName, add, edit);
        term.setSpacing(30);

        term.setPadding(new Insets(10, 0, 5, 2));
        //term.setPadding(new Insets(5,5,5,5));
        return term;
    }


    public static VBox addLevel() {
        VBox level = new VBox();
        Label levelName = new Label();
        return level;
    }
}
