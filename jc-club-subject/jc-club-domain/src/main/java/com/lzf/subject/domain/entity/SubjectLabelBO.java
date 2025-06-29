package com.lzf.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-06-22 11:38:38
 */
@Data

public class SubjectLabelBO implements Serializable {
//    private static final long serialVersionUID = 494938012020364962L;
/**
 /**
 * 主键
 */
private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;




}

