package SwingTest;
import IO.IoTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class Rand extends JFrame{
    JFrame frame=new JFrame("体育部随机器");
    JComboBox cmb = new JComboBox();
    JTextField jtf = new JTextField(16);
    JButton buttonAdd = new JButton("添加");
    JButton buttonDel = new JButton("删除");
    JButton buttonRand = new JButton("随机");
    JLabel result = new JLabel("结果");
    JLabel showInfo = new JLabel();
    JPanel centerBox = new JPanel(); //创建CenterBox
    Box rightBox = Box.createVerticalBox(); //创建CenterBox
    Box allBox = Box.createHorizontalBox();
    Box Box1 = Box.createVerticalBox();
   public Rand(){
       Init();
       //控件布局
       Box1.add(buttonAdd);
       Box1.add(buttonDel);
       Box1.add(buttonRand);
       centerBox.add(cmb);
       centerBox.add(jtf);
       centerBox.add(Box1);
       rightBox.add(result);
       allBox.add(centerBox);
       allBox.add(rightBox);
       frame.add(allBox);
       //设置监听器
       cmb.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               String str = e.getItem().toString();
           }
       });
       buttonAdd.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(jtf.getText().length()!=0){
                   IoTest io = new IoTest();
                   String t =","+jtf.getText();
                   try {
                       io.addApend(t);
                       showInfo.setText("增加成功");
                       centerBox.add(showInfo);

                       Init();
                   } catch (Exception e1) {
                       e1.printStackTrace();
                   }
               }

           }
       });
       buttonDel.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String strDel = cmb.getSelectedItem().toString();
               IoTest io = new IoTest();
               try {
                   String temp = io.get();
                   String[] t2 = temp.split(",");
                   String[] t3 = new String[100];
                   int j=0;
                   for(int i =0;i<t2.length;i++){
                       if(!t2[i].equals(strDel)){
                           t3[j++]=t2[i];
                       }
                   }
                   String t4="";
                   for(int i = 0;i<j;i++){
                       if(i!=0){
                           t4+=",";
                       }
                       t4+=t3[i];
                   }
                   io.addOverride(t4);
                   Init();
                   showInfo.setText("删除成功");
                   centerBox.add(showInfo);
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
           }
       });
       buttonRand.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                IoTest io = new IoTest();
               try {
                   String temp = io.get();
                   String[] t = temp.split(",");
                   Random r3 = new Random();
                   int x =r3.nextInt(t.length);
                    result.setText(t[x]);
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
           }
       });
       //设置窗口的关闭动作、标题、大小位置以及可见性等
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setBounds(100,100,550,200);
       frame.setVisible(true);
   }

   public void Init(){
       IoTest io = new IoTest();
       String t1 =null;
       cmb.removeAllItems();
       try {
          t1 =io.get();
       } catch (Exception e) {
           e.printStackTrace();
       }
       String[] t2 =t1.split(",");
       for(int i =0;i<t2.length;i++){
           String t =t2[i];
           cmb.addItem(t);
       }
   }

}
