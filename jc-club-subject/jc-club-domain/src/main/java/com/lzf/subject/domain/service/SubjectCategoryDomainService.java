package com.lzf.subject.domain.service;

import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);




    /**
     * 查询分类
     *
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 修改分类
     *
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);
}
