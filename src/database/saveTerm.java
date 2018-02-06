package database;

import org.apache.commons.dbutils.DbUtils;
import terms.term;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 2/6/2018.
 */
public class saveTerm implements Runnable {

    private static Lock lock = new ReentrantLock();
    private String term_id;
    private String term_name;
    private String active_status;
    private LocalDate opening_date;
    private LocalDate closing_date;
    private String term_activities_id;
    private String timetables_id;


    public saveTerm(term currentTerm) {
        this.term_id = currentTerm.getTermId();
        this.term_name = currentTerm.getTermName();
        this.active_status = currentTerm.getActiveStatus();
        this.opening_date = currentTerm.getOpeningDate();
        this.closing_date = currentTerm.getClosingDate();
        this.term_activities_id = currentTerm.getTermActivitiesId();
        this.timetables_id = currentTerm.getTimetablesId();
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
            String sql = "INSERT INTO term (   termId, termName,activeStatus, openingDate,  closingDate,timetableId,termActivitiesId,created) VALUES(?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, term_id);
            pstmt.setString(2, term_name);
            pstmt.setString(3, active_status);

            pstmt.setDate(4, java.sql.Date.valueOf(opening_date));
            pstmt.setDate(5, java.sql.Date.valueOf(closing_date));
            pstmt.setString(6, timetables_id);
            pstmt.setString(7, term_activities_id);
            pstmt.setDate(8, java.sql.Date.valueOf(LocalDate.now()));
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
