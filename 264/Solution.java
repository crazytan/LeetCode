import java.util.*;

public class Solution {

    public class Factor implements Comparable<Factor> {
        int a,b,c;
        long val;

        public Factor(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            val = 1;
            for (int i = 0;i < a;i++) val *= 2;
            for (int i = 0;i < b;i++) val *= 3;
            for (int i = 0;i < c;i++) val *= 5;
        }

        @Override
        public int compareTo(Factor f) {
            if (this.val < f.val) return -1;
            if (this.val > f.val) return 1;
            return 0;
        }
    }

    public void insert(Factor f, PriorityQueue<Factor> q1, PriorityQueue<Factor> q2, PriorityQueue<Factor> q3) {
        if ((f.a >= f.b) && (f.a >= f.c)) q1.add(f);
        else if ((f.a < f.b) && (f.b >= f.c)) q2.add(f);
        else q3.add(f);
    }

    public int nthUglyNumber(int n) {
        if (n <= 2) return n;
        PriorityQueue<Factor> q1 = new PriorityQueue<>();
        PriorityQueue<Factor> q2 = new PriorityQueue<>();
        PriorityQueue<Factor> q3 = new PriorityQueue<>();
        q1.add(new Factor(2,0,0));
        q1.add(new Factor(1,1,0));
        q1.add(new Factor(1,0,1));
        q2.add(new Factor(0,1,0));
        q3.add(new Factor(0,0,1));
        for (int i = 3;i < n;i++) {
            long val1 = q1.peek().val;
            long val2 = q2.peek().val;
            long val3 = q3.peek().val;
            Factor tmp;
            if ((val1 <= val2) && (val1 <= val3)) {
                tmp = q1.poll();
                if (q1.peek() != null) while (tmp.val == q1.peek().val) q1.poll();
                insert(new Factor(tmp.a + 1, tmp.b, tmp.c), q1, q2, q3);
                insert(new Factor(tmp.a, tmp.b + 1, tmp.c), q1, q2, q3);
                insert(new Factor(tmp.a, tmp.b, tmp.c + 1), q1, q2, q3);

            }
            else if ((val2 <= val1) && (val2 <= val3)) {
                tmp = q2.poll();
                if (q2.peek() != null) while (tmp.val == q2.peek().val) q2.poll();
                insert(new Factor(tmp.a, tmp.b + 1, tmp.c), q1, q2, q3);
                insert(new Factor(tmp.a, tmp.b, tmp.c + 1), q1, q2, q3);

            }
            else {
                tmp = q3.poll();
                if (q3.peek() != null) while (tmp.val == q3.peek().val) q3.poll();
                insert(new Factor(tmp.a, tmp.b, tmp.c + 1), q1, q2, q3);
            }
        }
        long val1 = q1.peek().val;
        long val2 = q2.peek().val;
        long val3 = q3.peek().val;
        return (int) Math.min(val1, Math.min(val2, val3));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1432));
    }
}
