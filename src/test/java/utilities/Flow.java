package utilities;

public class Flow {

    public static void wait(int waitTime){
        try{
            Thread.sleep(waitTime);
        }
        catch (InterruptedException e){
            System.out.println();
        }
    }
}
