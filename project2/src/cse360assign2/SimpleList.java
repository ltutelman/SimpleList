
/**
 * @author 		Laura Tutelman
 * StudentID:	1212541237
 * Assignment:	1
 * 
 * This file contains the SimpleList class.  The program constructs a ten integer array
 * and performs operations including add, remove, and search.  Count returns the number of elements
 * in the array and toString returns a concatenated String. 
 */

package cse360assign2;

/**
 * Simple list class contains all operations on a simple ten integer java array and also contains
 * the array size. 
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
	 * @param	input	value to be added to the array
	 */
	public void add(int input)
	{
		if(count < 10)
		{
			for(int index = count; index > 0; index--)
			{
			    list[index] = list[index - 1];
			}
		    list[0] = input;
			count++;
		}
		else if(count == 10)
		{
			for(int index = 9; index > 0; index--)
			{
				list[index]= list[index - 1];
			}
		    list[0] = input;
		}
		
	}
	
	/**
	 * Removes an integer from the array and, if needed, shifts all other elements one index left.
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

	}
	
	/**
	 * Gives the size of the array.
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

}
