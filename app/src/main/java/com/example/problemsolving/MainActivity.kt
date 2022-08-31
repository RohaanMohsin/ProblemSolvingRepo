package com.example.problemsolving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    val num = intArrayOf(10,40,20, 30,15,50,60 )
    var a = 50
    var b = 120
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    get_button?.setOnClickListener {
//        getThirdLargestElement()
//        getNumberOfOccurrenceOfCharacter("keep the Flag flying high", 'z')
//        firstNonRepeatedCharacters("MEMO")
//        removeRepeatedCharacters("AABBCCDDEEFF")
//        removeRepeatedIntigers(listOf(1,1,2,2,3,3,4,4,5,5))

//        swapElement()
//        getPalandrom(1122)

        answer_text?.text = nNumberOfPrimeNumber(100).toString()
        // [2,6,7,8,1]
    }

    }


    fun getThirdLargestElement(){
        var firstElement = num[0]
        for (element in num)
        {
            if(firstElement < element){
                firstElement = element
                answer_text?.text = firstElement.toString()
                println(" number is =======**========== > $element")

            }
            println(" number is ================= > $element")
        }
    }

    fun getNumberOfOccurrenceOfCharacter(value:String,findingLetter:Char){

        var count = 0
        val charArray = value.toCharArray()

        for (x in charArray){
            if (x == findingLetter){
                count++
            }
        }

        answer_text?.text = "Character occure $count times in this String "
        println("Character occure $count times in this String ")
    }

    fun firstNonRepeatedCharacters(value:String){

        val hashMap = LinkedHashMap<Char,Int>()
        val charArray = value.toCharArray()

       for(x in charArray){
           if(hashMap.containsKey(x)){

               hashMap[x] = hashMap[x]?.plus(1)!!

           }else{
               hashMap[x] = 1
           }
       }

        for (x in hashMap){

            if (x.value == 1){
                answer_text?.text = "NON Repeating Element is ${x.key}"
                break
            }
            println("${x.key} === ${x.value}")


        }
    }

    fun removeRepeatedCharacters(value:String){

        var charArr = value?.toCharArray()
        var hashmap = LinkedHashMap<Char,Boolean>()
        var str = ""

        for (x in charArr){
            if (!hashmap.containsKey(x)){
                hashmap.put(x,true)
            }
        }

        for (x in hashmap){
            str += x.key
        }

        answer_text?.text = "New Sring is  $str"

    }

    fun removeRepeatedIntigers(value:List<Int>){

        var hashmap = LinkedHashMap<Int,Int>()
        var str = ""

        for (x in value){
            if (!hashmap.containsKey(x)){
                hashmap.put(x,value.indexOf(x))
            }
        }

        for (x in hashmap){
            str += x.key.toString()
        }

        answer_text?.text = "New Sring is  $str"

    }

    fun swapElement(){ //10 , 20

        a += b

        b = a - b

        a -= b

        answer_text?.text = "value of a = $a ====== value of b = $b"
    }

    fun getPalandrom(value: Int){
        var orignalValue = value
        var number = value
        var reminder = 0
        var reverseNum = 0

        while (number != 0){

            reminder = number % 10
            reverseNum = reverseNum * 10 + reminder
            number /= 10
        }

        if (orignalValue == reverseNum){
            answer_text?.text = "true"
        }else
            answer_text?.text = "false"

    }

    fun reverseArray() : ArrayList<Int>{
        val array = arrayListOf(1,2,3,4,5,6)
        var newArray = ArrayList<Int>()

        for (x in (array.size).downTo(1)){
            newArray.add(x)
        }

        return newArray
    }

    fun findMissingNumber(list:ArrayList<Int>, number:Int) : Int{

        //N*(N+1)/2 formulla

        var totalSum = number*(number+1)/2
        println("------------------- $totalSum")
        var arraySum = 0

        for (x in list){
            arraySum = arraySum + x
        }

        println("------------------- $arraySum")


        return totalSum - arraySum
    }

    fun findLargestAndSmallestInt(list:ArrayList<Int>) :String{

        var largest = list[0]
        var smallest = list[0]

        for (x in list){

            if (largest < x ){
                largest = x
            }else if (smallest > x){
                smallest = x
            }

//            if (smallest > x){
//                smallest = x
//            }
        }

        return "largest is $largest  and Smallest is $smallest"
    }

    fun fabonacciSeries(num:Int):ArrayList<Int>{

        var num1 = 0
        var num2 = 1

        var arr = ArrayList<Int>()
//        arr.add(num1)
        for (x in 1..num){
            arr.add(num1)

            val sum = num1 + num2
            num1 = num2
            num2 = sum
        }

        return arr
    }

    fun armStrongNumber(num:Int,power:Double):Boolean{

       var number = num
       var orignalNumber = num
       var finalNumber = 0

       while (number != 0 ) {

           var reminder = number % 10
           finalNumber += reminder.toDouble().pow(power).toInt()
           number /= 10
       }

        return orignalNumber == finalNumber
    }

    fun anagram(value1:String,value2:String) : Boolean{

        val hashMap = LinkedHashMap<Char,Int>()
        val charArray1 = value1.toCharArray()
        val charArray2 = value2.toCharArray()

        if (value1.length != value2.length)
            return false
        else{
            var flag = true

            for (x in charArray1){
                if (hashMap.containsKey(x)){
                    hashMap[x] = hashMap[x]?.plus(1)!!
                }else
                    hashMap[x] = 1
            }

            for (x in charArray2){
                if (hashMap.containsKey(x)){
                    hashMap[x] = hashMap[x]?.plus(1)!!
                }else
                    hashMap[x] = 1
            }

            for (x in hashMap){

                if (x.value % 2 == 1){
                    flag = false
                    break
                }

            }

            return flag
        }

    }

    fun factorial(num:Int):Int{

        var factorial = 1

        for (x in 1..num){
            factorial *= x
        }

        return factorial
    }

    fun isPrimeNumber(number:Int):Boolean{

        var flag = true

        if (number == 1)
            flag = false

        for (x in 2 until number){

            if (number % x == 0 ){
                flag = false
                break
            }
        }

        return flag
    }

    fun nNumberOfPrimeNumber(number:Int):ArrayList<Int>{

        var primeNumberList = ArrayList<Int>()

        for (x in 1..number){
            if (isPrimeNumber(x)){
             primeNumberList.add(x)
            }
        }
        return primeNumberList
    }

}