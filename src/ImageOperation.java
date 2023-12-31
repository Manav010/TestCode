import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageOperation {

    public static void operation(int key){
        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);

        File file = filechooser.getSelectedFile();

        try{
            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];

            fis.read(data);
             int i=0;

            for(byte b :data){
              

                  data[i]  = (byte)(b^key);
                 System.out.println(b);

                i++;
            }

             FileOutputStream fos = new FileOutputStream(file);
             fos.write(data);

             fos.close();
             fis.close();
             JOptionPane.showMessageDialog(null , "done");


        }catch(Exception e){
               e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        JFrame f = new JFrame();

        f.setTitle("Image Operation");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);

       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //Creatimg button

        Font font = new Font("Roboto" , Font.BOLD , 25);
        JButton Button = new JButton("enter your key");
        Button.setText("Open your image to encrypt or Decrypt");
        Button.setFont(font);

        //Creating TextField

        JTextField jtextfield = new JTextField(20);
        jtextfield.setFont(font);

        Button.addActionListener(e->{
            System.out.println("clicked");
            String text = jtextfield.getText();
            int temp = Integer.parseInt(text);
            operation(temp);
        });


       f.setLayout(new FlowLayout());
        f.add(Button);
        f.add(jtextfield);

        f.setVisible(true);

    }
}
