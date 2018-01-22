package fees;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/3/2017.
 */
public class fee {
    StringProperty payableAccounts;
    private StringProperty feeId;
    private StringProperty classificationId;
    private StringProperty feeCategory;
    private DoubleProperty ammount;
    private ObjectProperty<LocalDate> creationDate;
    private ObjectProperty<LocalDate> deadLine;
    private StringProperty activeState;

    public String getFeeId() {
        return feeId.get();
    }

    public void setFeeId(String feeId) {
        this.feeId.set(feeId);
    }

    public StringProperty feeIdProperty() {
        return feeId;
    }

    public String getClassificationId() {
        return classificationId.get();
    }

    public void setClassificationId(String classificationId) {
        this.classificationId.set(classificationId);
    }

    public StringProperty classificationIdProperty() {
        return classificationId;
    }

    public String getPayableAccounts() {
        return payableAccounts.get();
    }

    public void setPayableAccounts(String payableAccounts) {
        this.payableAccounts.set(payableAccounts);
    }

    public StringProperty payableAccountsProperty() {
        return payableAccounts;
    }

    public String getFeeCategory() {
        return feeCategory.get();
    }

    public void setFeeCategory(String feeCategory) {
        this.feeCategory.set(feeCategory);
    }

    public StringProperty feeCategoryProperty() {
        return feeCategory;
    }

    public double getAmmount() {
        return ammount.get();
    }

    public void setAmmount(double ammount) {
        this.ammount.set(ammount);
    }

    public DoubleProperty ammountProperty() {
        return ammount;
    }

    public LocalDate getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate.set(creationDate);
    }

    public ObjectProperty<LocalDate> creationDateProperty() {
        return creationDate;
    }

    public LocalDate getDeadLine() {
        return deadLine.get();
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine.set(deadLine);
    }

    public ObjectProperty<LocalDate> deadLineProperty() {
        return deadLine;
    }

    public String getActiveState() {
        return activeState.get();
    }

    public void setActiveState(String activeState) {
        this.activeState.set(activeState);
    }

    public StringProperty activeStateProperty() {
        return activeState;
    }
}
