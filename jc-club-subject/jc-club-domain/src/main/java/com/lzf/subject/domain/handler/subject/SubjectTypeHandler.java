package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.entity.SubjectOptionBO;
import com.lzf.subject.infra.basic.service.SubjectInfoService;

/**
 * 类型获取逻辑接口
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
public interface SubjectTypeHandler {
    /**
     * 获取处理逻辑类型，枚举身份的识别
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();
    /**
     * 实际题目的插入
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 题目详情
     */
    SubjectOptionBO query(int subjectId);
}
