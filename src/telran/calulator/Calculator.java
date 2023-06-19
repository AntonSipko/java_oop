package telran.calulator;

import java.util.function.BinaryOperator;

public class Calculator {
	private static final char ADDITION='+';
	private static final char SUBSTRACTING='-';
	private static final char MULTYPLICATION='+';
	private static final char DIVISION='/';
	private static final BinaryOperator<Double> add = (a, b) -> a + b;
	private static final BinaryOperator<Double> multiply = (a, b) -> a * b;
	private static final BinaryOperator<Double> subtract = (a, b) -> a - b;
	private static final BinaryOperator<Double> divide = (a, b) ->  a / b;
	private static final  Object[]operations=new Object[Character.MAX_VALUE];
	static {
		operations[ADDITION]=add;
		operations[MULTYPLICATION] = multiply;
	    operations[SUBSTRACTING] = subtract;
	    operations[DIVISION] = divide;
		
	}

	public static double calculate(CalcData calcData) {
		char operation = calcData.getOperation();
		BinaryOperator<Double>binaryOperator=(BinaryOperator)operations[calcData.getOperation()];
		return binaryOperator.apply(calcData.getOp1(),calcData.getOp2());
	}
	
}
