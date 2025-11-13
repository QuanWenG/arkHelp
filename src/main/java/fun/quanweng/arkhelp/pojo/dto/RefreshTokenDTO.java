package fun.quanweng.arkhelp.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 刷新令牌请求DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "刷新令牌请求")
public class RefreshTokenDTO {
    /**
     * 刷新令牌
     */
    @Schema(description = "刷新令牌")
    private String refreshToken;
}
