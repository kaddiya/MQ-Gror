package org.kaddiya.mqgror.guice

import com.google.inject.AbstractModule
import org.kaddiya.grorchestrator.helpers.DockerRegistryAuthFinder
import org.kaddiya.mqgror.helpers.APIDockerRegistryAuthFinderImpl

/**
 * Created by Webonise on 01/03/17.
 */
class MQGrorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DockerRegistryAuthFinder).to(APIDockerRegistryAuthFinderImpl)
    }
}
