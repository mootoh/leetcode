import kotlin.math.max
import kotlin.math.min

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun validate(root: TreeNode?, lower: Int?, upper: Int?): Boolean {
        if (root == null) return true
        println("${root.`val`} $lower $upper")
        val value = root.`val`

        lower?.let { 
            if (value <= it)
                return false
         }
         upper?.let {
             if (value >= it)
                 return false
         }

         if (!validate(root.left, lower, value)) return false
         if (!validate(root.right, value, upper)) return false
         return true
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, null, null)
    }
}

fun main(args: Array<String>) {
    val root = TreeNode(2).apply { 
        left = TreeNode(1)
        right = TreeNode(3)
     }
    println(Solution().isValidBST(root))

    val root2 = TreeNode(5).apply { 
        left = TreeNode(1)
        right = TreeNode(4).apply { 
            left = TreeNode(3)
            right = TreeNode(6)
         }
     }
     println(Solution().isValidBST(root2))

     val root3 = TreeNode(10).apply { 
        left = TreeNode(5).apply { 
            left = TreeNode(6)
            right = TreeNode(20)
         }
        right = TreeNode(15)
     }
     println(Solution().isValidBST(root3))

     val root4 = TreeNode(10).apply { 
        left = TreeNode(5)
        right = TreeNode(15).apply { 
            left = TreeNode(6)
            right = TreeNode(20)
        }
    }
    println(Solution().isValidBST(root4))
}