package com.lzf.subject.application.convert;

import com.lzf.subject.application.dto.SubjectCategoryDTO;
import com.lzf.subject.application.dto.SubjectLabelDTO;
import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
@Mapper

public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    List<SubjectLabelDTO> convertBoToLabelDTOList(List<SubjectLabelBO> subjectLabelDTO);

    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    SubjectLabelDTO convertBoToLabelDTO(SubjectLabelBO subjectLabelBO);



}
