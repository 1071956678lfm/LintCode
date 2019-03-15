package leet.Sum;

/**
 * 883
 */
public class Area3DShapes {
    /**
     * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
     * <p>
     * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
     * <p>
     * Now we view the projection of these cubes onto the xy, yz, and zx planes.
     * <p>
     * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
     * <p>
     * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
     * <p>
     * Return the total area of all three projections.
     * <p>
     * Analyse:
     * (x,y,z) = (i,j,grid[i][j])
     */
    public int projectionArea(int[][] grid) {
        int areaXY = 0;
        int areaXZ = 0;
        int areaYZ = 0;
        //XY
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 0)
                    ++areaXY;
        //XZ
        for (int i = 0; i < grid.length; i++) {
            int rowMAX_Z = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > rowMAX_Z) {
                    rowMAX_Z = grid[i][j];
                }
            }
            areaXZ += rowMAX_Z;
        }
        //YZ
        for (int j = 0; j < grid[0].length; j++) {
            int colMAX_Z = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > colMAX_Z)
                    colMAX_Z = grid[i][j];
            }
            areaYZ += colMAX_Z;
        }

        return areaXY + areaXZ + areaYZ;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(new Area3DShapes().projectionArea(nums));
    }
}
