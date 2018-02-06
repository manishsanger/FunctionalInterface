package com.manishsanger.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by manishsanger on 18/01/18.
 */
public class ConsumerExample {
    public static void main(String[] args) {

        ConsumerExample consumerExample = new ConsumerExample();

        System.out.println("Consumer Without Lambda expression");
        consumerExample.consumerWithoutLambdaExpression();

        System.out.println("\nConsumer With Lambda expression");
        consumerExample.consumerWithLambdaExpression();


        System.out.println("\nConsumer as target of Lambda expression");
        consumerExample.consumerAsTargetOfLambdaExpression();

        System.out.println("\nCustom method As a target of Lambda expression");
        consumerExample.customMethodAsTargetOfLambdaExpression();

        System.out.println("\nConsumer with AndThen Lambda expression");
        consumerExample.consumerWithAndThenLambdaExpression();



    }

    //Consumer without Lambda expression
    private void consumerWithoutLambdaExpression(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.print(number + ",");
            }
        };
        numbers.forEach(consumer);
    }

    //Consumer with Lambda expression
    private void consumerWithLambdaExpression(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer consumer = (t) -> System.out.print(t + ",");


        numbers.forEach(consumer);
    }

    //Consumer As a target of Lambda expression
    private void consumerAsTargetOfLambdaExpression(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach((t) -> System.out.print(t + ","));
    }

    //Custom method As a target of Lambda expression
    private void customMethodAsTargetOfLambdaExpression(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ConsumerExample consumerExample = new ConsumerExample();
        numbers.forEach((t) -> consumerExample.printNumber(t));
    }

    public void printNumber(Integer i){
        System.out.print(i + ",");
    }

    //Consumer with AndThen Lambda expression
    private void consumerWithAndThenLambdaExpression(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ConsumerExample consumerExample = new ConsumerExample();

        Consumer consumer = (t) -> System.out.print(t);

        Consumer hiphen = consumer.andThen((t) -> System.out.print("-"));
        consumerExample.printNumbers(numbers, hiphen);

    }

    private void printNumbers(List<Integer> numbers, Consumer consumer){
        numbers.forEach(number -> consumer.accept(number));
    }
}
