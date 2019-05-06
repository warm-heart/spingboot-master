package cn.jiayao.myjwt.modular.interceptor;

import cn.jiayao.myjwt.jwts.common.JwtClaims;
import cn.jiayao.myjwt.jwts.common.Jwts;
import cn.jiayao.myjwt.jwts.secret.Base64Utils;
import cn.jiayao.myjwt.modular.tools.Apistatus;
import cn.jiayao.myjwt.modular.tools.Json;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: JiaYao
 * @demand: 自定义web拦截器
 * @parameters:
 * @creationDate：
 * @email: huangjy19940202@gmail.com
 */
@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {

    /**
     * JWT密钥
     */
    @Value("${jwt.safety.secret}")
    private String jwtSafetySecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //  进入拦截器 WebInterceptor...
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return noAccess403(response);
        } else {
            try {
                String token = authorization.substring(7).replaceAll(" ", "");
                // 验证token的完整性和有效性
                if (StringUtils.isNotEmpty(token) && Jwts.safetyVerification(token, jwtSafetySecret)) {
                    JwtClaims jwtClaims = JSON.parseObject(Base64Utils.getFromBase64(token.split("\\.")[1]), JwtClaims.class);
                    request.setAttribute("claims", jwtClaims);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return noAccess(response);
            }
        }
        return false;
    }

    /**
     * 在未登录状态或登录状态失效时请求需要登录状态才能请求的URL
     *
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    public boolean noAccess(HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/json; charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Json.newInstance(Apistatus.CODE_401)));
        return false;
    }

    /**
     * 在未登录状态或登录状态失效时请求需要登录状态才能请求的URL
     *
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    public boolean noAccess403(HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/json; charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Json.newInstance(Apistatus.CODE_403)));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {
    }

}