package parents;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by FINETEKLABS on 1/23/2018.
 */
public class parentList extends ListCell implements parentsLists {
    private static final String CACHE_LIST_FOUND_CLASS = "cache-list-found";
    private static final String CACHE_LIST_NOT_FOUND_CLASS = "cache-list-not-found";
    private static final String CACHE_LIST_NAME_CLASS = "cache-list-name";
    private static final String CACHE_LIST_DT_CLASS = "cache-list-dt";
    private static final String CACHE_LIST_ICON_CLASS = "cache-list-icon";
    private static final String FONT_AWESOME = "FontAwesome";
    private GridPane grid = new GridPane();
    private Label icon = new Label();
    private Label name = new Label();
    private Label dt = new Label();

    public parentList() {
        configureGrid();
        configureIcon();
        configureName();
        configureDifficultyTerrain();
        addControlsToGrid();
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

    private void configureGrid() {
        grid.setHgap(10);
        grid.setVgap(4);
        grid.setPadding(new Insets(0, 10, 0, 10));
    }

    private void configureIcon() {
        icon.setFont(Font.font(FONT_AWESOME, FontWeight.BOLD, 24));
        icon.getStyleClass().add(CACHE_LIST_ICON_CLASS);
    }

    private void configureName() {
        name.getStyleClass().add(CACHE_LIST_NAME_CLASS);
    }

    private void configureDifficultyTerrain() {
        dt.getStyleClass().add(CACHE_LIST_DT_CLASS);
    }

    private void addControlsToGrid() {
        grid.add(icon, 0, 0, 1, 2);
        grid.add(name, 1, 0);
        grid.add(dt, 1, 1);
    }


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

//    private void setStyleClassDependingOnFoundState(parent  cache) {
//        if (CacheUtils.hasUserFoundCache(cache, new Long(3906456))) {
//            addClasses(this, CACHE_LIST_FOUND_CLASS);
//            removeClasses(this, CACHE_LIST_NOT_FOUND_CLASS);
//        } else {
//            addClasses(this, CACHE_LIST_NOT_FOUND_CLASS);
//            removeClasses(this, CACHE_LIST_FOUND_CLASS);
//        }
}

