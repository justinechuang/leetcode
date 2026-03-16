//36. Valid Sudoku (Medium)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(row.contains(board[i][j])){
                        return false;
                    }
                }
                row.add(board[i][j]);
                if(board[j][i] != '.'){
                    if(col.contains(board[j][i])){
                        return false;
                    }
                }
                col.add(board[j][i]);
                int r = (i / 3) * 3 + j / 3;			//figuring out this calculation
                int c = (i % 3) * 3 + j % 3;			//is probably the hardest part of the whole problem
                if(board[r][c] != '.'){
                    if(box.contains(board[r][c])){
                        return false; 
                    }
                }
                box.add(board[r][c]);
            }
        }
        return true; 
    }
}