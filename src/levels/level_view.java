package levels;

import javafx.geometry.Insets;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by FINETEKLABS on 1/9/2018.
 */
public class level_view extends Tab {
    public VBox border;
    public BorderPane innerborder;
    public level currentlevel = new level();
    addLevel addlevels = new addLevel();
    // parentOptions editMenu = new parentOptions();
    private BorderPane centraldata;
    private VBox leftarea;
    private BorderPane parentsCenter;
    private HBox parentOPerations;
    private VBox navigator;
    private HBox menu;

    public level_view(level currentLevel, String title) {
        this.currentlevel = currentLevel;
//        designs();
        init();
        this.setText(title);

//        bindFieldsToModel();

        this.setContent(init());
    }


    public SplitPane init() {


        SplitPane devidescreen = new SplitPane();


        innerborder = new BorderPane();
        leftarea = new VBox();

        innerborder.setCenter(leftarea);
        centraldata = new BorderPane();
        centraldata.setCenter(addlevels);
        //centraldata.setTop(editMenu);
//        centraldata.setBottom(memberDataForm.Add());
        centraldata.setPadding(new Insets(10, 10, 10, 10));

        border = new VBox();

        devidescreen.getItems().addAll(leftarea, centraldata);

        devidescreen.setDividerPositions(0.15);
        //
        leftarea.maxWidthProperty().bind(devidescreen.widthProperty().multiply(0.20));
        return devidescreen;
    }
}


