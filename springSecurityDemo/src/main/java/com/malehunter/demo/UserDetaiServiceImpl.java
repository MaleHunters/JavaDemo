package com.malehunter.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/24 9:19
 * @Package: com.malehunter.demo
 * @CurrentProject: springSecurityDemo
 * @version: 1.0
 */
public class UserDetaiServiceImpl implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    System.out.println("经过了usersecurityservice");
    System.out.println("用户名为" + s);
    // 角色集合
    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    grantedAuthorities.add( new SimpleGrantedAuthority("ROLE_ADMIN"));
    return new User(s,"$2a$10$F9z2iUJ51iFjh.HCTxLMQuPr928WV/5mauoGTLz0FU98gieZMEAOm",grantedAuthorities);
  }
}
