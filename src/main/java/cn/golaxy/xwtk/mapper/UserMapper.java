package cn.golaxy.xwtk.mapper;

import cn.golaxy.xwtk.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author LENOVO
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findList();

    IPage<User> selectUserPage(Page<?>page,Integer grade);
}
