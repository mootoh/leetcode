import kotlin.math.max

class Solution {
    fun dfs(x: Int, y: Int, grid: Array<IntArray>): Int {
        if (grid[y][x] == 0) return 0
        grid[y][x] = 0

        var area = 1
        if (x > 0)
            area += dfs(x-1, y, grid)
        if (x+1 < grid[0].size)
            area += dfs(x+1, y, grid)
        if (y > 0)
            area += dfs(x, y-1, grid)
        if (y+1 < grid.size)
            area += dfs(x, y+1, grid)
        return area
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var area = 0
        grid.forEachIndexed {y, row ->
            row.forEachIndexed {x, _ ->
                area = max(area, dfs(x, y, grid))
            }
        }
        return area
    }
}