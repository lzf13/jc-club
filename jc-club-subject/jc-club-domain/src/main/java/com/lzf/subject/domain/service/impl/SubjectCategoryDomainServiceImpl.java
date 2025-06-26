package com.lzf.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.domain.convert.SubjectCategoryConverter;
import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.service.SubjectCategoryDomainService;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private SubjectCategoryService subjectCategoryService;


    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
//        if (log.isInfoEnabled()) {
//            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
//        }
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    /**
     * 查询分类
     *
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);

        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(boList));
        }
//        boList.forEach(bo -> {
//            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
//            bo.setCount(subjectCount);
//        });
        return boList;
    }

    /**
     * 修改分类
     *
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    /**
     * 删除分类
     *
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }




}



