package schools;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Created by FINETEKLABS on 12/10/2017.
 */
public class schoolView extends GridPane {


    //labels
    Label schoolName = new Label("SCHOOL NAME:");
    Label schoolId = new Label("SCHOOL ID");
    Label location = new Label("LOCATION");
    Label taxNumber = new Label("TAX NUMBER");
    Label centerCode = new Label("CENTER CODE");
    Label schoolRegistration = new Label("SCHOOL REGISTRATION");
    Label telephone = new Label("TELEPHONE");
    Label mobile = new Label("MOBILE");
    Label website = new Label("WEBSITE");
    Label currentTerm = new Label("CURRENT TERM");
    Label academicYear = new Label(" ACADEMIC  YEAR");
    Label schoolCategory = new Label(" SCHOOL CATEGORY");
    //TextFields
    JFXTextField schoolNameField = new JFXTextField() {
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
    JFXTextField schoolIdField = new JFXTextField() {
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
    JFXTextField locationField = new JFXTextField() {
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
    JFXTextField categoryField = new JFXTextField() {
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
    JFXTextField centerCodeField = new JFXTextField() {
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
    JFXTextField websiteField = new JFXTextField() {
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
    JFXTextField mobileField = new JFXTextField() {
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
    JFXTextField telephoneField = new JFXTextField() {
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
    //Buttons
    JFXButton saveButton = new JFXButton("save");
    JFXButton closeButton = new JFXButton("close");
    private school myschool;

    public schoolView(school myschool) {
        this.myschool = myschool;
        layoutField();
        bindFieldsToModel();
    }

    private void layoutField() {
        this.setHgap(5);
        this.setVgap(5);

        this.add(schoolId, 1, 1);
        this.add(schoolName, 1, 2);
        this.add(schoolCategory, 1, 3);

        this.add(location, 1, 4);
        this.add(telephone, 1, 5);
        this.add(mobile, 1, 6);
        this.add(centerCode, 1, 7);
        this.add(website, 1, 8);
        this.add(academicYear, 1, 9);


        this.add(schoolIdField, 2, 1);
        this.add(schoolNameField, 2, 2);
        this.add(categoryField, 2, 3);
        this.add(locationField, 2, 4);
        this.add(telephoneField, 2, 5);
        this.add(mobileField, 2, 6);
        this.add(centerCodeField, 2, 7);
        this.add(websiteField, 2, 8);

        VBox buttonBox = new VBox(saveButton, closeButton);
        saveButton.setMaxWidth(Double.MAX_VALUE);
        closeButton.setMaxWidth(Double.MAX_VALUE);


        this.add(buttonBox, 3, 1, 1, 5);
    }


    public void bindFieldsToModel() {
        schoolIdField.textProperty().bind(myschool.schoolIdProperty().asString());
        schoolNameField.textProperty().bindBidirectional(myschool.schoolNameProperty());
        locationField.textProperty().bindBidirectional(myschool.locationProperty());
    }


}
