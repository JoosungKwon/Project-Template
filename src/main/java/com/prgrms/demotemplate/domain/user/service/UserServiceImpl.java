package com.prgrms.demotemplate.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prgrms.demotemplate.domain.user.dto.UserResponse;
import com.prgrms.demotemplate.domain.user.exception.UserNotFoundException;
import com.prgrms.demotemplate.domain.user.mapper.UserMapper;
import com.prgrms.demotemplate.domain.user.repository.UserRepository;
import com.prgrms.demotemplate.global.security.oauth.dto.OauthUserInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public Long signUp(OauthUserInfo oauthUserInfo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserResponse.UserProfile getUserProfile(Long userId) {
		return userRepository.findById(userId)
			.map(userMapper::toUserProfile)
			.orElseThrow(UserNotFoundException::new);
	}
}
