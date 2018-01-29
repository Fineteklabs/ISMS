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
    private StringProperty exam_description = new SimpleStringProperty(this, "examId", null);
    private ObjectProperty<LocalDate> startDate = new SimpleObjectProperty(this, " startDate", null);
    private ObjectProperty<LocalDate> endDate = new SimpleObjectProperty(this, " endDate ", null);
    private StringProperty levelId = new SimpleStringProperty(this, " levelId", null);
    private StringProperty currentTerm = new SimpleStringProperty(this, " currentTerm", null);

    


}
