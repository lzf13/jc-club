package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.convert.JudgeSubjectConverter;
import com.lzf.subject.domain.convert.MultipleSubjectConverter;
import com.lzf.subject.domain.entity.SubjectAnswerBO;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.entity.SubjectOptionBO;
import com.lzf.subject.infra.basic.entity.SubjectBrief;
import com.lzf.subject.infra.basic.entity.SubjectJudge;
import com.lzf.subject.infra.basic.entity.SubjectMultiple;
import com.lzf.subject.infra.basic.service.SubjectJudgeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断题目的策略类
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

     @Resource
     private SubjectJudgeService subjectJudgeService;



    // 判断题目的处理逻辑
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //判断题目的插入
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectJudgeService.insert(subjectJudge);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
//        SubjectJudge subjectJudge = subjectJudgeService.queryById(Long.valueOf(subjectId));
//        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
//        subjectOptionBO.setSubjectAnswer(subjectJudge.getSubjectAnswer());
//
//        return subjectOptionBO;
        return null;
    }
}
