package pt.homefinance.backend.controllers

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.{CacheControl, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RestController}
import org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
class TestController {
  @Value("${application.name}")
  val appName: String = null

  @RequestMapping(path = Array("/test"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = Map("name" -> appName, "message" -> "It works on my machine!")

  @RequestMapping(path = Array("/buildInfo"), method = Array(GET), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def get(): ResponseEntity[String] = {
    ResponseEntity.ok().cacheControl(CacheControl.noStore()).body("test")
  }
}
