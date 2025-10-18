package fun.quanweng.arkhelp.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 助战表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpTable {
    /**
    * 逻辑id
    * */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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
