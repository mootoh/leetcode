import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var tilt = 0

    fun sumAndStoreTilt(node: TreeNode?): Int {
        if (node == null) return 0
        val left = sumAndStoreTilt(node.left)
        val right = sumAndStoreTilt(node.right)
        tilt += abs(left - right)
        return left + right + node.`val`
    }

    fun findTilt(root: TreeNode?): Int {
        if (root == null) return 0
        sumAndStoreTilt(root)
        return tilt
    }
}

fun main(args: Array<String>) {
    val root1 = TreeNode(1).apply { 
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(Solution().findTilt(root1))

    val root2 = TreeNode(5).apply { 
        left = TreeNode(3).apply { 
            left = TreeNode(2)
            right = TreeNode(4)
         }
        right = TreeNode(9).apply { 
            left = TreeNode(7)
            right = TreeNode(12)
         }
    }
    println(Solution().findTilt(root2))
}
