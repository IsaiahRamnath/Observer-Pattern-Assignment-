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
public class WeatherTopicSubscriber implements WeatherObserver{
    private final String name;
    private WeatherSubject topic;
    
    WeatherTopicSubscriber (String name){
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String)topic.getUpdate(this);
        
        if (msg == null){
            System.out.println("\t Greetings, " + name + "there are no weather updates. \n");
            
        }
        else{
            System.out.println("\t COngratulations " + name + ", " + msg + "\n");
        }
    }

    @Override
    public void setSubject(WeatherSubject sub) {
        this.topic = sub;
    }
    
}
