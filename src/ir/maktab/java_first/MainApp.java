package ir.maktab.java_first;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = getInputs();
        RightPair<Integer> rightPair = new RightPair<>(numbers);
        rightPair.deleteWrongPairs();
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    private static ArrayList<Integer> getInputs() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your integer array values(Enter exit for close entering): ");
        boolean continueLoop = true;
        do {
            try{
                numbers.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                String input = scanner.next();
                if(input.toLowerCase().equals("exit")) continueLoop = false;
                else System.out.println("Your input isn't integer. Please input a valid value.");
            }
        } while (continueLoop);
        return numbers;
    }
/*
3
7
9
2
5
5
8
5
6
3
4
7
3
1
exit
*/
}
