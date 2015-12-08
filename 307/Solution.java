public class Solution {

    public class NumArray {

        private int sum, l, r;

        private NumArray left, right;

        private NumArray(int[] nums, int l, int r) {
            if (r < 0) {
                this.sum = 0;
                this.l = this.r = 0;
                this.left = this.right = null;
                return;
            }
            if (l >= r) {
                this.left = this.right = null;
                this.sum = nums[l];
                this.l = this.r = l;
                return;
            }
            int mid = (l + r) / 2;
            this.left = new NumArray(nums, l, mid);
            this.right = new NumArray(nums, mid + 1, r);
            this.sum = this.left.sum + this.right.sum;
            this.l = l;
            this.r = r;
        }

        public NumArray(int[] nums) {
            this(nums, 0, nums.length - 1);
        }

        void update(int i, int val) {
            if ((i == this.l) && (i == this.r)) {
                this.sum = val;
                return;
            }
            int mid = (l + r) / 2;
            if (i <= mid) {
                int tmp = this.left.sum;
                this.left.update(i, val);
                this.sum += (this.left.sum - tmp);
            }
            else {
                int tmp = this.right.sum;
                this.right.update(i, val);
                this.sum += (this.right.sum - tmp);
            }
        }

        public int sumRange(int i, int j) {
            if ((this.l == i) && (this.r == j)) return this.sum;
            int mid = (this.l + this.r) / 2;
            if (j <= mid) return this.left.sumRange(i, j);
            if (i > mid) return this.right.sumRange(i, j);
            return this.left.sumRange(i, mid) + this.right.sumRange(mid + 1, j);
        }
    }

    public void test() {
        NumArray numArray = new NumArray(new int[]{});
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, 10);
        System.out.println(numArray.sumRange(1, 2));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }
}
