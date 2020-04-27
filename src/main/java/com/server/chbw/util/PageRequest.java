package com.server.chbw.util;

/**
 * 分页请求
 */
public class PageRequest {
	/**
     * 当前页码
     */
    private int page;
    /**
     * 每页数量
     */
    private int limit;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
    

}
