package com.lzf.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.domain.convert.SubjectInfoConverter;
import com.lzf.subject.domain.convert.SubjectLabelConverter;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.service.SubjectInfoDomainService;
import com.lzf.subject.infra.basic.entity.SubjectInfo;
import com.lzf.subject.infra.basic.entity.SubjectLabel;


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


    /**
     * 添加
     *
     * @param subjectInfoBO
     */
    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectController.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }

    }




}



