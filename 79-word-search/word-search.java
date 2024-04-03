class Solution {
    public boolean inBound(char[][] board, int i, int j){
        // checks if the move is still in boundary 
        int n = board.length;
        int m = board[0].length;
        if( 0 <= i && i < n && 0 <= j && j < m) return true;
        return false;
    }
    public boolean backTrackbetter(char[][] board, String word, int i , int j , int wordIndex){
        if(wordIndex == word.length()) return true;

        board[i][j] = '#';
        if((inBound(board, i+1, j) && board[i+1][j] == word.charAt(wordIndex) && backTrackbetter(board, word, i+1, j, wordIndex+1)) ||
            (inBound(board, i-1, j) && board[i-1][j] == word.charAt(wordIndex) && backTrackbetter(board, word, i-1, j, wordIndex+1)) ||
            (inBound(board, i, j-1) && board[i][j-1] == word.charAt(wordIndex) && backTrackbetter(board, word, i, j-1, wordIndex+1)) ||
            (inBound(board, i, j+1) && board[i][j+1] == word.charAt(wordIndex) && backTrackbetter(board, word, i, j+1, wordIndex+1))) return true;
        board[i][j] = word.charAt(wordIndex-1);
        return false;
    }
    public boolean backTrack(char[][] board, String word, int i , int j, int wordIndex){
        // base case: word found.
        if(wordIndex == word.length()) return true;
        // find we the char at wordIndex can be found by moving down
        if(inBound(board, i+1, j) && board[i+1][j] == word.charAt(wordIndex)){
            // make the move
            board[i+1][j] ='#';
            if(backTrack(board, word, i+1, j, wordIndex+1)) return true;
            board[i+1][j] = word.charAt(wordIndex);
        }
        // find we the char at wordIndex can be found by moving up
        if(inBound(board, i-1, j) && board[i-1][j] == word.charAt(wordIndex)){
            // make the move
            board[i-1][j] ='#';
            if(backTrack(board, word, i-1, j, wordIndex+1)) return true;
            board[i-1][j] = word.charAt(wordIndex);
        }
        // find we the char at wordIndex can be found by moving left
        if(inBound(board, i, j-1) && board[i][j-1] == word.charAt(wordIndex)){
            // make the move
            board[i][j-1] ='#';
            if(backTrack(board, word, i, j-1, wordIndex+1)) return true;
            board[i][j-1] = word.charAt(wordIndex);
        }
        // find we the char at wordIndex can be found by moving right
        if(inBound(board, i, j+1) && board[i][j+1] == word.charAt(wordIndex)){
            // make the move
            board[i][j+1] ='#';
            if(backTrack(board, word, i, j+1, wordIndex+1)) return true;
            board[i][j+1] = word.charAt(wordIndex);
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;



        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                char ch = board[i][j];
                // if this element at i, j is the first char of word then we call if word can be formed here.
            
                // calling the backtrack1 function

                // if(ch == word.charAt(0)) {
                //     board[i][j]='#';
                //     if(backTrack(board, word, i, j, 1)) return true;
                //     board[i][j] =word.charAt(0);
                // }
                // else continue to find other occurances of 1st character.


                // calling the better function
                if( ch == word.charAt(0) && backTrackbetter(board, word, i, j, 1)) return true;
            }
        }
        return false;
    }
}