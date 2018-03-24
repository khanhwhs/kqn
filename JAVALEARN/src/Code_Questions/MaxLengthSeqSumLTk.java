package Code_Questions;

public class MaxLengthSeqSumLTk {
	
	// Returns length of biggest subarray with sum less than x.
	// If there is no subarray with given sum, then returns n+1
	int smallestSubWithSum(int arr[], int n, int x) 
	{
		// Initialize current sum and minimum length
		int curr_sum = 0, max_len = 0;
		

		// Initialize starting and ending indexes
		int start = 0, end = 0;
		while (end < n) 
		{
			// Keep adding array elements while current sum
			// is smaller than x
			while (curr_sum <= x && end < n){
				if ((end - start > max_len) && (curr_sum < x))
					max_len = end - start;
				
				curr_sum = curr_sum + arr[end];
				System.out.println("Current Sum: and end2 is "+ curr_sum + "  "+end);
				end++;
				
			// Update minimum length if needed
				
				
				
					
			}
			System.out.println("Current Sum: and end is "+ curr_sum + "  "+end);
			// If current sum becomes greater than x.
			while (curr_sum > x && start < n) 
			{
				// remove starting elements
				curr_sum = curr_sum - arr[start++];
				System.out.println("Current Sum after - start:"+ curr_sum);
			}
		}
		return (max_len );
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		MaxLengthSeqSumLTk array_sum = new MaxLengthSeqSumLTk();
		int arr1[] = {1,3,4,2,5,13,7,9};
		int x = 15;
		int n1 = arr1.length;
		System.out.println("FINAL max_sub is " + array_sum.smallestSubWithSum(arr1, n1, x));
	}
}
