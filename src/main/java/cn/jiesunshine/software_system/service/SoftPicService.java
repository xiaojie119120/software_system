package cn.jiesunshine.software_system.service;

import java.util.List;

import cn.jiesunshine.software_system.entity.SoftPic;

public interface SoftPicService {
	/***
	 * 增加一条图片记录
	 * @param pic
	 * @return
	 */
	int addPic(SoftPic pic);
	/***
	 * 通过图片id删除一条图片记录
	 * @param pid
	 * @return
	 */
	int delPicByPid(int pid);
	/***
	 * 通过软件id删除多条图片记录
	 * @param sid
	 * @return
	 */
	int delPicBySid(int sid);
	/***
	 * 通过pic.picId更新图片信息
	 * @param pic
	 * @return
	 */
	int updatePic(SoftPic pic);
	/***
	 * 通过软件id查找图片
	 * @param sid
	 * @return
	 */
	List<SoftPic> getPicBySid(int sid);
}
