package com.company;

import com.company.exceptions.IncorrectOperation;
import com.company.exceptions.NotComputedValue;
import com.company.exceptions.NotFitableNumbers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    static String input1,operation,input2;
    static HashMap<String,Integer> transfer = new LinkedHashMap<>();
    public static void main(String[] args) throws IncorrectOperation, NotFitableNumbers, NotComputedValue {
        generate();
        Scanner cin = new Scanner(System.in);
        input1 = cin.next();
        operation = cin.next();
        input2 = cin.next();
        if(checkOp(operation)){
            boolean define = defineType(input1);
            int answer = 0;
            if(define == defineType(input2)){
                if(!define)
                {
                    if(Integer.parseInt(input1) <= 10 && Integer.parseInt(input2) <= 10)
                        System.out.println(result(Integer.parseInt(input1),Integer.parseInt(input2),operation));
                    else
                        throw new NotComputedValue("Not computed value");
                }else {
                    if(transfer.containsKey(input1) && transfer.containsKey(input2)){
                        System.out.println(transfer.get(input1)+" "+transfer.get(input2));
                         System.out.println(convertRoman(result(transfer.get(input1),transfer.get(input2),operation)));
                    }
                    else
                        throw new NotComputedValue("Not computed value in romans");
                }
           }
        }else{
            throw new IncorrectOperation("Not existed operation");
        }
       // throw new NotFitableNumbers("Not one type of number Exception");


    }
    private  static boolean checkOp(String op){
        return ((op.contains("+") || op.contains("-") || op.contains("/") || op.contains("*")) && op.length() == 1);
    }
    private static boolean defineType(String temp){
        boolean yes = true;
        int pos = 0;
        if(temp.charAt(0) =='-')
            pos ++;
        //if roman true
        //else false
        for(int i = pos ; i < temp.length();i ++){
            yes &= Character.isAlphabetic(temp.charAt(i));
        }
        return yes;
    }
    private static void generate(){
        transfer.put("I",1);
        transfer.put("II",2);
        transfer.put("III",3);
        transfer.put("IV",4);
        transfer.put("V",5);
        transfer.put("VI",6);
        transfer.put("VII",7);
        transfer.put("VIII",8);
        transfer.put("IX",9);
        transfer.put("X",10);
        transfer.put("-I",-1);
        transfer.put("-II",-2);
        transfer.put("-III",-3);
        transfer.put("-IV",-4);
        transfer.put("-V",-5);
        transfer.put("-VI",-6);
        transfer.put("-VII",-7);
        transfer.put("-VIII",-8);
        transfer.put("-IX",-9);
        transfer.put("-X",-10);
    }
    private static int result(int a, int b,String op){
        if(op.equals("+"))
            return a + b;
        if(op.equals("*"))
            return a * b;
        if(op.equals("-"))
            return a - b;
        return a / b;
    }
    private static String convertRoman(int n){
        String ans = "";
        if (n >= 100){
            n %= 100;
            ans ="C";
        }

        if(n / 10 == 1){
            ans +="X";
            n %= 10;
        }
        if(n / 10 == 2){
            ans +="XX";
            n %= 10;
        }
        if(n / 10 == 3){
            ans +="XXX";
            n %= 10;
        }
        if(n / 10 == 4){
            ans +="XL";
            n %= 10;
        }
        if(n / 10 == 5){
            ans +="L";
            n %= 10;
        }
        if(n / 10 == 6){
            ans +="LX";
            n %= 10;
        }
        if(n / 10 == 7){
            ans +="LXX";
            n %= 10;
        }
        if(n / 10 == 8){
            ans +="LXXX";
            n %= 10;
        }
        if(n / 10 == 9){
            ans +="XC";
            n %= 10;
        }
        if(n == 1){
            ans +="I";
        }
        if(n == 2){
            ans +="II";
        }
        if(n == 3){
            ans +="III";
        }
        if(n == 4){
            ans +="IV";
        }
        if(n == 5){
            ans +="V";
        }
        if(n == 6){
            ans +="VI";
        }
        if(n == 7){
            ans +="VII";
        }
        if(n == 8){
            ans +="VIII";
        }
        if(n == 9){
            ans +="IX";
        }
        if(ans.isEmpty())
            return "0";
        return ans;
    }


}
