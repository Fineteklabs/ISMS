package subjects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by FINETEKLABS on 1/30/2018.
 */
public class subject_departments {

    private final StringProperty departmentId = new SimpleStringProperty(this, "departmentId", null);
    private final StringProperty departmentName = new SimpleStringProperty(this, "subjectId", null);
    private final StringProperty supervisorId = new SimpleStringProperty(this, "subjectId", null);
    private final StringProperty departmentDescription = new SimpleStringProperty(this, "subjectId", null);


    public String getDepartmentId() {
        return departmentId.get();
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId.set(departmentId);
    }

    public StringProperty departmentIdProperty() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName.get();
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName.set(departmentName);
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }

    public String getSupervisorId() {
        return supervisorId.get();
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId.set(supervisorId);
    }

    public StringProperty supervisorIdProperty() {
        return supervisorId;
    }

    public String getDepartmentDescription() {
        return departmentDescription.get();
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription.set(departmentDescription);
    }

    public StringProperty departmentDescriptionProperty() {
        return departmentDescription;
    }
}
