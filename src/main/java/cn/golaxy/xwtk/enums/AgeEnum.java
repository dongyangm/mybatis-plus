package cn.golaxy.xwtk.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author LENOVO
 */

public enum AgeEnum implements IEnum<Integer> {
    ZERO(0,"0岁"),
    ONE(1, "一岁"),
    TWO(2, "二岁"),
    THREE(3, "三岁");

    private int age;
    private String desc;

    AgeEnum(int i, String desc) {
        this.age = i;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.age;
    }
}
