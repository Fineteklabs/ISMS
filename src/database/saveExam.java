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
 * Created by FINETEKLABS on 1/29/2018.
 */
public class saveExam implements Runnable {
    private static Lock lock = new ReentrantLock();
    private String exam_id;
    private String exam_name;
    private String level_id;
    private String current_term;
    private LocalDate start_date;
    private LocalDate end_date;


    public saveExam(exams.exams mock) {
        this.exam_id = mock.getExamId();
        this.exam_name = mock.getExam_name();
        this.level_id = mock.getLevelId();
        this.current_term = mock.getCurrentTerm();
        this.start_date = mock.getStartDate();
        this.end_date = mock.getEndDate();
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
            String sql = "INSERT INTO exams (   exam_id, exam_name,  level_id, current_term,  startDate, endDate) VALUES(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, exam_id);
            pstmt.setString(2, exam_name);
            pstmt.setString(3, level_id);
            pstmt.setString(4, current_term);
            pstmt.setDate(5, java.sql.Date.valueOf(start_date));
            pstmt.setDate(6, java.sql.Date.valueOf(end_date));


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