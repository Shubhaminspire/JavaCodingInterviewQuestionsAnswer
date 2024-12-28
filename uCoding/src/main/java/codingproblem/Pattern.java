package codingproblem;

public class Pattern {
    static int rows = 5;

    public static void main(String[] args) {
        Pattern pattern = new Pattern();
        pattern.printFirstPattern();
        System.out.println();
        pattern.secondPattern();
        System.out.println();
        pattern.secondPattern(rows);
        System.out.println();
        pattern.thirdPattern(rows);
        System.out.println();
        pattern.fourthPattern(rows);
    }

    //55555
    //4444
    //333
    //22
    //1
    private void printFirstPattern() {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //* * * * *
    //* * * *
    //* * *
    //* *
    //*
    private void secondPattern() {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //*
    //* *
    //* * *
    //* * * *
    //* * * * *
    private void secondPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //1
    //1 2
    //1 2 3
    //1 2 3 4
    //1 2 3 4 5

    private void thirdPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    //1
    //2 3
    //4 5 6
    //7 8   10
    //11 12 13 14 15
    private void fourthPattern(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if(number != 9){
                    System.out.print(number + " ");
                }
                if(number == 9){
                    System.out.print(" ");
                }
                number++;
            }
            System.out.println();
        }
    }
}

