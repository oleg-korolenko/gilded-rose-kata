package com.gildedrose.domain

import java.lang.Math.max

/**
  * Created by okorolenko on 2019-06-23.
  */
final case class AverageItem(name: String, sellIn: Int, quality: Int)
    extends ItemWithQuality {
  override def updateQuality: AverageItem = {
    this.sellIn match {
      case s if s < 0 =>
        this.copy(
          sellIn = this.sellIn - 1,
          quality = max(0, this.quality - 2)
        )
      case _ =>
        this.copy(
          sellIn = this.sellIn - 1,
          quality = max(0, this.quality - 1)
        )
    }
  }

}
