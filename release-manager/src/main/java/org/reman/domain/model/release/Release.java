package org.reman.domain.model.release;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * A release is a set of milestones that is common for a set of projects.
 * 
 * A release is defined to be completed when all the milestones contained in met. 
 * 
 * @author sandornemeth
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class Release implements Serializable {

	private Long id;

	private String name;

	private List<Milestone> milestones = Lists.newArrayList();

	protected Release() {
	}

	public Long getId() {
		return id;
	}

	public List<Milestone> getMilestones() {
		return ImmutableList.copyOf(milestones);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class Builder {

		private Release release;

		public Builder(String name) {
			Preconditions.checkArgument(StringUtils.isNotBlank(name));
			release = new Release();
			release.name = name;
		}

		public Builder withMilestone(String name, Date deadLine) {
			release.milestones.add(new Milestone(name, deadLine));
			return this;
		}

		public Release build() {
			return release;
		}

	}
}
