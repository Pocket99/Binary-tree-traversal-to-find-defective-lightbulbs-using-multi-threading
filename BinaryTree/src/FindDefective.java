public class FindDefective extends Thread {
    private int [] arr;
    private int low;
    private int high;
    private static int threadcounter = 1;
    private int sum;
    FindDefective(int []arr, int low,int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }
    //hello qiu zi qi
    //hello jun yi
    @Override
    public void run() {
        sum = (low+high)/2;
        if(!isLighting(arr,low,high)){
            if(low<high){
                try{
                    FindDefective f1 = new FindDefective(arr,low,sum);
                    threadcounter++;
                    FindDefective f2 = new FindDefective(arr,sum+1,high);
                    threadcounter++;
                    System.out.println("Thread number:" + threadcounter);
                    f1.start();
                    f2.start();
                    f1.join();
                    f2.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                if(arr[sum] == 0) {
                    System.out.println("Defective light bulb:" + sum);
                }
            }
        }


    }
    //return current bulb series is lighting or not
    public boolean isLighting(int []a, int l,int h){
        for (int i =l; i<=h;i++){
            if (a[i] == 0){
                return false;
            }
        }
        return true;
    }
    public static int getThreadCounter(){
        return threadcounter;
    }
}
