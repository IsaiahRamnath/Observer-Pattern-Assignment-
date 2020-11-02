/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author isaia
 */
public interface WeatherObserver {
    public void update();
    public void setSubject (WeatherSubject sub);
    
}
