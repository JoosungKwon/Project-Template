package com.prgrms.demotemplate.global.security.oauth;

import static com.prgrms.demotemplate.global.security.jwt.JwtTokenProvider.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prgrms.demotemplate.domain.user.service.UserService;
import com.prgrms.demotemplate.global.security.jwt.JwtTokenProvider;
import com.prgrms.demotemplate.global.security.oauth.dto.OauthUserInfo;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OAuthService {

	private final JwtTokenProvider jwtTokenProvider;
	private final UserService userService;

	@Transactional
	public String login(OauthUserInfo userInfo) {
		Long userId = userService.signUp(userInfo);
		return jwtTokenProvider.createAccessToken(
			Claims.from(userId, "ROLE_USER"));
	}
}
