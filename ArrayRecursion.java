/*  File: ArrayRecursion.java
 *
 *  Programmer: your name
 *
 */

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class that performs some simple array operations recursively
 * @author Greg
 */
public class ArrayRecursion
{
   // instance var's
   private int[] list ;       // array of ints
   private int size ;         // number of elements

   /**
    * Create an ArrayRecursion object. 
    * Creates an array with between 10 and 15 elements, and fills it with
    * random positive 2-digit ints
    */
   public ArrayRecursion()
   {
      Random r = new Random();
      size = r.nextInt(6) + 10;
      list = new int[size];

      for (int i = 0; i < size; i++)
      {
         list[i] = r.nextInt(90) + 10;
      }
   }

   /**
    * Return the list as a string
    * @return a string containing all ints stored in list
    */
   public String toString()
   {
      String out = "";
      for (int i = 0; i < size; i++)
      {
         out += list[i] + "  ";
      }
      return out + "\n";
   }

   /**
    * Returns the index of the smallest value in the array.
    * @return the index of the smallest value in the array
    */
   public int getIndexOfSmallest()
   {
      return recursiveGetIndexOfSmallest(list, size);
   }

   // recursive "helper" method to return index of smallest value
   // called by public method getIndexOfSmallest()
   private int recursiveGetIndexOfSmallest(int[] list, int count)
   {
       int index; // index of smallest value 
  
       if(count == 1) // if only one element in array
       {
           return 0 ; //return its index
       }
       
       /*
        Call recursive function until you reach base case and then store the
        returned index into a variable
       */
       index = recursiveGetIndexOfSmallest(list,count - 1) ; 
       
       // if value at index is less than last element in array
       if(list[index] < list[count-1])
       {
           return index ; // return 
       }
     
      return count - 1;   // return index of last element in array
   }

   /**
    * Sort the array in descending order using the selection sort
    */
   public void sort()
   {
      recursiveSort(list, size);
   }

   // recursive "helper" method to sort the array
   // called by public method sort()
   private void recursiveSort(int[] list, int count)
   {
       int index ; //index of smallest value in array
       int temp ; // a temporary variable to hold a value in an index to swap
       
       if(count == 0) //base case no more swaps to be made
       {
           return ;
       }
       
       //swap code, find the index of the smallest value in the array and then
       //swap with the last element in the array
       index = recursiveGetIndexOfSmallest(list, count) ;
       temp = list[count -1] ;
       list[count - 1] = list[index] ;
       list[index] = temp ;
       
       recursiveSort(list, count - 1) ; //recursive call to sort smaller array
   }
   
   /**
    * Indicates whether a given int is on the list
    * @param target the int to search for
    * @return true if target is on the list, false if not
    */
   public boolean contains (int target)
   {
      return recursiveContains(list,size,target) ;
   }
   
   // recursive "helper" method to search the array
   // called by public method contains()
   private boolean recursiveContains(int[] list, int count, int target)
   {
       if(count == 0) //if all elements in array have been tested
       {
           return false ; // return false
       }
       
       if(list[count - 1] == target) // if the target is found
       {
           return true ; // return true
       }
       
       //reduce array and pass to same method
       return recursiveContains(list, count - 1, target) ;    
   }   
   
   public static void main(String[] args)
   {
      ArrayRecursion list = new ArrayRecursion();

      System.out.println("\nOriginal:  " + list);

      System.out.println("Smallest value is at index: "
              + list.getIndexOfSmallest());
      list.sort();
      System.out.println("\nSorted:    " + list);
     
      String target = JOptionPane.showInputDialog("Number to search for?") ;
      int searchee = Integer.parseInt(target) ;
      
      if (list.contains(searchee))
         System.out.println(searchee + " is on the list");
      else
         System.out.println(searchee + " is not on the list");
   }
}
