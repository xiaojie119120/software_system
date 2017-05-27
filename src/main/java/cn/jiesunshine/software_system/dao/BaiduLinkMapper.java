package cn.jiesunshine.software_system.dao;

import cn.jiesunshine.software_system.entity.BaiduLink;
import cn.jiesunshine.software_system.entity.BaiduLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaiduLinkMapper {
    int countByExample(BaiduLinkExample example);

    int deleteByExample(BaiduLinkExample example);

    int deleteByPrimaryKey(Integer bdId);

    int insert(BaiduLink record);

    int insertSelective(BaiduLink record);

    List<BaiduLink> selectByExample(BaiduLinkExample example);

    BaiduLink selectByPrimaryKey(Integer bdId);

    int updateByExampleSelective(@Param("record") BaiduLink record, @Param("example") BaiduLinkExample example);

    int updateByExample(@Param("record") BaiduLink record, @Param("example") BaiduLinkExample example);

    int updateByPrimaryKeySelective(BaiduLink record);

    int updateByPrimaryKey(BaiduLink record);
}