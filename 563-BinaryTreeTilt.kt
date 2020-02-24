import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumOf(root: TreeNode?): Int {
        if (root == null) return 0
        return root.`val` + sumOf(root.left) + sumOf(root.right)
    }

    fun tilt(node: TreeNode?): Int {
        if (node == null) return 0
        return abs(sumOf(node.left) - sumOf(node.right))
    }

    fun findTilt(root: TreeNode?): Int {
        if (root == null) return 0
        return tilt(root) + tilt(root.left) + tilt(root.right)
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
