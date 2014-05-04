package org.reman.domain.model.release;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.reman.domain.model.project.Project;

/**
 * A milestone is a fixed, named date in the lifecycle of a {@link Project} or a
 * {@link Release}.
 * 
 * @author sandornemeth
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class Milestone implements Serializable, Comparable<Milestone> {

	private Long id;

	private String name;

	private Date deadline;

	private Date completitionDate;

	public Milestone() {
	}

	public Milestone(String name, Date deadline) {
		this.name = name;
		this.deadline = deadline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Long getId() {
		return id;
	}

	public Date getCompletitionDate() {
		return completitionDate;
	}

	public void setCompletitionDate(Date completitionDate) {
		this.completitionDate = completitionDate;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.DEFAULT_STYLE);
	}

	public boolean isOverdue() {
		return !isCompleted() && this.deadline.before(new Date());
	}

	/**
	 * A milestone is considered to be completed, when the
	 * {@link #completitionDate} property is set to a value
	 * 
	 * @return true if the {@link #completitionDate} is set
	 */
	public boolean isCompleted() {
		return null != completitionDate;
	}

	public boolean isDelayed() {
		return isCompleted() && this.deadline.before(completitionDate);
	}

	@Override
	public int compareTo(Milestone o) {
		return this.deadline.compareTo(o.getDeadline());
	}

}
