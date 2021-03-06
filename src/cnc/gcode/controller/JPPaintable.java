/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jPPaintable.java
 *
 * Created on 18.11.2011, 16:03:07
 */
package cnc.gcode.controller;

import java.awt.Graphics;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Patrick
 */
public class JPPaintable extends javax.swing.JPanel 
{

    protected EventListenerList jPlistenerList = new EventListenerList();
    
    /** Creates new form jPPaintable */
    public JPPaintable() {
        initComponents();
    }

    public void addPaintEventListener(JPPaintableListener listener) 
    {
        listenerList.add(JPPaintableListener.class, listener);
    }
    public void removePaintEventListener(JPPaintableListener listener) 
    {
        listenerList.remove(JPPaintableListener.class, listener);
    }
    
    void firePaintEvent(JPPaintableEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i + 2) 
        {
            if (listeners[i] == JPPaintableListener.class) 
            {
                ((JPPaintableListener) listeners[i + 1]).paintComponent(evt);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        firePaintEvent(new JPPaintableEvent(this, g));
    }

    
    boolean repaintEnable=true;
            
    @Override
    public void repaint(){
        if(repaintEnable)
        {
            super.repaint();
        }
    }
    
    /**Stops the repaint for this element (When value is ture a repaint is triggered!)
     * @param value */
    public void setRepaintEnable(boolean value){
        repaintEnable = value;
        repaint();
    }
    
    public boolean getRepaintEnable(){
        return repaintEnable;
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
