package database;

import org.apache.commons.dbutils.DbUtils;
import students.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 12/17/2017.
 */
public class saveStudent implements Runnable {
    private static Lock lock = new ReentrantLock();


    private String studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String parentId;
    private String email;
    private String currentClassId;
    private String activeState;
    private String home;
    private LocalDate clearanceDate;
    private LocalDate dateOfBirth;
    private LocalDate admissionDate;


    public saveStudent(student momanyi) {
        this.studentId = momanyi.getStudentId();
        this.firstName = momanyi.getFirstName();
        this.lastName = momanyi.getLastName();
        this.middleName = momanyi.getMiddleName();
        this.parentId = momanyi.getParentId();
        this.email = momanyi.getEmail();
        this.currentClassId = momanyi.getCurrentClassId();
        this.activeState = momanyi.getActiveState();
        this.home = momanyi.getHome();
        this.clearanceDate = momanyi.getClearanceDate();
        this.dateOfBirth = momanyi.getDateOfBirth();
        this.admissionDate = momanyi.getAdmissionDate();
    }


    public void savetoMysql() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = currentDb.mysql_connection();
            lock.lock();
            Thread.sleep(1000);
            String sql = "INSERT INTO   (   studentId, firstName,middleName, lastName,  parentId,email,currentClassId,home, admissionDate, clearanceDate, dateOfBirth,activeState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, parentId);
            pstmt.setString(6, email);
            pstmt.setString(7, currentClassId);
            pstmt.setString(8, home);
            pstmt.setDate(9, java.sql.Date.valueOf(admissionDate));
            pstmt.setDate(10, java.sql.Date.valueOf(clearanceDate));
            pstmt.setDate(11, java.sql.Date.valueOf(dateOfBirth));
            pstmt.setString(12, activeState);


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
            pstmt.setString(1, studentId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, middleName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, parentId);
            pstmt.setString(6, email);
            pstmt.setString(7, currentClassId);
            pstmt.setString(8, home);
            pstmt.setDate(9, java.sql.Date.valueOf(admissionDate));
            pstmt.setDate(10, java.sql.Date.valueOf(clearanceDate));
            pstmt.setDate(11, java.sql.Date.valueOf(dateOfBirth));
            pstmt.setString(12, activeState);


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

