package fun.quanweng.arkhelp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatorTableVO {
    /**
     * 干员逻辑id
     */
    private Long id;
    /**
     * 干员名称
     */
    private String operatorName;

    /**
     * 干员星级
     */
    private Integer operatorStar;

    /**
     * 干员等级
     */
    private Integer operatorLevel;

    /**
     * 精英化等级
     */
    private Integer operatorElite;

    /**
     * 干员职业
     */
    private String operatorClass;

    /**
     * 干员子职业
     */
    private String operatorSubclass;

    /**
     * 干员潜能
     */
    private Integer operatorPotential;

    /**
     * 干员信赖度
     */
    private Integer operatorTrustRate;

    /**
     * 一技能等级
     */
    private String firstSkill;

    /**
     * 二技能等级
     */
    private String secondSkill;

    /**
     * 三技能等级
     */
    private String thirdSkill;

    /**
     *  x模组等级
     */
    private Integer xMod;

    /**
     * y模组等级
     */
    private Integer yMod;

    /**
     * delta模组等级
     */
    private Integer deltaMod;

    /**
     * alpha模组等级
     */
    private Integer alphaMod;

    /**
     * beta模组等级
     */
    private Integer betaMod;

    /**
     * gamma模组等级
     */
    private Integer gammaMod;

    /**
     * 其他备注
     */
    private String other;

    /**
     * 主人id
     */
    private Long masterId;

    /**
     * 主人联系方式
     */
    private String masterLink;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
