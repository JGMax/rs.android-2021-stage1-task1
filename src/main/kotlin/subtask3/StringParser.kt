package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val closeBrackets = mapOf('(' to ')', '[' to ']', '<' to '>')
        val ans = arrayListOf<String>()
        val openBrackets = mutableMapOf('(' to 0, '[' to 0, '<' to 0)
        val creatingStrings = arrayListOf<String>()

        inputString.forEach {
            when (it) {
                in openBrackets.keys -> {
                    for (i in 0 until creatingStrings.size) {
                        var s = creatingStrings[i]
                        s += it
                        creatingStrings[i] = s
                    }
                    creatingStrings.add("$it")
                }
                in closeBrackets.values -> {
                    var i = creatingStrings.lastIndex
                    var isNotFoundClosedBracket = true
                    while (i >= 0) {
                        var s = creatingStrings[i]
                        s += it
                        if (closeBrackets[creatingStrings[i][0]] == it && isNotFoundClosedBracket) {
                            creatingStrings.removeAt(i)
                            ans.add(s)
                            isNotFoundClosedBracket = false
                        } else {
                            creatingStrings[i] = s
                        }
                        i--
                    }
                }
                else -> {
                    for (i in 0 until creatingStrings.size) {
                        var s = creatingStrings[i]
                        s += it
                        creatingStrings[i] = s
                    }
                }
            }
        }

        for (j in 0 until ans.size) {
            ans[j] = ans[j].slice(1 until ans[j].lastIndex)
        }
        return ans.toTypedArray()
    }
}