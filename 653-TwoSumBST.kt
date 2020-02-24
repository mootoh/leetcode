class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val visited: MutableSet<Int> = mutableSetOf()

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) return false
        if (visited.contains(k-root.`val`)) return true
        visited.add(root.`val`)
        return findTarget(root.left, k) || findTarget(root.right, k)
    }
}

fun main(args: Array<String>) {
    val root1 = TreeNode(5).apply { 
        left = TreeNode(3).apply { 
            left = TreeNode(2)
            right = TreeNode(4)
         }
        right = TreeNode(6).apply { 
            right = TreeNode(7)
         }
    }
    println(Solution().findTarget(root1, 9))

    val root2 = TreeNode(1)
    println(Solution().findTarget(root2, 2))

    val root3 = TreeNode(2).apply { 
        left = TreeNode(1)
        right = TreeNode(3)
     }
    println(Solution().findTarget(root3, 4))
}
