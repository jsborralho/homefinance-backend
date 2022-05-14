package pt.homefinance.backend.boot

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.{CorsRegistry, EnableWebMvc, WebMvcConfigurer}

@Configuration
@EnableWebMvc
class CorsConfig extends WebMvcConfigurer {

  override def addCorsMappings(registry: CorsRegistry): Unit = registry.addMapping("/**")
}
