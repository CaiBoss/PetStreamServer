package cn.chuareed.pet_stream_server.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 10:56
 * @description ： 用户
 */
@Data
@ToString
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String gender;  //性别  M——男    F——女
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer isDeleted;  //逻辑删除 表示是否被删除  1——是 0——否

    private List<Role> roles;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
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
        return isDeleted == 0;
    }
}
