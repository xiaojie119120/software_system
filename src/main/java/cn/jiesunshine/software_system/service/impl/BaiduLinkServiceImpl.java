package cn.jiesunshine.software_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiesunshine.software_system.dao.BaiduLinkMapper;
import cn.jiesunshine.software_system.entity.BaiduLink;
import cn.jiesunshine.software_system.entity.BaiduLinkExample;
import cn.jiesunshine.software_system.service.BaiduLinkService;
@Service
public class BaiduLinkServiceImpl implements BaiduLinkService {
	
	@Autowired
	private BaiduLinkMapper baiduLinkMapper;
	
	@Override
	public int addBaiduLink(BaiduLink bLink) {
		// TODO Auto-generated method stub
		httplk2Link(bLink);
		return baiduLinkMapper.insert(bLink);
	}

	@Override
	public int delBaiduLinkById(int id) {
		// TODO Auto-generated method stub
		return baiduLinkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int delBaiduLinkBySid(int sid) {
		// TODO Auto-generated method stub
		BaiduLinkExample example = new BaiduLinkExample();
		example.createCriteria().andBdSoftIdEqualTo(sid);
		return baiduLinkMapper.deleteByExample(example);
		
	}

	@Override
	public int updateBaiduLinkById(BaiduLink bLink) {
		// TODO Auto-generated method stub
		httplk2Link(bLink);
		return baiduLinkMapper.updateByPrimaryKeySelective(bLink);
		
	}

	@Override
	public BaiduLink getBaiduLinkById(int id) {
		// TODO Auto-generated method stub
		return baiduLinkMapper.selectByPrimaryKey(id);
	}

	@Override
	public BaiduLink getBaiduLinkBySid(int sid) {
		// TODO Auto-generated method stub
		
		BaiduLinkExample example = new BaiduLinkExample();
		example.createCriteria().andBdSoftIdEqualTo(sid);
		List<BaiduLink> bLinks = baiduLinkMapper.selectByExample(example);
		if (bLinks.size()!=0){
			return bLinks.get(0);
		}else {
			return null;
		}
	}

	@Override
	public int updateBaiduLinkBySid(BaiduLink bLink) {
		// TODO Auto-generated method stub
		httplk2Link(bLink);
		BaiduLinkExample example = new BaiduLinkExample();
		example.createCriteria().andBdSoftIdEqualTo(bLink.getBdSoftId());
		return baiduLinkMapper.updateByExampleSelective(bLink, example);
	}
	private void httplk2Link(BaiduLink bLink){
		bLink.setBdLink(bLink.getBdLink().replace("http://", "").replace("https://", ""));
	}
}
