package pt.homefinance.backend.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootApp

  @main
  def main(): Unit = SpringApplication.run(classOf[SpringBootApp])

