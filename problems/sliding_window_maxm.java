class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length , i = 0 , j = 0  , it , l = 0 , r = i+k-1 , comp=0,prev=0;
        List <Integer> ans = new ArrayList<>() ;
        TreeSet <Integer> hs = new TreeSet<>() ;
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        
        for(i=0;i<k;i++) {
            hs.add(nums[i]) ;
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i],hm.get(nums[i])+1) ;
            }
            else {
                hm.put(nums[i],1) ;
            }
        }
        ans.add(hs.last()) ;
        
        for(i=k;i<n;i++) {
            hm.put(nums[prev],hm.get(nums[prev])-1) ;
            if(hm.get(nums[prev])==0) {
                hm.remove(nums[prev]) ;
                hs.remove(nums[prev]) ;
            }
            hs.add(nums[i]) ;
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i],hm.get(nums[i])+1) ;
            }
            else {
                hm.put(nums[i],1) ;
            }
            ans.add(hs.last()) ;
            prev++;
        }
        
        int[] ans2 = new int[ans.size()] ;
        for(i=0;i<ans.size();i++) {
            ans2[i] = ans.get(i) ;
        }
        return  ans2;
    }
}