package fun.quanweng.arkhelp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .openapi("3.0.1")
                .info(new Info()
                        .title("ArkHelp API 文档")
                        .description("明日方舟助战表管理系统 API 文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("quanweng")
                                .email("")));
    }
}