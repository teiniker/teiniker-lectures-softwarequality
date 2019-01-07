package org.se.lab;

import java.util.concurrent.atomic.AtomicLong;

public final class LongSequence
{
	private LongSequence() {}

	/*
	 * Property: sequenceNumber:long
	 */
    private static final long INITIAL_SEQUENCE_NUMBER = 1; // default value
	private static AtomicLong sequenceNumber = new AtomicLong(INITIAL_SEQUENCE_NUMBER);
	
	public synchronized static long getNextSequenceNumber()
	{
		return sequenceNumber.getAndIncrement();
	}
	
	public synchronized static void setSequenceNumber(long id)
	{
		 sequenceNumber.set(id);
	}	
	
	public synchronized static void resetSequenceNumber()
	{
		sequenceNumber.set(INITIAL_SEQUENCE_NUMBER);
	}
}
