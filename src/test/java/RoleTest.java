import cn.golaxy.xwtk.entity.Role;
import cn.golaxy.xwtk.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = cn.golaxy.xwtk.Application.class)
@Slf4j
public class RoleTest {

    public static final Gson gson = new Gson();

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void save(){
        Role role = new Role();
        role.setName("老师");
        roleMapper.insert(role);
        log.info("result is {}",gson.toJson(role));
    }

    @Test
    public void delete(){
        int i = roleMapper.deleteById(1328618977863729154L);
        log.info("result is {}",gson.toJson(i));
    }

}
