package fun.quanweng.arkhelp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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
                .eq(OperatorTable::getHelpTable,tableId)
                .eq(OperatorTable::getStatus,1));
        List<OperatorTableVO> operatorTableVOList = new ArrayList<>();
        for (OperatorTable operatorTable : operatorTableList) {
            OperatorTableVO operatorTableVO = OperatorTableVO.builder()
                    .id(operatorTable.getId())
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

    @Override
    public void updateOperator(OperatorTable operatorTable) {
        operatorTable.setUpdateTime(LocalDateTime.now());
        this.update(new LambdaUpdateWrapper<OperatorTable>()
        .eq(OperatorTable::getId,operatorTable.getId())
                .set(OperatorTable::getUpdateTime,operatorTable.getUpdateTime())
                .set(operatorTable.getOperatorName() != null && !operatorTable.getOperatorName().isEmpty(),
                        OperatorTable::getOperatorName,operatorTable.getOperatorName())
                .set(operatorTable.getOperatorStar() != null,
                        OperatorTable::getOperatorStar,operatorTable.getOperatorStar())
                .set(operatorTable.getOperatorLevel() != null,
                        OperatorTable::getOperatorLevel,operatorTable.getOperatorLevel())
                .set(operatorTable.getOperatorElite() != null,
                        OperatorTable::getOperatorElite,operatorTable.getOperatorElite())
                .set(operatorTable.getOperatorClass() != null && !operatorTable.getOperatorClass().isEmpty(),
                        OperatorTable::getOperatorClass,operatorTable.getOperatorClass())
                .set(operatorTable.getOperatorSubclass() != null && !operatorTable.getOperatorSubclass().isEmpty(),
                        OperatorTable::getOperatorSubclass,operatorTable.getOperatorSubclass())
                .set(operatorTable.getOperatorPotential() != null,
                        OperatorTable::getOperatorPotential,operatorTable.getOperatorPotential())
                .set(operatorTable.getOperatorTrustRate() != null,
                        OperatorTable::getOperatorTrustRate,operatorTable.getOperatorTrustRate())
                .set(operatorTable.getFirstSkill() != null && !operatorTable.getFirstSkill().isEmpty(),
                        OperatorTable::getFirstSkill,operatorTable.getFirstSkill())
                .set(operatorTable.getSecondSkill() != null && !operatorTable.getSecondSkill().isEmpty(),
                        OperatorTable::getSecondSkill,operatorTable.getSecondSkill())
                .set(operatorTable.getThirdSkill() != null && !operatorTable.getThirdSkill().isEmpty(),
                        OperatorTable::getThirdSkill,operatorTable.getThirdSkill())
                .set(operatorTable.getXMod() != null,
                        OperatorTable::getXMod,operatorTable.getXMod())
                .set(operatorTable.getYMod() != null,
                        OperatorTable::getYMod,operatorTable.getYMod())
                .set(operatorTable.getDeltaMod() != null,
                        OperatorTable::getDeltaMod,operatorTable.getDeltaMod())
                .set(operatorTable.getAlphaMod() != null,
                        OperatorTable::getAlphaMod,operatorTable.getAlphaMod())
                .set(operatorTable.getBetaMod() != null,
                        OperatorTable::getBetaMod,operatorTable.getBetaMod())
                .set(operatorTable.getGammaMod() != null,
                        OperatorTable::getGammaMod,operatorTable.getGammaMod())
                .set(operatorTable.getOther() != null && !operatorTable.getOther().isEmpty(),
                        OperatorTable::getOther,operatorTable.getOther())
                .set(operatorTable.getMasterLink() != null && !operatorTable.getMasterLink().isEmpty(),
                        OperatorTable::getMasterLink,operatorTable.getMasterLink())
        );
    }

    @Override
    public void deleteOperator(Long id) {
        this.update(new LambdaUpdateWrapper<OperatorTable>()
                .eq(OperatorTable::getId,id)
                .set(OperatorTable::getUpdateTime,LocalDateTime.now())
                .set(OperatorTable::getStatus,0));
    }
}
