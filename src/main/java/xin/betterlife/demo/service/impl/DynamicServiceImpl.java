package xin.betterlife.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import xin.betterlife.demo.entity.Notice;
import xin.betterlife.demo.mapper.NoticeMapper;
import xin.betterlife.demo.service.IDynamicService;
import xin.betterlife.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DynamicServiceImpl
 *
 * @author Steven Chen
 */
@Service
public class DynamicServiceImpl extends BaseServiceImpl<NoticeMapper, Notice> implements IDynamicService {

	@Override
	public List<Notice> masterList() {
		return this.list();
	}

	@Override
	@DS("slave")
	public List<Notice> slaveList() {
		return this.list();
	}
}
