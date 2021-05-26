package subtask3

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val closeBrackets = mapOf('(' to ')', '[' to ']', '<' to '>')
        val ans = arrayListOf<String>()
        val openBrackets = setOf('(', '[', '<')

        inputString.forEach {
            ans.forEachIndexed { i, s ->
                val close = closeBrackets[s[0]]
                if (s.last() != close || s.count { ch -> ch == s[0] } != s.count { ch -> ch == close }) {
                    ans[i] = s + it
                }
            }
            if (it in openBrackets) {
                ans.add("$it")
            }
        }

        for (j in 0 until ans.size) {
            ans[j] = ans[j].slice(1 until ans[j].lastIndex)
        }

        return ans.toTypedArray()
    }
}
