
package observerpattern;

import java.util.ArrayList;

public class WeatherTopic implements WeatherSubject{
    
    private ArrayList<WeatherObserver> observers;
    private String message;
    private boolean changed;
    
    private final Object MUTEX = new Object();
    
    WeatherTopic(){
        this.observers = new ArrayList<WeatherObserver>();
        
    }

    @Override
    public void attach(WeatherObserver user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach(WeatherObserver user) {
        if (user == null) throw new NullPointerException("No user to add");
        
        synchronized (MUTEX) {
            if(!observers.contains(user)) observers.add(user);
        }
    }

    @Override
    public void notifyObservers() {
    
    ArrayList<WeatherObserver> observersLocal = null;
    
    synchronized (MUTEX) {
        if(!changed)
            return;
        observersLocal = new ArrayList<>(this.observers);
        this.changed = false;
        
    }
    for (WeatherObserver obj: observersLocal){
    obj.update();
    }
}

    @Override
    public Object getUpdate(WeatherObserver user) {
        return this.message;
    }
    
    public String sendMessage (String message){
        System.out.println("The message was posted: " + message + "\n");
        this.message = message;
        this.changed = true;
        notifyObservers();
        return message;
    }
}
