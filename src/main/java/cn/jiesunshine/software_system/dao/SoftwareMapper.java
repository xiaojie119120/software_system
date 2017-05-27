package cn.jiesunshine.software_system.dao;

import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.SoftwareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoftwareMapper {
    int countByExample(SoftwareExample example);

    int deleteByExample(SoftwareExample example);

    int deleteByPrimaryKey(Integer softId);

    int insert(Software record);

    int insertSelective(Software record);

    List<Software> selectByExampleWithBLOBs(SoftwareExample example);

    List<Software> selectByExample(SoftwareExample example);

    Software selectByPrimaryKey(Integer softId);

    int updateByExampleSelective(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByExampleWithBLOBs(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByExample(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByPrimaryKeySelective(Software record);

    int updateByPrimaryKeyWithBLOBs(Software record);

    int updateByPrimaryKey(Software record);
}