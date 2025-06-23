class Solution {
    String minSum(int[] arr) {
        // code here
        int freq[]=new int[10];
        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> second=new ArrayList<>();
        boolean flag=true;
        for(int i=1;i<10;i++)
        {
            while(freq[i]-->0)
            {
                if(flag)
                    first.add(i);
                else
                    second.add(i);
                    flag=!flag;
            }
        }
        return sum(first,second);
    }
    public static String sum(ArrayList<Integer> first, ArrayList<Integer> second)
    {
        StringBuilder string=new StringBuilder();
        int sum=0,carrysum=0;
        int m=first.size()-1;
        int n=second.size()-1;
        while((m>=0) && (n>=0))
        {
            sum=first.get(m--)+second.get(n--)+carrysum;
            if(sum>9)
            {
                carrysum=1;
                sum-=10;
            }
            else
            {
                carrysum=0;
            }
            string.append(sum);
        }
        if(m==0)
        {
            sum=first.get(0)+carrysum;
            if(sum>9)
            {
                carrysum=1;
                sum-=10;
            }
            else
            {
                carrysum=0;
            }
            string.append(sum);
        }
        if(n==0)
        {
            sum=second.get(0)+carrysum;
            if(sum>9)
            {
                carrysum=1;
                sum-=10;
            }
            else
            {
                carrysum=0;
            }
            string.append(sum);
        }
        if(carrysum>0)
        {
            string.append(carrysum);
        }
        string.reverse();
        return string.toString();
    }
}
