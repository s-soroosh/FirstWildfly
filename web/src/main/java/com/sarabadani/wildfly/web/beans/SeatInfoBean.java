package com.sarabadani.wildfly.web.beans;

import com.sarabadani.wildfly.SeatManager;
import com.sarabadani.wildfly.model.Seat;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by soroosh on 9/6/14.
 */
@Model
public class SeatInfoBean {
    @Inject
    SeatManager seatManager;

    private List<Seat> seats;

    @Produces
    @Named
    public List<Seat> getSeats() {
        return this.seats;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Seat seat) {
        System.out.println("An event occured on seats.");
        System.out.print("Reloading seats.");
        retrieveAllSeats();
    }

    @PostConstruct
    public void retrieveAllSeats() {
        this.seats = Collections.list(this.seatManager.getSeats());

    }


}
