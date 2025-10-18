package fun.quanweng.arkhelp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200,"成功"),

    ERROR(500,"未知错误");

    private final int code;
    private final String message;


}
