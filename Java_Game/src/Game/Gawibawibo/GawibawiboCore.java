package Game.Gawibawibo;

import java.util.Random;
import java.util.Scanner;


import Game.I2DGame;

public class GawibawiboCore implements I2DGame
{
	// string table
	String menuString = new String(); 
	String errorCode = "Wrong Input."; 

	enum Simbol
	{
		None,
		Rock ,
		Scissors,
		Paper
	};
	
	//flags
	boolean endFlag = false; 
	boolean roundEndFlag = false; 
	boolean allowContinueFlag = true; // allow restart New Game flag. if true ask restart game when round finished.

	//Const menu names
	final int FrontMenu = 0; 
	final int PlayMenu = 1; 
	final int EndMenu = 2; 
	final int Win = 1;
	final int Draw = 0;
	final int Lose = -1;

	//base info
	private Simbol comPickedSimbol = Simbol.None;
	private Simbol playerPickedSimbol = Simbol.None;
	private int winCount = 0;

	//game stage
	private int currentPage = -1; 

	//needed function
	Random rand = new Random(); 
	Scanner scan = new Scanner(System.in ); 

	//redirection method
	void LineOut(String _line)
	{
		System.out.print(_line ); 
	}
	void NewLineOut(String _line)
	{
		System.out.println(_line ); 
	}

	/*return value base by _playerA 
	lose  -1
	draw  0
	win 1
	*/
	int IsWin(Simbol _playerA, Simbol _playerB)
	{

		if(_playerA == _playerB)
		{
			return this.Draw;
		}
		else
		{
			switch(_playerA)
			{
				case Rock :
				{
					if(_playerB == Simbol.Paper)
					{
						return this.Lose;
					}
					else //scissors
					{
						return this.Win;
					}
				}

				case Scissors :
				{
					if(_playerB == Simbol.Paper)
					{
						return this.Win;
					}
					else // rock
					{
						return this.Lose;
					}
				}

				case Paper :
				{
					if(_playerB == Simbol.Scissors)
					{
						return this.Lose;
					}
					else
					{
						return this.Win;
					}
				}
				
				default:
				{
					return -2; //error code;
				}
			}
		}		
	}

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
							this.comPickedSimbol = Simbol.values()[ this.rand.nextInt(3)+1];		
							this.playerPickedSimbol = Simbol.None;

							this.LineOut(this.menuString); 		
							
							if (scan.hasNextInt() == false)
							{
								this.NewLineOut(this.errorCode); 
								scan.nextLine();
								continue; 
							}
							else
							{							
								int playerPickedIndex =  scan.nextInt(); 	
								if ((playerPickedIndex> 0 && playerPickedIndex <= 3) == false)
								{
									this.NewLineOut(this.errorCode); 
									this.NewLineOut(("Please Pick On Between 1 to 3.")); 									
									continue; 
								}
								else
								{
									this.playerPickedSimbol = Simbol.values()[playerPickedIndex];
									int result = IsWin(this.playerPickedSimbol ,this.comPickedSimbol );

									NewLineOut("Computer Picked " + this.comPickedSimbol + " and You Picked " + this.playerPickedSimbol);									

									switch(result)
									{
										case Win:
										{											
											NewLineOut("You Win");
											this.winCount++;											
											this.SwapPage(this.EndMenu);
										}
										break;

										case Lose:
										{
											NewLineOut("You Lose");																					
											this.SwapPage(this.EndMenu);
										}
										break;

										case Draw:
										{
											NewLineOut("Draw");																					
											this.SwapPage(this.EndMenu);
										}
										break;
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
										LineOut("Win Count : " + this.winCount);
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
				this.menuString = "Computer was Picked. Now, Your turn. Whick one?\n1)Rock, 2)Scissors, 3)Paper : "; 
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

	@Override
	public boolean Stop()
	{
		this.endFlag = true; 
		
		return this.endFlag; 
	}

}
