package com.example;

public class Main
{
    public static void main(String[] args)
    {
        Subsequence subsequence = new Subsequence(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20});
        subsequence.findArithmeticSubsequences();
        subsequence.printSubsequences();
    }
}
