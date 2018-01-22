package students;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by FINETEKLABS on 12/6/2017.
 */
public class student_acad {
    StringProperty studentId;
    StringProperty levelId;
    StringProperty passStatus;
    private DoubleProperty marks;
    private DoubleProperty agp;
    private IntegerProperty entryPoints;
    private StringProperty termId;


    public String getStudentId() {
        return studentId.get();
    }

    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public StringProperty studentIdProperty() {
        return studentId;
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

    public String getPassStatus() {
        return passStatus.get();
    }

    public void setPassStatus(String passStatus) {
        this.passStatus.set(passStatus);
    }

    public StringProperty passStatusProperty() {
        return passStatus;
    }

    public double getMarks() {
        return marks.get();
    }

    public void setMarks(double marks) {
        this.marks.set(marks);
    }

    public DoubleProperty marksProperty() {
        return marks;
    }

    public double getAgp() {
        return agp.get();
    }

    public void setAgp(double agp) {
        this.agp.set(agp);
    }

    public DoubleProperty agpProperty() {
        return agp;
    }

    public int getEntryPoints() {
        return entryPoints.get();
    }

    public void setEntryPoints(int entryPoints) {
        this.entryPoints.set(entryPoints);
    }

    public IntegerProperty entryPointsProperty() {
        return entryPoints;
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
}
