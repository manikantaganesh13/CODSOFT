import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class WordCounter {
    public static void main(String[] args){
        JFrame f;
        JLabel heading,l1,l2,l3;
        JTextArea ta;
        JButton submit,clear;

        Font font = new Font(Font.SANS_SERIF,Font.BOLD, 17);
        Font font1 = new Font(Font.SANS_SERIF,Font.PLAIN,14);

        f = new JFrame("Word Counter");
        heading = new JLabel("Task 2 Of CODSOFT Java Programming Internship");
        l1 = new JLabel("Enter the text: ");
        ta = new JTextArea();
        submit = new JButton("Submit");
        l2 = new JLabel("Number of words: ");
        l3 = new JLabel("Number of unique words: ");
        clear = new JButton("Clear");

        heading.setFont(font);
        l1.setFont(font1);
        l2.setFont(font1);
        l3.setFont(font1);

        heading.setBounds(40,10,450,30);
        l1.setBounds(40,40,100,30);
        ta.setBounds(40,70,450,230);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        l2.setBounds(40,300,400,30);
        l3.setBounds(40,330,400,30);
        submit.setBounds(120,400,90,40);
        clear.setBounds(280,400,90,40);

        f.add(heading);
        f.add(l1);
        f.add(ta);
        f.add(l2);
        f.add(l3);
        f.add(submit);
        f.add(clear);

       submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int word_count = 0,unique_words = 0;
                String str = ta.getText();
                String[] words = str.trim().split("[\\s\\p{Punct}]+");

                HashMap<String,Integer> map = new HashMap<>();

                for(String s : words){
                    map.put(s,map.getOrDefault(s,0)+1);
                    word_count++;
                }

                l2.setText("Number of words: "+word_count);

                for(String s:map.keySet()){
                    if(map.get(s)==1)
                        unique_words++;
                }
                l3.setText("Number of unique words: "+unique_words);
            }
       });

       clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ta.setText("");
                l2.setText("Number of words: ");
                l3.setText("Number of unique words: ");
            }
       });

        f.setSize(530,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

}
