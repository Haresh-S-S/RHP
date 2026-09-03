class MinStack {
    Stack <Integer> min;
    Stack <Integer> ts;
    int mini = Integer.MAX_VALUE, secmini = Integer.MAX_VALUE;
    public MinStack() {
        min = new Stack <Integer> ();
        ts = new Stack <Integer> ();
    }
    
    public void push(int value) {
        if(min.isEmpty())
        {
            ts.push(value);
        }
        else{
            if(value < ts.peek())
            {
                ts.push(value);
            }
            else{
                ts.push(ts.peek());
            }
        }
        min.push(value);
        // mini = Math.min(mini, value);
        // // if(value > mini && value < secmini) secmini = value;
        // ts.push(mini);
        // else if(value > mini && value < secmini)
        // {
        //     secmini = value;
        // }
    }
    
    public void pop() {
        // if(ts.peek() == min.peek()) 
        // {
        ts.pop();
        min.pop();

    }
    
    public int top() {
        return min.peek();
    }
    
    public int getMin() {
        // if(min.contains(mini)) return mini;
        // else return secmini;
        return ts.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
