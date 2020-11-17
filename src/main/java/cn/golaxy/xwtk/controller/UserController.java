package cn.golaxy.xwtk.controller;

import cn.golaxy.xwtk.entity.User;
import cn.golaxy.xwtk.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LENOVO
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserMapper mapper;

    @GetMapping("findList")
    public List<User> findList(){
        return mapper.findList();
    }
}
