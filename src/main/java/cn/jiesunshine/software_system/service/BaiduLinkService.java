package cn.jiesunshine.software_system.service;


import cn.jiesunshine.software_system.entity.BaiduLink;

public interface BaiduLinkService {
	/***
	 * 增加一个百度网盘地址
	 * @param sid
	 * @param link
	 * @param type
	 * @return
	 */
	int addBaiduLink(BaiduLink bLink);
	/***
	 * 删除网盘地址通过id
	 * @param id
	 * @return
	 */
	int delBaiduLinkById(int id);
	/***
	 * 删除网盘地址通过软件sid
	 * @param sid
	 * @return
	 */
	int delBaiduLinkBySid(int sid);
	/***
	 * 更新网盘地址
	 * @param bLink
	 * @return
	 */
	int updateBaiduLinkById(BaiduLink bLink);
	/***
	 * 更新网盘地址，通过软件id
	 * @param bLink
	 * @return
	 */
	int updateBaiduLinkBySid(BaiduLink bLink);
	/***
	 * 获取一个网盘地址通过id
	 * @param id
	 * @return
	 */
	BaiduLink getBaiduLinkById(int id);
	/***
	 * 获取网盘地址通过sid
	 * @param id
	 * @return
	 */
	BaiduLink getBaiduLinkBySid(int sid);
}
