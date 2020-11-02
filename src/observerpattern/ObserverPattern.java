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
import javax.swing.JFrame;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Scanner;

public class ObserverPattern {

    
    static JFrame s = new MainWeather();
    
    public static void main(String[] args) {
        
        MainWeather W = new MainWeather();
        W.setVisible(true);
        
        MainWeather s = new MainWeather ();
        s.setVisible(true);
       
        WeatherTopic topic = new WeatherTopic();
        Scanner input = new Scanner(System.in);
        
        String a,b,c;
        
        System.out.println("Enter Name: ");
        
        System.out.println("\t First Name: ");
        a = input.next();
        System.out.println("\t Second Name: ");
        b = input.next();
        System.out.println("\t Third Name: ");
        c = input.next();
        
        WeatherObserver A = new WeatherTopicSubscriber(a);
        WeatherObserver B = new WeatherTopicSubscriber(b);
        WeatherObserver C = new WeatherTopicSubscriber(c);
        
        topic.attach(A);
        topic.attach(B);
        topic.attach(C);
        
        A.setSubject(topic);
        B.setSubject(topic);
        C.setSubject(topic);
        
        System.out.println("Select which day you'd like to see the weather"
        + "\n 1  Monday"
        + "\n 2  Tuesday"
        + "\n 3  Wednesday \n");
        
        System.out.print("Day selection: ");
        int pick = input.nextInt();
        DateFormatSymbols symbols = new DateFormatSymbols();
        Date date = new Date();
        DateFormat full = new SimpleDateFormat("MMMM dd, yyyy");
        
        switch (pick){
            case 1:
                System.out.println("\t Monday's weather is " + full.format(date));
                topic.sendMessage("Humidity: 80%     40% chance of rain");
                break;
                
            case 2:
                System.out.println("\t Tuesday's weather is " + full.format(date));
                topic.sendMessage("Humidity: 60%     15% chance of rain");
                break;
                
            case 3:
                System.out.println("\t Wednesday's weather is " + full.format(date));
                topic.sendMessage("Humidity: 30%     0% chance of rain");
                break;
            default:
                System.err.println("Day selection is invalid.");
                        
              
        }
        
        


        
        
        
        
    }
    
}
