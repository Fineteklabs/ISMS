package schools;

/**
 * Created by FINETEKLABS on 12/24/2017.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.svg.SVGGlyph;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import levels.level;
import levels.level_view;
import org.apache.log4j.BasicConfigurator;
import parents.parent;
import parents.parent_view;
import students.student;
import students.student_view;

/**
 * Created by FINETEKLABS on 11/23/2017.
 */


/**
 * Created by FINETECHLABS on 16/08/2016.
 */


public class schoolApp extends Application {
    public static Stage mainStage;
    public static Scene scene;
    public static MenuItem login;
    public static MenuItem logout;
    public static MenuItem exit;
    public static JFXButton button;
    //private  schoolDetailsTab  schoolDetails;
    private static Menu users;
    private static Menu help;
    private static Menu view;
    private static Menu about;
    //  public static
    public TabPane tabs = new TabPane();

    public static void main(String args[]) {
        launch(args);
    }

    public static MenuBar TopMenu() {
        HBox titleBox = new HBox();

        login = new MenuItem("LOGIN");
        login.setOnAction(e -> {
            //Users.login();
        });
        logout = new MenuItem("LOGOUT");
        logout.setOnAction(e -> {
            //Users.login();
            login.setDisable(false);
            logout.setDisable(true);
        });
        logout.setDisable(true);
        exit = new MenuItem("EXIT");
        exit.setOnAction(e -> {
            Platform.exit();
        });
        titleBox.setStyle("-fx-border-color: #004d40;-fx-border-insets:5;" +
                "-fx-border-style:solid;" +
                "-fx-border-width: 2");
        titleBox.setPadding(new Insets(10, 10, 10, 10));
        MenuBar loginBar = new MenuBar();

        users = new Menu("USERS");
        users.getItems().addAll(login, logout, exit);

        about = new Menu("ABOUT");
        view = new Menu("VIEW");
        loginBar.getMenus().addAll(users, view, about);
        titleBox.getChildren().addAll(loginBar);
        return loginBar;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        school myschool = new school();
        student momanyi = new student();
        parent myparent = new parent();
        level mylevels = new level();
        student_view students = new student_view(momanyi, "STUDENTS CENTER");
        level_view levels = new level_view(mylevels, "CLASSES");
        school_view views = new school_view(myschool, "SCHOOL INFORMATION");
        parent_view parents = new parent_view(myparent, "PARENT CENTER");
        views.closableProperty().set(false);

        tabs.getTabs().addAll(views, students, parents, levels);
        BorderPane border = new BorderPane();
        border.setCenter(tabs);

        border.setTop(TopMenu());
        scene = new Scene(border, 900, 650);

        scene.getStylesheets().add(schoolApp.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());


        BasicConfigurator.configure();
//the stock tab


        mainStage = new Stage();
        mainStage.minWidthProperty().bind(scene.heightProperty().multiply(1.5));
        mainStage.minHeightProperty().bind(scene.widthProperty().divide(1.5));
        mainStage.setAlwaysOnTop(true);
//        stage.initModality(Modality.APPLICATION_MODAL);
        mainStage.resizableProperty().setValue(false);
        mainStage.setScene(scene);
        mainStage.setTitle("SETTINGS");
        mainStage.show();

    }

    public JFXButton backButton() {

        button = new JFXButton("");
        SVGGlyph arrow = new SVGGlyph(0, "FULLSCREEN", "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z", Color.WHITE);
        arrow.setSize(20, 16);
        button.setGraphic(arrow);
        button.setRipplerFill(Color.WHITE);

        button.setOnAction(e -> {
            this.tabs.getSelectionModel().selectPrevious();
        });

        return button;
    }

    public ImageView getImage(String fileName) {
        ImageView imgView = null;
        try {
            String imagePath = "resources/images/" + fileName;
            Image img = new Image(imagePath);
            imgView = new ImageView(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgView;
    }


}
