package bluetoothstudy.qiaojim.com.lib;


public class myClass {

    public static void main(String[] args){
        System.out.print("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.notify();
    }
}
