package com.deyond.fileUpload.common.dao;

import java.io.Serializable;
import java.util.List;

import com.deyond.fileUpload.common.entity.Page;

/**
 * 功能：基本接口，不是为了公用，而是为了约束常用功能方法的命名。 类和子类中的方法排序需遵守 增、删、改、查 的顺序，在此基础上常用名要优先，如getById要先于getByUserId。
 *
 * @version 2016年12月28日下午8:55:38
 * @author baocheng.ren
 * @param <T>
 */
public interface BasicDAO<T> {
    
    /**
     * 功能：插入新对象
     *
     * @version 2016年12月28日下午8:53:19
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int insert(T o);
    
    /**
     * 功能：删除一个或多个对象
     *
     * @version 2016年12月28日下午8:53:35
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int delete(T o);
    
    /**
     * 功能：根据对象id删除单一对象
     *
     * @version 2016年12月28日下午8:53:53
     * @author baocheng.ren
     * @param id 主键
     * @return int
     */
    int deleteById(Serializable id);
    
    /**
     * 功能：更新修改的对象
     *
     * @version 2016年12月28日下午8:54:03
     * @author baocheng.ren
     * @param o 对象
     * @return int
     */
    int update(T o);
    
    /**
     * 功能：根据对象id获取单一对象
     *
     * @version 2016年12月28日下午8:54:14
     * @author baocheng.ren
     * @param id 主键
     * @return T
     */
    T findById(Serializable id);
    
    /**
     * 功能：无条件获取所有对象
     *
     * @version 2016年12月28日下午8:54:23
     * @author baocheng.ren
     * @return List<T>
     */
    List<T> findAll();
    
    /**
     * 功能：根据查询对象获取多个对象
     *
     * @version 2016年12月28日下午8:54:35
     * @author baocheng.ren
     * @param page 分页类
     * @return List<Object>
     */
    List<Object> findList(Page page);
    
    /**
     * 功能：根据查询对象统计结果个数
     *
     * @version 2016年12月28日下午8:54:43
     * @author baocheng.ren
     * @param page 分页类
     * @return int
     */
    int findCount(Page page);
    
}
