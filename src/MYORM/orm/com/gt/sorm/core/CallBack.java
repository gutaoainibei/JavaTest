package MYORM.orm.com.gt.sorm.core;

import java.sql.ResultSet;
/**
* @ClassName: CallBack 
* @Description: 查询数据库回调接口 
* @author gutao 
* @date 2016年10月8日 下午12:39:46 
*
 */
public interface CallBack {
    public Object doExecute(Class clazz, ResultSet rs);
}
