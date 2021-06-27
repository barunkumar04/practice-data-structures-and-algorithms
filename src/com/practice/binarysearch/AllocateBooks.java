package com.practice.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/***
 *

 Problem Description
 Given an array of integers A of size N and an integer B. College library has N books,the ith book has A[i] number of pages.
 You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.
 A book will be allocated to exactly one student. Each student has to be allocated at least one book.
 Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 Calculate and return that minimum possible number.

 NOTE: Return -1 if a valid assignment is not possible.

 Problem Constraints
     1 <= N <= 105
     1 <= A[i], B <= 105

 Input Format
     The first argument given is the integer array A.
     The second argument given is the integer B.

 Output Format
     Return that minimum possible number

 Example Input
     A = [12, 34, 67, 90]
     B = 2

 Example Output
     113

 Example Explanation
    There are 2 number of students. Books can be distributed in following fashion :
        1) [12] and [34, 67, 90]
    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3) [12, 34, 67] and [90]
    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

    Of the 3 cases, Option 3 has the minimum pages = 113.
 *
 */

// TODO - Revisit logic
public class AllocateBooks {

    private static int minAllocation = Integer.MAX_VALUE;
    public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9 ));
            int B = 5;

            System.out.println(allocateBooks(A, B));
    }
    public static int allocateBooks(ArrayList<Integer> A, int B) {

        //Collections.sort(A);

        int totalPages = A.stream().reduce(0, Integer::sum);

        int minPages  = 0;
        int maxPages = totalPages;
        binarySearchToMaximizePageAllocation(minPages, maxPages, A, B);

        return minAllocation;
    }

    private static void binarySearchToMaximizePageAllocation(int minPages, int maxPages, ArrayList<Integer> books, int studentCount){

        if(minPages >= maxPages)
            return;

        int pages = minPages + (maxPages - minPages) / 2;
        boolean validAllocation = validateAllocation(pages, books, studentCount);

        if(validAllocation)
            binarySearchToMaximizePageAllocation(pages+1, maxPages, books, studentCount);
        else
            binarySearchToMaximizePageAllocation(minPages, pages-1, books, studentCount);
    }

    private static boolean validateAllocation(int pages, ArrayList<Integer> books, int studentCount){
        int maxAllocatedPageCount = Integer.MIN_VALUE;
        int pageCount = 0;
        for(int i=0; i<books.size(); i++){
            pageCount = pageCount + books.get(i);
            if(pageCount >= pages){ // allocate
                studentCount--;
                if(studentCount == 0){
                    i++;
                    for( ;i<books.size(); i++){
                        pageCount = pageCount + books.get(i);
                    }
                    minAllocation = Math.min(minAllocation, maxAllocatedPageCount);
                    return true;
                }
                maxAllocatedPageCount = Math.max(maxAllocatedPageCount, pageCount);

                pageCount = 0;
            }
        }

        return false;
    }
}
