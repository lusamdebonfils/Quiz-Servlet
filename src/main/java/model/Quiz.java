package model;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;


public class Quiz {
    static int score = 0;
    static String [] questions = {
            "{3,1,4,1,5}", //pi
            "{1,1,2,3,5}", //fibonacci
            "{1,4,9,16,25}",//squares
            "{2,3,5,7,11}", //primes
            "{1,2,4,8,16} "//powers of 2
    };
    static int[] answers = {9,8,36,13,32};

    Random rand = new Random();
    int random = rand.nextInt(5);

    public Quiz(){
        //loopThroughQuiz().forEach(System.out::println);
        Scanner input = new Scanner(System.in);
        int len = answers.length;
        System.out.println("Starting the Game ");
        int current = 0;
        for(int i = 0; i < len; i++){
            System.out.println();
            System.out.print("Choose the next number in the sequence ");
            System.out.print(Arrays.toString(questions)+"\n");
            System.out.print("Your answer is : ");
            current = input.nextInt();
            if (current == answers[i]){
                score++;
            }
            System.out.println("Your current score is : " + score);
        }
        System.out.println("Your final score is : " + score);
    }


    public HashMap<Integer,String> getMap(){
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<Integer, String> shuffleMap = new LinkedHashMap<>();
        int len = answers.length;
        for(int i = 0; i < len; i++){
            map.put(answers[i],questions[i]);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.shuffle(list);
        list.forEach(k->shuffleMap.put(k, map.get(k)));
//
//        map.forEach((k,v)->{
//
//        });
        return shuffleMap;
    }



    public int incrementScore(){
        return ++score;
    }

    public static void main(String[] args){
        new Quiz();
    }
}
