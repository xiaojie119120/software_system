package cn.jiesunshine.software_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiesunshine.software_system.dao.SoftPicMapper;
import cn.jiesunshine.software_system.entity.SoftPic;
import cn.jiesunshine.software_system.entity.SoftPicExample;
import cn.jiesunshine.software_system.entity.SoftPicExample.Criteria;
import cn.jiesunshine.software_system.service.SoftPicService;
@Service
public class SoftPicServiceImpl implements SoftPicService {
	@Autowired
	SoftPicMapper softPicMapper;
	@Override
	public int addPic(SoftPic pic) {
		// TODO Auto-generated method stub
		if (pic!=null && pic.getPicLink()!=null){
			return softPicMapper.insert(pic);
		}
		return 0;
	}

	@Override
	public int delPicByPid(int pid) {
		// TODO Auto-generated method stub
		return softPicMapper.deleteByPrimaryKey(pid);
		
	}

	@Override
	public int delPicBySid(int sid) {
		// TODO Auto-generated method stub
		SoftPicExample example = new SoftPicExample();
		Criteria criteria = example.createCriteria();
		criteria.andPicSoftIdEqualTo(sid);
		return softPicMapper.deleteByExample(example);
	}

	@Override
	public int updatePic(SoftPic pic) {
		// TODO Auto-generated method stub
		softPicMapper.updateByPrimaryKey(pic);
		return 0;
	}

	@Override
	public List<SoftPic> getPicBySid(int sid) {
		// TODO Auto-generated method stub
		SoftPicExample example = new SoftPicExample();
		Criteria criteria = example.createCriteria();
		criteria.andPicSoftIdEqualTo(sid);
		return softPicMapper.selectByExample(example);
		
	}

	
}
