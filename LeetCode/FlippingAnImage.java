class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] flippedInvertedImage = new int[image.length][image.length];
        for (int i = 0; i < flippedInvertedImage.length; i++)
            getFlippedRow(image[i], flippedInvertedImage[i]);
        return flippedInvertedImage;
    }

    private int[] getFlippedRow(int[] row, int[] copyTo) {
        for(int i = 0; i < copyTo.length; i++)
            copyTo[i] = row[row.length-i-1] ^ 1;
        return copyTo;
    }
}