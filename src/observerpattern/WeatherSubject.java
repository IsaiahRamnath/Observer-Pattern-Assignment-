
package observerpattern;


public interface WeatherSubject {
    
    public void attach (WeatherObserver user);
    public void detach (WeatherObserver user);
    public void notifyObservers ();
    
    public Object getUpdate (WeatherObserver user);
    
    
}
