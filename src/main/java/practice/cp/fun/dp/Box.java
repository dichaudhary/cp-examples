package practice.cp.fun.dp;

public class Box implements Comparable<Box> {
    int w,h,l;
    int area;

    public Box(int w, int h, int l) {
        this.w = w;
        this.h = h;
        this.l = l;
        this.area = this.w*this.l;
    }

    @Override
    public int compareTo(Box a) {
        return a.area - this.area;
    }
}
