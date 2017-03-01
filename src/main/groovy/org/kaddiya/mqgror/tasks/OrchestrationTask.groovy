package org.kaddiya.mqgror.tasks

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.grorchestrator.models.core.SupportedContainerActions
import org.kaddiya.grorchestrator.models.core.latest.Host
import org.kaddiya.grorchestrator.models.core.latest.Instance
import org.kaddiya.grorchestrator.models.remotedocker.responses.AbstractDockerInteractionResponse
import org.kaddiya.mqgror.models.kafka.internal.OrchestrationResult

import java.time.Instant
import java.util.concurrent.Callable

/**
 * Created by Webonise on 22/02/17.
 */
@Slf4j
@CompileStatic
class OrchestrationTask extends AbstractOrchestrationTask implements Callable<OrchestrationResult> {

    public OrchestrationTask(Long taskId, Host host, Instance instance, SupportedContainerActions action) {
        super(instance, host, action)
        this.taskId = taskId;
    }

    @Override
    OrchestrationResult call() throws Exception {
        Instant startTime = Instant.now()
        log.info("Orchestration task id {} with action {} for instance {} on Host {}  started at {}", taskId,action.name(), instance.name, host.ip,startTime)
        AbstractDockerInteractionResponse interactionResponse = entryPoint.doWork()
        Instant endTime = Instant.now()
        log.info("Orchestration task id {} with action {} for instance {} on Host {} with Id {} finished at {}", taskId,action.name(), instance.name, host.ip, endTime)
        return new OrchestrationResult(taskId,interactionResponse != null ,interactionResponse,endTime,startTime)
    }


}
