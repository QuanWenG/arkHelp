package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.pojo.dto.OperatorTableDTO;
import fun.quanweng.arkhelp.pojo.entity.OperatorTable;
import fun.quanweng.arkhelp.pojo.vo.OperatorTableVO;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.OperatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/operator")
@AllArgsConstructor
@Tag(name = "干员列表",description = "干员列表相关接口")
public class OperatorController {

    private OperatorService operatorService;

    @PostMapping("/add")
    @Operation(summary = "添加干员",description = "向助战表添加一名干员")
    public Result addOperator(@Valid @RequestBody OperatorTableDTO operatorTableDTO) {
        OperatorTable operatorTable = OperatorTable.builder()
                .operatorName(operatorTableDTO.getOperatorName())
                .operatorStar(operatorTableDTO.getOperatorStar())
                .operatorLevel(operatorTableDTO.getOperatorLevel())
                .operatorElite(operatorTableDTO.getOperatorElite())
                .operatorClass(operatorTableDTO.getOperatorClass())
                .operatorSubclass(operatorTableDTO.getOperatorSubclass())
                .operatorPotential(operatorTableDTO.getOperatorPotential())
                .operatorTrustRate(operatorTableDTO.getOperatorTrustRate())
                .firstSkill(operatorTableDTO.getFirstSkill())
                .secondSkill(operatorTableDTO.getSecondSkill())
                .thirdSkill(operatorTableDTO.getThirdSkill())
                .xMod(operatorTableDTO.getXMod())
                .yMod(operatorTableDTO.getYMod())
                .deltaMod(operatorTableDTO.getDeltaMod())
                .alphaMod(operatorTableDTO.getAlphaMod())
                .betaMod(operatorTableDTO.getBetaMod())
                .gammaMod(operatorTableDTO.getGammaMod())
                .other(operatorTableDTO.getOther())
                .masterId(operatorTableDTO.getMasterId())
                .masterLink(operatorTableDTO.getMasterLink())
                .helpTable(operatorTableDTO.getHelpTable())
                .build();
        operatorService.addOperator(operatorTable);
        return Result.success();
    }

    @GetMapping("/select/all")
    @Operation(summary = "查询全部",description = "简单查询全部干员")
    public Result<List<OperatorTableVO>> selectAllOperator(@RequestParam Long tableId){
        List<OperatorTableVO> operatorTableVOList = operatorService.selectAllOperator(tableId);
        return Result.success(operatorTableVOList);
    }


}
