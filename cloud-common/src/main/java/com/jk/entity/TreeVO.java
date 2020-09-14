/** 
 * <pre>项目名称:bootstrap-demo 
 * 文件名称:TreeVO.java 
 * 包名:com.jk.entity 
 * 创建日期:2020年8月21日上午10:05:31 
 * Copyright (c) 2020, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

import java.util.List;

/** 
 * <pre>项目名称：bootstrap-demo    
 * 类名称：TreeVO    
 * 类描述：    
 * 创建人：yangshy myangshu@sina.com    
 * 创建时间：2020年8月21日 上午10:05:31    
 * 修改人：yangshy myangshu@sina.com     
 * 修改时间：2020年8月21日 上午10:05:31    
 * 修改备注：       
 * @version </pre>    
 */
public class TreeVO {
	
	private Integer id;
	private String text;
	private String href;
	//是否可选中
	private Boolean selectable;
	private Integer pid;
	private List<TreeVO> nodes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Boolean getSelectable() {
		return selectable;
	}
	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List<TreeVO> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeVO> nodes) {
		this.nodes = nodes;
	}
	
}
