package fun.quanweng.arkhelp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 助战表
 */
@Data
@AllArgsConstructor
public class HelpTable {
    /**
    * 逻辑id
    * */
    private Long id;

    /**
    * 创建者id
    * */
    private Long masterId;

    /**
     * 渠道来源 0:官服 1:B服 2:国际服 3:台服
     */
    private Integer tableFrom;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最近更改时间
     */
    private LocalDateTime updateTime;
}
