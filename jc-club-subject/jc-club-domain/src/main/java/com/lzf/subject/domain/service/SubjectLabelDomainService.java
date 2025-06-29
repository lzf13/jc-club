package com.lzf.subject.domain.service;

import com.lzf.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */

public interface SubjectLabelDomainService {

    /**
     * 添加
     * @param subjectLabelBO
     */
    void add(SubjectLabelBO subjectLabelBO);


    /**
     * 修改
     * @param subjectLabelBO
     * @return
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除
     * @param subjectLabelBO
     * @return
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类id查询标签
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
