package com.example.shiro.config;

import com.example.shiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author wangqianlong
 * @create 2018-08-02 9:13
 */

public class MyShiroRealm extends  AuthorizingRealm{
    @Autowired
    private UserService userService;
    /*鉴权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findPermissionsByUserName(userName));
        authorizationInfo.setStringPermissions(userService.findPermissionsByUserName(userName));

        return authorizationInfo;
    }


    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getUserName() + user.getPasswordSalt()),
                getName());
        return authenticationInfo;
    }
}
