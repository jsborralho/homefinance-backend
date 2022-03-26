package pt.homefinance.backend.models

import org.springframework.data.mongodb.core.mapping.{Document, Field}

import scala.beans.BeanProperty

@Document("Home")
class Home {

  @BeanProperty
  var date: String = _
  @BeanProperty
  var category: String = _
  @Field("sub-category")
  @BeanProperty
  var subCategory: String = _
  @BeanProperty
  var value: Float = _
}

object Home {
  def apply(date: String, category: String, subCategory: String, value: Float): Home = {
    val home = new Home
    home.date = date
    home.category = category
    home.subCategory = subCategory
    home.value = value

    home
  }
}
