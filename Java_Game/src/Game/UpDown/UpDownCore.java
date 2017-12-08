package Game.UpDown; 

import java.util.Random; 
import java.util.Scanner;


import Game.I2DGame; 

public class UpDownCore implements I2DGame
{
	// string table
	String menuString = new String(); 
	String roundString = new String(); 
	String errorCode = "Wrong Input."; 
	String roundErrorCode = "That number is Out Of Range"; 

	//base info
	private int comPickedNumber = -1; 
	private int playerPickedNumber = -1; 	
	private int minValue, maxValue = 0; 
	private int maximumRange = 100; // default

	//flags
	boolean endFlag = false; 
	boolean roundEndFlag = false; 
	boolean allowContinueFlag = true; // allow restart New Game flag. if true ask restart game when round finished.

	//game stage
	private int currentPage = -1; 

	//needed function
	Random rand = new Random(); 
	Scanner scan = new Scanner(System.in ); 

	//Const menu names
	final int FrontMenu = 0; 
	final int PlayMenu = 1; 
	final int EndMenu = 2; 

	//redirection method
	void LineOut(String _line)
	{
		System.out.print(_line ); 
	}
	void NewLineOut(String _line)
	{
		System.out.println(_line ); 
	}

	void ReflashRoundString()
	{
		this.roundString = "Select Single Number Between " + this.minValue +" to " + this.maxValue + ". : "; 
	}

	//Override interface method
	@Override
	public boolean Play()
	{
		this.SwapPage(FrontMenu); 

		while (this.endFlag != true)
		{
			
			switch (this.currentPage)
			{
				case FrontMenu:
				{	
					this.LineOut((this.menuString)); 		
					
					if (scan.hasNextInt() == false)
					{
						this.NewLineOut(this.errorCode); 
						scan.nextLine();
						continue; 
					}
					else				
					{
						boolean swapPageResult = SwapPage(scan.nextInt()); 

						if (swapPageResult == false)
						{
							this.NewLineOut(this.errorCode); 			
							continue; 							
						}
					}
				}
				break; 

				case PlayMenu:
				{
					this.comPickedNumber = rand.nextInt(this.maximumRange) + 1; 
					this.minValue = 1; 
					this.maxValue = this.maximumRange; 
					this.roundEndFlag = false; 		

					while (this.roundEndFlag != true)
					{
						this.ReflashRoundString();
						this.LineOut(this.roundString); 		
						
						if (scan.hasNextInt() == false)
						{
							this.NewLineOut(this.errorCode); 
							scan.nextLine();
							continue; 
						}
						else
						{								
							this.playerPickedNumber = scan.nextInt(); 
							if ((this.playerPickedNumber > minValue && this.playerPickedNumber <= maxValue) == false)
							{
								this.NewLineOut(this.roundErrorCode); 
								this.NewLineOut(("Please Pick On Between " + minValue + " to " + maxValue + ".")); 
								this.playerPickedNumber = -1; 
								continue; 
							}
							else
							{
								if (this.comPickedNumber == this.playerPickedNumber)
								{
									NewLineOut("Currect!"); 
									this.roundEndFlag = true; 
								
									this.SwapPage(this.EndMenu); 	
								}
								else if (this.comPickedNumber > this.playerPickedNumber)
								{
								 this.	NewLineOut("Up!"); 
									this.minValue = this.playerPickedNumber; 
									this.playerPickedNumber = -1; 
								}
								else
								{
									this.	NewLineOut("Down!"); 
									this.maxValue = this.playerPickedNumber; 
									this.playerPickedNumber = -1; 
								}
							}						
						}						
					}
				}
				break; 

				case EndMenu:
				{
					this.LineOut((this.menuString)); 		
					
					if(this.allowContinueFlag == true)
					{						
						String inputKey = scan.next(); 
						inputKey = inputKey.replace(" ", ""); 
						inputKey = inputKey.toUpperCase(); 

						if(inputKey .length() != 1)
						{
							this.NewLineOut(this.errorCode); 

						}	
						else
						{
							if (inputKey.contains( "Y" ) )
							{
								this.SwapPage(this.PlayMenu); 
							}
							else if (inputKey.contains( "N" ))
							{
								this.Stop(); 
							}
							else
							{
								this.NewLineOut(this.errorCode); 
							}
						}
					}
					else
					{
						this.Stop();
					}
				}
				break; 
			}
		}

		return true; 
	}

	@Override
	public boolean Stop()
	{
		this.endFlag = true; 
		
		return this.endFlag; 
	}

	@Override
	public boolean SwapPage(int _nextPage)
	{

		switch (_nextPage)
			{
			case FrontMenu:
				{
					this.currentPage = FrontMenu; 			
					this.menuString = "===Menu===\n1.Start\n2.Quit\nSelect : "; 				
				}
				return true; 

			case PlayMenu:
				{
					this.currentPage = PlayMenu; 				
					//this.menuString = "Select Single Number Between 1 to " + this.maximumRange + ". : "; 
				}
				return true; 

			case EndMenu:
				{
					this.currentPage = EndMenu; 
					if(this.allowContinueFlag == true)
					{
						this.menuString = "Restart New Game? [Y/N] : "; 
					}
					else
					{
						this.menuString = "Game is Done\n";
					}					
				}
				return true; 

			default:			
				return false; 
			}
	}
}
