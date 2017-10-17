package com.ben.katas;

import com.ben.katas.domain.Book;
import com.ben.katas.domain.Promotion;
import com.ben.katas.domain.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BookStoreTest {

    private Book thePhilosophersStone;
    private Book theChamberOfSecrets;
    private Book thePrisonerOfAzkaban;
    private Book theGobletOfFire;
    private Book theOrderOfthePhoenix;
    private Book theHalfBloodPrince;
    private Book theDeathlyHallows;
    private Map<String, Promotion> promotions;
    private ShoppingBasket basket;

    @Before
    public void setUp() {
        buildBooks();
        buildPromotions();
        basket = new ShoppingBasket();
    }

    @Test
    public void oneBookShouldApplyNoDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8);

        basket.addToBasket(theOrderOfthePhoenix);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void twoSameBooksShouldApplyNoDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 2);

        basket.addToBasket(theOrderOfthePhoenix);
        basket.addToBasket(theOrderOfthePhoenix);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void twoDifferentBooksShouldApplyFivePercentDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 2, 8 * 2, 0.05);

        basket.addToBasket(theOrderOfthePhoenix);
        basket.addToBasket(theGobletOfFire);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void threeSameBooksShouldApplyNoDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 3);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(theDeathlyHallows);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void threeDifferentBooksShouldApplyTenPercentDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 3, 8 * 3, 0.10);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(theGobletOfFire);
        basket.addToBasket(thePhilosophersStone);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void threeBooksIncludingTwoDifferentBooksShouldApplyFivePercentDiscountOnTwoBooks() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 3, 8 * 2, 0.05);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(thePhilosophersStone);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fourSameBooksShouldApplyNoDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 4);

        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fourDifferentBooksShouldApplyTwentyPercentDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 4, 8 * 4, 0.20);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(theGobletOfFire);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(thePrisonerOfAzkaban);
        basket.applyPromotion(promotions);


        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fourBooksIncludingThreeDifferentBooksShouldApplyTenPercentDiscountOnThreeBooks() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 4, 8 * 3, 0.10);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(theGobletOfFire);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fiveSameBooksShouldApplyNoDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 5);

        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.addToBasket(theHalfBloodPrince);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fiveDifferentBooksShouldApplyTwentyFivePercentDiscount() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 5, 8 * 5, 0.25);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(theGobletOfFire);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(thePrisonerOfAzkaban);
        basket.addToBasket(theChamberOfSecrets);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    @Test
    public void fiveBooksIncludingFourDifferentBooksShouldApplyTwentyPercentDiscountOnFourBooks() {
        BigDecimal expectedPrice = calcExpectedPriceAfterDiscount(8 * 5, 8 * 4, 0.20);

        basket.addToBasket(theDeathlyHallows);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(thePhilosophersStone);
        basket.addToBasket(theGobletOfFire);
        basket.addToBasket(theChamberOfSecrets);
        basket.applyPromotion(promotions);

        Assert.assertEquals(expectedPrice, basket.getTotalPriceAfterDiscount());
    }

    private BigDecimal calcExpectedPriceAfterDiscount(int totalBookCost) {
        return calcExpectedPriceAfterDiscount(totalBookCost, 0, 0);
    }

    private BigDecimal calcExpectedPriceAfterDiscount(int totalBookCost, int discountedBookCost, double discountPercent) {
        return new BigDecimal(totalBookCost - (discountedBookCost * discountPercent)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private void buildBooks() {
        thePhilosophersStone = new Book.BookBuilder()
                .setTitle("The Philosophers Stone")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        theChamberOfSecrets = new Book.BookBuilder()
                .setTitle("The Chamber of Secrets")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        thePrisonerOfAzkaban = new Book.BookBuilder()
                .setTitle("The Prisoner of Azkaban")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        theGobletOfFire = new Book.BookBuilder()
                .setTitle("The Goblet of Fire")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        theOrderOfthePhoenix = new Book.BookBuilder()
                .setTitle("The Order of the Phoenix")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        theHalfBloodPrince = new Book.BookBuilder()
                .setTitle("The Half-Blood Prince")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();

        theDeathlyHallows = new Book.BookBuilder()
                .setTitle("The Deathly Hallows")
                .setAuthor("J. K. Rowling")
                .setPublisher("Bloomsbury")
                .build();
    }

    private void buildPromotions() {
        Promotion promotion2 = new Promotion.PromotionBuilder()
                .setCode("POTTER2")
                .setPercentageDiscount(0.05)
                .setDescription("5% Discount on two Harry Potter books")
                .build();

        Promotion promotion3 = new Promotion.PromotionBuilder()
                .setCode("POTTER3")
                .setPercentageDiscount(0.10)
                .setDescription("10% Discount on three Harry Potter books")
                .build();

        Promotion promotion4 = new Promotion.PromotionBuilder()
                .setCode("POTTER4")
                .setPercentageDiscount(0.20)
                .setDescription("20% Discount on four Harry Potter books")
                .build();

        Promotion promotion5 = new Promotion.PromotionBuilder()
                .setCode("POTTER5")
                .setPercentageDiscount(0.25)
                .setDescription("25% Discount on five Harry Potter books")
                .build();

        promotions = new HashMap<>();
        promotions.put(promotion2.getCode(), promotion2);
        promotions.put(promotion3.getCode(), promotion3);
        promotions.put(promotion4.getCode(), promotion4);
        promotions.put(promotion5.getCode(), promotion5);
    }
}