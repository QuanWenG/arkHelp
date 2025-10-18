package fun.quanweng.arkhelp.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTable {
    /**
     * 逻辑id
     */
    private Long id;

    /**
     * 账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号状态
     */
    private Character status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
