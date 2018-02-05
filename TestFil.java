import java.util.Iterator;
import java.util.Random;

public class TestFil {

    SLCWithGet<Integer> list;
    Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("         ______------::::::::    Running Test File    ::::::::-------_______");

        new TestFil();

    }

    public TestFil() {
        list = new SLCWithGet<>();


        for (int i = 0; i < 50; i++) {
            int n = rand.nextInt(100);

            list.add(n);

        }

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("        _____-----:::::: END TEST :::::-.-----_____");

    }

}

