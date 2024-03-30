/*
 * Mahmoud Abouzeid

 * This file contains a re-creation of the java
 * Stringbuilder class.
 * 
 */

/**
 * This class contains a recreation of the java
 * Stringbuilder classs done by me. It allows you to 
 * append letters at the end of strings.
 */
public class MyStringBuilder {

    private CharNode start;
    private CharNode end;
    private int length;

    private static final String EMPTY_STRING = "";
    private static final int ONE = 1;
    private static final String NULL_POINTER_EXCEPTION = 
        "This object isn't pointing to anything";
    private static final String INDEX_OUT_OF_BOUNDS_EXCEPTION = 
        "index out of bounds";

    /**
     * This is a constructor that uses a char. 
     * 
     * @param ch character in string
     */
    public MyStringBuilder(char ch){
        start =  new CharNode(ch);
        end = start;
        length = ONE;
    }

    /**
     * This is a constructor that uses a string. 
     * 
     * @param str string passed into method.
     */
    public MyStringBuilder(String str){
        if (str == null) {
            throw new NullPointerException
            (NULL_POINTER_EXCEPTION);
        }
        else if (str.length() == 0){
            length = str.length();
            return;
        }

        for (int i = 0; i < str.length(); i++){
            this.append(str.charAt(i));
        }
    }

    /**
     * This is a constructor that uses another stringbuilder object. 
     * 
     * @param other object to be deep copied.
     */
    public MyStringBuilder(MyStringBuilder other){

        if (other == null) {
            throw new NullPointerException
            (NULL_POINTER_EXCEPTION);
        }
        String newString = other.toString();

        for (int i = 0; i < newString.length(); i++) {
            this.append(newString.charAt(i)); 
        }
    }

    /**
     * this is a getter method that returns the string length.
     * 
     * @return length;
     */
    public int length() {
        return length;
    }

    /**
     * This method appends a character.
     * 
     * @param ch character to be appended
     * @return mystringbuilder object
     */
    public MyStringBuilder append(char ch) {
        CharNode currChar = new CharNode(ch);
        if (length == 0) {
            start = currChar;
            end = currChar;
            length = ONE;
        }
        else {
            this.end.setNext(currChar);
            end = currChar;
            length++;
        }
        return this;
    }
}