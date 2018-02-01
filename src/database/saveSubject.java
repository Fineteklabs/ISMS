package database;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 2/1/2018.
 */
public class saveSubject implements Runnable {
    private static Lock lock = new ReentrantLock();
    private String subject_id;
    private String subject_name;
    private String subject_description;
    private String department_id;
    private LocalDate creation_date;
    private int subject_passmark;


    public saveSubject(subjects.subjects mysubjects) {
        this.subject_id = mysubjects.getSubjectId();
        this.subject_name = mysubjects.getSubjectName();
        this.subject_description = mysubjects.getSubjectDescription();
        this.department_id = mysubjects.getSubjectDepartment();
        this.creation_date = LocalDate.now();
        this.subject_passmark = mysubjects.getSubjectPassMark();
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
            String sql = "INSERT INTO subjects (   subject_id, subject_name,subjectDescription, department_id,  subjectPassMark,created) VALUES(?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subject_id);
            pstmt.setString(2, subject_name);
            pstmt.setString(3, subject_description);
            pstmt.setString(4, department_id);
            pstmt.setInt(5, subject_passmark);
            pstmt.setDate(6, java.sql.Date.valueOf(creation_date));


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
