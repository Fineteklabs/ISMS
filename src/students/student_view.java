package students;

import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by FINETEKLABS on 12/28/2017.
 */
public class student_view extends Tab {
    public student momanyi = new student(" ", "  ", " ", " ", " ", " ", " ", " ", null, null, null, " ");
    addStudent addstudents = new addStudent(momanyi);
    addStudent design = new addStudent(momanyi);
    private BorderPane studentsCenter;
    private HBox studentActivities;
    private VBox navigator;
    private HBox menu;


    public student_view(student momanyi, String title) {
        this.momanyi = momanyi;
//        designs();
        init();
        this.setText(title);

//        bindFieldsToModel();

        this.setContent(init());
    }

    public BorderPane init() {
        studentsCenter = new BorderPane();
        studentsCenter.setCenter(addstudents);
        studentsCenter.setCenter(design.GeneralInfo());
        return studentsCenter;
    }

}
