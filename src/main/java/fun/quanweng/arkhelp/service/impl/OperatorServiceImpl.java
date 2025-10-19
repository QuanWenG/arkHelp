package fun.quanweng.arkhelp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.quanweng.arkhelp.mapper.OperatorMapper;
import fun.quanweng.arkhelp.pojo.entity.HelpTable;
import fun.quanweng.arkhelp.pojo.entity.OperatorTable;
import fun.quanweng.arkhelp.pojo.vo.OperatorTableVO;
import fun.quanweng.arkhelp.service.OperatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, OperatorTable> implements OperatorService {
    @Override
    public void addOperator(OperatorTable operatorTable) {
        operatorTable.setCreateTime(LocalDateTime.now());
        operatorTable.setUpdateTime(LocalDateTime.now());
        this.save(operatorTable);
    }

    @Override
    public List<OperatorTableVO> selectAllOperator(Long tableId) {
        List<OperatorTable> operatorTableList = this.list(new LambdaQueryWrapper<OperatorTable>()
                .eq(OperatorTable::getHelpTable,tableId));
        List<OperatorTableVO> operatorTableVOList = new ArrayList<>();
        for (OperatorTable operatorTable : operatorTableList) {
            OperatorTableVO operatorTableVO = OperatorTableVO.builder()
                    .operatorName(operatorTable.getOperatorName())
                    .operatorStar(operatorTable.getOperatorStar())
                    .operatorLevel(operatorTable.getOperatorLevel())
                    .operatorElite(operatorTable.getOperatorElite())
                    .operatorClass(operatorTable.getOperatorClass())
                    .operatorSubclass(operatorTable.getOperatorSubclass())
                    .operatorPotential(operatorTable.getOperatorPotential())
                    .operatorTrustRate(operatorTable.getOperatorTrustRate())
                    .firstSkill(operatorTable.getFirstSkill())
                    .secondSkill(operatorTable.getSecondSkill())
                    .thirdSkill(operatorTable.getThirdSkill())
                    .xMod(operatorTable.getXMod())
                    .yMod(operatorTable.getYMod())
                    .deltaMod(operatorTable.getDeltaMod())
                    .alphaMod(operatorTable.getAlphaMod())
                    .betaMod(operatorTable.getBetaMod())
                    .gammaMod(operatorTable.getGammaMod())
                    .other(operatorTable.getOther())
                    .masterId(operatorTable.getMasterId())
                    .masterLink(operatorTable.getMasterLink())
                    .updateTime(operatorTable.getUpdateTime())
                    .build();
            operatorTableVOList.add(operatorTableVO);
        }
        return operatorTableVOList;
    }
}
