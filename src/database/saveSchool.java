package database;

import org.apache.commons.dbutils.DbUtils;
import schools.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 12/17/2017.
 */
public class saveSchool implements Runnable {

    private static Lock lock = new ReentrantLock();

    private int schoolId;
    private String schoolName;
    private String centerCode;
    private String schoolRegistration;
    private String academicYear;
    private String location;
    private String address;
    private String telephone;
    private String mobile;
    private String website;
    private String email;
    private String currentTerm;
    private String activeState;


    public saveSchool(school maseno) {
        this.schoolId = maseno.getSchoolId();
        this.schoolName = maseno.getSchoolName();
        this.centerCode = maseno.getCenterCode();
        this.schoolRegistration = maseno.getSchoolRegistration();
        this.academicYear = maseno.getAcademicYear();
        this.location = maseno.getLocation();
        this.address = maseno.getAddress();
        this.telephone = maseno.getAddress();
        this.mobile = maseno.getMobile();
        this.website = maseno.getWebsite();
        this.email = maseno.getEmail();
        this.currentTerm = maseno.getCurrentTerm();
        this.activeState = maseno.getActiveState();
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
            String sql = "INSERT INTO school (   schoolId,  schoolName, centerCode, schoolRegistration,  academicYear,location,address, telephone, mobile, website,email,currentTerm,activeState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, schoolId);
            pstmt.setString(2, schoolName);
            pstmt.setString(3, centerCode);
            pstmt.setString(4, schoolRegistration);
            pstmt.setString(5, academicYear);
            pstmt.setString(6, location);
            pstmt.setString(7, address);

            pstmt.setString(8, telephone);
            pstmt.setString(9, mobile);
            pstmt.setString(10, website);
            pstmt.setString(11, email);
            pstmt.setString(12, currentTerm);
            pstmt.setString(13, activeState);


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
