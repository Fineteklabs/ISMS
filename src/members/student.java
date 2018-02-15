package members;

import javafx.beans.property.*;

import java.time.LocalDate;
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
    private final StringProperty stream = new SimpleStringProperty(this, "stream", null);
    private final IntegerProperty active = new SimpleIntegerProperty(this, "active", 1);
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", null);
    private final StringProperty fullName = new SimpleStringProperty(this, "full_name", null);
    private final StringProperty admissionNumber = new SimpleStringProperty(this, "admissionNumber", null);

    private final StringProperty middleName = new SimpleStringProperty(this, "middleName", null);
    private final IntegerProperty studentId = new SimpleIntegerProperty(this, "studentId", 0);
    private final StringProperty parentId = new SimpleStringProperty(this, "parentId", null);
    private final StringProperty home = new SimpleStringProperty(this, "home", null);
    private final ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth", null);
    private final StringProperty email = new SimpleStringProperty(this, "email", null);
    private final StringProperty activeState = new SimpleStringProperty(this, "activeState", null);
    private final StringProperty currentClassId = new SimpleStringProperty(this, "currentClassId", null);
    private final StringProperty currentStream = new SimpleStringProperty(this, "currentStream,null");
    private final StringProperty admissionDate = new SimpleStringProperty(this, "admissionDate", null);
    private final ObjectProperty<LocalDate> entryDate = new SimpleObjectProperty<>(this, "clearanceDate", null);
    private final ObjectProperty<LocalDate> clearanceDate = new SimpleObjectProperty<>(this, "clearanceDate", null);

    public student(int studentId, String firstName, String middleName, String lastName, String parentId, String email, String currentClassId, String home, String admissionDate, LocalDate clearanceDate, LocalDate dateOfBirth, String activeState) {
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

    public student(int studentId, String fullName, String admissionNumber, LocalDate dob, String entryDate, LocalDate creationDate) {
        this.studentId.set(studentId);
        this.fullName.set(fullName);
        this.admissionNumber.set(admissionNumber);
        this.dateOfBirth.set(dob);
        this.admissionDate.set(entryDate);
        this.entryDate.set(creationDate);
    }

    public student(int studentId, String fullName, String admissionNumber, String currentClass, LocalDate dob, String entryDate, LocalDate creationDate) {
        this.studentId.set(studentId);
        this.fullName.set(fullName);
        this.admissionNumber.set(admissionNumber);
        this.dateOfBirth.set(dob);
        this.admissionDate.set(entryDate);
        this.entryDate.set(creationDate);
        this.currentClassId.set(currentClass);
    }

    public student(int studentId, String fullName, String admissionNumber, String currentClass, String stream, LocalDate dob, String entryDate, LocalDate creationDate) {
        this.studentId.set(studentId);
        this.fullName.set(fullName);
        this.admissionNumber.set(admissionNumber);
        this.dateOfBirth.set(dob);
        this.admissionDate.set(entryDate);
        this.entryDate.set(creationDate);
        this.currentClassId.set(currentClass);
        this.stream.set(stream);
    }


    public student(int studentId, String fullName, String admissionNumber, String currentClass, String stream, LocalDate dob, String entryDate, LocalDate creationDate, int activeStatus) {
        this.studentId.set(studentId);
        this.fullName.set(fullName);
        this.admissionNumber.set(admissionNumber);
        this.dateOfBirth.set(dob);
        this.admissionDate.set(entryDate);
        this.entryDate.set(creationDate);
        this.currentClassId.set(currentClass);
        this.stream.set(stream);
        this.active.set(activeStatus);
    }


    public student() {
        this(0, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static ExecutorService getExecutor() {
        return executor;
    }

    public static void setExecutor(ExecutorService executor) {
        student.executor = executor;
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

    public int getActive() {
        return active.get();
    }

    public void setActive(int active) {
        this.active.set(active);
    }

    public IntegerProperty activeProperty() {
        return active;
    }

    public String getStream() {
        return stream.get();
    }

    public void setStream(String stream) {
        this.stream.set(stream);
    }

    public StringProperty streamProperty() {
        return stream;
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public String getAdmissionNumber() {
        return admissionNumber.get();
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber.set(admissionNumber);
    }

    public StringProperty admissionNumberProperty() {
        return admissionNumber;
    }

    public int getStudentId() {
        return studentId.get();
    }

    public void setStudentId(int studentId) {
        this.studentId.set(studentId);
    }

    public IntegerProperty studentIdProperty() {
        return studentId;
    }

    public LocalDate getEntryDate() {
        return entryDate.get();
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate.set(entryDate);
    }

    public ObjectProperty<LocalDate> entryDateProperty() {
        return entryDate;
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

    public String getAdmissionDate() {
        return admissionDate.get();
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate.set(admissionDate);
    }

    public StringProperty admissionDateProperty() {
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


    public Boolean isValidStudent(student momanyi, List<String> errorList) {
        boolean isValid = true;

        String fullName = momanyi.getFirstName() + momanyi.getMiddleName() + momanyi.getLastName();
        if (fullName == null || fullName.trim().length() <= 5) {
            errorList.add(" student  name must contain atleast five characters");
            isValid = false;
        }
        Integer sid = momanyi.getStudentId();

        if (sid == null || sid < 3) {
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
            // executor.execute(new saveStudent(momanyi));
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
