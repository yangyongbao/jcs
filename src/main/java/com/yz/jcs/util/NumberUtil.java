package com.yz.jcs.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberUtil {
	private static final BigDecimal BIGDECIMAL_10000000 = new BigDecimal(10000000);
	
	private static final BigDecimal BIGDECIMAL_100000000 = new BigDecimal(100000000);

	private static final BigDecimal BIGDECIMAL_100000 = new BigDecimal(100000);
	
	private static final BigDecimal BIGDECIMAL_10000 = new BigDecimal(10000);

	public static String formatNum(BigDecimal num, int scale) {
		if(num == null){
			return "";
		}
		
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		String pattern = "###,###";
		if (scale > 0) {
			pattern += ".";
		}
		for (int i = 0; i < scale; i++) {
			pattern += "0";
		}
		df.applyPattern(pattern);
		if (num.divide(BIGDECIMAL_10000000).intValue() >= 1) {
			return formatNum(num.divide(BIGDECIMAL_100000000), scale) + "亿";
		} else if (num.divide(BIGDECIMAL_100000).intValue() >= 1) {
			return formatNum(num.divide(BIGDECIMAL_10000), scale) + "万";
		} else {
			String finalStr = df.format(num);
			if (finalStr.indexOf(".") == 0) {
				return "0" + finalStr;
			} else {
				return df.format(num);
			}
		}
	}
	
	public static String formatNum(Integer num){
    	if(num==null|| num==0){
    		return "0";
    	}
    	int scale = 0;
    	return formatNum(new BigDecimal(num),scale);
    }
    
    public static String formatNum(Double num){
    	if(num==null || num==0){
    		return "0.00";
    	}
    	//默认保留小数位
    	int scale = 2;
    	return formatNum(new BigDecimal(num),scale);
    }
    public static String formatNum(BigDecimal num){
    	if(num==null|| num.doubleValue()==0){
    		return "0.00";
    	}
    	return formatNum(num.doubleValue());
    }
    
    
    public static String formatNumNoFlag(int num){
    	DecimalFormat df=(DecimalFormat)NumberFormat.getInstance(); 
    	String pattern = "###,###";
    	df.applyPattern(pattern);
    	return df.format(num);
    }
	
    public static Integer parseInt(String s,Integer def){
    	try{
    		return Integer.parseInt(s);
    	}catch(Exception e){
    		return def;
    	}
    }
    
	public static void main(String[] args) {
		System.out.println(NumberUtil.formatNum(new BigDecimal("123456789"),2));
	}
}
