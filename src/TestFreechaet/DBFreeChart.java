package TestFreechaet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.mysql.jdbc.PreparedStatement;

public class DBFreeChart {
    public static void main(String[] args) {
    	try {
    		DefaultPieDataset dataPieset = new DefaultPieDataset();
    		DefaultCategoryDataset dataCategoryset = new DefaultCategoryDataset();
    		PreparedStatement preparedStatement = (PreparedStatement) DB.getConn().prepareStatement("select * from product");
    		PreparedStatement preparedStatement1 = (PreparedStatement) DB.getConn().prepareStatement("select name,sum(counts) from product group by name");
    		ResultSet rs = preparedStatement.executeQuery();
    		ResultSet rs1 = preparedStatement1.executeQuery();
            while (rs.next()) {
				dataCategoryset.addValue(rs.getInt(3), rs.getString(2), rs.getString(4));
            }
            while (rs1.next()) {
				dataPieset.setValue(rs1.getString(1), rs1.getInt(2));
            }
            TestfreeChart.createPie3D(dataPieset);
            TestfreeChart.createChart3D(dataCategoryset);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
