package terms;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/4/2017.
 */
public class term {
    private StringProperty termId;
    private StringProperty termName;
    private StringProperty activeStatus;
    private ObjectProperty<LocalDate> openingDate;
    private ObjectProperty<LocalDate> closingDate;
    private StringProperty timetablesId;
    private StringProperty termActivitiesId;


    public String getTermId() {
        return termId.get();
    }

    public void setTermId(String termId) {
        this.termId.set(termId);
    }

    public StringProperty termIdProperty() {
        return termId;
    }

    public String getTermName() {
        return termName.get();
    }

    public void setTermName(String termName) {
        this.termName.set(termName);
    }

    public StringProperty termNameProperty() {
        return termName;
    }

    public String getActiveStatus() {
        return activeStatus.get();
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus.set(activeStatus);
    }

    public StringProperty activeStatusProperty() {
        return activeStatus;
    }

    public LocalDate getOpeningDate() {
        return openingDate.get();
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate.set(openingDate);
    }

    public ObjectProperty<LocalDate> openingDateProperty() {
        return openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate.get();
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate.set(closingDate);
    }

    public ObjectProperty<LocalDate> closingDateProperty() {
        return closingDate;
    }

    public String getTimetablesId() {
        return timetablesId.get();
    }

    public void setTimetablesId(String timetablesId) {
        this.timetablesId.set(timetablesId);
    }

    public StringProperty timetablesIdProperty() {
        return timetablesId;
    }

    public String getTermActivitiesId() {
        return termActivitiesId.get();
    }

    public void setTermActivitiesId(String termActivitiesId) {
        this.termActivitiesId.set(termActivitiesId);
    }

    public StringProperty termActivitiesIdProperty() {
        return termActivitiesId;
    }
}
//extend  term
