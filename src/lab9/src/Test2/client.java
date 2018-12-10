package Test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client extends javax.swing.JFrame
{

    static Socket sckt;
    static DataInputStream dtinpt;
    static DataOutputStream dtotpt;
    /** Creates new form client */
    public client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {


    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:


        try
        {
            String msgout = "";
            msgout = jTextField1.getText().trim();
            dtotpt.writeUTF(msgout);
        }
        catch (Exception e)
        {
        }
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new client().setVisible(true);
            }
        });

        try
        {
            sckt = new Socket("127.0.0.1",1201);
            dtinpt = new DataInputStream(sckt.getInputStream());
            dtotpt = new DataOutputStream(sckt.getOutputStream());
            String msgin = "";
            while(!msgin.equals("Exit"))
            {
                msgin=dtinpt.readUTF();
                jTextArea1.setText(jTextArea1.getText().trim()+"\n Server:"+msgin);
            }
        }
        catch(Exception e)
        {

        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration

}