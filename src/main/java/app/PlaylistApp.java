package app;

import business.Song;

import java.util.Scanner;
import utils.SongFileUtils;
import utils.SongUtils;
import utils.Validation;

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
                    int op = input.nextInt();
                    input.nextLine();

                    switch(op){
                        case 1:
                            SongUtils.sortSongsBySongTitle(songs);
                            System.out.println("\nPlaylist sorted by title: ");
                            System.out.println("-----------------");

                            for(int i = 0; i < songs.length; i++){
                                System.out.println(songs[i].toString());
                                System.out.println("-----------------");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Please enter a valid option");
                            break;
                    }

                    break;
                case "3":
                    break;
                case "4":
                    System.out.println("Input title to search: ");
                    String title = input.nextLine();
                    Validation.validateString(title);
                    SongUtils.sortSongsBySongTitle(songs);
                    Song result = SongUtils.searchBySongTitle(songs, title);
                    if(result != null){
                        System.out.println(result.toString());
                    }
                    else{
                        System.out.println("Song not found");
                    }
                    break;
                case "5":
                    System.out.println("Choose a song: ");
                    System.out.println("-----------------");
                    for(int i = 0; i < songs.length; i++){
                        System.out.print(i + ") ");
                        System.out.println(songs[i].toString());
                        System.out.println("-----------------");
                    }
                    int song = input.nextInt();
                    Validation.intBound(song, songs.length);
                    System.out.println("What change would you like to make: ");
                    System.out.println("1) Add a tag");
                    System.out.println("2) Remove a tag");
                    int op2 = input.nextInt();
                    input.nextLine();

                    switch (op2){
                        case 1:
                            System.out.println("Input unique tag: ");
                            String tag = input.nextLine();
                            Validation.validateString(tag);
                            boolean outcome = songs[song].addTag(tag);
                            if(outcome == true){
                                System.out.println("Tag added successfully");
                                System.out.println("-----------------");
                                System.out.println(songs[song]);
                                System.out.println("-----------------");
                            }
                            else{
                                System.out.println("Tag not added");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Please enter a valid option");
                    }
                    break;
                case "6":
                    System.out.println("Most popular song: ");
                    System.out.println(SongUtils.findMostPopular(songs).toString());
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
