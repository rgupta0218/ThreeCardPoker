import java.util.ArrayList;
import java.util.Collections;



//ThreCardLogic class
public class ThreeCardLogic 
{
	//function to check who won which type of bet
	public static int evalHand(ArrayList<Card> hand)
    {	
		//returns one if player or dealer won staright flush
		if(StraightFlush(hand) == true) { return 1;}
		
		//returns two if player or dealer won threeOfAKind
		else if(threeOfAKind(hand)==true){ return 2;}
		
		//returns three if player or dealer won straight
		else if(straight(hand) == true){ return 3;}
		
		//returns four if player or dealer won flush
		else if(flush(hand) == true){ return 4; }
		
		//returns five if player or dealer won pair
		else if(pair(hand) == true){ return 5; }
		
		//returns zero if player or dealer has high card
		else { return 0; }
    }

	
	//pair helper
	public static boolean pair (ArrayList<Card> hand)
	{
		if ((hand.get(0).value == hand.get(1).value) ||
			(hand.get(0).value == hand.get(2).value) ||
			(hand.get(1).value == hand.get(2).value))
		{
			return true;
		}
		return false;
	}
	
	//flush helper
	public static boolean flush (ArrayList<Card> hand)
	{
		if((hand.get(0).suit == hand.get(1).suit) &&
		   (hand.get(0).suit == hand.get(2).suit) &&
		   (hand.get(1).suit == hand.get(2).suit))
		{
			return true;
		}
		return false;
	}

	
	//Straight helper ace 2 3 
	public static boolean straight (ArrayList<Card> hand)
	{
		ArrayList<Integer> straightChecker = new ArrayList<Integer>();
		
		straightChecker.add(hand.get(0).value);
		straightChecker.add(hand.get(1).value);
		straightChecker.add(hand.get(2).value);
		Collections.sort(straightChecker);
		
		if(((straightChecker.get(0)+1)== straightChecker.get(1)) && 
		   ((straightChecker.get(1)+1)== straightChecker.get(2)))
		{
			return true;
		}
		
		if((straightChecker.get(0) == 2) && (straightChecker.get(1) == 3) && (straightChecker.get(2) == 14))
		{
			return true;
		}
		return false;
	}

	//threeOfAKind helper
	public static boolean threeOfAKind (ArrayList<Card> hand)
	{	
		if ((hand.get(0).value == hand.get(1).value) &&
			(hand.get(0).value == hand.get(2).value) &&
			(hand.get(1).value == hand.get(2).value))
		{
			return true;
		}
		return false;
	}
	
	//StraightFlush helper
	public static boolean StraightFlush(ArrayList<Card> hand)
	{
		if((flush(hand) == true) && (straight(hand) == true))
		{
			return true;
		}
		return false;
	}
	

	//evalute the PPB here
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) 
	{
		//if the player got staright flush then PPB*40
		if(StraightFlush(hand) == true)
		{
			bet = 40*bet;
			return bet;
		}
		
		//if the player got staright flush then PPB*30
		else if(threeOfAKind(hand) == true)
		{
			bet = 30*bet;
			return bet;
		}
		
		//if the player got staright flush then PPB*6
		else if(straight(hand) == true)
		{
			bet = 6*bet;
			return bet;
		}
		
		//if the player got staright flush then PPB*3
		else if(flush(hand) == true)
		{
			bet = 3*bet;
			return bet;
		}
		
		//if the player got staright flush then PPB*1
		else if(pair(hand) == true)
		{
			bet = 1*bet;
			return bet;
		}
		
		//if the player loses the PPB then return 0
		return 0;
	}
	
	//
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) 
	{
		//checks to see if the dealer qualifies or not, do not conitnue the game if the dealer doesn't qualify
		if ((dealer.get(0).value >= 12) || (dealer.get(1).value >= 12) || (dealer.get(2).value >= 12))
		{ 
			//evaluate who won
			int deal = evalHand(dealer);
			int play = evalHand(player);
			
			//checks to who wins
			if (deal > play) 
			{
				if(play == 0) { return 1;} //dealer 
				return 2;
			}
			
			else if(deal < play)
			{
				if(deal == 0) {return 2;}
				return 1;
			}
			
			else 
			{
				//arrayList to check the index of high cards
			    ArrayList<Integer> dealersCards = new ArrayList<Integer>();
			    ArrayList<Integer> playersCards = new ArrayList<Integer>();
			
			    for(int i = 0; i < 3; i++){
		            playersCards.add(player.get(i).value);
		            dealersCards.add(dealer.get(i).value);
		        }
			    
			    //check to see if neither won, so we have to sort the cards
			    Collections.sort(playersCards);	
			    Collections.sort(dealersCards);

			    if((dealersCards.get(2)) > (playersCards.get(2))) { return 1;}
			    else if ((dealersCards.get(2)) < (playersCards.get(2)))
			    {
			    	return 2;
			    }

			    //this statement checks when both the dealer and cards second values are same
			    else 
			    {
			    	 //checking if the first 
			    	 if((dealersCards.get(1)) > (playersCards.get(1)))
					 {
					    return 1;
					 }
			    	 else if ((dealersCards.get(1)) < (playersCards.get(1)))
					 {
					    return 2;
					 }
			    	 else
			    	 {
			    		 if((dealersCards.get(0)) > (playersCards.get(0)))
						 {
						    return 1;
						 }
			    		 else if((dealersCards.get(0)) < (playersCards.get(0)))
						 {
						    return 2;
						 } 
			    	 }
			    	 return 0;
			    }
				
			}

		}
		else
		{
			return 0;
		}
	
	}

}