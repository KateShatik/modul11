import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Катя on 26.01.2017.
 */
public class Main {
    static String replacer(Map<String, String> map) throws IOException{
        BufferedReader br=null;

        String string=null;
        try{//Open file to read
            FileReader fileReader = new FileReader("C://GoOnlineJava//modul11/task2.txt");
            br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }


            string = sb.toString();
            for (Map.Entry<String, String> mapEntry : map.entrySet()) {
                string = string.replaceAll(mapEntry.getKey(), mapEntry.getValue());
            }
        }
            catch(Exception e){
                System.out.println("ERROR");
            } finally {
            br.close();
        }
        return string;
        }

    static void  fileContentReplacer(Map<String, String> map) throws IOException{
        BufferedReader br=null;
        BufferedWriter bw= null;
        String string=null;
        try{//Open file to read
            FileReader fileReader = new FileReader("C://GoOnlineJava//modul11/task2.txt");
            br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();//read
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            string = sb.toString();
            for (Map.Entry<String, String> mapEntry : map.entrySet()) {
                string = string.replaceAll(mapEntry.getKey(), mapEntry.getValue());
            }
            bw= new BufferedWriter(new FileWriter("C://GoOnlineJava//modul11/task2.txt"));//open file to write
            bw.write(string);//write
            bw.flush();
        }
        catch(Exception e){
            System.out.println("ERROR");
        } finally {
            br.close();
            bw.close();
        }

    }

    static void  fileContentMerger(Map<String, String> map) throws IOException{
        BufferedReader br=null;
        BufferedWriter bw= null;
        String string=null;

        try{//Open file to read
            FileReader fileReader = new FileReader("C://GoOnlineJava//modul11/task3.txt");
            br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();//read
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            string = sb.toString();
            for (Map.Entry<String, String> mapEntry : map.entrySet()) {
                string = string.replaceAll(mapEntry.getKey(), mapEntry.getValue());
            }
            File file=new File("C://GoOnlineJava//modul11/task3Result.txt");
            bw= new BufferedWriter(new FileWriter(file));//open file to write
            bw.append(string);
            bw.flush();

        }
        catch(Exception e){
            System.out.println("ERROR");
        } finally {
            br.close();
            bw.close();
        }

    }

    static int checkWord(String word) throws IOException{
        BufferedReader br=null;
        BufferedWriter bw= null;
        String string=null;
        int count =0;

        try{//Open file to read
            FileReader fileReader = new FileReader("C://GoOnlineJava//modul11/task4.txt");
            br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();//read
            while (line != null) {
                if(!line.equals(word)) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                else count ++;
                line = br.readLine();
            }


        }
        catch(Exception e){
            System.out.println("ERROR");
        } finally {
            br.close();

        }
       return count;
    }

    static int checkWordResources(String word) throws IOException{

        int count = 0;

        try{
            try(BufferedReader br= new BufferedReader(new FileReader("C://GoOnlineJava//modul11/task4.txt"))) {

                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    if(!line.equals(word)) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                    }
                    else count ++;
                    line = br.readLine();
                }
            }
        } catch(Exception e){
            System.out.println("ERROR");
        }

        return count;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Task1");
        Map<String, String> map = new HashMap<>();
        map.put("Word","ReplacedWord");
        System.out.println(replacer(map));

        System.out.println("Task2");
        fileContentReplacer(map);
        System.out.println("Task3");
        fileContentMerger(map);
        System.out.println("Task4");
        String word = "Work";
        System.out.println("Calculate how many time the word occurs " + word);
        System.out.println("1. Task with usual try ");
        System.out.println("Result= "+ checkWord(word));
        System.out.println("2. Try with resources");
        System.out.println("Result= "+ checkWordResources(word));

    }


    }


