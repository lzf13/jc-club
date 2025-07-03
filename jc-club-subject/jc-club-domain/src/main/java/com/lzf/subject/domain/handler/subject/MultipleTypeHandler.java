package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.convert.MultipleSubjectConverter;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.infra.basic.entity.SubjectMultiple;
import com.lzf.subject.infra.basic.service.SubjectMultipleService;
import jakarta.annotation.Resource;

import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */public class MultipleTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectMultipleService subjectMultipleService;

    // 多选题目的处理逻辑
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    /**
     * 添加多选题目
     * @param subjectInfoBO
     */
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);
            //相当于一个utils的转换，把BO里面的数据转换成Mul里面的存在的那些属性。
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);


    }
}
