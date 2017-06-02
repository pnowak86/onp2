package com.onp2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Stack<String> first = new Stack<>();
        Stack<String> second = new Stack<>();

        boolean quit = true;
        while (quit){


            String scanInput = scanner.nextLine();

            char scanInToChar = scanInput.charAt(0);


//            for (int i = 0; i < scanInput.length() ; i++) {
//
//
//            }

            //            printStack(first);

            if( Character.isDigit(scanInToChar))
            {
                first.push(scanInput);
                printStack(first);
            }
           else if(scanInput.equals(")")){
                System.out.println("Znak do przeniesienia do first:" + second.peek());
                String temp = second.peek();
                first.push(temp);
                second.pop();
                second.pop();
                printStack(first);
                printStack(second);
           }
            else if(scanInput.equals("-")){
                while (second.size() != 0) {
                    String temp = second.peek();
                    first.push(temp);
                    second.pop();

                }
                second.push(scanInput);
                printStack(second);
                printStack(first);

            }
            else if (scanInput.equals("quit")) {
                while (second.size() != 0) {
                    String temp = second.peek();
                    first.push(temp);
                    second.pop();
                }
                printStack(second);
                printStack(first);
                quit = false;
                }

            else {
                second.push(scanInput);

                printStack(second);
            }

        }



    }




    public static void printStack(Stack<String> s) {
        if (s.isEmpty()) {
            System.out.println("Stack is empty!!!");
        } else {
            System.out.printf("%s, TOP\n", s);
        }

    }
}
