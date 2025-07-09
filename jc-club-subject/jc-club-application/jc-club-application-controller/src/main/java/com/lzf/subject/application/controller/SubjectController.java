package com.lzf.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lzf.subject.application.convert.SubjectAnswerDTOConverter;
import com.lzf.subject.application.convert.SubjectCategoryDTOConverter;
import com.lzf.subject.application.convert.SubjectInfoDTOConverter;
import com.lzf.subject.application.dto.SubjectCategoryDTO;
import com.lzf.subject.application.dto.SubjectInfoDTO;
import com.lzf.subject.common.entity.PageResult;
import com.lzf.subject.common.entity.Result;
import com.lzf.subject.domain.entity.SubjectAnswerBO;
import com.lzf.subject.domain.entity.SubjectCategoryBO;
import com.lzf.subject.domain.entity.SubjectInfoBO;
import com.lzf.subject.domain.service.SubjectInfoDomainService;
import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 刷题controller
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/22
 */
@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {




    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

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

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS =
                    SubjectAnswerDTOConverter.INSTANCE.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }

    }

    /**
     * 查询题目列表，分页查询
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            //这里可以用全局异常处理来做
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);

            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.getSubjectPage.error:{}", e.getMessage(), e);
            return Result.fail("查询题目失败");
        }

    }


    /**
     * 查询题目详细信息
     * @param subjectInfoDTO
     * @return
     * @date 2025/6/22
     * @author luozhifeng
     * @version 1.0
     * **/
    @PostMapping("/querySubjectInfo")
    public Result<PageResult> querySubjectInfoe(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            //这里可以用全局异常处理来做

            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDTOToBO(subjectInfoDTO);

            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);

            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSTANCE.convertBOToDTO(boResult);

            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectCategoryController.querySubjectInfo.error:{}", e.getMessage(), e);
            return Result.fail("查询题目失败");
        }

    }




}
