package cn.golaxy.xwtk.entity;

import cn.golaxy.xwtk.enums.AgeEnum;
import cn.golaxy.xwtk.enums.GradeEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author LENOVO
 */
@Data
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;
    private AgeEnum age;
    private Date createTime;
    private GradeEnum grade;
    private Integer score;
    @TableLogic
    private Integer isDeleted;
}
