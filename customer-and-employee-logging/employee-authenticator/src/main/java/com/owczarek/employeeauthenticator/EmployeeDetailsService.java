package com.owczarek.employeeauthenticator;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"employee".equals(username)) {
            throw new UsernameNotFoundException("Employee " + username + " has not been found");
        }
        return new User(
                username,
                "password",
                AuthorityUtils.createAuthorityList("EMPLOYEE"));
    }
}
