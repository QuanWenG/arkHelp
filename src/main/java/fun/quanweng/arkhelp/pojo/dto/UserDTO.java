package fun.quanweng.arkhelp.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    /**
     * 账号
     */
    @Schema(description = "账号")
    @NotEmpty(message = "账号不能为空")
    private String username;
    /**
     * 密码
     */
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
