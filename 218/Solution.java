import java.util.*;

public class Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        if ((buildings.length == 0) || (buildings[0].length == 0)) {
            return new ArrayList<>();
        }
        int n = buildings.length;
        Set<Integer> coordSet = new HashSet<>();
        List<Integer> coordList = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            if (!coordSet.contains(buildings[i][0])) {
                coordSet.add(buildings[i][0]);
                coordList.add(buildings[i][0]);
            }
            if (!coordSet.contains(buildings[i][1])) {
                coordSet.add(buildings[i][1]);
                coordList.add(buildings[i][1]);
            }
        }
        Collections.sort(coordList);
        Map<Integer, Integer> coordMap = new HashMap<>();
        int index = 0;
        for (int coord: coordList) {
            coordMap.put(coord, index);
            index++;
        }

        int[] heights = new int[coordList.size()];
        for (int i = 0;i < n;i++) {
            int startIndex = coordMap.get(buildings[i][0]);
            int endIndex = coordMap.get(buildings[i][1]);
            int height = buildings[i][2];
            for (int j = startIndex;j < endIndex;j++) {
                if (height > heights[j]) heights[j] = height;
            }
        }

        List<int[]> ans = new ArrayList<>();
        ans.add(new int[] {coordList.get(0), heights[0]});
        int prev = heights[0];
        for (int i = 1;i < heights.length;i++) {
            if (heights[i] != prev) {
                ans.add(new int[] {coordList.get(i), heights[i]});
                prev = heights[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //List<int[]> ans = new Solution().getSkyline(new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
        List<int[]> ans = new Solution().getSkyline(new int[][] {{}});
        ans.stream().forEach(point -> System.out.println(point[0] + " " + point[1]));
    }
}