package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Calculator implements ActionListener {

    /**
     * declaring Swing units, and buttons for GUI
     */
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton powButton, cosButton, sinButton, logButton;


    JPanel panel;

    /**
     * setting fonts: Big font - for numbers and usual operations
     * small font for sin, cos, ln
     */
    Font myBigFont = new Font("Ink free", Font.BOLD, 20);
    Font mySmallFont = new Font("Ink free", Font.BOLD, 12);
    double num1=0, num2=0, result=0;
    char operator;


    /**
     * Constructor:
     *          sets frame
     *          puts buttons
     *          look-n-feel of the applications,
     *          no functionality
     */
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 380, 50);
        textField.setFont(myBigFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
        powButton = new JButton("^");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        logButton = new JButton("ln");



        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = powButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = cosButton;
        functionButtons[12] = logButton;


        for (int i=0; i<10; i++){
            functionButtons[i].setFont(myBigFont);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i=10; i<13; i++){
            functionButtons[i].setFont(mySmallFont);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myBigFont);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 150, 50);
        clrButton.setBounds(300, 430, 130, 50);

        panel = new JPanel();
        panel.setBounds(50,100,380,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(powButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(sinButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(cosButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(logButton);




        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    /**
     * actionPerformed function:
     *                  logic and functionality of the project
     *                  calculations depending on the operation
     *                  after clicking the operation button, the input field is cleaned
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '^'; //power
            textField.setText("");
        }
        if (e.getSource() == sinButton){
            operator = 's'; //sin
            textField.setText("");
        }
        if (e.getSource() == cosButton){
            operator = 'c'; //cos
            textField.setText("");
        }
        if (e.getSource() == logButton){
            operator = 'l'; //base e log
            textField.setText("");
        }
        if (e.getSource()==equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;
                case 's':
                    result = Math.sin(num2);
                    break;
                case 'c':
                    result = Math.cos(num2);
                    break;
                case 'l':
                    result = Math.log(num2);
                    break;
            }
            textField.setText(String.valueOf(result));

            /**
             * writing the equations to file
             * concatenated to the file: CalculationResults.txt
             */
            try {
                FileWriter resultsFile = new FileWriter("CalculationResults.txt", true);
                if (operator != 's' && operator != 'c'  && operator != 'l' ){
                    resultsFile.append(num1 + " " + operator + " " + num2 + " = "  + result + "\n");
                } else if (operator == 's') {
                    resultsFile.append("sin" + " " + num2 + " = "  + result + "\n");
                } else if (operator == 'c') {
                    resultsFile.append("cos" + " " + num2 + " = "  + result + "\n");
                } else if (operator == 'l') {
                    resultsFile.append("ln" + " " + num2 + " = "  + result + "\n");
                }

                resultsFile.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            num1=result;
        }
        /**
         * special buttons: Clear, Delete, Negate
         */
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String string  = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

    }

    /**
     * Getters and Setters
     * @return
     */

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}