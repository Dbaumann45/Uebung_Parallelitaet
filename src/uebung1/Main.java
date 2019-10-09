/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class DemoThread extends Thread {
  
    
  
  }
/**
 *
 * @author DavidLindlbauer
 */
public class Main{

    private static List<String> liste = new ArrayList<>();
    private static List<String> zahlen = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s1 = new Scanner(System.in);
        s1.useDelimiter("\n");
        CSVReader();
        zahlen.forEach(s -> System.out.println(s));
        System.out.print("Chunks eingeben: ");
        int t = s1.nextInt();

        System.out.print("Teiler eingeben: ");
        int i = s1.nextInt();

        findTeilbar(i);
    }
    
    public static void CSVReader() throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("numbers.csv"));
        s.useDelimiter("\n");
        
        while(s.hasNext())
        {
            String line = s.nextLine();
            String[] teile = line.split(":");
            liste.addAll(Arrays.asList(teile));
        }
        for(int i = 0;i < liste.size();i++)
        {
            boolean zahl = true;
            for(int j = 0;j < liste.get(i).length();j++)
            {
                if(liste.get(i).charAt(j) < 48 || liste.get(i).charAt(j) > 57)
                {
                    zahl = false;
                }
            }
            if(zahl == true)
            {
                zahlen.add(liste.get(i));
            }
        }
        
        
    }
    
    public static void findTeilbar(int h)
    {
        for(int i = 0;i < zahlen.size();i++)
        {
            if(Integer.parseInt(zahlen.get(i)) % h == 0 && Integer.parseInt(zahlen.get(i)) >= h)
            {
                System.out.println(zahlen.get(i));
            }
        }
    }


    
    
    
}
