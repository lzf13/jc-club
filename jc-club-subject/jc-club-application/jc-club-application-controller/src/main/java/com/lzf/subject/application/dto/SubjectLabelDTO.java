package com.lzf.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-06-22 11:38:38
 */
@Data
public class SubjectLabelDTO implements Serializable {
//    private static final long serialVersionUID = 494938012020364962L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;





}

