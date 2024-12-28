package lambda;

interface Operations {
    int multiply(int a);
}

interface OperationTwoNumber {
    int operations(int a, int b);
}

interface SingleStringOperations {
    int count(String value);

}

public class LambdaCode {
    public static void main(String[] args) {

        Operations multiplyBy2 = (int a) -> 2 * a;
        System.out.println(multiplyBy2.multiply(3));

        OperationTwoNumber addFunction = Integer::sum;
        System.out.println(addFunction.operations(4, 6));
        OperationTwoNumber safeDivideFunction = (int a, int b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println(safeDivideFunction.operations(25, 5));
        SingleStringOperations stringLengthCount = (String value) -> {
            System.out.println(value.replaceAll(" ",""));
            return value.replaceAll(" ", "").length();
        };
        System.out.println(stringLengthCount.count("Shubham Sharma"));
    }
}

