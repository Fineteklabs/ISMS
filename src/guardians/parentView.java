package guardians;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Created by FINETECHLABS on 09/01/2017.
 */
public class parentView extends Tab {

    public static BorderPane innerborder;
    private static GridPane leftarea;
    public VBox border;
    private BorderPane centraldata;

    public parentView(String title, Node graphic) {
        this.setText(title);
        this.setGraphic(graphic);
        init();
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
        leftarea = new GridPane();

        innerborder.setCenter(leftarea);
        centraldata = new BorderPane();
        centraldata.setTop(parentsDataForm.mainmenu());
        centraldata.setCenter(parentsDataForm.EmployeeTableHolder());
        centraldata.setBottom(parentsDataForm.Add());

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
        leftarea.maxWidthProperty().bind(devidescreen.widthProperty().multiply(0.20));
        return devidescreen;
    }
}
