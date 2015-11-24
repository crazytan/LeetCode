import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    private class Rational {
        int a;
        int b;

        private int gcd(int a, int b) {
            while (b > 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }

        Rational(int a, int b) {
            if (a == 0) {
                this.a = 0;
                this.b = 1;
                return;
            }
            if (b == 0) {
                this.a = 1;
                this.b = 0;
            }
            int gcd = gcd(Math.abs(a),Math.abs(b));
            a = a/gcd;
            b = b/gcd;
            if (a >= 0) {
                this.a = a;
                this.b = b;
            }
            else {
                this.a = -a;
                this.b = -b;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Rational)) return false;
            if (o == this) return true;

            Rational that = (Rational) o;
            return (this.a == that.a) && (this.b == that.b);
        }

        @Override
        public int hashCode() {
            return a * b + a;
        }
    }

    public int maxPoints(Point[] points) {
        int ans = 0;
        for (int i = 0;i < points.length;i++) {
            Map<Rational, Integer> angleMap = new HashMap<>();
            int max = 0;
            int sameCnt = 0;
            for (int j = 0;j < points.length;j++) {
                if (i != j) {
                    if ((points[i].x != points[j].x) || (points[i].y != points[j].y)) {
                        Rational angle = new Rational(points[j].x - points[i].x, points[j].y - points[i].y);
                        int cnt = angleMap.getOrDefault(angle, 0);
                        angleMap.put(angle, cnt + 1);
                        if ((cnt + 1) > max) max = cnt + 1;
                    }
                    else
                        sameCnt++;
                }
            }
            if ((max + sameCnt + 1) > ans) ans = max + sameCnt + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Point[] points = new Point[4];
        points[0] = new Point(1,1);
        points[1] = new Point(1,1);
        points[2] = new Point(2,2);
        points[3] = new Point(2,2);
        System.out.println(new Solution().maxPoints(points));
    }
}
