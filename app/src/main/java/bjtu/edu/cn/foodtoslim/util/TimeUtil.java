package bjtu.edu.cn.foodtoslim.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	
	
	    private static String mYear;  
	    private static String mMonth;  
	    private static String mDay;  
	    private static String mWay;  
	      
	    public static String getDate(int day){  //获得距今天第day天的日期

	    	Calendar cal = Calendar.getInstance();

	    	cal.setTime(new Date());
	    	cal.add(Calendar.DAY_OF_MONTH, day);  //第2天，第x天，照加。如果是负数，表示前n天。

	        mYear = String.valueOf(cal.get(Calendar.YEAR)); // 获取当前年份  
	        mMonth = String.valueOf(cal.get(Calendar.MONTH) + 1);// 获取当前月份  
	        mDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码  
	     
	        return  mMonth + "月" + mDay+"日";  
	    }  
	    
	    public static String getWay(int day)//获得距今天第day天的时星期几
	    {
	    	
	    	Calendar cal = Calendar.getInstance();

	    	cal.setTime(new Date());
	    	cal.add(Calendar.DAY_OF_MONTH, day);  //第2天，第x天，照加。如果是负数，表示前n天。

	    	
	    	
	    	   mWay = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));  
		        if("1".equals(mWay)){  
		            mWay ="天";  
		        }else if("2".equals(mWay)){  
		            mWay ="一";  
		        }else if("3".equals(mWay)){  
		            mWay ="二";  
		        }else if("4".equals(mWay)){  
		            mWay ="三";  
		        }else if("5".equals(mWay)){  
		            mWay ="四";  
		        }else if("6".equals(mWay)){  
		            mWay ="五";  
		        }else if("7".equals(mWay)){  
		            mWay ="六";  
		        }  
	    	
	    	return  "星期"+mWay;
	    }

}
