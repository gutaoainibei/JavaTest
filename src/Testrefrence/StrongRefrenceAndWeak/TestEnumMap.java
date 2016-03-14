package Testrefrence.StrongRefrenceAndWeak;

import java.util.EnumMap;
/**
 * 
 * 描述：测试EnumMap,它的key只能是枚举的值
 * @author gt
 * @created 2016年3月14日 下午4:43:12
 * @since
 */
public class TestEnumMap {
   public static void main(String[] args) {
	EnumMap<Season, String> enumMap = new EnumMap<Season, String>(Season.class);
	enumMap.put(Season.SPRING, "春天");
	enumMap.put(Season.SUMMER, "夏天");
	enumMap.put(Season.AUTUMN, "秋天");
	enumMap.put(Season.WINTER, "冬天");
	System.out.println(enumMap.size());
	}
}
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}