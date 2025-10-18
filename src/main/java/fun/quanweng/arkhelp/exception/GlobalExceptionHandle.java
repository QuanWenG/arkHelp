package fun.quanweng.arkhelp.exception;

import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.lang.reflect.UndeclaredThrowableException;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            log.error(ex.getMessage());
            return Result.error(ex.getCode(), ex.getMessage());
        }
        return Result.error(ResultCode.ERROR.getCode(), e.getMessage());
    }
}
