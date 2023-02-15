package com.prgrms.demotemplate.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SampleController {

	@GetMapping("/sample")
	public ResponseEntity<TestResponse> ok(
		@RequestBody TestRequest testRequest
	) {
		return ResponseEntity.ok(
			new TestResponse(testRequest.id(), testRequest.title()));
	}

	public record TestResponse(
		Long id,
		String title
	) {
	}

	public record TestRequest(
		Long id,
		String title
	) {
	}

}

