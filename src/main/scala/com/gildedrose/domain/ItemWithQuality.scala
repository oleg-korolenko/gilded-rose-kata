package com.gildedrose.domain

/**
  * Created by okorolenko on 2019-06-23.
  */
trait ItemWithQuality {
  def updateQuality: ItemWithQuality
  val name: String
  val sellIn: Int
  val quality: Int
}
