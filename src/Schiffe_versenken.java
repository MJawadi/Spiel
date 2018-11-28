import java.util.*;
public class Schiffe_versenken {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
		while(true) {
			
			System.out.print("1 . Start game.\n2 . Quit the game.\n-->: ");
			int choose = scan.nextInt();
			if(choose==2) {
				scan.close();
				break;
			}
			if(choose==1) {
				int dif = 0;
				System.out.print("Set the difficulty \n1 . Easy \n2 . Normal \n3 . hard \n4 . Extreme \n-->: ");
				choose = scan.nextInt();
				if(choose<1 || choose>4) {
					System.out.println("Error!! choose right number!!");
					choose = scan.nextInt();
				}else {
					int win = 0;
					if(choose==1) {
						dif = 7;
						win = 5;
					}
					if(choose==2) {
						dif = 5;
						win = 4;
					}
					if(choose==3) {
						dif = 3;
						win = 2;
					}
					if(choose==4) {
						dif = 1;
						win = 1;
					}
					System.out.println("\nThe number of enemy's ships are "+dif+" \nSink "+win+" enemy ships to win the game.");
					int[][] myShips = new int[6][6];
					int[][] enemyShips = new int[6][6];
					randomCoordinate(myShips, dif);
					randomCoordinate(enemyShips, dif);
					int enemyShot = 0;
					int myShots = 0;
					int count= 0;
					int[][] coordinates = new int[6][6];
					int[][] enemyCoordinates = new int[6][6];
					while(true) {
						count++;
						if(count!=10) {
							boolean hit = false;
							getCoordinate(coordinates, true);
							if(cheacking(hit, enemyShips, coordinates)==true) {
								myShots++;
								if(myShots == win) {
									System.out.println("You have won!!!");
									break;
								}
							}
							getCoordinate(enemyCoordinates, false);
							print(enemyShips, myShips, coordinates, enemyCoordinates);
							if(cheacking(hit, myShips, enemyCoordinates)==true) {
								enemyShot++;
								if(enemyShot == win) {
									System.out.println("Enemy won!! You lost!!");
									break;
								}
							}
							
						}else {
							if(myShots>enemyShot) {
								System.out.println("You've won!!");
							}
							if(myShots<enemyShot) {
								System.out.println("Enemy've won");
							}
							if(myShots==enemyShot) {
								System.out.println("It's a draw!!!");
							}
							break;
						}
					}
				}
			}
		}

	}
	
	
	public static int[][] randomCoordinate(int[][] ship, int numOfShips) {
		
		Random rn = new Random();
		
		for(int b=1; b<=numOfShips; b++) {
			int x = rn.nextInt(6);
			int y = rn.nextInt(6);
			if(ship[y][x]!=1) {
				ship[y][x]=1;
			}else {
				b--;
			}
		}
		
		return ship;
	}
	
	
	
	
	public static boolean cheacking(boolean result, int[][] shipsPosition, int[][] shot){
		
		for(int x=0; x<shipsPosition.length; x++) {
			for(int y=0; y<shot.length; y++) {
				if(shipsPosition[x][y]==1 && shot[x][y]==1) {
					result = true;
				}
			}
		}
		return result;
	}
	
	
	
	
	
	public static void print(int[][] enemyList, int[][] myList, int[][] myShots, int[][] enemyShot){
		
		int set=6;
		System.out.println("\n     Enemy's Ships             y             My Ships");
		for(int x=5; x>=0; x--) {
			for(int y=5; y>=0; y--) {
				if(enemyList[x][y]==1 && myShots[x][y]==1) {
					System.out.print("   "+"T");
				}else{
					if(myShots[x][y]==1) {
						System.out.print("   "+"F");
					}else {
						System.out.print("   "+"0");
					}
				}
			}
			System.out.print("      |"+set+"|  ");
			set--;
			for(int j=0; j<6; j++) {
				if(myList[x][j]==1 && enemyShot[x][j]==1) {
					System.out.print("   "+"T");
				}else{
					if(enemyShot[x][j]==1) {
						System.out.print("   "+"F");
					}else {
						if(myList[x][j]==1) {
							System.out.print("   "+"S");
						}else {
							System.out.print("   "+"0");
						}
					}
				}
			}
			System.out.print("\n");
		}
		System.out.println("   6___5___4___3___2___1______<x>_____1___2___3___4___5___6");
	}
	
	
	
	
	
	public static int[][] getCoordinate(int[][] list, boolean person){
		
		Random rn = new Random();
		
		if(person==true) {
			System.out.print("\nGive the coordinate for X: ");
			int x = scan.nextInt();
			while(true) {
				if(x<1 || x>6) {
					System.out.println("Error!!! Number is out of bound");
					System.out.print("\nGave the coordinate for X: ");
					x = scan.nextInt();
				}else {
					break;
				}
			}
			System.out.print("Gave the coordinate for Y: ");
			int y = scan.nextInt();
			while(true) {
				if(y<1 || y>6) {
					System.out.println("Error!!! Number is out of bound");
					System.out.print("\nGave the coordinate for Y: ");
					y = scan.nextInt();
				}else {
					break;
				}
			}
			list[y-1][x-1] = 1;
		}
		if(person==false) {
			int x = rn.nextInt(6);
			int y = rn.nextInt(6);
			list[y][x] = 1;
		}
		
		return list;
	}
	
	
}

