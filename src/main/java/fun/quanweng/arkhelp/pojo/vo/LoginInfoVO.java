package fun.quanweng.arkhelp.pojo.vo;

import lombok.Data;

@Data
public class LoginInfoVO {
    /**
     * 通过token
     */
    private String accessToken;
    /**
     * 过期时间
     */
    private Integer accessTokenExpiresIn;
    /**
     * 刷新token
     */
    private String refreshToken;
    /**
     * 过期时间
     */
    private Integer refreshTokenExpiresIn;
}
