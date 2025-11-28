package fun.quanweng.arkhelp.service;

import fun.quanweng.arkhelp.pojo.dto.RefreshTokenDTO;
import fun.quanweng.arkhelp.pojo.dto.UserDTO;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.LoginInfoVO;

public interface LoginService {
    void register(UserTable userTable) throws Exception;
    
    LoginInfoVO login(UserDTO userDTO) throws Exception;
    
    LoginInfoVO refreshToken(RefreshTokenDTO refreshTokenDTO) throws Exception;
    
    UserTable getUserById(Long userId);
}
