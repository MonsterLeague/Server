import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

public class StudentInq extends HttpServlet {
    public StudentInq(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("uid"));
        StudentJsonBean json = StudentBusiness.getStudent(request.getParameter("uid"));
        String gson;
        gson = new Gson().toJson(json);
        PrintWriter out = response.getWriter();
        out.print(gson);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
