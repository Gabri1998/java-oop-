package com.company;

import java.util.Scanner;
class Practic {
public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         System.out.print("How many favourite movies do you have: ");
         int numOfMovies = input.nextInt();
         input.nextLine();

         String[] favouriteMovies = new String[ numOfMovies ];

         for (int i = 0; i < favouriteMovies.length; i++) {
             System.out.print("Type your favourite movie n." + (i+1) + ": ");
             String movieTitle = input.nextLine();
             favouriteMovies[i] = movieTitle;
             }

         System.out.println("Your favourite movies are: ");
         for (int i = 0; i < favouriteMovies.length; i++) {
             System.out.println(favouriteMovies[i]);
             }

         input.close();
        }
 }
