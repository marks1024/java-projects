package kz.edu.nu.cs.teaching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class TestExamples {
    public static void main(String[] args) {
        TestExamples t = new TestExamples();
        
        t.magic((b,w) -> (long)w.intValue());
        
        // t.wakeUp(() -> System.out.println("Hello, world."));
        t.wakeUp(() -> "S");
        
        ReportExample report = new ReportExample();
        // report.submitReports();
        
        List<String> l = Arrays.asList("Alpha", "Beta", "Epsilon");
        
        List<? extends Manager> ceos = new ArrayList<CEO>();
        
        // begin
        StringBuilder sb = new StringBuilder();
        for(String e : l) {
            sb.append("\n").append(e);
        }
        String s = sb.toString();
        // end
        
        System.out.println(s);
    }
    
    public void magic(BinaryOperator<Long> lambda) {
        lambda.apply(3L, 7L);
    }
    
    public void wakeUp(Supplier supplier) { // d1
        supplier.get();
     }
    
}

class ReportExample {
    public void submitReports() {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            service.submit(this.getJob(i));
        }

        service.shutdown();
    }

    public Runnable getJob(int i) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
    }
}

class Manager {}
class CEO extends Manager {}
