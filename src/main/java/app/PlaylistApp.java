package app;

import business.Song;

import java.util.Scanner;
import utils.SongFileUtils;
import utils.SongUtils;

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
                    System.out.println("\nPlaylist: ");
                    System.out.println("-----------------");
                    for(int i = 0; i < songs.length; i++){
                        System.out.println(songs[i].toString());
                        System.out.println("-----------------");
                    }
                    break;
                case "2":
                    System.out.println("How would you like to sort songs?");
                    System.out.println("1) By title");
                    System.out.println("2) By number of tags");
                    String op = input.nextLine();

                    switch(op){
                        case "1":
                            SongUtils.sortSongsBySongTitle(songs);
                            System.out.println("\nPlaylist sorted by title: ");
                            System.out.println("-----------------");

                            for(int i = 0; i < songs.length; i++){
                                System.out.println(songs[i].toString());
                                System.out.println("-----------------");
                            }
                            break;
                        case "2":
                            break;
                        default:
                            System.out.println("Please enter a valid option");
                    }

                    break;
                case "3":
                    handleWhat();
                    break;
                case "4":
                    System.out.println("Input title to search: ");
                    String title = input.next();

                    SongUtils.sortSongsBySongTitle(songs);
                    Song result = SongUtils.searchBySongTitle(songs, title);
                    if(result != null){
                        System.out.println(result.toString());
                    }
                    else{
                        System.out.println("No song found");
                    }
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
        System.out.println("\nPlease select from the following options: ");
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
