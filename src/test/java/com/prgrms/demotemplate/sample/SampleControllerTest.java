package com.prgrms.demotemplate.sample;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.JsonFieldType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParametersBuilder;
import com.prgrms.demotemplate.base.ControllerTest;

class SampleControllerTest extends ControllerTest {

    @Test
    @DisplayName("swagger 변환 테스트")
    void restDocs_To_SwaggerUI_Test() throws Exception {
        mockMvc.perform(get("/api/v1/sample")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(
                    new SampleController.TestRequest(1L, "테스트")
                ))
            )
            .andExpect(status().isOk())
            .andDo(
                MockMvcRestDocumentationWrapper.document("sample",
                    new ResourceSnippetParametersBuilder()
                        .tag("sample")
                        .description("Get a sample by id")
                        .responseFields(
                            fieldWithPath("id").type(STRING).description("The sample identifier."),
                            fieldWithPath("name").type(STRING).description("The name of sample.")
                        )
                )
            );
    }
}