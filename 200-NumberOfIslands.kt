class Solution {
    fun dfs(x: Int, y: Int, grid: Array<CharArray>) {
        if (grid[y][x] == '0')
            return
        grid[y][x] = '0'

        if (y > 0)
            dfs(x, y-1, grid)
        if (y+1 < grid.size)
            dfs(x, y+1, grid)
        if (x+1 < grid[0].size)
            dfs(x+1, y, grid)
        if (x > 0)
            dfs(x-1, y, grid)
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var found = 0

        grid.forEachIndexed { y, row ->
            row.forEachIndexed {x, cell ->
                if (cell == '1') {
                    found += 1
                    dfs(x, y, grid)
                }
            }
        }

        return found
    }
}

fun main(args: Array<String>) {
    println(Solution().numIslands(
        arrayOf(
            "11110".toCharArray(),
            "11010".toCharArray(),
            "11000".toCharArray(),
            "00000".toCharArray()
        )
    ))
    println(Solution().numIslands(
        arrayOf(
            "11000".toCharArray(),
            "11000".toCharArray(),
            "00100".toCharArray(),
            "00011".toCharArray()
        )
    ))
    println(Solution().numIslands(
        arrayOf(
            "111".toCharArray(),
            "010".toCharArray(),
            "111".toCharArray()
        )
    ))
}