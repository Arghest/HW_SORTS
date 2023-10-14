import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {

    @Test
    public void FewTicketSortPriceTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8);
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17);
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7);
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 17, 20);
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 20);
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("OVB", "LED");
        Ticket[] exp = {ticket5, ticket1, ticket3, ticket8, ticket7};

        Assertions.assertArrayEquals(actual, exp);

    }

    @Test
    public void OneTicketSortPriceTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8);
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17);
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7);
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 17, 20);
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 20);
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("TOF", "LED");
        Ticket[] exp = {ticket4};

        Assertions.assertArrayEquals(actual, exp);
    }

    @Test
    public void ZeroTicketSortPriceTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8);
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17);
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7);
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 17, 20);
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 20);
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("TOF", "DME");
        Ticket[] exp = { };

        Assertions.assertArrayEquals(actual, exp);
    }

    @Test
    public void FewTicketSortTimeTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8); //4
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17); //6
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7); //5
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 18, 20); //2
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 22); //8
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("OVB", "LED", comparator);
        Ticket[] exp = {ticket7, ticket1, ticket5, ticket3, ticket8};

        Assertions.assertArrayEquals(actual, exp);

    }

    @Test
    public void OneTicketSortTimeTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8); //4
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17); //6
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7); //5
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 18, 20); //2
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 22); //8
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("TOF", "LED", comparator);
        Ticket[] exp = {ticket4};

        Assertions.assertArrayEquals(actual, exp);

    }

    @Test
    public void ZeroTicketSortTimeTest() {
        //OVB - Толмачево LED - Пулково DME - Домодедово TOF - Богашёво

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("OVB", "LED", 4000, 4, 8); //4
        Ticket ticket2 = new Ticket("OVB", "DME", 3000, 4, 11);
        Ticket ticket3 = new Ticket("OVB", "LED", 5000, 11, 17); //6
        Ticket ticket4 = new Ticket("TOF", "LED", 6000, 10, 14);
        Ticket ticket5 = new Ticket("OVB", "LED", 3000, 2, 7); //5
        Ticket ticket6 = new Ticket("DME", "LED", 2000, 17, 19);
        Ticket ticket7 = new Ticket("OVB", "LED", 7000, 18, 20); //2
        Ticket ticket8 = new Ticket("OVB", "LED", 6000, 14, 22); //8
        Ticket ticket9 = new Ticket("DME", "TOF", 5500, 1, 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("TOF", "DME", comparator);
        Ticket[] exp = { };

        Assertions.assertArrayEquals(actual, exp);

    }

}

