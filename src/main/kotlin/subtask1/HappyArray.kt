package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val sadList = sadArray.toMutableList()
        val happyList = arrayListOf<Int>()
        while (true) {
            sadList.forEachIndexed { index, i ->
                if (index == 0 || index == sadList.lastIndex) {
                    happyList.add(i)
                } else {
                    if (sadList[index - 1] + sadList[index + 1] >= i) {
                        happyList.add(i)
                    }
                }
            }
            if (sadList.size == happyList.size) {
                break
            }
            sadList.clear()
            sadList.addAll(happyList)
            happyList.clear()
        }
        return sadList.toIntArray()
    }
}
