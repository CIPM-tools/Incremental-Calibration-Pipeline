# CIPM Pipeline Evaluation
This project contains a setup for evaluating the CIPM pipeline. It also contains already collected monitoring data and calibrated models for the evaluation scenarios.

## Requirements
It requires a running installation of this repository: [PCM-Headless](https://github.com/dmonsch/PCM-Headless). This is needed to execute the simulations. The easiest way is to use the corresponding Docker setup ([Setup using Docker](https://github.com/dmonsch/PCM-Headless/wiki/Setup-using-Docker)).

## Execution
The packages [`paper.evaluation.automation.start.cocome`](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform/src/main/java/paper/evaluation/automation/start/cocome) and [`paper.evaluation.automation.start.teastore`](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform/src/main/java/paper/evaluation/automation/start/teastore) contain the main classes to execute the certain evaluation cases. Within the test cases, the simulations are executed, the monitoring data is compared with the simulation results and the corresponding metrics are displayed. In addition, these results are also stored in a JSON file so that they can be analyzed externally.

## Note
The repository does not contain the identical monitoring data and calibrated models that were used in the evaluation of the paper. However, the results are mostly even better and reflect the same insights.
