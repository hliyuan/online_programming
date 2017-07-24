package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/6.
 */
/**
 * 给定一副由N*N矩阵表示的图像，其中每个像素的大小为4字节，编写一个方法，将图像旋转90度。不占用额外内存空间是否能做到。
 * */
public class Solution1_6 {

    public static int[][] rotate(int[][] matrix, int n){

        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer -1;

            for (int i = first; i < last; i++) {
                int offset = i -first;

                //存储上边
                int top =matrix[first][i];

                //左到上
                matrix[first][i] = matrix[last-offset][first];

                //下到左
                matrix[last-offset][first] = matrix[last][last-offset];

                //右到下
                matrix[last][last-offset] = matrix[i][last];

                //上到右
                matrix[i][last] = top;


            }


        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rotate = rotate(matrix,3);
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                System.out.print(rotate[i][j]);
            }
            System.out.println();
        }
    }
}
