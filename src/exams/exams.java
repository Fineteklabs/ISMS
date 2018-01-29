package exams;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/6/2017.
 */
public class exams {
    private StringProperty examId = new SimpleStringProperty(this, "examId", null);
    private StringProperty exam_name = new SimpleStringProperty(this, "examId", null);
    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty(this, " startDate", null);
    private ObjectProperty<LocalDate> endDate = new SimpleObjectProperty(this, " endDate ", null);
    private StringProperty levelId = new SimpleStringProperty(this, " levelId", null);
    private StringProperty currentTerm = new SimpleStringProperty(this, " currentTerm", null);


    public exams(String examId, String exam_name, String levelId, String currentTerm, LocalDate startDate, LocalDate endDate) {
        this.currentTerm.set(currentTerm);
        this.exam_name.set(exam_name);
        this.examId.set(examId);
        this.levelId.set(levelId);
        this.startDate.set(startDate);
        this.endDate.set(endDate);
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

    public String getExam_name() {
        return exam_name.get();
    }

    public void setExam_name(String exam_name) {
        this.exam_name.set(exam_name);
    }

    public StringProperty exam_nameProperty() {
        return exam_name;
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate.get();
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public ObjectProperty<LocalDate> endDateProperty() {
        return endDate;
    }

    public String getLevelId() {
        return levelId.get();
    }

    public void setLevelId(String levelId) {
        this.levelId.set(levelId);
    }

    public StringProperty levelIdProperty() {
        return levelId;
    }

    public String getCurrentTerm() {
        return currentTerm.get();
    }

    public void setCurrentTerm(String currentTerm) {
        this.currentTerm.set(currentTerm);
    }

    public StringProperty currentTermProperty() {
        return currentTerm;
    }

    public void delete(exams mock) {

    }

}
