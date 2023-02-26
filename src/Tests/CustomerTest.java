package Tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import Interceptor.ConcreteLoggerInterceptor;
import Interceptor.Dispatcher;
import MovieRental.Customer;
import MovieRental.Movie;
import MovieRental.Rental;

public class CustomerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void rentalTest() {
        ConcreteLoggerInterceptor cli = new ConcreteLoggerInterceptor();
        Dispatcher.getDispatcher().attachInterceptor(cli);

        Customer customer = new Customer("Meara O' Connell");
        Movie movie = new Movie("Song of the Sea",  1);
        Rental rental = new Rental(movie, 3);

        customer.addRental(rental);

        String expected = "Movie: Song of the Sea\nRented by Meara O' Connell for 3 days.\nPrice: 9.0";
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
