package com.example.testingdemo.integration;

import com.example.testingdemo.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateMemberIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createClient() {
        Member member = new Member();
        member.setName("Cherprang");

        ResponseEntity<Member> responseEntity =
                restTemplate.postForEntity("/members", member, Member.class);
        Member memberResponse = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(memberResponse.getName()).isEqualTo("Cherprang");
    }
}
