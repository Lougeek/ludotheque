/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Alexandre
 */
public class ModelBoutonTitre implements ButtonModel {

    private boolean _armed;
    private boolean _selected;
    private boolean _enabled;

    @Override
    public boolean isArmed() {
        return _armed;
    }

    @Override
    public boolean isSelected() {
        return _selected;
    }

    @Override
    public boolean isEnabled() {
        return _enabled;
    }

    @Override
    public boolean isPressed() {
        return false;
    }

    @Override
    public boolean isRollover() {
        return false;
    }

    @Override
    public void setArmed(boolean b) {
        _armed = b;
    }

    @Override
    public void setSelected(boolean b) {
        _selected = b;
    }

    @Override
    public void setEnabled(boolean b) {
        _enabled = b;
    }

    @Override
    public void setPressed(boolean b) {

    }

    @Override
    public void setRollover(boolean b) {
    }

    @Override
    public void setMnemonic(int key) {
    }

    @Override
    public int getMnemonic() {
        return 0;
    }

    @Override
    public void setActionCommand(String s) {
    }

    @Override
    public String getActionCommand() {
        return "";
    }

    @Override
    public void setGroup(ButtonGroup group) {
    }

    @Override
    public void addActionListener(ActionListener l) {
    }

    @Override
    public void removeActionListener(ActionListener l) {
    }

    @Override
    public void addItemListener(ItemListener l) {
    }

    @Override
    public void removeItemListener(ItemListener l) {
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public Object[] getSelectedObjects() {
        return null;
    }

}
