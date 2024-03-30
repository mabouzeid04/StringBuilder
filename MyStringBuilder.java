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
}