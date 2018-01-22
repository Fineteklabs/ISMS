package students;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import levels.level;

/**
 * Created by FINETEKLABS on 12/29/2017.
 */
public class addStudent extends GridPane {
    //TextFields


    public VBox border;
    public BorderPane innerborder;
    protected student momanyi = new student(" ", " ", " ", " ", " ", " ", " ", " ", null, null, null, " ");
    //Labels
    Label firstName = new Label("firstname:");
    Label lastName = new Label("lastname");
    Label middleName = new Label("middlename");
    Label email = new Label("Email");
    Label studentId = new Label("Student Id");
    Label parentId = new Label("Parent Id");
    Label activeState = new Label("Active Status");
    Label currentClassId = new Label("Current Level");
    Label admissionDate = new Label(" Admission Date");
    Label clearanceDate = new Label(" Clearance Date");
    Label home = new Label(" Home");
    Label dateOfBirth = new Label(" Date of Birth");
    //Buttons
    JFXButton saveButton = new JFXButton("save");
    JFXButton closeButton = new JFXButton("close");
    JFXTextField studentIdField = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXTextField studentFirstNameField = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXTextField studentLastNameField = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXTextField studentMiddleName = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXTextField homeField = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXTextField emailField = new JFXTextField() {
        final int maxChars = 50;
        final String restrictTo = "[0-9,A-Z ]";

        @Override
        public void replaceText(int start, int end, String text) {
            if (matchTest(text)) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            if (matchTest(text)) {
                super.replaceSelection(text);
            }
        }

        private boolean matchTest(String text) {
            return text.isEmpty() || (text.matches(restrictTo) && getText().length() < maxChars);
        }
    };
    JFXDatePicker admissionDateField = new JFXDatePicker();
    JFXDatePicker clearanceDateField = new JFXDatePicker();
    JFXDatePicker dateOfBirthField = new JFXDatePicker();
    ComboBox<parents.parent> parentIdField = new ComboBox<>();
    ComboBox<level> getCurrentClassIdField = new ComboBox<>();
    ComboBox<String> activeStateField = new ComboBox<>();
    private BorderPane centraldata;
    private VBox leftarea;

    public addStudent(student momanyi) {
        this.momanyi = momanyi;
        GeneralInfo();
        layoutField();
        bindFieldsToModel();
    }

    public void layoutField() {
        this.setHgap(10);
        this.setVgap(10);
        this.add(studentId, 1, 1);
        this.add(firstName, 3, 1);
        this.add(middleName, 1, 2);
        this.add(lastName, 3, 2);
        this.add(parentId, 1, 5);
        this.add(email, 1, 6);
        this.add(home, 1, 7);
        this.add(admissionDate, 1, 8);
        this.add(dateOfBirth, 1, 9);
        this.add(clearanceDate, 3, 9);
        this.add(currentClassId, 1, 11);


        this.add(studentIdField, 2, 1);
        this.add(studentFirstNameField, 4, 1);
        this.add(studentMiddleName, 2, 2);

        this.add(studentLastNameField, 4, 2);
        this.add(parentIdField, 2, 5);
        this.add(emailField, 2, 6);
        this.add(homeField, 2, 7);
        this.add(admissionDateField, 2, 8);
        this.add(dateOfBirthField, 2, 9);
        this.add(clearanceDateField, 4, 9);
        this.add(getCurrentClassIdField, 2, 11);
        this.add(saveButton, 5, 12);
        this.add(closeButton, 6, 12);
    }


    public void bindFieldsToModel() {
        studentIdField.textProperty().bind(momanyi.studentIdProperty());
        studentMiddleName.textProperty().bindBidirectional(momanyi.middleNameProperty());
        studentLastNameField.textProperty().bindBidirectional(momanyi.lastNameProperty());
        studentFirstNameField.textProperty().bindBidirectional(momanyi.firstNameProperty());
        emailField.textProperty().bindBidirectional(momanyi.emailProperty());
        //  admissionDate.textProperty().bindBidirectional(momanyi.admissionDateProperty().toString());
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
        //   leftarea.getChildren().addAll(common.homeAccess.quickAccess());

        innerborder.setCenter(leftarea);
        centraldata = new BorderPane();
//        centraldata.setTop(memberDataForm.mainmenu());
        centraldata.setCenter(this);
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
