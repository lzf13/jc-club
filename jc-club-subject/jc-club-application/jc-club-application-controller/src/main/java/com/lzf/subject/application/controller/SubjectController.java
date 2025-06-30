package com.lzf.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lzf.subject.application.convert.SubjectAnswerDTOConverter;
import com.lzf.subject.application.convert.SubjectCategoryDTOConverter;
import com.lzf.subject.application.convert.SubjectInfoDTOConverter;
import com.lzf.subject.application.dto.SubjectCategoryDTO;
import com.lzf.subject.application.dto.SubjectInfoDTO;
import com.lzf.subject.common.entity.Result;
import com.lzf.subject.domain.entity.SubjectAnswerBO;
import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 刷题controller
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/22
 */
@RestController
@Slf4j
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Autowired
    private SubjectAnswerDTOConverter subjectAnswerDTOConverter;

    /**
     * 新增题目
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            //这里可以用全局异常处理来做
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                    , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                    , "标签id不能为空");

            SubjectInfoBO subjectInfoBO =
                    SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = subjectAnswerDTOConverter.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);


            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }

    }



}
