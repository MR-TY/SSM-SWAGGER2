package com.ty.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//如果程序中使用了junit测试则用@WebAppConfiguration
@Configuration
@EnableWebMvc
//扫描control所在的package请修改为你control所在package
@ComponentScan(basePackages = "com.ty.controller.EmployeeController")
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SSM的CRUD接口文档")
				.description("SSM项目接口测试")
				.version("1.0.0")
				.termsOfServiceUrl("")
				.license("")
				.licenseUrl("").build();
	}

}
