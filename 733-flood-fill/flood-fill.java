class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int OG = image[sr][sc];
        if(color != OG){
            paint(image, sr, sc, color, OG);
        }
        return image;
    }
    public void paint(int[][] image, int r, int c, int color, int OG){
        if(image[r][c] == OG){
            image[r][c] = color;
            if (r >= 1) {
                paint(image, r - 1, c, color, OG);
            }
            if (c >= 1) {
                paint(image, r, c - 1, color, OG);
            }
            if (r + 1 < image.length) {
                paint(image, r + 1, c, color, OG);
            }
            if (c + 1 < image[0].length) {
                paint(image, r, c + 1, color, OG);
            }
        }
    }
}