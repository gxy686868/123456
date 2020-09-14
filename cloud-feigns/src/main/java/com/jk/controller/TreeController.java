/** 
 * <pre>项目名称:BootStrap-tree 
 * 文件名称:TreeController.java 
 * 包名:com.jk.controller 
 * 创建日期:2020年8月21日上午11:56:53 
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.TreeVO;
import com.jk.service.TreeService;

/** 
 * <pre>项目名称：BootStrap-tree    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：gxy
 * 创建时间：2020年8月21日 上午11:56:53    
 * 修改人：gxy
 * 修改时间：2020年8月21日 上午11:56:53    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("tree")
public class TreeController {


	@Autowired
	private TreeService treeService;

	//跳转到tree页面
	@RequestMapping("tree")
	public String toShow(){
		return "tree";
	}

	//树
	@RequestMapping("queryAllTreeInfo")
	@ResponseBody
	public List<TreeVO> queryAllTreeInfo(){
		return treeService.queryTreeVO();
	}

}
