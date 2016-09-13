package MYORM.orm.com.gt.sorm.bean;

import java.util.List;
import java.util.Map;


public class TableInfo {
	// 表名
	private String tname;
	// 所有字段信息
	private Map<String, ColumnInfo> columns;
	// 唯一主键
	private ColumnInfo onlyPriKey;

	private List<ColumnInfo> priKeys;//联合主键
	public TableInfo(String tname, Map<String, ColumnInfo> columns,
			ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
    
	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}

	public TableInfo() {
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	@Override
	public String toString() {
		return "[tname=" + tname + ", columns=" + columns
				+ ", onlyPriKey=" + onlyPriKey + ", priKeys=" + priKeys + "]";
	}
    
}
