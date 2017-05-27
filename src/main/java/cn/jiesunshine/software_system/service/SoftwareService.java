package cn.jiesunshine.software_system.service;

import java.util.Date;
import java.util.List;

import cn.jiesunshine.software_system.dto.Execution;
import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.SoftwareExtend;

/***
 * 软件业务接口
 * @author xiaojie119120
 *
 */
public interface SoftwareService {
	/***
	 * 通过软件id获取软件
	 * @param id
	 * @return
	 */
	public Execution<Software> getSoftwareById(int id);
	/***
	 * 通过软件id获取软件字段更多
	 * @param id
	 * @return
	 */
	public Execution<SoftwareExtend> getSoftwareExtendById(int id);
	/***
	 * 通过软件名获取软件
	 * @param name
	 * @return
	 */
	public Execution<Software> getSoftwarebyName(String name);
	/***
	 * 增加一个软件
	 * @param software
	 * @return
	 */
	public Execution<Software> addSoftware(Software software);
	/***
	 * 通过id删除软件
	 * @param id
	 * @return
	 */
	public Execution<Software> deleteSoftware(int id);
	/***
	 * 通过software.id更新软件信息
	 * @param software
	 * @return
	 */
	public Execution<Software> updateSoftware(Software software);
	/***
	 * 通过用户ID获取软件列表
	 * @param uid
	 * @param page
	 * @return
	 */
	public Execution<List<Software>> getSoftwaresByUserId(int uid,int page);
	/***
	 * 通过软件名关键字获取软件列表
	 * @param sname
	 * @param page
	 * @return
	 */
	public Execution<List<Software>> getSoftwaresBySoftNameLike(String sname,int page);
	/***
	 * 通过类别id获取软件列表
	 * @param gid
	 * @param page
	 * @return
	 */
	public Execution<List<Software>> getSoftwaresByGroupId(int gid,int page);
	/***
	 * 获取最新更新的软件
	 * @param page
	 * @param num
	 * @return
	 */
	public Execution<List<Software>> getNewSoftware(int page , int num);
	/***
	 * 通过软件id和uid删除软件，必须id和uid都正确才能删除成功
	 * @param id
	 * @param uid
	 * @return
	 */
	public Execution<Software> deleteSoftwareByIdAndUid(int id,int uid);
	/***
	 * 获取某一日更新的软件
	 * @param date
	 * @param page
	 * @param num
	 * @return
	 */
	public Execution<List<Software>> getSoftwaresByDate(Date date,int page , int num);
	/***
	 * 通过id下载软件
	 * @param id
	 * @return
	 */
	public Execution<Software> downSoftwaresById(int id);
	/***
	 * 获得所有软件，只给管理员调用
	 * @param page
	 * @return
	 */
	Execution<List<Software>> getAllSoftwares(int page);
	/***
	 * 通过下载量排序软件
	 * @param page
	 * @return
	 */
	Execution<List<Software>> getSoftwaresByDown(int page);
}
