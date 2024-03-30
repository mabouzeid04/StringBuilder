/**
 * Mahmoud Abouzeid
 */

/**
 * This class represents a character in our MyStringBuilder data structure. 
 * Stores a next pointer (null if non-existent) and the char represented. 
 */
public class CharNode {
    private CharNode next;
    private char data;

    /**
     * Creates a CharNode object that represents the passed-in char. 
     *
     * @param  ch The char represented by this node. 
     */
    public CharNode(char ch) {
        data = ch;
    }

    /**
     * Returns the char represented by this CharNode. 
     *
     * @return The char stored in this node. 
     */
    public char getData() {
        return data;
    }

    /**
     * Returns a direct reference to the next CharNode in the MSB. 
     * (Returns null if non-existent)
     *
     * @return The next CharNode of the MyStringBuilder. 
     */
    public CharNode getNext() {
        return next;
    }

    
    
}
