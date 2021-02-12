package com.vetApplication.program.security;

import com.vetApplication.program.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


public class MyUserDetails implements UserDetails {

    private  Set<? extends GrantedAuthority> grantedAuthorityList;
    private  String password;
    private  String username;
    private  boolean isAccountNonExpired;
    private  boolean isAccountNonLocked;
    private  boolean isCredentialsNonExpired;
    private  boolean isEnabled;

    @Autowired
    PasswordEncoder passwordEncoder;

    public MyUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.grantedAuthorityList = ApplicationUserRole.ADMIN.getGrantedAuthorities();

    }


    public MyUserDetails(
                         Set<GrantedAuthority> grantedAuthorityList,
                         String password,
                         String username,
                         boolean isAccountNonExpired,
                         boolean isAccountNonLocked,
                         boolean isCredentialsNonExpired,
                         boolean isEnabled) {
        this.grantedAuthorityList = grantedAuthorityList;
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public MyUserDetails(String username, String encode, boolean b, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, Set<SimpleGrantedAuthority> grantedAuthorities) {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    public void setGrantedAuthorityList(Set<SimpleGrantedAuthority> grantedAuthorities) {
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


}
