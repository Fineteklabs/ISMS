package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by FINETEKLABS on 12/17/2017.
 */
public class currentDb {


    public static Connection sqlite_connect() {
        // SQLite connection string

        String url = "jdbc:sqlite:D:\\IdeaProjects\\SIMS\\src\\resources\\sims.sqlite";
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
}
