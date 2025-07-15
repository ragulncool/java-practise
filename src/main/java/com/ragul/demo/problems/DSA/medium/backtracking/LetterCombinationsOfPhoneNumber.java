package com.ragul.demo.problems.DSA.medium.backtracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        System.out.println(solution.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, new StringBuilder(), digits, mapping, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentCombination, String digits, String[] mapping, int index) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(result, currentCombination, digits, mapping, index + 1);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // backtrack
        }
    }
}
