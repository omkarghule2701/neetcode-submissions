class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> q= new LinkedList<>();

        for (int i=0; i<rows; i++) {
            if (board[i][0]== 'O') {
                board[i][0] = 'S';
                q.offer (new int[] {i, 0} );
            }

            if (board[i][cols-1]== 'O') {
                board[i][cols-1] = 'S';
                q.offer (new int[] {i, cols-1} );
            }
        }

        for (int i=0; i<cols; i++) {
            if (board[0][i]== 'O') {
                board[0][i] = 'S';
                q.offer (new int[] {0, i} );
            }

            if (board[rows-1][i]== 'O') {
                board[rows-1][i] = 'S';
                q.offer (new int[] {rows -1, i} );
            }
        }   

        bfs (board, q, rows, cols);

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (board[i][j] == 'S') {
                    board[i][j]='O';
                }
                else {
                    board[i][j]='X';
                }
            }
        } 

        
    }

    private void bfs (char[][] board, Queue<int[]> q, int rows, int cols) {
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int first = cell[0];
            int second = cell [1];

            for (int[] dir : directions) {
                
                int newR = first + dir[0];
                int newC = second + dir[1];

                if (newR < 0 || newC <0 || newR >= rows || newC >= cols) {
                    continue;
                }

                if (board[newR][newC] == 'X' || board[newR][newC] == 'S') {
                    continue;
                }

                board[newR][newC] = 'S';
                q.offer (new int[] {newR, newC} );

            }
        }
    }
}