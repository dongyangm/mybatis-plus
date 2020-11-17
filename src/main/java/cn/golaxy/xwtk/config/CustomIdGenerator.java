package cn.golaxy.xwtk.config;

import cn.golaxy.xwtk.utils.SnowflakeIDGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @author LENOVO
 * 自定义ID生成器,mybatis-plus默认使用雪花算法
 */
//@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return SnowflakeIDGenerator.getId();
    }
}
