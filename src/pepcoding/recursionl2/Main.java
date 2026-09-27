package src.pepcoding.recursionl2;

import java.util.HashMap;

public class Main {

    // Q1: Print abbrevatiations (which will be made from the binary nums of length = word.length() )
    static void printAbbreviations(String word, int idx, int count, String asf) {
        if (idx == word.length()) {
            if (count != 0) {
                System.out.println(asf + count);
            } else {
                System.out.println(asf);
            }
            return;
        }

        char ch = word.charAt(idx);

        String settle = "";
        if (count != 0) {
            settle += count;
        }
        printAbbreviations(word, idx + 1, 0, asf + settle + ch); // include ch
        printAbbreviations(word, idx + 1, count + 1, asf); // exclude ch
    }

    // Q2: N-Queens, find all combinations in which N queens can be placed in a NxN matrix such that no queen could kill another
    static void nQueens(boolean[][] board, int n, int i, String ans, boolean[] restrictedCol, boolean[] restrictedIncresingDiagonal, boolean[] restrictedDecreasingDiagonal) {

        if(i == n){
            System.out.println(ans);
            return;
        }

        for(int j=0; j<n; j++) {

            int incDiagIdx = i+j;
            int decDiagIdx = i-j + n-1;

            if (board[i][j] == false) {
                if (!restrictedCol[j] && !restrictedIncresingDiagonal[incDiagIdx] && !restrictedDecreasingDiagonal[decDiagIdx]) {

                    board[i][j] = true;
                    restrictedCol[j] = true;
                    restrictedIncresingDiagonal[incDiagIdx] = true;
                    restrictedDecreasingDiagonal[decDiagIdx] = true;

                    String pair = i + "-" + j + ", ";
                    nQueens(board, n, i + 1, ans+pair , restrictedCol, restrictedIncresingDiagonal, restrictedDecreasingDiagonal);

                    board[i][j] = false;
                    restrictedCol[j] = false;
                    restrictedIncresingDiagonal[incDiagIdx] = false;
                    restrictedDecreasingDiagonal[decDiagIdx] = false;
                }
            }
        }


    }

    // Q3: Max score of words
    static int maxScore(String[] words, int[] scores, int[] freqArray, int idx){
        if(idx == words.length){
            return 0;
        }

        int scoreNo = maxScore(words, scores, freqArray,idx+1);

        String word = words[idx];
        int currWordScore = 0;
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(freqArray[ch-'a'] <=0){
                flag = false;
            }

            currWordScore += scores[ch - 'a'];
            freqArray[ch-'a']--;
        }

        int scoreYes = 0;
        if(flag){
            scoreYes = currWordScore + maxScore(words, scores, freqArray,idx+1);
        }

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            freqArray[ch-'a']++;
        }

        return Math.max(scoreNo, scoreYes);
    }


    public static void main(String[] args) {
//--------------------Q1-------------------------------------------------------------------------
        System.out.println("------Q1-------------------------------------------");
        printAbbreviations("pep", 0, 0, "");

//--------------------Q2-------------------------------------------------------------------------
        System.out.println("------Q2-------------------------------------------");
        // num of diags in a mat = 2n+1
        int n = 4;
        boolean[] cols = new boolean[n];
        boolean[] incDiags = new boolean[2*n - 1];
        boolean[] decDiags = new boolean[2*n - 1];
        boolean[][] board = new boolean[n][n];

        nQueens(board, n, 0, "", cols, incDiags, decDiags);

//--------------------Q3-------------------------------------------------------------------------
        System.out.println("------Q3-------------------------------------------");
        String[] words = {"dog", "cat", "dad", "good"};
        String allowedChars = "abcdddgoo";
        int[] freqArray = new int[26];
        for(int i=0; i<allowedChars.length(); i++){
            char ch = allowedChars.charAt(i);
            freqArray[ch - 'a']++;
        }
        int[] scores = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int res3 = maxScore(words, scores,freqArray, 0);
        System.out.println(res3);
    }
}
