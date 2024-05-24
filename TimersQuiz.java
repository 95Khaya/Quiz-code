/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package timersquiz;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author khaya
 */
public class TimersQuiz {

    /**
     * @param args the command line arguments
     */
    
     private static final int timeLimit = 10;
     private static boolean answered = false;
     
    public static void main(String[] args) {
        // TODO code application logic here
       
        Scanner scanner = new Scanner(System.in);
        int score = 0; // Initialize the score to zero

        // Array to store correct answers for each question
        char[] correctAnswers = {'a', 'a', 'c', 'b', 'a'};

        // Array to store questions
        String[] questions = {
        		//First element or index or i= 0
            "1. What is the capital of South Africa?\n" +
            "a) Pretoria\n" +
            "b) Johannesburg\n" +
            "c) Madrid\n" +
            "d) Berlin\n",

            // i = 1
            "2. Who wrote 'Othello'?\n" +
            "a) William Shakespeare\n" +
            "b) Charles Dickens\n" +
            "c) Jane Austen\n" +
            "d) J.K. Rowling\n",

            // i = 2
            "3. What is the chemical symbol for water?\n" +
            "a) CO2\n" +
            "b) H2O\n" +
            "c) O2\n" +
            "d) N2\n",

            // i = 3
            "4. What is the tallest statue in the world?\n" +
            "a) K2\n" +
            "b) The Statue of Unity\n" +
            "c) Kangchenjunga\n" +
            "d) Liberty\n",

            // i = 4
            "5. What is the largest planet in our solar system?\n" +
            "a) Jupiter\n" +
            "b) Saturn\n" +
            "c) Neptune\n" +
            "d) Earth\n"
        };

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            answered = false;
            Timer timer = new Timer();
            
            TimerTask task = new TimerTask(){
            @Override
            public void run() {
                
              if(!answered){
                  System.out.println("Time is up!");
                  timer.cancel();                              
              }     
            }
                      
        };
            
            //char userAnswer = scanner.next().charAt(0); // Read user's answer
        timer.schedule(task,timeLimit*1000);
             
        String input = scanner.nextLine();
        
        if(!input.isEmpty()) {
               
            char userAnswer = input.charAt(0);
            answered = true;
            
             if(userAnswer == correctAnswers[i]) {
                score++; // Increment score if answer is correct
            }
        }
        
       timer.cancel();

    }
      
    // Calculate and display the final score
        double percentage = (double) score / questions.length * 100;
        System.out.println("Your score: " + score + "/" + questions.length);
        System.out.println("Percentage: " + percentage + "%");

        scanner.close();    
      
       
       
        
             
              
    }
    
}
