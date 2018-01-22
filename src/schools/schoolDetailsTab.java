//package schools;
//
///**
// * Created by FINETEKLABS on 12/24/2017.
// */
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXScrollPane;
//import com.jfoenix.svg.SVGGlyph;
//import javafx.geometry.Insets;
//import javafx.geometry.Orientation;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class schoolDetailsTab extends Tab {
//    private school mySchool;
//    private  school_view myView;
//    private BorderPane centraldata;
//    public VBox border;
//    private  VBox  leftarea;
//    public   BorderPane innerborder;
//    school mychama= new school();
//    schoolView myCompanySettings= new schoolView(mychama);
//
//    public schoolDetailsTab(String title,school mySchool,school_view myView)
//    {
//        this.setText(title);
//        this.mySchool=mySchool;
//        this.myView=myView;
//        init();
//
//    }
//    public void init() {
//
//
//        this.setContent(GeneralInfo());
//        attachEvents();
//    }
//
//    private  void attachEvents(){
//        myView.setHgap(5);
//        myView.setVgap(5);
//        myView.saveButton.setOnAction(e->saveData());
//        myView.closeButton.setOnAction(e -> myView.getScene().getWindow().hide());
//        myView.locationField.setPromptText(" enter location");
//        myView.centerCodeField.setPromptText(" center code");
//        myView.mobileField.setPromptText(" mobile number");
//        myView.websiteField.setPromptText(" your website");
//        myView.schoolNameField.setPromptText("School name");
//
//    }
//
//    private void saveData() {
//        List<String> errorList = new ArrayList<>();
//        boolean isSaved = mySchool.save(errorList);
//        if (!isSaved) {
//            this.showError(errorList);
//        }
//    }
//
//    public SplitPane GeneralInfo() {
//
//
//
//
//        JFXScrollPane pane = new JFXScrollPane();
//        pane.setContent(myCompanySettings);
//
//        JFXButton button = new JFXButton("");
//        SVGGlyph arrow = new SVGGlyph(0, "FULLSCREEN", "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z", Color.WHITE);
//        arrow.setSize(20, 16);
//        button.setGraphic(arrow);
//        button.setRipplerFill(Color.WHITE);
//
//        button.setOnAction(e->{
//            //companyPane.tabs.getSelectionModel().selectPrevious();
//        });
//        pane.getTopBar().getChildren().add(button);
//
//        Label title = new Label("SCHOOL INFORMATION");
//        pane.getMainHeader().getChildren().add(title);
//        title.setStyle("-fx-text-fill:WHITE; -fx-font-size: 40;");
//        JFXScrollPane.smoothScrolling((ScrollPane) pane.getChildren().get(0));
//        pane.getTopBar().setMaxHeight(50);
//        //pane.getCondensedHeader().getChildren().add(title)
//        pane.getBottomBar().setMaxHeight(50);
//        pane.setAlignment(title, Pos.CENTER_LEFT);
//        pane.setAlignment(button,Pos.CENTER_LEFT);
//
//      //  myCompanySettings.chooser.getStyleClass().add("button-raised");
//
//
//        // Create a horizontal separator
//        Separator separator1 = new Separator();
//// Change the orientation to vertical
//        separator1.setOrientation(Orientation.VERTICAL);
//// Create a vertical separator
//        Separator separator2 = new Separator(Orientation.VERTICAL);
//
//        SplitPane  devidescreen= new SplitPane();
//
//
//
//        innerborder= new BorderPane();
//        leftarea= new VBox();
//     //   leftarea.getChildren().addAll(common.homeAccess.quickAccess());
//
//        innerborder.setCenter(leftarea);
//        centraldata= new BorderPane();
////        centraldata.setTop(memberDataForm.mainmenu());
//        centraldata.setCenter(pane);
////        centraldata.setBottom(memberDataForm.Add());
//        centraldata.setPadding( new Insets(10,10,10,10));
//
//        border = new VBox();
//        // border.getChildren().addAll(homeAccess.quickAccess());
////        VBox headers = null;
////        headers = new VBox();
////        headers.getChildren().addAll(mainmenu(),top());
////
////        border.setTop(headers);
//        //  border.setCenter();
//        devidescreen.getItems().addAll(leftarea, centraldata);
//        //border.setPadding( new Insets(10,10,10,10));
////        // border.setRight(itemcounter());
//        devidescreen.setDividerPositions(0.15);
//        //
//        leftarea.maxWidthProperty().bind(devidescreen.widthProperty().multiply(0.20));
//        return devidescreen;
//    }
//
//    public void showError(List<String> errorList) {
//        String msg = "";
//        if (errorList.isEmpty()) {
//            msg = "No message to display.";
//        } else {
//            for (String s : errorList) {
//                msg = msg + s + "\n";
//            }
//        }
//        Label msgLbl = new Label(msg);
//        Button okBtn = new Button("OK");
//        VBox root = new VBox(new StackPane(msgLbl), new StackPane(okBtn));
//        root.setSpacing(10);
//        Scene scene = new Scene(root);
//        Stage stage = new Stage(StageStyle.UTILITY);
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.setScene(scene);
//        stage.initOwner(myView.getScene().getWindow());
//// Set the Action listener for the OK button
//        okBtn.setOnAction(e -> stage.close());
//        stage.setTitle("Error");
//        stage.sizeToScene();
//        stage.showAndWait();
//    }
//
//}
