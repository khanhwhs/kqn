/**
 * MedianOfArray
 */

 import java.util.*;
public class MedianOfArray {
    // private class minNode implements Comparable<minNode>{

    // }

    public static void main(String[] args) {
        int [] arr = {3, 5, 7, 12, 13, 14, 21, 23, 23, 23, 23, 29, 40, 56};

        int [] a = {1,3,6,7};
        int [] b = {2,4 ,5};

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());;

        int midVal = arr[arr.length/2];
        int median = 0;

        for(int i : arr){
            if(i<midVal) maxHeap.add(i);
            else minHeap.add(i);
        }

        while((minHeap.size() - maxHeap.size()) > 1){
            maxHeap.add(minHeap.poll());
        }
        while((maxHeap.size() - minHeap.size()) > 1){
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size() == minHeap.size()) median  = (maxHeap.poll() + minHeap.poll())/2;
        else if (maxHeap.size() > minHeap.size()) median = maxHeap.poll();
        else median = minHeap.poll();

        System.out.println(findKth(4,a,b,0,0));

        // findKth


    }

    public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
        if(s1>=nums1.length){
            return nums2[s2+k-1];
        }
     
        if(s2>=nums2.length)
            return nums1[s1+k-1];
     
        if(k==1)
            return Math.min(nums1[s1], nums2[s2]);
     
        int m1 = s1+k/2-1;
        int m2 = s2+k/2-1;
     
        int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
        int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

        System.out.println("m1 : " + m1 + " -- m2: "+ m2 + " -------- mid1:" + mid1 + " -- mid2:" + mid2);
     
        if(mid1<mid2){
            return findKth(k-k/2, nums1, nums2, m1+1, s2);
        }else{
            return findKth(k-k/2, nums1, nums2, s1, m2+1);
        }
    }
    
}

// mid = 23

// minHeap = 23 23 23 23 29 39 40 56

// maxHeap = 21 14 13 12 7 5 3