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
     * @author Wohui He
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

  /* @author Wohui He   
  public static Song searchBySongTitle(Song [] songs, String songTitle){
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
/**
 *  sort the provided array of songs in descending order based on the quantity of tags.
 * @param songs the array of songs going to be sorted by count tag.
 * @author Wohui He
 */
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
/**
 * to find the most common tags
 * @author Wohui He
 * @param songs the array of songs using in finding common tag
 * @return the most common tag--case-insensitive;
 */
    public static String findMostCommonTag(Song [] songs){
        int totalTags=0;
        for(int i =0;i<songs.length;i++){
            if(songs[i]!=null){
                totalTags+=songs[i].getTagCount();
            }
        }
        if(totalTags==0){
            return null;
        }
        String[] allTags=new String [totalTags];
        int index=0;
        for(int i=0;i<songs.length;i++){
            if(songs[i]!=null){
                String[] tags=songs[i].getTags();
                int count = songs[i].getTagCount();
                for(int x=0;x<count;x++){
                    allTags[index]=tags[x].toLowerCase();
                    index++;
                }
            }
        }
        int maxCount=0;
        String MostCommonTag=null;
        for(int i=0;i<songs.length;i++){
            String current=allTags[i];
            int frequency=1;
            for(int x=i+1;x<allTags.length;x++){
                if(allTags[x].equals(current)){
                    frequency++;
                }
            }
            if(i>lastIndexOf(MostCommonTag,allTags)&&frequency>maxCount||frequency==maxCount){
                maxCount=frequency;
                MostCommonTag=current;
            }
        }
        return MostCommonTag;
        // todo: ADD findMostCommonTag() LOGIC
    }
    private static int lastIndexOf(String tag,String[]allTags){
        if(tag==null){
            return-1;
        }
        int position=-1;
        for(int i=0;i<allTags.length;i++){
            if(allTags[i].equals(tag)){
                position=i;
            }
        }
        return position;
    }
}
