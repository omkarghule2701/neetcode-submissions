class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int end = (rows * columns) -1;

        while (start <= end) {
            int mid = end + (start - end) / 2;

            int row = mid/columns;
            int col = mid%columns;

            int element = matrix [row][col];

            if (element == target) {
                return true;
            }
            else {
                if (element < target) {
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }
        }


        return false;
    }
}