/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author maxra
 */
public class clockFace extends javax.swing.JFrame {

    static int milliseconds=0;
    static int seconds=0;
    static int minutes=0;
    static int hours=0;
    
    static boolean state = true;
    public clockFace() {
        initComponents();
        playMusic("C:\\Users\\maxra\\Documents\\NetBeansProjects\\stopWatch\\song.wav");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hour = new javax.swing.JLabel();
        second = new javax.swing.JLabel();
        minute = new javax.swing.JLabel();
        millisecond = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        hour.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        hour.setText("00  :");
        getContentPane().add(hour);
        hour.setBounds(40, 80, 30, 17);

        second.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        second.setText("00  :");
        getContentPane().add(second);
        second.setBounds(100, 80, 30, 17);

        minute.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        minute.setText("00  :");
        getContentPane().add(minute);
        minute.setBounds(70, 80, 30, 17);

        millisecond.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        millisecond.setText("00");
        getContentPane().add(millisecond);
        millisecond.setBounds(130, 80, 50, 17);

        start.setBackground(new java.awt.Color(72, 36, 0));
        start.setFont(new java.awt.Font("Viner Hand ITC", 0, 13)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setText("start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start);
        start.setBounds(70, 110, 70, 29);

        stop.setBackground(new java.awt.Color(72, 36, 0));
        stop.setFont(new java.awt.Font("Viner Hand ITC", 0, 13)); // NOI18N
        stop.setForeground(new java.awt.Color(255, 255, 255));
        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop);
        stop.setBounds(70, 140, 70, 29);

        reset.setBackground(new java.awt.Color(72, 36, 0));
        reset.setFont(new java.awt.Font("Viner Hand ITC", 0, 13)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(70, 170, 70, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stopwatch/clockface.jpeg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 320, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static void playMusic(String filepath){
    InputStream music;
    try {
        music = new FileInputStream(new File(filepath));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.start(audios);
    } catch (Exception e) {
    }
}


public static void stopMusic(String filepath){
    InputStream music;
    try {
        music = new FileInputStream(new File(filepath));
        AudioStream audios = new AudioStream(music);
        AudioPlayer.player.stop(audios);
    } catch (Exception e) {
    }
}
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        state = true;
        
      
        Thread t = new Thread(){
            public void run(){
                for(;;){
                    if (state==true){
                        try {
                            sleep(1);
                            if(milliseconds>1000){
                                milliseconds=0;
                                seconds++;
                            }else if(seconds>60){
                                milliseconds=0;
                                seconds=0;
                                minutes++;
                            }else if(minutes>60){
                                milliseconds=0;
                                seconds=0;
                                minutes=0;
                                hours++;
                            }
                            
                            
                            millisecond.setText(": "+milliseconds);
                            milliseconds++;
                            second.setText(": "+seconds);
                            minute.setText(": "+minutes);
                            hour.setText(""+hours);
                            
                            
                        } catch (Exception e) {
                        }
                    }else{
                        break;
                    }
                }
            }
        };
        t.start();
       
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
             
        state = false;
    }//GEN-LAST:event_stopActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
     state = false;
     milliseconds=0;
     seconds=0;
     minutes= 0 ;
     hours = 0;
     millisecond.setText("00");
    second.setText("00 :");
     minute.setText("00  :");
     hour.setText("00  :");
     
     
     
    }//GEN-LAST:event_resetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clockFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clockFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clockFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clockFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clockFace().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel millisecond;
    private javax.swing.JLabel minute;
    private javax.swing.JButton reset;
    private javax.swing.JLabel second;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
