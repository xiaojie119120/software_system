package cn.jiesunshine.software_system.dao;

import cn.jiesunshine.software_system.entity.SgSoftGroup;
import cn.jiesunshine.software_system.entity.SgSoftGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SgSoftGroupMapper {
    int countByExample(SgSoftGroupExample example);

    int deleteByExample(SgSoftGroupExample example);

    int deleteByPrimaryKey(Integer sgId);

    int insert(SgSoftGroup record);

    int insertSelective(SgSoftGroup record);

    List<SgSoftGroup> selectByExample(SgSoftGroupExample example);

    SgSoftGroup selectByPrimaryKey(Integer sgId);

    int updateByExampleSelective(@Param("record") SgSoftGroup record, @Param("example") SgSoftGroupExample example);

    int updateByExample(@Param("record") SgSoftGroup record, @Param("example") SgSoftGroupExample example);

    int updateByPrimaryKeySelective(SgSoftGroup record);

    int updateByPrimaryKey(SgSoftGroup record);
}