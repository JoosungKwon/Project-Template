package com.prgrms.demotemplate.domain.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prgrms.demotemplate.domain.user.dto.UserResponse;
import com.prgrms.demotemplate.domain.user.service.UserService;
import com.prgrms.demotemplate.global.security.jwt.JwtAuthentication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	@GetMapping("/me")
	ResponseEntity<UserResponse.UserProfile> getMyProfile(
		@AuthenticationPrincipal JwtAuthentication user
	) {
		return ResponseEntity.ok(
			userService.getUserProfile(user.id())
		);
	}
}
