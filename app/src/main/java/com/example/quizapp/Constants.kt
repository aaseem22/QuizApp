package com.example.quizapp

object Constants {
   // these constant values are used to display in the result page
    // const val must always be in ***capital letters***.
    const val USER_NAME : String = "user_name"
    const val TOTAL_QUE : String = "total_que"
    const val CORRECT_ANS : String = "correct_answer"


    //questions are inherited from Questions class.
    fun getQuestion(): ArrayList<Questions> {
        val queList = ArrayList<Questions>()
//1
        val que1 = Questions(
            1, " In the given figure , ∠POS = 90⁰. What Is the measure of ∠ROQ?",
            R.drawable.que1,
            "30 degrees ", "45 degrees ",
            " 90 degrees ", "180 degrees",
            3
        )
        // '.add' is used to add que in the arraylist
        //without add que will not be displayed.
            queList.add(que1)


//2
        val que2 = Questions(
            2, "  In the given figure ,what is the value of x, if 4x= 5y",
            R.drawable.que2,
            "100 degrees ", "105 degrees ",
            " 115 degrees", "180 degrees",
            1
        )
        queList.add(que2)



//3
        val que3 = Questions(
            3, "If OE is the bisector of ∠AOD in the given figure ,then the value of X and y are respectively",
            R.drawable.que3,
            " 45 degrees, 45 degrees ", "68  degrees , 48 degrees",
            " 48 degrees , 66 degrees", "30  degrees, 60 degrees",
            2
        )
        queList.add(que3)


        val que4 = Questions(
            4, "In a ∆ ABC, AB= BC,∠ B= x⁰ and ∠A = (2x-20)⁰. Then, ∠ B= ? ",
            R.drawable.que4,
            " 30 degrees ", " 40 degrees",
            " 44 degrees ", "64 degrees",
            3
        )
        queList.add(que4)


        // 5
        val que5 = Questions(
            5, "In a cyclic quad. ABCD, ∠A=80⁰. Then ∠c =? ",
            R.drawable.que5,
            " 80 degrees ", " 160 degrees",
            " 100 degrees ", "120 degrees",
            3
        )
        queList.add(que5)


        // 6
        val que6= Questions(
            6, "How many vertices are there in the following figure?",
            R.drawable.que10,
            " 5 ", "3",
            "2 ", "1",
            1
        )
        queList.add(que6)

//7
        val que7= Questions(
            7, "The value of (x) in the following figure is ",
            R.drawable.que7,
            " 120 degrees ", " 1000 degrees",
            " 80 degrees ", "60 degrees",
            4
        )
        queList.add(que7)


        // 8



        val que8= Questions(
            8, "How Many Triangles are There In This Figure? ",
            R.drawable.que11,
            "25", "24",
            "26", "23",
            1
        )
        queList.add(que8)

        //we have to return questions to queslist
        //quelist is the arraylist of  questions/
        return queList
    }

}