package pt.homefinance.backend.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import pt.homefinance.backend.models.Home

trait HomeRepository extends MongoRepository[Home, String]{

  def findHomeByCategory(category: String): Array[Home]

  def findHomeBySubCategory(subCategory: String): Array[Home]




}
