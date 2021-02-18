package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

class Stack{
    int top;
    int stSize;
    int[] array;

    Stack(int top, int stSize){
        this.top = top;
        this.stSize = stSize;
        array = new int[stSize];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == stSize;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Stack is FULL\n");
        }else{
            array[top++] = element;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty\n");
            return -1;
        }else{
            return array[top-1];
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty\n");
            return -1;
        }else{
            return array[--top];
        }
    }

    public void search(int element){
        System.out.println(element + " index: ");
        for(int i = 0; i < top; i++){
          if(array[i] == element){
              System.out.print(i + " ");
          }
        }
        System.out.println();
    }

    public void printStack(){
        System.out.println("0 ~ " + top);
        IntStream.range(0, top).forEach((int i)
                -> System.out.print(array[i] + " "));
        System.out.println();
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 스택의 크기
        System.out.print("Max stackSize: ");
        int stSize = input.nextInt();

        // 스택 생성 & 초기화
        Stack stack = new Stack(0, stSize);

        // 스택 정보 입력
        System.out.println("\nMENU (1: push | 2: peek | 3: pop | 4: search | 5: print stack | -1: quit)\n");
        int check;
        do{
            System.out.print("what do you want? ");
            check = input.nextInt();

            // 스택 push
            if(check == 1) {
                System.out.print("Input stack element: ");
                int tmp = input.nextInt();
                stack.push(tmp);
            } // 스택 peek
            else if(check == 2){
                System.out.println("peek: " + stack.peek());
            } // 스택 pop
            else if(check == 3){
                System.out.println("pop: " + stack.pop());
            } // 검색
            else if(check == 4){
                System.out.print("Input search element: ");
                int tmp = input.nextInt();
                stack.search(tmp);
            } // 출력
            else if(check == 5){
                stack.printStack();
            }
            else if(check == -1){
                System.out.println("exit...");
            } // 예외
            else{
                System.out.println("Command not found.\n");
            }

        } while(check != -1);
    }
}
