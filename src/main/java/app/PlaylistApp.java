package app;

import business.Song;

import java.util.Scanner;
import utils.SongFileUtils;

import static utils.SongFileUtils.readSongFile;

/**
 *
 * @author michelle
 */
public class PlaylistApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Song[] songs = readSongFile("sampleSongInput.txt");

        boolean keepRunning = true;
        while(keepRunning) {
            displayMenu();

            String choice = input.nextLine();

            switch(choice){
                case "1":
                    for(int i = 0; i < songs.length; i++){
                        System.out.println(songs[i].toString());
                        System.out.println("-----------------");
                    }
                    break;
                case "2":
                    handleGoodbye();
                    break;
                case "3":
                    handleWhat();
                    break;
                case "0":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!!!");
            }
        }

        System.out.println("Program terminating. Goodbye!");
    }

    private static void handleHello(){
        System.out.println("Hi!!");
    }

    private static void handleGoodbye() {
        System.out.println("Bye!!");
    }

    private static void handleWhat(){
        System.out.println("Whaaaaaaaaaaaaaaaaaat?!");
    }

    private static void displayMenu() {
        System.out.println("Please select from the following options: ");
        System.out.println("1) Print out a playlist");
        System.out.println("2) Sort songs");
        System.out.println("3) Search with specific tag");
        System.out.println("4) Search, using a title");
        System.out.println("5) Edit Songs");
        System.out.println("6) Most popular song");
        System.out.println("7) Most common song");
        System.out.println("0) Exit");
    }
}
