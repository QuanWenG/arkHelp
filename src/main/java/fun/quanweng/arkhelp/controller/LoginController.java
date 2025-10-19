package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.pojo.dto.RefreshTokenDTO;
import fun.quanweng.arkhelp.pojo.dto.UserDTO;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.LoginInfoVO;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户相关接口
 */
@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "用户相关接口",description = "用户相关")
public class LoginController {

    private LoginService loginService;

    @PostMapping("/register")
    @Operation(summary = "注册账号",description = "注册")
    public Result register(@Valid @RequestBody UserDTO userDTO) throws Exception {
        UserTable userTable = UserTable.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        loginService.register(userTable);
        return Result.success();
    }

    @PostMapping("/login")
    @Operation(summary = "登录账号",description = "登录")
    public Result<LoginInfoVO> login(@Valid @RequestBody UserDTO userDTO) throws Exception {
        LoginInfoVO loginInfoVO = loginService.login(userDTO);
        return Result.success(loginInfoVO);
    }

    @PostMapping("/refresh")
    @Operation(summary = "刷新令牌",description = "刷新令牌")
    public Result<LoginInfoVO> refreshToken(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO) throws Exception {
        LoginInfoVO loginInfoVO = loginService.refreshToken(refreshTokenDTO);
        return Result.success(loginInfoVO);
    }
}
