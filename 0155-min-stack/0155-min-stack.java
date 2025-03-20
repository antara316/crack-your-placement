import java.util.Stack;

class MinStack {
    private Stack<Long> stack;
    private long minVal;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(long val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minVal = val;
        } else if (val < minVal) {
            stack.push(2 * val - minVal);
            minVal = val;
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        long poppedVal = stack.pop();
        if (poppedVal < minVal) {
            minVal = 2 * minVal - poppedVal;
        }
    }

    public long top() {
        long peekVal = stack.peek();
        return (peekVal < minVal) ? minVal : peekVal;
    }

    public long getMin() {
        return minVal;
    }
}