package subjects;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by FINETEKLABS on 1/30/2018.
 */
public class subjects {
    private final StringProperty subjectId = new SimpleStringProperty(this, "subjectId", null);

    private final StringProperty subjectName = new SimpleStringProperty(this, "subjectId", null);

    private final StringProperty subjectDescription = new SimpleStringProperty(this, "subjectDescription", null);


    private final StringProperty subjectDepartment = new SimpleStringProperty(this, "subjectDepartment", null);


    private final DoubleProperty subjectPassMark = new SimpleDoubleProperty(this, " subjectPassMark", 0.0);


    public String getSubjectId() {
        return subjectId.get();
    }

    public void setSubjectId(String subjectId) {
        this.subjectId.set(subjectId);
    }

    public StringProperty subjectIdProperty() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName.get();
    }

    public void setSubjectName(String subjectName) {
        this.subjectName.set(subjectName);
    }

    public StringProperty subjectNameProperty() {
        return subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription.get();
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription.set(subjectDescription);
    }

    public StringProperty subjectDescriptionProperty() {
        return subjectDescription;
    }

    public String getSubjectDepartment() {
        return subjectDepartment.get();
    }

    public void setSubjectDepartment(String subjectDepartment) {
        this.subjectDepartment.set(subjectDepartment);
    }

    public StringProperty subjectDepartmentProperty() {
        return subjectDepartment;
    }

    public double getSubjectPassMark() {
        return subjectPassMark.get();
    }

    public void setSubjectPassMark(double subjectPassMark) {
        this.subjectPassMark.set(subjectPassMark);
    }

    public DoubleProperty subjectPassMarkProperty() {
        return subjectPassMark;
    }

    public void save() {

    }

    public void delete() {

    }

    public void update() {

    }
}
