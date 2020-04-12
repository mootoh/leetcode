class Solution {
    val matched = mapOf('(' to ')', '{' to '}', '[' to ']')
    fun isValid(s: String): Boolean {
        val stk = mutableListOf<Char>()
        for (ch in s) {
            when(ch) {
                '(', '{', '[' -> stk.add(0, ch)
                ')', '}', ']' -> {
                    if (stk.size == 0)
                        return false
                    val popped = stk.removeAt(0)
                    if (matched[popped] != ch)
                        return false
                }
            }
        }
        return stk.size == 0
    }
}

fun main(args: Array<String>) {
    println(Solution().isValid("()"))
    println(Solution().isValid("()[]{}"))
    println(Solution().isValid("(]"))
    println(Solution().isValid("([)]"))
    println(Solution().isValid("{[]}"))
}