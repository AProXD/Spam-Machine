import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.sound.sampled.*;
public class Menu extends JFrame implements ActionListener{
   private JButton ButtonStart;
   private ImageIcon icon = new ImageIcon("./res/logo.png");
   private ImageIcon IconDPad = new ImageIcon("./res/dpad.png");
   private ImageIcon BabyScreen = new ImageIcon("./res/dancing_baby_screen.gif");
   private JTextArea TextAreaFakeScreen;
   private JButton dpad;
   private Random random = new Random();
   private String ln = "\n";
   private String[] randomMessages = {ln + "java edition",ln + "Also try Minecraft!",ln + "AProXD is cool",ln + "SPAMMER!!!!!!",ln + "Awesome!",ln + "Aww Man!",ln + "Don't feed avocados to parrots!",ln + "also try FNAA",ln + "I dont Have Friends!","",ln + "helo",ln + "Exploding creepers!",ln +"Subscribe to AProXD on YOUTUBE!",ln + "skeletons are kool!",ln + "Peluche!!!!!",ln +"I hate ants",ln + "1% sugar!",ln +"LEGEN-",ln +"-DAIRY",ln +"As seen on TV!",ln +"LOL",ln +"ROFL",ln +"KEKW",ln +"not funny, didnt laugh"};
   private int rn = random.nextInt(randomMessages.length);
   private JLabel  LabelFakeScreen;
   private JPanel panel;
   private Font font = new Font("Consolas",0,14);
   private Boolean baby = false;
   
   
   public Menu(){
      this.setSize(500,500);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setIconImage(icon.getImage());
      this.setLocationRelativeTo(null);
      this.setTitle("Spam-Machine | Main Menu");
      this.setResizable(false);
      addStuff();
   }
   
   public void addStuff(){
      addPanel();
      addDPad();
      addTextAreaFakeScreen();
      addButton();
      addLabelFakeScreen();
   }
   
   private void addPanel(){
      panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(new Color(145,151,145));
      
      this.getContentPane().add(panel);
   }
   
   private void addTextAreaFakeScreen(){
      TextAreaFakeScreen = new JTextArea();
      TextAreaFakeScreen.setBounds(25,30,260,220);
      TextAreaFakeScreen.setBackground(new Color(0,40,0));
      TextAreaFakeScreen.setForeground(Color.GREEN);
      TextAreaFakeScreen.setEditable(false);
      TextAreaFakeScreen.setFont(font);
      TextAreaFakeScreen.setText("Spam-Machine");
      TextAreaFakeScreen.append(randomMessages[rn]);
      TextAreaFakeScreen.append("|");
      TextAreaFakeScreen.setBorder(BorderFactory.createBevelBorder(0));
      panel.add(TextAreaFakeScreen);
   }
   
   private void addButton(){
      ButtonStart = new JButton();
      ButtonStart.setBounds(300,290,150,90);
      ButtonStart.setFocusable(false);
      ButtonStart.setBackground(new Color(130,36,86));
      ButtonStart.setForeground(new Color(98,98,234));
      ButtonStart.setBorder(BorderFactory.createBevelBorder(0));
      ButtonStart.setMnemonic('S');
      ButtonStart.addActionListener(this);
      ButtonStart.setText("Start");
      ButtonStart.setFont(new Font("Gill Sans Ultra Bold",0,30));
      
      panel.add(ButtonStart);
   }
   
   private void addDPad(){
      dpad = new JButton();
      
      dpad.setFocusable(false);
      dpad.setBorder(null);
      dpad.setContentAreaFilled(false);         
      dpad.setOpaque(false);
      dpad.setBackground(null);
      dpad.setBounds(30,280,150,150);
      dpad.addActionListener(this);
      dpad.setMnemonic('a');
      dpad.setMnemonic('w');
      dpad.setIcon(new ImageIcon(IconDPad.getImage().getScaledInstance(dpad.getWidth(),dpad.getHeight(),0)));
      
      panel.add(dpad);
   }
   
   public void addLabelFakeScreen(){
      LabelFakeScreen = new JLabel();
      LabelFakeScreen.setOpaque(true);
      LabelFakeScreen.setVisible(false);
      LabelFakeScreen.setBounds(25,30,260,220);
      LabelFakeScreen.setBackground(new Color(0,40,0));
      LabelFakeScreen.setForeground(Color.GREEN);
      LabelFakeScreen.setIcon(new ImageIcon(BabyScreen.getImage().getScaledInstance(LabelFakeScreen.getWidth(),LabelFakeScreen.getHeight(),1)));
      LabelFakeScreen.setFont(font);
      LabelFakeScreen.setVerticalAlignment(JLabel.TOP);
      LabelFakeScreen.setBorder(BorderFactory.createBevelBorder(0));
      panel.add(LabelFakeScreen);

   }
   
   @Override
   public void actionPerformed(ActionEvent ea){
      playSound("./res/button_click.wav");
   
      if(ea.getSource() == ButtonStart){
         TermsandConditions terms = new TermsandConditions();
         terms.setVisible(true);
         this.setVisible(false);
      }
      
      if(ea.getSource() == dpad){
         if(baby == false){
            
            LabelFakeScreen.setVisible(true);
            TextAreaFakeScreen.setVisible(false);
            baby = true;
            
         } else if(baby == true){
            LabelFakeScreen.setVisible(false);
            TextAreaFakeScreen.setVisible(true);
            baby = false;
         }  
      }
   }
   
   public void playSound(String soundLocation){
      try{
         File file = new File(soundLocation);
         AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
         Clip clip = AudioSystem.getClip();
         clip.open(inputStream);
         clip.start();
         //clip.stop();
      } catch(Exception e){
         System.out.println("error: " + e);
      }   
   }
}