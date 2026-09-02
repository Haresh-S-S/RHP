import java.util.*;
public class 3Sum {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        List <List <Integer>> res = threeSum(arr);
        for(int i = 0; i < res.size(); i++){
            LinkedList <Integer> li = res.get(i);
            for(int j = 0; j < li.size(); j++)
            {
                System.out.print(li.get(i) + " ");
            }
            System.out.println();
        }

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> neli = new LinkedList<> ();
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i = 0; i <= n-3; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while(left < right)
            {
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0)
            {
                List <Integer> intli = new LinkedList <> ();
                intli.add(nums[i]);
                intli.add(nums[left]);
                intli.add(nums[right]);
                neli.add(intli);
                while((left + 1) < n && nums[left] == nums[left + 1])
                {
                    left++;
                }
                left++;
            }
            else if(sum < 0)
            {
                left++;
            }
            else{
                right--;
            }
            }
        }

        return neli;
    }
}
