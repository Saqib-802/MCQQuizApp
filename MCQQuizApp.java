
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class MCQQuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private ButtonGroup optionGroup;

    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the 'Red Planet'?",
            "What is the largest mammal?",
    };

    private String[][] choices = {
            { "Paris", "London", "Berlin", "Madrid" },
            { "Mars", "Jupiter", "Venus", "Saturn" },
            { "Blue Whale", "Elephant", "Giraffe", "Lion" },
    };

    private int currentQuestionIndex = 0;

    public MCQQuizApp() {
        setTitle("MCQ Quiz App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questionLabel = new JLabel(questions[currentQuestionIndex]);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(choices[currentQuestionIndex][i]);
            optionGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optionGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(MCQQuizApp.this, "Please select an option.");
                } else {
                    if (currentQuestionIndex < questions.length - 1) {
                        currentQuestionIndex++;
                        updateQuestion();
                    } else {
                        JOptionPane.showMessageDialog(MCQQuizApp.this, "Quiz completed!");
                        System.exit(0);
                    }
                }
            }
        });
        add(nextButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        for (int i = 0; i < 4; i++) {
            options[i].setText(choices[currentQuestionIndex][i]);
            options[i].setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MCQQuizApp());
    }
}