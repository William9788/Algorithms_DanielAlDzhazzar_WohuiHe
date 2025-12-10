package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class SongUtils {
    /**
     * Performs a linear search through the provided array and return the new array contains the specific tags.
     * @param songs the array of the songs to serach.
     * @param tag the tag to serach.
     * @return the array contains the specific tags
     */
    public static Song[] searchByTag(Song [] songs, String tag){
        if(tag==null||tag.trim().isEmpty()){
            return new Song[0];
        }
        int count=0;
        for(int i =0;i<songs.length;i++){
            if(songs[i]!=null&&songs[i].containsTag(tag)){
                count++;
            }
        }
        if(count==0){
            return new Song[0];
        }
        Song[] result = new Song[count];
        int index=0;
        for(int i =0;i<songs.length;i++){
            if(songs[i]!=null&&songs[i].containsTag(tag)){
                result[index] = songs[i];
                index++;
            }
        }
        return result;
        // todo: ADD searchByTag() LOGIC
        // Should implement linear search, but not for a single result
    }

  /*   public static Song searchBySongTitle(Song [] songs, String songTitle){
       if(songTitle==null||songTitle.trim().isEmpty()){
            return null;
        }
        int low=0;
        int high=songs.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(songs[mid]==null){
                return null;
            }
            int cmp=songs[mid].getTitle().compareToIgnoreCase(songTitle);
            if(cmp==0){
                return songs[mid];
            }
            else if(cmp<0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return null;
        // todo: ADD searchBySongTitle() LOGIC
        // Should implement binary search
    }
*/
    public static Song findMostPopular(Song [] songs){
        // todo: ADD findMostPopular() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void sortSongsBySongTitle(Song [] songs){
        // todo: ADD sortSongsBySongTitle() LOGIC
        // Should implement for-loop based bubble sort
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void sortSongsByNumTags(Song [] songs){
        for(int i=0;i<songs.length-1;i++){
            int maxIndex=i;
            for(int x=i+1;x<songs.length;x++){
                if(songs[x]!=null&&songs[maxIndex]!=null){
                    if(songs[x].getTagCount()>songs[maxIndex].getTagCount()){
                        maxIndex=x;
                    }
                }
            }
            Song room=songs[i];
            songs[i]=songs[maxIndex];
            songs[maxIndex]=room;
        }
        // todo: ADD sortSongsByNumTags() LOGIC
        // Should implement selection sort
    }

    public static String findMostCommonTag(Song [] songs){
        // todo: ADD findMostCommonTag() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
