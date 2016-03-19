package Guava;

import java.util.Map;
import java.util.Set;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * 
 * 描述:1.双键的Map--Table--rowKey+columnKey+value
 *     2.方法:
 *       所有行数据:cellSet();
 *       所有的第一个key值:rowKeySet();
 *       所有的第二个key值:columnKeySet();
 *       所有的值:values();
 *       第一个值对应的第二个值:rowMap()+get(第一个值)
 *                         row(第一个值)，获取第二个key+value的map
 *       第二个值对应的第一个值:columnMap()+get(第二个值)
 *                         colomn(第二个值)，获取第一个key+value的map  
 * @author gt
 * @created 2016年3月18日 上午10:23:14
 * @since
 */
public class TableStudy {
     public static void main(String[] args) {
		Table<String, String, Double> gradeTable = HashBasedTable.create();
	    gradeTable.put("gutao", "Chinese", 90.2);
	    gradeTable.put("gutao", "Math", 96.2);
	    gradeTable.put("nibei", "Chinese", 90.2);
	    gradeTable.put("nibei", "sport", 80.2);
	    gradeTable.put("luoming", "English", 60.2);
	    Set<Cell<String, String, Double>> cells = gradeTable.cellSet();
	    for (Cell<String, String, Double> cell : cells) {
			System.out.println(cell.getRowKey()+"-->"+cell.getColumnKey()+"-->"+cell.getValue());
		}
	    System.out.println("==========================成绩表=============================");
	    //通过获取列元素，来定义表的第一行，就是表的列元素
	    System.out.print("学生"+"\t");
	    Set<String> columnkeySet = gradeTable.columnKeySet();
	    for (String string : columnkeySet) {
			System.out.print(string+"\t\t");
		}
	    System.out.println();
	    //遍历学生，并在每一个学生中遍历他的各科成绩
	    Set<String> rowkeySet = gradeTable.rowKeySet();
	    for (String string : rowkeySet) {
			  System.out.print(string+"\t");
			  Map<String, Double> scoresMap = gradeTable.row(string);
			                                  
			  for (String column : columnkeySet) {
					System.out.print(scoresMap.get(column)+"\t\t");
					//获取到所有的rowMap,
					//Open Declaration Map<String, Map<String, Double>> com.google.common.collect.Table.rowMap()
					//这里会议第一个key为新的map的key，另外一个key和value为新的map元素
					//System.out.print(gradeTable.columnMap().get(string)+"\t\t");
			  }
			  System.out.println();
		}
	    
     }
}
