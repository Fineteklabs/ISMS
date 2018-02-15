package database;

import members.student;
import org.apache.commons.dbutils.DbUtils;

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


    private int studentId;

    private String fullName;
    private int activeState;
    private String admissionNumber;
    private String admissionDate;
    private LocalDate dateOfBirth;
    private LocalDate creationDate;


    public saveStudent(student momanyi) {
        this.studentId = momanyi.getStudentId();
        this.fullName = momanyi.getFullName();
        this.activeState = momanyi.getActive();
        this.admissionDate = momanyi.getAdmissionDate();
        this.dateOfBirth = momanyi.getDateOfBirth();
        this.admissionNumber = momanyi.getAdmissionNumber();

    }


    public void savetoMysql() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = currentDb.mysql_connection();
            lock.lock();
            Thread.sleep(1000);
            String sql = "INSERT INTO sims.students  (   id,full_name, admission_number,date_of_birth, active,  admission_date,created_at,image_src) VALUES(?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            pstmt.setString(2, fullName);
            pstmt.setString(3, admissionNumber);
            pstmt.setDate(4, java.sql.Date.valueOf(dateOfBirth));
            pstmt.setInt(5, activeState);
            pstmt.setString(6, LocalDate.now().toString());
            pstmt.setDate(7, java.sql.Date.valueOf(LocalDate.now()));
            pstmt.setString(3, " no image");


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
        savetoMysql();
    }


    public void savetoSql() {
//        PreparedStatement pstmt = null;
//        Connection conn = null;
//        ResultSet rs = null;
//
//        try {
//            conn = currentDb.sqlite_connect();
//            lock.lock();
//            Thread.sleep(1000);
//            String sql = "INSERT INTO students (   studentId, firstName,middleName, lastName,  parentId,email,currentClassId,home, admissionDate, clearanceDate, dateOfBirth,activeState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, studentId);
//            pstmt.setString(2, firstName);
//            pstmt.setString(3, middleName);
//            pstmt.setString(4, lastName);
//            pstmt.setString(5, parentId);
//            pstmt.setString(6, email);
//            pstmt.setString(7, currentClassId);
//            pstmt.setString(8, home);
//            pstmt.setDate(9, java.sql.Date.valueOf(admissionDate));
//            pstmt.setDate(10, java.sql.Date.valueOf(clearanceDate));
//            pstmt.setDate(11, java.sql.Date.valueOf(dateOfBirth));
//            pstmt.setString(12, activeState);
//
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//
//            System.out.println(e.getMessage());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            DbUtils.closeQuietly(rs);
//            DbUtils.closeQuietly(pstmt);
//            DbUtils.closeQuietly(conn);
//            lock.unlock();
//        }
    }
}

