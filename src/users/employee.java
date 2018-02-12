package users;

import javafx.beans.property.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FINETECHLABS on 04/01/2017.
 */
public class employee implements Serializable {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", null);
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", null);
    private final StringProperty idNumber = new SimpleStringProperty(this, "idNumber", null);
    private final DoubleProperty salary = new SimpleDoubleProperty(this, "salary", 0.0);
    private final StringProperty station = new SimpleStringProperty(this, "station", null);
    private final StringProperty phoneNumber = new SimpleStringProperty(this, "phoneNumber", null);
    private final StringProperty residence = new SimpleStringProperty(this, "residence", null);
    //  private StringProperty altPhone;
    private final ObjectProperty<LocalDate> recruitmentDate = new SimpleObjectProperty<>(this, "recruitmentDate", null);
    private final StringProperty activeStatus = new SimpleStringProperty(this, "activeStatus", null);
    ;
    private final DoubleProperty bonus = new SimpleDoubleProperty(this, "bonus", 0.0);
    private final DoubleProperty wage = new SimpleDoubleProperty(this, "wage", 0.0);
    private final StringProperty position = new SimpleStringProperty(this, "position", null);
    ;
    private final ObjectProperty<LocalDate> dob = new SimpleObjectProperty<>(this, "dob", null);
    private final StringProperty maritalStatus = new SimpleStringProperty(this, "maritalStatus", null);
    private final StringProperty password = new SimpleStringProperty(this, "password", null);
    ;

    public employee() {
        this(null, null, null, null, null, null, null, null, null, 0.0, 0.0, 0.0, null, null, null);
    }

    public employee(String idNumber, String firstName, String lastName, String phoneNumber, String residence, String station, String position,
                    String activeStatus, String maritalStatus, double salary, double wage, double bonus, LocalDate dob, LocalDate recruitmentDate, String password) {
        this.idNumber.set(idNumber);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.residence.set(residence);
        this.station.set(station);
        this.activeStatus.set(activeStatus);
        this.maritalStatus.set(maritalStatus);
        this.salary.set(salary);
        this.dob.set(dob);
        this.position.set(position);
        this.wage.set(wage);
        this.bonus.set(bonus);
        this.password.set(password);
        this.recruitmentDate.set(recruitmentDate);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getIdNumber() {
        return idNumber.get();
    }

    public void setIdNumber(String idNumber) {
        this.idNumber.set(idNumber);
    }

    public StringProperty idNumberProperty() {
        return idNumber;
    }

    public double getSalary() {
        return salary.get();
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public String getStation() {
        return station.get();
    }

    public void setStation(String station) {
        this.station.set(station);
    }

    public StringProperty stationProperty() {
        return station;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getResidence() {
        return residence.get();
    }

    public void setResidence(String residence) {
        this.residence.set(residence);
    }

    public StringProperty residenceProperty() {
        return residence;
    }

    public String getActiveStatus() {
        return activeStatus.get();
    }

//    public String getAltPhone() {
//        return altPhone.get();
//    }
//
//    public StringProperty altPhoneProperty() {
//        return altPhone;
//    }
//
//    public void setAltPhone(String altPhone) {
//        this.altPhone.set(altPhone);
//    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus.set(activeStatus);
    }

    public StringProperty activeStatusProperty() {
        return activeStatus;
    }

    public double getBonus() {
        return bonus.get();
    }

    public void setBonus(double bonus) {
        this.bonus.set(bonus);
    }

    public DoubleProperty bonusProperty() {
        return bonus;
    }

    public double getWage() {
        return wage.get();
    }

    public void setWage(double wage) {
        this.wage.set(wage);
    }

    public DoubleProperty wageProperty() {
        return wage;
    }

    public LocalDate getDob() {
        return dob.get();
    }

    public void setDob(LocalDate dob) {
        this.dob.set(dob);
    }

    public ObjectProperty<LocalDate> dobProperty() {
        return dob;
    }

    public String getMaritalStatus() {
        return maritalStatus.get();
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus.set(maritalStatus);
    }

    public StringProperty maritalStatusProperty() {
        return maritalStatus;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate.get();
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate.set(recruitmentDate);
    }

    public ObjectProperty<LocalDate> recruitmentDateProperty() {
        return recruitmentDate;
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public StringProperty positionProperty() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("NAME:%s",
                getFirstName());
    }

    /* Domain specific business rules */
    public boolean isValidBirthDate(LocalDate bdate) {
        return isValidBirthDate(bdate, new ArrayList<>());
    }

    /* Domain specific business rules */
    public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
        if (bdate == null) {
            return true;
        }
// Birth date cannot be in the future
        if (bdate.isAfter(LocalDate.now())) {
            errorList.add("Birth date must not be in future.");
            return false;
        }
        return true;
    }

    /* Domain specific business rules */
    public boolean isValidPerson(List<String> errorList) {
        return isValidPerson(this, errorList);
    }

    /* Domain specific business rules */
    public boolean isValidPerson(employee p, List<String> errorList) {
        boolean isValid = true;
        String fn = p.firstName.get();
        if (fn == null || fn.trim().length() == 0) {
            errorList.add("First name must contain minimum one character.");
            isValid = false;
        }
        String ln = p.lastName.get();
        if (ln == null || ln.trim().length() == 0) {
            errorList.add("Last name must contain minimum one character.");
            isValid = false;
        }
        if (!isValidBirthDate(this.recruitmentDate.get(), errorList)) {
            isValid = false;
        }
        return isValid;
    }

    public boolean save(List<String> errorList) {
        boolean isSaved = false;
        if (isValidPerson(errorList)) {
            System.out.println("Saved " + this.toString());
            isSaved = true;
        }
        return isSaved;
    }

    //private StringProperty classification;
    //private DoubleProperty heldCash;
    public enum jobCategory {
        MANAGER, SUPERVISOR, DIRECTOR, SALARIED, CASUAL, INTERN
    }
}
