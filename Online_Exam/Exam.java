//Online Exam - task 4 - Oasis infobyte - Archita bhattad

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask; 
class login extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel , label;  
    final JTextField  textField1, textField2;  
    login()  
    {       
        userLabel = new JLabel();  
        userLabel.setText("    Username :");      
        textField1 = new JTextField(15);      
        passLabel = new JLabel();  
        passLabel.setText("    Password :");        
        textField2 = new JPasswordField(8);     
        b1 = new JButton("   SUBMIT   ");  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);     
        newPanel.add(textField1);  
        newPanel.add(passLabel);    
        newPanel.add(textField2);   
        newPanel.add(b1);          
        add(newPanel, BorderLayout.CENTER);  
        b1.addActionListener(this);    
        setTitle("Login Form ");         
    }   
    public void actionPerformed(ActionEvent ae)     
    {  
        String userValue = textField1.getText();        
        String passValue = textField2.getText();       
        if(!passValue.equals(""))
            new TestBegin(userValue); 
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }     
}  
class TestBegin extends JFrame implements ActionListener  
{
    JLabel l;  
    JLabel l1;  
    JRadioButton jb[]=new JRadioButton[6];  
    JButton b1,b2,log;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    Timer timer = new Timer();  
    TestBegin(String s)  
    {      
        super(s); 
        l=new JLabel();
        l1 = new JLabel();  
        add(l);
        add(l1);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Save and Next");  
        b2=new JButton("Save for later");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(95,240,140,30);  
        b2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);     
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 120;
            public void run() {  
                l1.setText("Time left: " + i);
                i--;   
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");                     
                } 
            }
        }, 0, 1000);        
    }  
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==4)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Save for later"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(500,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==4)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Score ="+count+"/5");  
            System.exit(0);  
        }  
    }  
    void set()  
    {   
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("1: Grand Central Terminal, Park Avenue, New York is the world's?");  
            jb[0].setText("largest railway station");jb[1].setText("highest railway station");jb[2].setText("longest railway station");jb[3].setText("None of the above");   
        }  
        if(current==1)  
        {  
            l.setText("2: Entomology is the science that studies?");  
            jb[0].setText("Behavior of human beings");jb[1].setText("Insects");jb[2].setText("The origin and history of technical and scientific terms");jb[3].setText("The formation of rocks");  
        }  
        if(current==2)  
        {  
            l.setText("3: Eritrea, which became the 182nd member of the UN in 1993, is in the continent of?");  
            jb[0].setText("Asia");jb[1].setText("Africa ");jb[2].setText("Europe");jb[3].setText("Australia");  
        }  
        if(current==3)  
        {  
            l.setText("4: Garampani sanctuary is located at ?");  
            jb[0].setText("Junagarh, Gujarat");jb[1].setText("Diphu, Assam");jb[2].setText("Kohima, Nagaland");jb[3].setText("Gangtok, Sikkim");  
        }  
        if(current==4)  
        {  
            l.setText("5: For which of the following disciplines is Nobel Prize awarded?");  
            jb[0].setText("Physics and Chemistry");jb[1].setText("Physiology or Medicine");jb[2].setText("Literature, Peace and Economics");jb[3].setText("All of the above");  
        }   
        l.setBounds(30,40,600,40);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        return false;  
    }    
} 
class Exam  
{  
    public static void main(String args[])  
    {  
        try  
        {  
            login form = new login();  
            form.setSize(400,150);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 