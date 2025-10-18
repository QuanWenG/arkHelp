package fun.quanweng.arkhelp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200,"成功"),
    PARAM_ERROR(10400, "参数错误"),
    ERROR(10500,"服务器繁忙");


    private final int code;
    private final String message;


}
