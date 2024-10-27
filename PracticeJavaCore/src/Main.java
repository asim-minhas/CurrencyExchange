import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int BUFFER_SIZE = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();
    public static void main(String[] args) {

//    List<String> colors = Arrays.asList("red","blue","green");
//    List<String> sorted = colors.stream().sorted().collect(Collectors.toList());
//        System.out.println(sorted.toString());
//    List<String> reverseSorted = colors.stream()
//            .sorted(Comparator.reverseOrder())
//            .collect(Collectors.toList());
//        System.out.println(reverseSorted);

//List<Integer> intList= Arrays.asList(1,2,3,4,5,8,9);
//int max = intList.stream()
//        .min(Integer::compare)
//        .orElse(null);
//        System.out.println(max);
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

    }
    static class Producer implements Runnable{

        @Override
        public void run() {
            int value =0;
            while(true){
                synchronized (buffer){
                while(buffer.size() == BUFFER_SIZE){
                    try {
                        buffer.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                System.out.println("producer produced value" + value);
                buffer.add(value++);
                buffer.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (buffer){
                while(buffer.isEmpty()){
                    try {
                        buffer.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                int value = buffer.poll();
                System.out.println("Consumer consumed value" + value);
                buffer.add(value++);
                buffer.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }

}