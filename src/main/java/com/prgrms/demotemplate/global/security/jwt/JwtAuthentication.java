package com.prgrms.demotemplate.global.security.jwt;

import java.util.Objects;

public record JwtAuthentication(String token, Long id) {

	public JwtAuthentication {
		validateToken(token);
		validateId(id);
	}


	private void validateToken(String token) {
		if (Objects.isNull(token) || token.isBlank()) {
			throw new IllegalArgumentException("토큰은 NULL 혹은 빈값일 수 없습니다.");
		}
	}

	private void validateId(Long userId) {
		if (Objects.isNull(userId) || userId <= 0L) {
			throw new IllegalArgumentException("유효하지 않은 ID입니다.");
		}
	}

	@Override
	public String toString() {
		return "JwtAuthentication{" +
			"token='" + token + '\'' +
			", id='" + id + '\'' +
			'}';
	}
}
