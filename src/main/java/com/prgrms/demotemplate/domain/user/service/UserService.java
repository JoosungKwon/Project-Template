package com.prgrms.demotemplate.domain.user.service;

import com.prgrms.demotemplate.domain.user.dto.UserResponse;
import com.prgrms.demotemplate.global.security.oauth.dto.OauthUserInfo;

public interface UserService {

	Long signUp(OauthUserInfo oauthUserInfo);

	UserResponse.UserProfile getUserProfile(Long userId);
}
