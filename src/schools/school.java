package schools;

import database.saveSchool;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by FINETEKLABS on 11/29/2017.
 */
public class school {

    private static ExecutorService executor;
    private static AtomicInteger schoolsSequence = new AtomicInteger(0);
    ;
    private final IntegerProperty schoolId =
            new SimpleIntegerProperty(this, "schoolId", schoolsSequence.incrementAndGet());
    private final StringProperty schoolName = new SimpleStringProperty(this, "schoolName", null);
    private final StringProperty centerCode = new SimpleStringProperty(this, "centerCode", null);
    private final StringProperty schoolRegistration = new SimpleStringProperty(this, "schoolRegistration", null);
    private final StringProperty academicYear = new SimpleStringProperty(this, "academicYear", null);
    private final StringProperty location = new SimpleStringProperty(this, "location", null);
    private final StringProperty address = new SimpleStringProperty(this, "address", null);
    private final StringProperty telephone = new SimpleStringProperty(this, "telephone", null);
    private final StringProperty mobile = new SimpleStringProperty(this, "mobile", null);
    private final StringProperty website = new SimpleStringProperty(this, "website", null);
    private final StringProperty email = new SimpleStringProperty(this, "email", null);
    private final StringProperty currentTerm = new SimpleStringProperty(this, "currentTerm", null);
    private final StringProperty activeState = new SimpleStringProperty(this, "activeState", null);

    public school() {
//        this(1, null, null, null, null, null, null, null, null, null, null, null);
    }


    public school(int schoolId, String schoolName, String centerCode,
                  String academicYear, String location, String address, String mobile,
                  String telephone, String website, String email, String currentTerm, String activeState) {
        this.academicYear.set(academicYear);
        this.activeState.set(activeState);
        this.address.set(address);
        this.centerCode.set(centerCode);
        this.currentTerm.set(currentTerm);
        this.mobile.set(mobile);
        this.telephone.set(telephone);
        this.schoolName.set(schoolName);
        this.website.set(website);
        this.location.set(location);
        this.schoolId.set(schoolId);
        this.email.set(email);
    }

    public static AtomicInteger getSchoolsSequence() {
        return schoolsSequence;
    }

    public static void setSchoolsSequence(AtomicInteger schoolsSequence) {
        school.schoolsSequence = schoolsSequence;
    }


    public static ExecutorService getExecutor() {
        return executor;
    }

    public static void setExecutor(ExecutorService executor) {
        school.executor = executor;
    }

    public int getSchoolId() {
        return schoolId.get();
    }

    public void setSchoolId(int schoolId) {
        this.schoolId.set(schoolId);
    }

    public IntegerProperty schoolIdProperty() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName.get();
    }

    public void setSchoolName(String schoolName) {
        this.schoolName.set(schoolName);
    }

    public StringProperty schoolNameProperty() {
        return schoolName;
    }

    public String getCenterCode() {
        return centerCode.get();
    }

    public void setCenterCode(String centerCode) {
        this.centerCode.set(centerCode);
    }

    public StringProperty centerCodeProperty() {
        return centerCode;
    }

    public String getSchoolRegistration() {
        return schoolRegistration.get();
    }

    public void setSchoolRegistration(String schoolRegistration) {
        this.schoolRegistration.set(schoolRegistration);
    }

    public StringProperty schoolRegistrationProperty() {
        return schoolRegistration;
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

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty locationProperty() {
        return location;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    public String getWebsite() {
        return website.get();
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public StringProperty websiteProperty() {
        return website;
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

    public String getCurrentTerm() {
        return currentTerm.get();
    }

    public void setCurrentTerm(String currentTerm) {
        this.currentTerm.set(currentTerm);
    }

    public StringProperty currentTermProperty() {
        return currentTerm;
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

    public Boolean isValidSchool(school mySchool, List<String> errorList) {
        boolean isValid = true;

        String sname = mySchool.getSchoolName();
        if (sname == null || sname.trim().length() <= 5) {
            errorList.add("school name must contain more than 5 characters");
            isValid = false;
        }
        Integer sid = mySchool.getSchoolId();

        if (sid == null || sid < 1) {
            errorList.add(" your school does not have a valid school id");

        }
        String stelephone = mySchool.getTelephone();
        if (stelephone == null || stelephone.trim().length() <= 5) {
            errorList.add("telephone must be atleast 5 numbers");
            isValid = false;
            ;
        }


        return isValid;
    }

    public boolean isValidSchool(List<String> errorList) {
        return isValidSchool(this, errorList);
    }

    public boolean save(List<String> errorList, school maseno) {
        boolean isSaved = false;

        if (isValidSchool(errorList)) {
            executor = Executors.newFixedThreadPool(2);
            executor.execute(new saveSchool(maseno));
            isSaved = true;
        }

        //save to db
        //save to db
        return isSaved;

    }


    public void save() {


        executor = Executors.newFixedThreadPool(2);
        executor.execute(new saveSchool(this));


        //save to db
        //save to db


    }




    public enum schoolCategory {
        PRIVATE, PUBLIC, SECONDARY, PRIMARY, SENIOR,
    }


}
