/**
 * @name        Calculator
 * @authors     Tajesvi Bhat and Monica Muthaiya
 * @link        http://github.com/tbhat3
 * 
 * We have created a calculator that can handle the basic operations of addition, multiplication, subtraction, 
 * and division. 
 * Along with that, it can also handle trigonometric functions (sin, cos, tan) as well as square roots and cubics.
 */
public class Calculator {
		
//This enum will handle basic arithmetic
	    public enum SimpleOperations {
	        normal, addition, subtraction, multiplication, division
	    }
//This enum will handle more advanced operations
	    public enum ComplexOperations {
	        square, squareRoot, cubic, cosine, sine, tangent, exponent
	    }


	    private Double firstInput, secondInput;
	    private SimpleOperations mode = SimpleOperations.normal;

//This method handles the execution of the basic arithmetic operations listed as enums above
	    private Double basicCalculations() {
	        if (mode == SimpleOperations.normal) {
	            return secondInput;
	        }
	        if (mode == SimpleOperations.addition) {
	            return firstInput + secondInput;
	        }
	        if (mode == SimpleOperations.subtraction) {
	            return firstInput - secondInput;
	        }
	        if (mode == SimpleOperations.multiplication) {
	            return firstInput * secondInput;
	        }
	        if (mode == SimpleOperations.division) {
	            return firstInput / secondInput;
	        }
	        //an error is thrown if user does not provide mathematically correct inputs
	        throw new Error();
	    }
	    
//this method handles the execution of the complex operations listed as enums above
	    public Double calculateComplex(ComplexOperations newMode, Double input) {
	        if (newMode == ComplexOperations.square) {
	            return input * input;
	        }
	        if (newMode == ComplexOperations.squareRoot) {
	            return Math.sqrt(input);
	        }
	        if (newMode == ComplexOperations.exponent) {
        			return Math.pow(2, input);
	        }
	        if (newMode == ComplexOperations.cubic) {
	            return input * input * input;
	        }
	        if (newMode == ComplexOperations.cosine) {
	            return Math.cos(input);
	        }
	        if (newMode == ComplexOperations.sine) {
	            return Math.sin(input);
	        }
	        if (newMode == ComplexOperations.tangent) {
	            return Math.tan(input);
	        }
	        throw new Error();
	    }

	    public Double calculateSimple(SimpleOperations newMode, Double number) {
	        if (mode == SimpleOperations.normal) {
	            secondInput = 0.0;
	            firstInput = number;
	            mode = newMode;
	            return Double.NaN;
	        } else {
	            secondInput = number;
	            firstInput = basicCalculations();
	            mode = newMode;
	            return firstInput;
	        }
	    }
	    

	    public Double reset() {
	        secondInput = 0.0;
	        firstInput = 0.0;
	        mode = SimpleOperations.normal;
	        return Double.NaN;
	    }
	    
//returns the value of the calculation if inputs are valid
	    public Double calculateEqual(Double num) {
	        return calculateSimple(SimpleOperations.normal, num);
	    }
	   
	}

