package com.yz.jcs.util;




import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class DateUtil extends Date{
	
	public static String DateToString(Date date, String pattern) {
		String strDateTime = null;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		strDateTime = date == null ? null : formater.format(date);
		return strDateTime;
	}
	
	
	public static String monthToString(Date date) {
		String _pattern = "yyyyMM";
		return date == null ? null : DateToString(date, _pattern);
	}
    
	
	public static String DateToString(Date date) {
		String _pattern = "yyyy-MM-dd";
		return date == null ? null : DateToString(date, _pattern);
	}

	
	public static String DateTimeToString(Date date) {
		String _pattern = "yyyy-MM-dd HH:mm:ss";
		return date == null ? null : DateToString(date, _pattern);
	}
	
	
	public static String DateStampToString(Date date) {
		String _pattern = "yyyy-MM-dd HH:mm:ss:SSS";
		return date == null ? null : DateToString(date, _pattern);
	}
	
	
	public static String DateStampToStringNoSp(Date date) {
		String _pattern = "yyyyMMddHHmmssSSS";
		return date == null ? null : DateToString(date, _pattern);
	}

	public static String DateStampToStringMs(Date date) {
		String _pattern = "yyyyMMddHHmmss";
		return date == null ? null : DateToString(date, _pattern);
	}
	
	
	public static String DateStampToStringYY(Date date) {
		String _pattern = "yyMMddHHmmss";
		return date == null ? null : DateToString(date, _pattern);
	}
	
	
	public static String DateStampToStringyyyyMMdd(Date date) {
		String _pattern = "yyyyMMdd";
		return date == null ? null : DateToString(date, _pattern);
	}
	
    public static String DateStampToStringyyyyMMdd(int timestamp) {
        String _pattern = "yyyyMMdd";
        return DateToString(new Date(timestamp * 1000l), _pattern);
    }
	
    public static String DateStampToStringyyyyMM(int timestamp) {
        String _pattern = "yyyyMM";
        return DateToString(new Date(timestamp * 1000l), _pattern);
    }
	
	public static String DateStampToStringHHmmss(Date date) {
		String _pattern = "HHmmss";
		return date == null ? null : DateToString(date, _pattern);
	}
	
	public static Date StringToDate(String str, String pattern) {
		Date dateTime = null;
		try {
			if (str != null && !str.equals("")) {
				SimpleDateFormat formater = new SimpleDateFormat(pattern);
				dateTime = formater.parse(str);
			}
		} catch (Exception ex) {
		}
		return dateTime;
	}

	
	public static Date StringToDate(String str) {
		String _pattern = "yyyy-MM-dd";
		return StringToDate(str, _pattern);
	}
    
	
	public static Date StringToDateTime(String str) {
		String _pattern = "yyyy-MM-dd HH:mm:ss";
		return StringToDate(str, _pattern);
	}
   
	
	public static Timestamp StringToDateHMS(String str) {
		Timestamp time = null;
		time = Timestamp.valueOf(str);
		return time;
	}

	
	public static Date YmdToDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	
	public static String communityDateToString(Date date) {
		SimpleDateFormat formater = new SimpleDateFormat("MM/dd HH:mm:ss");
		String strDateTime = date == null ? null : formater.format(date);
		return strDateTime;
	}
    /**
     * 当天最大时间戳
     * @return 10位时间戳
     */
    public static int getMaxDateOfDay(int i) {
        return getMaxDateOfDay((int)(System.currentTimeMillis() / 1000l), i);
    }    	
	/**
     * 当天最大时间戳
     * @param date 20151225   
     * @return 10位时间戳
     */
    public static int getMaxDateOfDay(String date) {
      return getMaxDateOfDay(date,0);
    }
	/**
	 * 当天最大时间戳
	 * @param date 20151225    i:日期加减值 em:-1  向前推一天
	 * @return 10位时间戳
	 */
    public static int getMaxDateOfDay(String date,int i) {
        if (date == null ||date.equals("")||date.length()!=8) {
            return 0;
        } else {
            Date cdate = convertStrToDate(date, "yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cdate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+i);
            calendar.set(11, calendar.getActualMaximum(11));
            calendar.set(12, calendar.getActualMaximum(12));
            calendar.set(13, calendar.getActualMaximum(13));
            calendar.set(14, calendar.getActualMaximum(14));
            int times = (int) (calendar.getTimeInMillis()/1000);
            return times;
        }
    }
    /**
     * 当天最大时间戳
     * @param date 10位时间戳  i:日期加减值 em:-1  向前推一天
     * @return 10位时间戳
     */
    public static int getMaxDateOfDay(int date, int i) {
        if (date <= 0) {
            return 0;
        } else {
            Date cdate = new Date(date * 1000l);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cdate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+i);
            calendar.set(11, calendar.getActualMaximum(11));
            calendar.set(12, calendar.getActualMaximum(12));
            calendar.set(13, calendar.getActualMaximum(13));
            calendar.set(14, calendar.getActualMaximum(14));
            int times = (int) (calendar.getTimeInMillis()/1000);
            return times;
        }
    }    
    /**
     * 
     * 日期加减运算   i>0 加  i<0 减
     * @param date yyyyMMdd
     * @param i 
     * @return  yyyyMMdd
     */
    public static String getNextDateStr(String date,int i){
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
        Date cdate = convertStrToDate(date, "yyyyMMdd");
        return df.format(new Date(cdate.getTime()+i * 24 * 60 * 60 * 1000));
    }
    
    /**
     * 
     * 日期加减运算   i>0 加  i<0 减
     * @param date yyyyMMdd
     * @param i 
     * @return  yyyyMMdd
     */
    public static String getNextDateStr(String date,int i,String format){
        SimpleDateFormat df=new SimpleDateFormat(format);
        Date cdate = convertStrToDate(date, format);
        return df.format(new Date(cdate.getTime()+i * 24 * 60 * 60 * 1000));
    }
    /**
     * 当天最小时间戳
     * @param date 20151225
     * @return 10位时间戳
     */
    public static int getMinDateOfDay(String date) {
     return getMinDateOfDay(date,0);
    }
    
    /**
     * 日期加减 天
     * 
     * @param date yyyyMMdd
     * @param i 大于0 加i天  小于0  减i天
     * @return  20151231
     */
    public static String getDayDiffStr(String date,int i){
     	  String _pattern = "yyyyMMdd";
    	  if (date == null ||date.equals("")||date.length()!=8) {
              return null;
          } else {
              Date cdate = convertStrToDate(date, "yyyyMMdd");
              Calendar calendar = Calendar.getInstance();
              calendar.setTime(cdate);
              calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+i);
              calendar.set(11, calendar.getActualMinimum(11));
              calendar.set(12, calendar.getActualMinimum(12));
              calendar.set(13, calendar.getActualMinimum(13));
              calendar.set(14, calendar.getActualMinimum(14));
              return DateToString(new Date(calendar.getTimeInMillis()),_pattern);
          }
    }
    
    /**
     * 当天最小时间戳
     * @param date 20151225  i:日期加减值 em:-1  向前推一天
     * @return 10位时间戳
     */
    public static int getMinDateOfDay(String date,int i) {
        if (date == null ||date.equals("")||date.length()!=8) {
            return 0;
        } else {
            Date cdate = convertStrToDate(date, "yyyyMMdd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cdate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+i);
            calendar.set(11, calendar.getActualMinimum(11));
            calendar.set(12, calendar.getActualMinimum(12));
            calendar.set(13, calendar.getActualMinimum(13));
            calendar.set(14, calendar.getActualMinimum(14));
            int times = (int) (calendar.getTimeInMillis()/1000);
            return times;
        }
    }
    
    /**
     * 当天最小时间戳
     * @param date 10位时间戳  i:日期加减值 em:-1  向前推一天
     * @return 10位时间戳
     */
    public static int getMinDateOfDay(int date, int i) {
        if (date <= 0) {
            return 0;
        } else {
            Date cdate = new Date(date * 1000l);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(cdate);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+i);
            calendar.set(11, calendar.getActualMinimum(11));
            calendar.set(12, calendar.getActualMinimum(12));
            calendar.set(13, calendar.getActualMinimum(13));
            calendar.set(14, calendar.getActualMinimum(14));
            int times = (int) (calendar.getTimeInMillis()/1000);
            return times;
        }
    }
    
    /**
     * 获取本日期本月第一一天 
     * 
     * @param date yyyyMM
     * @return  20151231
     */
    public static String getMinDayOfMonthStr(String date){
        Date cdate = convertStrToDate(date, "yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cdate);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(11, calendar.getActualMinimum(11));
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }
    /**
     * 获取本日期本月第一一天 
     * 
     * @param date yyyyMM
     * @return 10位时间戳
     */
    public static int getMinDayOfMonth(String date){
        Date cdate = convertStrToDate(date, "yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cdate);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(11, calendar.getActualMinimum(11));
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
        int times = (int) (calendar.getTimeInMillis()/1000);
        return times;
    }
    /**
     * 获取本日期本月最后一天 
     * 
     * @param date yyyyMM
     * @return 20151201
     */
    public static String getMaxDayOfMonthStr(String date){
        Date cdate = convertStrToDate(date, "yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cdate);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(11, calendar.getActualMaximum(11));
        calendar.set(12, calendar.getActualMaximum(12));
        calendar.set(13, calendar.getActualMaximum(13));
        calendar.set(14, calendar.getActualMaximum(14));
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        return format.format(calendar.getTime());
    }
    /**
     * 
     * @param date yyyyMM
     * 获取本日期本月最后一天 
     * @return 10位时间戳
     */
    public static int getMaxDayOfMonth(String date){
        Date cdate = convertStrToDate(date, "yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cdate);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(11, calendar.getActualMaximum(11));
        calendar.set(12, calendar.getActualMaximum(12));
        calendar.set(13, calendar.getActualMaximum(13));
        calendar.set(14, calendar.getActualMaximum(14));
        int times = (int) (calendar.getTimeInMillis()/1000);
        return times;
    }
	/**
     * 获取当天的 最大时间点
     * 
     * @param date
     * @return
     */
	public static Date getMaxDateOfDay(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(11, calendar.getActualMaximum(11));
			calendar.set(12, calendar.getActualMaximum(12));
			calendar.set(13, calendar.getActualMaximum(13));
			calendar.set(14, calendar.getActualMaximum(14));
			return calendar.getTime();
		}
	}
	
	/**
	 * 获取当月最大时间
	 * @param time 参考时间（年、月）
	 * @return 当月最大时间
	 */
	public static Integer getMaxTimeOfMonth(Integer time) {
	    if(time == null)
	        throw new IllegalArgumentException("非法输入参数[time]");
	    else {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(time * 1000l);
	        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
	        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
	        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
	        return getTime10Int(calendar.getTimeInMillis());
	    }
	}
	
	   /**
	 * 获取当月最小时间
	 * @param time 参考时间（年、月）
	 * @return 当月最小时间
	 */
	public static Integer getMinTimeOfMonth(Integer time) {
	        if(time == null)
	            throw new IllegalArgumentException("非法输入参数[time]");
	        else {
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTimeInMillis(time * 1000l);
	            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	            calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
	            calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
	            calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
	            return getTime10Int(calendar.getTimeInMillis());
	        }
	    }
	
	/**
	 * 获取指定天最小时间
	 * @param time 参考时间（年、月）
	 * @param day 指定天
	 * @return 该天最小时间
	 */
	public static Integer getMinTimeOfDay(Integer time, int day) {
        if(time == null && day > 31)
            throw new IllegalArgumentException("非法输入参数[time/day]");
        else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time * 1000l);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
            return getTime10Int(calendar.getTimeInMillis());
        }
	}
	
	/**
	 * 获取指定一天最大时间
	 * @param time 参考时间（年、月）
	 * @param day 指定天
	 * @return 该天最大时间
	 */
	public static Integer getMaxTimeOfDay(Integer time, int day) {
	    if(time == null && day > 31)
            throw new IllegalArgumentException("非法输入参数[time/day]");
        else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time * 1000l);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
            return getTime10Int(calendar.getTimeInMillis());
        }
	}
    
	/**
	 * 获取当天的 最小时间点
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMinDateOfDay(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(11, calendar.getActualMinimum(11));
			calendar.set(12, calendar.getActualMinimum(12));
			calendar.set(13, calendar.getActualMinimum(13));
			calendar.set(14, calendar.getActualMinimum(14));
			return calendar.getTime();
		}
	}

	/**
	 * 取指定日后n天，n允许为负数
	 * 
	 * @param date
	 * @param afterDays
	 * @return java.util.Date
	 */
	public static Date getAfterDay(Date date, int afterDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, afterDays);
		return cal.getTime();
	}
	
	/**
	 * 指定日后n天（n允许为负数） 的最小时间点
	 * 
	 * @param date
	 * @param afterDays
	 * @return
	 */
	public static int getDayMin10Bit(Date date, int afterDays){
	    
	    if (date == null) {
            return 0;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, afterDays);
            calendar.set(11, calendar.getActualMinimum(11));
            calendar.set(12, calendar.getActualMinimum(12));
            calendar.set(13, calendar.getActualMinimum(13));
            calendar.set(14, calendar.getActualMinimum(14));
            return getTime10Int(calendar.getTimeInMillis());
        }
	}
	
    public static int getDayMin10Bit(int date, int afterDays){
        return getDayMin10Bit(new Date(date * 1000l), afterDays);
    }
	
	/**
     * 指定日后n天（n允许为负数） 的最大时间点
     * 
     * @param date
     * @param afterDays
     * @return
     */
    public static int getDayMax10Bit(Date date, int afterDays){
        if (date == null) {
            return 0;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, afterDays);
            calendar.set(11, calendar.getActualMaximum(11));
            calendar.set(12, calendar.getActualMaximum(12));
            calendar.set(13, calendar.getActualMaximum(13));
            calendar.set(14, calendar.getActualMaximum(14));
            return getTime10Int(calendar.getTimeInMillis());
        }
    }
    
    public static int getDayMax10Bit(int date, int afterDays){
        return getDayMax10Bit(new Date(date * 1000l), afterDays);
    }
	
	/**
	 * 获取指定几个月后的日期
	 * @param date
	 * @param afterMonth
	 * @return
	 */
	public static java.util.Date getAfterMonth( java.util.Date date, int afterMonth){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(java.util.Calendar.MONTH,afterMonth);
		return cal.getTime();
	}

	/**
	 * 计算两个时间中之间的 天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int DateDiff(Date date1, Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()) / 3600 / 24 / 1000);
		return i;
	}

	/**
	 * 计算两个时间中之间的 分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int MinDiff(Date date1, Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()) / 1000 / 60);
		return i;
	}

	/**
	 * 计算两个时间中之间的 秒数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int TimeDiff(Date date1, Date date2) {
		int i = (int) ((date1.getTime() - date2.getTime()));
		return i;
	}
	
	/**
	 * 根据日期获取星期数
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date){
		Calendar c = Calendar.getInstance();
		String week = null;
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_WEEK) == 1){
			week = "[周日]";
		}else if(c.get(Calendar.DAY_OF_WEEK) == 2){
			week = "[周一]";
		}else if(c.get(Calendar.DAY_OF_WEEK) == 3){
			week = "[周二]";
		} else if(c.get(Calendar.DAY_OF_WEEK) == 4){
			week = "[周三]";
		} else if(c.get(Calendar.DAY_OF_WEEK) == 5){
			week = "[周四]";
		} else if(c.get(Calendar.DAY_OF_WEEK) == 6){
			week = "[周五]";
		} else if(c.get(Calendar.DAY_OF_WEEK) == 7){
			week = "[周六]";
		} else {
			week = "";
		}
		return week;
	}
	
	/**
	 * 获取当前月的第一天
	 * @param date
	 * @return	返回当前月第一天的日期
	 */
	public static String getFirstDayStrOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        
        return formatDate2Str(calendar.getTime());
	}
	
	/**
	 * 日期格式化成默认格式的字符串，yyyy-MM-dd
	 * @param date 待格式化日期
	 * @return	格式化字符串
	 */
	public static String formatDate2Str(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
	
	/**
	 * 日期格式化成默认格式的字符串，yyyy-MM-dd
	 * @param date 待格式化日期
	 * @return	格式化字符串
	 */
	public static String convertDate2Str(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
    /**
     * 返回：当前系统日
     * @return 09
     */
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);
        return sdf.format(new java.util.Date()).split("-")[2].split(" ")[0];
    }	
    /**
     * 获取当日日期 20160130 String
     * @return 
     */
    public static String getNowDay(int i){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date().getTime()+i*24*60*60*1000);
    }
    /**
     * 获取当日日期 20160130 Int
     * @return 
     */
    public static Integer getNowDayInt(int i){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDay= sdf.format(new Date().getTime()+i*24*60*60*1000);
        return Integer.valueOf(nowDay);
    }

	/**
	 * 将字符串转换为可查询的Date类型，默认格式(yyyyMMddHHmmss)
	 * @param String
	 * @return Date
	 * @throws ParseException
	 */
	
	public static Date convertStr2DateForQuery(String source)
	{		
		if(source == null || source.trim().length() != 14)
			return null;
		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sdf.setLenient(false);
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
		}
		
		return date;
	}
	
	/**
	 * 将字符串转换为可查询的Date类型，默认格式(yyyyMMddHHmmss)
	 * @param String
	 * @return Date
	 * @throws ParseException
	 */
	
	public static Date convertStrToDate(String source)
	{		
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
		}
		
		return date;
	}

	/**
	 * 判断时间差是否超过4小时
	 * @param timestamp1
	 * @param timestamp2
	 * @return
	 */
	public static boolean isDiffer4hours(long timestamp1, long timestamp2){
		if (Math.abs(timestamp1 - timestamp2) > 4 * 60 * 60 * 1000L)
			return true;
		else
			return false;
	}

	/**
	 * 获取当前时间的时间戳
	 * 
	 * @return
	 */
	public static int getTimeStampInt() {
	    return (int) (new Date().getTime() / 1000l);
	}
    public static int getTimeStampInt(Date date) {
        return (int) (date.getTime() / 1000l);
    }
	
	/**
	 * 将字符串转换为可查询的Date类型，默认格式(yyyy/MM/dd)
     * @param String
     */
    public static Date convertStrToDate(String source, String pattern) {    
        if (source == null || source.length() <= 0) {
            return null;
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat((pattern == null || pattern.length() <=0) ? "yyyy/MM/dd" : pattern);
        sdf.setLenient(false);
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return date;
    }
    
    /**
     * 按天获取时间差（按照北京时间计算：包括startTime、endTime当天）
     * 
     * @param base
     * @param time
     * @return
     */
    public static int offsetOfDay(int startTime, int endTime) {
        return (endTime + 8 * 3600) / 3600 / 24 - (startTime + 8 * 3600) / 3600 / 24 + 1;
    }
	
    /**
     * 将时间戳转化为时间字符串
     * */
    public static String convertLongToString(long timestamp,String pattern){
        if(pattern == null || pattern == ""){
            pattern = "yyyyMMdd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String date = sdf.format(new Date(timestamp));
        return date;
    }
	/**
	 * 将时间戳转化为时间字符串
	 *
	 * */
	public static String convertIntToString(Long timestamp,String pattern){
		if(pattern == null || pattern == ""){
			pattern = "yyyyMMdd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date(timestamp*1000L));
		return date;
	}
	/**
	 * 转时间格式 
	 * @param timestamp
	 * @return  2099年12月30日
	 */
	public static String convertLongToString(Long timestamp){
		if(timestamp==null)return "";
		String pattern = "yyyy年MM月dd日";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date(timestamp));
		return date;
	}
	
	/**
	 * 转时间格式 
	 * @param timestamp
	 * @return  yyyy-MM-dd HH:mm:ss
	 */
	public static String convertLongToString2(Long timestamp){
		if(timestamp==null||timestamp==0)return "";
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date(timestamp));
		return date;
	}
	/**
	 * 转时间格式 
	 * @param timestamp
	 * @return  M月dd日
	 */
	public static String convertLongToString3(Long timestamp){
		if(timestamp==null||timestamp==0)return "";
		String pattern = "M月dd日";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date(timestamp));
		return date;
	}
	/**
	 * 日期格式化成默认格式的字符串，yyyyMMdd
	 * @param date MM月dd日
	 * @return	格式化字符串
	 */
	public static String formatDate2StrMD(String source){
		if(null==source || "".equals(source))return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
			Date date = null;
			try {
				date = sdf.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		SimpleDateFormat sdfs = new SimpleDateFormat("M月dd日");
		
		return sdfs.format(date);
	}

	/**
	 * 判断两个时间是否是同一天
	 * @param timestamp1 13位时间戳
	 * @param timestamp2 13位时间戳
	 * @return
	 */
	public static boolean isSameDate(long timestamp1, long timestamp2) {
		if (Math.abs(timestamp1 - timestamp2) > 24 * 60 * 60 * 1000L)
			return false;
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(timestamp1);
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(timestamp2);
		return c1.get(Calendar.DATE) == c2.get(Calendar.DATE);
	}
	
	/**
	 * 取指定日后n分钟，n允许为负数
	 *
	 * @param date
	 * @param afterDays
	 * @return java.util.Date
	 */
	public static Date getAfterMin(Date date, int afterMinis) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, afterMinis);
		return cal.getTime();
	}

	/**
	 * yyyy-MM-dd HH:mm:ss转成long型数据
	 * @param datestr
	 * @return
	 */
	public static long Date2Timestamp(String datestr){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timestamp = date.getTime()/1000;
		return timestamp;
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss转成int型数据
	 * @param datestr
	 * @return
	 */
	public static int Date2TimestampInt(String datestr){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timestamp = date.getTime()/1000;
		return Integer.parseInt( Long.toString(timestamp));
	}
	
	/**
	 * 将13位时间值转换成10位的int类型
	 * 
	 * @param time
	 * @return
	 */
	public static int getTime10Int(long time) {
        if(time > Integer.MAX_VALUE)
            return (int) (time / 1000);
        else
            return (int) time;
    }
	
	
	/**
	 * 获取当着时间10位
	 * @return
	 */
	public static Integer getCurrentTimeWith10Bit() {
		return (int) (System.currentTimeMillis()/1000l);
	}

	/**
	 * 将13位时间值转换成10位
	 * @param time 13位时间值
	 * @return 10位时间值
	 */
	public static long  getTime10Long(long time) {
		if(time > Integer.MAX_VALUE)
			return time/1000l;
		else
			return time;
	}
	
	
	/**
	 * 获取某小时之前的时间值
	 * @param hour 几小时之前
	 * @return 时间10位long值
	 */
	public static long getTimeBeforeSomeHourWith10Bit(int hour) {
		return System.currentTimeMillis()/1000l - hour*60*60l;
	}
	
	/**
	 * 返回当时的小时数(24小时制)
	 * @param timeStamp
	 * @return
	 */
	public static int getNowHour(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);  
		return hour;
	}
	
	/**
	 * 返回当时的分钟数
	 * @param timeStamp
	 * @return
	 */
	public static int getNowMinute(){
		Calendar cal = Calendar.getInstance();
		int Minute = cal.get(Calendar.MINUTE);  
		return Minute;
	}
	
	/**
	 * 返回当时的年
	 * @param timeStamp
	 * @return
	 */
	public static int getNowYear(){
		Calendar cal = Calendar.getInstance();
		int YEAR = cal.get(Calendar.YEAR);  
		return YEAR;
	}
	
	/**
	 * 返回当时的月
	 * @param timeStamp
	 * @return
	 */
	public static int getNowMonth(){
		Calendar cal = Calendar.getInstance();
		int MONTH = cal.get(Calendar.MONTH);  
		return MONTH;
	}
	
	/**
	 * 返回当时的日
	 * @param timeStamp
	 * @return
	 */
	public static int getNowDay(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);  
		return day;
	}
	
	/**
	 * 根据年月日返回格林尼治时间的毫秒
	 * @param timeStamp
	 * @return
	 */
	public static long getTimeByDate(int y,int M,int d,int h,int m,int s){
		Calendar cal = Calendar.getInstance();
		cal.set(y,M,d,h,m,s);
        return cal.getTimeInMillis();
	}
	
	/**
	 * 根据两个时间戳返回 它们的时间相差多少天
	 * @param firstTime 第一个时间
	 * @param secondTime 第二个时间
	 * @return
	 */
	public static int getDayDifferenceByTS(long firstTime,long secondTime){
		long day = (Math.abs(firstTime-secondTime))/(24*60*60);
		BigDecimal bd = new BigDecimal(day);
		int newDay = Integer.parseInt(bd.setScale(BigDecimal.ROUND_UP).toPlainString());
        return newDay;
	}
	
}
