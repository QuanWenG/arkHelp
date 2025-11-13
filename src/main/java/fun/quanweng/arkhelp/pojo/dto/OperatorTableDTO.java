package fun.quanweng.arkhelp.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "干员表")
public class OperatorTableDTO {
    /**
     * 干员逻辑id
     */
    @Schema(description = "逻辑id")
    private Long id;

    /**
     * 干员名称
     */
    @Schema(description = "干员名称")
    @NotEmpty(message = "干员名称不能为空")
    private String operatorName;

    /**
     * 干员星级
     */
    @Schema(description = "干员星级")
    @NotNull(message = "干员星级不能为空")
    @Max(value = 6,message = "干员不能大于6星")
    @Min(value = 1,message = "干员不能小于1星")
    private Integer operatorStar;

    /**
     * 干员等级
     */
    @Schema(description = "干员等级")
    @NotNull(message = "干员等级不能为空")
    @Max(value = 90,message = "等级不能超过90级")
    @Min(value = 1,message = "等级不能小于1级")
    private Integer operatorLevel;

    /**
     * 精英化等级
     */
    @Schema(description = "精英化等级")
    @NotNull(message = "精英化等级不能为空")
    @Max(value = 2,message = "干员不能精英化二级以上")
    @Min(value = 0,message = "干员不能精英化零级以下")
    private Integer operatorElite;

    /**
     * 干员职业
     */
    @Schema(description = "干员职业")
    @NotEmpty(message = "干员职业不能为空")
    private String operatorClass;

    /**
     * 干员子职业
     */
    @Schema(description = "干员子职业")
    @NotEmpty(message = "干员子职业不能为空")
    private String operatorSubclass;

    /**
     * 干员潜能
     */
    @Schema(description = "干员潜能")
    @NotNull(message = "干员潜能不能为空")
    @Max(value = 6,message = "干员潜能不能超过六潜")
    @Min(value = 1,message = "干员不能没有潜能")
    private Integer operatorPotential;

    /**
     * 干员信赖度
     */
    @Schema(description = "干员信赖度")
    @NotNull(message = "干员信赖度不能为空")
    @Max(value = 200,message = "干员信赖度不能超过200%")
    @Min(value = 0,message = "干员信赖度不能低于0%")
    private Integer operatorTrustRate;

    /**
     * 一技能等级
     */
    @Schema(description = "一技能等级")
    @NotEmpty(message = "一技能等级不能为空")
    private String firstSkill;

    /**
     * 二技能等级
     */
    @Schema(description = "二技能等级")
    @NotEmpty(message = "二技能等级不能为空")
    private String secondSkill;

    /**
     * 三技能等级
     */
    @Schema(description = "三技能等级")
    @NotEmpty(message = "三技能等级不能为空")
    private String thirdSkill;

    /**
     *  x模组等级
     */
    @NotNull(message = "x模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    @Schema(description = "x模组等级")
    private Integer xMod;

    /**
     * y模组等级
     */
    @NotNull(message = "y模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    @Schema(description = "y模组等级")
    private Integer yMod;

    /**
     * delta模组等级
     */
    @Schema(description = "delta模组等级")
    @NotNull(message = "delta模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    private Integer deltaMod;

    /**
     * alpha模组等级
     */
    @Schema(description = "alpha模组等级")
    @NotNull(message = "alpha模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    private Integer alphaMod;

    /**
     * beta模组等级
     */
    @Schema(description = "beta模组等级")
    @NotNull(message = "beta模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    private Integer betaMod;

    /**
     * gamma模组等级
     */
    @Schema(description = "gamma模组等级")
    @NotNull(message = "gamma模组等级不能为空")
    @Max(value = 3,message = "模组等级不能超过3级")
    @Min(value = 0,message = "模组等级不能低于0级")
    private Integer gammaMod;

    /**
     * 其他备注
     */
    @Schema(description = "其他备注")
    private String other;

    /**
     * 主人id
     */
    @Schema(description = "主人账号id")
    @NotNull(message = "账号id不能为空")
    private Long masterId;

    /**
     * 主人联系方式
     */
    @Schema(description = "博士联系方式")
    @NotEmpty(message = "博士联系方式不能为空")
    private String masterLink;

    /**
     * 从属助战表id
     */
    @Schema(description = "从属助战表id")
    @NotNull(message = "助战表id不能为空")
    private Long helpTable;
}
