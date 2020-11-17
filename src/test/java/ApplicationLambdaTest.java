import cn.golaxy.xwtk.entity.User;
import cn.golaxy.xwtk.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = cn.golaxy.xwtk.Application.class)
@Slf4j
public class ApplicationLambdaTest {

    public static final Gson gson = new Gson();

    @Resource
    private UserMapper mapper;

    @Test
    public void findByCondition(){
        /*eq测试*/
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","张三");
        List<User> user = mapper.selectList(wrapper);
        log.info("eq is {} ",gson.toJson(user));

        LambdaQueryWrapper<User> queryWrapperLambda = new LambdaQueryWrapper<>();
        queryWrapperLambda.eq(User::getName,"张三");
        List<User> userLambda = mapper.selectList(queryWrapperLambda);
        log.info(" lambda eq is {}",gson.toJson(userLambda));

        /*like*/
        QueryWrapper<User> wrappers = new QueryWrapper<>();
        List<User> users = mapper.selectList(wrappers.like("name","测试"));
        log.info("like is {}",gson.toJson(users));
        LambdaQueryWrapper<User> wrappersLambda = new LambdaQueryWrapper<User>();
         wrappersLambda.like(User::getName, "测试");
        List<User> usersLambda = mapper.selectList(wrappersLambda);
        log.info("lambda like is {} ",gson.toJson(usersLambda));

        /*between*/
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        List<User> users1 = mapper.selectList(wrapper1.between("age",0,10));
        log.info("数值between: {}",gson.toJson(users1));
        LambdaQueryWrapper<User> wrapper1Lambda = new LambdaQueryWrapper<User>();
        wrapper1Lambda.between(User::getAge,0,10);
        List<User> users1Lambda = mapper.selectList(wrapper1Lambda);
        log.info("lambda 数值between: {}",gson.toJson(users1Lambda));

        /**日期between*/
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper2.between("create_time",new Date(1605578072000L),new Date());
        List<User> users2 = mapper.selectList(wrapper2);
        log.info("时间范围查询：{}",gson.toJson(users2));
        LambdaQueryWrapper<User> wrapper2Lambda = new LambdaQueryWrapper<User>();
        wrapper2Lambda.between(User::getCreateTime,new Date(1605578072000L),new Date());
        List<User> users2Lambda = mapper.selectList(wrapper2Lambda);
        log.info("时间范围查询：{}",gson.toJson(users2Lambda));
    }
}
