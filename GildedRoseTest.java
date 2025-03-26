package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

    
	@Test
    public void testTheTruth() {
        assertTrue(true);
    }

    @Test
    public void exampleTest() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Failed quality for Dexterity Vest", 19, quality);
    }

    @Test
    public void testAgedBrieQualityIncreases() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Aged Brie", 5, 0));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Failed quality for Aged Brie", 1, quality);
    }

    @Test
    public void testSulfurasQualityStaysTheSame() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Failed quality for Sulfuras", 80, quality);
    }

    @Test
    public void testItemQualityDoesNotGoBelowZero() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("+5 Dexterity Vest", 0, 0));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Quality should not go below 0", 0, quality);
    }

    @Test
    public void testQualityCannotExceedFifty() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Aged Brie", 5, 49));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Quality should not exceed 50", 50, quality);
    }

    @Test
    public void testBackstagePassQualityIncreasesAsSellInApproaches() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();

        assertEquals("Failed quality for Backstage passes (SellIn > 10)", 21, quality);
    }

    @Test
    public void testBackstagePasses_QualityIncreasesBy2_LessThan10Days() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(22, quality);
    }

    @Test
    public void testBackstagePasses_QualityIncreasesBy3_LessThan5Days() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(23, quality);
    }

    @Test
    public void testBackstagePasses_QualityDropsToZero_AfterConcert() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(0, quality);
    }

    @Test
    public void testGenericItemDegradesTwiceAsFastAfterSellIn() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("+5 Dexterity Vest", 0, 10));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(8, quality); 
    }

    @Test
    public void testBackstagePasses_DoesNotExceedFifty() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(50, quality);
    }

    @Test
    public void testAgedBrie_DoesNotExceedFifty_AfterSellIn() {
        GildedRose inn = new GildedRose();
        inn.setItem(new Item("Aged Brie", -1, 49));
        inn.oneDay();

        List<Item> items = inn.getItems();
        int quality = items.get(0).getQuality();
        assertEquals(50, quality);
    }
}
    