package com.gildedrose.domain

/**
  * Created by okorolenko on 2019-06-23.
  */
final case class AgedBrie(sellIn: Int, quality: Int) extends ItemWithQuality {

  override val name: String = "Aged Brie"

  override def updateQuality: AgedBrie = {
    this.quality match {
      case q if q >= 50 => this.copy(sellIn = this.sellIn - 1)
      case _ =>
        this.copy(
          sellIn = this.sellIn - 1,
          quality = this.quality + 1
        )
    }
  }

}
