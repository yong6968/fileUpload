package com.deyond.fileUpload.module.channel.service;

import com.deyond.fileUpload.module.channel.entity.page.ChannelPage;

/**
 * 渠道管理
 *
 * @version 2017年7月27日 下午4:32:10
 * @author zhiyong.lin
 */
public interface ChannelService {
	/**
	 * 功能：查询列表
	 *
	 * @version 2017年7月27日 下午5:33:51
	 * @author zhiyong.lin
	 * @param page 分页类
	 */
	public void findList(ChannelPage page);
}
