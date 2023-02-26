package Interceptor;

public class ConcreteLoggerInterceptor implements LoggerInterceptor {
    
    public void interceptRental(ContextObject con) {
        String result = "Movie: " + con.getMovie() +
                        "\nRented by " + con.getCustomer() + " for " + con.getDaysRented() + " days." + 
                        "\nPrice: " + con.getPrice();
        System.out.println(result);
    }
}
