package com.zengyao.util;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 * @author 曾尧
 *
 */
public class PageUtil {
	
	/**
	 * 获取分页工具
	 * @param total 总记录数
	 * @param page 当前页面
	 * @param size 每页数量
	 * @return
	 */
	public static String getPageTool(HttpServletRequest request, long total, int page, int size){
		if (total <= 0) {
			return null;
		}
		int pages = (int) (total % size ==0 ? total/size : total /size + 1);
		pages = pages == 0 ? 1 : pages;
		String url = request.getRequestURL().toString();
		StringBuilder paramBuilder = new StringBuilder();
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			if(param.indexOf("page") > -1) {
				continue;
			}
			paramBuilder.append("&").append(param).append("=").append(request.getParameter(param));
		}
		
		StringBuilder pageBuilder = new StringBuilder();
		pageBuilder.append("<div class='pagination'>");
		if (page <= 1) { 
			pageBuilder.append("<span class='disabled'><<</span>");
		}else{
			pageBuilder.append("<span>").append("<a href='").append(url).append("?").append("page=").append(page-1)
			.append(paramBuilder).append("'>").append("<<").append("</a>").append("</span>");
		}
		if (pages <= 7) { 
			for (int i = 1; i <= pages; i++) {
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, i));
			}
		}else{
			if (page<4 || page>pages-3) { // 1 2 3 ... pages-2 pages-1 pages
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, 1));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, 2));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, 3));
				pageBuilder.append(" ... ");
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, pages-2));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, pages-1));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, pages));
			}else{	// 1 2 ... page-1 page page+1 ... pages-1 pages
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, 1));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, 2));
				pageBuilder.append(" ... ");
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, page-1));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, page));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, page+1));
				pageBuilder.append(" ... ");
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, pages-1));
				pageBuilder.append(packPageItem(url, paramBuilder.toString(), page, pages));
			}
		}
		// 
		if (page >= pages) { 
			pageBuilder.append("<span class='disabled'>>></span>");
		}else{
			pageBuilder.append("<span>").append("<a href='").append(url).append("?").append("page=").append(page+1)
			.append(paramBuilder).append("'>").append(">>").append("</a>").append("</span>");
		}
		pageBuilder.append("</div>");
		return pageBuilder.toString();
	}
	
	
	/**
	 * 封装分页项
	 * @param url
	 * @param params
	 * @param page
	 * @param i
	 * @return
	 */
	private static String packPageItem(String url, String params, int page, int i) {
		StringBuilder pageBuilder = new StringBuilder();
		if (i == page) {
			pageBuilder.append("<span class='current'>").append(i).append("</span>");
		}else{
			pageBuilder.append("<a href='").append(url).append("?").append("page=").append(i)
				.append(params).append("'>");pageBuilder.append(i).append("</a>");
		}
		return pageBuilder.toString();
	}
	
	
	/**
	 * 后台管理分页
	 * @param request
	 * @param total
	 * @param page
	 * @param size
	 * @return
	 */
	public static String getPageToolAdmin(HttpServletRequest request, long total, int page, int size) {
		if (total <= 0) {
			return null;
		}
		int pages = (int) (total % size ==0 ? total/size : total /size + 1);
		pages = pages == 0 ? 1 : pages;
		String url = request.getRequestURL().toString();
		StringBuilder paramBuilder = new StringBuilder();
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			if(param.indexOf("page") > -1) {
				continue;
			}
			paramBuilder.append("&").append(param).append("=").append(request.getParameter(param));
		}
		
		StringBuilder pageBuilder = new StringBuilder();
		pageBuilder.append("<div style='width:140px;float:right;'>");
		if (page <= 1) { 
			pageBuilder.append("<span style='color:lightgray'>上一页</span>");
		}else{
			pageBuilder.append("<span>").append("<a href='").append(url).append("?").append("page=").append(page-1)
			.append(paramBuilder).append("'>").append("上一页").append("</a>").append("</span>");
		}
		pageBuilder.append("[").append(page).append("/").append(pages).append("]");
		if (page >= pages) { 
			pageBuilder.append("<span style='color:lightgray'>下一页</span>");
		}else{
			pageBuilder.append("<span>").append("<a href='").append(url).append("?").append("page=").append(page+1)
			.append(paramBuilder).append("'>").append("下一页").append("</a>").append("</span>");
		}
		pageBuilder.append("</div>");
		return pageBuilder.toString();
	}

}
