package parents;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by FINETEKLABS on 1/9/2018.
 */
public class addParent extends GridPane {


    protected parent momanyi = new parent(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
    Label parentId = new Label(" parent  id");
    Label firstName = new Label(" first name");
    Label lastName = new Label(" last name");
    Label occupation = new Label(" occupation");
    Label role = new Label(" roles");
    Label phoneNumber = new Label(" phone number");
    Label emailAddress = new Label(" email address");
    Label mobileAddress = new Label(" mobile number");
    Label postalAddress = new Label(" postal address");
    Label password = new Label(" password");
    Label activeStatus = new Label(" active status");
    Label nationalId = new Label("national id.No");
    Label homeAddress = new Label("home address");
    //Buttons
    JFXButton saveButton = new JFXButton("save");
    JFXButton closeButton = new JFXButton("close");
    // textfields
    JFXTextField parentFirstNameField = new JFXTextField() {
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
    JFXTextField parentLastNameField = new JFXTextField() {
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
    JFXTextField parentNationalIdField = new JFXTextField() {
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
    JFXTextField parentIdFieldField = new JFXTextField() {
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
    JFXTextField occupationField = new JFXTextField() {
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
    JFXTextField roleField = new JFXTextField() {
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
    JFXTextField emailAddressField = new JFXTextField() {
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
    JFXTextField postalAddressField = new JFXTextField() {
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
    JFXTextField passwordField = new JFXTextField() {
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
    JFXTextField activeStatusField = new JFXTextField() {
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
    JFXPasswordField mobileNumberField = new JFXPasswordField() {
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
    JFXPasswordField phoneNumberField = new JFXPasswordField() {
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

    public addParent(parent momanyi) {
        this.momanyi = momanyi;
        layoutField();
    }


    public GridPane layoutField() {
        this.setHgap(15);
        this.setVgap(10);

        this.add(parentId, 1, 1);
        this.add(firstName, 1, 2);
        this.add(lastName, 3, 2);
        this.add(role, 1, 4);
        this.add(occupation, 3, 4);
        this.add(phoneNumber, 1, 5);
        this.add(mobileAddress, 3, 5);
        this.add(homeAddress, 1, 6);
        this.add(postalAddress, 1, 8);
        this.add(password, 1, 9);
        this.add(nationalId, 1, 10);
        this.add(emailAddress, 1, 11);

        this.add(parentIdFieldField, 2, 1);
        this.add(parentFirstNameField, 2, 2);
        this.add(parentLastNameField, 4, 2);
        this.add(roleField, 2, 4);
        this.add(occupationField, 4, 4);
        this.add(phoneNumberField, 2, 5);
        this.add(mobileNumberField, 4, 5);
        this.add(homeField, 2, 6);
        this.add(postalAddressField, 2, 8);
        this.add(passwordField, 2, 9);
        this.add(parentNationalIdField, 2, 10);
        this.add(emailAddressField, 2, 11);


//        this.add(phoneNumberField,2,9);

//        this.add(postalAddressField,2,11);
        this.add(saveButton, 5, 13);
        this.add(closeButton, 6, 13);
        return this;
    }


}
