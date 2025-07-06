package com.lzf.subject.domain.service;

import com.lzf.subject.common.entity.PageResult;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */

public interface SubjectInfoDomainService {

    /**
     * 新增题目
     * @param subjectInfoBO
     */
    void add(SubjectInfoBO subjectInfoBO);


    /**
     * 分页查询题目列表
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目详情
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
