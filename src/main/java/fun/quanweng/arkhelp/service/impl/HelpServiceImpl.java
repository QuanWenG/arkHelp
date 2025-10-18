package fun.quanweng.arkhelp.service.impl;

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
    public void createHelpTable(HelpTable helpTable) {
        helpTable.setCreateTime(LocalDateTime.now());
        helpTable.setUpdateTime(LocalDateTime.now());
        this.save(helpTable);
    }
}
