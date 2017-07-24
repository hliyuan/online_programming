package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/7.
 */

/**
 * 编写一个算法，若M*N矩阵中某个元素为0，则将其所在的行与列清零。
 * */
public class Solution1_7 {

    
    /*
    * 方法一
    * 定义matrix[][]二维数组。
    * 定义一个新数组newMatrix[][]，将原数组的值依次赋值给新数组。
    * 注意:不可使用newMatrix = matrix因为数组的存储，赋值指向的是数组的引用（即matrix和newMatrix指向一个同一个地址）所以，一旦newMatrix改变，matrix也会改变。
    * */
    public static int[][] clear1(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("matrix["+i+","+j+"]"+matrix[i][j]);
                if (matrix[i][j]==0){
                    for (int x = 0; x < newMatrix[i].length; x++) {
                        newMatrix[i][x] = 0;
                    }
                    for (int y = 0; y < newMatrix.length; y++) {
                        newMatrix[y][j] = 0;
                    }
                }
            }
        }
        return newMatrix;
    }

    /*
    * 方法二：
    * 记录0元素所在的行和列，然后将0元素的所在的行和列都变为0.
    * */
    public static int[][] clear2(int[][] matrix){

        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //记录值为0的元素所在的行索引和列索引
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i]||column[j])
                    matrix[i][j] = 0;

            }
        }

        return matrix;

    }



    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,0},{4,5,6,7},{0,1,2,3}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("the result of clear");
        int[][] newMatrix1 = clear1(matrix);

        int[][] newMatrix2 = clear2(matrix);

        for (int i = 0; i < newMatrix1.length; i++) {
            for (int j = 0; j < newMatrix1[i].length; j++) {
                System.out.print(newMatrix1[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < newMatrix2.length; i++) {
            for (int j = 0; j < newMatrix2[i].length; j++) {
                System.out.print(newMatrix2[i][j]);
            }
            System.out.println();
        }



    }
}
