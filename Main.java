import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        out.println("Random success is where we thrive!");

        // Adding some randomness, because otherwise it's boring
        Random rand = new Random();

        //Images for winning or losing
        ImageIcon win = new ImageIcon("src/win.png");
        ImageIcon lose = new ImageIcon("src/lose.png");

        // Creates window + stops code on closing of window
        JFrame window = new JFrame("Trying for SUCCESS");
        window.setSize(800,  400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        // Panels for the buttons
        JPanel successPanel = new JPanel(new BorderLayout());
        JPanel failurePanel = new JPanel(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Take your pick, however, you may be surprised the more you play.");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));


        // Label for "You won!"
        JLabel successLabel = new JLabel("You won");
        successLabel.setVisible(false);
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Label for "You lost!"
        JLabel failureLabel = new JLabel("You lost");
        failureLabel.setVisible(false);
        failureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        failureLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Success Button
        JButton successButton = new JButton("Press to win!");
        successButton.addActionListener(e -> {
            int chance = rand.nextInt(100);
            if (chance < 90) {
                System.out.println("You won!");
                successLabel.setText("You won!");
                successLabel.setIcon(win);
            } else {
                System.out.println("You lost!");
                successLabel.setText("You lost!");
                successLabel.setIcon(lose);
            }
            successLabel.setVisible(true);
        });
        successButton.setPreferredSize(new Dimension(150, 45));


        // Failure Button
        JButton failureButton = new JButton("Press to lose!");
        failureButton.addActionListener(e -> {
            int chance = rand.nextInt(100);
            if (chance < 90) {
                System.out.println("You lost!");
                failureLabel.setText("You lost!");
                failureLabel.setIcon(lose);
            } else {
                System.out.println("You won!");
                failureLabel.setText("You won!");
                failureLabel.setIcon(win);
            }
            failureLabel.setVisible(true);
        });
        failureButton.setPreferredSize(new Dimension(150, 45));


        successPanel.add(successButton, BorderLayout.NORTH);
        successPanel.add(successLabel, BorderLayout.CENTER);

        failurePanel.add(failureButton, BorderLayout.NORTH);
        failurePanel.add(failureLabel, BorderLayout.CENTER);

        window.add(headerLabel, BorderLayout.NORTH);
        window.add(successPanel, BorderLayout.WEST);
        window.add(failurePanel, BorderLayout.EAST);


        window.setVisible(true);
    }
}