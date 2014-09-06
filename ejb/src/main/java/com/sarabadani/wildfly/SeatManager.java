package com.sarabadani.wildfly;

import com.sarabadani.wildfly.model.Seat;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;

/**
 * Created by soroosh on 9/6/14.
 */
@Singleton
public class SeatManager implements Serializable {
    private Dictionary<Integer, Seat> seats = new Hashtable<Integer, Seat>();

    @Inject
    Event<Seat> seatEvent;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 50; i++) {
            seats.put(i, new Seat(i, "seat-" + i, i * 1000));
        }
    }

    @Lock(LockType.WRITE)
    public void buySeat(Integer id) {
        Seat selected_seat = seats.get(id);
        selected_seat.reserve();
        seatEvent.fire(selected_seat);
    }

    @Lock(LockType.READ)
    public Enumeration<Seat> getSeats() {
        return this.seats.elements();

    }

}
