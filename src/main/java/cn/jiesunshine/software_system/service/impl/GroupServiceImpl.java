package cn.jiesunshine.software_system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiesunshine.software_system.dao.SoftGroupMapper;
import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.SoftGroup;
import cn.jiesunshine.software_system.entity.SoftGroupExample;
import cn.jiesunshine.software_system.entity.SoftGroupExample.Criteria;
import cn.jiesunshine.software_system.enums.GroupStateEnum;
import cn.jiesunshine.software_system.service.GroupService;
@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private SoftGroupMapper groupMapper;
	@Override
	public Execution<SoftGroup> getGroupById(int id) {
		// TODO Auto-generated method stub
		SoftGroup group = groupMapper.selectByPrimaryKey(id);
		if (group!=null){
			return new Execution<SoftGroup>(GroupStateEnum.SUCCESS, group);
		}else {
			return new Execution<SoftGroup>(GroupStateEnum.GROUP_NO_EXIST);
		}
	}

	@Override
	public Execution<SoftGroup> getGroupByName(String name) {
		// TODO Auto-generated method stub
		SoftGroupExample gExample = new SoftGroupExample();
		Criteria criteria = gExample.createCriteria();
		criteria.andGroupNameEqualTo(name);
		List<SoftGroup> groups = groupMapper.selectByExample(gExample);
		if (groups!=null && groups.size()>0){
			return new Execution<SoftGroup>(GroupStateEnum.SUCCESS,groups.get(0));
		}else {
			return new Execution<SoftGroup>(GroupStateEnum.GROUP_NO_EXIST);
		}
	}

	@Override
	public Execution<List<SoftGroup>> getGroups() {
		// TODO Auto-generated method stub
		SoftGroupExample gExample = new SoftGroupExample();
		List<SoftGroup> groups = groupMapper.selectByExample(gExample);
		if (groups!=null && groups.size()>0){
			return new Execution<List<SoftGroup>>(GroupStateEnum.SUCCESS,groups);
		}else {
			return new Execution<List<SoftGroup>>(GroupStateEnum.NO_GROUP);
		}
	}

	@Override
	public Execution<SoftGroup> addGroup(SoftGroup group) {
		// TODO Auto-generated method stub
		SoftGroupExample gExample = new SoftGroupExample();
		Criteria criteria = gExample.createCriteria();
		criteria.andGroupNameEqualTo(group.getGroupName());
		List<SoftGroup> groups = groupMapper.selectByExample(gExample);
		if (groups!=null && groups.size()>0){
			return new Execution<SoftGroup>(GroupStateEnum.NAME_REPEAT);
		}else {
			if (groupMapper.insert(group)>0){
				groups = groupMapper.selectByExample(gExample);
				if (groups!=null && groups.size()>0)
					return new Execution<SoftGroup>(GroupStateEnum.SUCCESS,groups.get(0));
			}else {
				return new Execution<SoftGroup>(GroupStateEnum.INNER_ERROR);
			}
			
		}
		return new Execution<SoftGroup>(GroupStateEnum.INNER_ERROR);
	}

	@Override
	public Execution<SoftGroup> deleteGroup(int id) {
		// TODO Auto-generated method stub
		if (groupMapper.deleteByPrimaryKey(id)>0){
			return new Execution<SoftGroup>(GroupStateEnum.SUCCESS,null);
		}else {
			return new Execution<SoftGroup>(GroupStateEnum.GROUP_NO_EXIST);
		}
	}

	@Override
	public Execution<SoftGroup> updateGroup(SoftGroup group) {
		// TODO Auto-generated method stub
		if (groupMapper.updateByPrimaryKey(group)>0){
			SoftGroup group_new = groupMapper.selectByPrimaryKey(group.getGroupId());
			if (group_new!=null)
				return new Execution<SoftGroup>(GroupStateEnum.SUCCESS,group_new);
		}else {
			return new Execution<SoftGroup>(GroupStateEnum.GROUP_NO_EXIST);
		}
		return new Execution<SoftGroup>(GroupStateEnum.INNER_ERROR);
	}

}
