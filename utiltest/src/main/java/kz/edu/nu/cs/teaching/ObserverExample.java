package kz.edu.nu.cs.teaching;

import java.util.HashSet;
import java.util.Set;

public class ObserverExample {
    public static void main(String[] args) {
        SensorListener o1 = new SensorListener("Listener 1");
        SensorListener o2 = new SensorListener("Listener 2");
        
        SensorSubject sensor = new SensorSubject();
        
        sensor.addListener(o1);
        sensor.addListener(o2);
        
        Thread t = new Thread(new SensorEnvironment(sensor));
        t.start();
    }
}

class SensorEnvironment implements Runnable {
    private SensorSubject sensor;
    
    public SensorEnvironment(SensorSubject sensor) {
        this.sensor = sensor;
    }
    
    @Override
    public void run() {
        int n = 20;
        
        while (n-- > 0) {
            if (Math.random() > 0.6) {
                System.out.println(n + ". Event!");
                sensor.eventHappened();
            } else {
                System.out.println(n + ". No event. :(");
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

interface Sensable {
    public void addListener(Listens l);
    public void removeListener(Listens l);
    public void notifyListeners();
}

interface Listens {
    public void update();
}

class SensorSubject implements Sensable {
    private Set<Listens> sensorListeners = new HashSet<Listens>();

    @Override
    public void addListener(Listens l) {
        sensorListeners.add(l);
    }

    @Override
    public void removeListener(Listens l) {
        sensorListeners.remove(l);
    }

    @Override
    public void notifyListeners() {
        for(Listens e : sensorListeners) {
            e.update();
        }
    }
    
    public void eventHappened() {
        this.notifyListeners();
    }
}

class SensorListener implements Listens {
    private String name;
    
    public SensorListener(String name) {
        this.name = name;
    }
    
    @Override
    public void update() {
        System.out.println("Message Received by " + this.name);
    }
}