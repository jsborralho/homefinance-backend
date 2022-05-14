package pt.homefinance.backend.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import pt.homefinance.backend.models.Home

import java.util.Date

trait HomeRepository extends MongoRepository[Home, String]{

  def findHomeByCategory(category: String): Array[Home]

  def findHomeBySubCategory(subCategory: String): Array[Home]

  def findHomeByDateBetween(startDate: Date, endDate: Date): Array[Home]

  def findHomeByDateBetweenAndCategory(startDate: Date, endDate: Date, category: String): Array[Home]
  


}
