package cn.golaxy.xwtk.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author LENOVO
 */
public enum GradeEnum {
    PRIMARY(1, "小学"),  SECONDORY(2, "中学"),  HIGH(3, "高中");

    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    @EnumValue//标记数据库存的值是code
    private  int code;
    private  String descp;
    @JsonValue
    public int getCode(){
        return this.code;
    }
}
