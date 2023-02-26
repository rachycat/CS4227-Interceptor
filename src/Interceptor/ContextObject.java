package Interceptor;

import MovieRental.Customer;
import MovieRental.Rental;

//interceptor gets info from context object 
public class ContextObject {
    private Rental rental;
    private Customer customer;

    public ContextObject(Rental r, Customer c) {
        this.rental  = r;
        this.customer = c;
    }

    public String getCustomer() {
        return customer.getName();
    }

    public double getPrice() {
        return rental.getCharge();
    }

    public String getMovie() {
        return rental.getMovie().getTitle();
    }

    public int getDaysRented() {
        return rental.getDaysRented();
    }

    // public int getTotalFrequentRenterPoints() {
    //     return rental.getFrequentRenterPoints();
    // }
}
