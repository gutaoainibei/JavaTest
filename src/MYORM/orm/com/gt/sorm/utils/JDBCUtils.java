package MYORM.orm.com.gt.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * 描述：封装jdbc连接，操作
 * @author gt
 * @created 2016年8月30日 下午10:56:55
 * @since
 */
public class JDBCUtils {
      public static void handleParamers(PreparedStatement ptmt , Object[] params){
    	  if(params != null){
    		  for (int i = 0; i <= params.length-1; i++) {
				try {
					ptmt.setObject(1+i, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
    	  }
      }
}
