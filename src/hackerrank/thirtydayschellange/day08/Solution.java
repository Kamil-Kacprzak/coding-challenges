package hackerrank.thirtydayschellange.day08;
/*
 * Given  names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an unknown number of names to query your phone book for. For each  queried, print the associated entry from your phone book on a new line in the form name=phoneNumber; if an entry for  is not found, print Not found instead.

Note: Your phone book should be a Dictionary/Map/HashMap data structure.
 */
import java.util.*;
import java.io.*;

public class Solution{
  public static void main(String []argh){
      Scanner in = new Scanner(System.in);
      HashMap<String,Long> phoneBook = new HashMap<>();
      
      int n = in.nextInt();
      for(int i = 0; i < n; i++){
          String name = in.next();
          long phone = in.nextLong();
          phoneBook.put(name, phone);
      }
      while(in.hasNext()){
          String s = in.next();
          String print = phoneBook.containsKey(s)?s+"="+phoneBook.get(s):"Not found";
          System.out.println(print);          
      }
      in.close();
  }
}