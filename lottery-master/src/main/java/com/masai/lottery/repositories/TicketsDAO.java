package com.masai.lottery.repositories;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.masai.lottery.model.Ticket;


@Repository
public class TicketsDAO
{
	private Set<Ticket> tickets;

	TicketsDAO()
	{
		generateTickets();
	}

	public void generateTickets()
	{
		tickets = new HashSet<>();
		for (int i = 1; i < 51; i++)
		{
			Ticket ticket = new Ticket((long) i, null, false);
			tickets.add(ticket);
		}
	}

	public Set<Ticket> getTickets()
	{
		return tickets;
	}
}
