import java.awt.PageAttributes;
import java.util.ArrayList;

//import javafx.application.Application;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.Scene;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;

public class ThreeCardPokerGame //extends Application 
{

//	public Button btn1;
//	public Button btn2;
//	public VBox paneCenter;
//	public TextField text; 
	public static void main(String[] args)  
	{
		// TODO Auto-generated method stub
		//launch(args);
		//System.out.println("Hello world!");
		Deck deckTestingDeck = new Deck( );
		//System.out.println(deckTestingDeck);
		System.out.println("Deck size: " + deckTestingDeck.size( ));
		
		Dealer Het = new Dealer();
		System.out.println("Dealers Card:  " + Het.dealHand( ));
		System.out.println("Deck size: " + Het.deckSize( ));  
		
		//System.out.println(Het.theDeck); 
		
		Player player1 = new Player();
		player1.hand.add(Het.playerCard1());
		player1.hand.add(Het.playerCard1());
		player1.hand.add(Het.playerCard1());
		System.out.println("Player1 Cards:  " + player1.hand);
		//System.out.println(Het.theDeck);
		System.out.println("Deck size: " + Het.deckSize( ));  
		
		int PPB = 10;
		
		//ThreeCardLogic logic = new ThreeCardLogic();
		ThreeCardLogic.evalHand(player1.hand);
		ThreeCardLogic.evalPPWinnings(player1.hand, PPB);
		
		
	}

	//feel free to remove the starter code from this method
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		primaryStage.setTitle("Let's Play Three Card Poker!!!");
//		text = new TextField();
//		
//		btn1 = new Button("button 1");
//		btn2 = new Button("button 2");
//		paneCenter = new VBox(20, text, btn1);
//		Scene scene = new Scene(new HBox(),600,600);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}

}
