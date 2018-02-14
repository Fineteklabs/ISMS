package database;

import guardians.parent;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 12/17/2017.
 */
public class saveParent implements Runnable {
    private static Lock lock = new ReentrantLock();
    private String firstName;
    private String lastName;
    private String occupation;
    private String Role;
    private String nationalId;
    private String phoneNumber;
    private String emailAdress;
    private String mobileNumber;
    private String homeAdress;
    private String postalAdress;
    private String password;
    private String activeStatus;
    private String parentId;

    public saveParent(parent mzazi) {
        this.parentId = mzazi.getParentId();
        this.firstName = mzazi.getFirstName();
        this.lastName = mzazi.getLastName();
        this.activeStatus = mzazi.getActiveStatus();

        this.occupation = mzazi.getOccupation();
        this.Role = mzazi.getRole();
        this.phoneNumber = mzazi.getPhoneNumber();
        this.emailAdress = mzazi.getEmailAdress();
        this.mobileNumber = mzazi.getHomeAdress();
        this.postalAdress = mzazi.getPostalAdress();
        this.password = mzazi.getPassword();
        this.homeAdress = mzazi.getHomeAdress();
        this.nationalId = mzazi.getNationalIdentifiaction();


    }

    @Override
    public void run() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = currentDb.sqlite_connect();
            lock.lock();
            Thread.sleep(1000);
            String sql = "INSERT INTO students (   studentId, firstName,middleName, lastName,  parentId,email,currentClassId,home, admissionDate, clearanceDate, dateOfBirth,activeState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, parentId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, occupation);
            pstmt.setString(5, parentId);
            pstmt.setString(6, Role);
            pstmt.setString(7, phoneNumber);
            pstmt.setString(8, emailAdress);
            pstmt.setString(9, mobileNumber);
            pstmt.setString(10, postalAdress);
            pstmt.setString(11, password);
            pstmt.setString(12, activeStatus);
            pstmt.setString(13, nationalId);


            pstmt.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(pstmt);
            DbUtils.closeQuietly(conn);
            lock.unlock();
        }
    }
}
