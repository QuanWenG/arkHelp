package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.common.JwtUtil;
import fun.quanweng.arkhelp.pojo.dto.RefreshTokenDTO;
import fun.quanweng.arkhelp.pojo.dto.UserDTO;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.LoginInfoVO;
import fun.quanweng.arkhelp.pojo.vo.UserInfoVO;
import fun.quanweng.arkhelp.enums.ResultCode;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeFormatter;


/**
 * 用户相关接口
 */
@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "用户登录相关接口",description = "登录相关")
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
    public Result<LoginInfoVO> refreshToken(@RequestBody(required = false) RefreshTokenDTO refreshTokenDTO,
                                            HttpServletRequest request) throws Exception {
        String token = refreshTokenDTO != null ? refreshTokenDTO.getRefreshToken() : null;

        if (!StringUtils.hasText(token)) {
            String authHeader = request.getHeader("Authorization");
            if (StringUtils.hasText(authHeader)) {
                token = authHeader.startsWith("Bearer ") ? authHeader.substring(7) : authHeader;
            }
        }
        if (!StringUtils.hasText(token)) {
            String refreshHeader = request.getHeader("refreshToken");
            if (StringUtils.hasText(refreshHeader)) {
                token = refreshHeader;
            }
        }
        if (!StringUtils.hasText(token)) {
            String refleshHeader = request.getHeader("refleshToken");
            if (StringUtils.hasText(refleshHeader)) {
                token = refleshHeader;
            }
        }

        if (!StringUtils.hasText(token)) {
            return Result.error(ResultCode.PARAM_ERROR.getCode(), "刷新令牌不能为空");
        }

        RefreshTokenDTO dto = new RefreshTokenDTO();
        dto.setRefreshToken(token);
        LoginInfoVO loginInfoVO = loginService.refreshToken(dto);
        return Result.success(loginInfoVO);
    }
}
