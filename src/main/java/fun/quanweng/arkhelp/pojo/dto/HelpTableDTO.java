package fun.quanweng.arkhelp.pojo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelpTableDTO {
    @NotNull(message = "创建者不能为空")
    private Long masterId;

    @NotNull(message = "渠道不能为空")
    @Max(value = 1)
    @Min(value = 0)
    private Integer tableFrom;
}
