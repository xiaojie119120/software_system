package cn.jiesunshine.software_system.dao;

import cn.jiesunshine.software_system.entity.SoftPic;
import cn.jiesunshine.software_system.entity.SoftPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoftPicMapper {
    int countByExample(SoftPicExample example);

    int deleteByExample(SoftPicExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(SoftPic record);

    int insertSelective(SoftPic record);

    List<SoftPic> selectByExample(SoftPicExample example);

    SoftPic selectByPrimaryKey(Integer picId);

    int updateByExampleSelective(@Param("record") SoftPic record, @Param("example") SoftPicExample example);

    int updateByExample(@Param("record") SoftPic record, @Param("example") SoftPicExample example);

    int updateByPrimaryKeySelective(SoftPic record);

    int updateByPrimaryKey(SoftPic record);
}