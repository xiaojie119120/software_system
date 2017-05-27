package cn.jiesunshine.software_system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiesunshine.software_system.dao.SoftwareDao;
import cn.jiesunshine.software_system.dao.SoftwareMapper;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.ExecutionDataInfo;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.SoftwareExample;
import cn.jiesunshine.software_system.entity.SoftwareExample.Criteria;
import cn.jiesunshine.software_system.entity.SoftwareExtend;
import cn.jiesunshine.software_system.enums.SoftwareStateEnum;
import cn.jiesunshine.software_system.service.SoftwareService;
import cn.jiesunshine.software_system.utils.ListValue;
@Service
public class SoftwareServiceImpl implements SoftwareService {
	@Autowired
	private SoftwareMapper softwareMapper;
	@Autowired
	private SoftwareDao softwareDao;
	@Override
	public Execution<Software> getSoftwareById(int id) {
		// TODO Auto-generated method stub
		Software software = softwareMapper.selectByPrimaryKey(id);
		if (software!=null){
			return new Execution<Software>(SoftwareStateEnum.SUCCESS,software);
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
	}

	@Override
	public Execution<Software> getSoftwarebyName(String name) {
		// TODO Auto-generated method stub
		SoftwareExample sExample = new SoftwareExample();
		Criteria criteria = sExample.createCriteria();
		criteria.andSoftNameEqualTo(name);
		List<Software> softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
		if (softwares!=null && softwares.size()>0){
			return new Execution<Software>(SoftwareStateEnum.SUCCESS,softwares.get(0));
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
	}

	@Override
	public Execution<Software> addSoftware(Software software) {
		// TODO Auto-generated method stub
		SoftwareExample sExample = new SoftwareExample();
		Criteria criteria = sExample.createCriteria();
		criteria.andSoftNameEqualTo(software.getSoftName());
		List<Software> softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
		if (softwares!=null && softwares.size()>0){
			return new Execution<Software>(SoftwareStateEnum.NAME_REPEAT);
		}else {
			if (softwareMapper.insert(software)>0){
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				if (softwares!=null && softwares.size()>0)
					return new Execution<Software>(SoftwareStateEnum.SUCCESS,softwares.get(0));
			}
		}
		return new Execution<Software>(SoftwareStateEnum.INNER_ERROR);
	}

	@Override
	public Execution<Software> deleteSoftware(int id) {
		// TODO Auto-generated method stub
		if (softwareMapper.deleteByPrimaryKey(id)>0){
			return new Execution<Software>(SoftwareStateEnum.SUCCESS,null);
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);			
		}
	}

	@Override
	public Execution<Software> updateSoftware(Software software) {
		// TODO Auto-generated method stub
		if (softwareMapper.updateByPrimaryKeySelective(software)>0){
			Software software_new = softwareMapper.selectByPrimaryKey(software.getSoftId());
			if (software_new!=null)
				return new Execution<Software>(SoftwareStateEnum.SUCCESS,software_new);
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
		return new Execution<Software>(SoftwareStateEnum.INNER_ERROR);
	}

	@Override
	public Execution<List<Software>> getSoftwaresByUserId(int uid, int page) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		SoftwareExample sExample = new SoftwareExample();
		Criteria criteria = sExample.createCriteria();
		criteria.andSoftUserIdEqualTo(uid);
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= ListValue.USERLISTROWS_NUM) {
			sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
					/ ListValue.USERLISTROWS_NUM + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_id limit "+(maxPage - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_id limit "+(page - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}

	@Override
	public Execution<List<Software>> getSoftwaresBySoftNameLike(String sname,
			int page) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		SoftwareExample sExample = new SoftwareExample();
		Criteria criteria = sExample.createCriteria();
		criteria.andSoftNameLike("%"+sname+"%");
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= ListValue.USERLISTROWS_NUM) {
			sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
					/ ListValue.USERLISTROWS_NUM + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_id limit "+(maxPage - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_id limit "+(page - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}

	@Override
	public Execution<List<Software>> getSoftwaresByGroupId(int gid, int page) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		int maxPage = 1;
		SoftwareExample sExample = new SoftwareExample();
		sExample.createCriteria().andSoftGroupIdEqualTo(gid);
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= ListValue.USERLISTROWS_NUM) {
			sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
					/ ListValue.USERLISTROWS_NUM + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_id limit "+(maxPage - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_id limit "+(page - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}
	
	@Override
	public Execution<List<Software>> getNewSoftware(int page , int num) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		SoftwareExample sExample = new SoftwareExample();
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= num) {
			sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit 0,"+num);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % num == 0 ? count / num : count
					/ num + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit 0,"+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit "+(maxPage - 1) * num+","+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit "+(page - 1) * num+","+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}

	@Override
	public Execution<Software> deleteSoftwareByIdAndUid(int id, int uid) {
		// TODO Auto-generated method stub
		SoftwareExample example = new SoftwareExample();
		example.createCriteria().andSoftIdEqualTo(id).andSoftUserIdEqualTo(uid);
		if (softwareMapper.deleteByExample(example)>0){
			return new Execution<Software>(SoftwareStateEnum.SUCCESS, null);
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
	}

	@Override
	public Execution<SoftwareExtend> getSoftwareExtendById(int id) {
		// TODO Auto-generated method stub
		SoftwareExtend softwareExtend = softwareDao.querySoftwareById(id);
		if (softwareExtend==null){
			return new Execution<SoftwareExtend>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
		return new Execution<SoftwareExtend>(SoftwareStateEnum.SUCCESS, softwareExtend);
	}

	@Override
	public Execution<List<Software>> getSoftwaresByDate(Date date, int page,
			int num) {
		List<Software> softwares = null;
		SoftwareExample sExample = new SoftwareExample();
		sExample.createCriteria().andSoftDateEqualTo(date);
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= num) {
			sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit 0,"+num);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % num == 0 ? count / num : count
					/ num + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit 0,"+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit "+(maxPage - 1) * num+","+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_date DESC , pre_update_time DESC , soft_date limit "+(page - 1) * num+","+num);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}

	@Override
	public Execution<Software> downSoftwaresById(int id) {
		// TODO Auto-generated method stub
		Software software = softwareMapper.selectByPrimaryKey(id);
		if (software!=null){
			software.setSoftDownloadVolume(software.getSoftDownloadVolume()+1);
			softwareMapper.updateByPrimaryKeySelective(software);
			return new Execution<Software>(SoftwareStateEnum.SUCCESS,software);
		}else {
			return new Execution<Software>(SoftwareStateEnum.SOFT_NO_EXIST);
		}
	}

	@Override
	public Execution<List<Software>> getAllSoftwares(int page) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		ExecutionDataInfo eInfo = new ExecutionDataInfo();
		SoftwareExample sExample = new SoftwareExample();
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		eInfo.setDataCount(count);
		if (count <= ListValue.USERLISTROWS_NUM) {
			sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			eInfo.setPageCount(maxPage);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,eInfo);
		} else {
			maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
					/ ListValue.USERLISTROWS_NUM + 1;
			eInfo.setPageCount(maxPage);
			if (page <= 1) {
				sExample.setOrderByClause("soft_id limit 0,"+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,eInfo);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_id limit "+(maxPage - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,eInfo);
			} else {
				sExample.setOrderByClause("soft_id limit "+(page - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,eInfo);
			}
		}
	}

	@Override
	public Execution<List<Software>> getSoftwaresByDown(int page) {
		// TODO Auto-generated method stub
		List<Software> softwares = null;
		SoftwareExample sExample = new SoftwareExample();
		int maxPage = 1;
		int count = softwareMapper.countByExample(sExample);
		if (count==0){
			return new Execution<List<Software>>(SoftwareStateEnum.SOFT_NO_FIND);
		}
		if (count <= ListValue.USERLISTROWS_NUM) {
			sExample.setOrderByClause("soft_download_volume DESC , soft_name DESC , soft_download_volume limit 0,"+ListValue.USERLISTROWS_NUM);
			softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
			return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
		} else {
			maxPage = count % ListValue.USERLISTROWS_NUM == 0 ? count / ListValue.USERLISTROWS_NUM : count
					/ ListValue.USERLISTROWS_NUM + 1;
			if (page <= 1) {
				sExample.setOrderByClause("soft_download_volume DESC , soft_name DESC , soft_download_volume limit 0,"+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else if (page >= maxPage) {
				sExample.setOrderByClause("soft_download_volume DESC , soft_name DESC , soft_download_volume limit "+(maxPage - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			} else {
				sExample.setOrderByClause("soft_download_volume DESC , soft_name DESC , soft_download_volume limit "+(page - 1) * ListValue.USERLISTROWS_NUM+","+ListValue.USERLISTROWS_NUM);
				softwares = softwareMapper.selectByExampleWithBLOBs(sExample);
				return new Execution<List<Software>>(SoftwareStateEnum.SUCCESS,softwares,maxPage);
			}
		}
	}

}
