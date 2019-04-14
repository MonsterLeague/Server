package JFreeChart01;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.io.File;

public class JFreeChartTest {
    public static void main(String args[])
    {
        JFreeChartTest.createLineChart();
    }

    public static void createLineChart() {
    DefaultCategoryDataset ds = new DefaultCategoryDataset();
    ds.setValue(0, "ibm", "第一次考试");
    ds.setValue(10, "ibm", "第二次考试");
    ds.setValue(-5, "ibm", "第三次考试");
    ds.setValue(-10, "ibm", "第四次考试");
    String filePath = "C:\\Users\\DELL\\text1.png";

    try {
        // 创建柱状图.标题,X坐标,Y坐标,数据集合,orientation,是否显示legend,是否显示tooltip,是否使用url链接
        org.jfree.chart.JFreeChart chart = ChartFactory.createLineChart("总排名进步曲线", "考试名称", "进步名次", ds, PlotOrientation.VERTICAL,false, true, true);
        chart.setBackgroundPaint(Color.WHITE);

        // 配置字体（解决中文乱码的通用方法）
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        Font xfont = new Font("黑体", Font.BOLD, 30); // X轴
        Font yfont = new Font("宋体", Font.BOLD, 30); // Y轴
        Font titleFont = new Font("宋体", Font.BOLD, 30); // 图片标题
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.getDomainAxis().setLabelFont(xfont);
        categoryPlot.getRangeAxis().setLabelFont(yfont);
        chart.getTitle().setFont(titleFont);

        categoryPlot.setBackgroundPaint(Color.WHITE);
        // x轴 // 分类轴网格是否可见
        categoryPlot.setDomainGridlinesVisible(true);
        // y轴 //数据轴网格是否可见
        categoryPlot.setRangeGridlinesVisible(true);
        // 设置网格竖线颜色
        categoryPlot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        // 设置网格横线颜色
        categoryPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        // 没有数据时显示的文字说明
        categoryPlot.setNoDataMessage("没有数据显示");
        // 设置曲线图与xy轴的距离
        categoryPlot.setAxisOffset(new RectangleInsets(0d, 0d, 0d, 0d));
        // 设置面板字体
        Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 25);
        // 取得Y轴
        NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        rangeAxis.setUpperMargin(0.20);
        rangeAxis.setLabelAngle(Math.PI / 2.0);
        // 取得X轴
        CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
        // 设置X轴坐标上的文字
        categoryAxis.setTickLabelFont(labelFont);
        // 设置X轴的标题文字
        categoryAxis.setLabelFont(labelFont);
        // 横轴上的 Lable 45度倾斜
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        // 设置距离图片左端距离
        categoryAxis.setLowerMargin(0.0);
        // 设置距离图片右端距离
        categoryAxis.setUpperMargin(0.0);
        // 获得renderer 注意这里是渲染到lineandshaperenderer！！
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
        // 是否显示折点
        lineandshaperenderer.setBaseShapesVisible(true);
        // 是否显示折线
        lineandshaperenderer.setBaseLinesVisible(true);
        // series 点（即数据点）间有连线可见 显示折点数据
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);
        ChartUtilities.saveChartAsJPEG(new File(filePath), chart, 1207, 500);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
