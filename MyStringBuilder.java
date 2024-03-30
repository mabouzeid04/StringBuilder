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
    /**
     * This method appends a string.
     * 
     * @param str string to be appended
     * @return mystringbuilder object
     */
    public MyStringBuilder append(String str){

        if (str == null) {
            throw new NullPointerException
            (NULL_POINTER_EXCEPTION);
        }
        else if (str.length() == 0) {
            return this;
        }

        for (int i = 0; i < str.length(); i++) {
            this.append(str.charAt(i));
            length++;
        }
        return this;
    }

    /**
     * This method returns the stringbuilder as a string.
     * 
     * @return returns the stringbuilder as a string.
     */
    public String toString() {
        String realString = EMPTY_STRING;

        if (length == 0) {
            return EMPTY_STRING;
        }

        CharNode currChar = start;
        while (currChar.getNext() != null) {
            realString += currChar.getData();
            currChar = currChar.getNext();
        }
        realString += currChar.getData();

        return realString;
    }

    /**
     * Returns the stringbuilder as a string starting from startidx.
     * 
     * @param startIdx the start index.
     * @return returns the substring.
     */
    public String subString(int startIdx){
        String fullString = this.toString();

        if ((startIdx < 0) || (startIdx > fullString.length() - ONE)) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }

        return fullString.substring(startIdx);
    }

    /**
     * Returns the stringbuilder as a string starting from startidx to endidx.
     * 
     * @param startIdx the start index.
     * @param endIdx the end index.
     * @return returns the substring. 
     */
    public String subString(int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return EMPTY_STRING;
        }

        String fullString = this.toString();

        if ((startIdx < 0) || (startIdx > fullString.length() - ONE) || 
            (endIdx > fullString.length()) || (endIdx < startIdx)) {
            throw new IndexOutOfBoundsException
            (INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }

        return fullString.substring(startIdx, endIdx);
    }
}