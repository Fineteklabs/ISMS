package schools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by FINETEKLABS on 2/12/2018.
 */
public class schoolLists {


    public static ObservableList<school> getActiveSchool() {
        ObservableList<school> activeSchool = FXCollections.observableArrayList();

        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.sqlite_connect();

            statement = conn.createStatement();
            String s = "SELECT * FROM school WHERE schoolId='2'";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                school maseno = new school(
                        rs.getInt("schoolId"),
                        rs.getString("schoolName"),
                        rs.getString("centerCode"),
                        rs.getString("academicYear"),
                        rs.getString("location"),
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getString("mobile"),
                        rs.getString("website"),
                        rs.getString("email"),
                        rs.getString("currentTerm"),
                        rs.getString("activeState"));

                activeSchool.add(maseno);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //Code to release your resources
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
        }

        return activeSchool;
    }
}

