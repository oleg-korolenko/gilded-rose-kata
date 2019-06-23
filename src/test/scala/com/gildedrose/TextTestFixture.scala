package com.gildedrose

import com.gildedrose.domain.{
  AgedBrie,
  AverageItem,
  BackStagePass,
  ConjuredItem,
  ItemWithQuality,
  SulfurasTheHand
}

/**
  * Created by okorolenko on 2019-06-21.
  */
object TexttestFixture {
  def main(args: Array[String]): Unit = {
    var items = Array[ItemWithQuality](
      AverageItem("+5 Dexterity Vest", 10, 20),
      AgedBrie(2, 0),
      AverageItem("Elixir of the Mongoose", 5, 7),
      SulfurasTheHand(0),
      SulfurasTheHand(-1),
      BackStagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      BackStagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      BackStagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      // this conjured item does not work properly yet
      ConjuredItem("Conjured Mana Cake", 3, 6)
    )

    val days = if (args.length > 0) args(0).toInt + 1 else 2
    for (i <- 0 until days) {
      System.out.println("-------- day " + i + " --------")
      System.out.println("name, sellIn, quality")
      for (item <- items) {
        System.out.println(item.name + ", " + item.sellIn + ", " + item.quality)
      }
      System.out.println()
      items = GildedRose.updateQuality(items)
    }
  }
}
