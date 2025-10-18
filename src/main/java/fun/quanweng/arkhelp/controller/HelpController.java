package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.pojo.dto.HelpTableDTO;
import fun.quanweng.arkhelp.pojo.entity.HelpTable;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.HelpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


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
    public Result createHelpTable(@RequestBody HelpTableDTO helpTableDTO) throws Exception {
        HelpTable helpTable = new HelpTable();
        helpTable.setMasterId(helpTableDTO.getMasterId());
        helpTable.setTableFrom(helpTableDTO.getTableFrom());
        helpService.createHelpTable(helpTable);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteHelpTable(){
        return Result.success();
    }

    @GetMapping("/select")
    public Result selectHelpTable(){
        return Result.success();
    }
}
