package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void updateQuality_DegradesQualityOfANormalItemByOneBeforeSellByDateHasPassed() {
        Item[] items = new Item[] {new Item("milk", 6,5),new Item("milk", -1,0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("milk", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    public void updateQuality_DegradesQualityTwiceAsFastOnceSellByDatePassed() {
        Item[] items = new Item[] {new Item("milk", 0,10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void updateQuality_NormalItemQualityNeverLowerThanZero(){
        Item[] items = new Item[] {new Item("milk", 0,0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_NeverReturnsNegativeQualityForItems(){
        Item[] items = new Item[] {new Item("milk", 0,1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_IncreasesAgedBrieQualityTheOlderItGets(){
        Item[] items = new Item[] {new Item("Aged Brie", 5,5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void updateQuality_QualityOfAgedBrieNeverExceedFifty(){
        Item[] items = new Item[] {new Item("Aged Brie", 5,50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void updateQuality_SulfurasNeverChangedInQuality (){
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void updateQuality_IncreaseBackstagePassesQualityByOneWhenConcertDateIsMoreThanTenDaysAway() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(41, app.items[0].quality);
    }

    @Test
    public void updateQuality_IncreaseBackstagePassesQualityByTwoWhenConcertDateIsLessThanTenDaysAwayButMoreThanFiveDaysAway() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(42, app.items[0].quality);
    }

    @Test
    public void updateQuality_IncreaseBackstagePassesQualityByThreeWhenConcertDateIsLessThanFiveDaysAway() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(43, app.items[0].quality);
    }

    @Test
    public void updateQuality_BackstageDropQualityToZeroOnceConcertPasses() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void updateQuality_NeverUpdatesQualityOfABackstagePassToBeMoreThanFifty (){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
