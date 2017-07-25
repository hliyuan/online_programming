package main.java.CrackCoding.package8_3;

/**
 * Created by lenovo on 2017/7/24.
 */

import java.util.Stack;

/**在经典问题汉诺塔中，有3根柱子及N个不同大小的穿孔圆盘，盘子可以划入任意一根柱子。
 * 一开始，所有盘子自底向上从大到小依次套在第一根柱子上（即每个盘子只能放在更大的盘子上面）。
 * 移动圆盘时，有以下限制：
 * 1）每次只能移动一个盘子；
 * 2）盘子只能从柱子顶端滑出移到下一根柱子；
 * 3）盘子只能叠在比它大的盘子上。
 * 请运用栈，编写程序将所有的盘子从第一根柱子移到最后一根柱子。*/
public class Solution3_4 {

    public class Tower{
        private Stack<Integer> disks;
        private Integer index;

        public Tower(int i){
            disks = new Stack<Integer>();
            index = i;
        }

        public int index(){
            return index;
        }
        public void add(int d){
            if (!disks.isEmpty()&&disks.peek()<=d){
                System.out.println("Error placing disk" + d );
            }else {
                disks.push(d);
            }
        }

        public void moveTopto(Tower t){
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk" + top + "from" +index()+"to"+t.index());

        }

        public void moveDisks(int n,Tower destination,Tower buffer){
            if (n > 0){
                moveDisks(n-1,buffer,destination);
                moveTopto(destination);
                buffer.moveDisks(n-1,destination,this);

            }
        }


    }


    public  void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);

        }
        for (int i = n-1; i >=0 ; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n,towers[2],towers[1]);
    }
}
