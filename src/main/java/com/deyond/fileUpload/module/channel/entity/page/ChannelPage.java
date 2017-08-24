package com.deyond.fileUpload.module.channel.entity.page;

import com.deyond.fileUpload.common.entity.Page;


/**
 * 
 *
 * @version 2017年7月27日 下午4:46:10
 * @author zhiyong.lin
 */
public class ChannelPage extends Page{
	/** 主键ID*/
	private String id;
	/** 渠道类型： 10-渠道分类，20-渠道主体 ，30-渠道号*/
	private String channelType;
	/** 渠道分类名称 */
	private String groupName;
	/** 渠道名称 */
	private String channelName;
	/** 公司名称 */
	private String channelCompany;
	/** 渠道号 */
	private String channelAccount;
	/** 状态  10启用；20停用 */
    private String status;

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelCompany() {
		return channelCompany;
	}

	public void setChannelCompany(String channelCompany) {
		this.channelCompany = channelCompany;
	}

	public String getChannelAccount() {
		return channelAccount;
	}

	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
