import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

//MADE change the graphics of the Terms and Conditions and Spammer.
//MADE add the menu to change the themes
//TODO add NORMIE THEME to the menu!!!!


public class Spammer extends JFrame implements ActionListener{
   public JPanel panel;
   public JLabel LabelText,LabelAmount;
   public JTextField TextFieldText, TextFieldAmount;
   public JButton ButtonSpam;
   public JLabel LabelTitle;
   public ImageIcon icon = new ImageIcon("./res/logo.png");
   public JTextArea TextArea1 = new JTextArea();
   public JScrollPane scroll = new JScrollPane();
   private static File file = new File("./res/music.wav");
   public AudioInputStream twitch;  
   public Robot robot;
   public Clip clip;
   
   //MENU BAR START
   private JMenuBar menuBar;
   private JMenu MenuSettings;
   private JMenu MenuTheme;
   private JMenu MenuOther;
   private JMenuItem MenuItemExit;
   private JMenuItem MenuItemSpamBoy,MenuItemSpammer, MenuItemCheesy, MenuItemPipBoy,MenuItemRayndia,MenuItemJosue,MenuItemNormie;
   //MENU BAR END
   Menu startMenu = new Menu();
    
   public Spammer(){
      this.setSize(400,550);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setTitle("Spam-Machine | Spammer");
      this.setResizable(false);
      this.setIconImage(icon.getImage());
      this.setLocationRelativeTo(null);
      
      addStuff();
      spamBoyTheme();
   }
   
   public void addStuff(){
      addPanel();
      addLabel();
      addTextField();
      addButton();
      addTextArea();
      addMenuBar();
      
   }
   
   private void addPanel(){
      panel = new JPanel();
      panel.setLayout(null);
      
      this.getContentPane().add(panel);
   }
   
   private void addLabel(){
      LabelText = new JLabel();
      LabelAmount = new JLabel();
      LabelTitle = new JLabel();
      
      LabelTitle.setText("Spam-Machine");
      LabelTitle.setOpaque(true);
      LabelTitle.setBackground(Color.RED);
      LabelTitle.setBounds(0,0,this.getWidth(), 60);
      LabelTitle.setHorizontalAlignment(JLabel.CENTER);
      
      LabelText.setText("enter text:");
      LabelAmount.setText("enter spam amount:");
      
      LabelText.setBounds(20,90,100,40);
      LabelAmount.setBounds(20,160,200,40);
      
      panel.add(LabelAmount);
      panel.add(LabelText);
      panel.add(LabelTitle);
   }
   
   private void addTextField(){
      TextFieldText = new JTextField();
      TextFieldAmount = new JTextField();
      
      //TextFieldAmount.setText("amount");
      TextFieldAmount.setBounds(140,165,235,30);
      TextFieldText.setBounds(90,95,287,30);
      
      panel.add(TextFieldText);
      panel.add(TextFieldAmount);
   }
   
   private void addButton(){
      ButtonSpam = new JButton();
      ButtonSpam.setText("Spam!!!");
      ButtonSpam.setBounds(210,240,150,90);
      ButtonSpam.setFocusable(false);
      
      ButtonSpam.addActionListener(this);
      
      panel.add(ButtonSpam);
   }
   
   private void addTextArea(){
      TextArea1 = new JTextArea();
      TextArea1.setEditable(true);
      TextArea1.setForeground(Color.RED);
      TextArea1.setLineWrap(true);
      TextArea1.setFont(new Font("Consolas",0,15));
      TextArea1.setWrapStyleWord(true);
      //TextArea1.setBackground(Color.BLACK);
      scroll.setForeground(Color.GREEN);
      scroll = new JScrollPane(TextArea1);
      scroll.setBounds(5,210,200,260);
      
      
      panel.add(scroll);
   }
   
   
   
   public void addMenuBar(){
      menuBar = new JMenuBar();
      MenuSettings = new JMenu("Settings");
      MenuOther = new JMenu("Other");
      MenuItemExit = new JMenuItem("Exit Spam-Machine");
      MenuTheme = new JMenu("Look and Feel/Theme");
      MenuItemSpamBoy = new JMenuItem("Spam-Boy");
      MenuItemSpammer = new JMenuItem("El Spammer");
      MenuItemCheesy = new JMenuItem("Cheesy");
      MenuItemPipBoy = new JMenuItem("Pip-Boy (Spammout)");
      MenuItemRayndia = new JMenuItem("Rayndia");
      MenuItemJosue = new JMenuItem("Josúe");
      MenuItemNormie = new JMenuItem("Normie");
      
      
      MenuSettings.setMnemonic('S');
      MenuOther.setMnemonic('o');
      
      MenuItemCheesy.addActionListener(this);
      MenuItemSpamBoy.addActionListener(this);
      MenuItemPipBoy.addActionListener(this);
      MenuItemRayndia.addActionListener(this);
      MenuItemJosue.addActionListener(this);
      MenuItemSpammer.addActionListener(this);
      MenuItemNormie.addActionListener(this);
      MenuItemExit.addActionListener(this); 
      
      
      
      
      menuBar.setBorder(null);
      
      menuBar.add(MenuSettings);
      menuBar.add(MenuOther);
      MenuSettings.add(MenuTheme);
      MenuTheme.add(MenuItemSpamBoy);
      MenuTheme.add(MenuItemSpammer);
      MenuTheme.add(MenuItemCheesy);
      MenuTheme.add(MenuItemNormie);
      MenuTheme.add(MenuItemPipBoy);
      MenuTheme.add(MenuItemRayndia);
      MenuTheme.add(MenuItemJosue);
      MenuOther.add(MenuItemExit);
      
      
      
      this.setJMenuBar(menuBar);
   }
   
   
   //code stufffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
   
   @Override
   public void actionPerformed(ActionEvent ea){
      startMenu.playSound("./res/button_click.wav");
      //change themes start
      
         if(ea.getSource() == MenuItemExit){
            this.setVisible(false);
            Menu menu = new Menu();
            menu.setVisible(true);
         }
      
         if(ea.getSource() == MenuItemSpamBoy){
            spamBoyTheme();
         }
         
         else if(ea.getSource() == MenuItemCheesy){
            cheesyTheme();
         }
         
         else if(ea.getSource() == MenuItemPipBoy){
            pipBoyTheme();
         }
         
         else if(ea.getSource() == MenuItemRayndia){
            rayndiaTheme();
         }
         else if(ea.getSource() == MenuItemJosue){
            josueTheme();
         }
         else if(ea.getSource() == MenuItemSpammer){
            spammerTheme();
         }
         else if(ea.getSource() == MenuItemNormie){
            normieTheme();
         }
         
      
      //change themes endd
      
      //spam start
      if(ea.getSource() == ButtonSpam){
      
            TextArea1.setForeground(Color.GREEN);
            TextArea1.setText(" ");
            
         try{
            
            if(TextFieldText.getText().equalsIgnoreCase("") || TextFieldAmount.getText().equalsIgnoreCase("")){
               JOptionPane.showMessageDialog(null,"please enter the Text you want to spam and the amount of times you want to spam it.");
            }
            
            String txt = TextFieldText.getText().toLowerCase();
            int amt = Integer.parseInt(TextFieldAmount.getText());
            spam(txt,amt);
            
            
         }catch (NumberFormatException nfe){
            TextArea1.setText("please enter valid input");
            TextArea1.setForeground(Color.RED);
         }catch(Exception e){
            TextArea1.setText("error: " + e);
            TextArea1.setForeground(Color.RED);
         }  
      }
    
      
   }
   
   private void spam(String text, int amount){   
      try{
         
         
         ArrayList<Integer> keys = new ArrayList<Integer>();
         robot = new Robot();
         char[] words = text.toCharArray();
         
         for(char word : words){
            switch(word){
               case 'a':keys.add(KeyEvent.VK_A); 
                  break;
               case 'b':keys.add(KeyEvent.VK_B); 
                  break;
               case 'c':keys.add(KeyEvent.VK_C); 
                  break;
               case 'd':keys.add(KeyEvent.VK_D); 
                  break;
               case 'e':keys.add(KeyEvent.VK_E); 
                  break;
               case 'f':keys.add(KeyEvent.VK_F); 
                  break;
               case 'g':keys.add(KeyEvent.VK_G); 
                  break;
               case 'h':keys.add(KeyEvent.VK_H); 
                  break;
               case 'i':keys.add(KeyEvent.VK_I); 
                  break;
               case 'j':keys.add(KeyEvent.VK_J); 
                  break;
               case 'k':keys.add(KeyEvent.VK_K); 
                  break;
               case 'l':keys.add(KeyEvent.VK_L); 
                  break;
               case 'm':keys.add(KeyEvent.VK_M); 
                  break;
               case 'n':keys.add(KeyEvent.VK_N); 
                  break;
               case 'o':keys.add(KeyEvent.VK_O); 
                  break;
               case 'p':keys.add(KeyEvent.VK_P); 
                  break;
               case 'q':keys.add(KeyEvent.VK_Q); 
                  break;
               case 'r':keys.add(KeyEvent.VK_R); 
                  break;
               case 's':keys.add(KeyEvent.VK_S); 
                  break;
               case 't':keys.add(KeyEvent.VK_T); 
                  break;
               case 'u':keys.add(KeyEvent.VK_U); 
                  break;
               case 'v':keys.add(KeyEvent.VK_V); 
                  break;
               case 'w':keys.add(KeyEvent.VK_W); 
                  break;
               case 'x':keys.add(KeyEvent.VK_X); 
                  break;
               case 'y':keys.add(KeyEvent.VK_Y); 
                  break;
               case 'z':keys.add(KeyEvent.VK_Z); 
                  break;       
               case '1': keys.add(KeyEvent.VK_1);
                  break;    
               case '2': keys.add(KeyEvent.VK_2);
                  break;
               case '3': keys.add(KeyEvent.VK_3);
                  break;      
               case '4': keys.add(KeyEvent.VK_4);
                  break; 
               case '5': keys.add(KeyEvent.VK_5);
                  break; 
               case '6': keys.add(KeyEvent.VK_6);
                  break;    
               case '7': keys.add(KeyEvent.VK_7);
                  break;
               case '8': keys.add(KeyEvent.VK_8);
                  break;      
               case '9': keys.add(KeyEvent.VK_9);
                  break; 
               case '0': keys.add(KeyEvent.VK_0);
                  break;  
               case ' ':keys.add(KeyEvent.VK_SPACE); 
                  break;
               case '-':keys.add(KeyEvent.VK_MINUS); 
                  break;
               case '.': keys.add(KeyEvent.VK_PERIOD);
                  break;
               case ',': keys.add(KeyEvent.VK_COMMA);            
                  break;
               case '#': keys.add(KeyEvent.VK_NUMBER_SIGN);
                  break;      
            }
                           
         }
            
            playMusic();     
            
            
                  
         for(int i = 0; i < amount; i++){
         
            for(int k: keys ){
               robot.keyPress(k);
               robot.keyRelease(k);
            }
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
         }
                  
      } catch(Exception e){
         TextArea1.setForeground(Color.RED);
         TextArea1.setText("error: " + e);
      }
      
      //spam end :(
   }
   
   public void playMusic(){
      try{
            twitch =   AudioSystem.getAudioInputStream(file);
            clip =  AudioSystem.getClip();
            clip.open(twitch);
            clip.start();
            robot.delay(6000);
            clip.stop();
            
         } catch(Exception e){
            TextArea1.setText("error: " + e);
         }
   }
   
   
   
   /************THEMES START************/
   
      //SPAM BOY THEEEEEEEME 
      
      public void spamBoyTheme(){
         panel.setBackground(new Color(145,151,145));
         
         ButtonSpam.setBackground(new Color(130,36,86));
         ButtonSpam.setForeground(new Color(98,98,234));
         ButtonSpam.setBorder(BorderFactory.createBevelBorder(0));
         ButtonSpam.setMnemonic('S');
         ButtonSpam.setFont(new Font("Gill Sans Ultra Bold",0,30));
         
         TextArea1.setFont(new Font("Consola",0,14));
         TextArea1.setBackground(new Color(0,40,0));
         TextArea1.setCaretColor(Color.GREEN);
         TextArea1.setForeground(Color.GREEN);
         TextArea1.setBorder(BorderFactory.createBevelBorder(0));
         scroll.getVerticalScrollBar().setBackground(new Color(0,40,0));
                  
         scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
          protected void configureScrollBarColors() {
            this.thumbColor = Color.GREEN;
          }
         });
         
         TextFieldText.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldText.setBackground(new Color(0,40,0));
         TextFieldText.setForeground(Color.GREEN);
         TextFieldText.setFont(new Font("Consola",1,14));
         
         TextFieldAmount.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldAmount.setBackground(new Color(0,40,0));
         TextFieldAmount.setForeground(Color.GREEN);
         TextFieldAmount.setFont(new Font("Consola",1,14));
         
         LabelText.setFont(new Font("Andale Mono", 1, 15));
         LabelAmount.setFont(new Font("Andale Mono", 1, 15));
         
         LabelText.setBounds(15,90,100,40);
         LabelAmount.setBounds(15,160,200,40);
         
         LabelText.setForeground(new Color(59,62,139));
         LabelAmount.setForeground(new Color(59,62,139));
         
         TextFieldAmount.setCaretColor(Color.GREEN);
         TextFieldText.setCaretColor(Color.GREEN);
         
         TextFieldAmount.setBounds(165,165,200,30);
         
         LabelTitle.setBackground(new Color(193,188,183));
         LabelTitle.setFont(new Font("Cooper Black",0,30));
         LabelTitle.setForeground(new Color(59,62,139));
         
         changeMenuStuff(new Color(193,188,183), Color.DARK_GRAY, new Font("Andale Mono", 1, 13));
            
      }
      
      //The Spammer THEMEEEEEEEEEEEEEE
      
      
      public void spammerTheme(){
         panel.setBackground(new Color(2,114,255));
         
         ButtonSpam.setBackground(new Color(198,0,158));
         ButtonSpam.setForeground(new Color(255,255,255));
         ButtonSpam.setBorder(BorderFactory.createBevelBorder(0));
         ButtonSpam.setMnemonic('S');
         ButtonSpam.setFont(new Font("Cooper Black",0,30));
         
         TextArea1.setFont(new Font("Consola",1,14));
         TextArea1.setBackground(new Color(188,0,28));
         TextArea1.setCaretColor(Color.WHITE);
         TextArea1.setForeground(Color.WHITE);
         TextArea1.setBorder(BorderFactory.createBevelBorder(0));
         scroll.getVerticalScrollBar().setBackground(new Color(198,0,158));
                  
         scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
          protected void configureScrollBarColors() {
            this.thumbColor = Color.WHITE;
          }
         });
         
         TextFieldText.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldText.setBackground(new Color(188,0,28));
         TextFieldText.setForeground(Color.WHITE);
         TextFieldText.setFont(new Font("Consola",1,14));
         
         TextFieldAmount.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldAmount.setBackground(new Color(188,0,28));
         TextFieldAmount.setForeground(Color.WHITE);
         TextFieldAmount.setFont(new Font("Consola",1,14));
         
         LabelText.setFont(new Font("Comic Sans MS", 1, 15));
         LabelAmount.setFont(new Font("Comic Sans MS", 1, 15));
         
         LabelText.setBounds(5,90,100,40);
         LabelAmount.setBounds(15,160,200,40);
         
         LabelText.setForeground(Color.WHITE);
         LabelAmount.setForeground(Color.WHITE);
         
         TextFieldAmount.setCaretColor(Color.GREEN);
         TextFieldText.setCaretColor(Color.GREEN);
         
         TextFieldAmount.setBounds(165,165,200,30);
         
         LabelTitle.setBackground(new Color(5,234,255));
         LabelTitle.setFont(new Font("Cooper Black",0,30));
         LabelTitle.setForeground(new Color(59,62,106));
         
         changeMenuStuff(new Color(5,234,255), new Color(59,62,106),new Font("Comic Sans MS", 1, 15));
            

      }
      
      //CHEESY THEMEEEEEEEEE
      
      public void cheesyTheme(){
         panel.setBackground(Color.YELLOW);
         
         ButtonSpam.setBackground(Color.RED);
         ButtonSpam.setForeground(Color.CYAN);
         ButtonSpam.setBorder(BorderFactory.createBevelBorder(0));
         ButtonSpam.setMnemonic('S');
         ButtonSpam.setFont(new Font("Gill Sans Ultra Bold",0,30));
         
         TextArea1.setFont(new Font("Comic Sans MS",1,15));
         TextArea1.setBackground(Color.MAGENTA);
         TextArea1.setCaretColor(Color.GREEN);
         TextArea1.setForeground(Color.GREEN);
         TextArea1.setBorder(BorderFactory.createBevelBorder(0));
         scroll.getVerticalScrollBar().setBackground(Color.CYAN);
                  
         scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
          protected void configureScrollBarColors() {
            this.thumbColor = Color.GREEN;
          }
         });
         
         TextFieldText.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldText.setBackground(Color.BLUE);
         TextFieldText.setForeground(Color.MAGENTA);
         TextFieldText.setFont(new Font("Comic Sans MS",1,16));
         
         TextFieldAmount.setBorder(BorderFactory.createBevelBorder(0));
         TextFieldAmount.setBackground(Color.BLUE);
         TextFieldAmount.setForeground(Color.cyan);
         TextFieldAmount.setFont(new Font("Comic Sans MS",1,16));
         
         LabelText.setFont(new Font("Comic Sans MS", 1, 15));
         LabelAmount.setFont(new Font("Comic Sans MS", 1, 15));
         
         LabelText.setBounds(5,90,100,40);
         LabelAmount.setBounds(5,160,200,40);
         
         LabelText.setForeground(Color.RED);
         LabelAmount.setForeground(Color.red);
         
         TextFieldAmount.setCaretColor(Color.YELLOW);
         TextFieldText.setCaretColor(Color.GREEN);
         
         TextFieldAmount.setBounds(165,165,200,30);
         
         LabelTitle.setBackground(Color.GREEN);
         LabelTitle.setFont(new Font("Cooper Black",0,30));
         LabelTitle.setForeground(Color.MAGENTA);
         
         changeMenuStuff(Color.GREEN, Color.RED, new Font("Comic Sans MS", 1, 15));
         
         
         
      }
      
      //PIP BOY THEME STAAAAAAAAART
      
      public void pipBoyTheme(){
         panel.setBackground(new Color(0,30,0));
         
         ButtonSpam.setBackground(Color.GREEN);
         ButtonSpam.setForeground(new Color(0,10,0));
         ButtonSpam.setBorder(BorderFactory.createLineBorder(Color.GREEN));
         ButtonSpam.setMnemonic('S');
         ButtonSpam.setFont(new Font("Arial Narrow",0,40));
         
         TextArea1.setFont(new Font("Arial Narrow",0,15));
         TextArea1.setBackground(Color.GREEN);
         TextArea1.setCaretColor(Color.GREEN);
         TextArea1.setForeground(Color.BLACK);
         TextArea1.setBorder(BorderFactory.createLineBorder(Color.GREEN));
         scroll.getVerticalScrollBar().setBackground(new Color(0,200,0));
                  
         scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
          protected void configureScrollBarColors() {
            this.thumbColor = new Color(0,60,0);
          }
         });
         
         TextFieldText.setBorder(BorderFactory.createLineBorder(Color.GREEN));
         TextFieldText.setBackground(Color.GREEN);
         TextFieldText.setForeground(Color.BLACK);
         TextFieldText.setFont(new Font("Arial Narrow",0,16));
         
         TextFieldAmount.setBorder(BorderFactory.createLineBorder(Color.GREEN));
         TextFieldAmount.setBackground(Color.GREEN);
         TextFieldAmount.setForeground(Color.BLACK);
         TextFieldAmount.setFont(new Font("Arial Narrow",0,16));
         
         LabelText.setFont(new Font("Arial Narrow", 1, 20));
         LabelAmount.setFont(new Font("Arial Narrow", 1, 20));
         
         LabelText.setBounds(5,90,100,40);
         LabelAmount.setBounds(5,160,200,40);
         
         LabelText.setForeground(Color.GREEN);
         LabelAmount.setForeground(Color.GREEN);
         
         TextFieldAmount.setCaretColor(Color.GREEN);
         TextFieldText.setCaretColor(Color.GREEN);
         
         TextFieldAmount.setBounds(165,165,200,30);
         
         LabelTitle.setBackground(new Color(0,30,0));
         LabelTitle.setFont(new Font("Arial Narrow",0,30));
         LabelTitle.setForeground(Color.GREEN);
         

         changeMenuStuff(new Color(0,30,0), Color.green, new Font("Arial Narrow", 1, 14));
         
      }
      
      //RAYNDIA THEME STARRRRRRRRRRRRRRRRRRRT
      
      public void rayndiaTheme(){
         panel.setBackground(Color.BLACK);
         
         ButtonSpam.setBackground(Color.BLACK);
         ButtonSpam.setForeground(Color.WHITE);
         ButtonSpam.setBorder(BorderFactory.createLineBorder(Color.WHITE));
         ButtonSpam.setMnemonic('S');
         ButtonSpam.setFont(new Font("Times New Roman",0,40));
         
         TextArea1.setFont(new Font("Times New Roman",0,15));
         TextArea1.setBackground(Color.BLACK);
         TextArea1.setCaretColor(Color.WHITE);
         TextArea1.setForeground(Color.WHITE);
         TextArea1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
         scroll.getVerticalScrollBar().setBackground(Color.BLACK);
                  
         scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
          protected void configureScrollBarColors() {
            this.thumbColor = Color.WHITE;
          }
         });
         
         TextFieldText.setBorder(BorderFactory.createLineBorder(Color.WHITE));
         TextFieldText.setBackground(Color.BLACK);
         TextFieldText.setForeground(Color.WHITE);
         TextFieldText.setFont(new Font("Times New Roman",0,16));
         
         TextFieldAmount.setBorder(BorderFactory.createLineBorder(Color.WHITE));
         TextFieldAmount.setBackground(Color.BLACK);
         TextFieldAmount.setForeground(Color.WHITE);
         TextFieldAmount.setFont(new Font("Times New Roman",0,16));
         
         LabelText.setFont(new Font("Times New Roman", 0, 20));
         LabelAmount.setFont(new Font("Times New Roman", 0, 20));
         
         LabelText.setBounds(5,90,100,40);
         LabelAmount.setBounds(5,160,200,40);
         
         LabelText.setForeground(Color.WHITE);
         LabelAmount.setForeground(Color.WHITE);
         
         TextFieldAmount.setCaretColor(Color.WHITE);
         TextFieldText.setCaretColor(Color.WHITE);
         
         TextFieldAmount.setBounds(165,165,200,30);
         
         LabelTitle.setBackground(Color.BLACK);
         LabelTitle.setFont(new Font("Times New Roman",0,30));
         LabelTitle.setForeground(Color.WHITE);
         
         
         changeMenuStuff(Color.BLACK, Color.WHITE, new Font("Times New Roman", 1, 15));
         
      }
      
      //josue theme staaaaart
      
      public void josueTheme(){
         doubleColor(Color.pink, Color.red, new Font("Comic Sans MS", 0, 16), new Font("Gill Sans Ultra Bold", 0, 40), new Font("Gill Sans Ultra Bold", 0, 30));
      }
      
      //nORMIE THEME STARRRRRRRRRTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
      
      public void normieTheme(){
            panel.setBackground(new JPanel().getBackground());
            
            ButtonSpam.setBackground(new JButton().getBackground());
            ButtonSpam.setForeground(Color.DARK_GRAY);
            ButtonSpam.setBorder(BorderFactory.createLineBorder(new Color(65,67,102)));
            ButtonSpam.setMnemonic('S');
            ButtonSpam.setFont(new Font("Arial",0,20));
            
            TextArea1.setFont(new Font("Arial",0,15));
            TextArea1.setBackground(Color.WHITE);
            TextArea1.setCaretColor(Color.DARK_GRAY);
            TextArea1.setForeground(Color.DARK_GRAY);
            TextArea1.setBorder(BorderFactory.createLineBorder(new Color(65,67,102)));
            scroll.getVerticalScrollBar().setBackground(new Color(238,238,238));
            
            
                     
            scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
             protected void configureScrollBarColors() {
               this.thumbColor = new Color(65,67,102);
             }
            });
            
            TextFieldText.setBorder(new JTextField().getBorder());
            TextFieldText.setBackground(new JTextField().getBackground());
            TextFieldText.setForeground(new JTextField().getForeground());
            TextFieldText.setFont(new JTextField().getFont());
            
            TextFieldAmount.setBorder(new JTextField().getBorder());
            TextFieldAmount.setBackground(new JTextField().getBackground());
            TextFieldAmount.setForeground(new JTextField().getForeground());
            TextFieldAmount.setFont(new JTextField().getFont());
            
            LabelText.setFont(new JLabel().getFont());
            LabelAmount.setFont(new JLabel().getFont());
            
            LabelText.setBounds(5,90,100,40);
            LabelAmount.setBounds(5,160,200,40);
            
            LabelText.setForeground(new JLabel().getForeground());
            LabelAmount.setForeground(new JLabel().getForeground());
            
            TextFieldAmount.setCaretColor(new JTextField().getForeground());
            TextFieldText.setCaretColor(new JTextField().getForeground());
            
            TextFieldAmount.setBounds(165,165,200,30);
            
            LabelTitle.setBackground(new JLabel().getBackground());
            LabelTitle.setFont(new Font("Arial",0,40));
            LabelTitle.setForeground(new JLabel().getForeground());
            
            
            changeMenuStuff(new JLabel().getBackground(), new JLabel().getForeground(), new JLabel().getFont());
            
   
      }
      
      //theme presetssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss      
      public void doubleColor(Color backgroundColor, Color foregroundColor, Font font, Font fontTitle, Font fontButton){
                  
                  
               panel.setBackground(backgroundColor);
         
               ButtonSpam.setBackground(backgroundColor);
               ButtonSpam.setForeground(foregroundColor);
               ButtonSpam.setBorder(BorderFactory.createLineBorder(foregroundColor));
               ButtonSpam.setMnemonic('S');
               ButtonSpam.setFont(fontButton);
               
               TextArea1.setFont(font);
               TextArea1.setBackground(backgroundColor);
               TextArea1.setCaretColor(foregroundColor);
               TextArea1.setForeground(foregroundColor);
               TextArea1.setBorder(BorderFactory.createLineBorder(foregroundColor));
               scroll.getVerticalScrollBar().setBackground(backgroundColor);
                        
               scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
               @Override
                protected void configureScrollBarColors() {
                  this.thumbColor = foregroundColor;
                }
               });
               
               TextFieldText.setBorder(BorderFactory.createLineBorder(foregroundColor));
               TextFieldText.setBackground(backgroundColor);
               TextFieldText.setForeground(foregroundColor);
               TextFieldText.setFont(font);
               
               TextFieldAmount.setBorder(BorderFactory.createLineBorder(foregroundColor));
               TextFieldAmount.setBackground(backgroundColor);
               TextFieldAmount.setForeground(foregroundColor);
               TextFieldAmount.setFont(font);
               
               LabelText.setFont(font);
               LabelAmount.setFont(font);
               
               LabelText.setBounds(5,90,100,40);
               LabelAmount.setBounds(5,160,200,40);
               
               LabelText.setForeground(foregroundColor);
               LabelAmount.setForeground(foregroundColor);
               
               TextFieldAmount.setCaretColor(foregroundColor);
               TextFieldText.setCaretColor(foregroundColor);
               
               TextFieldAmount.setBounds(165,165,200,30);
               
               LabelTitle.setBackground(backgroundColor);
               LabelTitle.setFont(fontTitle);
               LabelTitle.setForeground(foregroundColor);
               
               
               changeMenuStuff(backgroundColor, foregroundColor, font);   
      }
      
      private void changeMenuStuff(Color ColorBackground, Color ColorForeground, Font f){
      
                menuBar.setBackground(ColorBackground);
                MenuOther.setBackground(ColorBackground);
               MenuTheme.setBackground(ColorBackground);
               MenuSettings.setBackground(ColorBackground);
               MenuItemSpamBoy.setBackground(ColorBackground);
               MenuItemCheesy.setBackground(ColorBackground);
               MenuItemPipBoy.setBackground(ColorBackground);
               MenuItemRayndia.setBackground(ColorBackground);
               MenuItemJosue.setBackground(ColorBackground); 
               MenuItemSpammer.setBackground(ColorBackground);
               MenuItemNormie.setBackground(ColorBackground);
               MenuItemExit.setBackground(ColorBackground);
               
               MenuOther.setForeground(ColorForeground);
               menuBar.setForeground(ColorForeground);
               MenuTheme.setForeground(ColorForeground);
               MenuSettings.setForeground(ColorForeground);
               MenuItemSpamBoy.setForeground(ColorForeground);
               MenuItemCheesy.setForeground(ColorForeground);
               MenuItemPipBoy.setForeground(ColorForeground);
               MenuItemRayndia.setForeground(ColorForeground);
               MenuItemJosue.setForeground(ColorForeground);
               MenuItemSpammer.setForeground(ColorForeground);
               MenuItemNormie.setForeground(ColorForeground);
               MenuItemExit.setForeground(ColorForeground);
               
         
               menuBar.setFont(f);
               MenuTheme.setFont(f);
               MenuSettings.setFont(f);
               MenuItemSpamBoy.setFont(f);
               MenuItemCheesy.setFont(f);
               MenuItemPipBoy.setFont(f);
               MenuItemRayndia.setFont(f);
               MenuItemJosue.setFont(f);
               MenuItemSpammer.setFont(f);
               MenuItemNormie.setFont(f);
               MenuItemExit.setFont(f);
               MenuOther.setFont(f);
               }
      
   /************THEMES   END************/
   
        
}