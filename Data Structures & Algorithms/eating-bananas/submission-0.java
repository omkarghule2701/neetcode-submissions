class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min =1;
        int max=0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int ans= Integer.MAX_VALUE;

        while (min <= max) {
            int mid = max + (min - max) / 2;

            

            int hours = calculate(piles, mid);

            if (hours <= h) {
                ans = mid;
                max = mid - 1; // try slower speed
            } else {
                min = mid + 1; // need faster speed
            }


        }

        return ans;
        
    }

    private int calculate (int[] piles, int h) {

        int ans = 0;

        for (int i : piles) {

            int temp = i/h;

            if ((i % h) != 0) {
                temp++;
            }

            ans += temp;

        }
        return ans;
    }
}