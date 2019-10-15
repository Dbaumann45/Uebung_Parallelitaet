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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class TeilerThread extends Thread {
  
    public void run(List<String> liste, int teiler, int chunk) {
      findTeilbar(teiler, liste);
    }
    
    public void findTeilbar(int h, List<String> liste)
    {
        for(int i = 0;i < liste.size();i++)
        {
            if(Integer.parseInt(liste.get(i)) % h == 0 && Integer.parseInt(liste.get(i)) >= h)
            {
                System.out.println(liste.get(i));
            }
        }
    } 
  
  }
/**
 *
 * @author DavidLindlbauer
 */
public class Main{

    private static List<String> liste = new ArrayList<>();
    private static List<String> zahlen = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s1 = new Scanner(System.in);
        s1.useDelimiter("\n");
        CSVReader();
        zahlen.forEach(s -> System.out.println(s));
        System.out.println(zahlen.size()); //33792
        System.out.print("Chunks eingeben: ");
        int chunk = s1.nextInt();

        System.out.print("Teiler eingeben: ");
        int teiler = s1.nextInt();
        
        ExecutorService executorService = Executors.newFixedThreadPool(chunk);
        Runnable task = () -> {
            findTeilbar(teiler);
        };
        
        for(int i = 0; i < chunk; i++) {
            executorService.submit(task);
        }
        /*for(int c = 0;c < t;c++)
        {
            TeilerThread a = new TeilerThread();
        }
        
        findTeilbar(i);*/
        
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
