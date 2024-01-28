Q1.
public class MoveZerosToEnd {

    public static void moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int nonZeroIndex = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap non-zero element with the first zero encountered
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;

                // Move the nonZeroIndex to the next position
                nonZeroIndex++;
            }
        }
    }
Q2. class Solution {
    public int longestPalindromeSubseq(String s) {
        // it is same as LCS problem just reverse the string and implement all the thing same as lcs
        //Reverse String
        StringBuilder strb = new StringBuilder(s);
        String str=strb.reverse().toString();

        int n=s.length();
        int m=str.length();
        int dp[][]=new int[n+1][m+1];
        
        //base case
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1)==str.charAt(j-1))  dp[i][j]=1+dp[i-1][j-1];

                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
Q3.class Solution {
    public int longestPalindromeSubseq(String s) {
        // it is same as LCS problem just reverse the string and implement all the thing same as lcs
        //Reverse String
        StringBuilder strb = new StringBuilder(s);
        String str=strb.reverse().toString();

        int n=s.length();
        int m=str.length();
        int dp[][]=new int[n+1][m+1];
        
        //base case
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1)==str.charAt(j-1))  dp[i][j]=1+dp[i-1][j-1];

                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
Q4.public class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quicksort(nums, low, pi - 1);
            quicksort(nums, pi + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
            if (nums[j] < pivot) swap(nums, ++i, j);
        swap(nums, ++i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
Q5.class Solution{
    public int[] twoSum(int[] nums, int target){
       
    //we have to solve two sum problems using complment idea
      Map<Integer,Integer> map =  new HashMap<>();
       int n = nums.length;

       for(int i = 0; i < n; i++){
           int complement =  target-nums[i];
           if(map.containsKey(complement)){
               return new int[] {map.get(complement),i};
           }
           map.put(nums[i], i);
       }
       return new int[] {};
    }
}
Q6.class Solution {
    public List<Integer> rightSideView(TreeNode root) {
// this is striver solution using recursion same u can do for left view of binary tree just comment right and do for left
  List<Integer> result =  new ArrayList<Integer>();
      rightView(root,result,0);
      return result;
    }
public void rightView(TreeNode curr ,List<Integer> result, int currDepth){
    if(curr == null){
        return;
    }
    if(currDepth == result.size()){
        result.add(curr.val);
    }
    rightView(curr.right, result,currDepth + 1);
    //rightView(curr.left, result,currDepth + 1);
  }
}
Q7.


class Solution {

    public ListNode reverseList(ListNode head) {
    
    ListNode current =   head;
    ListNode previous =  null;

    while(current != null){
        ListNode nextNode = current.next;
        current.next = previous;
        previous = current;
        current = nextNode;
    }
    return previous;
    }
}
Q8.class Solution {
    public int search(int[] nums, int target) {
       int start = 0;
       int end =  nums.length-1;

       while(start <= end){
           int mid = start + (end - start ) / 2;

           if(nums[mid] == target){
                return mid;
           }
           else if(nums[mid] < target){
               start = mid + 1;
           }
           else
           {
           end = mid-1;
           }
        }
        return -1;
    }
}
Q9.
class Solution {
  public int findNumberOfLIS(int[] nums) {
    final int n = nums.length;
    int ans = 0;
    int maxLength = 0;
    // length[i] := the length of the LIS ending in nums[i]
    int[] length = new int[n];
    // count[i] := the number of LIS's ending in nums[i]
    int[] count = new int[n];

    Arrays.fill(length, 1);
    Arrays.fill(count, 1);

    // Calculate the `length` and `count` arrays.
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < i; ++j)
        if (nums[j] < nums[i])
          if (length[i] < length[j] + 1) {
            length[i] = length[j] + 1;
            count[i] = count[j];
          } else if (length[i] == length[j] + 1) {
            count[i] += count[j];
          }

    // Get the number of LIS.
    for (int i = 0; i < n; ++i)
      if (length[i] > maxLength) {
        maxLength = length[i];
        ans = count[i];
      } else if (length[i] == maxLength) {
        ans += count[i];
      }

    return ans;
  }
}
Q10.class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
       int dp[][] = new int[k + 1][prices.length];
		for (int i = 1; i < dp.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < dp[0].length; j++) {
				maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
			}
		}
		return dp[k][prices.length - 1];
    }
}





