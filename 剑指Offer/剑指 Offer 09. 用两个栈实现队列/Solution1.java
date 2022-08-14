// 时间复杂度O(1)，入队和出队的时间复杂度均为O(1)，因为每个元素至多入栈出栈各两次
// 空间复杂度O(n)

import java.util.Stack;

class CQueue {

    Stack<Integer> enStack;
    Stack<Integer> deStack;

    public CQueue() {
        enStack = new Stack<>();
        deStack = new Stack<>();
    }

    public void appendTail(int value) {
        enStack.push(value);
    }

    public int deleteHead() {
        if (!deStack.empty()) {
            return deStack.pop();
        } else if (!enStack.empty()) {
            while (!enStack.empty()) {
                deStack.push(enStack.pop());
            }
            return deStack.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */