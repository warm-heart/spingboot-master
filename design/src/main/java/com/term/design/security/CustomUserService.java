package com.term.design.security;

import com.term.design.dao.PermissionDao;
import com.term.design.dao.SysUserDao;
import com.term.design.entity.Permission;
import com.term.design.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-07-31 15:01
 */

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = sysUserDao.findByName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
}
