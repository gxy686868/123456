/** 
 * <pre>项目名称:BootStrap-tree 
 * 文件名称:TreeService.java 
 * 包名:com.jk.service 
 * 创建日期:2020年8月21日上午11:57:51 
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;

import com.jk.entity.TreeVO;

/** 
 * <pre>项目名称：BootStrap-tree    
 * 类名称：TreeService    
 * 类描述：    
 * 创建人：gxy
 * 创建时间：2020年8月21日 上午11:57:51    
 * 修改人：gxy
 * 修改时间：2020年8月21日 上午11:57:51    
 * 修改备注：       
 * @version </pre>    
 */
public interface TreeService {

	/** <pre>queryTreeVO(这里用一句话描述这个方法的作用)   
	 * 创建人：gxy
	 * 创建时间：2020年8月21日 上午11:59:30    
	 * 修改人：gxy
	 * 修改时间：2020年8月21日 上午11:59:30    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<TreeVO> queryTreeVO();

}
