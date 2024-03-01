package no.ntnu.idatx2003.oblig3.cardgame;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import no.ntnu.idatx2003.oblig3.cardgame.Main;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class cardGameUI extends Application{
  public void start(Stage stage) throws Exception {
    //Creating labels
    Label sumOfFaceLabel = new Label("Sum of the faces:");
    Label cardOfHeartsLabel = new Label("Cards of hearts:");
    Label flushLabel = new Label("Flush:");
    Label queenOfSpadesLabel = new Label("Queen of spades:");

    Label Card1 = new Label("Please");
    Label Card2 = new Label("Click");
    Label Card3 = new Label("Deal");
    Label Card4 = new Label("Hand");
    Label Card5 = new Label("First");

    sumOfFaceLabel.setFont(javafx.scene.text.Font.font("Impact", 15));
    cardOfHeartsLabel.setFont(javafx.scene.text.Font.font("Impact", 15));
    flushLabel.setFont(javafx.scene.text.Font.font("Impact", 15));
    queenOfSpadesLabel.setFont(javafx.scene.text.Font.font("Impact", 15));

    Card1.setFont(javafx.scene.text.Font.font("Impact", 15));
    Card2.setFont(javafx.scene.text.Font.font("Impact", 15));
    Card3.setFont(javafx.scene.text.Font.font("Impact", 15));
    Card4.setFont(javafx.scene.text.Font.font("Impact", 15));
    Card5.setFont(javafx.scene.text.Font.font("Impact", 15));

    //Creating buttons and setting their size and font
    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    //Creating textfields
    TextField SumOfFacesTextfield = new TextField();
    TextField CardOfHeartsTextfield = new TextField();
    TextField FlushTextfield = new TextField();
    TextField QueenOfSpadesTextfield = new TextField();

    SumOfFacesTextfield.setPrefSize(40, 20);
    CardOfHeartsTextfield.setPrefSize(80, 20);
    FlushTextfield.setPrefSize(40, 20);
    QueenOfSpadesTextfield.setPrefSize(40, 20);

    dealHandButton.setPrefSize(100, 20);
    checkHandButton.setPrefSize(100, 20);
    dealHandButton.setFont(javafx.scene.text.Font.font("Impact", 15));
    checkHandButton.setFont(javafx.scene.text.Font.font("Impact", 15));

    //Creates a window for the tabletop of the cardgame.
    GridPane cardWindow = new GridPane();

    //Creates a window for the game menu
    FlowPane gameMenu = new FlowPane();

    //Creates a window for game info
    GridPane gameInfo = new GridPane();

    //Creates a borderpane for the window
    GridPane rootNode = new GridPane();

    //Creates a group for the rootNode
    Group cardWindowRoot = new Group();
    Group gameMenuRoot = new Group();
    Group gameInfoRoot = new Group();

    //Adds the windows to the rootNodes
    cardWindowRoot.getChildren().add(cardWindow);
    gameMenuRoot.getChildren().add(gameMenu);
    gameInfoRoot.getChildren().add(gameInfo);

    //Sets the center of the rootNode to the cardWindow
    rootNode.add(cardWindowRoot, 0, 0);
    rootNode.add(gameMenuRoot, 1, 0);
    rootNode.add(gameInfoRoot, 0, 1);

    //Adds cards to the cardWindow
    cardWindow.add(Card1, 0, 0);
    cardWindow.add(Card2, 1, 0);
    cardWindow.add(Card3, 2, 0);
    cardWindow.add(Card4, 3, 0);
    cardWindow.add(Card5, 4, 0);

    //Centers and creates space between the cards on cardWindow.
    cardWindow.setHgap(10);
    cardWindow.setVgap(10);
    cardWindow.setPadding(new Insets(10, 10, 10, 10));
    cardWindow.setAlignment(Pos.CENTER);

    //Adds the labels and buttons to gameInfo
    gameInfo.add(sumOfFaceLabel, 0, 0);
    gameInfo.add(SumOfFacesTextfield, 1, 0);
    gameInfo.add(cardOfHeartsLabel, 0, 1);
    gameInfo.add(CardOfHeartsTextfield, 1, 1);
    gameInfo.add(flushLabel, 2, 0);
    gameInfo.add(FlushTextfield, 3, 0);
    gameInfo.add(queenOfSpadesLabel, 2, 1);
    gameInfo.add(QueenOfSpadesTextfield, 3, 1);

    //Centers and creates space between the labels and buttons on gameInfo.
    gameInfo.setHgap(10);
    gameInfo.setVgap(10);
    gameInfo.setPadding(new Insets(10, 10, 10, 10));
    gameInfo.setAlignment(Pos.CENTER);

    //Adds buttons to the gameMenu
    ObservableList list = gameMenu.getChildren();
    list.addAll(dealHandButton, checkHandButton);

    //Orents the buttons in the gameMenu
    gameMenu.setOrientation(Orientation.VERTICAL);
    gameMenu.setAlignment(Pos.TOP_CENTER);

    //Centers and creates space between the buttons on gameMenu.
    gameMenu.setPadding(new Insets(10, 10, 10, 10));
    gameMenu.setVgap(10);
    gameMenu.setHgap(10);
    gameMenu.setAlignment(Pos.CENTER);

    //Gives the buttons events
    dealHandButton.setOnAction(e -> {
      DeckOfCards deck = new DeckOfCards();
      deck.shuffleDeck();
      PlayingCard[] hand = deck.dealHand(5);
      Card1.setText(hand[0].getAsString());
      Card2.setText(hand[1].getAsString());
      Card3.setText(hand[2].getAsString());
      Card4.setText(hand[3].getAsString());
      Card5.setText(hand[4].getAsString());
    });
    checkHandButton.setOnAction(e -> {
      DeckOfCards deck = new DeckOfCards();
      PlayingCard[] hand = new PlayingCard[5];
      hand[0] = new PlayingCard(Card1.getText().charAt(0), Integer.parseInt(Card1.getText().substring(1)));
      hand[1] = new PlayingCard(Card2.getText().charAt(0), Integer.parseInt(Card2.getText().substring(1)));
      hand[2] = new PlayingCard(Card3.getText().charAt(0), Integer.parseInt(Card3.getText().substring(1)));
      hand[3] = new PlayingCard(Card4.getText().charAt(0), Integer.parseInt(Card4.getText().substring(1)));
      hand[4] = new PlayingCard(Card5.getText().charAt(0), Integer.parseInt(Card5.getText().substring(1)));

      SumOfFacesTextfield.setText(Integer.toString(deck.sumOfFaces(hand)));
      CardOfHeartsTextfield.setText(Integer.toString(deck.cardOfHearts(hand)));
      FlushTextfield.setText(Boolean.toString(deck.flush(hand)));
      QueenOfSpadesTextfield.setText(Boolean.toString(deck.queenOfSpades(hand)));
    });

    //makes the size og gameMenu, gameInfo and cardwindow relative to windowsize
    gameMenu.prefWidthProperty().bind(rootNode.widthProperty().divide(4));
    gameMenu.prefHeightProperty().bind(rootNode.heightProperty().divide(4).multiply(3));
    gameInfo.prefWidthProperty().bind(rootNode.widthProperty().divide(4).multiply(3));
    gameInfo.prefHeightProperty().bind(rootNode.heightProperty().divide(4));
    cardWindow.prefWidthProperty().bind(rootNode.widthProperty().divide(4).multiply(3));
    cardWindow.prefHeightProperty().bind(rootNode.heightProperty().divide(4).multiply(3));

    //Sets the size and style of the gameMenu
    gameMenu.setStyle("-fx-background-color: #86542e");

    //Sets the size and style of the cardWindow

    cardWindow.setStyle("-fx-background-color: green");

    //Sets the size and style of the gameInfo

    gameInfo.setStyle("-fx-background-color: #86542e");

    //Sets the background color of the rootNode
    rootNode.setStyle("-fx-background-color: #86542e");

    //Creates a scene for the window
    Scene scene = new Scene(rootNode, 800, 600);

    //set minimum window size
    stage.setMinHeight(450);
    stage.setMinWidth(700);

    //Sets the scene to the stage
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();

  }
    public static void appmain(String[] args) { launch(); }

}
