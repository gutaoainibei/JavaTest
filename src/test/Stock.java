package test;

public class Stock {
	  private short   serno;                    //股票序号码
      
	    private String  code;                     //股票代码
	                                               
	    private String  name;                     //股票名称
	                                               
	    private String  pyname;                   //拼音名称
	                                               
	    private int     stktype   = -1;           //股票类型
	                                               
	    private int     volbase;                  //量比基量
	                                               
	    private float   volrate;                  //量比
	                                               
	    private float   yesterday;                //昨日收盘价
	                                               
	    private float   open;                     //今日开盘价
	                                               
	    private float   high;                     //最高价
	                                               
	    private float   low;                      //最低价
	                                               
	    private float   now;                      //现价
	                                               
	    //    private float   buy;                      //叫买价
	    //                                               
	    //    private float   sell;                     //叫卖价
	    
	    private float   buyprice1;                //买一
	                                               
	    private float   buyprice2;                //买二
	                                               
	    private float   buyprice3;                //买三
	                                               
	    private float   buyprice4;                //买四
	                                               
	    private float   buyprice5;                //买五
	                                               
	    private float   buyvol1;                  //买盘量一
	                                               
	    private float   buyvol2;                  //买盘量二
	                                               
	    private float   buyvol3;                  //买盘量三
	                                               
	    private float   buyvol4;                  //买盘量四
	                                               
	    private float   buyvol5;                  //买盘量五
	                                               
	    private float   sellprice1;               //卖一
	                                               
	    private float   sellprice2;               //卖二
	                                               
	    private float   sellprice3;               //卖三
	                                               
	    private float   sellprice4;               //卖四
	                                               
	    private float   sellprice5;               //卖五
	                                               
	    private float   sellvol1;                 //卖盘量一
	                                               
	    private float   sellvol2;                 //卖盘量二
	                                               
	    private float   sellvol3;                 //卖盘量三
	                                               
	    private float   sellvol4;                 //卖盘量四
	                                               
	    private float   sellvol5;                 //卖盘量五
	                                               
	    private float   volume;                   //总成交量
	                                               
	    private float   amount;                   //总成交金额
	                                               
	    private float   thedeal;                  //现手
	                                               
	    private float   inside;                   //卖盘
	                                               
	    private float   outside;                  //买盘
	                                               
	    private float   thechange;                //笔升跌
	                                               
	    private short   dealno;                   //成交明细数量
	                                               
	    private float   min5change;               //5分钟涨跌幅
	                                               
	    private int     curdate;                  //当前日期
	                                               
	    private short   minutes;                  //分钟数
	                                               
	    private String  market;                   //市场(大写SZ or SH)
	                                               
	    private float   up        = 0.0F;         //涨幅
	                                               
	    private float   uppercent = 0.0F;         //涨幅百分比
	                                               
	    //新增加排序字段
	    private float   flux      = 0.0F;         //振幅
	                                               
	    private int     WC;                       //委差
	                                               
	    private float   WB        = 0.0F;         //委比
	                                               
	    //PGR, MGJZ , ZSZ , HSL , LTSZ                                          
	    
	    //    private float  HSL       = 0.0F; //换手率
	    //    
	    //    private float  ZSZ       = 0.0F; //总市值
	    //    
	    //    private float  LTSZ      = 0.0F; //流通市值
	    //    
	    //    private float  MGJZ      = 0.0F; //每股净资
	    
	    private float limitUp = 0.0F;          //涨停价
	    
	    private float limitDown = 0.0F;        //跌停价
	    
	    private String issuspend = "2";        //是否停牌（1，停牌；2非停牌）
	    
	    public String getIssuspend() {
			return issuspend;
		}

		public void setIssuspend(String issuspend) {
			this.issuspend = issuspend;
		}

		public void setLimitUp(float limitUp)
	    {
	        this.limitUp = limitUp;
	    }
	    
	    public float getLimitUp()
	    {
	        return this.limitUp;
	    }
	    
	    public void setLimitDown(float limitDown)
	    {
	        this.limitDown = limitDown;
	    }
	    
	    public float getLimitDown()
	    {
	        return this.limitDown;
	    }
	    
	    public short getSerno()
	    {
	        return serno;
	    }
	    public void setSerno(short serno)
	    {
	        this.serno = serno;
	    }
	    
	    public String getCode()
	    {
	        return code;
	    }
	    
	    public void setCode(String code)
	    {
	        this.code = code;
	    }
	    
	    public String getName()
	    {
	        return name;
	    }
	    
	    public void setName(String name)
	    {
	        this.name = name;
	    }
	    
	    public String getPyname()
	    {
	        return pyname;
	    }
	    
	    public void setPyname(String pyname)
	    {
	        this.pyname = pyname;
	    }
	    
	    public int getStktype()
	    {
	        return stktype;
	    }
	    
	    public void setStktype(int stktype)
	    {
	        this.stktype = stktype;
	    }
	    
	    public int getVolbase()
	    {
	        return volbase;
	    }
	    
	    public void setVolbase(int volbase)
	    {
	        this.volbase = volbase;
	    }
	    
	    public float getVolrate()
	    {
	        return volrate;
	    }
	    
	    public void setVolrate(float volrate)
	    {
	        this.volrate = volrate;
	    }
	    
	    public float getYesterday()
	    {
	        return yesterday;
	    }
	    
	    public void setYesterday(float yesterday)
	    {
	        this.yesterday = yesterday;
	    }
	    
	    public float getOpen()
	    {
	        return open;
	    }
	    
	    public void setOpen(float open)
	    {
	        this.open = open;
	    }
	    
	    public float getHigh()
	    {
	        return high;
	    }
	    
	    public void setHigh(float high)
	    {
	        this.high = high;
	    }
	    
	    public float getLow()
	    {
	        return low;
	    }
	    
	    public void setLow(float low)
	    {
	        this.low = low;
	    }
	    
	    public float getNow()
	    {
	        return now;
	    }
	    
	    public void setNow(float now)
	    {
	        this.now = now;
	    }
	    
	    public float getBuyprice1()
	    {
	        return buyprice1;
	    }
	    
	    public void setBuyprice1(float buyprice1)
	    {
	        this.buyprice1 = buyprice1;
	    }
	    
	    public float getBuyprice2()
	    {
	        return buyprice2;
	    }
	    
	    public void setBuyprice2(float buyprice2)
	    {
	        this.buyprice2 = buyprice2;
	    }
	    
	    public float getBuyprice3()
	    {
	        return buyprice3;
	    }
	    
	    public void setBuyprice3(float buyprice3)
	    {
	        this.buyprice3 = buyprice3;
	    }
	    
	    public float getBuyprice4()
	    {
	        return buyprice4;
	    }
	    
	    public void setBuyprice4(float buyprice4)
	    {
	        this.buyprice4 = buyprice4;
	    }
	    
	    public float getBuyprice5()
	    {
	        return buyprice5;
	    }
	    
	    public void setBuyprice5(float buyprice5)
	    {
	        this.buyprice5 = buyprice5;
	    }
	    
	    public float getBuyvol1()
	    {
	        return buyvol1;
	    }
	    
	    public void setBuyvol1(float buyvol1)
	    {
	        this.buyvol1 = buyvol1;
	    }
	    
	    public float getBuyvol2()
	    {
	        return buyvol2;
	    }
	    
	    public void setBuyvol2(float buyvol2)
	    {
	        this.buyvol2 = buyvol2;
	    }
	    
	    public float getBuyvol3()
	    {
	        return buyvol3;
	    }
	    
	    public void setBuyvol3(float buyvol3)
	    {
	        this.buyvol3 = buyvol3;
	    }
	    
	    public float getBuyvol4()
	    {
	        return buyvol4;
	    }
	    
	    public void setBuyvol4(float buyvol4)
	    {
	        this.buyvol4 = buyvol4;
	    }
	    
	    public float getBuyvol5()
	    {
	        return buyvol5;
	    }
	    
	    public void setBuyvol5(float buyvol5)
	    {
	        this.buyvol5 = buyvol5;
	    }
	    
	    public float getSellprice1()
	    {
	        return sellprice1;
	    }
	    
	    public void setSellprice1(float sellprice1)
	    {
	        this.sellprice1 = sellprice1;
	    }
	    
	    public float getSellprice2()
	    {
	        return sellprice2;
	    }
	    
	    public void setSellprice2(float sellprice2)
	    {
	        this.sellprice2 = sellprice2;
	    }
	    
	    public float getSellprice3()
	    {
	        return sellprice3;
	    }
	    
	    public void setSellprice3(float sellprice3)
	    {
	        this.sellprice3 = sellprice3;
	    }
	    
	    public float getSellprice4()
	    {
	        return sellprice4;
	    }
	    
	    public void setSellprice4(float sellprice4)
	    {
	        this.sellprice4 = sellprice4;
	    }
	    
	    public float getSellprice5()
	    {
	        return sellprice5;
	    }
	    
	    public void setSellprice5(float sellprice5)
	    {
	        this.sellprice5 = sellprice5;
	    }
	    
	    public float getSellvol1()
	    {
	        return sellvol1;
	    }
	    
	    public void setSellvol1(float sellvol1)
	    {
	        this.sellvol1 = sellvol1;
	    }
	    
	    public float getSellvol2()
	    {
	        return sellvol2;
	    }
	    
	    public void setSellvol2(float sellvol2)
	    {
	        this.sellvol2 = sellvol2;
	    }
	    
	    public float getSellvol3()
	    {
	        return sellvol3;
	    }
	    
	    public void setSellvol3(float sellvol3)
	    {
	        this.sellvol3 = sellvol3;
	    }
	    
	    public float getSellvol4()
	    {
	        return sellvol4;
	    }
	    
	    public void setSellvol4(float sellvol4)
	    {
	        this.sellvol4 = sellvol4;
	    }
	    
	    public float getSellvol5()
	    {
	        return sellvol5;
	    }
	    
	    public void setSellvol5(float sellvol5)
	    {
	        this.sellvol5 = sellvol5;
	    }
	    
	    public float getVolume()
	    {
	        return volume;
	    }
	    
	    public void setVolume(float volume)
	    {
	        this.volume = volume;
	    }
	    
	    public float getAmount()
	    {
	        return amount;
	    }
	    
	    public void setAmount(float amount)
	    {
	        this.amount = amount;
	    }
	    
	    public float getThedeal()
	    {
	        return thedeal;
	    }
	    
	    public void setThedeal(float thedeal)
	    {
	        this.thedeal = thedeal;
	    }
	    
	    public float getInside()
	    {
	        return inside;
	    }
	    
	    public void setInside(float inside)
	    {
	        this.inside = inside;
	    }
	    
	    public float getOutside()
	    {
	        return outside;
	    }
	    
	    public void setOutside(float outside)
	    {
	        this.outside = outside;
	    }
	    
	    public float getThechange()
	    {
	        return thechange;
	    }
	    
	    public void setThechange(float thechange)
	    {
	        this.thechange = thechange;
	    }
	    
	    public short getDealno()
	    {
	        return dealno;
	    }
	    
	    public void setDealno(short dealno)
	    {
	        this.dealno = dealno;
	    }
	    
	    public float getMin5change()
	    {
	        return min5change;
	    }
	    
	    public void setMin5change(float min5change)
	    {
	        this.min5change = min5change;
	    }
	    
	    public int getCurdate()
	    {
	        return curdate;
	    }
	    
	    public void setCurdate(int curdate)
	    {
	        this.curdate = curdate;
	    }
	    
	    public short getMinutes()
	    {
	        return minutes;
	    }
	    
	    public void setMinutes(short minutes)
	    {
	        this.minutes = minutes;
	    }
	    
	    public String getMarket()
	    {
	        return market;
	    }
	    
	    public void setMarket(String market)
	    {
	        this.market = market;
	    }
	    
	    public float getUp()
	    {
	        return up;
	    }
	    
	    public void setUp(float up)
	    {
	        this.up = up;
	    }
	    
	    public float getUppercent()
	    {
	        return uppercent;
	    }
	    
	    public void setUppercent(float uppercent)
	    {
	        this.uppercent = uppercent;
	    }
	    
	    public float getFlux()
	    {
	        return flux;
	    }
	    
	    public void setFlux(float flux)
	    {
	        this.flux = flux;
	    }
	    
	    public int getWC()
	    {
	        return WC;
	    }
	    
	    public void setWC(int wC)
	    {
	        WC = wC;
	    }
	    
	    public float getWB()
	    {
	        return WB;
	    }
	    
	    public void setWB(float wB)
	    {
	        WB = wB;
	    }
	   
}
