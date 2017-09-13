package com.gildedrose;

/**
 * Created by localadmin on 9/13/17.
 */
public class AgedBrie extends Item{

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.quality < 50) this.quality += 1;
        this.sellIn -= 1;
    }
}
