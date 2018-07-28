package com.renwoxing.util;

/*** 
 *  @Program Name  : servletframe.com.servletframe.util.StringUtil.java
 *  @Written by    : Hui Dong
 *  @Creation Date : 2014Âπ?11Êú?27Êó? 19:54:47
 *  @version       : v1.00
 *  @Description   :  Â≠óÁ¨¶‰∏≤Â∑•ÂÖ∑Á±ª
 *  @ModificationHistory  
 *  Who          When                What 
 *  --------     ----------          ------------------------------------------------ 
 *  Hong Liang    2014Âπ?10Êú?30Êó•‰∏ãÂç?1:57:40      TODO
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
