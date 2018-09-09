package com.silence.fileupload.dao;

import com.silence.fileupload.domain.FileDO;
import com.silence.fileupload.domain.FileDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface FileDOMapper {
    long countByExample(FileDOExample example);

    int deleteByExample(FileDOExample example);

    int insert(FileDO record);

    int insertSelective(FileDO record);

    List<FileDO> selectByExample(FileDOExample example);

    int updateByExampleSelective(@Param("record") FileDO record, @Param("example") FileDOExample example);

    int updateByExample(@Param("record") FileDO record, @Param("example") FileDOExample example);
}