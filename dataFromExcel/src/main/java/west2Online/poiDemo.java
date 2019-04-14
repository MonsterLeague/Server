package west2Online;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class poiDemo {
    public static String excelPath  = "C:\\Users\\DELL\\dataFromExcel\\text.xls";

    public static void main(String[] args) throws FileNotFoundException {
        poimothed();
    }

    public static void poimothed() throws FileNotFoundException{
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                int suffixIndex = split.length -1;
                Workbook wb=null;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[suffixIndex])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[suffixIndex])){

                }else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                for(int i=0;i<wb.getNumberOfSheets();i++) {
                    Sheet sheet = wb.getSheetAt(i);     //读取sheet 0

                    int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
                    int lastRowIndex = sheet.getLastRowNum();
                    //System.out.println("firstRowIndex: " + firstRowIndex);
                    //System.out.println("lastRowIndex: " + lastRowIndex);

                    for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                        //System.out.println("rIndex: " + rIndex);
                        Row row = sheet.getRow(rIndex);
                        if (row != null) {
                            int firstCellIndex = row.getFirstCellNum();
                            int lastCellIndex = row.getLastCellNum();
                            String studentID = null;
                            String name = null;
                            double computerCompositionPrinciple=0 ;
                            double computerCompositionPrincipleExperiment=0;
                            double computerNetwork=0;
                            double probability=0;
                            double assemblyLanguage=0;
                            double basicPriciplesOfMarxism=0;
                            double sum=0;

                            for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                                Cell cell = row.getCell(cIndex);
                                if (cell != null && !"".equals(cell.toString().trim())) {
                                    if (cIndex == 0) {
                                        studentID = cell.toString();
                                        System.out.println("1:" + studentID);
                                    }
                                    if (cIndex == 1) {
                                        name = cell.toString();
                                        System.out.println("2:" + name);
                                    }
                                    if (cIndex == 2) {
                                        computerCompositionPrinciple= cell.getNumericCellValue();
                                        sum+=computerCompositionPrinciple;
                                        System.out.println("2:" + computerCompositionPrinciple);
                                    }
                                    if (cIndex == 3) {
                                        computerCompositionPrincipleExperiment = cell.getNumericCellValue();
                                        sum+=computerCompositionPrincipleExperiment;
                                        System.out.println("3:" + computerCompositionPrincipleExperiment);
                                    }
                                    if (cIndex == 4) {
                                        computerNetwork = cell.getNumericCellValue();
                                        sum+=computerNetwork;
                                        System.out.println("4:" + computerNetwork);
                                    }
                                    if (cIndex == 5) {
                                        probability = cell.getNumericCellValue();
                                        sum+=probability;
                                        System.out.println("5:" + probability);
                                    }
                                    if (cIndex == 6) {
                                        assemblyLanguage = cell.getNumericCellValue();
                                        sum+= assemblyLanguage;
                                        System.out.println("6:" + assemblyLanguage);
                                    }
                                    if (cIndex == 7) {
                                        basicPriciplesOfMarxism = cell.getNumericCellValue();
                                        sum+=basicPriciplesOfMarxism;
                                        System.out.println("7:" + basicPriciplesOfMarxism);
                                    }
                                }
                            }
                            //System.out.println(sum);
                            //插入大二下的数据
                            JDBCUtils.insert(studentID,name,computerCompositionPrinciple,computerCompositionPrincipleExperiment,computerNetwork,probability,assemblyLanguage,basicPriciplesOfMarxism,sum);

                        }
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
