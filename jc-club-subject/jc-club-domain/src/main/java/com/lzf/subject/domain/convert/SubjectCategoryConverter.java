package com.lzf.subject.domain.convert;

import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
//拦截器
@Mapper// 必须指定 componentModel
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);


}
