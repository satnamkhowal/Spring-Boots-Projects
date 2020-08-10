package com.gs.dao;

import com.gs.entities.UserInfo;

public interface UserInfoDao {
		public abstract UserInfo getActiveUser(String userName);
}
