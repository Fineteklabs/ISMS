package parents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

/**
 * Created by FINETEKLABS on 1/23/2018.
 */
public class allparents extends ListView {
    private static final String CACHE_LIST_NAME_CLASS = "cache-list-name";
    private static final String CACHE_LIST_DT_CLASS = "cache-list-dt";
    private static final String CACHE_LIST_ICON_CLASS = "cache-list-icon";
    private static final String FONT_AWESOME = "FontAwesome";
    parent parents = new parent("steve", "steve", "steve", "steve", "steve", "steve", "steve",
            "steve", "steve", "steve", "steve", " none");
    private GridPane grid = new GridPane();
    private Label icon = new Label();
    private Label name = new Label();
    private Label dt = new Label();

    public allparents() {


        this.setCellFactory(new Callback<ListView<String>,
                                    ListCell<String>>() {
                                @Override
                                public ListCell<String> call(ListView<String> list) {
                                    return myparents(parents);
                                }
                            }
        );


    }

    public parentsListCell myparents(parent parent) {
        ListCell<parent> cell = new ListCell<parent>() {

            private void clearContent() {
                setText(null);
                setGraphic(null);
            }

            private void addContent(parent cache) {
                setText(null);
                // icon.setText(GeocachingIcons.getIcon(cache).toString());
                name.setText(cache.getFirstName() + " " + cache.getLastName());
                dt.setText(cache.getMobileNumber() + " / " + cache.getRole());
                //  setStyleClassDependingOnFoundState(cache);
                setGraphic(grid);
            }

            @Override
            public void updateItem(parent cache, boolean empty) {
                super.updateItem(cache, empty);
                if (empty) {
                    clearContent();
                } else {
                    addContent(cache);
                }


            }


        };
        return new parentsListCell();
    }


    private void configureGrid() {
        grid.setHgap(10);
        grid.setVgap(4);
        grid.setPadding(new Insets(0, 10, 0, 10));
    }

    private void configureIcon() {
        icon.setFont(Font.font(FONT_AWESOME, FontWeight.BOLD, 24));
        icon.getStyleClass().add(CACHE_LIST_ICON_CLASS);
    }

    private void addControlsToGrid() {
        grid.add(icon, 0, 0, 1, 2);
        grid.add(name, 1, 0);
        grid.add(dt, 1, 1);
    }


}
