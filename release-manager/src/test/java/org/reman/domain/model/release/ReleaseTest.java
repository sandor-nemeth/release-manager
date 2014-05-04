package org.reman.domain.model.release;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

public class ReleaseTest {

	@Test
	public void cannotBuildWithoutName() {
		try {
			new Release.Builder(null);
			new Release.Builder("");
			new Release.Builder(" ");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void canBuildValidRelease() {
		Release release = new Release.Builder("Sample release").withMilestone(
				"RG1", getDate("2014-04-04")).build();
		assertThat(release.getMilestones().size(), is(1));
	}

	/**
	 * Get a {@link Date} from an ISO 8601 date String (yyyy-MM-dd format)
	 * 
	 * @param iso8601DateString
	 *            the date
	 * @return the built date object
	 */
	private Date getDate(String iso8601DateString) {
		return new LocalDate(iso8601DateString).toDate();
	}

}
