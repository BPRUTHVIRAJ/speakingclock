package Configuration;

import javax.swing.text.Document;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public Document api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.speakingclock.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(new ApiInfoBuilder()
                .title("Speaking Clock API")
                .description("Convert 24-hour clock to spoken time")
                .version("1.0")
                .build());
    }
}

