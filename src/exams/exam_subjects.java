package exams;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/6/2017.
 */
public class exam_subjects {
    private StringProperty examId = new SimpleStringProperty(this, "examId", null);
    private StringProperty subjectId = new SimpleStringProperty(this, " subjectId", null);
    private ObjectProperty<LocalDate> sittingDate = new SimpleObjectProperty<>(this, " sittingDate", null);
    private StringProperty academicYear = new SimpleStringProperty(this, " academicYear", null);


    public LocalDate getSittingDate() {
        return sittingDate.get();
    }

    public void setSittingDate(LocalDate sittingDate) {
        this.sittingDate.set(sittingDate);
    }

    public ObjectProperty<LocalDate> sittingDateProperty() {
        return sittingDate;
    }

    public String getAcademicYear() {
        return academicYear.get();
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear.set(academicYear);
    }

    public StringProperty academicYearProperty() {
        return academicYear;
    }

    public String getExamId() {
        return examId.get();
    }

    public void setExamId(String examId) {
        this.examId.set(examId);
    }

    public StringProperty examIdProperty() {
        return examId;
    }

    public String getSubjectId() {
        return subjectId.get();
    }

    public void setSubjectId(String subjectId) {
        this.subjectId.set(subjectId);
    }

    public StringProperty subjectIdProperty() {
        return subjectId;
    }
}
