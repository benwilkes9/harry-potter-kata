package com.ben.katas;

import com.ben.katas.domain.Book;
import com.ben.katas.domain.Promotion;
import com.ben.katas.domain.ShoppingBasket;

import java.util.ArrayList;
import java.util.Map;

abstract class BookStore {
    /*
        Abstract class to very simply illustrate basic relationship between books, promotions
        and ShoppingBasket. Implementing this along with related classes like customer & checkout is beyond the scope of the kata
     */

    private ArrayList<Book> books;
    private Map<String, Promotion> promotions;
    private ShoppingBasket shoppingBasket;
}