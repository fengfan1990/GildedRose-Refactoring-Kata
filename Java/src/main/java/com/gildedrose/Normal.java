package com.gildedrose;

/**
 * Created by localadmin on 9/13/17.
 */
public class Normal extends Item {

    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.sellIn <= 0 && this.quality > 0) this.quality -= 1;
        if (this.quality > 0) this.quality -= 1;
        this.sellIn -= 1;
    }
}
