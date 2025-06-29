package com.lzf.subject.domain.convert;

import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.entity.SubjectLabelBO;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
//拦截器
@Mapper// 必须指定 componentModel
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertBoToLabel(List<SubjectLabel> labelList);


}
