package fun.quanweng.arkhelp.pojo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 刷新令牌请求DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDTO {
    /**
     * 刷新令牌
     */
    @NotEmpty(message = "刷新令牌不能为空")
    private String refreshToken;
}