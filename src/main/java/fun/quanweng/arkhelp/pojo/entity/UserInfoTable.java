package fun.quanweng.arkhelp.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoTable {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 账号
     */
    private String username;
    /**
     * 昵称
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户头像
     */
    private String userImg;
    /**
     * 用户简介
     */
    private String userMd;
    /**
     * 用户状态
     */
    private Short status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
