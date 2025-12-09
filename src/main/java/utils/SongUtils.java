package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class SongUtils {
    public static Song[] searchByTag(Song [] songs, String tag){
        // todo: ADD searchByTag() LOGIC
        // Should implement linear search, but not for a single result
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static Song[] searchBySongTitle(Song [] songs, String songTitle){
        // todo: ADD searchBySongTitle() LOGIC
        // Should implement binary search
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static Song findMostPopular(Song [] songs){
        Song best = songs[0];

        for(int i = 0; i < songs.length; i++){
            if(songs[i].getRating > best.getRating){
                best = songs[i];
            }
        }
        return best;
    }

    /**
     * sorts an array of songs by titles based on bubble sort algorithm
     *
     * @param songs an array which will be sorted
     *
     * @author Daniel Al-Dzhazzar
     */

    public static void sortSongsBySongTitle(Song [] songs) {
        for (int i = 0; i < songs.length - 1; i++) {
            for (int j = 0; j < songs.length - i - 1; j++) {
                if (songs[j].getTitle().compareToIgnoreCase(songs[j + 1].getTitle()) > 0) {
                    Song musicBox = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = musicBox;
                }
            }
        }
    }


    public static void sortSongsByNumTags(Song [] songs){
        // todo: ADD sortSongsByNumTags() LOGIC
        // Should implement selection sort
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static String findMostCommonTag(Song [] songs){
        // todo: ADD findMostCommonTag() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
