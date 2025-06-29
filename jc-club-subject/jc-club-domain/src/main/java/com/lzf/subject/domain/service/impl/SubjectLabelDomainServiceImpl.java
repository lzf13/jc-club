package com.lzf.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzf.subject.common.enums.IsDeletedFlagEnum;
import com.lzf.subject.domain.convert.SubjectCategoryConverter;
import com.lzf.subject.domain.convert.SubjectLabelConverter;
import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.entity.SubjectLabelBO;
import com.lzf.subject.domain.service.SubjectLabelDomainService;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.entity.SubjectLabel;
import com.lzf.subject.infra.basic.entity.SubjectMapping;
import com.lzf.subject.infra.basic.service.SubjectLabelService;
import com.lzf.subject.infra.basic.service.SubjectMappingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/23
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    /**
     * 添加
     *
     * @param subjectLabelBO
     */
    @Override
    public void add(SubjectLabelBO subjectLabelBO) {
//        if (log.isInfoEnabled()) {
//            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
//        }
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelController.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectLabelService.insert(subjectLabel);
    }

    /**
     * 修改
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 删除
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE
                .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());//删除直接设定isdelete为1即可
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 根据分类id查询标签
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        // 获取类别ID
        Long categoryId = subjectLabelBO.getCategoryId();

        // 创建学科映射对象并设置类别ID
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);

        // 设置映射对象的删除状态为未删除
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        // 查询符合当前映射条件的标签ID列表
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);

        // 如果查询结果为空，则直接返回空列表
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }

        // 从映射列表中提取标签ID
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());

        // 根据标签ID列表批量查询标签信息
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);

        // 创建业务对象列表以存储转换后的标签信息
        List<SubjectLabelBO> boList = new LinkedList<>();

        // 遍历标签列表，将每个标签信息转换为业务对象并添加到列表中
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });

        return boList;
    }


}



