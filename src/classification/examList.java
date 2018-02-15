package classification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 7/10/2017.
 */
public class examList extends Task<ObservableList<exams>> {
    static exams steve;

    // RETURN exam Name
    public static TableColumn<exams, String> getExamName() {
        TableColumn<exams, String> classificationName = new TableColumn<>("Exam Name");
        classificationName.setCellValueFactory(new PropertyValueFactory<>("exam_name"));
        return classificationName;
    }

    // return exam id
    public static TableColumn<exams, String> getExamId() {
        TableColumn<exams, String> classificationId = new TableColumn<>("exam id ");
        classificationId.setCellValueFactory(new PropertyValueFactory<exams, String>("exam_id"));
        return classificationId;
    }


    public static TableColumn<exams, String> getLevelId() {
        TableColumn<exams, String> classificationId = new TableColumn<>("level id ");
        classificationId.setCellValueFactory(new PropertyValueFactory<exams, String>("level_id"));
        return classificationId;
    }

    //current term-+++++++++++++++++++++++++++++
    public static TableColumn<exams, String> getCurrentTerm() {
        TableColumn<exams, String> classificationDescription = new TableColumn<>("term done");
        classificationDescription.setCellValueFactory(new PropertyValueFactory<>("current_term"));
        return classificationDescription;
    }


    public static TableColumn<exams, LocalDate> getEndDate() {
        TableColumn<exams, LocalDate> dateColumn = new TableColumn<>("end date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        return dateColumn;
    }

    public static TableColumn<exams, LocalDate> getStartDate() {
        TableColumn<exams, LocalDate> dateColumn = new TableColumn<>("start date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        return dateColumn;
    }

    public static ObservableList<exams> examsList() {
        ObservableList<exams> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.sqlite_connect();

            statement = conn.createStatement();
            String s = "SELECT * FROM classification ";

            rs = statement.executeQuery(s);
            int g = 0;

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
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //Code to release your resources
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
        }

        return members;
    }

    @Override
    protected ObservableList<exams> call() throws Exception {
        ObservableList<exams> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.sqlite_connect();

            statement = conn.createStatement();
            String s = "SELECT * FROM MemberList ";

            rs = statement.executeQuery(s);
            int g = 0;

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
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //Code to release your resources
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
        }

        return members;
    }


}
