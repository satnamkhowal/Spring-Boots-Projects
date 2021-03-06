package com.gs.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gs.dao.UserInfoDao;
import com.gs.entities.UserInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoDao.getActiveUser(username);
		System.out.println("I am in User DetailsImpl");
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		System.out.println(userInfo);
		User user = new User(userInfo.getUsername(), userInfo.getPassword(), Arrays.asList(authority));
		userDetails = (UserDetails) user;
		System.out.println(userDetails.toString());
		System.out.println("hi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return userDetails;
	}

}
