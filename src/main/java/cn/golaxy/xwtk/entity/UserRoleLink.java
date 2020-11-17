package cn.golaxy.xwtk.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LENOVO
 */
@Data
@TableName("user_role_link")
public class UserRoleLink extends BaseEntity{
    @TableId
    private Long id;
    private Long userId;
    private Long roleId;
}
