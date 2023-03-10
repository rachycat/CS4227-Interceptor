package MovieRental;

import java.util.ArrayList;
import java.util.List;

import Interceptor.ContextObject;
import Interceptor.Dispatcher;

public class Customer {

    private String _name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        //interception point
        ContextObject con = new ContextObject(arg, this);
        Dispatcher.getDispatcher().interceptRental(con);
        rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        
        for(Rental each : rentals) {
            result +=  each.getCharge();
        }
        return result;
    }

    private double getTotalFrequentRenterPoints() {
        double result = 0;

        for(Rental each : rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}