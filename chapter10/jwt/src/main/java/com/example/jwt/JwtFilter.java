package com.example.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 第二个过滤器则是当其他请求发送来，校验token的过滤器，如果校验成功，就让请求继续执行
 *
 * Created By ChengHao On 2019/11/19
 */
public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //首先从请求头中提取出 authorization 字段，这个字段对应的value就是用户的token
        String jwtToken = request.getHeader("authorization");
        System.out.println("jwtToken = " + jwtToken);
        //将提取出来的token字符串转换为一个Claims对象
        Claims claims = Jwts.parser().setSigningKey("sang@123").parseClaimsJws(jwtToken.replace("Bearer","")).getBody();
        //从Claims对象中提取出当前用户名和用户角色
        String username = claims.getSubject();  //获取当前登录用户名
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
        //创建一个UsernamePasswordAuthenticationToken放到当前的Context中
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null,authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
        //执行过滤链使请求继续执行下去
        filterChain.doFilter(request,servletResponse);
    }
}
