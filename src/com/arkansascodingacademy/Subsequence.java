package com.arkansascodingacademy;

//The function should return the number of arithmetic subsequence slices in an array.

import java.util.ArrayList;
import java.util.List;

class Subsequence
{
    private int[] array;
    private List<List<Integer>> subsequences = new ArrayList<>();

    Subsequence(int[] array)
    {
        this.array = array;
    }

    //   A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of
    // integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
    //   A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic.
    // In particular, this means that k ≥ 2.
    //   The function should return the number of arithmetic subsequence slices in an array.

    void findAllSubsequences()
    {
        for (int size = 3; size <= array.length; size++)
        {
            for (int index = 0; index <= array.length - size; index++)
            {
                addToSubsequences(index, size);
            }
        }
    }

    private void addToSubsequences(int index, int size)
    {
        List<Integer> subsequence = new ArrayList<>();

        for (int i = index; i < index + size; i++)
        {
            subsequence.add(array[i]);
        }

        subsequences.add(subsequence);
    }

    // A sequence of integers is arithmetic if it consists of at least three elements and
    // if the difference between any two consecutive elements is the same.
    boolean isArithmetic()
    {
        return array.length > 2 && sameDifference();
    }

    private boolean sameDifference()
    {
        int difference = -1;

        boolean firstIteration = true;
        for (int i = 0; i < array.length - 1; i++)
        {
            if (firstIteration)
            {
                firstIteration = false;
                difference = array[i + 1] - array[i];
            }
            else
            {
                if (difference != array[i + 1] - array[i])
                {
                    return false;
                }

            }
        }

        return true;
    }

    List<List<Integer>> getSubsequences()
    {
        return subsequences;
    }

    void printSubsequences()
    {
        for(List<Integer> list : subsequences)
        {
            System.out.println(list);
        }
    }
}
