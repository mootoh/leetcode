/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

data class NodeWithDepth(val node: TreeNode, val depth: Int)

class Solution {
    fun isLeaf(node: TreeNode): Boolean {
        if (node.left == null && node.right == null) return true
        return false
    }

    fun minDepth(root: TreeNode?): Int {
        val queue: MutableList<NodeWithDepth> = mutableListOf()

        if (root == null) return 0

        queue.add(NodeWithDepth(root, 1))

        while (queue.isNotEmpty()) {
            val elm = queue.first()
            queue.removeAt(0)
            if (isLeaf(elm.node))
                return elm.depth
            if (elm.node.left != null)
                queue.add(NodeWithDepth(elm.node.left!!, elm.depth+1))
            if (elm.node.right != null)
                queue.add(NodeWithDepth(elm.node.right!!, elm.depth+1))
        }
        
        return 0
    }
}

fun main(args: Array<String>) {
    println(Solution().minDepth(TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply { 
            left = TreeNode(15)
            right = TreeNode(7)
         }
    }))
    println(Solution().minDepth(TreeNode(3)))
    println(Solution().minDepth(TreeNode(1).apply {
        left = TreeNode(2)
    }))
}