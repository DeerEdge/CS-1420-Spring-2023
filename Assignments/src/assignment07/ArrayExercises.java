/**
 * <p>
 * See below for requirements.  Note that the JavaDoc comments below
 * (and this one) are formatted with HTML tags to create a nicer
 * view in the generated documentation.
 * </p>
 */
package assignment07;

/* Only import java.awt.Color and java.awt.Rectangle. */
import java.awt.Color;
import java.awt.Rectangle;
/* No other imports are allowed. */

/**
 * <p>
 * This class is a collection of static methods for processing arrays.
 * There are no fields or static variables, and none are allowed.
 * (In other words, only use variables declared inside each method.)
 * You will not build ArrayExercises objects.  Instead, you'll just
 * call (execute) the static methods in this class, like this:  
 * ArrayExercises.sort(someArray)
 * </p>
 * 
 * <p>
 * This class is the starting point for programming assignment #7.  Each
 * method has a contract, and you will write the statements inside
 * each method to exactly satisfy the contract.  Note:  Some methods
 * indicate they might throw an exception.  You don't need to throw
 * these exceptions -- I've anticipated what exceptions will be thrown
 * normally when incorrect parameters are passed to the methods.
 * <b>(Don't add code to throw exceptions and don't prevent them
 * from being thrown.)</b>
 * </p>
 * 
 * <p>
 * Note:  None of the method contracts below says anything about files,
 * user input, or console printing.  Don't prompt the user or ask
 * for input.  You may print what you need to while testing,
 * but all printing should be removed from the code you submit.
 * </p>
 * 
 * <p>
 * When completing the assignment, students may not use any
 * Java library methods for working with arrays (sorting, searching, etc.),
 * except during testing.  Your tests may use the Arrays class, but your
 * functions here cannot.  (Advanced students must not use collections
 * or equivalent structures.) You will write equivalent code here instead.
 * </p>
 * 
 * @author ***Put your name here***
 * @version ***Put the date here***
 */

public class ArrayExercises
{
    /**
     * <p>
     * This method returns an array of size 'size' full of unique randomly
     * ordered integers in the range [0..size).  All integers in the range
     * [0..size) will be in the array, but they will be in a shuffled order.
     * </p>
     * 
     * <p>
     * From Peter:  This is an example array function that is more complex than 
     * almost all of the assignment problems.  I am providing it to show you an 
     * interesting use of arrays as well as to show you how unit tests can be 
     * used to check correctness of methods and classes.
     * </p>
     * 
     * @param size the number of array locations requested
     * @return an array of the specified size filled with randomly ordered integers
     */
    public static int[] randomArray (int size)
    {
        // Create an array of the requested size.
        
        int[] numbers = new int[size];  // If size is negative, this throws an exception.
        
        // Fill the array with the integers [0..size)
        
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i;  // Just store the index of each location in the location, not normally done.
        
        // Shuffle the array (starting from the right).  For each
        //   position i, find a random position j, and swap elements
        //   at those positions.
        
        for (int i = numbers.length - 1; i > 0; i--)
        {
            // Pick a random location for j (but only to the left of i).
        	//   (Getting this wrong creates a bias - must do it as shown.)
            
            int j = (int) (Math.random()*(i+1));
            
            // j = (int) (Math.random() * size);  // This way is wrong - feel free to uncomment it to cause a JUnit test error.
            
            // Swap elements i and j in the array.
            
            int tempI = numbers[i];
            int tempJ = numbers[j];            
            numbers[i] = tempJ;
            numbers[j] = tempI;           
        }
        
        // Done.  Feel free to uncomment the lines below to simulate errors.
        
        // numbers = new int[size+1];  // This causes an error - the array size is wrong.
        // numbers[0] = -1;  // This causes an error - a number is overwritten.  I use it for testing my error code.
        
        return numbers;
    }
    
    /**
     * <p>
     * This method reverses 'in place' the elements in
     * the array.  Reversing is defined as moving the
     * elements in the array such that the first element
     * becomes the last element, the second element
     * becomes the second to last element, the third
     * element becomes the third to last element, etc.
     * </p>
     * 
     * <p>
     * This method does not have a return
     * type - the list array is modified directly.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes. 
     * </p>
     * 
     * <p><b>This is problem #1 for programming assignment #7.</b></p>
     *
     * <p>(Hint:  Many students loop too far, and accidentally
     * do and undo the reversal.)</p>
     * 
     * @param symbols   An array that will be reversed.
     */
    public static void reverseOrder (char[] symbols)
    {
        // Swaps the outer and inner indices every iteration
        // Ex. Index 0 and end index swapping then index 1 and end index - 1 swapping
        for (int index = 0; index <= symbols.length / 2 - 1; index++) {
            int arrayIndexLength = symbols.length - 1;
            char currentChar = symbols[index];
            symbols[index] = symbols[arrayIndexLength - index];
            symbols[arrayIndexLength - index] = currentChar;
        }
    }
    
    /**
     * <p>
     * This method counts and returns how many times the target
     * object occurs in the array.  For this method,
     * two objects are considered the same if they represent
     * the same thing.  In other words, use .equals().
     * </p>
     * 
     * <p>Note:  It is legal for the values array to contain a
     * null object, and it is legal for the target to be null.
     * No exception should be thrown in this case, and the
     * correct count should be returned.</p>
     * 
     * <p><b>This is problem #2 for programming assignment #7.</b></p>
     *
     * <p>(Hint:  For testing, you can use Object arrays that you
     * fill with Strings, Colors, BigIntegers, or any other Object references.)</p>
     * 
     * @param values   An array of Object references
     * @param target   A target object
     * @return   The number of objects in the array that equal the target
     * @throws NullPointerException   If values is null
     */
    public static int count (Object[] values, Object target)
    {
    	// Hint -- you may want code like this...
    	// if (target == null)    or maybe   if (value == null), or some combination of code like this
    	// Initialize counter that counts matches
        int matchCount = 0;
        try {
            for (int index = 0; index < values.length; index++) {
                // If the Object equals to the target or null, we add a match
                if (values[index] == null || values[index].equals(target)) {
                    matchCount++;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
        // return the count
        return matchCount;
    }
    
    /**
     * <p>
     * This method examines the elements in the array and
     * replaces all occurrences in the array of the original String 
     * with the replacement String.  The array contents are
     * modified.
     * </p>
     * 
     * <p>
     * For this method, two Strings are considered equal
     * if they refer to the same object.  (Use ==)  Note that either
     * the original String, the replacement String, or
     * any of the Strings in the list may be null, and this is
     * both allowed and expected on occasion.
     * </p>
     * 
     * <p>
     * This method does not have a return
     * type - the list array is modified directly.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes. 
     * </p>
     * 
     * <p><b>This is problem #3 for programming assignment #7.</b></p>
     * 
     * <p>Hint:  If you have "Hello" and "Hello" in separate places
     * in your code, note that Java/IntelliJ may choose to create a single
     * String object for both of these "Hello" strings, and use it 
     * in both places that "Hello" exists.  To get around this,
     * use new String("Hello") if you want to guarantee the
     * creation of a different String object.  </p>
     * 
     * @param list   An array of String references
     * @param original   The String reference to be replaced
     * @param replacement   The replacement String reference
     * @throws NullPointerException   If list is null
     */
    public static void replace (String[] list, String original, String replacement)
    {
        // We loop through the list anr change the element to the replacement if it matches the original String
        // Nothing is returned from this method
        try {
            for (int index = 0; index < list.length; index++) {
                if (list[index] == original) {
                    list[index] = replacement;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
    }
    
    /**
     * <p>
     * This method computes and returns the area of several rectangular
     * regions.  The data is not stored in Rectangle objects.  Instead,
     * the data is stored in parallel arrays.  (In parallel arrays,
     * data at position i in each array is related to the data in the
     * other arrays at position i:
     * </p>
     * 
     * <p>
     * For a rectangle i, width[i] specifies
     * the width of the rectangle, and height[i] specifies
     * the height of the rectangle.</p>
     * 
     * <p> A new array is created
     * (that is the same size as the width and height arrays)
     * and the area of each rectangle is computed and placed
     * in this array.  (Area of rectangle i would be stored
     * in the ith position in the array.)  The array is then returned.
     * </p>
     * 
     * <p>
     * This method assumes (but does not check) that the widths and heights are positive.
     * </p>
     * 
     * <p>
     * Note that width and height arrays must be the same size.
     * </p>
     * 
     * <p><b>This is problem #4 for programming assignment #7.</b></p>
     * 
     * @param widths   An array of rectangle widths
     * @param heights  An array of rectangle heights
     * @return   An array of rectangle areas
     * @throws NullPointerException   If widths or heights is null
     * @throws ArrayIndexOutOfBoundsException   If widths or heights are not the same size
     */
    public static double[] computeAreas (double[] widths, double[] heights)
    {
        // An array containing all rectangleAreas is initialized with length of width array as a non-match between
        // widths and heights will anyway cause an exception
        double[] rectangleAreas = new double[widths.length];
        try {
            // Loop through, compute areas and store
            try {
                for (int index = 0; index < widths.length; index++) {
                    rectangleAreas[index] = widths[index] * heights[index];
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception Caught: ArrayIndexOutOfBoundsException");
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
        // Return array of calculated areas
        return rectangleAreas;
    }
    
    /**
     * <p>
     * This method creates and returns a new array that
     * contains all the colors stored in the original array,
     * except those colors that are equal to the target.  For this
     * method, two colors are equal if they represent the
     * same color.
     * </p>
     * 
     * <p>
     * Note that target may be null, and 'pixels' may contain
     * null elements.  Two null elements will be considered equal.
     * </p>
     * 
     * <p><b>This is problem #5 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  Use Color.BLUE, Color.RED, etc. for testing.)</p>
     * 
     * @param pixels   An array of Color references
     * @param target   The Color object to be removed
     * @throws NullPointerException   If pixels is null
     */
    public static Color[] remove (Color[] pixels, Color target)
    {
        // A count is initialized to see how many instances of the target color exist
        int matchCount = 0;

        // matchCount is updated as the array is iterated through
        try {
            for (int index = 0; index < pixels.length; index++) {
                if (pixels[index] == target) {
                    matchCount++;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }

        // An array of the number of matches is formed
        Color[] sortedColors = new Color[pixels.length - matchCount];
        int sortedIndex = 0;

        // The new array adds all the elements that aren't matching the target to itself
        try {
            for (int index = 0; index < pixels.length; index++) {
                if (pixels[index] != target && sortedIndex != matchCount) {
                    sortedColors[sortedIndex] = pixels[index];
                    sortedIndex++;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
        // Return the updated array with unmatching elements to the target
        return sortedColors;
    }
    
    
    /**
     * <p>
     * This method sorts the elements in the data array
     * in descending order using selection sort (The largest element will 
     * be placed in position 0.)
     * </p>
     * 
     * <p>
     * Note that this method does not have a return
     * type - the data array is sorted 'in place'.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes.
     * </p>
     * 
     * <p>You must write a selection sort algorithm for this solution.</p>
     * 
     * <p><b>This is problem #6 for programming assignment #7.</b></p>
     * 
     * @param data   The array to be sorted
     * @throws NullPointerException   If data is null
     */    
    public static void sort (int[] data)
    {
        try {
            // Choose the current element and crosscheck its value with all other values within the array
            // If current element is greater, we swap the elements
            // Nothing is returned
            for (int currIndex = 0; currIndex < data.length; currIndex++) {
                for (int checkIndex = 0; checkIndex < data.length; checkIndex++) {

                    // Check which value is greater
                    if (data[currIndex] > data[checkIndex]) {
                        int elementSwapped = data[currIndex];
                        data[currIndex] = data[checkIndex];
                        data[checkIndex] = elementSwapped;
                    }
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
    }
    
    
    /**
     * <p>
     * This method finds and returns the smallest rectangle in the
     * array.  The smallest rectangle is defined as the one
     * with the smallest area.  If two rectangles have the same
     * smallest area, the one that occurs last in the array
     * is returned.
     * </p>
     * 
     * <p>
     * This method requires that the rectangles array 
     * must not contain null.
     * </p>
     * 
     * <p><b>This is problem #7 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  Look up the documentation for the Rectangle class.
     * You'll see how to extract the needed information from each Rectangle.)</p>
     * 
     * @param rectangles   An array of rectangle objects
     * @return   The smallest rectangle in the array
     * @throws NullPointerException   If rectangles is null or rectangles contains null
     */
    public static Rectangle findSmallest (Rectangle[] rectangles)
    {
        // We can say the first rectangle in the array is the smallest
        Rectangle smallestRect = rectangles[0];

        // Iterate and compare each rectangle's calculated area to the smallest rectangle's area and set the smallest
        // rectangle to the current rectangle if the area is smaller or equal
        try {
            for (int index = 0; index < rectangles.length; index++) {
                double rectWidth = rectangles[index].getWidth();
                double rectHeight = rectangles[index].getHeight();
                double smallestWidth = smallestRect.getWidth();
                double smallestHeight = smallestRect.getHeight();

                // Calculation and comparison
                if (rectWidth * rectHeight <= smallestWidth * smallestHeight) {
                    smallestRect = rectangles[index];
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
        }
        // Return the smallest rectangle's object
        return smallestRect;
    }    
    
    /**
     * <p>
     * This method counts how many times each value appears 
     * in the data array, and returns an array of these counts.
     * (If 16 occurs 13 times in the data array, then 
     * the returned array will contain a thirteen in position 16
     * of the array.)  This method assumes that data values 
     * will be non-negative and small.
     * </p>
     * 
     * <p>
     * The size of the returned list is determined by the maximum value
     * stored in the data array.  The size of the returned list will be
     * one greater than the maximum value stored in the data array.
     * </p>
     * 
     * <p><b>This is problem #8 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  This problem has two major steps.  Solve them one at a time,
     * and don't try to mix the code between the two steps.  (Keep the ideas
     * and code steps separately as much as you can.)</p>
     * 
     * @param data   A data array
     * @return   An array of counts
     */
    public static int[] histogram (int[] data)
    {
        int highestNum = 0;

        // First we find the highest number in the array to determine the histogram length
        for (int index = 0; index < data.length; index++) {
            if (data[index] > highestNum) {
                highestNum = data[index];
            }
        }

        // Create histogram and set to length of the highest number plus 1
        int[] countOfNums = new int[highestNum + 1];
        int matchCount = 0;

        // Iterating through the data, we count the number of instances for each number and place that value into the
        // corresponding value in the histogram
        for (int num = 0; num < countOfNums.length; num++) {
            for (int elementIndex = 0; elementIndex < data.length; elementIndex++) {
               // Check for equality between current number and number to be checked
                if (num == data[elementIndex]) {
                    matchCount++;
                }
            }
            countOfNums[num] = matchCount;
            matchCount = 0;
        }
        // Return histogram array
        return countOfNums;
    }
}
