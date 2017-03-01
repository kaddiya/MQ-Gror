package org.kaddiya.mqgror.tasks

import com.google.inject.Guice
import com.google.inject.Injector
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.kaddiya.grorchestrator.guice.DeserialiserModule
import org.kaddiya.grorchestrator.guice.DockerRemoteAPIModule
import org.kaddiya.grorchestrator.guice.GrorchestratorModule
import org.kaddiya.grorchestrator.guice.HelperModule
import org.kaddiya.grorchestrator.guice.factory.DockerContainerActionFactory
import org.kaddiya.grorchestrator.guice.factory.InspectContainerFactory
import org.kaddiya.grorchestrator.guice.factory.KillContainerFactory
import org.kaddiya.grorchestrator.guice.factory.PullImageFactory
import org.kaddiya.grorchestrator.guice.factory.RemoveContainerFactory
import org.kaddiya.grorchestrator.guice.factory.RunContainerFactory
import org.kaddiya.grorchestrator.managers.interfaces.DockerRemoteInterface
import org.kaddiya.grorchestrator.managers.interfaces.InspectContainer
import org.kaddiya.grorchestrator.models.HostType
import org.kaddiya.grorchestrator.models.core.DockerHubAuth
import org.kaddiya.grorchestrator.models.core.SupportedContainerActions
import org.kaddiya.grorchestrator.models.core.latest.Host
import org.kaddiya.grorchestrator.models.core.latest.Instance
import org.kaddiya.grorchestrator.models.remotedocker.responses.AbstractDockerInteractionResponse
import org.kaddiya.mqgror.models.kafka.internal.OrchestrationResult

import java.util.concurrent.Callable

/**
 * Created by Webonise on 22/02/17.
 */
@Slf4j
@CompileStatic
class OrchestrationTask extends AbstractOrchestrationTask implements Callable<OrchestrationResult> {

    public OrchestrationTask(Long taskId,Host host,Instance instance,SupportedContainerActions action){
        super(instance,host,action)
        this.taskId = taskId;
    }
    @Override
    OrchestrationResult call() throws Exception {
        AbstractDockerInteractionResponse interactionResponse = entryPoint.doWork()
        return new OrchestrationResult(taskId,true,interactionResponse)
    }


}
