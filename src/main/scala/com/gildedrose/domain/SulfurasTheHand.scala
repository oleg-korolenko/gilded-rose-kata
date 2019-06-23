package com.gildedrose.domain

/**
  * Created by okorolenko on 2019-06-23.
  */
final case class SulfurasTheHand(sellIn: Int) extends ItemWithQuality {

  override def updateQuality: SulfurasTheHand = this

  override val name: String = "Sulfuras, Hand of Ragnaros"
  override val quality: Int = 80
}
