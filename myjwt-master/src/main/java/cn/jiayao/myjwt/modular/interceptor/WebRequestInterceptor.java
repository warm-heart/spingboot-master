package cn.jiayao.myjwt.modular.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: JiaYao
 * @demand: 将拦截器添加到列表中，即观察者与被观察者
 * @parameters:
 * @creationDate： 2018/12/19 0019 9:16
 */
@Configuration
public class WebRequestInterceptor implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor webInterceptor;

    /**
     * 需要JWT拦截的Url
     */
    @Value("${jwt.secret-url}")
    private String jwtSecretUrl;
    /**
     * JWT密钥
     */
    @Value("${jwt.safety.secret}")
    private String jwtSafetySecret;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        jwtSecretUrl = jwtSecretUrl.replaceAll(" ", "");
        registry.addInterceptor(webInterceptor).addPathPatterns(jwtSecretUrl.split(","));
    }

}
