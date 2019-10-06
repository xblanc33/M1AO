package fr.ubordeaux.ao.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    @Test
    public void testBasket() {

        Basket basket = new Basket();

        AlphabetWord bookId = new AlphabetWord("bookId");
        AlphabetWord book = new AlphabetWord("book");
        Reference ref = new Reference(bookId, book, "good book", new Price(10));

        basket.order(ref, 1);
        assertEquals(10, basket.getPrice().getValue());
        basket.order(ref, 3);
        assertEquals(30, basket.getPrice().getValue());

        AlphabetWord musicId = new AlphabetWord("musicId");
        AlphabetWord music = new AlphabetWord("music");
        Reference ref2 = new Reference(musicId, music, "good music", new Price(20));

        basket.order(ref2, 1);
        assertEquals(50, basket.getPrice().getValue());

    }

}