package business;

import java.util.Arrays;
import java.util.Objects;

public class Song {
    private String title;
    private String artist;
    private String album;
    private double rating;
    private String genre;
    private String [] tags;
    private int tagCount;

    public Song(String title, String artist, String album, double rating, String genre, String[] tags) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.rating = rating;
        this.genre = genre;
        this.tags = tags;
        this.tagCount = tags.length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getTags() {
        return tags;
    }

    // You may not add the setTags method

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, album);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", tagCount=" + tagCount +
                '}';
    }

    /**
     * shift inserts new tags if they are unique
     *
     * @param tag parametr which we need to insert
     * @return boolean outcome of inserting operation
     *
     * @author Daniel Al-Dzhazzar
     */

    public boolean addTag(String tag) {
        for (int i = 0; i < tagCount; i++) {
            if (tags[i].equalsIgnoreCase(tag)) {
                return false;
            }
        }

        if (tagCount == tags.length) {
            String[] newTags = new String[tags.length + 1];

            for (int i = 0; i < tags.length; i++) {
                newTags[i] = tags[i];
            }

            tags = newTags;
        }

        for (int i = 0; i < tagCount; i++) {
            if (tags[i].compareToIgnoreCase(tag) > 0) {
                for (int j = tagCount; j > i; j--) {
                    tags[j] = tags[j - 1];
                }
                tags[i] = tag;
                tagCount++;
                return true;
            }
        }
        tags[tagCount] = tag;
        tagCount++;
        return true;
    }

    public boolean removeTag(String tag){
        // todo: ADD removeTag() LOGIC
        // Should implement APPROPRIATE delete action
        // Question to ask yourself: Which is more appropriate here - overwrite or shift?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * searches tag provided using binary search
     *
     * @param tag parametr, which is searched in tags
     * @return boolean outcome of search
     *
     * @author Daniel Al-Dzhazzar
     */

    public boolean containsTag(String tag){
        int left = 0;
        int right = tagCount - 1;
        int position;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int comp = tags[mid].compareToIgnoreCase(tag);
            if(comp == 0){
                position = mid;
                return true;
            }
            else if (comp < 0){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }

    public String format(){
        // todo: ADD format() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
