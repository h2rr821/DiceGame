package dice;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice {
	
	
	private ImageView diceImage; 
	private int value;
	private boolean enable;
	public Dice()
	{
		diceImage=new ImageView(new Image("file:./DiceImages/Dice1.png"));
		diceImage.setPreserveRatio(true);
		diceImage.setFitWidth(150);
	    value=1;
	    enable=true;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public ImageView getDiceImage() {
		return diceImage;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
		if(value==1)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice1.png"));
		}
		if(value==2)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice2.png"));
		}
		if(value==3)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice3.png"));
		}
		if(value==4)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice4.png"));
		}
		if(value==5)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice5.png"));
		}
		if(value==6)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice6.png"));
		}
		
		
	}
	
	public void setHoldValue() {
	
		if(this.value==1)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice1Held.png"));
		}
		if(this.value==2)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice2Held.png"));
		}
		if(this.value==3)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice3Held.png"));
		}
		if(this.value==4)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice4Held.png"));
		}
		if(this.value==5)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice5Held.png"));
		}
		if(this.value==6)
		{
			diceImage.setImage(new Image("file:./DiceImages/Dice6Held.png"));
		}
	
	

	}
	
}
