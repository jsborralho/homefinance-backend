package pt.homefinance.backend.boot.configuration

import org.springframework.context.annotation
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.{PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
  @Bean
  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2)
      .select
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any)
      .build
  }
}
