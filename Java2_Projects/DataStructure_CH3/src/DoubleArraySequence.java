// Naomi Crosby - Data Structures
// Chapter 3 - Sequence Program


/* ****** NOT COMPLETED ****** */

// File: DoubleArraySequence.java from the package edu.colorado.collections
// package edu.colorado.collections;

/******************************************************************************
 * This class is a homework assignment;
 * A DoubleArraySeq is a collection of double numbers.
 * The sequence can have a special "current element," which is specified and 
 * accessed through four methods that are not available in the sequence class 
 * (start, getCurrent, advance and isCurrent).
 *
 * @note
 *   (1) The capacity of one a sequence can change after it's created, but
 *   the maximum capacity is limited by the amount of free memory on the 
 *   machine. The constructor, addAfter, 
 *   addBefore, clone, 
 *   and concatenation will result in an
 *   OutOfMemoryError when free memory is exhausted.
 *   <p>
 *   (2) A sequence's capacity cannot exceed the maximum integer 2,147,483,647
 *   (Integer.MAX_VALUE). Any attempt to create a larger capacity
 *   results in a failure due to an arithmetic overflow. 
 *
 * @note
 *   This file contains only blank implementations ("stubs")
 *   because this is a Programming Project for my students.
 *
 * @see
 *   <A HREF="../../../../edu/colorado/collections/DoubleArraySeq.java">
 *   Java Source Code for this class
 *   (www.cs.colorado.edu/~main/edu/colorado/collections/DoubleArraySeq.java)
 *   </A>
 *
 * @version
 *   March 5, 2002
 ******************************************************************************/
public class DoubleArraySequence implements Cloneable {
	// Invariant of the DoubleArraySeq class:
	//   1. The number of elements in the sequences is in the instance variable 
	//      manyItems.
	//   2. For an empty sequence (with no elements), we do not care what is 
	//      stored in any of data; for a non-empty sequence, the elements of the
	//      sequence are stored in data[0] through data[manyItems-1], and we
	//      don’t care what’s in the rest of data.
	//   3. If there is a current element, then it lies in data[currentIndex];
	//      if there is no current element, then currentIndex equals manyItems. 
	private double[ ] data;
	private int manyItems;
	private int currentIndex; 

	/**
	 * Initialize an empty sequence with an initial capacity of 10.  
	 * Note that the addAfter and addBefore methods work
	 * efficiently (without needing more memory) until this capacity is reached.
	 * @param - none
	 * @postcondition
	 *   This sequence is empty and has an initial capacity of 10.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for: 
	 *   new double[10].
	 **/   
	public DoubleArraySequence( ) {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new double[INITIAL_CAPACITY];
	}

	/**
	 * Initialize an empty sequence with a specified initial capacity. Note that
	 * the addAfter and addBefore methods work
	 * efficiently (without needing more memory) until this capacity is reached.
	 * @param initialCapacity
	 *   the initial capacity of this sequence
	 * @precondition
	 *   initialCapacity is non-negative.
	 * @postcondition
	 *   This sequence is empty and has the given initial capacity.
	 * @exception IllegalArgumentException
	 *   Indicates that initialCapacity is negative.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for: 
	 *   new double[initialCapacity].
	 **/   
	public DoubleArraySequence(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException
			("The initialCapacity is negative: " + initialCapacity);
		data = new double[initialCapacity];
		manyItems = 0;
	}

	/**
	 * Add a new element to this sequence, after the current element. 
	 * If the new element would take this sequence beyond its current capacity,
	 * then the capacity is increased before adding the new element.
	 * @param element
	 *   the new element that is being added
	 * @postcondition
	 *   A new copy of the element has been added to this sequence. If there was
	 *   a current element, then the new element is placed after the current
	 *   element. If there was no current element, then the new element is placed
	 *   at the end of the sequence. In all cases, the new element becomes the
	 *   new current element of this sequence. 
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for increasing the sequence's capacity.
	 * @note
	 *   An attempt to increase the capacity beyond
	 *   Integer.MAX_VALUE will cause the sequence to fail with an
	 *   arithmetic overflow.
	 **/
	public void add(double element) {
		if (manyItems == data.length) {  // Ensure twice as much space as we need.
			ensureCapacity( (manyItems * 2) + 1 );
		}
		data[manyItems] = element;
		manyItems++;
	}

	/**
	 * Remove the current element from this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @postcondition
	 *   The current element has been removed from this sequence, and the 
	 *   following element (if there is one) is now the new current element. 
	 *   If there was no following element, then there is now no current 
	 *   element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   removeCurrent may not be called. 
	 **/
	public void remove( ) {
		/*int index; // The location of target in the data array.

    // First, set index to the location of target in the data array,
    // which could be as small as 0 or as large as manyItems-1; If target
    // is not in the array, then index will be set equal to manyItems;
    for (index = 0; (index < manyItems) && (target != data[index]); index++)
       // No work is needed in the body of this for-loop.
       ;

    if (index == manyItems) {
       // The target was not found, so nothing is removed.
       return false;
    } else {  
    	// The target was found at data[index].
    	// So reduce manyItems by 1 and copy the last element onto data[index].
       manyItems--;
       data[index] = data[manyItems];
       return true;
    }*/
	}	
	
	/**
	 * Move forward, so that the current element is now the next element in
	 * this sequence.
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this sequence 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   advance may not be called.
	 **/
	public void advance( ) {
		// Implemented by student.
	}

	/**
	 * Change the current capacity of this sequence.
	 * @param minimumCapacity
	 *   the new capacity for this sequence
	 * @postcondition
	 *   This sequence's capacity has been changed to at least minimumCapacity.
	 *   If the capacity was already at or greater than minimumCapacity,
	 *   then the capacity is left unchanged.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for: new int[minimumCapacity].
	 **/
	public void ensureCapacity(int minimumCapacity) {
		double[ ] biggerArray;

		if (data.length < minimumCapacity) {
			biggerArray = new double[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}

	/**
	 * Accessor method to get the current element of this sequence. 
	 * @param - none
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this sequence
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public double getCurrent( ) {
		// Implemented by student.
	}

	/**
	 * Accessor method to determine whether this sequence has a specified 
	 * current element that can be retrieved with the 
	 * getCurrent method. 
	 * @param - none
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public double isCurrent( ) {
		// Implemented by student.
	}

	/**
	 * Determine the number of elements in this sequence.
	 * @param - none
	 * @return - the number of elements in this bag
	 **/               
	public int size( ) {
		return manyItems;
	}
}
