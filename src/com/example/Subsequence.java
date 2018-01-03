package com.example;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/articles/arithmetic-slices-ii-subsequence/

- A subsequence of an array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
- A subsequence is called arithmetic if it consists of at least three elements and if the difference between any two
consecutive elements is the same.

TODONE: Return the number of arithmetic subsequences in any given array...
*/

class Subsequence
{
    private int[] array;
    private List<List<Integer>> subsequences = new ArrayList<>();

    Subsequence(int[] array)
    {
        this.array = array;
    }

    void findArithmeticSubsequences()
    {
        List<Integer> subsequence = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
        {
            subsequence.add(array[i]);
            findArithmeticSubsequences2(subsequence, i + 1);
            subsequence.remove(subsequence.size() - 1);
        }
    }

    private void findArithmeticSubsequences2(List<Integer> subsequence, int index)
    {
        for (int i = index; i < array.length; i++)
        {
            subsequence.add(array[i]);
            if (isArithmetic(subsequence))
            {
                subsequences.add(new ArrayList<>(subsequence));
            }
            findArithmeticSubsequences2(subsequence, index + 1);
            subsequence.remove(subsequence.size() - 1);
        }
    }

    private boolean isArithmetic(List<Integer> sequence)
    {
        return sequence.size() >= 3 && sameDifference(sequence);
    }

    private boolean sameDifference(List<Integer> sequence)
    {
        int difference = 0;

        boolean firstIteration = true;
        for (int i = 0; i < sequence.size() - 1; i++)
        {
            if (firstIteration)
            {
                firstIteration = false;
                difference = sequence.get(i + 1) - sequence.get(i);
            }
            else
            {
                if (difference != sequence.get(i + 1) - sequence.get(i))
                {
                    return false;
                }

            }
        }

        return true;
    }

    void printSubsequences()
    {
        for (List<Integer> list : subsequences)
        {
            System.out.println(list);
        }
    }
}
