import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[]options;
    private JLabel submitButton;
    private JLabel timerLabel;
    //Add timer Label
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private String [] questions={"what is the capital of france?","What is 2 + 2 =?","what is largest planet in our solar system?"};
    private String [][] choices = {
            {"Berlin", "Madrid", "paris", "Rome"}, {"3", "4", "5", "6"}, {"Earth", "jupiter", "Mars", "venus"}
    };
    private int[] correctAnswers={2,1,1};
    public QuizApplication(){
        setTitle("Quiz Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,300);
        setLayout(new BorderLayout());
        questionLabel = new JLabel();
        add(questionLabel,BorderLayout.NORTH);
        JPanel optionsPanel = new JPanel(new GridLayout(4,1));
       options = new JRadioButton[4];
       ButtonGroup buttonGroup = new ButtonGroup();
       for(int i = 0;i<4;i++){
           options[i]=new JRadioButton();
           options[i].setText(choices[currentQuestionIndex][i]);
           buttonGroup.add(options[i]);
           optionsPanel.add(options[i]);

       }
       add(optionsPanel,BorderLayout.CENTER);
       submitButton = new JLabel("Submit");
       add(submitButton,BorderLayout.SOUTH);
      // submitButton.addAncestorListener(new ActionListener() {

           // @Override
           // public void actionPerformed(ActionEvent e) {
                //checkAnswer();
               // showNextQuestion();
           // }
       // });

       timerLabel = new JLabel();
       add(timerLabel,BorderLayout.EAST);
       // add the timer label
        currentQuestionIndex = 0;
        showQuestions();
        startTimer();
       }
       private void showQuestions(){
        questionLabel.setText(questions[currentQuestionIndex]);
        for(int i = 0;i<4;i++){
            options[i].setText(choices[currentQuestionIndex][i]);
            options[i].setSelected(false);
        }
    }
    private void showNextQuestion(){
        currentQuestionIndex++;
        if(currentQuestionIndex<questions.length){
            showQuestions();
            resetTimer();

        }else{
            showResult();
        }
    }
    private void checkAnswer(){
        for(int i = 0;i<4;i++)
            if (options[i].isSelected() && i == correctAnswers[currentQuestionIndex]) {
                score++;
            }
    }
    private void showResult() {
        JOptionPane.showMessageDialog(this, "QUIZ COMPLETED!\nScore: " + score+" / " + questions.length);
        System.exit(0);
    }
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft >= 0) {
                    timerLabel.setText("Timer Left! " + secondsLeft + " seconds");
                    secondsLeft--;
                } else timer.stop();
                checkAnswer();
                showNextQuestion();
            }
        });
        timer.start();
    }

            private int secondsLeft = 15;

     private void resetTimer(){
         timer.stop();
         startTimer();


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApplication().setVisible(true);
            }
        });
    }

}
