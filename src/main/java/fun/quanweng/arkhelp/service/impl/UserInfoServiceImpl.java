package fun.quanweng.arkhelp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.quanweng.arkhelp.mapper.UserInfoMapper;
import fun.quanweng.arkhelp.pojo.entity.UserInfoTable;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.UserInfoVO;
import fun.quanweng.arkhelp.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoTable> implements UserInfoService {
    @Override
    public UserInfoVO getInfo(Long userId) {
        UserInfoTable userInfoTable = this.getOne(new QueryWrapper<UserInfoTable>().eq("id", userId));
        if (userInfoTable == null) {
            throw new RuntimeException("用户信息不存在");
        }
        return UserInfoVO.builder()
                .id(userInfoTable.getId())
                .username(userInfoTable.getUsername())
                .name(userInfoTable.getName())
                .email(userInfoTable.getEmail())
                .userImg(userInfoTable.getUserImg())
                .userMd(userInfoTable.getUserMd())
                .createTime(userInfoTable.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }
}
