package CrackCoding.package8_3;

/**
 * Created by liyuan on 2017/7/18.
 */
/**描述如何只用一个数组来实现3个栈*/
public class Solution3_1 {
    int stackSize = 100;
    int[] buffer = new int[stackSize*3];
    int[] stackPointer = {-1,-1,-1};   //用来追踪栈顶元素。

    void push(int stackNum, int value) throws Exception {
        if (stackPointer[stackNum] + 1>=stackSize)
            throw new Exception("Out of space");
        else{
            stackPointer[stackNum] += 1;
            buffer[stackPointer[stackNum]] = value;

        }
    }

    int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1)
            throw new Exception("Trying to pop an empty stack");
        else {
            int item = buffer[absTopOfStack(stackNum)];
            buffer[absTopOfStack(stackNum)]=0;
            stackPointer[stackNum]--;
            return item;
        }
    }


    int peek(int stackNum){
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    boolean isEmpty(int stackNum){
        return stackPointer[stackNum] == -1;
    }
    //返回栈“stackNum”栈顶元素的索引，绝对量
    int absTopOfStack(int stackNum){
        return stackNum*stackSize + stackPointer[stackNum];
    }
}
