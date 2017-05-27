package cn.jiesunshine.software_system.service;

import java.util.List;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.SoftGroup;

/***
 * 分类业务接口
 * @author xiaojie119120
 *
 */
public interface GroupService {
	/***
	 * 通过id获取一个分类
	 * @param id
	 * @return
	 */
	public Execution<SoftGroup> getGroupById(int id);
	/***
	 * 通过分类名获取一个分类
	 * @param name
	 * @return
	 */
	public Execution<SoftGroup> getGroupByName(String name);
	/***
	 * 获取全部分类列表
	 * @return
	 */
	public Execution<List<SoftGroup>> getGroups();
	/***
	 * 增加一个分类
	 * @param group
	 * @return
	 */
	public Execution<SoftGroup> addGroup(SoftGroup group);
	/***
	 * 通过id删除一个分类
	 * @param id
	 * @return
	 */
	public Execution<SoftGroup> deleteGroup(int id);
	/***
	 * 更新一个分类
	 * @param group
	 * @return
	 */
	public Execution<SoftGroup> updateGroup(SoftGroup group);
}
