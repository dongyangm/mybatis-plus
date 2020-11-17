import cn.golaxy.xwtk.entity.User;
import cn.golaxy.xwtk.enums.GradeEnum;
import cn.golaxy.xwtk.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class ApplicationTest {
    public static final Gson gson = new Gson();

    @Resource
    private UserMapper mapper;

    @Test
    public void save(){
        User u = new User();
        u.setName("测试自定义ID生成器");
        u.setGrade(GradeEnum.HIGH);
        int insert = mapper.insert(u);
        log.info("insert is {}",insert);
    }

    @Test
    public void update(){
        User u = new User();
        u.setId(1328516927704363009L);
        u.setName("浩二二");
        int i = mapper.updateById(u);
        log.info("update is {}",i);
    }

    @Test
    public void updateByCondition(){
        User u = new User();
        u.setGrade(GradeEnum.HIGH);
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.isNull("grade");
        int update = mapper.update(u, wrapper);
        log.info("update is {}",update);
    }

    @Test
    public void delete(){
        int i = mapper.deleteById(1328534387274915841L);
        log.info("delete is {}",i);
    }

    @Test
    public void selectById(){
        User user = mapper.selectById(1328534387274915841L);
        log.info(user.toString());
    }

    @Test
    public void findList(){
        List<User> user = mapper.findList();
        System.out.println(gson.toJson(user));
    }

    /**
     * 条件查询
     */
    @Test
    public void findByCondition(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> user = mapper.selectList(wrapper.eq("name","张三"));
        log.info("eq: {}",gson.toJson(user));

        QueryWrapper<User> wrappers = new QueryWrapper<>();
        List<User> users = mapper.selectList(wrappers.like("name","66"));
        log.info("like: {}",gson.toJson(users));

        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        List<User> users1 = mapper.selectList(wrapper1.between("age",0,10));
        log.info("数值between: {}",gson.toJson(users1));

        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper1.between("create_time",new Date(1605578072000L),new Date());
        List<User> users2 = mapper.selectList(wrapper2);
        log.info("时间范围查询：{}",gson.toJson(users2));
    }

    @Test
    public void selectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "66");

        Integer count = mapper.selectCount(queryWrapper);
        log.info("result is {}",gson.toJson(count));
    }

    @Test
    public void selectList() {
        List<User> list = mapper.selectList(null);
        log.info("result is {}",gson.toJson(list));
    }

    /**
     * 分页
     */
    @Test
    public void selectPage() {
       /* 不查询总记录数,只查询分页后的结果*/
//        IPage<User> page = new Page<>(1, 2,false);//
        /* 查询总记录数,总页数需要调用getPages()方法，实际是根据总条数和每一页大小计算*/
        IPage<User> page = new Page<>(1, 2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        IPage<User> userIPage = mapper.selectPage(page, queryWrapper);
        log.info("pages is {}",userIPage.getPages());
        log.info("result is {}",gson.toJson(userIPage));
    }

    /**
     * 自定义分页方法
     */
    @Test
    public void selectUserPage(){
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = mapper.selectUserPage(page, 3);
        log.info("result is {}",gson.toJson(userIPage));
    }

    /**
     * LambdaQueryWrapper的几种创建方式
     */
    @Test
    public void testChain1(){
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambda1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> lambda2 = Wrappers.<User>lambdaQuery();
        lambda.like(User::getName,"测试").lt(User::getGrade,3);
        List<User> users = mapper.selectList(lambda);
        log.info("result is {}",gson.toJson(users));
    }

    /**
     * 链式编程
     */
    @Test
    public void testChain2(){
        List<User> users = new LambdaQueryChainWrapper<User>(mapper)
                .like(User::getName, "测试")
                .lt(User::getGrade, 3)
                .list();
        log.info("result is {}",gson.toJson(users));
    }

    /**
     * 链式编程分页
     */
    @Test
    public void testChain3page(){
        Page<User> page = new LambdaQueryChainWrapper<User>(mapper)
                .like(User::getName, "测试")
                .lt(User::getGrade, 3)
                .page(new Page<User>(1, 5));
        log.info("result is {}",gson.toJson(page));
    }
}
