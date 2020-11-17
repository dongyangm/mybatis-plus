package cn.golaxy.xwtk.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.util.Date;

/**
 * @author LENOVO
 */
public class BaseEntity {
    @TableLogic
    private Integer isDeleted;
    private Date createTime;
}
