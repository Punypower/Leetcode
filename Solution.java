package diagonal;

/**
 * 给你一个大小为 m x n 的矩阵 mat
 * 请以对角线遍历的顺序
 * 用一个数组返回这个矩阵中的所有元素。
 */
class Solution {

    public static int[] findDiagonalOrder(int[][] matrix) {

        // 检查健壮性,如果是空或者是一维数组,直接返回
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // 获得二位数组的行数和列数
        int N = matrix.length;
        int M = matrix[0].length;

        // 行数和列数的下标初始化
        int row = 0, column = 0;

        // 用来判断是向上的对角线还是向下的对角线 1上 0下
        int diagonal = 1;

        // 创建一个N*M的数组用来接收最后的结果
        int[] result = new int[N*M];
        int r = 0;

        /* 主要算法部分

         */
        while (row < N && column < M) {

            // 先将第一行第一个的元素加载至数组
            result[r++] = matrix[row][column];

            // 沿着对角线移动,根据对角线向上还是向下 向上则行减一 列加一 向下则行加一 列减一
            int new_row = row + (diagonal == 1 ? -1 : 1);
            int new_column = column + (diagonal == 1 ? 1 : -1);

            //检查对角线的下一个元素是否在边界范围内.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // 对角线向上.
                if (diagonal == 1) {

                    // 向上对角线,若是在边界上,列数达到了最大值,则给行加一
                    row += (column == M - 1 ? 1 : 0) ;

                    column += (column < M - 1 ? 1 : 0);
                //对角线向下
                } else {

                    //向下对角线,若是在边界上,行数达到了最大值,列数加一
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // 反转对角线
                diagonal = 1 - diagonal;

            } else {
                //不在边界上,正常移动
                row = new_row;
                column = new_column;
            }
        }
        return result;
    }
}

