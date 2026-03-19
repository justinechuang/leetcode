//215. Kth Largest Element in an Array (Medium)
/*
1.) create an empty min heap
2.) Iterate through each number:
	- Push the number into the min-heap
	- If the heap size exceeds k, pop the smallest element
3.) after processing all the numbers, the top of the heap is the kth largest element
4.) that number is returned.
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

//Note: the easy ass solution is to sort the array and return the number thats at array.length - k index.. 
//the above is the non-sorting answer 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}


/*
Example:
nums = [3, 2, 1, 5, 6, 4]
k = 2


minHeap = []

Iteration 1:
num = 3
offer(3)

Heap: [3]


Iteration 2:
num = 2
offer(2)

Heap: [2, 3]  
size <= k (do nothing)


Iteration 3:
num = 1
offer(1)

[1, 3, 2], size > k -> remove smallest (1)

Heap: [2, 3]


Iteration 4:
num = 5
offer(5)

[2, 3, 5], size > k -> removes smallest (2)

Heap: [3, 5]


Iteration 5:
num = 6
offer(6)

[3, 5, 6], size > k -> removes smallest (3)

Heap: [5, 6]

Iteration 6:
num = 4
offer(4)

[4, 6, 5], size > k -> removes smallest

Heap: [5, 6]

---> return minHeap.peek() (which is 5)

*/