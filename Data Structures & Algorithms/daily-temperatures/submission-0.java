class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<int[]> st= new Stack<int[]>();
        int len = temperatures.length;
        int[] ans = new int[len];
        int i = len-1;

        while(i>=0) {

            
            while (!st.isEmpty() && st.peek()[0] <= temperatures[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                ans[i]=0;
                int[] temp = new int[2];
                temp[0]= temperatures[i];
                temp[1]= i;
                st.push(temp);
            }
            else {
                ans[i]=st.peek()[1]-i;
                int[] temp = new int[2];
                temp[0]= temperatures[i];
                temp[1]= i;
                st.push(temp);
                
            }
            i--;


        }
        return ans;
        
    }
}