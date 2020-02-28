/**
 * @author 		Laura Tutelman
 * StudentID:	1212541237
 * Assignment:	2
 *
 * This file contains the SimpleList class.  The program constructs a ten integer array
 * and performs operations including add, append, remove and search.
 * Count returns the number of elements in the array, toString returns a concatenated String,
 * size returns the size of the array, and first and last return the first and last
 * elements, respectively.
 */

package cse360assign2;

/**
 * Simple list class contains all operations on a simple ten integer java array and also contains
 * the array size, element count, and first and last elements.
 */
public class SimpleList {

    private int[] list;
    private int count;

    /**
     * Constructs ten integer array and initializes count to zero.
     */
    public SimpleList()
    {
        list = new int[10];
        count = 0;
    }

    /**
     * Adds new element to the beginning of the array and shifts all other elements one index right.
     * If list is full, adds 50% extra space to array.
     * @param	input	value to be added to the array
     */
    public void add(int input)
    {
        if(count < list.length)
        {
            for(int index = count; index > 0; index--)
            {
                list[index] = list[index - 1];
            }
            list[0] = input;
            count++;
        }
        //if array is full, we allocate more memory and insert the new element
        else if(count == list.length)
        {
            int[] tempList = new int[(int) Math.floor(list.length*1.5)];
            for(int index = 0; index < list.length; index++)
            {
                tempList[index] = list[index];
            }

            for(int index = count; index > 0; index--)
            {
                tempList[index]= tempList[index - 1];
            }
            tempList[0] = input;
            list = tempList;
            count++;
        }

    }
    /**
     * Adds new element to the end of the array and increases array size by 50% if array is full.
     * @param	input	value to be added to the array
     */
    public void append(int input)
    {
        if(count < list.length)
        {
            list[count] = input;
            count++;
        }
        else if(count == list.length)
        {
            //make new array with more space and then rename it

            int[] tempList = new int[(int) Math.floor(list.length)];
            for(int i = 0; i < list.length; i ++)
            {
                tempList[i] = list[i];
            }
            list = tempList;

            //shift everything and set new initial value
            list[count] = input;
            count++;
        }
    }

    /**
     * Removes an integer from the array and, if needed, shifts all other elements one index left.
     * If list is less than 75% full, array size moves down to the number of elemts it currently posesses.
     * @param	removeInt	value to be removed from the array
     */
    public void remove(int removeInt)
    {
        //first check that removeInt is in the array
        if(search(removeInt) != -1)
        {
            for(int index = 0; index < count; index++)
            {
                if(list[index] == removeInt)
                {
                    //shift all remaining elements back
                    for(int shiftIndex = index; shiftIndex <= count; shiftIndex++)
                    {
                        list[shiftIndex] = list[shiftIndex + 1];
                    }
                    list[count] = 0;
                    count--;
                }
            }
        }
        //Check how many empty places and then decrease size of the list

        //if count is less than 75% of the length, then we decrease list size
        if(count < (int)(Math.floor(list.length*.75)))
        {
            int[] tempList = new int[count];
            for(int i = 0; i < count; i++)
            {
                tempList[i] = list[i];
            }
            list = tempList;
        }

    }

    /**
     * Gives the size of the array in terms of elements.
     * @return	the number of elements in the array
     */
    public int count()
    {
        return count;
    }

    /**
     * Concatenates integer array into a string with values separated by a single " "
     * @return	A space-delimited string representation of the array
     */
    public String toString()
    {

        String concat = "";
        if(count != 0) {
            for(int index = 0; index < count-1; index++)
            {
                //concatenate all but last element which can not be followed by " "
                concat += Integer.toString(list[index]) + " ";
            }
            concat += Integer.toString(list[count - 1]);
        }

        return concat;
    }

    /**
     * Searches to see if an integer is in the array
     * @param	searchInt	the value to search for in the array
     * @return	return -1 if no value found otherwise return index of first appearance of searchInt
     */
    public int search(int searchInt)
    {
        boolean found = false;
        int searchIndex = -1;
        for(int index = 0; index <= count; index++)
        {
            //array element must be searchInt AND not be the first instance
            if(list[index] == searchInt && found == false)
            {
                searchIndex = index;
                found = true;
            }
        }
        return searchIndex;
    }
    /**
     * Gives first element in the list.
     * @return fist element in array
     */
    public int first()
    {
        int returnValue = -1;
        if(count > 0)
        {
            returnValue = list[0];
        }
        return returnValue;
    }
    /**
     * Gives last element in the list.
     * @return last element in array
     */
    public int last()
    {
        int returnValue = -1;
        if(count > 0)
        {
            returnValue = list[count-1];
        }
        return returnValue;	}
    /**
     * Gives current number of possible location in the list.
     * @return size of list
     */
    public int size()
    {
        return list.length;
    }

}
