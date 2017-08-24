package com.deyond.fileUpload.module.channel.entity;

import java.io.Serializable;

import com.deyond.fileUpload.common.entity.EntityVo;

/**
 * 渠道类
 *
 * @version 2017年7月27日 下午4:59:45
 * @author zhiyong.lin
 */
public class Channel extends EntityVo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    /** 渠道ID */
    private String Id;
    /** 上级渠道ID */
    private String parentId;
    /** 渠道分类 */
    private String groupName;
    /** 渠道名称 */
    private String channelName;
    /** 渠道号 */
    private String  channelAccount;
    /** 渠道公司 */
    private String channelCompany;
    /** 维护人 */
    private String director;
    /** 状态  10启用；20停用 */
    private String status;
    /** 备注 */
    private String remark;
    /** 创建时间 */
    private String createTime;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelAccount() {
		return channelAccount;
	}
	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount;
	}
	public String getChannelCompany() {
		return channelCompany;
	}
	public void setChannelCompany(String channelCompany) {
		this.channelCompany = channelCompany;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}