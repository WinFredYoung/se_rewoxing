package com.renwoxing.util;

/*** 
 *  @Program Name  : servletframe.com.servletframe.util.Page.java
 *  @Written by    : Hong Liang
 *  @Creation Date : 2014�?10�?30�? 下午9:14:37 
 *  @version       : v1.00
 *  @Description   :  网上的一个分页工具类
 *  @ModificationHistory  
 *  Who          When                What 
 *  --------     ----------          ------------------------------------------------ 
 *  Hong Liang    2014�?10�?30日下�?9:14:37      TODO
 ***/
public class Page {

	private int totalPage;// 总页�?
	private int pageSize = 10;// 分页大小
	private int curentPage = 1;// 默认当前页吗
	private int perverPage;// 上一�?
	private int nextPage;// 下一�?
	private int count;// 总记录数

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public int getPerverPage() {
		return perverPage;
	}

	public void setPerverPage(int perverPage) {
		this.perverPage = perverPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		// 计算页数高深算法哈哈
		this.totalPage = (count - 1 + pageSize) / pageSize;

		// 计算下一�?
		if (totalPage == curentPage) {
			nextPage = curentPage;
		} else {
			nextPage = curentPage + 1;
		}
		// 计算上一页数
		if (curentPage == 1) {
			perverPage = 1;
		} else {
			perverPage = curentPage - 1;
		}
		this.count = count;
	}
}
