package members;

/**
 * Created by FINETECHLABS on 31/08/2016.
 */

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentList extends Task<ObservableList<student>> {


    // RETURN ids
//    public static TableColumn<student, Integer> getIdColumn() {
//        TableColumn<student, Integer> memberIdColumn = new TableColumn<>("student id");
//        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
//
//        return memberIdColumn;
//
//
//    }

    public static TableColumn<student, String> getStream() {
        TableColumn<student, String> memberIdColumn = new TableColumn<>("stream");
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("stream"));

        return memberIdColumn;


    }

    public static TableColumn<student, String> getActiveStatus() {
        TableColumn<student, String> memberFirstNameColumn = new TableColumn<>("active");
        memberFirstNameColumn.setCellValueFactory(cellData -> {
            student ms = cellData.getValue();
            int active = 0;
            active = ms.getActive();
            String name;
            if (ms.getActive() == 0) {
                name = "INACTIVE";
            } else if (ms.getActive() == 1) {
                name = "ACTIVE";
            } else {
                name = " ";
            }

            return new ReadOnlyStringWrapper(name);
        });


        memberFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        memberFirstNameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<student, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<student, String> t) {
                        ((student) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
                    }
                }
        );
        return memberFirstNameColumn;
    }

    // return  names
//    public static TableColumn<student, String> getNameColumn() {
//        TableColumn<student, String> memberFirstNameColumn = new TableColumn<>("Full Name");
//        memberFirstNameColumn.setCellValueFactory(cellData -> {
//            student ms = cellData.getValue();
//            String firstname = ms.getFirstName();
//            String lastname = ms.getLastName();
//
//            String name = firstname + " " + lastname;
//            return new ReadOnlyStringWrapper(name);
//        });
//
//
//        memberFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        memberFirstNameColumn.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<student, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<student, String> t) {
//                        ((student) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setFirstName(t.getNewValue());
//                    }
//                }
//        );
//        return memberFirstNameColumn;
//    }


//    public static TableColumn<student, String> getName() {
//        TableColumn<student, String> getNames = new TableColumn<>("name");
//        getNames.setCellValueFactory(cellData -> {
//            student ms = cellData.getValue();
//
//
//            String name = ms.getName();
//            return new ReadOnlyStringWrapper(name);
//        });
//        return getNames;
//    }
    //residence
//    public static TableColumn<student, String> getResidence() {
//        TableColumn<student, String> memberResidenceColumn = new TableColumn<>("RESIDENCE");
//        memberResidenceColumn.setCellValueFactory(new PropertyValueFactory<>("residence"));
//        memberResidenceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        memberResidenceColumn.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<student, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<student, String> t) {
//                        ((student) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setResidence(t.getNewValue());
//                    }
//                }
//        );

//
//        return memberResidenceColumn;
//    }


    public static TableColumn<student, String> getAdmissionNumber() {
        TableColumn<student, String> memberFineColumn = new TableColumn<>("admission number");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("admissionNumber"));
        return memberFineColumn;
    }


    public static TableColumn<student, String> getCurrentClass() {
        TableColumn<student, String> memberFineColumn = new TableColumn<>("class");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("currentClassId"));
        return memberFineColumn;
    }




    public static TableColumn<student, String> getAdmissionDate() {
        TableColumn<student, String> memberFineColumn = new TableColumn<>("admission date");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("admissionDate"));
        return memberFineColumn;
    }

    public static TableColumn<student, String> getFullName() {
        TableColumn<student, String> memberFineColumn = new TableColumn<>("name");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        return memberFineColumn;
    }


    public static ObservableList<student> allStudents() {
        ObservableList<student> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.mysql_connection();

            statement = conn.createStatement();
            String s = "SELECT * FROM sims.students ";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                student steve = new student(rs.getInt("id"),

                        rs.getString("full_name"),
                        rs.getString("admission_number"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("admission_date"),
                        rs.getDate("created_at").toLocalDate()

                        // rs.getDate("dob").toLocalDate()
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


    public static ObservableList<student> student_with_classes() {
        ObservableList<student> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = database.currentDb.mysql_connection();

            statement = conn.createStatement();
            String s = "SELECT DISTINCT sims.students.id,sims.students.date_of_birth,sims.students.active ,sims.students.admission_date,sims.students.full_name,sims.students.admission_number,sims.students.created_at, sims.classes.id,sims.classes.class_name,sims.classes.stream_name,sims.class_student.class_id,sims.class_student.student_id FROM sims.students JOIN sims.class_student ON sims.students.admission_number= sims.class_student.student_id JOIN sims.classes ON sims.class_student.class_id=sims.classes.id;";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                student steve = new student(rs.getInt("id"),

                        rs.getString("full_name"),
                        rs.getString("admission_number"),
                        rs.getString("class_name"),
                        rs.getString("stream_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("admission_date"),
                        rs.getDate("created_at").toLocalDate(),
                        rs.getInt("active")
                        // rs.getDate("dob").toLocalDate()
                );
//System.out.println(steve);

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


//    public static ObservableList<Member> inactiveMembers()
//    {
//        ObservableList<Member> members= FXCollections.observableArrayList();
//
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet rs        = null;
//
//        try {
//            conn = Connections. connect();
//
//            statement   =conn.createStatement();
//            String s    = "SELECT * FROM MemberList WHERE activestatus='SUSPENDED'";
//
//            rs          = statement.executeQuery(s);
//            int g =0;
//
//            while (rs.next()) {
//                Member steve= new Member(rs.getString("idNumber"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("phoneNumber"),
//
//                        rs.getString("refereeIdNumber"),
//                        rs.getString("refereeFirstName"),
//                        rs.getString("refereeLastName"),
//                        rs.getString("residence"),
//                        rs.getDouble("openingBalance"),
//                        rs.getDouble("totalWorth"),
//                        rs.getDouble("finecount"),
//                        rs.getDouble("accruedProfit"),
//                        rs.getDouble("accruedLoss"),
//                        rs.getString("activestatus"),
//                        rs.getDouble("loanbalance"));
//
//                members.add(steve);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }finally{
//            //Code to release your resources
//            DbUtils.closeQuietly(conn);
//            DbUtils.closeQuietly(statement);
//            DbUtils.closeQuietly(rs);
//        }
//
//        return members;
//    }
//    public static ObservableList<Member> LoanEligibleMembers()
//    {
//        ObservableList<Member> members= FXCollections.observableArrayList();
//
//        Connection conn = null;
//        Statement statement = null;
//        ResultSet rs        = null;
//
//        try {
//            conn = Connections. connect();
//
//            statement   =conn.createStatement();
//            String s    = "SELECT * FROM MemberList WHERE activestatus='ACTIVE'AND loanbalance=0";
//
//            rs          = statement.executeQuery(s);
//            int g =0;
//
//            while (rs.next()) {
//                Member steve= new Member(rs.getString("idNumber"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("phoneNumber"),
//
//                        rs.getString("refereeIdNumber"),
//                        rs.getString("refereeFirstName"),
//                        rs.getString("refereeLastName"),
//                        rs.getString("residence"),
//                        rs.getDouble("openingBalance"),
//                        rs.getDouble("totalWorth"),
//                        rs.getDouble("finecount"),
//                        rs.getDouble("accruedProfit"),
//                        rs.getDouble("accruedLoss"),
//                        rs.getString("activestatus"),
//                        rs.getDouble("loanbalance"));
//
//                members.add(steve);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }finally{
//            //Code to release your resources
//            DbUtils.closeQuietly(conn);
//            DbUtils.closeQuietly(statement);
//            DbUtils.closeQuietly(rs);
//        }
//
//        return members;
//    }

    public static void delete(int id) {
        String sql = " DELETE FROM MemberList WHERE idNumber = ?";

//        try (Connection conn = db.Connections.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            // set the corresponding param
//            pstmt.setInt(1, id);
//            // execute the delete statement
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        common.refreshConnections.refreshMembers();
    }

    @Override
    protected ObservableList<student> call() throws Exception {
        ObservableList<student> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
//            conn =  Connections. connect();
//
//            statement   =conn.createStatement();
//            String s    = "SELECT * FROM MemberList ";
//
//            rs          = statement.executeQuery(s);
//            int g =0;
//
//            while (rs.next()) {
//                Member steve= new Member(rs.getString("idNumber"),
//                        rs.getString("firstName"),
//                        rs.getString("lastName"),
//                        rs.getString("phoneNumber"),
//
//                        rs.getString("refereeIdNumber"),
//                        rs.getString("refereeFirstName"),
//                        rs.getString("refereeLastName"),
//                        rs.getString("residence"),
//                        rs.getDouble("openingBalance"),
//                        rs.getDouble("totalWorth"),
//                        rs.getDouble("finecount"),
//                        rs.getDouble("accruedProfit"),
//                        rs.getDouble("accruedLoss"),
//                        rs.getString("activestatus"),
//                        rs.getDouble("loanbalance"));
//
//                members.add(steve);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
        } finally {
            //Code to release your resources
            DbUtils.closeQuietly(conn);
            DbUtils.closeQuietly(statement);
            DbUtils.closeQuietly(rs);
        }

        return members;
    }


}
