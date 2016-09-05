//package test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
//import com.thinkive.market.client.HQClient;
//
//public class HQHelper
//{
//    private static Logger logger   = Logger.getLogger(HQClient.class);
//    
//    //行情服务器数组    
//    private String[]      svrArray = new String[0];
//    
//    private static String SERVER   = null;
//    
//    public HQHelper()
//    {
//        String hqSvrList = "http://121.15.137.175:8081|";
//        svrArray = hqSvrList.split("\\|");
//    }
//    
//    /**
//     * 描述：获取股票列表行情信息
//     * @author 黎兵
//     * @created 2016年2月22日 上午10:24:53
//     * @since 
//     * @return
//     */
//    public List<Stock> getFunc21007Data()
//    {
//        List<Stock> resultList = null;
//        try
//        {
//            if ( svrArray.length == 0 ) //没有配置服务器
//            {
//                return null;
//            }
//            if ( SERVER != null )
//            {
//                resultList = addressInvokeResult(SERVER);
//            }
//            else
//            {
//                resultList = selectAddressReturn();
//            }
//        }
//        catch (Exception e)
//        {
//            logger.info("", e);
//        }
//        return resultList;
//    }
//    
//    /**
//     * 描述：获取股票5档行情信息
//     * @author 黎兵
//     * @created 2016年2月23日 上午10:18:22
//     * @since 
//     * @param stockKey
//     * @return
//     */
//    public Map getFunc20003Data(String stockKey)
//    {
//        Map<String, Object> resultData = null;
//        try
//        {
//            if ( svrArray.length == 0 ) //没有配置服务器
//            {
//                return null;
//            }
//            if ( SERVER != null )
//            {
//                resultData = invokeResult20003(SERVER,stockKey);
//            }
//            else
//            {
//                resultData = selectAddressReturn20003(stockKey);
//            }
//        }
//        catch (Exception e)
//        {
//            logger.info("", e);
//        }
//        return resultData;
//    }
//    
//    /**
//     * 描述：根据"市场:代码"返回五档行情信息
//     * @author 黎兵
//     * @created 2016年2月23日 上午10:28:27
//     * @since 
//     * @param server
//     * @param stockKey
//     * @return
//     * @throws Exception
//     */
//    private Map invokeResult20003(String server,String stockKey) throws Exception
//    {
//        HQClient.setHost(server);
//        Map map = new HashMap();
//        map.put("version", 1);
//        map.put("stock_list", stockKey);
//        List lists = HQClient.invoke(20003, map);
//        if ( lists != null )
//        {
//            return parseFunc20003Result(lists);
//        }
//        
//        return null;
//    }
//    
//    private Map<String, Object> selectAddressReturn20003(String stockKey) throws Exception
//    {
//        for (int i = 0; i < svrArray.length; i++)
//        {
//            String svrAddress = svrArray[i];
//            if ( svrAddress.equals(SERVER) )
//            {
//                continue;
//            }
//            Map<String, Object> resultData = invokeResult20003(svrAddress,stockKey);
//            if ( resultData != null )
//            {
//                SERVER = svrAddress;
//                return resultData;
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * 描述：格式化股票5档行情信息
//     * @author 黎兵
//     * @created 2016年2月23日 上午10:09:16
//     * @since 
//     * @param lists
//     * @return
//     */
//    private Map parseFunc20003Result(List lists)
//    {
//        Map data = new HashMap<String, Object>();
//        for (int i = 0; i < lists.size(); i++)
//        {
//            List list = (List) lists.get(i);
//            data.put("buyprice1", list.get(16).toString());
//            data.put("buyprice2", list.get(17).toString());
//            data.put("buyprice3", list.get(18).toString());
//            data.put("buyprice4", list.get(19).toString());
//            data.put("buyprice5", list.get(20).toString());
//            data.put("buyvol1", list.get(21).toString());
//            data.put("buyvol2", list.get(22).toString());
//            data.put("buyvol3", list.get(23).toString());
//            data.put("buyvol4", list.get(24).toString());
//            data.put("buyvol5", list.get(25).toString());
//            data.put("sellprice1", list.get(10).toString());
//            data.put("sellprice2", list.get(9).toString());
//            data.put("sellprice3", list.get(8).toString());
//            data.put("sellprice4", list.get(7).toString());
//            data.put("sellprice5", list.get(6).toString());
//            data.put("sellvol1", list.get(15).toString());
//            data.put("sellvol2", list.get(14).toString());
//            data.put("sellvol3", list.get(13).toString());
//            data.put("sellvol4", list.get(12).toString());
//            data.put("sellvol5", list.get(11).toString());
//        }
//        return data;
//    }
//    
//    /**
//     * 描述：根据行情地址返回股票信息
//     * @author 黎兵
//     * @created 2016年2月22日 下午3:51:05
//     * @since 
//     * @param address
//     * @return
//     * @throws Exception
//     */
//    private List<Stock> addressInvokeResult(String address) throws Exception 
//    {
//        HQClient.setHost(address);
//        Map map = new HashMap();
//        map.put("version", 1);//版本号
//        map.put("type", "0:2:4:5:9:12:13:18:19:20");//0:9:2:5:13:18:4:12
//        map.put("q", "");
//        map.put("count", "1000000");
//        map.put("field", "24:22:23:21:12:9:10:11:2:25:1:3:45:46:28:48");
//        List results = HQClient.invoke(21007, map);
//        
//        if(results != null)
//        {
//        	logger.trace("股票行情信息："+results.toString());
//            return parseFunc21007Result(results);
//        }
//        return null;
//    }
//    
//    /**
//     * 描述：循环行情服务器数组返回股票信息
//     * @author 黎兵
//     * @created 2016年2月22日 下午3:51:41
//     * @since 
//     * @return
//     * @throws Exception
//     */
//    private List<Stock> selectAddressReturn() throws Exception
//    {
//        for (int i = 0; i < svrArray.length; i++)
//        {
//            String svrAddress = svrArray[i];
//            if ( svrAddress.equals(SERVER) )
//            {
//                continue;
//            }
//            List<Stock> stockList = addressInvokeResult(svrAddress);
//            if ( stockList != null )
//            {
//                SERVER = svrAddress;
//                return stockList;
//            }
//        }
//        return null;
//    }
//    
//    /**
//     * 描述：格式化获取到的股票信息
//     * @author 黎兵
//     * @created 2016年2月22日 下午3:55:33
//     * @since 
//     * @param lists
//     * @return
//     * @throws Exception
//     */
//    private List parseFunc21007Result(List lists) throws Exception
//    {
//        List<Stock> dataList = new ArrayList<Stock>();
//        for (int i = 0; i < lists.size(); i++)
//        {
//            List list = (List)lists.get(i);
//            Stock stock = new Stock();
//            stock.setSerno(Short.parseShort((i+1)+""));
//            stock.setCode(list.get(0).toString());
//            stock.setName(list.get(1).toString());
//            stock.setMarket(list.get(2).toString());
//            stock.setStktype(Integer.parseInt(list.get(3).toString()));
//            stock.setYesterday(Float.parseFloat((list.get(4).toString())));
//            stock.setOpen(Float.parseFloat((list.get(5).toString())));
//            stock.setHigh(Float.parseFloat((list.get(6).toString())));
//            stock.setLow(Float.parseFloat((list.get(7).toString())));
//            stock.setNow(Float.parseFloat((list.get(8).toString())));
//            stock.setThedeal(Float.parseFloat((list.get(9).toString())));
//            stock.setUppercent(Float.parseFloat((list.get(10).toString())));
//            stock.setUp(Float.parseFloat((list.get(11).toString())));
//            stock.setLimitUp(Float.parseFloat(list.get(12).toString()));
//            stock.setLimitDown(Float.parseFloat(list.get(13).toString()));
//            stock.setPyname(list.get(14).toString());
//            stock.setIssuspend(list.get(15).toString());
//            dataList.add(stock);
//        }
//        return dataList;
//    }
//    
//    public List<Map<String, Object>> queryStockInfo(String stockKey)
//    {
//      //获取行情股票列表
//        HQClient.setHost("http://121.15.137.175:8081");
//        Map pramMap=new HashMap();
//        pramMap.put("funcno", "20000");
//        pramMap.put("version", "1");
//        pramMap.put("stock_list", stockKey);
//        pramMap.put("field", "22:24:2:10:11:9:12:14:6:23:21:3:1");
//        List stocklist=null;
//        List<Map<String, Object>> resultlist=new ArrayList<Map<String, Object>>();
//        try
//        {
//            stocklist = HQClient.invoke(20000, pramMap);
//            if(stocklist!=null&&stocklist.size()>0){
//                for(Iterator it=stocklist.iterator(); it.hasNext();){
//                    List st=(List)it.next();
//                    Map<String, Object> item=new HashMap<String, Object>();
//                    item.put("name", st.get(0));
//                    item.put("code", st.get(1));
//                    item.put("now", st.get(2));
//                    item.put("high", st.get(3));
//                    item.put("low", st.get(4));
//                    item.put("open", st.get(5));
//                    item.put("yesterday", st.get(6));
//                    item.put("amount", st.get(7));
//                    item.put("volume", st.get(8));
//                    item.put("market", st.get(9));
//                    item.put("stktype", st.get(10));
//                    item.put("up", Double.parseDouble(st.get(11).toString()));
//                    item.put("uppercent", st.get(12).toString());
//                    resultlist.add(item);
//                }
//            }    
//        }
//        catch (IOException e)
//        {
//            logger.error("", e);
//            return null;
//        }
//        return resultlist;
//    }
//    
//    /**
//     * 描述：查询行情状态（转码机初始化时间、转码时间、股票数量等）
//     * @author 黎兵
//     * @created 2016年4月25日 下午2:46:15
//     * @since 
//     * @return
//     */
//    public Map<String, Object> getFunc29999Data()
//    {
//    	Map<String, Object> result = new HashMap<String, Object>();
//        for (int i = 0; i < svrArray.length; i++)
//        {
//            String svrAddress = svrArray[i];
//            if(svrAddress == null || svrAddress.trim().equals(""))
//            {
//                continue;
//            }
//            HQClient.setHost(svrAddress);
//            Map pramMap=new HashMap();
//            pramMap.put("funcno", "29999");
//            pramMap.put("version", "1");
//            try
//            {
//                List resultList = HQClient.invoke(29999, pramMap);
//                if(resultList != null && resultList.size() > 0)
//                {
//                    for(Iterator iter = resultList.iterator(); iter.hasNext();)
//                    {
//                        List list = (List)iter.next();
//                        result.put("StockNum", list.get(0));//股票数量
//                        result.put("HqInitDate", list.get(1));//行情日期（转码机初始化日期）
//                        result.put("DBFTime", list.get(2));//转码机时间（行情源dbf文件）
//                        result.put("HqServerTime", list.get(3));//行情服务器机器时间
//                        result.put("HKHQTime", list.get(4));//港股通行情源时间
//                    }
//                }
//            }
//            catch (IOException e)
//            {
//               logger.error("",e);
//               return null;
//            }
//            
//        }
//        return result;
//    }
//    
//    public static void main(String[] args)
//    {
//    	HQHelper hq = new HQHelper();
////        hq.getFunc29999Data();
//        System.out.println(hq.getFunc21007Data().size());
////    	System.err.println(hq.svrArray[0]);
////        hq.getFunc20003Data("SZ:000001");
//    }
//}
//
