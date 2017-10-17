package com.ben.katas.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class ShoppingBasket {

    private final ArrayList<Book> books;
    private BigDecimal totalPrice;
    private BigDecimal discount;

    public ShoppingBasket() {
        super();
        this.books = new ArrayList<>();
        this.totalPrice = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.discount = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTotalPriceAfterDiscount() {
        return totalPrice.subtract(discount);
    }

    private void setDiscount(BigDecimal discount) {
        this.discount = discount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void addToBasket(Book book) {
        books.add(book);
        this.totalPrice = this.totalPrice.add(book.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void applyPromotion(Map<String, Promotion> promotions) {
        BigDecimal basePrice = new BigDecimal(8.00);
        BigDecimal percentageDiscount;

        if (promotions == null) {
            throw new IllegalArgumentException("promotion cannot be null");
        }

        Long distinctBooks = books
                .stream()
                .distinct()
                .count();

        if (distinctBooks == 0L | distinctBooks == 1L) {
            setDiscount(new BigDecimal(0));
        }

        if (promotions.containsKey("POTTER" + distinctBooks)) {
            Promotion promotion = promotions.get("POTTER" + distinctBooks);
            percentageDiscount = new BigDecimal(promotion.getPercentageDiscount());
            setDiscount(basePrice.multiply(percentageDiscount).multiply(new BigDecimal(distinctBooks)));
        } else {
            setDiscount(new BigDecimal(0));
        }
    }

}
