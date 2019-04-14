import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Grade {
    Grade() { }
    private Grade1 grade1;
    private Grade2 grade2;
    private Grade3 grade3;
    private Grade4 grade4;

    public Grade1 getGrade1() {
        return grade1;
    }

    public void setGrade1(Grade1 grade1) {
        this.grade1 = grade1;
    }

    public Grade2 getGrade2() {
        return grade2;
    }

    public void setGrade2(Grade2 grade2) {
        this.grade2 = grade2;
    }

    public Grade3 getGrade3() {
        return grade3;
    }

    public void setGrade3(Grade3 grade3) {
        this.grade3 = grade3;
    }

    public Grade4 getGrade4() {
        return grade4;
    }

    public void setGrade4(Grade4 grade4) {
        this.grade4 = grade4;
    }
}
class Grade1{
    Grade1() { }

    private ArrayList<Object> JSJKX;
    private ArrayList<Object> RZSX;
    private ArrayList<Object> GDSXBA;
    private ArrayList<Object> CP;
    private ArrayList<Object> CPW;
    private ArrayList<Object> XXDS;

    /*
    this.jisuanji = new ArrayList<Double>();
        jisuanji.add(0, rs.getDouble("jisuanji"));
        jisuanji.add(1,rs.getDouble("jisuanji")/peo);
    */

    public ArrayList<Object> getJSJKX() {
        return JSJKX;
    }

    public ArrayList<Object> getRZSX() {
        return RZSX;
    }

    public ArrayList<Object> getGDSXBA() {
        return GDSXBA;
    }

    public ArrayList<Object> getCP() {
        return CP;
    }

    public ArrayList<Object> getCPW() {
        return CPW;
    }

    public ArrayList<Object> getXXDS() {
        return XXDS;
    }

    public void setJSJKX(ResultSet rs, ResultSet name, int peo) {
        try {
            JSJKX = new ArrayList<>();
            JSJKX.add(0, name.getString("JSJKX"));
            JSJKX.add(1, rs.getDouble("JSJKX"));
            JSJKX.add(2, rs.getDouble("JSJKX") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void setRZSX(ResultSet rs, ResultSet name, int peo) {
        try {
            RZSX = new ArrayList<>();
            RZSX.add(0, name.getString("RZSX"));
            RZSX.add(1, rs.getDouble("RZSX"));
            RZSX.add(2, rs.getDouble("RZSX") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void setGDSXBA(ResultSet rs, ResultSet name, int peo) {
        try {
            GDSXBA = new ArrayList<>();
            GDSXBA.add(0, name.getString("GDSXBA"));
            GDSXBA.add(1, rs.getDouble("GDSXBA"));
            GDSXBA.add(2, rs.getDouble("GDSXBA") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void setCP(ResultSet rs, ResultSet name, int peo) {
        try {
            CP = new ArrayList<>();
            CP.add(0, name.getString("CP"));
            CP.add(1, rs.getDouble("CP"));
            CP.add(2, rs.getDouble("CP") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void setCPW(ResultSet rs, ResultSet name, int peo) {
        try {
            CPW = new ArrayList<>();
            CPW.add(0, name.getString("CPW"));
            CPW.add(1, rs.getDouble("CPW"));
            CPW.add(2, rs.getDouble("CPW") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void setXXDS(ResultSet rs, ResultSet name, int peo) {
        try {
            XXDS = new ArrayList<>();
            XXDS.add(0, name.getString("XXDS"));
            XXDS.add(1, rs.getDouble("XXDS"));
            XXDS.add(2, rs.getDouble("XXDS") / peo);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }

    public void set(ResultSet rs, ResultSet name, int peo){
        setCP(rs, name, peo);
        setCPW(rs, name, peo);
        setGDSXBA(rs, name, peo);
        setJSJKX(rs, name, peo);
        setRZSX(rs, name, peo);
        setXXDS(rs, name, peo);
    }

}
class Grade2{
    Grade2() { }

    private double daxuewuli;
    private double daxuewulishiyan;
    private double gaodengshuxue;
    private double jidian;
    private double jidianshiyan;
    private double cplusplus;

    public double getDaxuewuli() {
        return daxuewuli;
    }

    public void setDaxuewuli(double daxuewuli) {
        this.daxuewuli = daxuewuli;
    }

    public double getDaxuewulishiyan() {
        return daxuewulishiyan;
    }

    public void setDaxuewulishiyan(double daxuewulishiyan) {
        this.daxuewulishiyan = daxuewulishiyan;
    }

    public double getGaodengshuxue() {
        return gaodengshuxue;
    }

    public void setGaodengshuxue(double gaodengshuxue) {
        this.gaodengshuxue = gaodengshuxue;
    }

    public double getJidian() {
        return jidian;
    }

    public void setJidian(double jidian) {
        this.jidian = jidian;
    }

    public double getJidianshiyan() {
        return jidianshiyan;
    }

    public void setJidianshiyan(double jidianshiyan) {
        this.jidianshiyan = jidianshiyan;
    }

    public double getCplusplus() {
        return cplusplus;
    }

    public void setCplusplus(double cplusplus) {
        this.cplusplus = cplusplus;
    }
}
class Grade3{
    Grade3() { }

    private double daxuewuli;
    private double daxuewulishiyan;
    private double lishanshuxue;
    private double shudian;
    private double shudianshiyan;
    private double suanfa;

    public double getDaxuewuli() {
        return daxuewuli;
    }

    public void setDaxuewuli(double daxuewuli) {
        this.daxuewuli = daxuewuli;
    }

    public double getDaxuewulishiyan() {
        return daxuewulishiyan;
    }

    public void setDaxuewulishiyan(double daxuewulishiyan) {
        this.daxuewulishiyan = daxuewulishiyan;
    }

    public double getLishanshuxue() {
        return lishanshuxue;
    }

    public void setLishanshuxue(double lishanshuxue) {
        this.lishanshuxue = lishanshuxue;
    }

    public double getShudian() {
        return shudian;
    }

    public void setShudian(double shudian) {
        this.shudian = shudian;
    }

    public double getShudianshiyan() {
        return shudianshiyan;
    }

    public void setShudianshiyan(double shudianshiyan) {
        this.shudianshiyan = shudianshiyan;
    }

    public double getSuanfa() {
        return suanfa;
    }

    public void setSuanfa(double suanfa) {
        this.suanfa = suanfa;
    }
}
class Grade4{
    Grade4() { }

    private double zuyuan;
    private double zuyuanshiyan;
    private double jisuanjiwangluo;
    private double gailvlun;
    private double huibian;
    private double mayuan;

    public double getZuyuan() {
        return zuyuan;
    }

    public void setZuyuan(double zuyuan) {
        this.zuyuan = zuyuan;
    }

    public double getZuyuanshiyan() {
        return zuyuanshiyan;
    }

    public void setZuyuanshiyan(double zuyuanshiyan) {
        this.zuyuanshiyan = zuyuanshiyan;
    }

    public double getJisuanjiwangluo() {
        return jisuanjiwangluo;
    }

    public void setJisuanjiwangluo(double jisuanjiwangluo) {
        this.jisuanjiwangluo = jisuanjiwangluo;
    }

    public double getGailvlun() {
        return gailvlun;
    }

    public void setGailvlun(double gailvlun) {
        this.gailvlun = gailvlun;
    }

    public double getHuibian() {
        return huibian;
    }

    public void setHuibian(double huibian) {
        this.huibian = huibian;
    }

    public double getMayuan() {
        return mayuan;
    }

    public void setMayuan(double mayuan) {
        this.mayuan = mayuan;
    }
}