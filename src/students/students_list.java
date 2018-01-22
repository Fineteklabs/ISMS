package students;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by FINETEKLABS on 12/30/2017.
 */
public class students_list extends TableView {

    // Return Student  Name
    public TableColumn<student, String> studentNameColumn() {
        TableColumn<student, String> studentNameColumn = new TableColumn<>("Full Name");
        studentNameColumn.setCellValueFactory(cellData -> {
            student ms = cellData.getValue();
            String firstname = ms.getFirstName();
            String lastname = ms.getLastName();
            String middleName = ms.getMiddleName();

            String name = firstname + " " + middleName + " " + lastname;
            return new ReadOnlyStringWrapper(name);
        });
        return studentNameColumn;
    }

    // return student Identification
    public TableColumn<student, String> studentIdColumn() {
        TableColumn<student, String> studentIdColumn = new TableColumn<>("STUDENT ID ");
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<student, String>("studentId"));
        return studentIdColumn;
    }


    //Email Address
    public TableColumn<student, String> emailAdressColumn() {
        TableColumn<student, String> emailAdressColumn = new TableColumn<>("EMAIL ADRESS");
        emailAdressColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        return emailAdressColumn;
    }


    // return current Class
    public TableColumn<student, String> currentClassColumn() {
        TableColumn<student, String> currentClassId = new TableColumn<>("CURRENT CLASS  ");
        currentClassId.setCellValueFactory(new PropertyValueFactory<student, String>("minimmumIncome"));
        return currentClassId;
    }

    // return active Status
    public TableColumn<student, String> activeStateColumn() {
        TableColumn<student, String> activeStateColumn = new TableColumn<>("ACTIVE STATUS");
        activeStateColumn.setCellValueFactory(new PropertyValueFactory<student, String>("activeState"));
        return activeStateColumn;
    }


}
