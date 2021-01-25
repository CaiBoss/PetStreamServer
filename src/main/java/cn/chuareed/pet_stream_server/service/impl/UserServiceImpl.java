package cn.chuareed.pet_stream_server.service.impl;

import cn.chuareed.pet_stream_server.dao.RoleDao;
import cn.chuareed.pet_stream_server.dao.UserDao;
import cn.chuareed.pet_stream_server.pojo.User;
import cn.chuareed.pet_stream_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 19:12
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        return user;
    }
}
