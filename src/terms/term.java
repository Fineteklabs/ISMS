package terms;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/4/2017.
 */
public class term {
    private StringProperty termId = new SimpleStringProperty(this, " termId", null);
    private StringProperty termName = new SimpleStringProperty(this, " termName", null);
    private StringProperty activeStatus = new SimpleStringProperty(this, " activeStatus", null);
    ;
    private ObjectProperty<LocalDate> openingDate = new SimpleObjectProperty<>(this, "openingDate", LocalDate.now());
    private ObjectProperty<LocalDate> closingDate = new SimpleObjectProperty<>(this, "clsoingDate", LocalDate.now().plusDays(60));
    private StringProperty timetablesId = new SimpleStringProperty(this, " timetablesId", null);
    private StringProperty termActivitiesId = new SimpleStringProperty(this, " termActivitiesId", null);


    public term() {

    }


    public term(String termId, String termName, LocalDate openingDate, LocalDate closingDate, String timetableId, String termActivitiesField, String activeStatus) {
        this.activeStatus.set(activeStatus);
        this.termId.set(termId);
        this.termName.set(termName);
        this.openingDate.set(openingDate);
        this.closingDate.set(closingDate);
        this.timetablesId.set(timetableId);
        this.termActivitiesId.set(termActivitiesField);

    }

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


    public void saveTerm() {

    }
}
//extend  term
