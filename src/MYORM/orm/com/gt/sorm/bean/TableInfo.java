package MYORM.orm.com.gt.sorm.bean;

import java.util.Map;

public class TableInfo {
	// 表名
	private String tname;
	// 所有字段信息
	private Map<String, ColumnInfo> columns;
	// 唯一主键
	private ColumnInfo onlyPriKey;

	public TableInfo(String tname, Map<String, ColumnInfo> columns,
			ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo() {
	}

}
