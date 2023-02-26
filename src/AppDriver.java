import Interceptor.ConcreteLoggerInterceptor;
import Interceptor.Dispatcher;
import MovieRental.Customer;
import MovieRental.Movie;
import MovieRental.Rental;

public class AppDriver {
    
    public static void main(String[] args) {
        ConcreteLoggerInterceptor cli = new ConcreteLoggerInterceptor();
        Dispatcher.getDispatcher().attachInterceptor(cli);

        Customer customer = new Customer("Meara O' Connell");
        Movie movie = new Movie("Song of the Sea",  1);
        Rental rental = new Rental(movie, 3);

        customer.addRental(rental);
    }

}
