package com.sarabadani.wildfly.web.beans;

import com.sarabadani.wildfly.SeatManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by soroosh on 9/6/14.
 */
@Named
@SessionScoped
public class SeatBooker implements Serializable {
    @Inject
    private SeatManager seatManager;
    public void book(Integer id){
        FacesContext fc = FacesContext.getCurrentInstance();

        try {
            seatManager.buySeat(id);
        }
        catch (Exception e){
            fc.addMessage(null,new FacesMessage(e.getMessage()));
        }
    }
}
