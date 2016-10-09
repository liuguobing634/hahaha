package lew.bing.math;

/**
 * Created by Y on 2016/10/8.
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //两次循环，第一次判断奇数
        String str = "";
        for (int i = 0;i < s.length();i++) {
            String s2 = palindrome(s,i,i,0);
            if (s2.length() > str.length()){
                str = s2;
            }
        }
        for (int i = 0;i < s.length()-1;i++) {
            String s2 = palindrome(s,i,i+1,0);
            if (s2.length() > str.length()){
                str = s2;
            }
        }
        return str;
    }

    private String palindrome(String s,int lmid,int rmid,int len) {
        int length = s.length();
        if (lmid - len < 0 || rmid + len >=length) {
           return s.substring(lmid-len + 1, rmid + len);
        }
        char l = s.charAt(lmid - len);
        char r = s.charAt(rmid + len);
        if (l == r) {
            return palindrome(s,lmid,rmid,len + 1);
        }else {
            return s.substring(lmid-len + 1, rmid + len);
        }
    }

    public String convert(String s, int numRows) {
        if (numRows < 2 || s == null || s.length() <= numRows) {
            return s;
        }
        int j = 0;
        int k = 1;
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int i = 0;i < s.length();i ++ ) {
            if (strs[j] == null){
                strs[j] = new StringBuilder();
            }
            strs[j].append(s.charAt(i));
            j += k;
            if (j == numRows) {
                j = numRows - 2;
                k = -1;
            }
            if (j == -1) {
                j = 1;
                k = 1;
            }
        }
        s = "";
        for (int i = 0;i < numRows;i++) {
            System.out.println(strs[i]);
            s += strs[i].toString();
        }
        return s;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            // if (x != Integer.MIN_VALUE) {
            //     return isPalindrome(-x);
            // }else {
            //     return false;
            // }
            return false;
        }
        if (x < 10) {
            return true;
        }
        int j = 10;
        for (;x / j >= 10;j *= 10) ;
        System.out.println(j);
        while (x >= 10) {
            if (x / j == x % 10 ) {
                x = (x % j) / 10;
                j = j / 100;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abcdcbdgbac"));
        System.out.println(new Solution().convert("abc",2));
        System.out.println(new Solution().isPalindrome(1001));
    }

}
