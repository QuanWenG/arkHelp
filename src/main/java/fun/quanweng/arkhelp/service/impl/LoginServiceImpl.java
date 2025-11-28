package fun.quanweng.arkhelp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.quanweng.arkhelp.common.JwtUtil;
import fun.quanweng.arkhelp.common.PasswordUtil;
import fun.quanweng.arkhelp.mapper.LoginMapper;
import fun.quanweng.arkhelp.pojo.dto.RefreshTokenDTO;
import fun.quanweng.arkhelp.pojo.dto.UserDTO;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.LoginInfoVO;
import fun.quanweng.arkhelp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper,UserTable> implements LoginService {

    @Autowired
    private PasswordUtil passwordUtil;
    
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void register(UserTable userTable) throws Exception {
        if(this.getOne(new LambdaQueryWrapper<UserTable>()
                .eq(UserTable::getUsername, userTable.getUsername())) != null){
            throw new Exception("该账号已经存在");
        }
        
        // 加密密码
        userTable.setPassword(passwordUtil.encodePassword(userTable.getPassword()));
        userTable.setStatus('1'); // 设置账号状态为正常
        userTable.setCreateTime(LocalDateTime.now());
        userTable.setUpdateTime(LocalDateTime.now());
        this.save(userTable);
    }

    @Override
    public LoginInfoVO login(UserDTO userDTO) throws Exception {
        // 查询用户
        UserTable user = this.getOne(new LambdaQueryWrapper<UserTable>()
                .eq(UserTable::getUsername, userDTO.getUsername()));
        
        if (user == null) {
            throw new Exception("用户名或密码错误");
        }
        
        // 验证密码
        if (!passwordUtil.matches(userDTO.getPassword(), user.getPassword())) {
            throw new Exception("用户名或密码错误");
        }
        
        // 检查账号状态
        if (user.getStatus() != '1') {
            throw new Exception("账号已被禁用");
        }
        
        // 生成令牌
        String accessToken = jwtUtil.generateAccessToken(user.getUsername(), user.getId());
        String refreshToken = jwtUtil.generateRefreshToken(user.getUsername(), user.getId());
        
        // 构建返回对象
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        loginInfoVO.setAccessToken(accessToken);
        loginInfoVO.setAccessTokenExpiresIn(jwtUtil.getAccessTokenExpirationInSeconds());
        loginInfoVO.setRefreshToken(refreshToken);
        loginInfoVO.setRefreshTokenExpiresIn(jwtUtil.getRefreshTokenExpirationInSeconds());
        
        return loginInfoVO;
    }

    @Override
    public LoginInfoVO refreshToken(RefreshTokenDTO refreshTokenDTO) throws Exception {
        String refreshToken = refreshTokenDTO.getRefreshToken();
        
        // 验证刷新令牌
        if (!jwtUtil.validateToken(refreshToken)) {
            throw new Exception("刷新令牌无效");
        }
        
        // 检查令牌类型
        String tokenType = jwtUtil.getTokenTypeFromToken(refreshToken);
        if (!"refresh".equals(tokenType)) {
            throw new Exception("令牌类型错误");
        }
        
        // 获取用户信息
        String username = jwtUtil.getUsernameFromToken(refreshToken);
        Long userId = jwtUtil.getUserIdFromToken(refreshToken);
        
        // 验证用户是否存在且状态正常
        UserTable user = this.getById(userId);
        if (user == null || user.getStatus() != '1') {
            throw new Exception("用户不存在或已被禁用");
        }
        
        // 生成新的令牌
        String newAccessToken = jwtUtil.generateAccessToken(username, userId);
        String newRefreshToken = jwtUtil.generateRefreshToken(username, userId);
        
        // 构建返回对象
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        loginInfoVO.setAccessToken(newAccessToken);
        loginInfoVO.setAccessTokenExpiresIn(jwtUtil.getAccessTokenExpirationInSeconds());
        loginInfoVO.setRefreshToken(newRefreshToken);
        loginInfoVO.setRefreshTokenExpiresIn(jwtUtil.getRefreshTokenExpirationInSeconds());
        
        return loginInfoVO;
    }

    @Override
    public UserTable getUserById(Long userId) {
        return this.getById(userId);
    }
}
