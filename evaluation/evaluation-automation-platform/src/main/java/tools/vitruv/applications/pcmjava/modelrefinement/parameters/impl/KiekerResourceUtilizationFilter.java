package tools.vitruv.applications.pcmjava.modelrefinement.parameters.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import kieker.analysis.IProjectContext;
import kieker.analysis.plugin.annotation.InputPort;
import kieker.analysis.plugin.annotation.Plugin;
import kieker.analysis.plugin.filter.AbstractFilterPlugin;
import kieker.common.configuration.Configuration;
import tools.vitruv.applications.pcmjava.modelrefinement.parameters.monitoring.records.ResourceUtilizationRecord;

/**
 * Implements the {@link ResourceUtilizationDataSet} by filtering resource
 * utilization records, read via Kieker.
 * 
 * @author JP
 *
 */
@Plugin(description = "A filter for resource utilization records.")
public final class KiekerResourceUtilizationFilter extends AbstractFilterPlugin implements ResourceUtilizationDataSet {

	/**
	 * The name of the input port for incoming events.
	 */
	public static final String INPUT_PORT_NAME_EVENTS = "inputEvent";

	private final Map<String, SortedMap<Long, Double>> cpuUtilization;
	private final Map<String, Map<String, SortedMap<Long, Double>>> containerUtilization;

	/**
	 * Initializes a new instance of {@link KiekerResourceUtilizationFilter}. Each
	 * Plugin requires a constructor with a Configuration object and a
	 * IProjectContext.
	 * 
	 * @param configuration  The configuration for this component.
	 * @param projectContext The project context for this component. The component
	 *                       will be registered.
	 */
	public KiekerResourceUtilizationFilter(final Configuration configuration, final IProjectContext projectContext) {
		super(configuration, projectContext);
		this.cpuUtilization = new HashMap<>();
		this.containerUtilization = new HashMap<>();
	}

	@Override
	public Configuration getCurrentConfiguration() {
		return new Configuration();
	}

	@Override
	public Set<String> getResourceIds() {
		return this.cpuUtilization.keySet();
	}

	@Override
	public SortedMap<Long, Double> getUtilization(final String resourceId) {
		return this.cpuUtilization.get(resourceId);
	}

	/**
	 * This method is called by kieker for each record of the type specified by
	 * {@link InputPort}.
	 * 
	 * @param record The record of the specified type.
	 */
	@InputPort(name = INPUT_PORT_NAME_EVENTS, description = "Input for cpu utilization records.", eventTypes = {
			ResourceUtilizationRecord.class })
	public final void inputEvent(final ResourceUtilizationRecord record) {
		// to stay compatible
		SortedMap<Long, Double> singleCpuUtilization = this.cpuUtilization.get(record.getResourceId());
		if (singleCpuUtilization == null) {
			singleCpuUtilization = new TreeMap<>();
			this.cpuUtilization.put(record.getResourceId(), singleCpuUtilization);
		}

		// utilization for containers
		if (!containerUtilization.containsKey(record.getContainerId())) {
			containerUtilization.put(record.getContainerId(), new HashMap<>());
		}

		if (!containerUtilization.get(record.getContainerId()).containsKey(record.getResourceId())) {
			containerUtilization.get(record.getContainerId()).put(record.getResourceId(), new TreeMap<>());
		}

		containerUtilization.get(record.getContainerId()).get(record.getResourceId()).put(record.getTimestamp(),
				record.getUtilization());

		singleCpuUtilization.put(record.getTimestamp(), record.getUtilization());
	}

	@Override
	public double timeToSeconds(final long time) {
		double value = time / 1.0e9;
		return value;
	}

	@Override
	public Map<String, SortedMap<Long, Double>> getContainerUtilization(String containerId) {
		return containerUtilization.get(containerId);
	}
}