package database;

import levels.level;
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
public class saveLevel implements Runnable {
    private static Lock lock = new ReentrantLock();

    String levelId;
    String levelName;
    String levelDescription;
    String supervisorId;
    String currentTermId;
    String levelFeeStructure;
    Integer levelMaximmumPopulation;
    Integer levelPassMarks;
    Double levelFees;
    LocalDate created_at;

    public saveLevel(level myclass) {
        this.levelId = myclass.getLevelId();
        this.levelName = myclass.getLevelName();
        this.levelDescription = myclass.getLevelDescription();
        this.supervisorId = myclass.getSupervisorId();
        this.currentTermId = myclass.getCurrentTermId();
        this.levelFeeStructure = myclass.getLevelFeeStructureId();
        this.levelMaximmumPopulation = myclass.getLevelMaxPopulation();
        this.levelPassMarks = myclass.getLevelPassMarks();
        this.levelFees = myclass.getLevelFees();
        this.created_at = LocalDate.now();

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
            String sql = "INSERT INTO levels  (   levelId, levelName,levelDescription, supervisorId,  currentTermId,levelFeeStructureId,levelMaxPopulation,levelPassMarks,levelFees,created) VALUES(?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, levelId);
            pstmt.setString(2, levelName);
            pstmt.setString(3, levelDescription);
            pstmt.setString(4, supervisorId);
            pstmt.setString(5, currentTermId);
            pstmt.setString(6, levelFeeStructure);
            pstmt.setInt(7, levelMaximmumPopulation);
            pstmt.setInt(8, levelPassMarks);
            pstmt.setDouble(9, levelFees);

            pstmt.setDate(6, java.sql.Date.valueOf(created_at));


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
