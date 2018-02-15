package classification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 7/25/2017.
 */
public class generateExam implements Runnable {
    public static ObservableList<exams> members = FXCollections.observableArrayList();
    public static exams steve;
    private static Lock lock = new ReentrantLock();
    private String classId;


    public generateExam(String classificationId) {
        classId = classificationId;

    }

    @Override
    public void run() {
        Statement statement = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.sqlite_connect();
            lock.lock();
            Thread.sleep(1000);
            String sql = "SELECT * FROM exams ";


            rs = statement.executeQuery(sql);

            while (rs.next()) {
                steve = new exams(
                        rs.getString("exam_id"),
                        rs.getString("exam_name"),
                        rs.getString("level_id"),
                        rs.getString("current_term"),
                        rs.getDate("creationDate").toLocalDate(),
                        rs.getDate("scheduleReview").toLocalDate()
                );


                members.add(steve);


            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
            lock.unlock();
        }
    }
}
