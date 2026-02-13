package ru.netology.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void shouldSortPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket3};
        Ticket[] actual = manager.search("Москва", "Краснодар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNull() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = { };
        Ticket[] actual = manager.search("Москва", "Екатеринбург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("Самара", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSortByTimeOne() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchAndSortBy("Самара", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSortByTime() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket3, ticket5};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Краснодар", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSortByTimeNull() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Краснодар", 5000, 10, 12);
        Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 8000, 10, 11);
        Ticket ticket3 = new Ticket("Москва", "Краснодар", 5000, 8, 10);
        Ticket ticket4 = new Ticket("Самара", "Сочи", 18000, 5, 10);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 3000, 2, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = { };
        Ticket[] actual = manager.searchAndSortBy("Самара", "Екатеринбург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
