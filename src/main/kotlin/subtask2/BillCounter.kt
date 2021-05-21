package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var sum = 0
        bill.forEachIndexed { i, it ->
            if (i != k) {
                sum += it
            }
        }
        return if (sum / 2 == b) {
            "Bon Appetit"
        } else {
            "${b - sum / 2}"
        }
    }
}
