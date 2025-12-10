package fun.quanweng.arkhelp.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    @Schema(description = "逻辑id")
    @NotNull(message = "id不能为空")
    private Long id;

    @Schema(description = "账号")
    private String username;

    @Schema(description = "昵称")
    private String name;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "用户头像")
    private String userImg;

    @Schema(description = "用户简介")
    private String userMd;


}
