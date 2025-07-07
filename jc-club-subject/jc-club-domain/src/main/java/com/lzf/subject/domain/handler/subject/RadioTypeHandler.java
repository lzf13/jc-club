package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import com.lzf.subject.domain.convert.MultipleSubjectConverter;
import com.lzf.subject.domain.convert.RadioSubjectConverter;
import com.lzf.subject.domain.entity.SubjectAnswerBO;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.entity.SubjectOptionBO;
import com.lzf.subject.infra.basic.entity.SubjectInfo;
import com.lzf.subject.infra.basic.entity.SubjectMultiple;
import com.lzf.subject.infra.basic.entity.SubjectRadio;
import com.lzf.subject.infra.basic.service.SubjectRadioService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * 单选的题目的策略类
 *
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        //单选的类
        return SubjectInfoTypeEnum.RADIO;
    }

    /**
     * 添加单选题目
     *
     * @param subjectInfoBO
     */
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        LinkedList<SubjectRadio> subjectRadioList = new LinkedList<>();
        //填入数据,这里注意，subjectInfoBO.getOptionList()是单选题目的选项,可能为空，需要if判断去校验
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId((long) subjectId);
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
