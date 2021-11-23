package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static ArrayList<String> names= new ArrayList<String>();
    private static int[] nums= new int[1000];
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void Assigner(String name){
        Random random= new Random();
        int size=names.size();
        boolean repetition=false;
        for (int i = 0; i < size; i++) {
            if(names.get(i).equalsIgnoreCase(name)){
                System.out.println("You already have a ticket");
                repetition=true;
            }
        }
        if(!repetition){
            names.add(name);
            nums[size]=random.nextInt(1000)+1;
            for (int i = 0; i < size; i++) {
                if(nums[size]==nums[i]){
                    nums[size]=random.nextInt(1000)+1;
                    i=0;
                }
            }
        }
    }
    private static String getname(){
        try {
            System.out.println("What is your Name?");
            return reader.readLine();
        }catch(Exception e){
            System.out.println("Error: "+e);
            return "Error";
        }
    }
    private static boolean checker(Integer ticket, Integer counter,String Name){
        for (int i = 0; i <counter ; i++) {
            if(ticket==nums[i]){
                if(names.get(i).equalsIgnoreCase(Name)){
                    boolean checker=true;
                    for (int j = 2; j < (ticket/2)+1; j++) {
                        if(ticket%j==0){
                            checker=false;
                        }
                    }
                    return checker;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int counter=0;
        char input=' ';
        do {
            boolean purchased = false;
            boolean winner = false;
            boolean someone=false;
            String userNum = "";
            try {
                while (userNum.length() < 1) {
                    userNum = getname();
                    if (userNum.length() < 1) {
                        System.out.println("Not a valid Name");
                    }
                }
                System.out.println("Do you want to purchase a ticket?Y/N");
                input = reader.readLine().toLowerCase().charAt(0);
                switch (input) {
                    case 'y':
                        if(counter>=1000){
                            System.out.println("We have no tickets left");
                        }
                        else{Assigner(userNum);
                        System.out.println("Your ticket number is "+nums[names.indexOf(userNum)]);
                        counter++;
                        }purchased = true;
                    default:
                        if (!purchased) {
                            System.out.println("Do you have a ticket?Y/N");
                            input = reader.readLine().toLowerCase().charAt(0);
                            if (input == 'y') {
                                System.out.println("What is your ticket?");
                                int ticket = Integer.parseInt(reader.readLine());
                                winner = checker(ticket,counter,userNum);
                            }
                        }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            if (winner && !purchased){
                System.out.println("Congratulations! You won!");
            }
            else if(!purchased){
                System.out.println("Sorry but you dont win anything");
            }
            System.out.println("Does someone still want to participate?Y/N");
            try{
                input = reader.readLine().toLowerCase().charAt(0);
            }
            catch(Exception e){
                System.out.println("Error: "+e);
            }
        }while(input=='y');
        System.out.println("Thanks for playing");
    }
}
