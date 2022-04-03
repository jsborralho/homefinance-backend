package pt.homefinance.backend.controllers

import io.micrometer.core.annotation.Timed
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.http.{CacheControl, HttpStatus, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestParam, RestController}
import org.springframework.web.bind.annotation.RequestMethod.GET
import pt.homefinance.backend.models.Home
import pt.homefinance.backend.repositories.HomeRepository

import java.util.Date

@RestController
@RequestMapping(path = Array("/homeFinance"))
class Controller(@Autowired homeRepository: HomeRepository) {


  @Value("${value}")
  val appName: String = null

  @RequestMapping(path = Array("/test"), method = Array(GET))
  @Timed
  def root(): Map[String, Any] = Map("name" -> appName, "message" -> "It works on my machine!")

  @GetMapping(path = Array("/finances"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def getFinances(@RequestParam(required = false) category: String,
                  @RequestParam(required = false) startDate: Date,
                  @RequestParam(required = false) endDate: Date): ResponseEntity[Array[Home]] = {

    var list: Array[Home] = Array()
    if(Option(category).nonEmpty) {
      if(Option(startDate).nonEmpty && Option(endDate).nonEmpty) {
        list = homeRepository.findHomeByDateBetweenAndCategory(startDate, endDate, category)
      } else {
        list = homeRepository.findHomeByCategory(category)
      }
    } else {
      new ResponseEntity[Array[Home]](HttpStatus.BAD_REQUEST)
    }

    new ResponseEntity[Array[Home]](list, HttpStatus.OK)

  }

  @GetMapping(path = Array("/byCategory"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def getFinancesByCategory(@RequestParam category: String
                ): Array[Home] = {
    var list: Array[Home] = homeRepository.findHomeByCategory(category)
    list
  }

  @GetMapping(path = Array("/byDate"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  def getFinancesByDate(@RequestParam(required = false) startDate: Date,
                        @RequestParam(required = false) endDate: Date): Array[Home] = {
    var list: Array[Home] = homeRepository.findHomeByDateBetween(startDate, endDate)
    list
  }
}
