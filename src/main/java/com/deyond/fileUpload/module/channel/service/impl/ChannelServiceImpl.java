package com.deyond.fileUpload.module.channel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.deyond.fileUpload.module.channel.dao.ChannelDao;
import com.deyond.fileUpload.module.channel.entity.page.ChannelPage;
import com.deyond.fileUpload.module.channel.service.ChannelService;



/**
 * 渠道管理
 *
 * @version 2017年7月27日 下午4:31:54
 * @author zhiyong.lin
 */
@Service
public class ChannelServiceImpl implements ChannelService {
	
	@Resource
	private ChannelDao channelDao;
	
	@Override
	public void findList(ChannelPage page) {
		// TODO Auto-generated method stub
		int count = this.channelDao.findCount(page);
        if (count > 0) {
            List<Object> findList = this.channelDao.findList(page);
            page.setDatas(findList);
            page.setTotalElements(count);
        }
	}
}
