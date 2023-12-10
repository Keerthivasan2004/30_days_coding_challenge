/*Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1*/

Solution:

class Solution 
{
public int firstMissingPositive(int[] nums) 
{
    int n = nums.length;
    for (int i = 0; i < n; i++) 
    {
        if (nums[i] <= 0 || nums[i] > n) 
        {
            nums[i] = n + 1;
        }
    }
    for (int i = 0; i < n; i++) 
    {
        int num = Math.abs(nums[i]);
        if (num > n) 
        {
            continue;
        }
        num--; 
        if (nums[num] > 0)
        { 
            nums[num] = -1 * nums[num];
        }
    }
    for (int i = 0; i < n; i++) 
    {
        if (nums[i] >= 0) 
        {
            return i + 1;
        }
    }
    return n + 1;
}
}