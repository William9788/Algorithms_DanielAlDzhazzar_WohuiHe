package utils;

public class Validation {
    public static String validateString(String s){
        if(s == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        if(s.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be empty");
        }
        return s;
    }

    public static int intBound(int i, int bound){
        if(i > bound && i < 0){
            throw new IllegalArgumentException("Input is out of bounds");
        }
        return i;
    }
}
