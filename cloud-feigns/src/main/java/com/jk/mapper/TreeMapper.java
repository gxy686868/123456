/** 
 * <pre>项目名称:BootStrap-tree 
 * 文件名称:TreeMapper.java 
 * 包名:com.jk.mapper 
 * 创建日期:2020年8月21日上午11:58:56 
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jk.entity.TreeVO;

/** 
 * <pre>项目名称：BootStrap-tree    
 * 类名称：TreeMapper    
 * 类描述：    
 * 创建人：gxy
 * 创建时间：2020年8月21日 上午11:58:56    
 * 修改人：gxy
 * 修改时间：2020年8月21日 上午11:58:56    
 * 修改备注：       
 * @version </pre>    
 */
@Mapper
public interface TreeMapper {

	/** <pre>queryTreeByPid(这里用一句话描述这个方法的作用)   
	 * 创建人：gxy
	 * 创建时间：2020年8月21日 下午12:04:54    
	 * 修改人：gxy
	 * 修改时间：2020年8月21日 下午12:04:54    
	 * 修改备注： 
	 * @param pid
	 * @return</pre>    
	 */
	List<TreeVO> queryTreeByPid(@Param("pid")Integer pid);

}
