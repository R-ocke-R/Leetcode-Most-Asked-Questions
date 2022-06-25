/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s=1;int e=n;
        int mid=s+((e-s)/2);
        int ans=1;
        while(s<=e){
            boolean a=isBadVersion(mid);
            if (a){
                e=mid-1;
                ans=mid;
            }
            else{
                s=mid+1;
            }
            mid=s+((e-s)/2);
        }
        return ans;
        
    }
}