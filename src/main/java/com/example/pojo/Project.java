package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName project
 */
@TableName(value ="project")
@Data
public class Project {

    @TableId
    private Long id;

    private String name;

    private String description;
}