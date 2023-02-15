package com.prgrms.demotemplate.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prgrms.demotemplate.base.RepositoryTest;

class SampleRepositoryTest extends RepositoryTest {

	@Autowired
	private SampleRepository sampleRepository;

	@Test
	@DisplayName("DB 연결 테스트")
	void connect_db_test() {
		sampleRepository.findById(1L);
	}

}
