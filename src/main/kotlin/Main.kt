fun mergeSort(array: ArrayList<Int>): ArrayList<Int> {

    if (array.size < 1) {
        return array
    }

    val pivot: Int = array.size / 2
    val left: ArrayList<Int> = arrayListOf(pivot)
    val right: ArrayList<Int> = arrayListOf(array.size-pivot)

    for (i in 0..pivot-1) {
        left[i] = array[i]
    }

    for (i in pivot..array.size) {
        right[i-pivot] = array[i]
    }

    mergeSort(left)
    mergeSort(right)
    merge(array, left, right)

}


fun merge(targetArray: ArrayList<Int>, items1: ArrayList<Int>, items2: ArrayList<Int>) {

    var array1MinIndex: Int = 0
    var array2MinIndex: Int = 0

    var targetArrayMinIndex: Int = 0


    while (array1MinIndex < items1.size && array2MinIndex < items2.size) {

        if (items1[array1MinIndex] <= items2[array2MinIndex]) {

            targetArray[targetArrayMinIndex] = items1[array1MinIndex]
            array1MinIndex++

        } else {

            targetArray[targetArrayMinIndex] = items2[array1MinIndex]
            array2MinIndex++

        }
    }

    while (array1MinIndex < items1.size) {

        targetArray[targetArrayMinIndex] = items1[array1MinIndex]
        array1MinIndex++

    }

    while (array2MinIndex < items2.size) {

        targetArray[targetArrayMinIndex] = items2[array2MinIndex]
        array2MinIndex++

    }



}

fun main() {

    val array: ArrayList<Int> = arrayListOf(8, 4, 5, 2, 1, 9)

    println(mergeSort(array))

}