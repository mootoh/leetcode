import kotlin.math.min

class MinStack() {
    /** initialize your data structure here. */
    val stk: MutableList<Pair<Int, Int>> = mutableListOf()

   
    fun push(x: Int) {
        if (stk.isEmpty()) {
            stk.add(Pair(x, x))
        } else {
            stk.add(Pair(x, min(x, stk.last().second)))
        }
    }

    fun pop() {
        stk.removeAt(stk.lastIndex)
    }

    fun top(): Int {
        return stk.last().first
    }

    fun getMin(): Int {
        return stk.last().second
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
fun main(args: Array<String>) {
    var minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // -3
    minStack.pop()
    println(minStack.top()) // 0
    println(minStack.getMin()) // -2
}