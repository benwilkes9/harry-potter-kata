package com.ben.katas.domain;

public class Promotion {

    private final String code;
    private final String description;
    private final Double percentageDiscount;

    private Promotion(String code, String description, Double percentageDiscount) {
        this.code = code;
        this.description = description;
        this.percentageDiscount = percentageDiscount;
    }

    public String getCode() {
        return code;
    }

    String getDescription() {
        return description;
    }

    Double getPercentageDiscount() {
        return percentageDiscount;
    }

    public static class PromotionBuilder {

        private String code;
        private String description;
        private Double percentageDiscount;

        public PromotionBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public PromotionBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PromotionBuilder setPercentageDiscount(double percentageDiscount) {
            this.percentageDiscount = percentageDiscount;
            return this;
        }

        public Promotion build() {
            return new Promotion(code, description, percentageDiscount);
        }

    }

}
