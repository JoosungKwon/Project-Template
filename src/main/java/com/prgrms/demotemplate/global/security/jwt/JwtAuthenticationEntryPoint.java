package com.prgrms.demotemplate.global.security.jwt;

import static org.springframework.http.HttpStatus.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
// import com.prgrms.demotemplate.global.common.ErrorResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint { // JWT 인증 실패시 처리할 동작

	private static final String ERROR_LOG_MESSAGE = "[ERROR] {} : {}";

	private final ObjectMapper objectMapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException {
		log.info(ERROR_LOG_MESSAGE, authException.getClass().getSimpleName(), authException.getMessage());
		response.setStatus(UNAUTHORIZED.value());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// response.getWriter() // 추후에 응답이 결정되면 추가 예정
		// 	.write(objectMapper.writeValueAsString(
		// 		ErrorResponse.from(UNAUTHORIZED.name(), authException.getMessage()))
		// 	);
	}
}
