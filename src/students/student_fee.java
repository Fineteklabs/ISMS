package students;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/4/2017.
 */
public class student_fee {
    private StringProperty studentId;
    ;
    private DoubleProperty totalFees;
    private DoubleProperty fowarded;
    private DoubleProperty closingBalance;
    private DoubleProperty refund;
    private StringProperty termId;
    private DoubleProperty activityFees;
    private StringProperty feeStatus;
    private StringProperty fines;
    private ObjectProperty<LocalDate> currentDate;
    private StringProperty staffId;// accountant or oversight officer

    public enum feeStates {
        WAIVERED, COMPLETED, FROZEN, INCOMPLETE, FOWARDED,
    }


}
