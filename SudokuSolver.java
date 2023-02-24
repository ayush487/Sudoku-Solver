public class SudokuSolver
{
    public static void main(String[] args) {
        System.out.println("Sudoku Solver");

        int[][] sudoku = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
         };
        
/* 
        int[][] sudoku = {
                            {3, 0, 0, 8, 0, 1, 0, 0, 2},
                            {2, 0, 1, 0, 3, 0, 6, 0, 4},
                            {0, 0, 0, 2, 0, 4, 0, 0, 0},
                            {8, 0, 9, 0, 0, 0, 1, 0, 6},
                            {0, 6, 0, 0, 0, 0, 0, 5, 0},
                            {7, 0, 2, 0, 0, 0, 4, 0, 9},
                            {0, 0, 0, 5, 0, 9, 0, 0, 0},
                            {9, 0, 4, 0, 8, 0, 7, 0, 5},
                            {6, 0, 0, 1, 0, 7, 0, 0, 3}
                         };
 */
        SudokuSolver solver = new SudokuSolver();
        boolean isSolved = solver.solve(sudoku, 9, 0, 0);
        solver.print(sudoku, 9);

        System.out.println("Sudoku solved : "+ isSolved);

    }


    boolean solve(int[][] board,int n, int row, int col){
        if(row==n-1 && col==n){
            return true;
        }
        if(col==n){
            row++;
            col = 0;
        }

        if(board[row][col]!=0){
            return solve(board, n, row, col+1);
        }

        
        for(int num=1;num<=n;num++){
            if(isSafe(board, n, num, row, col)){
                board[row][col] = num;
                if(solve(board, n, row, col+1)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        
        return false;
    }

    boolean isSafe(int[][] board,int n, int num, int row, int col){

        //check horizontal
        for(int i=0;i<n;i++){
            if(board[row][i]==num && i!=col){
                return false;
            }
        }

        //check vertically
        for(int j=0;j<n;j++){
            if(board[j][col]==num && j!=row){
                return false;
            }
        }

        //check in boxes
        if(row<3 && col<3){
            for(int a=0;a<3;a++){
                for(int b=0;b<3;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row<3 && col>=3 && col<6){
            for(int a=0;a<3;a++){
                for(int b=3;b<6;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row<3 && col>=6){
            for(int a=0;a<3;a++){
                for(int b=6;b<9;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=3 && row<6 && col<3){
            for(int a=3;a<6;a++){
                for(int b=0;b<3;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=3 && row<6 && col>=3 && col<6){
            for(int a=3;a<6;a++){
                for(int b=3;b<6;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=3 && row<6 && col>=6 ){
            for(int a=3;a<6;a++){
                for(int b=6;b<9;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=6 && col<3){
            for(int a=6;a<9;a++){
                for(int b=0;b<3;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=6 && col>=3 && col<6){
            for(int a=6;a<9;a++){
                for(int b=3;b<6;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
        if(row>=6 && col>=6){
            for(int a=6;a<9;a++){
                for(int b=6;b<9;b++){
                    if(board[a][b]==num && (a!=row || b!=col)){
                        return false;
                    }
                }
            }
        }
    
        return true;
    }

    void print(int[][] board, int n){
        for(int i=0;i<n;i++){
            System.out.println(" - - - - - - - - - - - - - - - - - - -");
            for(int j=0;j<n;j++){
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" | ");
            
        }
        System.out.println(" - - - - - - - - - - - - - - - - - - -");
    }
}