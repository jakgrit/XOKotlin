import java.util.*;

fun main(){
    val sc = Scanner(System.`in`)

    var count: Int = 0
    var turn: Char = 'X'

    val arr2D = arrayOf(
        arrayOf("-", "-", "-"),
        arrayOf("-", "-", "-"),
        arrayOf("-", "-", "-")
    )

    for (row in arr2D){
        for(col in row){
            print(col)
        }
        println()
    }

    var row:Int
    var col:Int

    while (count < 9){

        if(turn == 'X'){
            println("X Turn")

            row = sc.nextInt()
            col = sc.nextInt()

            if((col > 3 && row > 3 || row < 0 && col < 0)){
                println("Error Out Of Bounds")
                continue
            }else{
                if(arr2D[row-1][col-1] != "-"){

                    println("Duplicate slot")

                }else{

                    if(col == 2){
                        arr2D[row - 1][col - 1] = turn.toString()
                    }

                    arr2D[row - 1][col - 1] = turn.toString()
                    turn = 'O'
                    count ++
                }
            }

        }else{
            println("O Turn")

            row = sc.nextInt()
            col = sc.nextInt()

            if((col > 3 && row > 3 || row < 0 && col < 0)){
                println("Error Out Of Bounds")
                continue
            }else{
                if(arr2D[row-1][col-1] != "-"){

                    println("Duplicate slot")

                }else{
                    if (col == 2){
                        arr2D[row - 1][col - 1] = turn.toString()
                    }

                    arr2D[row - 1][col - 1] = turn.toString()

                    turn = 'X'

                    count ++
                }
            }
        }

        if (checkWin(arr2D)){
            if(turn == 'X') turn = 'O'
            else turn = 'X'
            println("$turn Win")
            break
        }

        printArr(arr2D)
    }
}

fun printArr(arr: Array<Array<String>>){
    for (row in arr){
        for(col in row){
            print("$col ")
        }
        println()
    }
    print("------------- \n")
}

fun checkWin(table: Array<Array<String>>):Boolean {
    for(row in 0..2){
        if ((table[row][0] == table[row][1] && table[row][0] == table[row][2])){
            if (table[row][0] != "-") {
                return true
            }
        }

    }
    for (col in 0..2) {
        if ((table[0][col] == table[1][col] && table[0][col] == table[2][col])) {
            if (table[0][col] != "-") {
                return true
            }
        }
    }
    if (table[1][1] != "-"){
        if ((table[0][0] == table[1][1] && table[0][0] == table[2][2])){
            return true
        }
        if ((table[2][0] == table[1][1] && table[2][0] == table[0][2])){
            return true
        }
    }
    return false
}