package com.lzf.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.domain.convert.SubjectInfoConverter;
import com.lzf.subject.domain.convert.SubjectLabelConverter;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.handler.subject.SubjectTypeHandler;
import com.lzf.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.lzf.subject.domain.service.SubjectInfoDomainService;
import com.lzf.subject.infra.basic.entity.SubjectInfo;
import com.lzf.subject.infra.basic.entity.SubjectLabel;


import com.lzf.subject.infra.basic.service.SubjectInfoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    /**
     * 添加
     *
     * @param subjectInfoBO
     */
    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectController.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }

        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

        //
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler((subjectInfo.getSubjectType()));
        handler.add(subjectInfoBO);


    }




}



