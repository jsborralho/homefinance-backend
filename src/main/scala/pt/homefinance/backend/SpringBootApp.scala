package pt.homefinance.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = Array("pt.homefinance.backend"))
class SpringBootApp

  @main
  def main(): Unit = SpringApplication.run(classOf[SpringBootApp])

