/** 
 * <pre>项目名称:BootStrap-tree 
 * 文件名称:TreeServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2020年8月21日上午11:58:19 
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.entity.TreeVO;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;

/** 
 * <pre>项目名称：BootStrap-tree    
 * 类名称：TreeServiceImpl    
 * 类描述：    
 * 创建人：gxy
 * 创建时间：2020年8月21日 上午11:58:19    
 * 修改人：gxy
 * 修改时间：2020年8月21日 上午11:58:19    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class TreeServiceImpl implements TreeService{
	@Autowired
	private TreeMapper treeMapper;

	//递归树
	@Override
	public List<TreeVO> queryTreeVO() {
		//根节点pid为0
		Integer rootPid = 0; 
		return queryTreeVOByPid(rootPid);
	}

	/** <pre>queryTreeVOByPid(递归查询子节点)   
	 * 创建人：gxy
	 * 创建时间：2020年8月21日 下午12:00:36    
	 * 修改人：gxy
	 * 修改时间：2020年8月21日 下午12:00:36    
	 * 修改备注： 
	 * @param rootPid
	 * @return</pre>    
	 */
	private List<TreeVO> queryTreeVOByPid(Integer pid) {
		List<TreeVO> treeList=treeMapper.queryTreeByPid(pid);
		
		for (TreeVO treeVO : treeList) {
			Integer id = treeVO.getId();
			List<TreeVO> queryTreeVOByPid = queryTreeVOByPid(id);
			if(queryTreeVOByPid == null || queryTreeVOByPid.isEmpty()){
				//代表当前节点无子节点
				treeVO.setSelectable(true);
			}else{
				//代表当前节点为父节点 无需选中
				treeVO.setSelectable(false);
				treeVO.setNodes(queryTreeVOByPid);
			}
		}
		return treeList;
	}

}
