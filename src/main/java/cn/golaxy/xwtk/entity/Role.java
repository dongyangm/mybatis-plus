package cn.golaxy.xwtk.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


/**
 * @author LENOVO
 */
@Data
@TableName(value = "role_info_test")
public class Role extends BaseEntity{
    @TableId
    private Long id;
    private String name;
}
