package com.renwoxing.util;

/*** 
 *  @Program Name  : servletframe.com.servletframe.util.StringUtil.java
 *  @Written by    : Hui Dong
 *  @Creation Date : 2014�?11�?27�? 19:54:47
 *  @version       : v1.00
 *  @Description   :  字符串工具类
 *  @ModificationHistory  
 *  Who          When                What 
 *  --------     ----------          ------------------------------------------------ 
 *  Hong Liang    2014�?10�?30日下�?1:57:40      TODO
 ***/
public class StringUtil {
	public static boolean isNotNull(String value){
		boolean result = false;
		if(value!=null&&value!=""&&!value.equals("")&&!value.equals(null)){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
}
