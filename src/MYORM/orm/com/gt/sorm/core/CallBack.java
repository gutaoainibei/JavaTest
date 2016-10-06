package MYORM.orm.com.gt.sorm.core;

import java.sql.ResultSet;

public interface CallBack {
    public Object doExecute(Class clazz, ResultSet rs);
}
