package pt.homefinance.backend.controllers

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.http.{CacheControl, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RestController}
import org.springframework.web.bind.annotation.RequestMethod.GET
import pt.homefinance.backend.models.Home
import pt.homefinance.backend.repositories.HomeRepository

@RestController
class Controller(@Autowired homeRepository: HomeRepository) {


  @Value("${value}")
  val appName: String = null

  @RequestMapping(path = Array("/test"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = Map("name" -> appName, "message" -> "It works on my machine!")

  @RequestMapping(path = Array("/byCategory"), method = Array(GET), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def get(): Array[Home] = {
    var list: Array[Home] = homeRepository.findHomeByCategory("Income")
    list
  }
}
