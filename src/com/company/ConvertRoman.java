package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConvertRoman {
    private static HashMap<String,Integer> transfer = new LinkedHashMap<>();
    public static void main(String[] args) {
        generate();
        Scanner cin = new Scanner(System.in);
        String t = cin.next();
        int nxt = 0;
        int prv = 0;
        int total = 0;
        if(t.length() >= 1){
            prv = transfer.get(t.charAt(0)+"");
        }
        for(int i = 1 ; i < t.length();i ++){
            String temp = t.charAt(i)+"";
                    nxt = transfer.get(temp);
                    if(nxt < prv){
                        total += nxt;
                        prv = transfer.get(temp);
                    }else{
                        total += nxt - prv;
                        prv = transfer.get(temp);
                    }
        }
        System.out.println(total);
    }
    private static void generate() {
        transfer.put("M",1000);
    //    transfer.put("CM",900);
     //   transfer.put("DCCC",800);
     //   transfer.put("DCC",700);
     //   transfer.put("DC",600);
        transfer.put("D",500);
    //    transfer.put("CD",400);
    //    transfer.put("CCC",300);
     //   transfer.put("CC",200);
        transfer.put("C",100);
     //   transfer.put("XC",90);
    //    transfer.put("LXXX",80);
     //   transfer.put("LXX",70);
     //   transfer.put("LX",60);
        transfer.put("L",50);
        transfer.put("X",10);
    //    transfer.put("XL",40);
    //    transfer.put("XXX",30);
     //   transfer.put("XX",20);
      //  transfer.put("X",10);
     //   transfer.put("IX",9);
      //  transfer.put("VIII",8);
      //  transfer.put("VII",7);
       // transfer.put("VI",6);
        transfer.put("V",5);
       /// transfer.put("IV",4);
      //  transfer.put("III",3);
       /// transfer.put("II",2);
        transfer.put("I",1);

    }
}
