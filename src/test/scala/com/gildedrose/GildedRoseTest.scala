package com.gildedrose

import com.gildedrose.domain._
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by okorolenko on 2019-06-21.
  */
class GildedRoseTest extends FlatSpec with Matchers {

  behavior of "GildedRose update quantity"

  behavior of "AverageItem"

  it should "update an AverageItem by decreasing quality & sell-in value" in {
    val item = AverageItem("+5 Dexterity Vest", 10, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality - 1))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  it should "update an AverageItem by decreasing sell-in value but keeping quality at 0 since the latter can't go below" in {
    val item = AverageItem("+5 Dexterity Vest", 10, 0)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = 0))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  it should "update an AverageItem by decreasing quality by 2 & sell-in value by 1 if sellin-value is negative" in {
    val item = AverageItem("+5 Dexterity Vest", -1, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality - 2))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  behavior of "BackstagePass"

  it should "update BackstagePass by increasing quality & decreasing sell-in value" in {
    val item =
      BackStagePass("BackstagePass", 11, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality + 1))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  it should "update BackstagePass by increasing quality by 2 & decreasing sell-in value when sell-in <10" in {
    val item =
      BackStagePass("BackstagePass", 10, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality + 2))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)

  }

  it should "update BackstagePass by increasing quality by 3 & decreasing sell-in value when sell-in <5" in {
    val item = BackStagePass("BackstagePass", 5, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality + 3))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)

  }

  it should "update BackstagePass by dropping quality to 0 & decreasing sell-in value when sell-in <=0" in {
    val item = BackStagePass("BackstagePass", 0, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = 0))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)

  }

  behavior of "AgedBrie"

  it should "update AgedBrie by increasing quality & decreasing sell-in value" in {
    val item = AgedBrie(10, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality + 1))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)

  }

  it should "only update AgedBrie by decreasing its sell-in value since quality is already at the max = 50 " in {
    val item = AgedBrie(10, 50)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)

  }

  behavior of "Sulfuras, Hand of Ragnaros"

  it should "not update the legendary item" in {
    val item = SulfurasTheHand(10)

    GildedRose.updateQuality(Array(item)) should equal(Array(item))

  }

  behavior of "ConjuredItem"
  it should "update an average item by decreasing quality by 2 & sell-in value by 1" in {
    val item = ConjuredItem("+5 Dexterity Vest", 10, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality - 2))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  it should "update an average item by decreasing sell-in value but keeping quality at 0 since the latter can't go below" in {
    val item = ConjuredItem("+5 Dexterity Vest", 10, 0)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = 0))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }

  it should "update an average item by decreasing quality by 4 & sell-in value by 1 if sellin-value is negative" in {
    val item = ConjuredItem("+5 Dexterity Vest", -1, 20)

    val expectedItems =
      Array(item.copy(sellIn = item.sellIn - 1, quality = item.quality - 4))

    GildedRose.updateQuality(Array(item)) should equal(expectedItems)
  }
}
