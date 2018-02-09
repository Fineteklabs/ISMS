package schools;

import com.jfoenix.controls.*;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by FINETEKLABS on 12/24/2017.
 */
public class school_view extends Tab {
    public VBox border;
    public BorderPane innerborder;
    public school myschool = new school(0, "  ", "NONE ", "NONE  ", " NONE ", "  ", " NONE  ", " NONE ", " NONE ", "  ", " NONE", "  ACTIVE");
    JFXTextField schoolNameField;
    JFXTextField schoolIdField;
    JFXTextField telephoneField;
    JFXTextField mobileField;
    JFXTextField locationField;
    JFXTextField websiteField;
    JFXTextField emailField;
    JFXTextField currentTermField;
    JFXTextField centerCodeField;
    JFXToggleButton activeButton;
    ComboBox academicYearField;
    JFXTextField addressField;
    JFXNodesList add;
    Label schoolName = new Label("School Name:");
    Label schoolId = new Label("School Number");
    Label location = new Label("Location");
    Label email = new Label("School email");
    Label centerCode = new Label("Center Code");
    Label address = new Label("School Address");
    Label telephone = new Label("Telephone.No");
    Label mobile = new Label("Mobile No");
    Label website = new Label("Website");
    Label currentTerm = new Label("Current Term");
    Label academicYear = new Label(" Academic Year");
    Label schoolCategory = new Label(" School Category");
    Label activeStatus = new Label("Active Status");
    //Buttons
    JFXButton saveButton = new JFXButton("save");
    JFXButton closeButton = new JFXButton("close");
    private BorderPane centraldata;
    private VBox leftarea;
    private GridPane myGrid;

    public school_view(school myschool, String title) {
        this.myschool = myschool;
        designs();
        this.setText(title);
        init();
        bindFieldsToModel();
    }

    public void init() {


        this.setContent(GeneralInfo());

    }

    public GridPane designs() {
        this.schoolIdField = new JFXTextField() {
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


        this.schoolNameField = new JFXTextField() {
            final int maxChars = 30;
            final String restictTo = "[ 0-9,a-z A-Z ]";

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
                return text.isEmpty() || (text.matches(restictTo));
            }
        };

        this.schoolNameField.setPromptText(" maseno");
        this.schoolNameField.setMinWidth(200);

        locationField = new JFXTextField() {
            final int maxChars = 30;
            final String restictTo = "[ 0-9,a-z A-Z ]";

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
                return text.isEmpty() || (text.matches(restictTo));
            }
        };

        this.locationField.setPromptText(" e.g kilimani,nairobi kenya");
        this.locationField.setMinWidth(200);

        currentTermField = new JFXTextField() {
            final int maxChars = 25;
            final String restrictTo = "[ 0-9,a-z A-Z ]";
            ;

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
        this.currentTermField.setPromptText("e.g TERM1-2017");


        centerCodeField = new JFXTextField() {
            final int maxChars = 20;
            final String restrictTo = "[ 0-9,a-z A-Z ]";
            ;

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


        centerCodeField.setPromptText("e.g 374000001");


        telephoneField = new JFXTextField() {
            final int maxChars = 40;
            final String restrictTo = "[0-9,+, ,-]";

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
        this.telephoneField.setPromptText("+254 720 543 543");
        emailField = new JFXTextField() {
            final int maxChars = 12;
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
        this.emailField.setPromptText("example@example.com");
        mobileField = new JFXTextField() {
            final int maxChars = 30;
            final String restrictTo = "[0-9,A-Z,. ,  ]";

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
        this.mobileField.setPromptText("020 5673455");


        this.websiteField = new JFXTextField() {
            final int maxChars = 20;
            final String restrictTo = "[ .,0-9,a-z A-Z ]";

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
        this.websiteField.setPromptText(" www.example.com");


        this.addressField = new JFXTextField() {
            final int maxChars = 20;
            final String restrictTo = "[-.,0-9,a-z A-Z ]";

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
        this.addressField.setPromptText(" 9638-0100,NAIROBI");


        activeButton = new JFXToggleButton();
        activeButton.setTooltip(new Tooltip("set active or inactive"));
        activeButton.setToggleColor(Color.DARKGREEN);
        activeButton.setUnToggleColor(Color.SILVER);

        academicYearField = new ComboBox();
        academicYearField.setTooltip(new Tooltip(" current year of study"));
        //academicYearField.setPromptText("academic year");
        academicYearField.getItems().addAll(" 2018-2019", "2017-2018");
        academicYearField.setMinWidth(200);
        JFXButton ssbutton1 = new JFXButton("ADD");
//        add.addAnimatedNode(ssbutton1);


        return layoutField();

    }

    private GridPane layoutField() {
        myGrid = new GridPane();
        myGrid.setHgap(10);
        myGrid.setVgap(10);

        myGrid.add(schoolId, 1, 1);
        myGrid.add(schoolName, 1, 2);
        myGrid.add(currentTerm, 1, 3);

        myGrid.add(location, 1, 4);
        myGrid.add(telephone, 1, 5);
        myGrid.add(mobile, 1, 6);
        myGrid.add(centerCode, 1, 7);
        myGrid.add(website, 1, 8);


        myGrid.add(email, 3, 1);
        myGrid.add(activeStatus, 3, 2);
        myGrid.add(academicYear, 3, 3);
        myGrid.add(address, 3, 4);
        myGrid.add(schoolIdField, 2, 1);
        myGrid.add(schoolNameField, 2, 2);
        myGrid.add(currentTermField, 2, 3);
        myGrid.add(locationField, 2, 4);
        myGrid.add(telephoneField, 2, 5);
        myGrid.add(mobileField, 2, 6);
        myGrid.add(centerCodeField, 2, 7);
        myGrid.add(websiteField, 2, 8);
        myGrid.add(emailField, 4, 1);
        myGrid.add(activeButton, 4, 2);
        myGrid.add(academicYearField, 4, 3);
        myGrid.add(addressField, 4, 4);
        // myGrid.add(add,5,3);


        HBox buttonBox = new HBox(saveButton, closeButton);
        buttonBox.setSpacing(10);
        saveButton.setMaxWidth(60);

        saveButton.getStyleClass().add("button-raised");
        closeButton.setMaxWidth(60);
        closeButton.getStyleClass().add("button-raised");

        saveButton.setOnAction(e -> {

        });
        myGrid.add(buttonBox, 4, 6, 5, 5);
        return myGrid;


    }

    public void bindFieldsToModel() {
        //   schoolIdField.textProperty().bind(myschool.schoolIdProperty().asString());
        schoolNameField.textProperty().bindBidirectional(myschool.schoolNameProperty());
        locationField.textProperty().bindBidirectional(myschool.locationProperty());
    }


    public SplitPane GeneralInfo() {
        JFXScrollPane pane = new JFXScrollPane();

        pane.setContent(layoutField());

        JFXHamburger button = new JFXHamburger();
        HamburgerSlideCloseTransition burgerTask = new HamburgerSlideCloseTransition(button);
        burgerTask.setRate(-1);
        button.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();
        });
        button.setAlignment(Pos.TOP_LEFT);
        button.setPadding(new Insets(10, 0, 0, 10));
        SVGGlyph arrow = new SVGGlyph(0, "FULLSCREEN", "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z", Color.WHITE);
        // arrow.setSize(20, 16);
//        button.getAnimation()
//        button.setRipplerFill(Color.WHITE);
//
//        button.setOnAction(e->{
//            //companyPane.tabs.getSelectionModel().selectPrevious();
//        });
        pane.getTopBar().getChildren().add(button);
        pane.getTopBar().setStyle("-fx-background-color: WHITE");
        Label title = new Label("SCHOOL INFORMATION");
        pane.getMainHeader().getChildren().add(title);
        title.setStyle("-fx-text-fill:WHITE; -fx-font-size: 40;");
        JFXScrollPane.smoothScrolling((ScrollPane) pane.getChildren().get(0));
        pane.getTopBar().setMaxHeight(50);
        //pane.getCondensedHeader().getChildren().add(title)
        pane.getBottomBar().setMaxHeight(50);
        pane.setAlignment(title, Pos.CENTER_LEFT);
        pane.setAlignment(button, Pos.CENTER_LEFT);

        //  myCompanySettings.chooser.getStyleClass().add("button-raised");


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
        centraldata.setCenter(pane);
//        centraldata.setBottom(memberDataForm.Add());
        centraldata.setPadding(new Insets(10, 10, 10, 10));

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

    public boolean isvalidEntry(List<String> errorList) {

        boolean isValid = true;
        String sid = schoolIdField.getText();
        if (sid == null || sid.trim().length() > 2) {
            errorList.add("school id is already taken");
            isValid = false;
        }
        String name = schoolNameField.getText();
        if (name == null || name.trim().length() <= 5) {
            errorList.add("school name must contain more than 5 characters");
            isValid = false;
        }
        String stelephone = telephoneField.getText();
        if (stelephone == null || stelephone.trim().length() <= 8) {
            errorList.add("telephone must be atleast 5 numbers");
            isValid = true;
            ;
        }
        String location = locationField.getText();
        if (location == null || location.trim().length() <= 5) {
            errorList.add("location field must be atleast 4 numbers");
            isValid = true;
            ;
        }
        String mobile = mobileField.getText();
        if (mobile == null || mobile.trim().length() <= 5) {
            errorList.add("mobile must be atleast 4 numbers");
            isValid = true;
        }

        String centercode = centerCodeField.getText();
        if (centercode == null || centercode.trim().length() <= 5) {
            errorList.add("center code must be atleast 4 numbers");
            isValid = true;
            ;
        }


        String academicyear = academicYearField.getSelectionModel().getSelectedItem().toString();
        if (academicyear == null || academicyear.trim().length() <= 4) {
            errorList.add("academic year must be atleast 4 numbers");
            isValid = false;
            ;
        }


        String email = emailField.getText();
        if (email == null || email.trim().length() <= 10) {
            errorList.add("email field must be filled correctly");
            isValid = true;
        }

        String website = websiteField.getText();
        if (website == null || website.trim().length() <= 4) {
            errorList.add("website  code must be atleast 4 numbers");
            isValid = false;
        }

        String currentTerm = currentTermField.getText();
        if (currentTerm == null || currentTerm.trim().length() <= 4) {
            errorList.add("term  must be atleast 4 characters");
            isValid = false;
        }

        return isValid;

    }


    public boolean isValidSchool(int schoolId, String schoolName, String centerCode, String academicYear, String location, String address, String mobile,
                                 String telephone, String website, String email, String currentTerm, String activeState, List<String> errorList) {

        schoolId = Integer.parseInt(schoolIdField.getText());
        schoolName = schoolNameField.getText().toUpperCase().trim();
        centerCode = centerCodeField.getText().trim().toUpperCase();
        academicYear = academicYearField.getSelectionModel().getSelectedItem().toString();
        address = addressField.getText().toUpperCase().trim();
        location = locationField.getText().trim().toUpperCase();
        telephone = telephoneField.getText().toUpperCase().trim();
        website = websiteField.getText().toUpperCase().trim();
        email = emailField.getText().trim().toUpperCase();
        currentTerm = currentTermField.getText().trim().toUpperCase();
        activeState = getActiveStates();


        return true;
    }

    public String getActiveStates() {
        String active;
        if (activeButton.isSelected()) {
            active = "ACTIVE";
        } else {
            active = "CLOSED";

        }
        return active;
    }

    public school validSchool() {
        school maseno;
        Integer schoolId;
        String schoolName;
        String centerCode;
        String academicYear;
        String location;
        String address;
        String mobile;
        String telephone;
        String website;
        String email;
        String currentTerm;
        String activeState;

        if (schoolIdField.getText().isEmpty() || schoolIdField.getText() == null) {

        } else {
            schoolId = Integer.parseInt(schoolIdField.getText().trim().toUpperCase());
        }


        if (schoolNameField.getText().isEmpty() || schoolNameField.getText() == null) {

        } else {
            schoolName = schoolNameField.getText();
        }

        if (centerCodeField.getText().isEmpty() || centerCodeField.getText() == null) {

        } else {
            centerCode = centerCodeField.getText().trim().toUpperCase();
        }

        if (academicYearField.getSelectionModel().getSelectedItem().toString().isEmpty() || academicYearField.getSelectionModel().getSelectedItem().toString() == null) {

        } else {
            academicYear = academicYearField.getSelectionModel().getSelectedItem().toString();
        }

        if (locationField.getText().isEmpty() || locationField.getText() == null) {

        } else {
            location = locationField.getText().trim().toUpperCase();
        }
        if (addressField.getText().isEmpty() || addressField.getText().trim() == null) {

        } else {
            address = addressField.getText().toUpperCase().trim();
        }
        if (telephoneField.getText().isEmpty() || telephoneField.getText() == null) {

        } else {
            telephone = telephoneField.getText();
        }

        if (mobileField.getText().isEmpty() || mobileField.getText() == null) {

        } else {
            mobile = mobileField.getText().toUpperCase().trim();
        }

        if (websiteField.getText().isEmpty() || websiteField.getText() == null) {
        } else {
            website = websiteField.getText().trim().toUpperCase();

        }
        if (emailField.getText().isEmpty() || emailField.getText() == null) {

        } else {
            email = emailField.getText().trim().toUpperCase();
        }
        if (currentTermField.getText().isEmpty() || currentTermField.getText() == null) {

        } else {
            currentTerm = currentTermField.getText().toUpperCase().trim();
        }


        return maseno
    }

}













































