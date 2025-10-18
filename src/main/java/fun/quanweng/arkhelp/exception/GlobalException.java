  package fun.quanweng.arkhelp.exception;

import fun.quanweng.arkhelp.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

  @Data
  @EqualsAndHashCode(callSuper = false)
  public class GlobalException extends RuntimeException implements Serializable {
      private static final long serialVersionUID = 8134030011662574394L;
      private Integer code;
      private String message;

      public GlobalException(Integer code, String message) {
          this.code = code;
          this.message = message;
      }

      public GlobalException(ResultCode resultCode, String message) {
          this.code = resultCode.getCode();
          this.message = message;
      }

      public GlobalException(ResultCode resultCode) {
          this.code = resultCode.getCode();
          this.message = resultCode.getMessage();
      }

      public GlobalException(String message) {
          this.code = ResultCode.ERROR.getCode();
          this.message = message;
      }

  }
