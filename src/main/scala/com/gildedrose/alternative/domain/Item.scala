package com.gildedrose.alternative.domain

/**
  * Simple ADTs with no behaviour whatsoever (see ItemQualityBehaviour)
  * Created by okorolenko on 2019-06-21.
  */
sealed trait Item

final case class AverageItem(name: String, sellIn: Int, quality: Int)
    extends Item
final case class AgedBrie(
    sellIn: Int,
    quality: Int
) extends Item {
  val name: String = "Aged Brie "
}

final case class BackStagePass(name: String, sellIn: Int, quality: Int)
    extends Item

final case class SulfurasTheHand(sellIn: Int) extends Item {
  val name: String = "Sulfuras, Hand of Ragnaros"
  val quality: Int = 80
}
