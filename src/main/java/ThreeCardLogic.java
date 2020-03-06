import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {
	
	public static int evalHand(ArrayList<Card> hand)
    {	
		if(StraightFlush(hand) == true)
		{
			System.out.println("Inside straightFlush");
			return 1;
		}
		
		else if(threeOfAKind(hand)==true)
		{
			System.out.println("Inside threeOfAKind");
			return 2;
		}
		
		else if(straight(hand) == true)
		{
			System.out.println("Inside straight");
			return 3;
		}
		
		else if(flush(hand) == true)
		{
			System.out.println("Inside flush");
			return 4;
		}
		
		else if(pair(hand) == true)
		{
			System.out.println("Inside pair");
			return 5;
		}
		
		else 
		{
			System.out.println("High Card");
			return 0; 	
		}
		
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

	
	//staight helper
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
	

	public static int evalPPWinnings(ArrayList<Card> hand, int bet) 
	{
		if(StraightFlush(hand) == true)
		{
			bet = 40*bet;
			System.out.println("PPB: " + bet);
			return bet;
		}
		
		else if(threeOfAKind(hand) == true)
		{
			bet = 30*bet;
			System.out.println("PPB: " + bet);
			return bet;git remote add origin https://github.com/hetbanker/Project2.git
		}
		
		else if(straight(hand) == true)
		{
			bet = 6*bet;
			System.out.println("PPB: " + bet);
			return bet;
		}
		
		else if(flush(hand) == true)
		{
			bet = 3*bet;
			System.out.println("PPB: " + bet);
			return bet;
		}
		
		else if(pair(hand) == true)
		{
			bet = 1*bet;
			System.out.println("PPB: " + bet);
			return bet;
		}
		
		else 
		{
			return 0;
		}
		
	}
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) 
	{
		
		
		
		
		return 0;
	}
	
	

}