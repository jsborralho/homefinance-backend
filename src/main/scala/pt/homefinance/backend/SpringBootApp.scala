package pt.homefinance.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, ComponentScan}
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@ComponentScan(basePackages = Array("pt.homefinance.backend"))
class SpringBootApp

  @main
  def main(): Unit = SpringApplication.run(classOf[SpringBootApp])


