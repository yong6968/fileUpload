package com.deyond.fileUpload.common.entity;

import java.util.List;

/**
 * 功能：基类page中包含公有翻页参数及保存查询到的结果以被页面遍历， 被子类继承后将增加不同的查询条件 。
 *
 * @version 2016年12月28日下午8:59:57
 * @author baocheng.ren
 */
@SuppressWarnings("unused")
public class Page {
    /**
     * 每页显示条数默认为10条
     */
    public static final int DEFAULT_SIZE = 10;
    
    /**
     * 分页时中间显示多少页数
     */
    public static final int DEFAULT_PAGER_RANGE = 7;
    
    /**
     * 当前页码， 从1开始计
     */
    private long page;
    
    /**
     * 每页条数
     */
    private int pagesize;
    
    /**
     * 总条数
     */
    private long totalElements;
    
    /**
     * 当前页数据
     */
    private List<Object> datas;
    
    /**
     * 排序字段名称
     */
    private String sortname;
    
    /**
     * 排序方式
     */
    private String sortorder;
    
    /**
     * 开始页数
     */
    private long beginPage;
    
    /**
     * 结束页数
     */
    private long endPage;
    
    /**
     * 中间显示多少页数
     */
    private int pagerRange = DEFAULT_PAGER_RANGE;
    
    /**
     * 全部显示结果列表的标志
     */
    private boolean allTag;
    
    public long getBeginPage() {
        return this.beginPage = Math.max(1, this.getPage() - this.getPagerRange() / 2);
    }
    
    public long getEndPage() {
        return Math.min(this.getBeginPage() + (this.getPagerRange() - 1), this.getTotalPages());
    }
    
    public int getPagerRange() {
        return pagerRange;
    }
    
    public void setPagerRange(int pagerRange) {
        this.pagerRange = pagerRange;
    }
    
    public Page() {
        // 设置默认值
        page = 1;
        pagesize = DEFAULT_SIZE;
    }
    
    /**
     * 功能：获取当前页码
     *
     * @version 2016年12月28日下午9:02:47
     * @author baocheng.ren
     * @return long
     */
    public long getPage() {
        return page;
    }
    
    /**
     * 功能：设置当前页码
     *
     * @version 2016年12月28日下午9:03:00
     * @author baocheng.ren
     * @param page 分页类
     */
    public void setPage(long page) {
        this.page = page;
    }
    
    /**
     * 功能：获取每页显示条数
     *
     * @version 2016年12月28日下午9:04:00
     * @author baocheng.ren
     * @return int
     */
    public int getPagesize() {
        return pagesize;
    }
    
    /**
     * 功能：设置每页显示条数
     *
     * @version 2016年12月28日下午9:04:08
     * @author baocheng.ren
     * @param pagesize 条数
     */
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    
    /**
     * 功能：获取当前页数据
     *
     * @version 2016年12月28日下午9:04:20
     * @author baocheng.ren
     * @return List<Object>
     */
    public List<Object> getDatas() {
        return datas;
    }
    
    /**
     * 功能：设置当前页数据
     *
     * @version 2016年12月28日下午9:04:27
     * @author baocheng.ren
     * @param datas 数据
     */
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
    
    /**
     * 功能：是否有数据
     *
     * @version 2016年12月28日下午9:04:42
     * @author baocheng.ren
     * @return boolean
     */
    public boolean hasDatas() {
        if (datas != null && !datas.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * 功能：获取总条数
     *
     * @version 2016年12月28日下午9:04:54
     * @author baocheng.ren
     * @return long
     */
    public long getTotalElements() {
        return totalElements;
    }
    
    /**
     * 功能：设置总条数
     *
     * @version 2016年12月28日下午9:05:07
     * @author baocheng.ren
     * @param totalElements 数据总数
     */
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    
    /**
     * 功能：获取总页数
     *
     * @version 2016年12月28日下午9:05:22
     * @author baocheng.ren
     * @return long
     */
    public long getTotalPages() {
        if (!hasDatas()) {
            return 0;
        }
        
        long totalPages = totalElements / pagesize;
        if (totalElements % pagesize != 0) {
            totalPages++;
        }
        
        return totalPages;
    }
    
    /**
     * 功能：是否是第一页
     *
     * @version 2016年12月28日下午9:05:35
     * @author baocheng.ren
     * @return boolean
     */
    public boolean isFirstPage() {
        return page == 1 ? true : false;
    }
    
    /**
     * 功能：是否是最后一页
     *
     * @version 2016年12月28日下午9:05:44
     * @author baocheng.ren
     * @return boolean
     */
    public boolean isLastPage() {
        return page == getTotalPages() ? true : false;
    }
    
    /**
     * 功能：获取从第几条数据开始查询
     *
     * @version 2016年12月28日下午9:05:53
     * @author baocheng.ren
     * @return long
     */
    public long getStart() {
        return (page - 1) * pagesize;
    }
    
    public void setBeginPage(long beginPage) {
        this.beginPage = beginPage;
    }
    
    public void setEndPage(long endPage) {
        this.endPage = endPage;
    }
    
    public boolean getAllTag() {
        return allTag;
    }
    
    /**
     * 功能：设置全部查出结果，即sql语句不添加limit子句
     *
     * @version 2016年12月28日下午8:51:22
     * @author baocheng.ren
     * @param allTag 查询标记
     */
    public void setAllTag(boolean allTag) {
        this.allTag = allTag;
    }
    
    public String getSortname() {
        return sortname;
    }
    
    public void setSortname(String sortname) {
        this.sortname = sortname;
    }
    
    public String getSortorder() {
        return sortorder;
    }
    
    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }
}