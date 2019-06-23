package com.gildedrose

import com.gildedrose.domain.ItemWithQuality

/**
  * Created by okorolenko on 2019-06-21.
  */
object GildedRose {

  def updateQuality(
      items: Array[ItemWithQuality]
  ): Array[ItemWithQuality] = {
    items.map(_.updateQuality)
  }
}
