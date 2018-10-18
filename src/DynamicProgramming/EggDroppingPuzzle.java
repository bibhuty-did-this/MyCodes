package DynamicProgramming;

public class EggDroppingPuzzle{
	public static void main(String args[]){
		System.out.println(eggDroppingProblem(2,4));
	}
	public static int eggDroppingProblem(int eggs,int floors){
		debug(eggs,floors);
		if(floors==0 || floors==1){
			debug(eggs,floors,floors);
			return floors;
		}

		if(eggs==1){
			debug(eggs,floors,floors);
			return floors;
		}
		int minimumAttempt=Integer.MAX_VALUE;

		for(int dropFloor=1;dropFloor<=floors;++dropFloor){
			System.out.println("Eggs ~ Floors ~ Iteration");
			System.out.println(eggs+" ~ "+ floors+" ~ "+dropFloor);
			System.out.println("Case where egg does break");
			int eggBreaks=eggDroppingProblem(eggs-1,floors-1);
			System.out.println("Case where egg doesn't break");
			int noEggBreaks=eggDroppingProblem(eggs,floors-dropFloor);
			int result=Math.max(eggBreaks,noEggBreaks);
			minimumAttempt=Math.min(minimumAttempt,result);
		}

		debug(eggs,floors,minimumAttempt+1);
		return minimumAttempt+1;
	}
	public static void debug(int eggs,int floors){
		System.out.println("Into the recursion of "+ eggs+ " eggs and "+ floors+" floors");
	}
	public static void debug(int eggs,int floors,int result){
		System.out.println("Into the recursion of "+ eggs+ " eggs and "+ floors+" floors"+ " returning the result "+result);
	}
}