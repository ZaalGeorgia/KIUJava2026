package lab01;

public class TripStarter {

    static class TicketDesk {
        void reserve() {
            System.out.println("Ticket reserved");
        }
    }

    static class HotelDesk {
        void reserve() {
            System.out.println("Hotel reserved");
        }
    }

    static class TaxiDesk {
        void reserve() {
            System.out.println("Taxi reserved");
        }
    }

    static class TripButton {
        private final TicketDesk ticketDesk = new TicketDesk();
        private final HotelDesk hotelDesk = new HotelDesk();
        private final TaxiDesk taxiDesk = new TaxiDesk();

        void go() {
            ticketDesk.reserve();
            hotelDesk.reserve();
            taxiDesk.reserve();
        }
    }

    public static void main(String[] args) {
        new TripButton().go();
    }
}
