import java.util.*
import java.lang.Integer.*
import java.lang.Math;

import kotlin.random.Random 
fun main(args: Array<String>)
{
	var counter: Int = 0
	
	
	var guess1 : Int = 0
	var guess2 : Int = 0
	var guess3 : Int = 0
	var guess4 : Int = 0
	
	//println("$guess1$guess2$guess3$guess4")
	while(checkIfGuess(guess1,guess2,guess3,guess4) == false)
	{
		 guess1 = Random.nextInt(0,9)
		 guess2  = Random.nextInt(0,9)
     	 guess3 = Random.nextInt(0,9)
	     guess4  = Random.nextInt(0,9)
	}
	
	
	var guessNumber : String ="$guess1$guess2$guess3$guess4"
		
	// for revealing the guess number:
	println(guessNumber)
	
	
	//var guessNumber: String = "9620"
	
	var correction = arrayOf("X","X","X","X")
	println("Number Master")
	println("")
	println("Instructions:")
	println("")
	println("The object of the game is to guess the hidden four digit number.")
	println("There are no repeated digits in the number. Once you have guessed, a code will be shown that indicates how successful your guess was.")
	println("")
	println("1 = correct digit in the right place, 2 = correct digit in the wrong place, X = incorrect digit")
	println("")
	println("Enter your four digit guess below (when you enter more than 4 digits , your first 4 will be taken):");
 
	 	
		var scoreTable : String =""
	
		/*var userInput = readLine()
		var neueInput : String = "$userInput".take(4)*/
 
	    var userInput : String? = ""
		var neueInput : String = ""
    	
	

		while(neueInput != guessNumber)
		{
			var checkIfNumber = neueInput.toIntOrNull()
			
			 var doppelt = checkIfDoubles(neueInput)
			 if(neueInput.length == 4)
			 {
				 if(checkIfNumber != null)
				 {
					 if(doppelt == 0 )
					{
					  correction = arrayOf("X","X","X","X")
					 counter++
					 checkNumber(neueInput,guessNumber,correction)
					 var corrString : String = correction[0]+correction[1]+correction[2]+correction[3]
					
					scoreTable = "$scoreTable\n$counter  $neueInput  $corrString"
					 println(scoreTable)
					 userInput = readLine()
					 neueInput  = "$userInput".take(4)
					}
					 else
					{
					   println("Please don't use digits, which appear more than once in your input !")
					   userInput = readLine()
					   neueInput  = "$userInput".take(4)
					}
				 }
				 else
				  {
					  println("Please don't use characters, user numbers !")
					 userInput = readLine()
					 neueInput  = "$userInput".take(4)
				}
			 }
			else
		    {
				println("Please write a number with at least 4 digits !")
				userInput = readLine()
				 neueInput  = "$userInput".take(4)
		
			}
	
		
	 
	}
	println("Congratulations ! You did it ! The number was $guessNumber")
	println("You needed $counter attempts")

	
}


		
		
		
fun checkIfGuess(guess1:Int,guess2:Int,guess3:Int,guess4:Int):Boolean
{
	if(guess1 != guess2 && guess1 != guess3 && guess1 != guess4 && guess2 != guess3 && guess2 != guess4 && guess3 != guess4)
	{
		return true
	}
	else
	{
		return false
	} 
}		
fun checkIfDoubles(neueInput:String) :Int
{
	for(z in neueInput)
	{
		var counter = 0
		for(t in neueInput)
		{
			if(z == t)
			{
				counter++
			}
		}
		if(counter > 1)
		{
			 return 1
			break;
		}
	
	}
	return 0
}


fun checkNumber(userInput:String,guessnumber: String,correction:Array<String>)
{
	
	
	
	//correction is an array , because on Kotlin i can't change certain characters on certain fields like correction[0] = "1" with Strings
	
	var correctcounter : Int = 0
	var swapcounter : Int = 0
	
	
	var runVar1 = 0
	
	//first run for correct guesses with correct positions
	while (runVar1 < 4)
	{
		
		var runVar2 = 0
		while(runVar2 <4)
		{
			
		    if(userInput[runVar1] == guessnumber[runVar2])
			{
				
				if(runVar1 == runVar2)
				{
				
					var rechnung = correctcounter
					correction[rechnung] = "1"
					correctcounter++
			
				}
				
			
			}	
			runVar2++
		}
		
		runVar1++
		
	}
	
	//second run for correct guesses but wrong positions
	var runVar3 = 0
	while (runVar3 < 4)
	{
		
		var runVar4 = 0
		while(runVar4 <4)
		{
			
		    if(userInput[runVar3] == guessnumber[runVar4])
			{
				
				if(runVar3 != runVar4)
				{
				
					var rechnung = correctcounter + swapcounter
					correction[rechnung] = "2"
					swapcounter++
				}
 
			}
	
			runVar4++
		}
		
		runVar3++
		
	}
	
	
}







