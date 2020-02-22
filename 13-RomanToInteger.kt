class Solution {
    fun romanToInt(s: String): Int {
        var result = 0
        var isI = false
        
        s.asIterable().forEach { ch ->
            when(ch) {
                'I' -> {
                    result += 1
                    isI = true
                }
                'V' -> {
                    result += 5
                    if (isI) {
                        isI = false
                        result -= 2
                    }
                }
                'X' -> {
                    result += 10
                    if (isI) {
                        isI = false
                        result -= 2
                    }
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().romanToInt("I"))
    println(Solution().romanToInt("II"))
    println(Solution().romanToInt("III"))
    println(Solution().romanToInt("IV"))
    println(Solution().romanToInt("V"))
    println(Solution().romanToInt("VI"))
    println(Solution().romanToInt("VII"))
    println(Solution().romanToInt("VIII"))
    println(Solution().romanToInt("IX"))
    println(Solution().romanToInt("X"))
    println(Solution().romanToInt("XV"))
}