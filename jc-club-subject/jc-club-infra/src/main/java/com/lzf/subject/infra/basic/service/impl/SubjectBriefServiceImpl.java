package com.lzf.subject.infra.basic.service.impl;

import com.lzf.subject.infra.basic.entity.SubjectBrief;
import com.lzf.subject.infra.basic.mapper.SubjectBriefDao;
import com.lzf.subject.infra.basic.service.SubjectBriefService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 简答题(SubjectBrief)表服务实现类
 *
 * @author makejava
 * @since 2025-06-30 19:37:16
 */
@Service("subjectBriefService")
@Slf4j
public class SubjectBriefServiceImpl implements SubjectBriefService {
    @Resource
    private SubjectBriefDao subjectBriefDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectBrief queryById(Long id) {
//        return this.subjectBriefDao.queryById(id);
        log.info("DAO查询ID: {}", id);
        SubjectBrief brief = subjectBriefDao.queryById(id);
        log.info("DAO返回结果: {}", brief != null ? brief.toString() : "NULL");
        return brief;
    }


    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefDao.insert(subjectBrief);
        return subjectBrief;
    }

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief update(SubjectBrief subjectBrief) {
        this.subjectBriefDao.update(subjectBrief);
        return this.queryById(subjectBrief.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectBriefDao.deleteById(id) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param subjectBrief 实例对象
     * @return 对象列表
     * @since 2025-06-30 19:37:16
     * **/
    @Override
    public SubjectBrief queryByCondition(SubjectBrief subjectBrief) {
        return this.subjectBriefDao.queryAllByLimit(subjectBrief);
    }
}
