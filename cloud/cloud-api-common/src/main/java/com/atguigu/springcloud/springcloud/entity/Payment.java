package com.atguigu.springcloud.springcloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
@ApiModel("请求参数")
public class Payment implements Serializable {
    private static final long serialVersionUID = 7626132878575243872L;
    /**
     * 可能用的上：
     *
     * @TableId(type = IdType.ASSIGN_UUID)
     * @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
     * @TableField(exist = false)
     */

    @ApiModelProperty(name = "id")
    private Integer id;

    @ApiModelProperty(name = "serial")
    private String serial;

}