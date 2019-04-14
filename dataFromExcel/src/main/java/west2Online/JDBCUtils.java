package west2Online;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {

    //通过jdbc连接数据库
    private static Connection getConn() {

        String driver = "com.mysql.cj.jdbc.Driver";
        //下面的变量设置根据自己的情况
        String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=UTF8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8"; //数据库是webone
        String username = "root";
        String password = "190516";

        Connection conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


     static void insert(String id,String name,double grade1,double grade2,double grade3,double grade4,double grade5,double grade6,double sum) throws SQLException {

        Connection conn = getConn();
        conn.setAutoCommit(false);
        int i = 0;

        //往数据库插入信息
        String sql = "insert into grade(ID,Name,subject1,subject2,subject3,subject4,subject5,subject6,sum) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt=null;

        try {

            //表示预编译的sql对象
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, grade1);
            pstmt.setDouble(4, grade2);
            pstmt.setDouble(5, grade3);
            pstmt.setDouble(6, grade4);
            pstmt.setDouble(7, grade5);
            pstmt.setDouble(8, grade6);
            pstmt.setDouble(9, sum);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
