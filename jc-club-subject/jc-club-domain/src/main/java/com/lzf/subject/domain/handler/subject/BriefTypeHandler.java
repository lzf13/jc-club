package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.convert.BriefSubjectConverter;
import com.lzf.subject.domain.entity.SubjectAnswerBO;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.entity.SubjectOptionBO;
import com.lzf.subject.infra.basic.entity.SubjectBrief;
import com.lzf.subject.infra.basic.entity.SubjectJudge;
import com.lzf.subject.infra.basic.service.SubjectBriefService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 简答题目的策略类
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
     @Resource
     private SubjectBriefService subjectBriefService;

    // 简答题目的处理逻辑
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //简答题的插入数据操作

        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);


    }

    @Override
    public SubjectOptionBO query(int subjectId) {
//        SubjectBrief subjectBrief = subjectBriefService.queryById((long) subjectId);
//        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
//        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
//
//        return subjectOptionBO;
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId((long) subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
