package fun.quanweng.arkhelp.service;

import fun.quanweng.arkhelp.pojo.entity.OperatorTable;
import fun.quanweng.arkhelp.pojo.vo.OperatorTableVO;

import java.util.List;

public interface OperatorService {
    void addOperator(OperatorTable operatorTable);

    List<OperatorTableVO> selectAllOperator(Long tableId);

    void updateOperator(OperatorTable operatorTable);

    void deleteOperator(Long id);
}
