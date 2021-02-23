import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
public class TermsandConditions extends JFrame implements ChangeListener,ActionListener{
   private JPanel panel;
   private JScrollPane scroll;
   private JTextArea TextAreaTerms;
   private JLabel label;
   private JButton ButtonAccept,ButtonDecline;
   private JCheckBox checkBox;
   String ln = "\n";
   private ImageIcon icon = new ImageIcon("./res/logo.png");
   Menu startMenu = new Menu();
   
   public TermsandConditions(){
      this.setSize(700,400);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
      this.setIconImage(icon.getImage());
      this.setResizable(false);
      this.setTitle("Spam-Machine | terms and conditions");
      addStuff();
   }
   
   public void addStuff(){
      addPanel();
      addTextArea();
      addButton();
      addCheckBox();
      addLabel();
   }
   
   private void addPanel(){
      panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(new Color(145,151,145));
      this.getContentPane().add(panel);
   }
   
   private void addTextArea(){
      TextAreaTerms = new JTextArea();
      TextAreaTerms.setText("THE SOFTWARE (SPAM-MACHINE) IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS ORIMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHERLIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THESOFTWARE." + ln + ln + "you are not allowed to copy,modify, merge, publish, distribute, and/or sell copies of the Software (Spam-Machine) without giving credit to the creator, AProXD."+ ln + ln + "By clicking the confirm button and continuing you are accepting the Terms and Conditions.");
      TextAreaTerms.setEditable(false);
      TextAreaTerms.setLineWrap(true);
      TextAreaTerms.setBorder(BorderFactory.createBevelBorder(0));
      TextAreaTerms.setBackground(new Color(0,40,0));
      TextAreaTerms.setForeground(Color.GREEN);
      TextAreaTerms.setFont(new Font("Consolas", 0 , 13));
      TextAreaTerms.setWrapStyleWord(true);
      //scroll = new JScrollPane(TextAreaTerms);
      //scroll.setBackground(new Color(0,40,0));
      //scroll.setForeground(Color.GREEN);
      //scroll.setBounds(20,30,600,200);
      TextAreaTerms.setBounds(20,30,600,200);
      
      panel.add(TextAreaTerms);
      //panel.add(scroll);
   }
   
   private void addButton(){
      ButtonAccept = new JButton();
      ButtonDecline = new JButton();
      
      ButtonAccept.setText("continue");
      ButtonDecline.setText("decline");
      
      ButtonAccept.setBounds(150,280,100,40);
      ButtonDecline.setBounds(20,280,100,40);
      
      ButtonAccept.setEnabled(false);
      ButtonDecline.setEnabled(true);
      
      ButtonAccept.setBackground(Color.GRAY);
      ButtonDecline.setBackground(new Color(230,12,0));
      
      ButtonAccept.setBorder(BorderFactory.createBevelBorder(0));
      ButtonDecline.setBorder(BorderFactory.createBevelBorder(0));
      
      ButtonAccept.setForeground(new Color(98,98,234));
      ButtonDecline.setForeground(new Color(88,12,0));
      
      ButtonAccept.setFont(new Font("Gill Sans Ultra Bold",0,15));
      ButtonDecline.setFont(new Font("Gill Sans Ultra Bold",0,15));
      
      ButtonAccept.setMnemonic('C');
      ButtonDecline.setMnemonic('D');
      
      ButtonAccept.addActionListener(this);
      ButtonDecline.addActionListener(this);
      
      ButtonAccept.setFocusable(false);
      ButtonDecline.setFocusable(false);
      
      panel.add(ButtonAccept);
      panel.add(ButtonDecline);
   }                 
   
   private void addCheckBox(){
      checkBox = new JCheckBox();
      checkBox.setText("confirm");
      checkBox.setMnemonic('A');
      checkBox.setFocusable(false);
      checkBox.setBounds(20,230,100,40);
      checkBox.addActionListener(this);
      checkBox.addChangeListener(this);
      checkBox.setOpaque(false);
      checkBox.setFont(new Font("Andale Mono", 1, 15));
      
      
      panel.add(checkBox);
   }
   
   private void addLabel(){
      label = new JLabel();
      label.setText("Terms and Conditions:");
      label.setBounds(20,5,300,30);
      label.setFont(new Font("Andale Mono", 1, 15));

      
      panel.add(label);
   }
  
   @Override
   public void stateChanged(ChangeEvent ce){
      
      if(checkBox.isSelected() == true){
         ButtonAccept.setEnabled(true);
         ButtonDecline.setEnabled(false);
         
         ButtonAccept.setBackground(new Color(130,36,86));
         ButtonDecline.setBackground(Color.GRAY);
         
      }
      else if(checkBox.isSelected() == false){
         ButtonAccept.setEnabled(false);
         ButtonDecline.setEnabled(true);
         
         ButtonDecline.setBackground(new Color(230,12,0));
         ButtonAccept.setBackground(Color.GRAY);
         
      }
   }
    
   @Override
   public void actionPerformed(ActionEvent ea){
      startMenu.playSound("./res/button_click.wav");
      if(ea.getSource() == ButtonAccept){
         this.setVisible(false);
         Spammer machine = new Spammer();
         machine.setVisible(true);
      }
      if(ea.getSource() == ButtonDecline){
         
         this.setVisible(false);
         startMenu.setVisible(true);
      }
      
      if(ea.getSource() == checkBox){
         
      }
   }
   
}
