class NumMatrix {

    int [][] dp;

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            int sum = 0;
            
            for(int j=0;j<matrix[0].length;j++) {
                sum += matrix[i][j];
                dp[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0 || row2 >= dp.length || col1 < 0 || col2 >= dp[0].length) {
            return -1;
        }
        
        int sum = 0;
        for(int i = row1;i<=row2;i++) {
            sum += dp[i][col2] - (col1 > 0 ? dp[i][col1 - 1] : 0);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */