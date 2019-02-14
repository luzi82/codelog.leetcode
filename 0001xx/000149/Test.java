class Test{

    public static void main(String[] argv){
        Solution solution = new Solution();
        
        Point[] pts;
        pts = new Point[]{
            new Point(1,1),
            new Point(2,2),
            new Point(3,3)
        };
        assert(solution.maxPoints(pts)==3);
        
        pts = new Point[]{
            new Point(1,1),
            new Point(3,2),
            new Point(5,3),
            new Point(4,1),
            new Point(2,3),
            new Point(1,4)
        };
        assert(solution.maxPoints(pts)==4);

        pts = new Point[]{};
        assert(solution.maxPoints(pts)==0);

        pts = new Point[]{
            new Point(1,1)
        };
        assert(solution.maxPoints(pts)==1);

        pts = new Point[]{
            new Point(1,1),
            new Point(1,1),
            new Point(1,1)
        };
        assert(solution.maxPoints(pts)==3);

        pts = new Point[]{
            new Point(1,1),
            new Point(1,1),
            new Point(1,2)
        };
        assert(solution.maxPoints(pts)==3);
    }

}