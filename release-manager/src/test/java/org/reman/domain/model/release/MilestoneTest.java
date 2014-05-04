package org.reman.domain.model.release;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

/**
 * Test package for the milestone domain model.
 * 
 * @author sandornemeth
 * @since 1.0.0
 */
public class MilestoneTest {

	@Test
	public void createdMilestoneIsNotOverDueAndNotComplete() {
		Milestone milestone = new Milestone("UAT", getFutureDate());
		assertFalse(milestone.isOverdue());
		assertFalse(milestone.isCompleted());
		assertFalse(milestone.isDelayed());

	}

	@Test
	public void testOverdueMilestone() {
		Milestone milestone = new Milestone("UAT", getPastDate());
		assertTrue(milestone.isOverdue());
		assertFalse(milestone.isCompleted());
		assertFalse(milestone.isDelayed());
	}

	@Test
	public void testCompletedMilestone() {
		Milestone milestone = new Milestone("UAT", getFutureDate());
		milestone.setCompletitionDate(new Date());
		assertFalse(milestone.isOverdue());
		assertFalse(milestone.isDelayed());
		assertTrue(milestone.isCompleted());
	}
	
	@Test public void lateCompletedMilestoneIsDelayed() {
		Milestone milestone = new Milestone("UAT", getPastDate());
		milestone.setCompletitionDate(new Date());
		assertFalse(milestone.isOverdue());
		assertTrue(milestone.isDelayed());
		assertTrue(milestone.isCompleted());
	}

	private Date getPastDate() {
		return new LocalDate().minusDays(3).toDate();
	}

	private Date getFutureDate() {
		return new LocalDate().plusDays(3).toDate();
	}

}
