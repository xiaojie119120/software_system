package cn.jiesunshine.software_system.dao;

import cn.jiesunshine.software_system.entity.SoftGroup;
import cn.jiesunshine.software_system.entity.SoftGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoftGroupMapper {
    int countByExample(SoftGroupExample example);

    int deleteByExample(SoftGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(SoftGroup record);

    int insertSelective(SoftGroup record);

    List<SoftGroup> selectByExample(SoftGroupExample example);

    SoftGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") SoftGroup record, @Param("example") SoftGroupExample example);

    int updateByExample(@Param("record") SoftGroup record, @Param("example") SoftGroupExample example);

    int updateByPrimaryKeySelective(SoftGroup record);

    int updateByPrimaryKey(SoftGroup record);
}