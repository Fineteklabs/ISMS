//package exams;
//
//import database.currentDb;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import org.apache.commons.dbutils.DbUtils;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
///**
// * Created by FINETEKLABS on 1/31/2018.
// */
//public class examList {
//
//
//    public static ObservableList<exams> allExams() {
//        ObservableList<exams> allExams = FXCollections.observableArrayList();
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet rs = null;
//
//        try {
//            conn = currentDb.sqlite_connect();
//
//            statement = conn.createStatement();
//            String s = "SELECT * FROM exams ";
//
//            rs = statement.executeQuery(s);
//            int g = 0;
//
//            while (rs.next()) {
//                exams steve = new exams(
//                        rs.getString("examId"),
//                        rs.getString("exam_name"),
//                        rs.getString("level_id"),
//                        rs.getString("current_term"),
//                        rs.getDate("startDate").toLocalDate(),
//                        rs.getDate("startDate").toLocalDate()
//
//
//                );
//
//
//                allExams.add(steve);
//
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            //Code to release your resources
//            DbUtils.closeQuietly(conn);
//            DbUtils.closeQuietly(statement);
//            DbUtils.closeQuietly(rs);
//        }
//
//        return allExams;
//    }
//
//
//    public static ObservableList<exams> currentTermExams() {
//        ObservableList<exams> allExams = FXCollections.observableArrayList();
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet rs = null;
//
//        try {
//            conn = currentDb.sqlite_connect();
//
//            statement = conn.createStatement();
//            String s = "SELECT * FROM exams where current_term =? ";
//
//            rs = statement.executeQuery(s);
//            int g = 0;
//
//            while (rs.next()) {
//                exams steve = new exams(
//                        rs.getString("examId"),
//                        rs.getString("exam_name"),
//                        rs.getString("level_id"),
//                        rs.getString("current_term"),
//                        rs.getDate("startDate").toLocalDate(),
//                        rs.getDate("startDate").toLocalDate()
//
//
//                );
//
//
//                allExams.add(steve);
//
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            //Code to release your resources
//            DbUtils.closeQuietly(conn);
//            DbUtils.closeQuietly(statement);
//            DbUtils.closeQuietly(rs);
//        }
//
//        return allExams;
//    }
//
//
//}
