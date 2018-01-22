package levels;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by FINETEKLABS on 1/12/2018.
 */
public class addLevel extends GridPane {
    Label levelId = new Label(" level id");
    Label levelName = new Label(" level name");
    Label levelDescription = new Label("description");
    Label supervisorId = new Label(" supervisor id");
    Label currentTermId = new Label(" currentTerm");
    Label currentFeeStructure = new Label("  Fee structure");
    Label maxPopulation = new Label(" maximmum population");
    Label levelFees = new Label(" fees");
    Label levelPassMarks = new Label("pass marks");


    JFXButton save = new JFXButton(" save");
    JFXButton close = new JFXButton(" close");
    JFXButton search = new JFXButton(" search");


    JFXTextField levelIdField = new JFXTextField() {
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


    JFXTextField levelNameField = new JFXTextField() {
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
    JFXTextField levelDescriptionField = new JFXTextField() {
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


    JFXTextField supervisorIdField = new JFXTextField() {
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
    JFXTextField currentTermField = new JFXTextField() {
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

    JFXTextField supervisorField = new JFXTextField() {
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


    JFXTextField feeStructureField = new JFXTextField() {
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

    JFXTextField passMarksField = new JFXTextField() {
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

    JFXTextField maxPopulatioFieldn = new JFXTextField() {
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


    public GridPane layoutField() {

        this.add(levelId, 1, 1);
        this.add(levelName, 1, 2);
        this.add(levelDescription, 1, 3);
        this.add(currentTermId, 1, 4);
        this.add(levelPassMarks, 1, 5);
        this.add(levelFees, 1, 6);
        this.add(supervisorId, 1, 7);

        this.add(levelIdField, 2, 1);
        this.add(levelNameField, 2, 2);
        this.add(levelDescriptionField, 2, 3);
        this.add(currentTermField, 2, 4);
        this.add(passMarksField, 2, 5);
        this.add(feeStructureField, 2, 6);
        this.add(supervisorField, 2, 7);


        return this;
    }
}
