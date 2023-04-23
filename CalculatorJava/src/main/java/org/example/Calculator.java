package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton powButton, cosButton, sinButton, logButton;


    JPanel panel;

    Font myBigFont = new Font("Ink free", Font.BOLD, 20);
    Font mySmallFont = new Font("Ink free", Font.BOLD, 12);
    double num1=0, num2=0, result=0;
    char operator;

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
        logButton = new JButton("log");



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


        for (int i=0; i<9; i++){
            functionButtons[i].setFont(myBigFont);
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i=9; i<13; i++){
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

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

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
            operator = 'p'; //power
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
                case 'p':
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
            num1=result;
        }
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
}