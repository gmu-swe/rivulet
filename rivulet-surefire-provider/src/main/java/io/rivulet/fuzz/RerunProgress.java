package io.rivulet.fuzz;

import io.rivulet.internal.rerun.TestRerunConfiguration;

import java.util.LinkedList;

public class RerunProgress {

	private int numRerunsCompleted;
	private int numRerunsTotal;
	public RerunProgress() {
	}

	public int getNumRerunsCompleted() {
		return numRerunsCompleted;
	}

	public void setNumRerunsCompleted(int numRerunsCompleted) {
		this.numRerunsCompleted = numRerunsCompleted;
	}

	public int getNumRerunsTotal() {
		return numRerunsTotal;
	}

	public void setNumRerunsTotal(int numRerunsTotal) {
		this.numRerunsTotal = numRerunsTotal;
	}

	public int getNumberOfRerunsRemaining(LinkedList<TestRerunConfiguration> rerunConfigurations) {
		return rerunConfigurations == null ? 0 : rerunConfigurations.size();
	}

	public int incrementAndGetNumberOfRerunsCompleted() {
		numRerunsCompleted++;
		return numRerunsCompleted;
	}
}
