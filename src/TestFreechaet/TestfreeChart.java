package TestFreechaet;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class TestfreeChart {
	public static void main(String[] args) throws Exception {
		System.out.println(DB.getConn());
		//createChart(getDatasetSim());

		//createChart3D(getDatasetSim());
		createChart(getDataCom());
		createChart3D(getDataCom());
		createPie3D(getPieDataSet());
	}

	private static CategoryDataset getDatasetSim() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "", "苹果");
		dataset.addValue(200, "", "梨子");
		dataset.addValue(300, "", "葡萄");
		dataset.addValue(400, "", "香蕉");
		dataset.addValue(500, "", "荔枝");
		return dataset;
	}

	private static void createChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart("test", // 图片
				"水果", // 横轴，
				"产量", // 纵轴，数值轴
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是 false)
				false, // 是否生成工具
				false // 是否生成 URL 链接
		);
		setCategoryChart(chart);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("D:\\BarChart.jpg");
			ChartUtilities.writeChartAsJPEG(fileOutputStream, chart, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (Exception e) {
			}
		}

	}

	private static void createChart3D(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart3D("test", // 图片
				"水果", // 横轴，
				"产量", // 纵轴，数值轴
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是 false)
				false, // 是否生成工具
				false // 是否生成 URL 链接
		);
		setCategoryChart(chart);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("D:\\BarChart3D.jpg");
			ChartUtilities.writeChartAsJPEG(fileOutputStream, chart, 400, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (Exception e) {
			}
		}

	}
	private static void createPie3D(DefaultPieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart3D(
				"水果", // 标题，
				dataset, // 数据集
				true, // 是否显示图例(对于简单的柱状图必须是 false)
				false, // 是否生成工具
				false // 是否生成 URL 链接
				);
		setPieChart(chart);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("D:\\PieChart3D.jpg");
			ChartUtilities.writeChartAsJPEG(fileOutputStream, chart, 300, 400);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static CategoryDataset getDataCom() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "苹果");//参数（double value, Comparable rowKey, Comparable columnKey）；
		dataset.addValue(100, "上海", "苹果");//---（数值，比较行标签，比较列标签）；
		dataset.addValue(100, "广州", "苹果");
		dataset.addValue(200, "北京", "梨子");
		dataset.addValue(200, "上海", "梨子");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(300, "上海", "葡萄");
		dataset.addValue(300, "广州", "葡萄");
		dataset.addValue(400, "北京", "香蕉");
		dataset.addValue(400, "上海", "香蕉");
		dataset.addValue(400, "广州", "香蕉");
		dataset.addValue(500, "北京", "荔枝");
		dataset.addValue(500, "上海", "荔枝");
		dataset.addValue(500, "广州", "荔枝");
		return dataset;
	}
	 private static DefaultPieDataset getPieDataSet() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("苹果", 100);
	        dataset.setValue("梨子", 200);
	        dataset.setValue("葡萄", 300);
	        dataset.setValue("香蕉", 400);
	        dataset.setValue("荔枝", 500);
	        return dataset;
	    }

	public static void setCategoryChart(JFreeChart chart) {
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

	}

	public static void setPieChart(JFreeChart chart) {
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelFont(new Font("黑体", Font.PLAIN, 20));
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("黑体", Font.PLAIN, 20));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

	}
}
