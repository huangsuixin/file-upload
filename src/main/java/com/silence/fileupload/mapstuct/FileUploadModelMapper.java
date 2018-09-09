package com.silence.fileupload.mapstuct;

import com.silence.fileupload.domain.FileDO;
import com.silence.fileupload.entity.dto.FileDTO;
import org.mapstruct.Mapper;

/**
 * @author silence
 * @version 1.0
 * @className FileUploadModelMapper
 * @date 2018/08/18 下午12:54
 * @description do <=> dto
 * @program file-save2Disk
 */
@Mapper(componentModel = "spring")
public interface FileUploadModelMapper {


    FileDO mapFileDO(FileDTO fileDTO);
}
