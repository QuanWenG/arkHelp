package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.pojo.dto.HelpTableDTO;
import fun.quanweng.arkhelp.pojo.entity.HelpTable;
import fun.quanweng.arkhelp.pojo.vo.HelpTableVO;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.HelpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 助战表
 */
@Slf4j
@RestController
@RequestMapping("/help")
@AllArgsConstructor
@Tag(name = "助战表相关接口",description = "助战表相关接口")
public class HelpController {

    private final HelpService helpService;

    @PostMapping("/create")
    @Operation(summary = "创建助战表", description = "创建助战表")
    public Result createHelpTable(@Valid @RequestBody HelpTableDTO helpTableDTO) throws Exception {
        HelpTable helpTable = HelpTable.builder()
                .masterId(helpTableDTO.getMasterId())
                .tableFrom(helpTableDTO.getTableFrom())
                .build();
        helpService.createHelpTable(helpTable);
        return Result.success();
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除助战表", description = "删除助战表")
    public Result deleteHelpTable(@RequestParam Long id){
        helpService.deleteHelpTable(id);
        return Result.success();
    }

    @GetMapping("/select")
    @Operation(summary = "查询全部助战表", description = "根据自己id查询全部助战表")
    public Result<List<HelpTableVO>> selectHelpTable(@RequestParam Long id){
        List<HelpTableVO> helpTableVOList = helpService.selectHelpTable(id);
        return Result.success(helpTableVOList);
    }
}
