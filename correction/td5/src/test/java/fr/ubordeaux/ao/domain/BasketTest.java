package fr.ubordeaux.ao.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    @Test
    public void testBasket() {

        Basket basket = new Basket(1);//first basket for ever

        int bookId = 12345;
        AlphabetWord book = new AlphabetWord("book");
        Reference ref = new Reference(bookId, book, "good book", new Price(10));

        basket.order(ref, 1);
        assertEquals(10, basket.getPrice().getValue());
        basket.order(ref, 3);
        assertEquals(30, basket.getPrice().getValue());

        int musicId = 12346;
        AlphabetWord music = new AlphabetWord("music");
        Reference ref2 = new Reference(musicId, music, "good music", new Price(20));

        basket.order(ref2, 1);
        assertEquals(50, basket.getPrice().getValue());

    }

}