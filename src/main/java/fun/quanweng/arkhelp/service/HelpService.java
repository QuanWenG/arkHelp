package fun.quanweng.arkhelp.service;

import fun.quanweng.arkhelp.pojo.entity.HelpTable;
import fun.quanweng.arkhelp.pojo.vo.HelpTableVO;

import java.util.List;

public interface HelpService {
    void createHelpTable(HelpTable helpTable) throws Exception;

    List<HelpTableVO> selectHelpTable(Long id);

    void deleteHelpTable(Long id);
}
