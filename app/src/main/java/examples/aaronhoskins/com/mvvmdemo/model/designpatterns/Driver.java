package examples.aaronhoskins.com.mvvmdemo.model.designpatterns;

public class Driver {
    public static void main(String[] args) {
        Singleton singletonOne;
        Singleton singletonTwo;

        singletonOne = Singleton.getInstance("ONE");
        singletonTwo = Singleton.getInstance("TWO");

        System.out.println(singletonOne.getTag());
        System.out.println(singletonTwo.getTag());
    }
}
