import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeCardPokerGame extends Application {


	//Declaring the players and the dealer
	Player player1 = new Player();
	Player player2 = new Player();
	Dealer dealer = new Dealer();
	
	//Keeping track of player's earning
	int totalWinningsP1 = player1.totalWinnings;
	int totalWinningsP2 = player1.totalWinnings;
	
	
	
	void PlayTheGame(Stage primaryStage)
	{
		primaryStage.setTitle("Let's Play Three Card Poker!!!");
		
		//get the three cards for the dealer
		dealer.dealHand();
		
		//Creating buttons for players 
		Button dealButtonP1 = new Button("Deal Cards");
		Button dealButtonP2 = new Button("Deal Cards");
		Button playButtonP1 = new Button("Play");
		playButtonP1.setDisable(true);
		Button playButtonP2 = new Button("Play");
		playButtonP2.setDisable(true);
		Button foldButtonP1 = new Button("Fold");
		foldButtonP1.setDisable(true);
		Button foldButtonP2 = new Button("Fold");
		foldButtonP2.setDisable(true);
		Button continuegame = new Button("Continue");

		//Creating text field to take user input 		
		TextField anteBetP1 = new TextField();
		anteBetP1.setPrefWidth(80);
		anteBetP1.setPromptText("AnteBet");
		TextField anteBetP2 = new TextField();
		anteBetP2.setPrefWidth(80);
		anteBetP2.setPromptText("AnteBet");
		TextField pairPlusBetP1 = new TextField();
		pairPlusBetP1.setPrefWidth(80);
		pairPlusBetP1.setPromptText("PairPlusBet");
		TextField pairPlusBetP2 = new TextField();
		pairPlusBetP2.setPromptText("PairPlusBet");
		pairPlusBetP2.setPrefWidth(80);
		
		//Creating labels to differentiate players
		Label player1Lable = new Label("Player 1 ");
      	player1Lable.setTextFill(Color.web("Yellow", 1.0));
      	player1Lable.setFont(Font.font("Times", FontWeight.BOLD,25));
      	
      	Label player1LableTotal = new Label("Total Earnings: " + totalWinningsP1 + " ");
      	player1LableTotal.setTextFill(Color.web("white", 1.0));
      	player1LableTotal.setFont(Font.font("Times", FontWeight.BOLD,25));
      	
      	Label player2Lable = new Label("Player 2 ");
      	player2Lable.setTextFill(Color.web("Yellow", 1.0));
      	player2Lable.setFont(Font.font("Times", FontWeight.BOLD,25));
		
     	Label player1LableTotal2 = new Label("Total Earnings: " + totalWinningsP2 + " ");
      	player1LableTotal2.setTextFill(Color.web("white", 1.0));
      	player1LableTotal2.setFont(Font.font("Times", FontWeight.BOLD,25));
		
      	//HBox having player2 cards and buttons
      	HBox holdsPlayer2CardsBox = new HBox(10,player1LableTotal2, player2Lable,dealButtonP2,anteBetP2,pairPlusBetP2,playButtonP2,foldButtonP2);
      	holdsPlayer2CardsBox.setTranslateY(-125);
		
      //HBox having player1 cards and buttons
		HBox holdsPlayer1CardsBox = new HBox(10,player1LableTotal,player1Lable,dealButtonP1, anteBetP1,pairPlusBetP1, playButtonP1,foldButtonP1);
		holdsPlayer1CardsBox.setTranslateY(100);
		
		VBox V = new VBox(300,holdsPlayer1CardsBox, holdsPlayer2CardsBox);
		
		//setting action for deal button for player1
		dealButtonP1.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//only taking input if the ante bet is more than 5 and less than 25
				if((Integer.parseInt(anteBetP1.getText()) > 4) && (Integer.parseInt(anteBetP1.getText()) < 26) )
				{
					playButtonP1.setDisable(true);
					foldButtonP1.setDisable(true);
					//taking in the user input for ante bet and pair plus bet
					player1.anteBet = Integer.parseInt(anteBetP1.getText());
					player1.pairPlusBet = Integer.parseInt(pairPlusBetP1.getText());
					//getting cards for player one from the deck
					player1.hand.add(dealer.playerCard1());
					player1.hand.add(dealer.playerCard1());
					player1.hand.add(dealer.playerCard1());
					
					//getting image for the cards drawn for player one to display
					for(Card c: player1.hand)
					{ 
						Image player1Image= new Image(Integer.toString(c.value)+c.suit+".png",100,150,false, false);
						ImageView playper1= new ImageView(player1Image);
						holdsPlayer1CardsBox.getChildren().add(playper1);
					}
					playButtonP1.setDisable(false);
					foldButtonP1.setDisable(false);
				}
				dealButtonP1.setDisable(true);
			}
		});
		
		//setting deal button on action for player two
		dealButtonP2.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//taking in user input only if the ante bet is more than 5 and less than 25
				if((Integer.parseInt(anteBetP2.getText()) > 4) && (Integer.parseInt(anteBetP2.getText()) < 26) )
				{
					playButtonP2.setDisable(true);
					foldButtonP2.setDisable(true);
					//taking in input for ante bet and pair plus bet
					player2.anteBet = Integer.parseInt(anteBetP2.getText());
					player2.pairPlusBet = Integer.parseInt(pairPlusBetP2.getText());
					//getting cards for player two from the deck
					player2.hand.add(dealer.playerCard1());
					player2.hand.add(dealer.playerCard1());
					player2.hand.add(dealer.playerCard1());
					
					//getting image for the cards drawn for player two to display
					for(Card c: player2.hand)
					{ 
						Image player2Image= new Image(Integer.toString(c.value)+c.suit+".png",100,150,false, false);
						ImageView player2= new ImageView(player2Image);
						holdsPlayer2CardsBox.getChildren().add(player2);
					}
					//Enabling the Play and fold button
					playButtonP2.setDisable(false);
					foldButtonP2.setDisable(false);
				}
				dealButtonP2.setDisable(true);
			}
		});

		//HBox for dealer's information
		HBox dealerBox = new HBox(10);
		dealerBox.setTranslateX(25);
        dealerBox.setTranslateY(75);
        
        //play button action when clicked
        playButtonP1.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				dealButtonP1.setDisable(true);
				foldButtonP1.setDisable(true);
				//calling compare function to check who wins the deal
				int whoWon= ThreeCardLogic.compareHands(dealer.dealersHand, player1.hand);
				Label dealerLable = new Label("Dealer");
		      	dealerLable.setTextFill(Color.web("yellow", 1.0));
		      	dealerLable.setFont(Font.font("Times", FontWeight.BOLD,40));
		      	dealerBox.getChildren().add(dealerLable);
		      	
		      	//showing the dealers card, getting the image for the dealers card drawn from the deck
				for(Card x: dealer.dealersHand)
				{ 
					Image dImage= new Image(Integer.toString(x.value)+x.suit+".png",100,150,false, false);
					ImageView dealerImages= new ImageView(dImage);
					dealerBox.getChildren().add(dealerImages);
				}
				
				//if player one wins the game 
				if (whoWon == 2)
				{
					//calculate the total winnings for player one
					player1.anteBet = Integer.parseInt(anteBetP1.getText());
			        int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet);
			        totalWinningsP1 = totalWinningsP1 + player1.anteBet+player1.anteBet  + calculatetedPPB;
					//check which pair plus bet the player one won
					int typeOfBet = ThreeCardLogic.evalHand(player1.hand);
					if(typeOfBet == 1)
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON staright flush\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 2)
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON ThreeOfAKind\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 3)
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON Straight\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 4)
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON Flush\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if (typeOfBet == 5)
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON Pair\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else 
					{
						//show on the game how the player one won
						Label statmentsss = new Label("Player1 WON High Card\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
				}
				
				//if the dealer wins the game
				else if(whoWon == 1)
				{
					//calculate the total winning of the player one
					player1.anteBet = Integer.parseInt(anteBetP1.getText());
			        int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player1.hand, player1.pairPlusBet);
			        totalWinningsP1 = totalWinningsP1 + calculatetedPPB -player1.anteBet-player1.anteBet ;
					int typeOfBet = ThreeCardLogic.evalHand(dealer.dealersHand);
					//show on the game how the dealer won
					if(typeOfBet == 1)
					{
						Label statmentsss = new Label("Player 1 loses staright flush\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
				        
					}
					//show on the game how the dealer won
					else if(typeOfBet == 2)
					{
						Label statmentsss = new Label("Player 1 loses ThreeOfAKind\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					//show on the game how the dealer won
					else if(typeOfBet == 3)
					{
						Label statmentsss = new Label("Player 1 loses Straight\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					//show on the game how the dealer won
					else if(typeOfBet == 4)
					{
						Label statmentsss = new Label("Player 1 loses Flush\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					//show on the game how the dealer won
					else if (typeOfBet == 5)
					{
						Label statmentsss = new Label("Player 1 loses Pair\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					//show on the game how the dealer won
					else {
						Label statmentsss = new Label("Player 1 loses High Card\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
				}
				//if dealer does not at least have queen high then calculate the pair plus bet for player one and 
				//push the ante bet forward for the next deal
				else 
				{
					//calculate the player one winning 
					int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player1.hand, Integer.parseInt(pairPlusBetP1.getText()));
					totalWinningsP1 = totalWinningsP1 +  calculatetedPPB -Integer.parseInt(anteBetP1.getText());
					//display on the game that the dealer didn't qualify to play
					Label statmentsss = new Label("Dealer doesn't have Queen high;\n ante wager is pushed\n" + "Player1 TotalEarnings: " + totalWinningsP1 + "\n");
					statmentsss.setTextFill(Color.web("yellow", 1.0));
					statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
			        dealerBox.getChildren().add(statmentsss);
				}
				playButtonP1.setDisable(true);
				dealButtonP1.setDisable(false);
				player1.hand.clear();

			}
			
		});
        
        //play button for player two setting action 
        playButtonP2.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				dealButtonP2.setDisable(true);
				foldButtonP2.setDisable(true);
				//calling compare function to check who wins the deal
				int whoWon= ThreeCardLogic.compareHands(dealer.dealersHand, player2.hand);
				//if the player two wins then 
				if (whoWon == 2)
				{
					//calculate the total winnings for player two
					player2.anteBet = Integer.parseInt(anteBetP2.getText());
			        int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player2.hand, player2.pairPlusBet);
			        totalWinningsP2 = totalWinningsP2 + player2.anteBet+player2.anteBet  + calculatetedPPB;
					int typeOfBet = ThreeCardLogic.evalHand(player2.hand);
					//Check how the player two win and display
					if(typeOfBet == 1)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON staright flush\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 2)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON ThreeOfAKind\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 3)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON Straight\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 4)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON Flush\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if (typeOfBet == 5)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON Pair\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else 
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 WON High Card\n" + "   Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
				}
				//if the dealer wins the game 
				else if(whoWon == 1)
				{
					//calculate the player two winning and the pair plus bet
					player2.anteBet = Integer.parseInt(anteBetP2.getText());
			        int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player2.hand, player2.pairPlusBet);
			        totalWinningsP2 = totalWinningsP2 + calculatetedPPB -player2.anteBet-player2.anteBet ;
			        //call eval hand from the logic to check how the dealer won
					int typeOfBet = ThreeCardLogic.evalHand(dealer.dealersHand);
					if(typeOfBet == 1)
					{
						//show on the game how the dealer won
						Label statmentsss = new Label("Player2 loses staright flush\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 2)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 loses ThreeOfAKind\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 3)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 loses Straight\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if(typeOfBet == 4)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 loses Flush\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else if (typeOfBet == 5)
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 loses Pair\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
					else 
					{
						//show on the game how the player two won
						Label statmentsss = new Label("Player2 loses High Card\n" + "Player2 TotalEarnings: " + totalWinningsP2);
						statmentsss.setTextFill(Color.web("yellow", 1.0));
						statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
				        dealerBox.getChildren().add(statmentsss);
					}
				}
				//if the dealer does not get at least queen high then the dealer doesn't qualify and so
				//just calculate the winnings and display 
				else 
				{
					//calculate the players earing for the next deal
					int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player2.hand, Integer.parseInt(pairPlusBetP2.getText()));
					totalWinningsP2 = totalWinningsP2 +  calculatetedPPB -Integer.parseInt(anteBetP2.getText());
					Label statmentsss = new Label("Dealer doesn't have Queen high;\n ante wager is pushed\n" + "Player2 TotalEarnings: " + totalWinningsP2);
					statmentsss.setTextFill(Color.web("yellow", 1.0));
					statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
			        dealerBox.getChildren().add(statmentsss);
				}
				playButtonP2.setDisable(true);
				dealButtonP2.setDisable(false);
				dealer.dealersHand.clear();
				player2.hand.clear();

			}
			
		});
        
        //if the player one decides not to play and wants to fold 
        foldButtonP1.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//disabling the deal and play button
				dealButtonP1.setDisable(true);
				playButtonP1.setDisable(true);
				//showing the dealers class
				Label dealerLable = new Label("Dealer");
		      	dealerLable.setTextFill(Color.web("yellow", 1.0));
		      	dealerLable.setFont(Font.font("Times", FontWeight.BOLD,40));
		      	dealerBox.getChildren().add(dealerLable);
		      	//after getting the cards of the dealer then get the image of those cards and show on the game
				for(Card x: dealer.dealersHand)
				{ 
					Image dealImage= new Image(Integer.toString(x.value)+x.suit+".png",100,150,false, false);
					ImageView dealerImages= new ImageView(dealImage);
					dealerBox.getChildren().add(dealerImages);
				}
				//calculate the earnings of the player two
				int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player1.hand, Integer.parseInt(pairPlusBetP1.getText()));
				totalWinningsP1 = totalWinningsP1 +  calculatetedPPB - Integer.parseInt(anteBetP1.getText());
				Label statmentsss = new Label("Player 1 folded"+ "\nPlayer1 TotalEarnings: " + totalWinningsP1);
				statmentsss.setTextFill(Color.web("yellow", 1.0));
				statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
		        dealerBox.getChildren().add(statmentsss);
			}
		});
        
      //if the player two decides not to play and wants to fold 
        foldButtonP2.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//disabling the deal and play button
				dealButtonP2.setDisable(true);
				playButtonP2.setDisable(true);
				//calculate the earnings of the player two
				int calculatetedPPB = ThreeCardLogic.evalPPWinnings(player2.hand, Integer.parseInt(pairPlusBetP2.getText()));
				totalWinningsP2 = totalWinningsP2 +  calculatetedPPB - Integer.parseInt(anteBetP2.getText());
				Label statmentsss = new Label("Player 2 folded"+ "\nPlayer2 TotalEarnings: " + totalWinningsP2);
				statmentsss.setTextFill(Color.web("yellow", 1.0));
				statmentsss.setFont(Font.font("Times", FontWeight.BOLD,20));
		        dealerBox.getChildren().add(statmentsss);
			}
		});

		//creating border pane to give the alignment
        BorderPane pane1 = new BorderPane();
        //get the image and create the image view for background
		Image image = new Image("back.jpg");
		BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		//get the image and create the image view for background
		Image image2 = new Image("back2.jpg");
		BackgroundSize bSize2 = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		
		//menu
		Menu menu = new Menu("Options");
		
		//create menu items 
        MenuItem menuExit = new MenuItem("Exit"); 
        MenuItem menuFreshStart = new MenuItem("Fresh Start"); 
        MenuItem menuNewLook = new MenuItem("New Look"); 
		
        //menu options
        menu.getItems().add(menuExit); 
        menu.getItems().add(menuFreshStart); 
        menu.getItems().add(menuNewLook); 
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        //HBox for adding the continue button and the option menu
		HBox forconBox = new HBox(menuBar,continuegame);
        //to close the game from menu bar
        menuExit.setOnAction(e->primaryStage.close());
		
        //new Start from the menu bar
        menuFreshStart.setOnAction(e-> 
        { 
        	pane1.getChildren().clear();
        	totalWinningsP1 = 1000; 
        	totalWinningsP2 = 1000; 
        	reset(primaryStage);
        	
        });
        
        //new look from the menu bar
        menuNewLook.setOnAction(e->
        { 
        	//displaying the pair plus bet rule heading
            Text pairPlusRuleHeading = new Text();
            pairPlusRuleHeading.setFill(Color.CRIMSON);
            pairPlusRuleHeading.setFont(Font.font("Times", FontWeight.BOLD,30));
            pairPlusRuleHeading.setText("PairPlusRules:");
            
            //displaying the pair plus bet rule 
            Text pairPlusRuleHeading1 = new Text();
            pairPlusRuleHeading1.setFill(Color.BLACK);
            pairPlusRuleHeading1.setFont(Font.font("Times", 20));
            pairPlusRuleHeading1.setText("* Staright Flush: 40 to 1\n" + 
            							 "* ThreeOfAKind: 30 to 1  \n" +
            							 "* Straight 6 to 1        \n"+
            							 "* Flush: 3 to 1          \n" + 
            							 "* Pair: 1 to 1           \n");
            
            //displaying the how to play the game heading
            Text pairPlusRuleHeading2 = new Text();
            pairPlusRuleHeading2.setFill(Color.CRIMSON);
            pairPlusRuleHeading2.setFont(Font.font("Times", FontWeight.BOLD,30));
            pairPlusRuleHeading2.setText("How to Play the Game:");
            
            //displaying the how to play the game
            Text pairPlusRuleHeading3 = new Text();
            pairPlusRuleHeading3.setFill(Color.BLACK);
            pairPlusRuleHeading3.setFont(Font.font("Times",20));
            pairPlusRuleHeading3.setText("* Play in full screen for best experience\n" +
            							 "* Enter AnteBet in first TextField\n" + 
            							 "* AnteBet should be bewteen 5 and 25\n"+
            								"* Enter PPBet in the next Textfield\n" +
            							 "* PairPlusBet can be any number\n"+
            									"* Then Press Deal Cards\n" +
            									 "* Then select Play/Fold\n"+
            									 "* To deal again hit continue\n"+
            									 "* Thank you for playing our game");
        	pane1.setBackground(new Background(new BackgroundImage(image2, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,bSize2)));
        	VBox stackPaneRules = new VBox(10,pairPlusRuleHeading2, pairPlusRuleHeading3, pairPlusRuleHeading,pairPlusRuleHeading1);    
        	pane1.setLeft(stackPaneRules);
        });
        
        //displaying the pair plus bet rule heading
        Text pairPlusRuleHeading = new Text();
        pairPlusRuleHeading.setFill(Color.YELLOW);
        pairPlusRuleHeading.setFont(Font.font("Times", FontWeight.BOLD,30));
        pairPlusRuleHeading.setText("PairPlusRules:");
        
        //displaying the pair plus bet rule
        Text pairPlusRuleHeading1 = new Text();
        pairPlusRuleHeading1.setFill(Color.WHITE);
        pairPlusRuleHeading1.setFont(Font.font("Times", 20));
        pairPlusRuleHeading1.setText("* Staright Flush: 40 to 1\n" + 
        							 "* ThreeOfAKind: 30 to 1  \n" +
        							 "* Straight 6 to 1        \n"+
        							 "* Flush: 3 to 1          \n" + 
        							 "* Pair: 1 to 1           \n");
        
        //displaying the how to play the game heading
        Text pairPlusRuleHeading2 = new Text();
        pairPlusRuleHeading2.setFill(Color.YELLOW);
        pairPlusRuleHeading2.setFont(Font.font("Times", FontWeight.BOLD,30));
        pairPlusRuleHeading2.setText("How to Play the Game:");
        
        //displaying the how to play the game
        Text pairPlusRuleHeading3 = new Text();
        pairPlusRuleHeading3.setFill(Color.WHITE);
        pairPlusRuleHeading3.setFont(Font.font("Times",20));
        pairPlusRuleHeading3.setText("* Play in full screen for best experience\n" +
        							 "* Enter AnteBet in first TextField\n" + 
        							 "* AnteBet should be bewteen 5 and 25\n"+
        								"* Enter PPBet in the next Textfield\n" +
        								"* PairPlusBet can be any number\n"+
        									"* Then Press Deal Cards\n" +
        									 "* Then select Play/Fold\n"+
        									 "* To deal again hit continue\n"+
        									 "* Thank you for playing our game");

        //VBox for setting the rule and 
        VBox stackPaneRules = new VBox(10,pairPlusRuleHeading2, pairPlusRuleHeading3, pairPlusRuleHeading,pairPlusRuleHeading1);    
        
        stackPaneRules.setMaxSize(10,10);
        stackPaneRules.setTranslateY(20);
        stackPaneRules.setStyle("-fx-font-size: 18;");
       
        //setting the pane and adding the HBox and VBox to set the game
        pane1.setTop(forconBox);
        pane1.setLeft(stackPaneRules);
        pane1.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,bSize)));
        pane1.setCenter(dealerBox);
        pane1.setBottom(V);
        //when the player wants to continue playing the game 
        continuegame.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent action) {
        		pane1.getChildren().clear();
            	reset(primaryStage);
			}
		});
        
		Scene scene = new Scene(pane1,1000,1000);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) 
	{
		launch(args);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		PlayTheGame(primaryStage);
	}

	//function to reset the game to the start 
	void reset(Stage stage)
	{
		player1.hand.clear();
		dealer.dealersHand.clear();
		PlayTheGame(stage);
	}
	
}