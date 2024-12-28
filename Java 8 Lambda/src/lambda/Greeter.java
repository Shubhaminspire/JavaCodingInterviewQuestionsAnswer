package lambda;

import java.util.Scanner;

public class Greeter {
    static String name = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of person to greet: ");
        name = sc.nextLine();
        Greeter greeter = new Greeter();
        Greetings greetings = new GreetingsStyle();
        greeter.greeting(greetings);

        MyLambda myLambdaFunction = () -> System.out.println("Hello World");
        myLambdaFunction.foo();
    }

    public void greeting(Greetings greetings) {
        greetings.perform(name);
    }

}
interface MyLambda {
    void foo();

}