package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName task
 */
@TableName(value ="task")
@Data
public class Task {

    @TableId
    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    private Long projectId;
}