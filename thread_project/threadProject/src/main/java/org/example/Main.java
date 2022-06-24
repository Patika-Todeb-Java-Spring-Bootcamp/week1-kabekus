package org.example;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File fileScore = new File("score.txt");

        FileWriter fWriter = new FileWriter(fileScore,false);
        final BufferedWriter scoreWriter = new BufferedWriter(fWriter);

        FileReader fReader = new FileReader(fileScore);
        final BufferedReader scoreReader = new BufferedReader(fReader);

        if(!fileScore.exists()){
            fileScore.createNewFile();
        }
        final Scanner scn = new Scanner(System.in);

        final Thread Consumer = new Thread(){
            public void run(){
                String line;
                try {
                    if (((line = scoreReader.readLine()) != null)){
                        System.out.println(line);
                        scoreReader.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        final Thread Producer = new Thread(){
            public void run(){
                System.out.print("Team 1:");
                String nameTeam1 = scn.next();
                System.out.print("Team 1 Score:");
                int scoreTeam1 = scn.nextInt();
                System.out.print("Team 2:");
                String nameTeam2 = scn.next();
                System.out.print("Team 2 Score:");
                int scoreTeam2 = scn.nextInt();

                if(scoreTeam1<0||scoreTeam2<0){
                    throw new RuntimeException("Score is wrong");
                }
                try {
                    scoreWriter.write("Match Result : " +nameTeam1+" "+scoreTeam1+" - "+scoreTeam2+" "+nameTeam2);
                    scoreWriter.close();
                    Consumer.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Producer.start();
    }
}
