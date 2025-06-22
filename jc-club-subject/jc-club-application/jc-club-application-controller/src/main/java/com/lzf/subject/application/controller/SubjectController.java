package com.lzf.subject.application.controller;

import com.lzf.subject.infra.basic.entity.SubjectCategory;
import com.lzf.subject.infra.basic.service.SubjectCategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);

        return subjectCategory.getCategoryName();
    }


}
