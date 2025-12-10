package fun.quanweng.arkhelp.controller;

import fun.quanweng.arkhelp.common.JwtUtil;
import fun.quanweng.arkhelp.enums.ResultCode;
import fun.quanweng.arkhelp.pojo.entity.UserTable;
import fun.quanweng.arkhelp.pojo.vo.UserInfoVO;
import fun.quanweng.arkhelp.result.Result;
import fun.quanweng.arkhelp.service.LoginService;
import fun.quanweng.arkhelp.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "用户个人信息相关接口",description = "用户个人信息相关")
public class UserInfoController {

    private JwtUtil jwtUtil;
    private LoginService loginService;
    private UserInfoService userInfoService;

    @GetMapping("/info")
    @Operation(summary = "获取当前用户信息",description = "获取当前登录用户的信息")
    public Result<UserInfoVO> getUserInfo(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (!StringUtils.hasText(authHeader) || !authHeader.startsWith("Bearer ")) {
            return Result.error(ResultCode.UNAUTHORIZED.getCode(), "未授权");
        }

        String token = authHeader.substring(7);
        if (!jwtUtil.validateToken(token)) {
            return Result.error(ResultCode.UNAUTHORIZED.getCode(), "令牌无效");
        }

        Long userId = jwtUtil.getUserIdFromToken(token);
        String username = jwtUtil.getUsernameFromToken(token);

        UserTable userTable = loginService.getUserById(userId);
        if (userTable == null) {
            return Result.error(ResultCode.USER_NOT_EXIST.getCode(), "用户不存在");
        }

        UserInfoVO userInfoVO = userInfoService.getInfo(userId);

        return Result.success(userInfoVO);
    }
}
