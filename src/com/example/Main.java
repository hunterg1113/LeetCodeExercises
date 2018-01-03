package com.example;

public class Main
{
    public static void main(String[] args)
    {
        Subsequence subsequence = new Subsequence(new int[]{2, 4, 6, 8, 10});
        subsequence.findAllSubsequences();
        subsequence.printSubsequences();
    }
}
