package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.entity.SubjectInfoBO;

/**
 * 判断题目的策略类
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */public class JudgeTypeHandler implements SubjectTypeHandler{
    // 多选题目的处理逻辑
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }
}
