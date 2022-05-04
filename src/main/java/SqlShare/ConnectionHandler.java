package SqlShare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/2 19:57
 */
public class ConnectionHandler {

    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConn() throws SQLException {
        /*
        为了保证OrderDaoImpl和StockDaoImpl中的Connection是同一个，我们做如下处理
         */
        Connection conn=threadLocal.get();
        /*
        null说明什么？
         */
        if(conn==null){
            String user = "root";
            String dbPassword = "123456";
            String url = "jdbc:mysql://localhost:3306/testshop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.close();
            threadLocal.remove();
        }
    }
}

