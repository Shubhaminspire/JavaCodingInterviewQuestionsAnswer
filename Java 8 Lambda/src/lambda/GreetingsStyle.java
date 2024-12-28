package lambda;

public class GreetingsStyle implements Greetings {
    @Override
    public void perform(String name){
        System.out.println("Hello World! "+name);
    }
}
