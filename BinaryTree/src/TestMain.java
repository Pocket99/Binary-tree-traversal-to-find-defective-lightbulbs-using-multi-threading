public class TestMain {
    public static void main(String[] args) {
        int [] a = {8,1,1,0,1,1,0,1,1};
        FindDefective test = new FindDefective(a,1,8);
        test.start();
        System.out.println("Main Thread number:" + test.getThreadCounter());
    }
}
