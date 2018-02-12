package guardians;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by FINETEKLABS on 12/4/2017.
 */
public class parent {

    private StringProperty parentId = new SimpleStringProperty(this, "parentId", null);
    ;
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", null);
    ;;
    private StringProperty lastName = new SimpleStringProperty(this, "lastName", null);
    ;
    private StringProperty occupation = new SimpleStringProperty(this, "occupation", null);
    ;
    private StringProperty Role = new SimpleStringProperty(this, "role", null);
    ;
    private StringProperty phoneNumber = new SimpleStringProperty(this, "phoneNumber", null);
    ;
    private StringProperty emailAdress = new SimpleStringProperty(this, "emailAddress", null);
    ;
    private StringProperty nationalIdentifiaction = new SimpleStringProperty(this, "nationalId", null);
    ;
    private StringProperty mobileNumber = new SimpleStringProperty(this, "mobileNumber", null);
    ;
    private StringProperty homeAdress = new SimpleStringProperty(this, "homeAddress", null);
    ;
    private StringProperty postalAdress = new SimpleStringProperty(this, "postalAddress", null);
    ;
    private StringProperty password = new SimpleStringProperty(this, "password", null);
    ;
    private StringProperty activeStatus = new SimpleStringProperty(this, "activeStatus", null);
    ;

    public parent(String parentId, String firstName, String lastName, String occupation, String Role, String phoneNumber,
                  String emailAddress, String mobileNumber, String postalAddress, String password, String activeStatus, String nationalId) {
        this.activeStatus.set(activeStatus);
        this.parentId.set(parentId);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.occupation.set(occupation);
        this.emailAdress.set(emailAddress);
        this.mobileNumber.set(mobileNumber);
        this.postalAdress.set(postalAddress);
        this.Role.set(Role);
        this.phoneNumber.set(phoneNumber);
        this.nationalIdentifiaction.set(nationalId);
        this.password.set(password);
    }

    ;


    public parent() {
        this(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
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

    public String getOccupation() {
        return occupation.get();
    }

    public void setOccupation(String occupation) {
        this.occupation.set(occupation);
    }

    public StringProperty occupationProperty() {
        return occupation;
    }

    public String getRole() {
        return Role.get();
    }

    public void setRole(String role) {
        this.Role.set(role);
    }

    public StringProperty roleProperty() {
        return Role;
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

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress.get();
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress.set(emailAdress);
    }

    public StringProperty emailAdressProperty() {
        return emailAdress;
    }

    public String getMobileNumber() {
        return mobileNumber.get();
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber.set(mobileNumber);
    }

    public StringProperty mobileNumberProperty() {
        return mobileNumber;
    }

    public String getHomeAdress() {
        return homeAdress.get();
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress.set(homeAdress);
    }

    public StringProperty homeAdressProperty() {
        return homeAdress;
    }

    public String getPostalAdress() {
        return postalAdress.get();
    }

    public void setPostalAdress(String postalAdress) {
        this.postalAdress.set(postalAdress);
    }

    public StringProperty postalAdressProperty() {
        return postalAdress;
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

    public String getActiveStatus() {
        return activeStatus.get();
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus.set(activeStatus);
    }

    public StringProperty activeStatusProperty() {
        return activeStatus;
    }

    public String getNationalIdentifiaction() {
        return nationalIdentifiaction.get();
    }

    public void setNationalIdentifiaction(String nationalIdentifiaction) {
        this.nationalIdentifiaction.set(nationalIdentifiaction);
    }

    public StringProperty nationalIdentifiactionProperty() {
        return nationalIdentifiaction;
    }

    public String toString() {
        return "[name:" + firstName.get() + " " + lastName.get() +
                ", phone:" + mobileNumber.get() +
                ", home" + homeAdress.get();

    }

    public enum Roles {
        GUARDIAN, PARENT, SPONSOR, SIBLING, OFFICIAL,
    }
}
