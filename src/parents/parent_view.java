package parents;

import javafx.geometry.Insets;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by FINETEKLABS on 1/9/2018.
 */
public class parent_view extends Tab {
    public VBox border;
    public BorderPane innerborder;
    public parent momanyi = new parent(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
    addParent addparents = new addParent(momanyi);
    parentOptions editMenu = new parentOptions();
    private BorderPane centraldata;
    private VBox leftarea;
    private BorderPane parentsCenter;
    private HBox parentOPerations;
    private VBox navigator;
    private HBox menu;

    public parent_view(parent momanyi, String title) {
        this.momanyi = momanyi;
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
        centraldata.setCenter(addparents);
        centraldata.setTop(editMenu);
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


