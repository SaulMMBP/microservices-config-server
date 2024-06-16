package io.github.saulmmbp.configService;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class MicroservicesConfigServerApplicationTests {

    	@Autowired
    	private TestRestTemplate testRestTemplate;
    
	@Test
	public void configurationAvailable() {
	    @SuppressWarnings("rawtypes")
	    ResponseEntity<Map> entity = testRestTemplate.getForEntity("/app/cloud", Map.class);
	    Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void envPostAvailable() {
	    @SuppressWarnings("rawtypes")
	    ResponseEntity<Map> entity = testRestTemplate.getForEntity("/admin/env", Map.class);
	    Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
