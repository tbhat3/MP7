/**
 * @name        Main Calculator Interface
 * @authors     Tajesvi Bhat and Monica Muthaiya
 * @link        http://github.com/tbhat3
 * 
 * We have created a calculator that can handle the basic operations of addition, multiplication, subtraction, 
 * and division. 
 * Along with that, it can also handle trigonometric functions (sin, cos, tan) as well as square roots and cubics.
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainCalcServer implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JButton but[], butAddition, butSubtraction, butMultiplication, butDivision,
            butEquals, butClear, butSquareRoot, butSquare, butCubic, butExponent,
            butCosine, butSine, butTangent;
    
    private final Calculator mp7calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };
    
//Establish the Calculator framework (size and shape of the device as well as the buttons)
    public MainCalcServer() {
        frame = new JFrame("MP 7 Calculator");
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());
        text = new JTextArea(2, 27);
        but = new JButton[10];
        for (int x = 0; x < 10; x++) {
            but[x] = new JButton(String.valueOf(x));
        }
//create the new calculator, the individual buttons, and assign the buttons their representative signs
//Color of the signs were changed so the basic arithmetic operations were red, the exponentials were blue
//and everything else was a random color chosen from Java.Color
        
        mp7calc = new Calculator();
        
        butAddition = new JButton("+");  
        butAddition.setOpaque(true);
        butAddition.setForeground(Color.red);
        
        butSubtraction = new JButton("-"); 
        butSubtraction.setOpaque(true);
        butSubtraction.setForeground(Color.red);
        
        butMultiplication = new JButton("x");
        butMultiplication.setOpaque(true);
        butMultiplication.setForeground(Color.red);
        
        butDivision = new JButton("÷");
        butDivision.setOpaque(true);
        butDivision.setForeground(Color.red);
        
        butEquals = new JButton("=");
        butEquals.setOpaque(true);
        butEquals.setForeground(Color.green);
        
        butSquareRoot = new JButton("√");
        butSquareRoot.setOpaque(true);
        butSquareRoot.setForeground(Color.blue);
        
        butSquare = new JButton("x^2");
        butSquare.setOpaque(true);
        butSquare.setForeground(Color.blue);
        
        butCubic = new JButton("x^3");    
        butCubic.setOpaque(true);
        butCubic.setForeground(Color.blue);
        
        butExponent = new JButton("2^x");
        butExponent.setOpaque(true);
        butExponent.setForeground(Color.blue);
        
        butCosine = new JButton("Cosine");
        butCosine.setOpaque(true);
        butCosine.setForeground(Color.pink);
        
        butSine = new JButton("Sine");
        butSine.setOpaque(true);
        butSine.setForeground(Color.pink);
        
        butTangent = new JButton("Tangent");
        butTangent.setOpaque(true);
        butTangent.setForeground(Color.pink);
        
        butClear = new JButton("Clear");
        butClear.setBackground(Color.white);     
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(350, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);
        for (int x = 0; x < 10; x++) {
            panel.add(but[x]);
            but[x].addActionListener(this);
        }

        panel.add(butAddition);
        panel.add(butSubtraction);
        panel.add(butMultiplication);
        panel.add(butDivision);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butExponent);
        panel.add(butCubic);
        panel.add(butCosine);
        panel.add(butSine);
        panel.add(butTangent);
        panel.add(butEquals);
        panel.add(butClear);

        butAddition.addActionListener(this);
        butSubtraction.addActionListener(this);
        butMultiplication.addActionListener(this);
        butDivision.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butCubic.addActionListener(this);
        butExponent.addActionListener(this);
        butCosine.addActionListener(this);
        butSine.addActionListener(this);
        butTangent.addActionListener(this);
        butEquals.addActionListener(this);
        butClear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int x = 0; x < 10; x++) {
            if (source == but[x]) {
                text.replaceSelection(buttonValue[x]);
                return;
            }
        }
//identify the function to be used when a specific button is pressed
        if (source == butAddition) {
            setOutput(mp7calc.calculateSimple(Calculator.SimpleOperations.addition, readInput()));
        }
        if (source == butSubtraction) {
            setOutput(mp7calc.calculateSimple(Calculator.SimpleOperations.subtraction, readInput()));
        }
        if (source == butMultiplication) {
            setOutput(mp7calc.calculateSimple(Calculator.SimpleOperations.multiplication,
                readInput()));
        }
        if (source == butDivision) {
            setOutput(mp7calc
                .calculateSimple(Calculator.SimpleOperations.division, readInput()));
        }
        if (source == butSquare) {
            setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.square,
                readInput()));
        }
        if (source == butSquareRoot) {
            setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.squareRoot,
                readInput()));
        }
        if (source == butCubic) {
            setOutput(mp7calc.calculateComplex(
                    Calculator.ComplexOperations.cubic, readInput()));
        }
        if (source == butExponent) {
    			setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.exponent, readInput()));
        }
        if (source == butCosine) {
            setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.cosine,
                readInput()));
        }
        if (source == butSine) {
            setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.sine,
                readInput()));
        }
        if (source == butTangent) {
            setOutput(mp7calc.calculateComplex(Calculator.ComplexOperations.tangent,
                readInput()));
        }
        if (source == butEquals) {
            setOutput(mp7calc.calculateEqual(readInput()));
        }
        if (source == butClear) {
            setOutput(mp7calc.reset());
        }
        text.selectAll();
    }

    public Double readInput() {
        Double input;
        String string = text.getText();
        input = Double.valueOf(string);
        return input;
    }

    public void setOutput(final Double input) {
        if (Double.isNaN(input)) {
            text.setText("");
        } else {
            text.setText(Double.toString(input));
        }
    }
}
