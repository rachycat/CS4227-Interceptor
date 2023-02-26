package Interceptor;
import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<LoggerInterceptor> interceptor;
    private static Dispatcher instance;

    public Dispatcher() {
        interceptor =  new ArrayList<>();
    }

    public static Dispatcher getDispatcher() {
        if(instance == null) {
            instance = new Dispatcher();
        }  
        return instance; 
    }

    public void attachInterceptor(LoggerInterceptor in) {
        interceptor.add(in);
    }

   public void detachInterceptor(LoggerInterceptor in) {
        interceptor.add(in);
   }

   public void interceptRental(ContextObject con) {
        for(LoggerInterceptor in : interceptor) {
            ConcreteLoggerInterceptor cli = (ConcreteLoggerInterceptor) in;
            cli.interceptRental(con);
        }
   }
}
