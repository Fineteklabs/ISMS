package members;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Created by FINETECHLABS on 09/01/2017.
 */
public class studentView extends Tab {

    public static BorderPane innerborder;
    private static VBox leftarea;
    public VBox border;
    private BorderPane centraldata;

    public studentView(String title) {
        this.setText(title);
        //      this.setGraphic(graphic);
        init();
    }

    public static void drawer() {
        JFXDrawer bottomDrawer = new JFXDrawer();
        StackPane bottomDrawerPane = new StackPane();
        bottomDrawerPane.getStyleClass().add("deep-purple-400");
        bottomDrawerPane.getChildren().add(new JFXButton("Bottom Content"));
        bottomDrawer.setDefaultDrawerSize(150);
        bottomDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
        bottomDrawer.setSidePane(bottomDrawerPane);
//		bottomDrawer.setContent(leftDrawer);
        bottomDrawer.setOverLayVisible(false);
        bottomDrawer.setResizableOnDrag(true);
    }

    public void init() {


        this.setContent(GeneralInfo());
    }

    public SplitPane GeneralInfo() {

        // Create a horizontal separator
        Separator separator1 = new Separator();
// Change the orientation to vertical
        separator1.setOrientation(Orientation.VERTICAL);
// Create a vertical separator
        Separator separator2 = new Separator(Orientation.VERTICAL);

        SplitPane devidescreen = new SplitPane();


        innerborder = new BorderPane();
        leftarea = new VBox();
        //  leftarea.getChildren().addAll(common.homeAccess.quickAccess());

        innerborder.setCenter(leftarea);
        centraldata = new BorderPane();
        centraldata.setTop(studentDataForm.mainmenu());
        centraldata.setCenter(studentDataForm.EmployeeTableHolder());
        centraldata.setBottom(studentDataForm.Add());
        centraldata.setPadding(new Insets(10, 10, 10, 10));

        border = new VBox();
        // border.getChildren().addAll(homeAccess.quickAccess());
//        VBox headers = null;
//        headers = new VBox();
//        headers.getChildren().addAll(mainmenu(),top());
//
//        border.setTop(headers);
        //  border.setCenter();
        devidescreen.getItems().addAll(leftarea, centraldata);
        //border.setPadding( new Insets(10,10,10,10));
//        // border.setRight(itemcounter());
        devidescreen.setDividerPositions(0.15);
        //
        leftarea.maxWidthProperty().bind(devidescreen.widthProperty().multiply(0.15));
        return devidescreen;
    }
}
