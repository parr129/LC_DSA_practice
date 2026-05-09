import java.util.*;

class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> arr = new ArrayList<>();

            // top
            for (int j = layer; j < n - layer - 1; j++)
                arr.add(grid[layer][j]);

            // right
            for (int i = layer; i < m - layer - 1; i++)
                arr.add(grid[i][n - layer - 1]);

            // bottom
            for (int j = n - layer - 1; j > layer; j--)
                arr.add(grid[m - layer - 1][j]);

            // left
            for (int i = m - layer - 1; i > layer; i--)
                arr.add(grid[i][layer]);

            int size = arr.size();
            int rot = k % size;

            List<Integer> rotated = new ArrayList<>();

            rotated.addAll(arr.subList(rot, size));
            rotated.addAll(arr.subList(0, rot));

            int idx = 0;

            // put back

            for (int j = layer; j < n - layer - 1; j++)
                grid[layer][j] = rotated.get(idx++);

            for (int i = layer; i < m - layer - 1; i++)
                grid[i][n - layer - 1] = rotated.get(idx++);

            for (int j = n - layer - 1; j > layer; j--)
                grid[m - layer - 1][j] = rotated.get(idx++);

            for (int i = m - layer - 1; i > layer; i--)
                grid[i][layer] = rotated.get(idx++);
        }

        return grid;
    }
}