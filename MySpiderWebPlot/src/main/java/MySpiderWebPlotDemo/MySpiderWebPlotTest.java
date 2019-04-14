package MySpiderWebPlotDemo;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MySpiderWebPlotTest {
    public static void main(String args[]) {
        //在SWING中显示
        JFrame jf = new JFrame();
        jf.add(erstelleSpinnenDiagramm());
        jf.pack();
        jf.setVisible(true);
        //将JFreeChart保存为图片存在文件路径中
        saveAsFile("C:\\Users\\DELL\\text2.png",500,400);
    }
    public static JPanel erstelleSpinnenDiagramm() {
        JFreeChart jfreechart =createChart();
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        return chartpanel;
    }


    public static void saveAsFile(String outputPath,
                                  int weight, int height) {
        FileOutputStream out = null;
        try {
            File outFile = new File(outputPath);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            out = new FileOutputStream(outputPath);

            // 保存为PNG
            ChartUtilities.writeChartAsPNG(out, createChart(),weight, height);
            // 保存为JPEG
            // ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // do nothing
                }
            }
        }
    }
    public static JFreeChart createChart() {
        MySpiderWebPlot spiderwebplot = new MySpiderWebPlot(createDataset());
        JFreeChart jfreechart = new JFreeChart("成绩雷达图", TextTitle.DEFAULT_FONT,spiderwebplot, false);
        LegendTitle legendtitle = new LegendTitle(spiderwebplot);
        legendtitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(legendtitle);
        return jfreechart;
    }
    public static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String group1 = "林三 ";

        dataset.addValue(49, group1, "组原");
        dataset.addValue(80, group1, "组原实验");
        dataset.addValue(84, group1, "网络");
        dataset.addValue(45, group1, "概率论");
        dataset.addValue(57, group1, "汇编");
        dataset.addValue(86, group1, "马原");
        return dataset;
    }
}
