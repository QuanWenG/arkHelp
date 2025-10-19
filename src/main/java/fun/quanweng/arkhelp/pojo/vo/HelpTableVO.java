package fun.quanweng.arkhelp.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpTableVO {
    private Long id;
    private Integer tableFrom;
    private LocalDateTime updateTime;
}
