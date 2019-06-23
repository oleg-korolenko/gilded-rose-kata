package com.gildedrose.domain

import java.lang.Math.min

/**
  * Created by okorolenko on 2019-06-23.
  */
final case class BackStagePass(name: String, sellIn: Int, quality: Int)
    extends ItemWithQuality {
  override def updateQuality: BackStagePass = {
    this.sellIn match {
      case s if s <= 0 => this.copy(sellIn = s - 1, quality = 0)
      case s if s <= 5 =>
        this.copy(
          sellIn = s - 1,
          quality = min(50, this.quality + 3)
        )
      case s if s <= 10 =>
        this.copy(
          sellIn = s - 1,
          quality = min(50, this.quality + 2)
        )
      case _ =>
        this.copy(
          sellIn = this.sellIn - 1,
          quality = min(50, this.quality + 1)
        )
    }
  }

}
