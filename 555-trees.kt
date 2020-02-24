import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1+max(maxDepth(root.left), maxDepth(root.right))
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(3).apply { 
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
        }
     }
    println(Solution().maxDepth(root))
}