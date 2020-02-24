class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun find(node: TreeNode?, orig: TreeNode?, target: Int): Boolean {
        if (node == null) return false
        if (node.`val` == target) {
            if (node == orig) return false
            return true
        }
        if (node.`val` > target) return find(node.left, orig, target)
        if (node.`val` < target) return find(node.right, orig, target)
        return false
    }

    fun traverse(root: TreeNode, node: TreeNode?, k: Int): Boolean {
        if (node == null) return false
        if (find(root, node, k-node.`val`)) return true
        if (traverse(root, node.left, k)) return true
        if (traverse(root, node.right, k)) return true
        return false
    }

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) return false
        return traverse(root, root, k)
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
