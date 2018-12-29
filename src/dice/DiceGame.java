package dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DiceGame extends Application{

	int sizeOfArray=5;
	int rollNum=1;
	int score=0;
	int overallScore=0;
	int bestScore=0;
	int[] rollScore= {-1,-1,-1};
	Label overallSore=new Label("Overall Score: 0");
	ArrayList<Dice> diceList=new ArrayList<Dice>(sizeOfArray);
	ArrayList<Integer> diceNum=new ArrayList<>(sizeOfArray);
	
	Dice dice1=new Dice();
	Dice dice2=new Dice();
	Dice dice3=new Dice();
	Dice dice4=new Dice();
	Dice dice5=new Dice();
	
	//diceList.add(dice1);
	
	
	Button rollBtn=new Button("Roll Dice");
	Label roundScore=new Label("Round Score: 0");
	Label rollsRemaining=new Label("Rolls Remaining: 3");
	public static void main(String [] args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		
		diceList.add(dice1);
		diceList.add(dice2);
		diceList.add(dice3);
		diceList.add(dice4);
		diceList.add(dice5);
		
		
		HBox dices=new HBox(5, diceList.get(0).getDiceImage(), diceList.get(1).getDiceImage(), diceList.get(2).getDiceImage(), 
				               diceList.get(3).getDiceImage(), diceList.get(4).getDiceImage()); 
		
	
				
		dices.setAlignment(Pos.CENTER);
		dices.setPadding(new Insets(20));
		
		VBox overallBox=new VBox(overallSore);
		overallBox.setAlignment(Pos.CENTER);
		overallBox.setPadding(new Insets(50, 10,10, 0));
		
		VBox rollBtnBox=new VBox(rollBtn);
		rollBtnBox.setAlignment(Pos.CENTER);
		rollBtnBox.setPadding(new Insets(5));
		
		VBox roundScoreBox=new VBox(roundScore);
		roundScoreBox.setAlignment(Pos.CENTER);
		roundScoreBox.setPadding(new Insets(5));
		
		VBox rollsRemainingBox=new VBox(rollsRemaining);
		rollsRemainingBox.setAlignment(Pos.CENTER);
		rollsRemainingBox.setPadding(new Insets(5));
		
		VBox finalView=new VBox(10, overallBox, dices,rollBtnBox, roundScoreBox,rollsRemainingBox );
		
		
		
    	   dice1.getDiceImage().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			
    		   if(rollNum>=2) {
		    	dice1.setHoldValue();
		    	dice1.setEnable(false);
    		   }
    	   });
		
    	   dice2.getDiceImage().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			
    		   if(rollNum>=2) {
	    		dice2.setHoldValue();
	    		dice2.setEnable(false);
    		   }
    	   });
	
    	   dice3.getDiceImage().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    		   if(rollNum>=2) {
    			   dice3.setHoldValue();
    			   dice3.setEnable(false);
    		   }
    	   });
		
    	   dice4.getDiceImage().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    		   if(rollNum>=2) {
    			   dice4.setHoldValue();
    			   dice4.setEnable(false);
    		   }
    	   });
		
    	   dice5.getDiceImage().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
    		   if(rollNum>=2) {
    			   dice5.setHoldValue();
    			   dice5.setEnable(false);
    		   }
    	   });
	
	
       
		
		rollBtn.setOnAction(event->{
			
			
			rollNum++;
			if(rollNum==5)
			{
				rollBtn.setText("Roll Dice");
				rollNum=1;
				
				 for(int i=0; i<diceList.size();i++)
			     {
		    		 
		    		 diceList.get(i).setValue(1);
		    		 diceList.get(i).setEnable(true);
		    		 
			     }
				score=0;
				
			}
			
			if(rollNum>=2)
			{ 
				for(int i=0;i<sizeOfArray;i++)
				{
					Random rd=new Random();
					int num=rd.nextInt(6)+1;
					if(diceList.get(i).isEnable())
					{
						diceList.get(i).setValue(num);
					}
				
				}
				 			
				diceNum.clear();
			
				for(int i=0;i<sizeOfArray;i++)
				{
				
					int numCheck=diceList.get(i).getValue();
					diceNum.add(numCheck);		
				
				}
			
				Collections.sort(diceNum);			
				//System.out.println("===============New====================");
				//System.out.println(diceNum);
				score=getScore(diceNum);
					
				rollsRemaining.setText("Rolls Remaining: "+(3-rollNum+1));
					
			}
			if(rollNum==4)
			{
				
				if(score==1)
				{
					rollsRemaining.setText("Two of a Kind");
				}
				else if(score==4)
				{
					rollsRemaining.setText("Two Pair");
				}
				else if(score==5)
				{
					rollsRemaining.setText("Three of a Kind");
				}
				else if(score==6)
				{
					rollsRemaining.setText("Full House ");
				}
				else if(score==7)
				{
					rollsRemaining.setText("Four of a Kind");
				}
				else if(score==8)
				{
					rollsRemaining.setText("Straight");
				}
				else if(score==10)
				{
					rollsRemaining.setText("Five of a Kind");
				}
				else
				{
					rollsRemaining.setText("Round Score: 0");
				}
				
				rollBtn.setText("Play Again");
				
				
			}
			
			
			//initial state
			if(rollNum==1)
			{
				
				roundScore.setText("Round Score: 0");
				rollsRemaining.setText("Rolls Remaining: "+(3-rollNum+1));
			}
			else
			{
				roundScore.setText("Your Score: "+score);
				//System.out.println("rollNum: "+rollNum);
				if(rollNum==2) {
					
					rollScore[0]=score;
					
				}
				
				if(rollNum==3) {
					
					
					rollScore[1]=score;
				}
				if(rollNum==4) {
					
					
					rollScore[2]=score;
					
					bestScore=rollScore[0];
					for(int i=1; i<rollScore.length; i++) {
						
						if(bestScore<rollScore[i]) {
							
							bestScore=rollScore[i];
						}
					}
					overallScore=overallScore+bestScore;
					overallSore.setText("Overall Score: "+overallScore);
					
					
				}
				
				
				
			}
			
			
		});
		
		
		Scene myScene =  new Scene(finalView, 1000,520);
		myScene.getStylesheets().add("file:./style/diceStyle.css");
		primaryStage.setScene(myScene);
		primaryStage.setTitle("Dice Game");
		primaryStage.show();
	
	}
	
	private boolean checkStraight(ArrayList<Integer> diceNum)
	{
		boolean isStraight=true;
		 int[] straightAry= {1,2,3,4,5};
	     int[] straightAry2= {2,3,4,5,6};
	     for(int i=0; i<diceNum.size();i++)
	     {
	    	 if(diceNum.get(0).equals(1))
	    	 {
	    		
	    		 if(!diceNum.get(i).equals(straightAry[i]))
		    	 {
		    		 return false;
		    	 }
	    	 }
	    	 else if(diceNum.get(0).equals(2))
	    	 {
	    		
	    		
	    		 if(!diceNum.get(i).equals(straightAry2[i]))
		    	 {
		    		 return false;
		    	 }
	    	 }
	    	 else
	    	 {
	    		 return false;
	    	 }
	     }
	     
		return isStraight;
	}
	private int getScore(ArrayList<Integer> diceNum ) {
	     
		
		 int returnScore=0;
	     int pair=0;
	     int pairIndex=-1;
	     //check for straight
	     if(checkStraight(diceNum))
	     {
	    	 returnScore=8;
	    	 return returnScore;
	     }
	     else//check pair or two pair
	     {
	    	
	    	 for(int i=0; i<(diceNum.size()-1);i++)
		     {
	    		 
	    		//check for one pair
	    		 if(diceNum.get(i).equals(diceNum.get(i+1))) {
	    			 pair++;
	    			 pairIndex=i;
	    			 //System.out.println("pairIndex:"+pairIndex);
	    			 returnScore=1;
	    			 
	    		 }
		     }
	    	
	    	 if(pair==2)
	    	 {
				 //System.out.println("out: pairIndex:"+pairIndex);
				
				 pair=2;
				 returnScore=4;
	    	 }
	    	
	    	
	    	
	    	 //check for three of a kind or a full house
	    	for(int j=0; j<3;j++)
	    	{
	    		if(diceNum.get(j).equals(diceNum.get(j+1))&& diceNum.get(j+1).equals(diceNum.get(j+2)) )
    			{
    				   returnScore=5;
    				   if((j==0 && (diceNum.get(3).equals(diceNum.get(4))))
    					||(j==2 && (diceNum.get(0).equals(diceNum.get(1)))))
    				  {
    					   returnScore=6;
    				  }
    					   
    			 }
	    	
	    	 }
	    	
	    	//check four of a kind
	    	for(int j=0; j<2;j++)
	    	{
	    		if(diceNum.get(j).equals(diceNum.get(j+1))&& diceNum.get(j+1).equals(diceNum.get(j+2))
	    		  && diceNum.get(j+2).equals(diceNum.get(j+3))	
	    				)
    			{
    				   returnScore=7;
    				
    			}
	    	
	    	 }	 
	    	//check five of a kind	 
	    	if(diceNum.get(0).equals(diceNum.get(1))&& diceNum.get(1).equals(diceNum.get(2))
	    		  && diceNum.get(2).equals(diceNum.get(3)) && diceNum.get(3).equals(diceNum.get(4)))
	    	{
	    		returnScore=10;
	    	}
	    		 
		    
	     }
	    
	     return returnScore;
	}

}
