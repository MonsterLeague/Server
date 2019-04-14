import java.util.ArrayList;

public class StudentJsonBean {
    StudentJsonBean() { }
    private int code;
    private String message;
    private ArrayList<Students> students;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }
}
