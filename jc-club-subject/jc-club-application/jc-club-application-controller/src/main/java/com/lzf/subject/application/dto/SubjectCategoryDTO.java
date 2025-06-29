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

public class SubjectCategoryDTO implements Serializable {
//    private static final long serialVersionUID = 494938012020364962L;
/**
     * 主键
     */
    private Long id;
/**
     * 分类名称
     */
    private String categoryName;
/**
     * 分类类型
     */
    private Integer categoryType;
/**
     * 图标连接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Long parentId;

/**
     * 是否删除 0: 未删除 1: 已删除
     */
//    private Integer isDeleted;




}

