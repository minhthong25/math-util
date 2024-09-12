package sample.sp24.t4s4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PC
 */
public class DBUtils {

    private static final String DB_NAME = "UserManagement";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        //Buoc 1: Load driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Step 2: Nap chuoi ket noi
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        con = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return con;
    }
    public static Connection getConnectionV2() throws NamingException, SQLException{
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) end.lookup("DBCon");
        conn = ds.getConnection();
        return conn;
    }
    
}
