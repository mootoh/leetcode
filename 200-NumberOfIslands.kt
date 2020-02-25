class Solution {
    fun dfs(x: Int, y: Int, found: Int, grid: Array<CharArray>, visited: Array<IntArray?>) {
        if (visited[y]!![x] > 0 || grid[y][x] == '0')
            return
        visited[y]!![x] = found


        if (y > 0)
            dfs(x, y-1, found, grid, visited)
        if (y+1 < grid.size)
            dfs(x, y+1, found, grid, visited)
        if (x+1 < grid[0].size)
            dfs(x+1, y, found, grid, visited)
        if (x > 0)
            dfs(x-1, y, found, grid, visited)
    }

    fun numIslands(grid: Array<CharArray>): Int {
        // initialization
        var found = 0
        var visited: Array<IntArray?> = arrayOfNulls<IntArray?>(grid.size)
        grid.forEachIndexed { y, row ->
            visited[y] = IntArray(row.size)
            row.forEachIndexed { x, _ ->
                visited[y]!![x] = 0
            }
        }

        grid.forEachIndexed { y, row ->
            row.forEachIndexed {x, cell ->
                if (cell == '1' && visited[y]!![x] == 0) {
                    found += 1
                    dfs(x, y, found, grid, visited)
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