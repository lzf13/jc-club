package com.lzf.subject.infra.basic.service;

import com.lzf.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
 * 多选题信息表(SubjectMultiple)表服务接口
 *
 * @author makejava
 * @since 2025-06-30 19:38:06
 */
public interface SubjectMultipleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple insert(SubjectMultiple subjectMultiple);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入数据
     *
     * @param subjectMultipleList 实例对象
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);

    /**
     * 条件查询
     *
     * @param subjectMultiple 筛选条件
     * @return 查询结果
     */
    List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple);
}
