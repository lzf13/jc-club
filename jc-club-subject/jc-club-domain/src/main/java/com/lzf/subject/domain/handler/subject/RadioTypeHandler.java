package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.entity.SubjectInfoBO;

/**
 * 单选的题目的策略类
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
public class RadioTypeHandler implements SubjectTypeHandler{
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        //单选的类
        return SubjectInfoTypeEnum.RADIO;
    }

    /**
     * 添加单选题目
     * @param subjectInfoBO
     */
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {

    }
}
