package com.ben.katas.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class Book {

    private final String title;
    private final String author;
    private final BigDecimal price;
    private final Category category;
    private final String publisher;

    private Book(String title, String author, BigDecimal price, Category category, String publisher) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.publisher = publisher;
    }

    private String getTitle() {
        return title;
    }

    private String getAuthor() {
        return author;
    }

    BigDecimal getPrice() {
        return price;
    }

    private String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getTitle(), book.getTitle())
                .append(getAuthor(), book.getAuthor())
                .append(getPublisher(), book.getPublisher())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getTitle())
                .append(getAuthor())
                .append(getPublisher())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("author", author)
                .append("price", price)
                .append("category", category)
                .append("publisher", publisher)
                .toString();
    }

    public static class BookBuilder {

        private String title;
        private String author;
        private BigDecimal price;
        private Category category;
        private String publisher;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Book build() {
            if (title == null || author == null || publisher == null) {
                throw new IllegalArgumentException("Title, Author and Publisher must be set");
            }
            if (price == null) {
                this.price = new BigDecimal(8.00);
            }
            if (category == null) {
                this.category = Category.FICTION;
            }

            return new Book(title, author, price, category, publisher);
        }
    }
}
