package com.gildedrose;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {

        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Aged Brie")) {
                AgedBrie agedBrie = new AgedBrie(items[i].name, items[i].sellIn, items[i].quality);
                agedBrie.updateQuality();
                items[i] = agedBrie;
            } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                Sulfuras sulfuras = new Sulfuras(items[i].name, items[i].sellIn, items[i].quality);
                sulfuras.updateQuality();
                items[i] = sulfuras;
            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                BackstagePass backstagePass = new BackstagePass(items[i].name, items[i].sellIn, items[i].quality);
                backstagePass.updateQuality();
                this.items = new Item[]{backstagePass};
            } else {
                Normal normal = new Normal(items[i].name, items[i].sellIn, items[i].quality);
                normal.updateQuality();
                items[i] = normal;
            }
        }
    }
}
