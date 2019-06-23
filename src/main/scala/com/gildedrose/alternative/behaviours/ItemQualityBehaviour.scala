package com.gildedrose.alternative.behaviours

import com.gildedrose.alternative.domain.{AgedBrie, AverageItem, BackStagePass}
import com.gildedrose.domain.SulfurasTheHand

object ItemQualityBehaviour {

  /**
    * Alternative solution using Type classes
    * All item quality update behaviours  are grouped here
    * Created by okorolenko on 2019-06-21.
    */
  /**
    * Operations available on Item
    */
  trait ItemQualityUpdater[T] {
    def updateQuality(source: T): T
  }

  object ItemQualityUpdater {
    def apply[T](
        implicit updater: ItemQualityUpdater[T]
    ): ItemQualityUpdater[T] =
      updater
  }

  /**
    * Implementations of operations on concrete Item
    */
  object ItemQualityUpdaters {

    implicit val backstagePassUpdater: ItemQualityUpdater[BackStagePass] =
      new ItemQualityUpdater[BackStagePass] {
        override def updateQuality(source: BackStagePass): BackStagePass = {
          source.sellIn match {
            case s if s <= 0 => source.copy(sellIn = s - 1, quality = 0)
            case s if s <= 5 =>
              source.copy(
                sellIn = s - 1,
                quality = Math.max(50, source.quality + 3)
              )
            case s if s <= 10 =>
              source.copy(
                sellIn = s - 1,
                quality = Math.max(50, source.quality + 2)
              )
            case _ =>
              source.copy(
                sellIn = source.sellIn - 1,
                quality = Math.max(50, source.quality + 1)
              )
          }
        }
      }

    implicit val agedBrieUpdater: ItemQualityUpdater[AgedBrie] =
      new ItemQualityUpdater[AgedBrie] {
        override def updateQuality(source: AgedBrie): AgedBrie = {
          source.quality match {
            case q if q >= 50 => source.copy(sellIn = source.sellIn - 1)
            case _ =>
              source.copy(
                sellIn = source.sellIn - 1,
                quality = source.quality + 1
              )
          }
        }
      }

    implicit val averageItemUpdater: ItemQualityUpdater[AverageItem] =
      new ItemQualityUpdater[AverageItem] {
        override def updateQuality(source: AverageItem): AverageItem = {
          source.sellIn match {
            case s if s < 0 =>
              source.copy(
                sellIn = source.sellIn - 1,
                quality = Math.max(0, source.quality - 2)
              )
            case _ =>
              source.copy(
                sellIn = source.sellIn - 1,
                quality = Math.max(0, source.quality - 1)
              )
          }
        }
      }

    implicit val legendaryItemUpdater: ItemQualityUpdater[SulfurasTheHand] =
      new ItemQualityUpdater[SulfurasTheHand] {
        // identity function
        override def updateQuality(source: SulfurasTheHand): SulfurasTheHand =
          source
      }

  }

  /**
    * Exposed operations syntax so those can be used  directly on Item
    */
  object ItemSyntax {
    implicit class ItemOps[T: ItemQualityUpdater](source: T) {
      def updateQuality(): T =
        ItemQualityUpdater[T].updateQuality(source)

    }
  }

}
