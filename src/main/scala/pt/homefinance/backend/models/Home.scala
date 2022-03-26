package pt.homefinance.backend.models

import org.springframework.data.mongodb.core.mapping.{Document, Field}
import org.springframework.format.annotation.DateTimeFormat

import java.util
import scala.beans.BeanProperty

@Document("Home")
class Home {

  @BeanProperty
  var date: util.Date = _
  @BeanProperty
  var category: String = _
  @Field("sub-category")
  @BeanProperty
  var subCategory: String = _
  @BeanProperty
  var value: Float = _
}

