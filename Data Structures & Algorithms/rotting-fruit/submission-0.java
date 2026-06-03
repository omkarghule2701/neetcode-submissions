class Solution {
    public int orangesRotting(int[][] grid) {


        int rows = grid.length;
        int col = grid[0].length;
        int count = 0;
        int ans = 0;
        int[][] direction = new int[][] {{0,-1}, {0,1}, {-1,0},{1,0}};

        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j]==2) {
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    q.offer(temp);
                }
                if (grid[i][j]==1) {
                    count++;
                }
            }
        }



        while(!q.isEmpty()) {
            
            int qsize = q.size();
            boolean spread = false;  

            for (int j=0; j< qsize; j++){
                int[] temp = q.poll();
                for (int i=0; i<4; i++) {
                    int dir1 = direction[i][0] + temp[0];
                    int dir2 = direction[i][1] + temp[1];

                    if (dir1 < 0 || dir1 >=rows || dir2<0 || dir2 >= col){
                        continue;
                    }

                    if (grid[dir1][dir2] == 1) {
                        grid[dir1][dir2] = 2;
                        int[] temp2 = new int[2];
                        temp2[0] = dir1;
                        temp2[1] = dir2;
                        q.offer(temp2);
                        count--;
                        spread = true;
                    }
                }
            }

            if (spread) ans++;       

        }

        if(count ==0){
            return ans;
        }
        else {
            return -1;
        }
        
    }
}