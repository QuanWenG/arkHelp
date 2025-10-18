package fun.quanweng.arkhelp.result;

import fun.quanweng.arkhelp.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;


    /**
     * 成功返回结果
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     * @param data
     * @return
     * @param <T>
     */
    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 未知错误
     * @return
     * @param <T>
     */
    public static <T> Result<T> error(){
        return new Result<>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), null);
    }

}
