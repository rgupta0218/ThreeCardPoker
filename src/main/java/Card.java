public class Card 
{
	char suit;
	int value;
	
	Card(char suit1, int value1)
	{
		suit = suit1;
		value= value1;
	}
	
	
	public String toString() {
        return this.suit +""+ this.value;
    }
}
