import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentBusiness {
    static StudentJsonBean json;
    static ConnectClass Mysql;
    static ResultSet name;
    static int peo = 58;

    StudentBusiness() { }

    static private StudentJsonBean getJson(ResultSet rs) throws SQLException{
        ArrayList<Students> students = new ArrayList<Students>();
        students.add(0, null);
        students.get(0).setUid(rs.getString("id"));
        students.get(0).setName(rs.getString("name"));
        Grade grade = new Grade();
        grade.getGrade1().set(rs, name, peo);
        students.get(0).setGrade(grade);
        json.setStudents(students);
        return json;
    }

    static public StudentJsonBean getStudent(String id){
        json = new StudentJsonBean();
        PreparedStatement pstmt;
        Statement st;
        ResultSet rs;
        String sql = "select * from Grade1 where id=?";
        try {
            Mysql = new ConnectClass();
            st = Mysql.conn.createStatement();
            pstmt = Mysql.conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            name = st.executeQuery("select * from NameMap");
        }catch (ClassNotFoundException ex1){
            System.out.println(ex1.getMessage());
            json.setCode(505);
            json.setMessage("数据库错误");
            return json;
        }catch (SQLException ex2){
            System.out.println(ex2.getMessage());
            json.setCode(505);
            json.setMessage("数据库错误");
            return json;
        }
        try{
            if(rs.next()){
                getJson(rs);
            }else{
                throw new SQLException("查无此人");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            json.setCode(404);
            json.setMessage("查无此人");
        }

        return json;
    }
}
