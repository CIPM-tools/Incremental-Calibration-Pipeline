# The Incremental Calibration Pipeline of CIPM
## Overview
This pipeline is part of the Continuous Integration of Performance Models (CIPM) approach. It is responsible for incremental calibration, updating the usage model and the initial self-validation of the calibrated performance models.
Moreover, this repository includes a source code for [automatic evaluation of the calibtrated performance models](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform)

## Getting Started
The steps to setup the calibration pipeline are found on [wiki](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/wiki/Calibration-Pipeline-Setup).

## Related Publications
The related publication for this repository are the following:
-**[ICSA 2020](http://icsa-conferences.org/2020/index.html)**: Manar Mazkatli, David Monschein, Johannes Grohmann, and Anne Koziolek; [Incremental calibration of architectural performance models with parametric dependencies]( https://sdqweb.ipd.kit.edu/publications/pdfs/mazkatli2020a.pdf).
-**[Qudous 2018](http://2018.qudos-workshop.org/)**: Manar Mazkatli and Anne Koziolek; [Continuous integration of performance model]( https://sdqweb.ipd.kit.edu/publications/pdfs/Mazkatli2018Qudos1.pdf).

More publications on the CIPM approach are found [here.](https://are.ipd.kit.edu/people/manar-mazkatli/publications/) 
## Evaluation of ICSA20 
For evaluating the experements described in [ICSA20 paper](https://sdqweb.ipd.kit.edu/publications/pdfs/mazkatli2020a.pdf), you can follow the instructions of the [evaluation automation platform](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform).
-  The evaluation of the experement on [CoCoMe](https://github.com/cocome-community-case-study/cocome-cloud-jee-platform-migration) case study (BookSale Calibration) can be found [here](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform/src/main/java/paper/evaluation/automation/start/cocome).
- The evaluation of the experements on [TeaStore](https://github.com/CIPM-tools/TeaStore) casestudy (train calibration, trainForRecommender calibration) can be found under [this link.](https://github.com/CIPM-tools/Incremental-Calibration-Pipeline/tree/master/evaluation/evaluation-automation-platform/src/main/java/paper/evaluation/automation/start/teastore)
## Note
A recent version of this pipeline with more features is found [here](https://github.com/CIPM-tools/CIPM-Pipeline).
