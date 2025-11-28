package fun.quanweng.arkhelp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.tools.Diagnostic;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200,"成功"),
    PARAM_ERROR(10400, "参数错误"),
    ERROR(10500,"服务器繁忙"),
    UNAUTHORIZED(10600,"令牌无效或已过期"),
    USER_NOT_EXIST(10601,"用户不存在");


    private final int code;
    private final String message;


}
