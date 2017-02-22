package org.kaddiya.mqgror.tasks

import groovy.util.logging.Slf4j
import org.kaddiya.grorchestrator.models.core.latest.Host
import org.kaddiya.grorchestrator.models.core.latest.Instance
import org.kaddiya.mqgror.models.kafka.internal.OrchestrationResult

import java.util.concurrent.Callable

/**
 * Created by Webonise on 22/02/17.
 */
@Slf4j
class OrchestrationTask implements Callable<OrchestrationResult> {
    private final Host host
    private final Instance instance
    private final Long taskId

    public OrchestrationTask(Long taskId){
        this.taskId = taskId
    }
    @Override
    OrchestrationResult call() throws Exception {
        println("running tasks id "+ taskId)
        return new OrchestrationResult(taskId,true)
    }
}
