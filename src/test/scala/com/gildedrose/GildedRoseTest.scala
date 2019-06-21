package com.gildedrose

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by okorolenko on 2019-06-21.
  */
class GildedRoseTest extends FlatSpec with Matchers {

  behavior of "GildedRose update quantity"

  behavior of "average item"

  it should "update an average item by decreasing quality & sell-in value" in {
    val items = Array[Item](
      new Item("+5 Dexterity Vest", 10, 20)
    )

    val expectedItem = new Item("+5 Dexterity Vest", 9, 19)
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)
  }

  it should "update an average item by decreasing sell-in value but keeping quality at 0 since the latter can't go below" in {
    val items = Array[Item](
      new Item("+5 Dexterity Vest", 10, 0)
    )

    val expectedItem = new Item("+5 Dexterity Vest", 9, 0)
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)
  }

  it should "update an average item by decreasing quality by 2 & sell-in value by 1 if sellin-value is negative" in {
    val items = Array[Item](
      new Item("+5 Dexterity Vest", 0, 20)
    )

    val expectedItem = new Item("+5 Dexterity Vest", -1, 18)
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)
  }

  behavior of "Backstage passes to a TAFKAL80ETC concert"

  it should "update [Backstage passes to a TAFKAL80ETC concert] by increasing quality & decreasing sell-in value" in {
    val items = Array[Item](
      new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)
    )

    val expectedItem =
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 21)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }
  // TODO in specs <=10
  it should "update backstage passes by increasing quality by 2 & decreasing sell-in value when sell-in <10" in {
    val items = Array[Item](
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
    )

    val expectedItem =
      new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }
  // TODO in specs <=5
  it should "update backstage passes by increasing quality by 3 & decreasing sell-in value when sell-in <5" in {
    val items = Array[Item](
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
    )

    val expectedItem =
      new Item("Backstage passes to a TAFKAL80ETC concert", 4, 23)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }

  it should "update backstage passes by dropping quality to 0 & decreasing sell-in value when sell-in <0" in {
    val items = Array[Item](
      new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
    )

    val expectedItem =
      new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }

  behavior of "Aged Brie"

  it should "update [Aged Brie] by increasing quality & decreasing sell-in value" in {
    val items = Array[Item](
      new Item("Aged Brie", 10, 20)
    )

    val expectedItem = new Item("Aged Brie", 9, 21)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }

  it should "only update [Aged Brie] by decreasing its sell-in value since quality is already at the max = 50 " in {
    val items = Array[Item](
      new Item("Aged Brie", 10, 50)
    )

    val expectedItem = new Item("Aged Brie", 9, 50)
    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }

  behavior of "Sulfuras, Hand of Ragnaros"

  it should "not update the legendary item" in {
    val item = new Item("Sulfuras, Hand of Ragnaros", 10, 10)
    val items = Array[Item](item)

    val expectedItem = item

    val app = new GildedRose(items)
    app.updateQuality()

    app.items(0).name should equal(expectedItem.name)
    app.items(0).sellIn should equal(expectedItem.sellIn)
    app.items(0).quality should equal(expectedItem.quality)

  }

}
