package ru.netology.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void shouldSortPrice() {
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Краснодар", "Волгоград", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Сочи", "Краснодар", 3000, 2, 4);

        int expected1 = -1;
        int actual1 = ticket1.compareTo(ticket4);

        Assertions.assertEquals(expected1, actual1);

        int expected2 = 1;
        int actual2 = ticket4.compareTo(ticket5);

        Assertions.assertEquals(expected2, actual2);

        int expected3 = 0;
        int actual3 = ticket3.compareTo(ticket1);

        Assertions.assertEquals(expected3, actual3);

        int expected4 = 1;
        int actual4 = ticket2.compareTo(ticket3);
        Assertions.assertEquals(expected4, actual4);
    }

    @Test
    public void shouldSearchSort() {
        AviaSouls manager = new AviaSouls();

        manager.add(new Ticket("Москва", "Краснодар", 5000, 10, 12));
        manager.add(new Ticket("Москва", "Краснодар", 5000, 8, 10));
        manager.add(new Ticket("Москва", "Краснодар", 3000, 2, 4));
        manager.add(new Ticket("Москва", "Краснодар", 18000, 5, 10));
        manager.add(new Ticket("Москва", "Краснодар", 8000, 10, 11));

        Ticket[] result = manager.search("Москва", "Краснодар");

        int expected1 = 3000;
        int actual1 = result[0].getPrice();

        Assertions.assertEquals(expected1, actual1);

        int expected2 = 5000;
        int actual2 = result[1].getPrice();

        Assertions.assertEquals(expected2, actual2);

        int expected3 = 5000;
        int actual3 = result[2].getPrice();

        Assertions.assertEquals(expected3, actual3);

        int expected4 = 8000;
        int actual4 = result[3].getPrice();

        Assertions.assertEquals(expected4, actual4);

        int expected5 = 18000;
        int actual5 = result[4].getPrice();

        Assertions.assertEquals(expected5, actual5);
    }

    @Test
    public void shouldSearchSortByTime() {
        AviaSouls manager = new AviaSouls();

        manager.add(new Ticket("Москва", "Краснодар", 5000, 10, 12));
        manager.add(new Ticket("Москва", "Краснодар", 5000, 8, 10));
        manager.add(new Ticket("Москва", "Краснодар", 3000, 2, 4));
        manager.add(new Ticket("Москва", "Краснодар", 18000, 5, 10));
        manager.add(new Ticket("Москва", "Краснодар", 8000, 10, 11));

        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] result = manager.searchAndSortBy("Москва", "Краснодар", comparator);

        int expected1 = 1;
        int actual1 = result[0].getTimeTo() - result[0].getTimeFrom();

        Assertions.assertEquals(expected1, actual1);

        int expected2 = 2;
        int actual2 = result[1].getTimeTo() - result[1].getTimeFrom();

        Assertions.assertEquals(expected2, actual2);

        int expected3 = 2;
        int actual3 = result[2].getTimeTo() - result[2].getTimeFrom();

        Assertions.assertEquals(expected3, actual3);

        int expected4 = 2;
        int actual4 = result[3].getTimeTo() - result[3].getTimeFrom();

        Assertions.assertEquals(expected4, actual4);

        int expected5 = 5;
        int actual5 = result[4].getTimeTo() - result[4].getTimeFrom();

        Assertions.assertEquals(expected5, actual5);
    }
}
