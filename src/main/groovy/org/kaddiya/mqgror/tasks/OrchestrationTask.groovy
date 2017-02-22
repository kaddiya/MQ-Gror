package org.kaddiya.mqgror.tasks

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.util.logging.Slf4j
import org.kaddiya.grorchestrator.guice.DeserialiserModule
import org.kaddiya.grorchestrator.guice.DockerRemoteAPIModule
import org.kaddiya.grorchestrator.guice.GrorchestratorModule
import org.kaddiya.grorchestrator.guice.HelperModule
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
    private Injector currentInjector

    public OrchestrationTask(Long taskId){
        this.taskId = taskId
        currentInjector = this.initContext()
    }
    @Override
    OrchestrationResult call() throws Exception {
        return new OrchestrationResult(taskId,true)
    }

    private Injector initContext(){
        Injector grorchestratorInjector = Guice.createInjector(new GrorchestratorModule(
                new DeserialiserModule(), new DockerRemoteAPIModule(), new HelperModule()

        ))

    }
}
