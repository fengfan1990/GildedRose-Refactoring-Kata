package com.gildedrose;

/**
 * Created by localadmin on 9/13/17.
 */
public class BackstagePass extends Item {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality () {
        if (this.sellIn > 0) this.quality += 1;
        if (this.sellIn < 10 ) this.quality += 1;
        if (this.sellIn < 5 ) this.quality += 1;
        if (this.quality > 50) this.quality = 50;
        if (this.sellIn == 0) this.quality = 0;
        this.sellIn -= 1;
    }
}
