package fun.quanweng.arkhelp.filter;

import fun.quanweng.arkhelp.common.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JWT认证过滤器
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException {
        
        String token = getTokenFromRequest(request);
        
        if (StringUtils.hasText(token) && jwtUtil.validateToken(token)) {
            // 检查是否为访问令牌
            String tokenType = jwtUtil.getTokenTypeFromToken(token);
            if ("access".equals(tokenType)) {
                String username = jwtUtil.getUsernameFromToken(token);
                Long userId = jwtUtil.getUserIdFromToken(token);
                
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // 创建认证对象
                    UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    authentication.setDetails(userId);
                    
                    // 设置到安全上下文
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        
        filterChain.doFilter(request, response);
    }

    /**
     * 从请求中获取令牌，支持 Authorization 和自定义 accessToken 头
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        // 1) 标准头：Authorization: Bearer <token>，也兼容直接传 token
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader)) {
            if (authHeader.startsWith("Bearer ")) {
                return authHeader.substring(7);
            }
            return authHeader;
        }
        // 2) 自定义头：accessToken
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.hasText(accessToken)) {
            return accessToken;
        }
        // 3) 容错支持：refreshToken/refleshToken（仅用于刷新接口，鉴权仍只接受 access token）
        String refreshToken = request.getHeader("refreshToken");
        if (StringUtils.hasText(refreshToken)) {
            return refreshToken;
        }
        String refleshToken = request.getHeader("refleshToken");
        if (StringUtils.hasText(refleshToken)) {
            return refleshToken;
        }
        return null;
    }
}