package lew.bing.math;

/**
 * Created by Y on 2016/10/7.
 */
public class Median {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        //第一次，傻瓜式比较
        int len = nums1.length+nums2.length;
        //依次比较两个nums
        int index1 = 0;
        int index2 = 0;
        if (len % 2 == 0) {
            //偶数个时
            int now1 = 0;
            int now2 = 0;
            while (index1 + index2 <= len / 2 ) {
                now1 = now2;
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        now2 = nums1[index1];
                        index1 ++;
                    }else {
                        now2 = nums2[index2];
                        index2 ++;
                    }
                }else if (index1 < nums1.length){
                    now2 = nums1[index1];
                    index1 ++;
                }else {
                    now2 = nums2[index2];
                    index2 ++;
                }
            }
            return ((double)(now1 + now2)) / 2;
        }else {
            //奇数个时
            int now = 0;
            while (index1 + index2 <= len / 2 ) {
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        now = nums1[index1];
                        index1 ++;
                    }else {
                        now = nums2[index2];
                        index2 ++;
                    }
                }else if (index1 < nums1.length){
                    now = nums1[index1];
                    index1 ++;
                }else {
                    now = nums2[index2];
                    index2 ++;
                }

            }
            return now;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //先取第一个数组的中间值跟第二个的数组每个数进行比较
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 < len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        if (len2 == 0) {
            return ((double) (nums1[(len1 - 1) / 2] + nums1[len1 / 2])) / 2;
        }
        //找出两个数，其中一个一半的数比它大，另一个一半的数比它小
        int lo = 0;
        int m1 = len2 * 2;
        while (lo <= m1) {
            //取一半
            int mid2 = (lo + m1) / 2;
            int mid1 = len1 + len2 - mid2;

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE:nums1[(mid1-1)/2];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE:nums2[(mid2-1)/2];
            double r1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE:nums1[mid1/2];
            double r2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE:nums2[mid2/2];
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(r1);
            System.out.println(r2);

            if (l1 > r2) lo = mid2 + 1;
            else if (l2 > r1) m1 = mid2 - 1;
            else return (max(l1,l2)+min(r1,r2)) / 2;
        }
        return 0.0;
    }

    private double max(double num1,double num2) {
        return num1>num2 ? num1:num2;
    }

    private double min(double num1,double num2) {
        return num1<num2 ? num1:num2;
    }

    public static void main(String[] args) {
        System.out.println(new Median().findMedianSortedArrays(new int[]{1},new int[]{2,3}));
    }



}
