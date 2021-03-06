package guardians;

/**
 * Created by FINETECHLABS on 04/01/2017.

 */




import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

public class parentsList extends Task<ObservableList<parent>> {


//    public  static List<vehicle.vehicle> getPersonsList() {
//
//        String url = "jdbc:sqlite:C:\\Povo Data\\members.db";
//        Connection connection = null;
//        ObservableList<vehicle.vehicle> memberlist= FXCollections.observableArrayList();
//        try
//        {
//            Statement statement = null;
//            // ResultSet rs        = null;
//            Connection conn = Connections. connect();
//
//            statement   =conn.createStatement();
//            String s    = "SELECT * FROM Expenses";
//
//            //rs          = statement.executeQuery(s);
//
//
//            Statement stmnt = connection.createStatement();
//            ResultSet rs = stmnt.executeQuery("select * from MemberList");
//            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection(url);
//
//            while (rs.next()) {
////                Member member= new Member( rs.getString("idNumber"),rs.getString("firstName"),rs.getString("lastName"),
////                        rs.getString("phoneNumber"),rs.getDate("dob").toLocalDate(),rs.getString("refereeIdNumber"),
////                        rs.getString("refereeFirstName"),rs.getString("refereeSecondName"),rs.getString("residence"),rs.getDouble("openingBalance"),rs.getDouble("totalworth"),
////                        rs.getDouble("finecount"),  rs.getDouble("sccruedProfit"),  rs.getDouble("accruedLoss"),  rs.getString("activeStatus")
////                        );
////
////memberlist.add(member);
////                Member person = new Member(idNumber,firstName, lastName,phoneNumber,dob.toLocalDate(),refereeIdNumber,refereeFirstName,refereeLastName,residence,openingBalance,totalworth,finecount,accruedProfit,accruedLoss,
////                        activestatus);
//                // personList.add(person);
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return memberlist ;
//    }


    //    public static ObservableList<vehicle.vehicle> getExpenses()
//    {
//        ObservableList<vehicle.vehicle> loanlist= FXCollections.observableArrayList();
//        Connection c = null;
//        Statement statement = null;
//        ResultSet rs        = null;
//
//        try {
//            Connection conn = Connections. connect();
//
//            statement   =conn.createStatement();
//
//            String s    = "SELECT * FROM MemberList";
//
//            rs          = statement.executeQuery(s);
//            int g =0;
//
//            while (rs.next()) {
////                Member member= new Member( rs.getString("idNumber"),rs.getString("firstName"),rs.getString("lastName"),
////                        rs.getString("phoneNumber"),rs.getDate("dob").toLocalDate(),rs.getString("refereeIdNumber"),
////                        rs.getString("refereeFirstName"),rs.getString("refereeSecondName"),rs.getString("residence"),
////                        rs.getDouble("openingBalance"),rs.getDouble("totalworth"),
////                        rs.getDouble("finecount"),  rs.getDouble("sccruedProfit"),  rs.getDouble("accruedLoss"),
////                        rs.getString("activeStatus")
////                );
////
////                // System.out.print(expenses);
////                loanlist.add(member);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }finally{
//        }
//
//        return loanlist;
//    }
    // RETURN ids
    public static TableColumn<parent, String> getIdNumber() {
        TableColumn<parent, String> empIdNumber = new TableColumn<>("id.no");
        empIdNumber.setCellValueFactory(new PropertyValueFactory<>("nationalId"));
        return empIdNumber;


    }



    // return  names
    public static TableColumn<parent, String> getName() {
        TableColumn<parent, String> memberFirstNameColumn = new TableColumn<>(" Name");
        memberFirstNameColumn.setCellValueFactory(cellData -> {
            parent ms = cellData.getValue();
            String firstname = ms.getFirstName();
            String lastname = ms.getLastName();
            String phone = ms.getPhoneNumber();
            String name = firstname + " " + lastname + " " + phone;
            return new ReadOnlyStringWrapper(name);
        });
        return memberFirstNameColumn;
    }


    //residence
    public static TableColumn<parent, String> getOccupation() {
        TableColumn<parent, String> memberResidenceColumn = new TableColumn<>("occupation");
        memberResidenceColumn.setCellValueFactory(new PropertyValueFactory<>("occupation"));
        return memberResidenceColumn;
    }

    public static TableColumn<parent, String> getPostalAddress() {
        TableColumn<parent, String> memberResidenceColumn = new TableColumn<>("postal address");
        memberResidenceColumn.setCellValueFactory(new PropertyValueFactory<>("postalAddress"));
        return memberResidenceColumn;
    }

    public static TableColumn<parent, String> getActiveStatus() {
        TableColumn<parent, String> memberFineColumn = new TableColumn<>("status");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("activeStatus"));
        return memberFineColumn;
    }




    public static TableColumn<parent, String> getPhoneNumber() {
        TableColumn<parent, String> memberFineColumn = new TableColumn<>("telephone");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        return memberFineColumn;
    }


    public static TableColumn<parent, String> getMobileNumber() {
        TableColumn<parent, String> memberFineColumn = new TableColumn<>("mobile");
        memberFineColumn.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        return memberFineColumn;
    }

    public static TableColumn<parent, String> getEmailAddress() {
        TableColumn<parent, String> spouseNameColumn = new TableColumn<>("email");
        spouseNameColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        return spouseNameColumn;
    }

    public static TableColumn<parent, String> getRole() {
        TableColumn<parent, String> spouseNameColumn = new TableColumn<>("role");
        spouseNameColumn.setCellValueFactory(new PropertyValueFactory<>("Role"));
        return spouseNameColumn;
    }


//    public static TableColumn<vehicle.vehicle, String> getWorth() {
//        TableColumn<vehicle.vehicle, String> spouseNameColumn = new TableColumn<>("TOTAL SAVINGS");
//        spouseNameColumn.setCellValueFactory(cellData -> {
//            vehicle.vehicle ms = cellData.getValue();
//            Double firstname = ms.getTotalWorth();
//            new MoneyFormatCell();
//            NumberFormat formatter=NumberFormat.getInstance();
//
//
//            return new ReadOnlyStringWrapper(formatter.format(firstname)+"");
//
//        });
//        return spouseNameColumn;
//    }
//    public static TableColumn<Member, String> getAge() {
//        TableColumn<Member, String> memberAge = new TableColumn<>("AGE ");
//        memberAge.setCellValueFactory(cellData -> {
//            Member ms = cellData.getValue();
//          String age= ms.getAge();
//            return new ReadOnlyStringWrapper(age);
//        });
//        return memberAge;
//    }


//    public static ObservableList<vehicle.vehicle> getMembers()
//    {
//        ObservableList<vehicle.vehicle> loanlist= FXCollections.observableArrayList();
//        // Connection c = null;
//        Statement statement = null;
//        ResultSet rs        = null;
//        Connection conn = Connections. connect();
//        try {
//
//
//            statement   =conn.createStatement();
//            String s    = "SELECT * FROM MemberList WHERE  activestatus='active'";
//
//            rs  = statement.executeQuery(s);
//
//
//            while (rs.next()) {
//                vehicle.vehicle  memberlist = new vehicle.vehicle(rs.getString("idNumber"),rs.getString("firstName"),rs.getString("lastName"),
//                        rs.getString("phoneNumber"),
//                        rs.getString("refereeIdNumber"),
//                        rs.getString("refereeFirstName"),rs.getString("refereeSecondName"),rs.getString("residence"),
//                        rs.getDouble("openingBalance"),rs.getDouble("totalworth"),
//                        rs.getDouble("finecount"),  rs.getDouble("accruedProfit"),  rs.getDouble("accruedLoss"),
//                        rs.getString("activeStatus"),rs.getDouble("loanbalance"));
//
//                System.out.print(memberlist.getName());
//                loanlist.add(memberlist);
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
//        return loanlist;
//    }




    public static void delete(int id) {
        String sql = " DELETE FROM parents WHERE idNumber = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        common.refreshConnections.refreshMembers();
    }

    public static ObservableList<parent> allParents() {
        ObservableList<parent> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = connect();

            statement = conn.createStatement();
            String s = "SELECT * FROM employees ";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                parent steve = new parent(
                        rs.getString("parentId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("occupation"),
                        rs.getString("Role"),
                        rs.getString("phoneNumber"),
                        rs.getString("emailAddress"),
                        rs.getString("mobileNumber"),
                        rs.getString("postalAddress"),
                        rs.getString("password"),
                        rs.getString("activeStatus"),
                        rs.getString("nationalId")
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

    private static Connection connect() {
        // SQLite connection string

        String url = "jdbc:sqlite:E:/IdeaProjects/PSV SACCO MANAGEMENT/resources/sacco.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    protected ObservableList<parent> call() throws Exception {
        ObservableList<parent> members = FXCollections.observableArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            conn = connect();

            statement = conn.createStatement();
            String s = "SELECT * FROM parents ";

            rs = statement.executeQuery(s);
            int g = 0;

            while (rs.next()) {
                parent steve = new parent(
                        rs.getString("parentId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("occupation"),
                        rs.getString("Role"),
                        rs.getString("phoneNumber"),
                        rs.getString("emailAddress"),
                        rs.getString("mobileNumber"),
                        rs.getString("postalAddress"),
                        rs.getString("password"),
                        rs.getString("activeStatus"),
                        rs.getString("nationalId")
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
