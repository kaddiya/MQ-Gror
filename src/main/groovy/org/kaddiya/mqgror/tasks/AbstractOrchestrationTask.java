package org.kaddiya.mqgror.tasks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.kaddiya.grorchestrator.guice.DeserialiserModule;
import org.kaddiya.grorchestrator.guice.DockerRemoteAPIModule;
import org.kaddiya.grorchestrator.guice.GrorchestratorModule;
import org.kaddiya.grorchestrator.guice.HelperModule;
import org.kaddiya.grorchestrator.guice.factory.DockerContainerActionFactory;
import org.kaddiya.grorchestrator.managers.interfaces.DockerRemoteInterface;
import org.kaddiya.grorchestrator.models.core.SupportedContainerActions;
import org.kaddiya.grorchestrator.models.core.latest.Host;
import org.kaddiya.grorchestrator.models.core.latest.Instance;

/**
 * Created by Webonise on 01/03/17.
 */
public abstract class AbstractOrchestrationTask {

    protected Long taskId;
    protected Instance instance;
    protected Host host;
    protected final SupportedContainerActions action;
    protected DockerRemoteInterface entryPoint;

    private final Injector grorchestratorInjector = Guice.createInjector(new GrorchestratorModule(
            new DeserialiserModule(), new DockerRemoteAPIModule(), new HelperModule()

    ));
    private final DockerContainerActionFactory actionFactory;

    public AbstractOrchestrationTask(Instance instance, Host host, SupportedContainerActions action) {
        this.instance = instance;
        this.host = host;
        this.action = action;
        this.actionFactory = grorchestratorInjector.getInstance(DockerContainerActionFactory.class);
        this.entryPoint = getEntryPointForThisAction();
    }


    private DockerRemoteInterface getEntryPointForThisAction() {
        switch (action) {
            case KILL:
                return this.actionFactory.getContainerKiller(this.instance, this.host);
            case RUN:
                return this.actionFactory.getContainerRunner(this.instance, this.host);
            case PULL:
                return this.actionFactory.getImagePuller(this.instance, this.host);
            default:
                throw new IllegalArgumentException("UnsupportedAction found");
        }

    }

}
