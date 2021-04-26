import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Contact CONTACT = new Contact("Hellow", "", "");
	private static final String license = null;
	private static final String licenseUrl = null;
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("title", "description", "version", "termsOfServiceUrl", license, licenseUrl, "");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}

}
