package fun.quanweng.arkhelp.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "助战表")
public class HelpTableDTO {
    @NotNull(message = "创建者不能为空")
    @Schema(description = "创建者id")
    private Long masterId;

    @NotNull(message = "渠道不能为空")
    @Max(value = 1,message = "最大不超过1")
    @Min(value = 0,message = "最小不低于0")
    @Schema(description = "渠道id 0官服 1B服")
    private Integer tableFrom;
}
