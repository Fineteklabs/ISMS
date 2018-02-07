package students;

import database.saveStudent;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by FINETEKLABS on 11/29/2017.
 */
public class student {
    private static ExecutorService executor;
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", null);
    ;
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", null);
    private final StringProperty middleName = new SimpleStringProperty(this, "middleName", null);
    private final StringProperty studentId = new SimpleStringProperty(this, "studentId", null);
    private final StringProperty parentId = new SimpleStringProperty(this, "parentId", null);
    private final StringProperty home = new SimpleStringProperty(this, "home", null);
    private final ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth", null);
    private final StringProperty email = new SimpleStringProperty(this, "email", null);
    private final StringProperty activeState = new SimpleStringProperty(this, "activeState", null);
    private final StringProperty currentClassId = new SimpleStringProperty(this, "currentClassId", null);
    private final StringProperty currentStream = new SimpleStringProperty(this, "currentStream,null");
    private final ObjectProperty<LocalDate> admissionDate = new SimpleObjectProperty<>(this, "admissionDate", null);
    private final ObjectProperty<LocalDate> clearanceDate = new SimpleObjectProperty<>(this, "clearanceDate", null);

    public student(String studentId, String firstName, String middleName, String lastName, String parentId, String email, String currentClassId, String home, LocalDate admissionDate, LocalDate clearanceDate, LocalDate dateOfBirth, String activeState) {
        this.studentId.set(studentId);
        this.firstName.set(firstName);
        this.middleName.set(middleName);
        this.lastName.set(lastName);
        this.parentId.set(parentId);
        this.email.set(email);
        this.currentClassId.set(currentClassId);
        this.activeState.set(activeState);
        this.home.set(home);
        this.clearanceDate.set(clearanceDate);
        this.dateOfBirth.set(dateOfBirth);
        this.admissionDate.set(admissionDate);
    }

    public student() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
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

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public String getHome() {
        return home.get();
    }

    public void setHome(String home) {
        this.home.set(home);
    }

    public StringProperty homeProperty() {
        return home;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getStudentId() {
        return studentId.get();
    }

    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public StringProperty studentIdProperty() {
        return studentId;
    }

    public String getParentId() {
        return parentId.get();
    }

    public void setParentId(String parentId) {
        this.parentId.set(parentId);
    }

    public StringProperty parentIdProperty() {
        return parentId;
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

    public LocalDate getAdmissionDate() {
        return admissionDate.get();
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate.set(admissionDate);
    }

    public ObjectProperty<LocalDate> admissionDateProperty() {
        return admissionDate;
    }

    public LocalDate getClearanceDate() {
        return clearanceDate.get();
    }

    public void setClearanceDate(LocalDate clearanceDate) {
        this.clearanceDate.set(clearanceDate);
    }

    public ObjectProperty<LocalDate> clearanceDateProperty() {
        return clearanceDate;
    }

    public String getCurrentClassId() {
        return currentClassId.get();
    }

    public void setCurrentClassId(String currentClassId) {
        this.currentClassId.set(currentClassId);
    }

    public StringProperty currentClassIdProperty() {
        return currentClassId;
    }

    public String getCurrentStream() {
        return currentStream.get();
    }

    public void setCurrentStream(String currentStream) {
        this.currentStream.set(currentStream);
    }

    public StringProperty currentStreamProperty() {
        return currentStream;
    }

    public boolean isValidBirthDate(LocalDate bdate) {
        return isValidBirthDate(bdate, new ArrayList<>());
    }

    /* Domain specific business rules */
    public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
        if (bdate == null) {
            return true;
        }

        if (bdate.isAfter(LocalDate.now())) {
            errorList.add("Birth date must not be in future.");
            return false;
        }
        return true;
    }

    public AgeCategory getAgeCategory() {
        if (dateOfBirth.get() == null) {
            return AgeCategory.UNKNOWN;
        }
        long years = ChronoUnit.YEARS.between(dateOfBirth.get(), LocalDate.now());
        if (years >= 0 && years < 2) {
            return AgeCategory.BABY;
        } else if (years >= 2 && years < 13) {
            return AgeCategory.CHILD;
        } else if (years >= 13 && years <= 19) {
            return AgeCategory.TEEN;
        } else if (years > 19 && years <= 50) {
            return AgeCategory.ADULT;
        } else if (years > 50) {
            return AgeCategory.SENIOR;
        } else {
            return AgeCategory.UNKNOWN;
        }
    }

    public Boolean isValidStudent(student momanyi, List<String> errorList) {
        boolean isValid = true;

        String fullName = momanyi.getFirstName() + momanyi.getMiddleName() + momanyi.getLastName();
        if (fullName == null || fullName.trim().length() <= 5) {
            errorList.add(" student  name must contain atleast five characters");
            isValid = false;
        }
        String sid = momanyi.getStudentId();

        if (sid == null || sid.trim().length() < 3) {
            errorList.add(" you've not assigned a valid student id");

        }

        String currentClass = momanyi.getCurrentClassId();
        if (currentClass == null) {
            errorList.add("please assign the student a current class");
            isValid = false;
        }
        LocalDate clearanceDate = momanyi.getClearanceDate();
        if (clearanceDate == null || clearanceDate.isBefore(LocalDate.now())) {
            errorList.add(" please check the expected clearance date of the student");

        }

        isValid = false;


        return isValid;
    }

    public boolean isValidStudent(List<String> errorList) {
        return isValidStudent(this, errorList);
    }

    public boolean save(List<String> errorList, student momanyi) {
        boolean isSaved = false;

        if (isValidStudent(errorList)) {
            executor = Executors.newFixedThreadPool(2);
            executor.execute(new saveStudent(momanyi));
            isSaved = true;
        }

        //save to db
        //save to db
        return isSaved;

    }

    public String toString() {
        return "[name:" + firstName.get() + " " + lastName.get() +
                ", class:" + currentClassId.get() +
                ", clearance" + clearanceDate.get();

    }
    public enum AgeCategory {
        BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
    }
}
