package students;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 12/6/2017.
 */
public class student_activities {
    DoubleProperty charges;
    private StringProperty actvityId;
    private StringProperty activityName;
    private DoubleProperty paidIn;
    private DoubleProperty balance;
    private DoubleProperty overPayment;
    private StringProperty ActiveStatus;
    private ObjectProperty<LocalDate> starDate;
    private ObjectProperty<LocalDate> endDate;
    private StringProperty termId;
    private StringProperty categoryId;


    public String getActvityId() {
        return actvityId.get();
    }

    public void setActvityId(String actvityId) {
        this.actvityId.set(actvityId);
    }

    public StringProperty actvityIdProperty() {
        return actvityId;
    }

    public String getActivityName() {
        return activityName.get();
    }

    public void setActivityName(String activityName) {
        this.activityName.set(activityName);
    }

    public StringProperty activityNameProperty() {
        return activityName;
    }

    public double getCharges() {
        return charges.get();
    }

    public void setCharges(double charges) {
        this.charges.set(charges);
    }

    public DoubleProperty chargesProperty() {
        return charges;
    }

    public double getPaidIn() {
        return paidIn.get();
    }

    public void setPaidIn(double paidIn) {
        this.paidIn.set(paidIn);
    }

    public DoubleProperty paidInProperty() {
        return paidIn;
    }

    public double getBalance() {
        return balance.get();
    }

    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public double getOverPayment() {
        return overPayment.get();
    }

    public void setOverPayment(double overPayment) {
        this.overPayment.set(overPayment);
    }

    public DoubleProperty overPaymentProperty() {
        return overPayment;
    }

    public String getActiveStatus() {
        return ActiveStatus.get();
    }

    public void setActiveStatus(String activeStatus) {
        this.ActiveStatus.set(activeStatus);
    }

    public StringProperty activeStatusProperty() {
        return ActiveStatus;
    }

    public LocalDate getStarDate() {
        return starDate.get();
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate.set(starDate);
    }

    public ObjectProperty<LocalDate> starDateProperty() {
        return starDate;
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

    public String getTermId() {
        return termId.get();
    }

    public void setTermId(String termId) {
        this.termId.set(termId);
    }

    public StringProperty termIdProperty() {
        return termId;
    }

    public String getCategoryId() {
        return categoryId.get();
    }

    public void setCategoryId(String categoryId) {
        this.categoryId.set(categoryId);
    }

    public StringProperty categoryIdProperty() {
        return categoryId;
    }
}
