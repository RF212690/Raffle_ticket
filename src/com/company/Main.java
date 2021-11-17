package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    private static ArrayList<String> names= new ArrayList<String>();
    private static int[] nums= new int[100];
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void Assigner(String name){
        Random random= new Random();
        names.add(name);
        int size=names.size()-1;
        nums[size]=random.nextInt(100);
        for (int i = 0; i < size; i++) {
            if(nums[size]==nums[i]){
                nums[size]=random.nextInt(100);
                i=0;
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
    private static boolean checker(Integer ticket){
        return false;
    }
    public static void main(String[] args) {
        try {
            String userNum = getname();
            System.out.println("Do you want to purchase a ticket?Y/N");
            char input=  reader.readLine().toLowerCase().charAt(0);
            switch(input){
                case 'y':
                    Assigner(userNum);
                default:
                    System.out.println("Do you have a ticket?Y/N");
                    input=  reader.readLine().toLowerCase().charAt(0);
                    if(input=='y'){
                        System.out.println("What is your ticket?");
                        int ticket= Integer.parseInt(reader.readLine());
                        boolean winner= checker(ticket);
                    }
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
    }
}
