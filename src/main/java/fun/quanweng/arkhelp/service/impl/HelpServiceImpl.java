package fun.quanweng.arkhelp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.quanweng.arkhelp.mapper.HelpMapper;
import fun.quanweng.arkhelp.pojo.entity.HelpTable;
import fun.quanweng.arkhelp.service.HelpService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelpServiceImpl extends ServiceImpl<HelpMapper,HelpTable> implements HelpService {

    private HelpMapper helpMapper;

    @Override
    public void createHelpTable(HelpTable helpTable) throws Exception {
        HelpTable findHelpTable = this.getOne(new LambdaQueryWrapper<>(HelpTable.class)
                .eq(HelpTable::getMasterId, helpTable.getMasterId())
                .eq(HelpTable::getTableFrom, helpTable.getTableFrom()));
        if (findHelpTable != null) {
            throw new Exception("你已经建过一个这样的助战表了");
        }
        helpTable.setCreateTime(LocalDateTime.now());
        helpTable.setUpdateTime(LocalDateTime.now());
        this.save(helpTable);
    }
}
