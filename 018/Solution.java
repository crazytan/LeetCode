import java.util.*;

public class Solution {

    public class Quad {
        int[] arr;

        public Quad(int[] arr) {
            this.arr = arr;
            Arrays.sort(this.arr);
        }

        public List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < 4;i++) list.add(arr[i]);
            return list;
        }

        @Override
        public String toString() {
            return arr[0] + "-" + arr[1] + "-" + arr[2] + "-" + arr[3];
        }
    }

    private boolean canProvide(List<Integer> list, int[] nums) {
        Set<Integer> set = new HashSet<>(list);
        if (set.size() < 4) {
            for (Integer n: set) {
                int cnt = 0;
                for (Integer _n: list) {
                    if (_n.equals(n)) cnt++;
                }
                for (int i = 0;i < nums.length;i++) {
                    if (nums[i] == n) cnt--;
                }
                if (cnt > 0) return false;
            }
        }
        return true;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if ((nums == null) || (nums.length < 4)) return ans;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0;i < nums.length;i++)
            for (int j = i + 1;j < nums.length;j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(sum)) {
                    map.get(sum).add(nums[i]);
                }
                else {
                    Set<Integer> set = new HashSet<>();
                    set.add(nums[i]);
                    map.put(sum, set);
                }
            }

        Set<String> strSet = new HashSet<>();
        for (int i = 0;i < nums.length;i++)
            for (int j = i + 1;j < nums.length;j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(target - sum)) {
                    Set<Integer> set = map.get(target - sum);
                    for (Integer n: set) {
                        int[] arr = new int[] {nums[i], nums[j], n, target - sum - n};
                        Quad quad = new Quad(arr);
                        if (!strSet.contains(quad.toString())) {
                            ans.add(quad.toList());
                            strSet.add(quad.toString());
                        }
                    }
                }
            }

        return Arrays.asList(ans.stream()
                                .filter(list -> canProvide(list, nums))
                                .toArray(ArrayList[]::new));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }
}