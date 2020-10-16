package com.example.fotbollsquizen

object Information {

    fun getQuestions():ArrayList<Questions>{
        val questionList = ArrayList <Questions>()

        val fråg1 = Questions(1,"Vilket Tröj Nr hade Zlatan Ibrahimovic när han spelade i landslaget?",
            R.drawable.zlatan,
            "Nr 9",
            "Nr 11",
            "Nr 10",
            "Nr 7",
            3
        )

        questionList.add((fråg1))

        // 2
        val fråg2= Questions(2,"Sveriges Landslag åkte ut i kvartsfinal år 2018, mot vilket lag?",
            R.drawable.sverige,
            "Sceweiz",
            "Tyskland",
            "Mexiko",
            "England",
            4
        )
        questionList.add(fråg2)

        // 3
        val fråg3 = Questions(3,"Vilket år vann Barcelona champions league titeln sist?",
            R.drawable.barcelona,
            "2015",
            "2016",
            "2017",
            "2018",
            1
        )
        questionList.add(fråg3)

        // 4
        val fråg4 = Questions(4,"Spelaren Neymar lämnade Barcelona 2017, till vilket lag gick han?",
            R.drawable.neymar,
            "Bayern munchen",
            "Paris Saint Germain",
            "Borussia Dortmund",
            "Manchester City",
            2
        )

        questionList.add(fråg4)

        // 5
        val fråg5 = Questions(5,"Hur gammal är stjärn spelaren Cristiano Ronaldo?",
            R.drawable.cristiano,
            "34",
            "33",
            "36",
            "35",
            4
        )
        questionList.add(fråg5)


        // 6
        val fråg6 = Questions(6,"Vilket av följande lag har vunnit Championsleague flest gånger?",
            R.drawable.championsleague,
            "Chelsea",
            "Milan",
            "Real madrid",
            "PSG",
            2
        )
        questionList.add(fråg6)

        // 7
        val fråg7 = Questions(7,"Vart spelas VM 2022?",
            R.drawable.qatar,
            "Qatar",
            "Australien",
            "Frankrike",
            "Brasilien",
            1
        )
        questionList.add(fråg7)

        //8
        val fråg8 = Questions(8,"Henrik larsson blev tredje tränare iår, till vilket lag?",
            R.drawable.henke,
            "Villareal",
            "Athletico bilbao",
            "Barcelona",
            "Real betis",
            3
        )
        questionList.add(fråg8)

        //9
        val fråg9 = Questions(9,"Vad heter Inters nuvarande tränare?",
            R.drawable.inter,
            "Jose Mourinho",
            "Mauricio Pochettino",
            "Ole Gunnar Solskjaer",
            "Antonio Conte",
            4
        )
        questionList.add(fråg9)

        //10
        val fråg10 = Questions(10,"Zidane fick rödkort efter att ha attackerat en spelarei vm 2006, vilken spelare var det?",
            R.drawable.zidane,
            "Marco Reus",
            "Marco Materazzi",
            "Paulo Maldini",
            "Fabio Cannavaro",
            2
        )
        questionList.add(fråg10)

        return questionList

    }
}